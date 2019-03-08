package com.dscutama.readapi.features.main;

import com.dscutama.readapi.data.model.response.Record;

import java.util.List;

public interface MainMvpView {

    void showData(List<Record> list);

}
