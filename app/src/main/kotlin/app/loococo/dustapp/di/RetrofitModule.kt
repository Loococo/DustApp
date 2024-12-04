package app.loococo.dustapp.di

import app.loococo.dustapp.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .setPrettyPrinting()
        .setLenient()
        .serializeNulls()
        .create()

    @Provides
    fun provideBaseOkHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            addInterceptor { chain ->
                val originalRequest = chain.request()
                val originalUrl = originalRequest.url

                val urlWithKey = originalUrl.newBuilder()
                    .addQueryParameter("serviceKey", BuildConfig.SERVICE_KEY)
                    .build()

                val newRequest = originalRequest.newBuilder()
                    .url(urlWithKey)
                    .build()

                chain.proceed(newRequest)
            }
            writeTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            connectTimeout(30, TimeUnit.SECONDS)
        }
    }

    @Provides
    fun provideOtherNetworkClient(
        clientBuilder: OkHttpClient.Builder
    ): OkHttpClient = clientBuilder.build()


    @Provides
    fun provideOtherRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

}
