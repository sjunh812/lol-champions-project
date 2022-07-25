package org.sjhstudio.lolchampions.data.api

import org.sjhstudio.lolchampions.data.model.ChampionInfo
import org.sjhstudio.lolchampions.data.model.ChampionResponse
import org.sjhstudio.lolchampions.domain.model.Champion
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChampionApi {
    @GET("data/ko_KR/champion.json")
    suspend fun getChampion(): Response<ChampionResponse<Champion>>

    @GET("data/ko_KR/champion/{id}.json")
    suspend fun getChampionInfo(@Path("id") id: String): Response<ChampionResponse<ChampionInfo>>
}