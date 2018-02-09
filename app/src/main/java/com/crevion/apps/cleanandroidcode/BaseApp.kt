package com.crevion.apps.cleanandroidcode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.crevion.apps.cleanandroidcode.deps.DaggerDeps
import com.crevion.apps.cleanandroidcode.deps.Deps
import com.crevion.apps.cleanandroidcode.networking.NetworkModule
import java.io.File

/**
 * Created by yusufaw on 2/9/18.
 */

open class BaseApp: AppCompatActivity() {
    lateinit var deps: Deps
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cacheFile = File(cacheDir, "responses")
        deps = DaggerDeps.builder().networkModule(NetworkModule(cacheFile)).build()
    }
}