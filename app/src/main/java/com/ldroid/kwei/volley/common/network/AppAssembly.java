package com.ldroid.kwei.volley.common.network;

import android.content.res.Resources;

import com.ldroid.kwei.volley.MainApp;
import com.ldroid.kwei.volley.R;


public class AppAssembly {

    private AppAssembly() {
    }

    public static Resources getResources() {
        return MainApp.getContext().getResources();
    }

    public static boolean isDebug() {
        return false;
    }

    public static String getUrl() {
        if (isDebug()) {
        }
        return getResources().getString(R.string.base_url);
    }

}
