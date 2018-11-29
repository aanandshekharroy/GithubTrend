package com.example.theseus.githubtrend

import android.app.Application
import com.example.theseus.githubtrend.di.components.ApplicationComponent
import com.example.theseus.githubtrend.di.components.DaggerApplicationComponent
import com.example.theseus.githubtrend.di.modules.ApplicationModule
import timber.log.Timber

class GithubTrendApplication: Application() {
    lateinit var mApplicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        mApplicationComponent.inject(this)
    }
}