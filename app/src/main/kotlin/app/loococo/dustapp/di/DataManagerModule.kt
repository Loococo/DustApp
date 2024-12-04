package app.loococo.dustapp.di

import app.loococo.data.remote.api.DustApi
import app.loococo.data.remote.manager.DustDataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDatasourceModule {
    @Provides
    @Singleton
    fun provideDustDataManager(api: DustApi): DustDataManager = DustDataManager(api)
}