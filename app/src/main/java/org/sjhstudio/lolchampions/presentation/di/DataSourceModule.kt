package org.sjhstudio.lolchampions.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.lolchampions.data.repository.remote.ChampionRemoteDataSource
import org.sjhstudio.lolchampions.data.repository.remote.ChampionRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsChampionRemoteDataSource(championRemoteDataSourceImpl: ChampionRemoteDataSourceImpl): ChampionRemoteDataSource
}