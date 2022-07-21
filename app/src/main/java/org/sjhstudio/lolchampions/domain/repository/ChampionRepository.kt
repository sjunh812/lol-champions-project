package org.sjhstudio.lolchampions.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sjhstudio.lolchampions.domain.model.Champion
import org.sjhstudio.lolchampions.presentation.base.UiState

interface ChampionRepository {
    fun getChampion(): Flow<UiState<List<Champion>>>
}