package com.crevion.apps.cleanandroidcode.networking

import com.crevion.apps.cleanandroidcode.models.CityListResponse
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by yusufaw on 2/9/18.
 */

class Service(private val networkService: NetworkService) {

    fun getCityList(callback: GetCityListCallback): Subscription {
        return networkService.getCityList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext { throwable -> Observable.error(throwable) }
                .subscribe(object : Subscriber<CityListResponse>() {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        callback.onError(NetworkError(e))
                    }

                    override fun onNext(cityListResponse: CityListResponse) {
                        callback.onSuccess(cityListResponse)
                    }
                })
    }

    interface GetCityListCallback {
        fun onSuccess(cityListResponse: CityListResponse)

        fun onError(networkError: NetworkError)
    }
}