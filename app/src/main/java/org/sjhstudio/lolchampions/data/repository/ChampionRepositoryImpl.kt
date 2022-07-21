package org.sjhstudio.lolchampions.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.sjhstudio.lolchampions.data.repository.remote.ChampionRemoteDataSource
import org.sjhstudio.lolchampions.domain.model.Champion
import org.sjhstudio.lolchampions.domain.repository.ChampionRepository
import org.sjhstudio.lolchampions.presentation.base.UiState
import javax.inject.Inject

class ChampionRepositoryImpl @Inject constructor(
    private val championRemoteDataSource: ChampionRemoteDataSource
) : ChampionRepository {
    override fun getChampion(): Flow<UiState<List<Champion>>> =
        flow<UiState<List<Champion>>> {
            val list = championRemoteDataSource.getChampion().getList()
            emit(UiState.Success(list))
        }.catch {
            emit(UiState.Error(it))
        }
}