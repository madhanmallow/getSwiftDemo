package com.mallow.getswiftdemo.http;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by bhagya on 23/11/15.
 */
@SuppressWarnings("deprecation") class GSJsonHttpResponseHandler extends JsonHttpResponseHandler {
    private final String TAG = this.getClass().getSimpleName();
    private GSHttpClientResponseHandler m_handler;
    private String m_url;

    /**
     * Method to set the url
     *
     * @param url The url to set
     */
    public void setUrl(String url) {
        m_url = url;
    }

    /**
     * Method to set the handler
     *
     * @param handler The handler
     */
    public void setHandler(GSHttpClientResponseHandler handler) {
        m_handler = handler;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "onStart() - " + m_url);
    }

    @Override
    public void onFinish() {
        super.onFinish();
        Log.v(TAG, "onFinish() - " + m_url);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        try {
            if (m_handler != null) {
                GSHttpClientResponse clientResponse = new GSHttpClientResponse();
                clientResponse.setResponse(response);
                clientResponse.setStatusCode(statusCode);

                m_handler.onSuccess(headers, clientResponse);
            }

            Log.v(TAG, "onSuccess(JSONArray) - " + m_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        try {
            if (m_handler != null) {
                GSHttpClientResponse clientResponse = new GSHttpClientResponse();
                clientResponse.setResponse(response);
                clientResponse.setStatusCode(statusCode);

                m_handler.onSuccess(headers, clientResponse);
            }

            Log.v(TAG, "onSuccess(JSONObject) - " + m_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        try {
            if (m_handler != null) {
                GSHttpClientResponse clientResponse = new GSHttpClientResponse();
                clientResponse.setResponse(responseString);
                clientResponse.setStatusCode(statusCode);

                m_handler.onSuccess(headers, clientResponse);
            }

            Log.v(TAG, "onSuccess(String) - " + m_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject response) {
        try {
            if (m_handler != null) {
                GSHttpClientResponse clientResponse = new GSHttpClientResponse();
                clientResponse.setResponse(response);
                clientResponse.setStatusCode(statusCode);
                clientResponse.setError(throwable.getMessage());

                m_handler.onFailure(clientResponse);
            }

            Log.v(TAG, "onFailure(JSONObject) - " + m_url + " " + throwable.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray response) {
        try {
            if (m_handler != null) {
                GSHttpClientResponse clientResponse = new GSHttpClientResponse();
                clientResponse.setResponse(response);
                clientResponse.setStatusCode(statusCode);
                clientResponse.setError(throwable.getMessage());

                m_handler.onFailure(clientResponse);
            }

            Log.v(TAG, "onFailure(JSONArray) - " + m_url + " " + throwable.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        try {
            if (m_handler != null) {
                GSHttpClientResponse clientResponse = new GSHttpClientResponse();
                clientResponse.setResponse(responseString);
                clientResponse.setStatusCode(statusCode);
                clientResponse.setError(throwable.getMessage());

                m_handler.onFailure(clientResponse);
            }

            Log.v(TAG, "onFailure(String) - " + m_url + " " + throwable.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
