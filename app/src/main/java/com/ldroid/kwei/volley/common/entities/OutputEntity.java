package com.ldroid.kwei.volley.common.entities;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class OutputEntity<ReList, Info> extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = -8297238643328522856L;

    @Expose
    public String code;
    @Expose
    public String message;
    @Expose
    public ArrayList<ReList> reList;
    @Expose
    public Info info;

    public String getErrorMsg() {
        return TextUtils.isEmpty(message) ? "网络或服务器异常" : message;
    }

}