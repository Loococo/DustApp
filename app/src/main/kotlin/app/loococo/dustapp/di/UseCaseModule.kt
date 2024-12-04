package app.loococo.dustapp.di

import app.loococo.domain.repository.DustRepository
import app.loococo.domain.usecase.DustUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideDustUseCase(repository: DustRepository): DustUseCase = DustUseCase(repository)
}
