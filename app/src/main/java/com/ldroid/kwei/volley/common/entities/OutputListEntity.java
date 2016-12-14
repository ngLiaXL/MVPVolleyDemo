package com.ldroid.kwei.volley.common.entities;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public  class OutputListEntity<RetData> extends OutputEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8297238643328522856L;

	
	@Expose
	public ArrayList<RetData> data ;
	
	

}