/**
 * 
 */
package com.ldroid.kwei.volley.common.mvp;

import android.content.Context;

public interface BaseView {

	Context getContext();

	void showLoading(String msg);

	void dismissLoading();

	void onError(String msg);
}
