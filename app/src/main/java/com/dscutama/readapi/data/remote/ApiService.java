package com.dscutama.readapi.data.remote;

import com.dscutama.readapi.data.model.response.ApiResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("echo")
    Flowable<ApiResponse> getData(@Query("user_content_key") String key);
}
