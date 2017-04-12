package com.mallow.getswiftdemo.http;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestHandle;
import com.mallow.getswiftdemo.GSAppConstants;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by bhagya on 23/11/15.
 */
@SuppressWarnings("deprecation")
public class GSHttpClient {

    private static final String TAG = "CXHttpClient";

    //Http headers
    private static final String CONTENT_TYPE = "Content-type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String ACCEPT = "Accept";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private final AsyncHttpClient m_asyncHttpClient;

    public GSHttpClient(Context context) {

        // Configure http client
        m_asyncHttpClient = new AsyncHttpClient();

        // Set default headers
        //Both content type and accept value are same. so used same variable.
        m_asyncHttpClient.addHeader(ACCEPT, CONTENT_TYPE_VALUE);
        m_asyncHttpClient.addHeader(CONTENT_TYPE, CONTENT_TYPE_VALUE);
        m_asyncHttpClient.setMaxRetriesAndTimeout(3, 1500);
    }

    /**
     * Method to get the response
     *
     * @param context The context
     * @param url     The url
     * @param handler The handler to handle both scenarios
     * @return Return the handler
     */
    private RequestHandle get(Context context, String url, GSHttpClientResponseHandler handler) {
        GSJsonHttpResponseHandler jsonHandler = new GSJsonHttpResponseHandler();
        jsonHandler.setUrl(url);
        jsonHandler.setHandler(handler);
        return m_asyncHttpClient.get(context, url, jsonHandler);

    }

    /**
     * Method to delete
     *
     * @param context The context
     * @param url     The url
     * @param handler The handler to handle both scenarios
     * @return Return the handler
     */
    private RequestHandle delete(Context context, String url, GSHttpClientResponseHandler handler) {
        GSJsonHttpResponseHandler jsonHandler = new GSJsonHttpResponseHandler();
        jsonHandler.setUrl(url);
        jsonHandler.setHandler(handler);
        return m_asyncHttpClient.delete(context, url, jsonHandler);

    }

    /**
     * Method to patch request
     *
     * @param context The context
     * @param url     The url
     * @param handler The handler to handle both scenarios
     * @return Return the handler
     */
    private RequestHandle patch(Context context, String url, JSONObject object, GSHttpClientResponseHandler handler) {
        GSJsonHttpResponseHandler jsonHandler = new GSJsonHttpResponseHandler();
        jsonHandler.setUrl(url);
        jsonHandler.setHandler(handler);
        StringEntity entity;
        entity = new StringEntity(object.toString(), "UTF8");
        return m_asyncHttpClient.patch(context, url, entity, "application/json", jsonHandler);

    }

    /**
     * Summary
     *
     * @param context The context
     * @param url     The url to post
     * @param json    The json object to be given for header
     * @param handler The handler to provide the response
     * @return Return the handler
     */
    private RequestHandle post(Context context, String url, JSONObject json, GSHttpClientResponseHandler handler) {

        GSJsonHttpResponseHandler jsonHandler = new GSJsonHttpResponseHandler();

        jsonHandler.setUrl(url);
        jsonHandler.setHandler(handler);

        StringEntity entity;

        entity = new StringEntity(json.toString(), "UTF8");

        return m_asyncHttpClient.post(context, url, entity, "application/json", jsonHandler);

    }


    private RequestHandle put(Context context, String url, JSONObject json, GSHttpClientResponseHandler handler) {

        GSJsonHttpResponseHandler jsonHandler = new GSJsonHttpResponseHandler();

        jsonHandler.setUrl(url);
        jsonHandler.setHandler(handler);

        StringEntity entity;

        entity = new StringEntity(json.toString(), "UTF8");

        return m_asyncHttpClient.put(context, url, entity, "application/json", jsonHandler);

    }

    public RequestHandle callAddJob(Context context, String eDestination_Address, String eDescription, String eContactName, String eContactPhone, String eEmailID, GSHttpClientResponseHandler handler) {
        JSONObject jObjDrop = new JSONObject();
        JSONObject jObjBook = new JSONObject();
        try {
            //generate the object to send
            JSONObject object = new JSONObject();
            object.put("name", eContactName);
            object.put("phone", eContactPhone);
            object.put("email", eEmailID);
            object.put("description", eDescription);
            object.put("address", eDestination_Address);

            jObjDrop.put("dropoffDetail", object);

            jObjBook.put("booking", jObjDrop);
            jObjBook.put("apiKey", GSAppConstants.GET_SWITF_MECHARENT_KEY);
            Log.d("", "===callAddJob===" + jObjBook);
        } catch (JSONException exception) {
            Log.d(TAG, exception.getLocalizedMessage());
        }
        return post(context, GSAppConstants.ADD_SWIFT_BOOK_DETAIL_API, jObjBook, handler);
    }

    public RequestHandle getJobDetail(Context context, GSHttpClientResponseHandler handler) {
        return get(context, GSAppConstants.GET_SWIFT_BOOK_DETAIL_API, handler);
    }


    public RequestHandle getTrackOrder(Context context, String mTrackOrderID, GSHttpClientResponseHandler handler) {
        return get(context, GSAppConstants.GET_TRACK_ORDER + mTrackOrderID, handler);
    }

}