/**
 *
 */
package com.ldroid.kwei.volley.common.network;


import com.android.volley.VolleyError;

public interface ResponseListener<T> {

    void onResponse(T response);

    void onErrorResponse(VolleyError error);

}
