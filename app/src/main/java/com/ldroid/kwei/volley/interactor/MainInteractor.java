package com.ldroid.kwei.volley.interactor;

import com.google.gson.reflect.TypeToken;
import com.ldroid.kwei.volley.common.entities.OutputListEntity;
import com.ldroid.kwei.volley.common.mvp.BaseInteractor;
import com.ldroid.kwei.volley.common.network.ActionConstants;
import com.ldroid.kwei.volley.common.network.ResponseListener;
import com.ldroid.kwei.volley.entities.in.ExpressInEntity;
import com.ldroid.kwei.volley.entities.out.ExpressOutEntity;

public class MainInteractor extends BaseInteractor {

    private static final String TAG = "MainInteractor";

    public void reqExpress(ExpressInEntity in,
                              ResponseListener<OutputListEntity<ExpressOutEntity>> listener) {
        in.setMethod(ActionConstants.API_EXPRESS);
        performRequest(in, listener, new TypeToken<OutputListEntity<ExpressOutEntity>>() {
        }.getType(), TAG);
    }

}