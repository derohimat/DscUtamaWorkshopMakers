package com.dscutama.readapi.features.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.dscutama.readapi.data.remote.ApiService;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter {

    private final Context context;
    private final ApiService apiService;
    private final MainMvpView mainMvpView;

    public MainPresenter(Context context, ApiService apiService, MainMvpView mainMvpView) {
        this.context = context;
        this.apiService = apiService;
        this.mainMvpView = mainMvpView;
    }

    @SuppressLint("CheckResult")
    void getUsers(){
        apiService
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> mainMvpView.showData(data.getRecords()),
                        throwable -> Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
