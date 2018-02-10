package com.crevion.apps.cleanandroidcode.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yusufaw on 2/10/18.
 */

@Module
class PreferencesModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)

    @Provides
    @Singleton
    fun providesPreferencesUtil(): PreferencesUtil = PreferencesUtil(provideSharedPreferences())
}