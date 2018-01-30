package com.crevion.apps.cleanandroidcode.networking;

import com.crevion.apps.cleanandroidcode.models.CityListResponse;


import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yusufaw on 1/27/18.
 */

public interface NetworkService {
    @GET("v1/city")
    Observable<CityListResponse> getCityList();
}
