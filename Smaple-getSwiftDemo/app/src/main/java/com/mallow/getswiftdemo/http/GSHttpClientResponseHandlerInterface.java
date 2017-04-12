package com.mallow.getswiftdemo.http;

import cz.msebera.android.httpclient.Header;

/**
 * Created by bhagya on 23/11/15.
 */
interface GSHttpClientResponseHandlerInterface {

    void onSuccess(Header[] headers, GSHttpClientResponse response);

    void onFailure(GSHttpClientResponse response);
}
