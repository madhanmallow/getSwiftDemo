package com.mallow.getswiftdemo.datamodel;


import com.mallow.getswiftdemo.http.GSHttpClientResponse;

/**
 * Company: Mallow Technology
 * Created by bhagya on 23/11/15.
 */
interface CXDataModelResponseHandlerInterface {
    void onSuccess(GSHttpClientResponse response);

    void onFailure(GSHttpClientResponse response);
}
