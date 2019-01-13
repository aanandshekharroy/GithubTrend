package com.example.theseus.githubtrend20.di.components

import com.example.theseus.githubtrend20.di.modules.MainFragmentModule
import com.example.theseus.githubtrend20.ui.main.MainFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentComponent {
    fun inject(mainFragment: MainFragment)
}