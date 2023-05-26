package com.sinch.httpclient;

/* loaded from: classes3.dex */
public interface ResponseHandler {
    void onError(Exception exc);

    void onSuccess(Response response);
}
