package com.ldroid.kwei.volley.ui.entities;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class ProvinceListEntity {

    @Expose public ArrayList<Province> provinces ;


    public class Province{
        @Expose public String province;
        @Expose public ArrayList<City> citys ;
    }

    public class City{
        @Expose public String cityName;
        @Expose public String cityCode;

    }

}
