package com.anoopnair.httpzoid;

import android.util.Log;

import java.net.URL;

/**
 * Response callback handler
 * (c) Artur Sharipov
 */
public class ResponseHandler<T> {
    private long start  ;
    private long finish;
    private String url ;
    /**
     * Notifies about success
     * @param data returned data
     * @param response http response object
     */
    public void success(T data, HttpResponse response){}

    /**
     * Notifies about error (http response code >= 400)
     * @param message error message
     * @param response http response object
     */
    public void error(String message, HttpResponse response){}

    /**
     * Notifies about network failure (offline, authentication error, etc.)
     * @param error
     */
    public void failure(NetworkError error){}

    /**
     * Notifies about request complete (happens after success/error/failure)
     */
    public void complete(){}

    public String getUrl(){
        return url;
    }
    public void setUrl(URL url){
        this.url = url.toString() ;
    }
    public void start(){
        start = System.currentTimeMillis();
    }
    public void finish(){
        finish = System.currentTimeMillis() ;
    }

    public void logElapsed(String url){
        long elapsed = (System.currentTimeMillis() - start) ;
        Log.i("Httpzoid", url + " " + elapsed + " ms");
    }
}