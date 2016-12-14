package com.ldroid.kwei.volley.module;


import com.ldroid.kwei.volley.common.mvp.BasePresenter;
import com.ldroid.kwei.volley.common.mvp.BaseView;
import com.ldroid.kwei.volley.entities.out.ExpressOutEntity;

import java.util.ArrayList;

public interface MainContract {

	interface View extends BaseView {
		void onRespExpress(ArrayList<ExpressOutEntity> response);
	}

	interface Presenter extends BasePresenter {
		void reqExpress(String type,String postid);
	}
}
