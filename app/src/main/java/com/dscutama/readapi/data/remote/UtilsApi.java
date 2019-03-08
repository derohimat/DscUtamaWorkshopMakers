package com.dscutama.readapi.data.remote;

import android.content.Context;

public class UtilsApi {

    public static ApiService getApiService(Context context){
        return RetrofitClient.getClient("https://script.googleusercontent.com/macros/", context)
                .create(ApiService.class);
    }

}
