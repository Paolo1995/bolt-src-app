package com.sinch.android.rtc.internal.service.pubnub;

import android.util.Log;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.natives.PubPublisher;
import com.sinch.android.rtc.internal.service.http.HttpClientDefaults;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import com.sinch.android.rtc.internal.service.http.ScopedConstantBackoffRetryPolicy;
import com.sinch.android.rtc.internal.service.pubnub.http.UriEncoder;
import com.sinch.gson.JsonArray;
import com.sinch.gson.JsonElement;
import com.sinch.gson.JsonParser;
import com.sinch.httpclient.Request;
import com.sinch.httpclient.RequestOptions;
import com.sinch.httpclient.Response;
import com.sinch.httpclient.ResponseHandler;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class PubNubPublisher {
    private static final int HTTP_CONNECTION_TIMEOUT = 5000;
    public static final String MALFORMED_JSON_FROM_PUB_NUB = "Malformed JSON from PubNub";
    private static final int PUBLISH_RETRY_SCOPE = 15000;
    private static final int PUBLISH_RETRY_WAIT = 3000;
    private static final int PUBLISH_TIME_OUT = 5000;
    private static final String TAG = "PubNubPublisher";
    private volatile boolean active = true;
    private final HttpClientInterface httpClient;
    private final String pubNubBaseUrl;
    private final Executor publishExecutor;

    public PubNubPublisher(Executor executor, String str, HttpClientInterface httpClientInterface) {
        this.publishExecutor = executor;
        this.pubNubBaseUrl = str;
        this.httpClient = httpClientInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failCallback(PubPublisher pubPublisher, int i8, String str) {
        failCallback(pubPublisher, i8, str, "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failCallback(final PubPublisher pubPublisher, final int i8, final String str, final String str2) {
        if (pubPublisher == null || !this.active) {
            return;
        }
        this.publishExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.service.pubnub.c
            @Override // java.lang.Runnable
            public final void run() {
                PubPublisher.this.onPublishFailed(i8, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void successCallback(final PubPublisher pubPublisher, final String str) {
        if (pubPublisher == null || !this.active) {
            return;
        }
        this.publishExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.service.pubnub.b
            @Override // java.lang.Runnable
            public final void run() {
                PubPublisher.this.onPublishSuccess(str);
            }
        });
    }

    public void abort() {
        this.active = false;
    }

    public void publish(String str, final String str2, String str3, String str4, String str5, final PubPublisher pubPublisher) {
        ResponseHandler responseHandler = new ResponseHandler() { // from class: com.sinch.android.rtc.internal.service.pubnub.PubNubPublisher.1
            @Override // com.sinch.httpclient.ResponseHandler
            public void onError(Exception exc) {
                String str6 = PubNubPublisher.TAG;
                Log.e(str6, "Permanent failure for publishing, message: " + str2);
                PubNubPublisher pubNubPublisher = PubNubPublisher.this;
                PubPublisher pubPublisher2 = pubPublisher;
                pubNubPublisher.failCallback(pubPublisher2, 1002, "Network error when publishing to PubNub. " + exc);
            }

            @Override // com.sinch.httpclient.ResponseHandler
            public void onSuccess(Response response) {
                String str6;
                byte[] bArr = response.body;
                if (bArr.length != 0) {
                    try {
                        str6 = new String(bArr, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        PubNubPublisher.this.failCallback(pubPublisher, InternalErrorCodes.ApiCallFailed, PubNubPublisher.MALFORMED_JSON_FROM_PUB_NUB);
                        return;
                    }
                } else {
                    str6 = null;
                }
                try {
                    JsonElement parse = new JsonParser().parse(str6);
                    if (!parse.isJsonArray()) {
                        PubNubPublisher.this.failCallback(pubPublisher, InternalErrorCodes.ApiCallFailed, PubNubPublisher.MALFORMED_JSON_FROM_PUB_NUB);
                        return;
                    }
                    JsonArray asJsonArray = parse.getAsJsonArray();
                    if (asJsonArray.size() < 3) {
                        PubNubPublisher.this.failCallback(pubPublisher, InternalErrorCodes.ApiCallFailed, PubNubPublisher.MALFORMED_JSON_FROM_PUB_NUB);
                        return;
                    }
                    int asInt = asJsonArray.get(0).getAsInt();
                    String asString = asJsonArray.get(1).getAsString();
                    long asLong = asJsonArray.get(2).getAsLong();
                    if (asInt == 1) {
                        PubNubPublisher.this.successCallback(pubPublisher, String.valueOf(asLong));
                    } else {
                        PubNubPublisher.this.failCallback(pubPublisher, InternalErrorCodes.ApiCallFailed, asString, String.valueOf(asLong));
                    }
                } catch (Exception e8) {
                    onError(e8);
                }
            }
        };
        try {
            this.httpClient.sendRequest(new Request(UUID.randomUUID().toString(), new URL(this.pubNubBaseUrl + "/publish/" + UriEncoder.encode(str4) + "/" + UriEncoder.encode(str3) + "/0/" + UriEncoder.encode(str) + "/0/" + ("\"" + UriEncoder.encode(str2) + "\"") + "?uuid=" + UriEncoder.encode(str5)), "GET", HttpClientDefaults.getDefaultEmptyHeaders(), HttpClientDefaults.getDefaultEmptyBody()), responseHandler, new RequestOptions(1, new ScopedConstantBackoffRetryPolicy(PUBLISH_RETRY_SCOPE, 3000), HttpClientDefaults.getDefaultLogger(), 5000, 5000, 5000));
        } catch (MalformedURLException e8) {
            responseHandler.onError(e8);
        }
    }
}
