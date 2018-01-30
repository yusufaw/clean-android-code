package com.crevion.apps.cleanandroidcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.crevion.apps.cleanandroidcode.deps.DaggerDeps;
import com.crevion.apps.cleanandroidcode.deps.Deps;
import com.crevion.apps.cleanandroidcode.networking.NetworkModule;

import java.io.File;

/**
 * Created by yusufaw on 1/30/18.
 */

public class BaseApp extends AppCompatActivity{
    Deps deps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Deps getDeps() {
        return deps;
    }
}
