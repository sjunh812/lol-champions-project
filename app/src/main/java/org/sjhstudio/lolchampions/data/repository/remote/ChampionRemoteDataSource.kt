package org.sjhstudio.lolchampions.data.repository.remote

import org.sjhstudio.lolchampions.data.api.ChampionApi
import org.sjhstudio.lolchampions.data.model.ChampionResponse
import org.sjhstudio.lolchampions.domain.model.Champion
import org.sjhstudio.lolchampions.presentation.exception.EmptyBodyException
import org.sjhstudio.lolchampions.presentation.exception.NetworkErrorException

interface ChampionRemoteDataSource {
    suspend fun getChampion(): ChampionResponse<Champion>
}

class ChampionRemoteDataSourceImpl(
    private val championApi: ChampionApi
): ChampionRemoteDataSource {
    override suspend fun getChampion(): ChampionResponse<Champion> {
        val response = championApi.getChampion()
        if(response.isSuccessful) {
            return response.body()
                ?: throw EmptyBodyException("[${response.code()}] : ${response.raw()}")
        } else throw NetworkErrorException("[${response.code()}] : ${response.raw()}")
    }
}