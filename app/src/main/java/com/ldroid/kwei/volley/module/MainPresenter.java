package com.ldroid.kwei.volley.module;


import com.android.volley.VolleyError;
import com.ldroid.kwei.volley.common.entities.OutputListEntity;
import com.ldroid.kwei.volley.common.network.ResponseListener;
import com.ldroid.kwei.volley.entities.in.ExpressInEntity;
import com.ldroid.kwei.volley.entities.out.ExpressOutEntity;
import com.ldroid.kwei.volley.interactor.MainInteractor;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainInteractor mInteractor;

    /**
     *
     */
    public MainPresenter(MainContract.View view) {
        this.mView = view;
        mInteractor = new MainInteractor();
    }


    @Override
    public void reqExpress(String type, String postid) {
        ExpressInEntity in = new ExpressInEntity(type,postid);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }

        mView.showLoading(null);
        mInteractor.reqExpress(in, new ResponseListener<OutputListEntity<ExpressOutEntity>>() {

            @Override
            public void onResponse(OutputListEntity<ExpressOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError("网络或服务器异常");
                } else {
                    mView.onRespExpress(response.data);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                mView.dismissLoading();
                mView.onError(error.toString());
            }

        });
    }

}
