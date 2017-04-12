package com.mallow.getswiftdemo;


/**
 * Created by Jai on 19/11/15.
 */
public class GSAppConstants {

    public static final float ALPHA_MEDIUM = 0.7f;
    public static final float ALPHA_DEFAULT = 1.0f;
    public static final int LOGIN_FAILED_ERROR_CODE = 401;
    public static int SPLASH_TIME_OUT = 3000;

    //InstallationRequest
    public static String INSTALLATION_REQUEST_NAME = "InstallationRequestName";
    public static String INSTALLATION_REQUEST_REFERENCE = "InstallationRequestReference";
    public static String INSTALLATION_REQUEST_ADD = "InstallationRequest_add";
    public static String GET_SWITF_MECHARENT_KEY = "bf6db080-957b-4bbb-81a0-b97c0ee69706";
    public static String ADD_SWIFT_BOOK_DETAIL_API = "https://app.getswift.co/api/v2/deliveries";
    public static String GET_SWIFT_BOOK_DETAIL_API = "https://app.getswift.co/api/v2/deliveries?apiKey=" + GET_SWITF_MECHARENT_KEY;
    public static String GET_TRACK_ORDER = "https://app.getswift.co//api/v2/deliveries/";
    public static boolean isAddJobGiven = false;
}
