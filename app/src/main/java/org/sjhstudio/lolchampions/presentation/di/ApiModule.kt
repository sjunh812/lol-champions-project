package org.sjhstudio.lolchampions.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.lolchampions.data.api.ChampionApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun getChampionApi(retrofit: Retrofit): ChampionApi = retrofit.create(ChampionApi::class.java)
}