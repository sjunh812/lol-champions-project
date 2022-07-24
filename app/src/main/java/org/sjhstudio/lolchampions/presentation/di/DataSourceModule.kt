package org.sjhstudio.lolchampions.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.lolchampions.data.repository.remote.ChampionDataSource
import org.sjhstudio.lolchampions.data.repository.remote.ChampionDataSourceImpl
import org.sjhstudio.lolchampions.data.repository.remote.ChampionInfoDataSource
import org.sjhstudio.lolchampions.data.repository.remote.ChampionInfoDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsChampionDataSource(championDataSourceImpl: ChampionDataSourceImpl): ChampionDataSource

    @Singleton
    @Binds
    abstract fun binsChampionInfoDataSource(championInfoDataSourceImpl: ChampionInfoDataSourceImpl): ChampionInfoDataSource
}