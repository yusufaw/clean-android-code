package com.crevion.apps.cleanandroidcode.deps;

import com.crevion.apps.cleanandroidcode.home.HomeActivity;
import com.crevion.apps.cleanandroidcode.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yusufaw on 1/27/18.
 */

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(HomeActivity homeActivity);
}
