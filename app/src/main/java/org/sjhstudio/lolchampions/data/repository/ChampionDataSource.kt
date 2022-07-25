package org.sjhstudio.lolchampions.data.repository

import org.sjhstudio.lolchampions.data.api.ChampionApi
import org.sjhstudio.lolchampions.data.model.ChampionResponse
import org.sjhstudio.lolchampions.domain.model.Champion
import org.sjhstudio.lolchampions.presentation.exception.EmptyBodyException
import org.sjhstudio.lolchampions.presentation.exception.NetworkErrorException
import javax.inject.Inject

interface ChampionDataSource {
    suspend fun getChampion(): ChampionResponse<Champion>
}

class ChampionDataSourceImpl @Inject constructor(
    private val championApi: ChampionApi
) : ChampionDataSource {
    override suspend fun getChampion(): ChampionResponse<Champion> {
        val response = championApi.getChampion()
        if (response.isSuccessful) {
            return response.body()
                ?: throw EmptyBodyException("[${response.code()}] : ${response.raw()}")
        } else throw NetworkErrorException("[${response.code()}] : ${response.raw()}")
    }
}