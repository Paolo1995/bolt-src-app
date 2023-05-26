package com.google.firebase.crashlytics.internal.network;

import java.util.Map;

/* loaded from: classes3.dex */
public class HttpRequestFactory {
    public HttpGetRequest a(String str, Map<String, String> map) {
        return new HttpGetRequest(str, map);
    }
}
