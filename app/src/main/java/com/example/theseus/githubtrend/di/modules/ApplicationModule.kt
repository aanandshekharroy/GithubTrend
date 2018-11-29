package com.example.theseus.githubtrend.di.modules

import android.app.Application
import com.example.theseus.githubtrend.data.DataManager
import com.example.theseus.githubtrend.data.IDataManager
import com.example.theseus.githubtrend.data.api.APIManager
import com.example.theseus.githubtrend.data.api.IAPIManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val context: Application) {
    @Provides
    @Singleton
    fun applicationContext(): Application = context

    @Provides
    @Singleton
    fun providesDataManager(dataManager: DataManager) = dataManager as IDataManager

    @Provides
    @Singleton
    fun providesAPIManager(apiManager: APIManager) = apiManager as IAPIManager
}