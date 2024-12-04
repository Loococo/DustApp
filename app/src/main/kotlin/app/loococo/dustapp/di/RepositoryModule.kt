package app.loococo.dustapp.di

import app.loococo.data.repository.DustRepositoryImpl
import app.loococo.domain.repository.DustRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideDustRepository(repository: DustRepositoryImpl): DustRepository
}