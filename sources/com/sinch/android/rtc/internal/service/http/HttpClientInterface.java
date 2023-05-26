package com.sinch.android.rtc.internal.service.http;

import com.sinch.httpclient.Request;
import com.sinch.httpclient.RequestOptions;
import com.sinch.httpclient.ResponseHandler;

/* loaded from: classes3.dex */
public interface HttpClientInterface {
    void cancelAllRequests();

    void cancelRequest(String str);

    void sendRequest(Request request, ResponseHandler responseHandler, RequestOptions requestOptions);
}
