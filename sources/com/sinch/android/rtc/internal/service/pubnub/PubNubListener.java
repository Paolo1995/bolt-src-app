package com.sinch.android.rtc.internal.service.pubnub;

import android.util.Log;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.natives.PubSubscriber;
import com.sinch.android.rtc.internal.service.http.CancellableFixedBackoffRetryPolicy;
import com.sinch.android.rtc.internal.service.http.HttpClientDefaults;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import com.sinch.gson.JsonArray;
import com.sinch.gson.JsonElement;
import com.sinch.gson.JsonParser;
import com.sinch.gson.JsonSyntaxException;
import com.sinch.httpclient.Logger;
import com.sinch.httpclient.Request;
import com.sinch.httpclient.RequestOptions;
import com.sinch.httpclient.Response;
import com.sinch.httpclient.ResponseHandler;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class PubNubListener {
    private static final int HTTP_CONNECTION_TIMEOUT = 5000;
    private static final int[] RETRY_INTERVALS = {200, 1000, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, InternalErrorCodes.ApiCallFailed, 6000, 10000, 20000};
    private static final int SUBSCRIBE_TIME_OUT = 310000;
    private static final String TAG = "PubNubListener";
    private volatile boolean active;
    private String baseRequest;
    private final String baseRequestSuffix;
    private final Executor callbackExecutor;
    private final Set<PubSubscriber> callbacks;
    private final List<String> channels;
    private final HttpClientInterface httpClient;
    private String lastRequestId;
    private final String pubnubUuid;
    private final int timeOffsetOnSubscribeInMs;
    private long timeToken;

    public PubNubListener(String str, String str2, List<String> list, String str3, int i8, String str4, Set<PubSubscriber> set, Executor executor, HttpClientInterface httpClientInterface) {
        String str5;
        this.timeOffsetOnSubscribeInMs = i8;
        this.callbacks = set;
        this.callbackExecutor = executor;
        this.channels = list;
        this.httpClient = httpClientInterface;
        this.pubnubUuid = str4;
        this.baseRequest = str + "/subscribe/" + str2 + "/" + getEncodedSubscribeChannels(list) + "/0/";
        if (str4 == null || str4.isEmpty()) {
            str5 = "";
        } else {
            str5 = "?uuid=" + str4;
        }
        this.baseRequestSuffix = str5;
        try {
            this.timeToken = Long.parseLong(str3);
        } catch (NumberFormatException unused) {
            this.timeToken = 0L;
        }
        this.active = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getChannelForMessageNo(String[] strArr, int i8) {
        return this.channels.size() == 1 ? this.channels.get(0) : (this.channels.size() <= 1 || strArr == null || strArr.length <= i8) ? "" : strArr[i8];
    }

    private static String getCommaSeparatedString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < list.size(); i8++) {
            sb.append(list.get(i8));
            if (i8 != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private String getEncodedSubscribeChannels(List<String> list) {
        String commaSeparatedString = getCommaSeparatedString(list);
        try {
            try {
                return URLEncoder.encode(commaSeparatedString, "utf-8");
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
                return commaSeparatedString;
            }
        } catch (Throwable unused) {
            return commaSeparatedString;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleData(JsonArray jsonArray, final String[] strArr) {
        for (int i8 = 0; i8 < jsonArray.size(); i8++) {
            final String asString = jsonArray.get(i8).getAsString();
            synchronized (this.callbacks) {
                for (final PubSubscriber pubSubscriber : this.callbacks) {
                    final int i9 = i8;
                    this.callbackExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.service.pubnub.PubNubListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PubNubListener.this.active) {
                                pubSubscriber.handleData(asString, PubNubListener.this.getChannelForMessageNo(strArr, i9), String.valueOf(PubNubListener.this.timeToken));
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailed(final String str) {
        synchronized (this.callbacks) {
            for (final PubSubscriber pubSubscriber : this.callbacks) {
                this.callbackExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.service.pubnub.PubNubListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PubNubListener.this.active) {
                            pubSubscriber.handleFailure(str);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTimeToken() {
        this.timeToken = 0L;
    }

    public void abort() {
        this.active = false;
        if (this.lastRequestId != null) {
            Logger defaultLogger = HttpClientDefaults.getDefaultLogger();
            String str = TAG;
            defaultLogger.d(str, "Cancelling subscription request " + this.lastRequestId);
            this.httpClient.cancelRequest(this.lastRequestId);
        }
    }

    public synchronized boolean isActive() {
        return this.active;
    }

    public void poll() {
        ResponseHandler responseHandler = new ResponseHandler() { // from class: com.sinch.android.rtc.internal.service.pubnub.PubNubListener.1
            @Override // com.sinch.httpclient.ResponseHandler
            public void onError(Exception exc) {
                if (exc instanceof JsonSyntaxException) {
                    PubNubListener.this.resetTimeToken();
                    if (PubNubListener.this.active) {
                        PubNubListener.this.poll();
                        return;
                    }
                    return;
                }
                String str = PubNubListener.TAG;
                Log.e(str, "Permanently failing subscribe due to " + exc.toString());
                PubNubListener.this.handleFailed(String.valueOf(1002));
            }

            @Override // com.sinch.httpclient.ResponseHandler
            public void onSuccess(Response response) {
                try {
                    try {
                        byte[] bArr = response.body;
                        String[] strArr = null;
                        String str = bArr.length != 0 ? new String(bArr, "UTF-8") : null;
                        if (str == null) {
                            PubNubListener.this.resetTimeToken();
                            if (PubNubListener.this.active) {
                                PubNubListener.this.poll();
                                return;
                            }
                            return;
                        }
                        JsonElement parse = new JsonParser().parse(str);
                        if (!parse.isJsonArray()) {
                            PubNubListener.this.resetTimeToken();
                            if (PubNubListener.this.active) {
                                PubNubListener.this.poll();
                                return;
                            }
                            return;
                        }
                        JsonArray asJsonArray = parse.getAsJsonArray();
                        if (asJsonArray.size() < 2) {
                            PubNubListener.this.resetTimeToken();
                            if (PubNubListener.this.active) {
                                PubNubListener.this.poll();
                                return;
                            }
                            return;
                        }
                        long asLong = asJsonArray.get(1).getAsLong();
                        if (PubNubListener.this.timeToken == 0) {
                            long j8 = (PubNubListener.this.timeOffsetOnSubscribeInMs * 10000) + asLong;
                            if (j8 > 0) {
                                asLong = j8;
                            }
                        }
                        PubNubListener.this.timeToken = asLong;
                        JsonArray asJsonArray2 = asJsonArray.get(0).getAsJsonArray();
                        if (asJsonArray.size() > 2) {
                            strArr = asJsonArray.get(2).getAsString().split(",");
                            int length = strArr.length;
                            asJsonArray2.size();
                        }
                        PubNubListener.this.handleData(asJsonArray2, strArr);
                        if (PubNubListener.this.active) {
                            PubNubListener.this.poll();
                        }
                    } catch (JsonSyntaxException unused) {
                        PubNubListener.this.resetTimeToken();
                        if (PubNubListener.this.active) {
                            PubNubListener.this.poll();
                        }
                    } catch (UnsupportedEncodingException unused2) {
                        PubNubListener.this.resetTimeToken();
                        if (PubNubListener.this.active) {
                            PubNubListener.this.poll();
                        }
                    }
                } catch (Throwable th) {
                    if (PubNubListener.this.active) {
                        PubNubListener.this.poll();
                    }
                    throw th;
                }
            }
        };
        String str = this.baseRequest + this.timeToken + this.baseRequestSuffix;
        this.lastRequestId = UUID.randomUUID().toString();
        try {
            this.httpClient.sendRequest(new Request(this.lastRequestId, new URL(str), "GET", HttpClientDefaults.getDefaultEmptyHeaders(), HttpClientDefaults.getDefaultEmptyBody()), responseHandler, new RequestOptions(1, new CancellableFixedBackoffRetryPolicy(RETRY_INTERVALS, TimeUnit.MILLISECONDS), HttpClientDefaults.getDefaultLogger(), 5000, SUBSCRIBE_TIME_OUT, SUBSCRIBE_TIME_OUT));
        } catch (MalformedURLException e8) {
            responseHandler.onError(e8);
        }
    }
}
