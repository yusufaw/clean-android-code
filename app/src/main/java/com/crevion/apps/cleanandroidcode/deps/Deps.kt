package com.crevion.apps.cleanandroidcode.deps

import com.crevion.apps.cleanandroidcode.ui.home.HomeActivity
import com.crevion.apps.cleanandroidcode.networking.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by yusufaw on 2/9/18.
 */

@Singleton
@Component(modules = [NetworkModule::class])
interface Deps {
    fun inject(homeActivity: HomeActivity)
}