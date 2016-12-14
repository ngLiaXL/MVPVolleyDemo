package com.ldroid.kwei.volley.common.network;


import com.android.volley.Request;
import com.android.volley.RequestQueue;

public class NetManager {

    public static final String TAG = "NetManager";

    private NetRequestQueue mRequestQueue;

    private static class NetManagerHolder {
        private static NetManager sEngine = new NetManager();
    }

    public static NetManager getInstance() {
        return NetManagerHolder.sEngine;
    }

    private NetManager() {
        mRequestQueue = NetRequestQueue.getInstance();

    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        if (mRequestQueue != null) {
            mRequestQueue.addToRequestQueue(req, tag);
        }
    }

    public <T> void addToRequestQueue(Request<T> req) {
        if (mRequestQueue != null) {
            mRequestQueue.addToRequestQueue(req);
        }

    }

    public void clearCache(Runnable r) {
        if (mRequestQueue != null) {
            mRequestQueue.clearCache(r);
        }
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue.getRequestQueue();
    }
}
