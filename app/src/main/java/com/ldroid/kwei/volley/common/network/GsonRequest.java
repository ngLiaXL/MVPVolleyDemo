package com.ldroid.kwei.volley.common.network;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;
import com.ldroid.kwei.volley.common.entities.InputEntity;
import com.ldroid.kwei.volley.common.utils.JsonUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {

	private Response.Listener<T> mListener;
	private Type mTypeOfT;
	private InputEntity mIn;

	/**
	 * 
	 * @param method
	 *            {@link Method}
	 * @param url
	 * @param listener
	 * @param errorListener
	 */
	public GsonRequest(int method, String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
		super(method, url, errorListener);
		mListener = listener;
	}

	public GsonRequest(String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
		this(Method.POST, url, listener, errorListener);
	}

	public <In extends InputEntity> GsonRequest(String url, Response.Listener<T> listener,
												Response.ErrorListener errorListener, In in) {
		this(Method.POST, url, listener, errorListener);
		this.mIn = in;
	}

	public void setTypeOfT(Type typeOfT) {
		this.mTypeOfT = typeOfT;
	}

	@Override
	public Map<String, String> getParams() throws AuthFailureError {
		return this.mIn.getParams();
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			T parsedGSON = JsonUtils.fromJson(jsonString, mTypeOfT);
			return Response.success(parsedGSON, HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException je) {
			return Response.error(new ParseError(je));
		}
	}

	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		HashMap<String, String> headers = new HashMap<String, String>();
		//headers.put("Accept-Encoding", "gzip");
		return headers;
	}

}