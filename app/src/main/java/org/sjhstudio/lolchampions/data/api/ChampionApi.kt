package org.sjhstudio.lolchampions.data.api

import org.sjhstudio.lolchampions.data.model.ChampionResponse
import org.sjhstudio.lolchampions.domain.model.Champion
import retrofit2.Response
import retrofit2.http.GET

interface ChampionApi {
    @GET("data/ko_KR/champion.json")
    suspend fun getChampion(): Response<ChampionResponse<Champion>>
}