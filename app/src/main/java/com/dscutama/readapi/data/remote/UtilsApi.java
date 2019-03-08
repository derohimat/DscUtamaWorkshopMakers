package com.dscutama.readapi.data.remote;

import android.content.Context;

public class UtilsApi {

    public static ApiService getApiService(Context context){
        return RetrofitClient.getClient("https://script.google.com/macros/s/", context)
                .create(ApiService.class);
    }

}
