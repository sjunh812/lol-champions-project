package org.sjhstudio.lolchampions.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.sjhstudio.lolchampions.domain.model.Champion
import org.sjhstudio.lolchampions.domain.repository.ChampionRepository
import org.sjhstudio.lolchampions.presentation.base.UiState
import javax.inject.Inject

class GetChampionUseCase @Inject constructor(private val championRepository: ChampionRepository) {
    fun invoke(
        scope: CoroutineScope,
        started: SharingStarted,
        initialValue: UiState<List<Champion>>
    ): StateFlow<UiState<List<Champion>>> {
        return championRepository.getChampion().stateIn(scope, started, initialValue)
    }
}