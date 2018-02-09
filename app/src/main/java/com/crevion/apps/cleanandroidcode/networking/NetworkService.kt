package com.crevion.apps.cleanandroidcode.networking

import com.crevion.apps.cleanandroidcode.models.CityListResponse
import retrofit2.http.GET
import rx.Observable

/**
 * Created by yusufaw on 2/9/18.
 */

interface NetworkService {
    @GET("v1/cities")
    fun getCityList(): Observable<CityListResponse>
}