package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Response response, NetworkRequestMetricBuilder networkRequestMetricBuilder, long j8, long j9) throws IOException {
        Request request = response.request();
        if (request == null) {
            return;
        }
        networkRequestMetricBuilder.v(request.url().url().toString());
        networkRequestMetricBuilder.j(request.method());
        if (request.body() != null) {
            long contentLength = request.body().contentLength();
            if (contentLength != -1) {
                networkRequestMetricBuilder.o(contentLength);
            }
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength2 = body.contentLength();
            if (contentLength2 != -1) {
                networkRequestMetricBuilder.r(contentLength2);
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                networkRequestMetricBuilder.q(contentType.toString());
            }
        }
        networkRequestMetricBuilder.l(response.code());
        networkRequestMetricBuilder.p(j8);
        networkRequestMetricBuilder.t(j9);
        networkRequestMetricBuilder.b();
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        Timer timer = new Timer();
        call.enqueue(new InstrumentOkHttpEnqueueCallback(callback, TransportManager.e(), timer, timer.d()));
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(TransportManager.e());
        Timer timer = new Timer();
        long d8 = timer.d();
        try {
            Response execute = call.execute();
            a(execute, c8, d8, timer.b());
            return execute;
        } catch (IOException e8) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    c8.v(url.url().toString());
                }
                if (request.method() != null) {
                    c8.j(request.method());
                }
            }
            c8.p(d8);
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }
}
