package com.crevion.apps.cleanandroidcode.home;

import com.crevion.apps.cleanandroidcode.models.CityListResponse;

/**
 * Created by yusufaw on 1/27/18.
 */

public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void geCityListSuccess(CityListResponse cityListResponse);
}
