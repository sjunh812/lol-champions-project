package org.sjhstudio.lolchampions.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.sjhstudio.lolchampions.domain.repository.ChampionInfoRepository
import org.sjhstudio.lolchampions.domain.repository.ChampionRepository
import org.sjhstudio.lolchampions.domain.usecase.GetChampionInfoUseCase
import org.sjhstudio.lolchampions.domain.usecase.GetChampionUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @ViewModelScoped
    @Provides
    fun getChampionUseCase(championRepository: ChampionRepository): GetChampionUseCase =
        GetChampionUseCase(championRepository)

    @ViewModelScoped
    @Provides
    fun getChampionInfoUseCase(championInfoRepository: ChampionInfoRepository): GetChampionInfoUseCase =
        GetChampionInfoUseCase(championInfoRepository)
}