package com.crevion.apps.cleanandroidcode.ui.home

import com.crevion.apps.cleanandroidcode.models.CityListResponse

/**
 * Created by yusufaw on 2/9/18.
 */

interface HomeView {
    fun showWait()

    fun removeWait()

    fun onFailure(appErrorMessage: String)

    fun geCityListSuccess(cityListResponse: CityListResponse)
}