package org.sjhstudio.lolchampions.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sjhstudio.lolchampions.data.model.ChampionInfo
import org.sjhstudio.lolchampions.presentation.base.UiState

interface ChampionInfoRepository {
    fun getChampionInfo(id: String): Flow<UiState<ChampionInfo>>
}