package org.sjhstudio.lolchampions.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.sjhstudio.lolchampions.data.model.ChampionInfo
import org.sjhstudio.lolchampions.domain.repository.ChampionInfoRepository
import org.sjhstudio.lolchampions.presentation.base.UiState
import javax.inject.Inject

class ChampionInfoRepositoryImpl @Inject constructor(
    private val championInfoDataSource: ChampionInfoDataSource
) : ChampionInfoRepository {
    override fun getChampionInfo(id: String): Flow<UiState<ChampionInfo>> =
        flow<UiState<ChampionInfo>> {
            println("xxx getChampionInfo")
            val championInfo = championInfoDataSource.getChampionInfo(id).getList()[0]
            println("xxx getChampionInfo2")
            emit(UiState.Success(championInfo))
        }.buffer().catch {
            emit(UiState.Error(it))
        }
}