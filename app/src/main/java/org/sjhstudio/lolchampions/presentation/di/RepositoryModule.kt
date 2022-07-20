package org.sjhstudio.lolchampions.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.lolchampions.data.repository.ChampionRepositoryImpl
import org.sjhstudio.lolchampions.domain.repository.ChampionRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindChampionRepository(championRepositoryImpl: ChampionRepositoryImpl): ChampionRepository
}