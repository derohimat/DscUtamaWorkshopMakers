package com.dscutama.readapi.data.remote;

import com.dscutama.readapi.data.model.response.ApiResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("AKfycbwbDoptVa-rhpVvnLNGpziq3Ey4-SfjEj152elQ6oUUsYT5BL1s/exec?action=read")
    Flowable<ApiResponse> getData();
}
