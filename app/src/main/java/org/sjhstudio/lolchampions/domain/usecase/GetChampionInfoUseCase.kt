package org.sjhstudio.lolchampions.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.sjhstudio.lolchampions.data.model.ChampionInfo
import org.sjhstudio.lolchampions.domain.repository.ChampionInfoRepository
import org.sjhstudio.lolchampions.presentation.base.UiState
import javax.inject.Inject

class GetChampionInfoUseCase @Inject constructor(private val championInfoRepository: ChampionInfoRepository) {
    fun execute(
        id: String,
        scope: CoroutineScope,
        started: SharingStarted,
        initValue: UiState<ChampionInfo>
    ): StateFlow<UiState<ChampionInfo>> =
        championInfoRepository.getChampionInfo(id).stateIn(scope, started, initValue)
}