package com.mallow.getswiftdemo;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.mallow.getswiftdemo.datamodel.GSDataModelController;
import com.mallow.getswiftdemo.http.GSHttpClient;

;

/**
 * Created by Jai on 19/11/15.
 */
public class GSApp extends Application {
    /**
     * Summary
     */
    private static final String TAG = "App";
    /**
     * Summary
     */
    private static GSApp m_instance;
    /**
     * Network timeout in seconds
     */
    private final int timeout = 15;
    private GSDataModelController m_dataModelController;
    private GSHttpClient m_httpClient;
    /**
     * Summary
     */
    private Toast m_toast;
    /**
     * The locale of the device
     */
    /**
     * Method to get the instance
     *
     * @return Return the instance
     */
    public static GSApp getInstance() {
        return m_instance;
    }

    /**
     * Summary
     */
    @Override
    public void onCreate() {
        super.onCreate();
        m_instance = this;

        initInstance();
    }
    /**
     * Summary
     */
    private void initInstance() {
        Log.v(TAG, "initInstance()");
        m_dataModelController = new GSDataModelController();
        m_httpClient = new GSHttpClient(this);

    }

    /**
     * Summary
     *
     * @param message
     */
    public void showToast(String message, int duration) {
        if (m_toast == null) {
            m_toast = Toast.makeText(this, message, duration);
        } else {
            m_toast.setText(message);
            m_toast.setDuration(duration);
        }

        m_toast.show();
    }

    /**
     * Summary
     */
    public void cancelToast() {
        if (m_toast != null) {
            m_toast.cancel();
            m_toast = null;
        }
    }
    /**
     * Method to get Http client.
     *
     * @return Returns http client.
     */
    public GSHttpClient getHttpClient() {
        return m_httpClient;
    }

    /**
     * Method to get dataModelController.
     *
     * @return Returns the dataModelController.
     */
    public GSDataModelController getDataModelController() {
        return m_dataModelController;
    }
}