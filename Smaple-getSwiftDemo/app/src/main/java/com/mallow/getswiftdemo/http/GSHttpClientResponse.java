package com.mallow.getswiftdemo.http;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by bhagya on 23/11/15.
 */
public class GSHttpClientResponse {

    /**
     * Summary
     */
    private JSONObject m_jsonObject;
    private JSONArray m_jsonArray;
    private int m_statusCode;
    private String m_string;
    private String m_error;

    /**
     * Method to set response.
     *
     * @param json The json.
     */
    public void setResponse(JSONObject json) {
        m_jsonObject = json;
    }

    /**
     * Method to get JSONObject.
     *
     * @return Returns the json object.
     */
    public JSONObject getJSONObject() {
        return m_jsonObject;
    }

    /**
     * Method to set response.
     *
     * @param json The json.
     */
    public void setResponse(JSONArray json) {
        m_jsonArray = json;
    }

    /**
     * Method to get JSONArray.
     *
     * @return Returns the json array.
     */
    public JSONArray getJSONArray() {
        return m_jsonArray;
    }

    /**
     * Method to set response form http connection.
     *
     * @param response The response.
     */
    public void setResponse(String response) {
        m_string = response;
    }

    /**
     * Method to get string value.
     *
     * @return returns string value.
     */
    public String getString() {
        return m_string;
    }

    /**
     * Method to get the status code.
     *
     * @return Return the status code for http connection.
     */
    public int getStatusCode() {
        return m_statusCode;
    }

    /**
     * Method to set the status code.
     *
     * @param statusCode The http status code.
     */
    public void setStatusCode(int statusCode) {
        m_statusCode = statusCode;
    }

    /**
     * Method to set the error response from http connection.
     *
     * @return Returns the error message.
     */
    public String getError() {
        return m_error;
    }

    /**
     * Method to set the error response from http connection.
     *
     * @param error The error.
     */
    public void setError(String error) {
        m_error = error;
    }
}
