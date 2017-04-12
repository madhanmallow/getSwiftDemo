package com.mallow.getswiftdemo.datamodel;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.mallow.getswiftdemo.GSApp;
import com.mallow.getswiftdemo.http.GSHttpClientResponse;
import com.mallow.getswiftdemo.http.GSHttpClientResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * Company: Mallow Technology
 * Created by Manikandan on 26/08/16.
 */
public class GSDataModelController {

    private final Gson m_gson;
    private final String TAG = "CXDataModelController";

    public GSDataModelController() {
        m_gson = new Gson();
    }

    /**
     * Method to list the controllex device
     *
     * @param context The context
     * @param handler The response handler
     */
    public void callAddJob(Context context, String eDestination_Address, String eDescription, String eContactName, String eContactPhone, String eEmailID, final GSDataModelResponseHandler handler) {
        try {
            GSApp.getInstance().getHttpClient().callAddJob(context, eDestination_Address, eDescription, eContactName, eContactPhone, eEmailID, new GSHttpClientResponseHandler() {
                @Override
                public void onSuccess(Header[] headers, GSHttpClientResponse response) {
                    JSONObject jsonObject = response.getJSONObject();
                    if (handler != null) {
                        handler.onSuccess(response);
                    }
                }

                @Override
                public void onFailure(GSHttpClientResponse response) {
                    Log.d(TAG, "Error code: " + response.getStatusCode());
                    if (handler != null) {
                        handler.onFailure(response);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the request
     *
     * @param context The context
     * @param handler The response handler
     */
    public void getJobDetail(Context context, final GSDataModelResponseHandler handler) {
        try {
            GSApp.getInstance().getHttpClient().getJobDetail(context, new GSHttpClientResponseHandler() {
                @Override
                public void onSuccess(Header[] headers, GSHttpClientResponse response) {
                    JSONObject jsonObject = response.getJSONObject();

                    //added null condition check for jsonObject
                    if (jsonObject != null) {
                        if (handler != null) {
                            handler.onSuccess(response);
                        }
                    } else {
                        //condition to handle the failure
                        if (handler != null) {
                            handler.onFailure(response);
                        }
                    }
                }

                @Override
                public void onFailure(GSHttpClientResponse response) {
                    Log.d(TAG, "Error code: " + response.getStatusCode());
                    if (handler != null) {
                        handler.onFailure(response);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the request
     *
     * @param context The context
     * @param handler The response handler
     */
    public void getTrackOrder(Context context, String mTrackOrderID, final GSDataModelResponseHandler handler) {
        try {
            GSApp.getInstance().getHttpClient().getTrackOrder(context, mTrackOrderID, new GSHttpClientResponseHandler() {
                @Override
                public void onSuccess(Header[] headers, GSHttpClientResponse response) {
                    JSONObject jsonObject = response.getJSONObject();

                    //added null condition check for jsonObject
                    if (jsonObject != null) {
                        if (handler != null) {
                            handler.onSuccess(response);
                        }
                    } else {
                        //condition to handle the failure
                        if (handler != null) {
                            handler.onFailure(response);
                        }
                    }
                }

                @Override
                public void onFailure(GSHttpClientResponse response) {
                    Log.d(TAG, "Error code: " + response.getStatusCode());
                    if (handler != null) {
                        handler.onFailure(response);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
