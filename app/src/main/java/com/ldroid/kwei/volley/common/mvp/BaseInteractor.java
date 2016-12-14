package com.ldroid.kwei.volley.common.mvp;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ldroid.kwei.volley.common.entities.InputEntity;
import com.ldroid.kwei.volley.common.network.GsonRequest;
import com.ldroid.kwei.volley.common.network.NetManager;
import com.ldroid.kwei.volley.common.network.ResponseListener;

import java.lang.reflect.Type;


public abstract class BaseInteractor {

    public NetManager mNetManager;

    public BaseInteractor() {
        mNetManager = NetManager.getInstance();
    }

    public <In extends InputEntity, Out> void performRequest(InputEntity requester,
                                                             final ResponseListener<Out> listener, Type type, String tag) {
        GsonRequest<Out> req = new GsonRequest<Out>(requester.getUrl(),
                new Response.Listener<Out>() {
                    @Override
                    public void onResponse(Out response) {
                        listener.onResponse(response);
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onErrorResponse(error);
            }
        }, requester);
        req.setTypeOfT(type);
        mNetManager.addToRequestQueue(req, tag);
    }

}
