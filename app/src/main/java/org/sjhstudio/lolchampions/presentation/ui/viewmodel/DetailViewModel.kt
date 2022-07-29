package org.sjhstudio.lolchampions.presentation.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import org.sjhstudio.lolchampions.data.model.ChampionInfo
import org.sjhstudio.lolchampions.domain.usecase.GetChampionInfoUseCase
import org.sjhstudio.lolchampions.presentation.base.UiState
import org.sjhstudio.lolchampions.presentation.base.successOrNull
import org.sjhstudio.lolchampions.presentation.ui.view.DetailActivity
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getChampionInfoUseCase: GetChampionInfoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val championId: String = savedStateHandle.get(DetailActivity.CHAMPION_ID_KEY)
        ?: throw IllegalStateException("Champion id 가 없습니다.")

    val championImageUrl: String = savedStateHandle.get(DetailActivity.CHAMPION_IMAGE_URL)
        ?: throw IllegalStateException("Champion image url 이 없습니다.")

    val uiState: StateFlow<UiState<ChampionInfo>> = getChampionInfoUseCase.execute(
        id = championId,
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initValue = UiState.Loading
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    val championInfo: StateFlow<ChampionInfo> = uiState.mapLatest { uiState ->
        uiState.successOrNull() ?: ChampionInfo.EMPTY
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = ChampionInfo.EMPTY
    )
}