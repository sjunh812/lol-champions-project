package org.sjhstudio.lolchampions.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.lolchampions.data.repository.ChampionDataSource
import org.sjhstudio.lolchampions.data.repository.ChampionDataSourceImpl
import org.sjhstudio.lolchampions.data.repository.ChampionInfoDataSource
import org.sjhstudio.lolchampions.data.repository.ChampionInfoDataSourceImpl
import javax.inject.Singleton

/**
 * Bind 방법
 * abstract fun 함수명(Impl): interface
 */
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