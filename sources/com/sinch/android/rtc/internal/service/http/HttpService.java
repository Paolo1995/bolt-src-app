package com.sinch.android.rtc.internal.service.http;

import com.sinch.android.rtc.internal.natives.HttpRequest;
import com.sinch.android.rtc.internal.natives.HttpRequestCallback;
import java.util.Map;

/* loaded from: classes3.dex */
public interface HttpService {
    void cancelAllRequests();

    HttpRequest createHttpRequest(String str, int i8, byte[] bArr, Map<String, String> map, int i9, int i10);

    void sendRequest(HttpRequest httpRequest, HttpRequestCallback httpRequestCallback);

    void setObserver(SinchHttpServiceObserver sinchHttpServiceObserver);
}
