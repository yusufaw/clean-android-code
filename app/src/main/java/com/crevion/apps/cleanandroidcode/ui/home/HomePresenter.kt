package com.crevion.apps.cleanandroidcode.ui.home

import com.crevion.apps.cleanandroidcode.models.CityListResponse
import com.crevion.apps.cleanandroidcode.networking.NetworkError
import com.crevion.apps.cleanandroidcode.networking.Service
import rx.subscriptions.CompositeSubscription

/**
 * Created by yusufaw on 2/9/18.
 */

class HomePresenter(private val service: Service, private val view: HomeView) {
    private val subscriptions: CompositeSubscription = CompositeSubscription()

    fun getCityList() {
        view.showWait()

        val subscription = service.getCityList(object : Service.GetCityListCallback {
            override fun onSuccess(cityListResponse: CityListResponse) {
                view.removeWait()
                view.geCityListSuccess(cityListResponse)
            }

            override fun onError(networkError: NetworkError) {
                view.removeWait()
                view.onFailure(networkError.appErrorMessage)
            }
        })
        this.subscriptions.add(subscription)
    }

    fun onStop() {
        subscriptions.unsubscribe()
    }
}