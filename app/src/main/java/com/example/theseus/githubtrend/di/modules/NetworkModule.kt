package com.example.theseus.githubtrend.di.modules

import com.example.theseus.githubtrend.data.api.APIService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesClient(interceptor: HttpLoggingInterceptor): OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(interceptor)

    @Provides
    @Singleton
    fun providesHTTPInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun retrofitInstance(client: OkHttpClient.Builder) = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    @Provides
    @Singleton
    fun retrofitApiService(retrofit: Retrofit) =
            retrofit.create(APIService::class.java)

}