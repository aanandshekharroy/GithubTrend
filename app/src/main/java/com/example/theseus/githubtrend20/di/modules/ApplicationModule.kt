package com.example.theseus.githubtrend20.di.modules

import com.example.theseus.githubtrend20.data.DataManager
import com.example.theseus.githubtrend20.data.DataManagerImp
import com.example.theseus.githubtrend20.data.api.APIManager
import com.example.theseus.githubtrend20.data.api.APIManagerImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    @Singleton
    fun provideDataManager(dataManagerImp: DataManagerImp) = dataManagerImp as DataManager

    @Provides
    @Singleton
    fun provideAPIManager(apiManagerImp: APIManagerImp) = apiManagerImp as APIManager
}