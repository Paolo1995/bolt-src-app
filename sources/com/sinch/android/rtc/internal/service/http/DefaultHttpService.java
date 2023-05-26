package com.sinch.android.rtc.internal.service.http;

import android.util.Base64;
import android.util.Log;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.natives.HttpRequest;
import com.sinch.android.rtc.internal.natives.HttpRequestCallback;
import com.sinch.httpclient.Request;
import com.sinch.httpclient.RequestOptions;
import com.sinch.httpclient.Response;
import com.sinch.httpclient.ResponseHandler;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DefaultHttpService implements HttpService {
    private static final int CONNECTION_TIMOUT = 10000;
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final int READ_TIMOUT = 10000;
    private static final String TAG = "DefaultHttpService";
    private final HttpClientInterface httpClient;
    private boolean mCancelAllRequests = false;
    private SinchHttpServiceObserver mObserver = null;

    public DefaultHttpService(HttpClientInterface httpClientInterface) {
        this.httpClient = httpClientInterface;
    }

    private static RequestOptions createRequestOptions(HttpRequest httpRequest) {
        return new RequestOptions(1, RetryPolicyFactory.createRetryPolicy(httpRequest), HttpClientDefaults.getDefaultLogger(), 10000, 10000, httpRequest.getRequestTimeoutMs() > 0 ? httpRequest.getRequestTimeoutMs() : -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logHttpRequest(String str) {
        if (str.length() <= 4000) {
            Log.d(TAG, str);
            return;
        }
        Log.d(TAG, str.substring(0, InternalErrorCodes.ApiCallFailed));
        logHttpRequest(str.substring(InternalErrorCodes.ApiCallFailed));
    }

    @Override // com.sinch.android.rtc.internal.service.http.HttpService
    public synchronized void cancelAllRequests() {
        this.mCancelAllRequests = true;
    }

    @Override // com.sinch.android.rtc.internal.service.http.HttpService
    public HttpRequest createHttpRequest(String str, int i8, byte[] bArr, Map<String, String> map, int i9, int i10) {
        return new HttpRequest(str, i8, bArr, map, i9, i10);
    }

    @Override // com.sinch.android.rtc.internal.service.http.HttpService
    public void sendRequest(final HttpRequest httpRequest, final HttpRequestCallback httpRequestCallback) {
        String str;
        try {
            Map<String, String> headers = httpRequest.getHeaders();
            if ((headers == null || headers.get("Content-Encoding") == null || !headers.get("Content-Encoding").equals("deflate")) ? false : true) {
                str = Base64.encodeToString(httpRequest.getBody(), 2);
            } else {
                if (httpRequest.getBody() != null && httpRequest.getBody().length != 0) {
                    str = new String(httpRequest.getBody(), "UTF-8");
                }
                str = "null/empty";
            }
        } catch (UnsupportedEncodingException e8) {
            httpRequestCallback.exception(e8.getClass().getSimpleName() + ": " + e8.getMessage());
            str = "UTF-8 Uninitialized String.";
        }
        logHttpRequest(String.format("Http request: %s  %s body: %s", httpRequest.getMethodString(), httpRequest.getUrl(), str));
        if (this.mCancelAllRequests) {
            Log.d(TAG, "Ignoring http request, since we've got cancelAllRequests");
            return;
        }
        try {
            SinchHttpServiceObserver sinchHttpServiceObserver = this.mObserver;
            if (sinchHttpServiceObserver != null) {
                sinchHttpServiceObserver.onHttpRequestSent(httpRequest.getUrl(), httpRequest.getMethodString(), httpRequest.getBody());
            }
            this.httpClient.sendRequest(new Request(UUID.randomUUID().toString(), new URL(httpRequest.getUrl()), httpRequest.getMethodString(), httpRequest.getHeaders(), httpRequest.getBody()), new ResponseHandler() { // from class: com.sinch.android.rtc.internal.service.http.DefaultHttpService.1
                @Override // com.sinch.httpclient.ResponseHandler
                public void onError(Exception exc) {
                    Log.e(DefaultHttpService.TAG, "Error while executing http request: ", exc);
                    HttpRequestCallback httpRequestCallback2 = httpRequestCallback;
                    httpRequestCallback2.exception(exc.getClass().getSimpleName() + ": " + exc.getMessage());
                }

                @Override // com.sinch.httpclient.ResponseHandler
                public void onSuccess(Response response) {
                    String str2 = null;
                    String str3 = response.headers.get(null);
                    String str4 = response.headers.get(DefaultHttpService.HEADER_CONTENT_TYPE);
                    byte[] bArr = response.body;
                    if (bArr.length != 0) {
                        try {
                            str2 = new String(bArr, "UTF-8");
                        } catch (UnsupportedEncodingException e9) {
                            onError(e9);
                            return;
                        }
                    }
                    String str5 = str2;
                    Object[] objArr = new Object[5];
                    objArr[0] = httpRequest.getMethodString();
                    objArr[1] = httpRequest.getUrl();
                    objArr[2] = str3;
                    objArr[3] = str4;
                    objArr[4] = str5 == null ? "null" : str5.isEmpty() ? "empty" : str5;
                    DefaultHttpService.this.logHttpRequest(String.format("Http response from: %s  %s. Status: %s. Content-type: %s, body: %s", objArr));
                    httpRequestCallback.completed(response.status, str3 == null ? "" : str3, response.body.length, str4 != null ? str4 : "", str5);
                }
            }, createRequestOptions(httpRequest));
        } catch (MalformedURLException e9) {
            httpRequestCallback.exception(e9.getClass().getSimpleName() + ": " + e9.getMessage());
        }
    }

    @Override // com.sinch.android.rtc.internal.service.http.HttpService
    public void setObserver(SinchHttpServiceObserver sinchHttpServiceObserver) {
        this.mObserver = sinchHttpServiceObserver;
    }
}
