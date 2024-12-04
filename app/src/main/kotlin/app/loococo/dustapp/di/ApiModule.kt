package app.loococo.dustapp.di

import app.loococo.data.remote.api.DustApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun providerDustApi(retrofit: Retrofit): DustApi = retrofit.create(DustApi::class.java)

}
