package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class InstrumentOkHttpEnqueueCallback implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Callback f16813a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkRequestMetricBuilder f16814b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16815c;

    /* renamed from: d  reason: collision with root package name */
    private final Timer f16816d;

    public InstrumentOkHttpEnqueueCallback(Callback callback, TransportManager transportManager, Timer timer, long j8) {
        this.f16813a = callback;
        this.f16814b = NetworkRequestMetricBuilder.c(transportManager);
        this.f16815c = j8;
        this.f16816d = timer;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.url();
            if (url != null) {
                this.f16814b.v(url.url().toString());
            }
            if (request.method() != null) {
                this.f16814b.j(request.method());
            }
        }
        this.f16814b.p(this.f16815c);
        this.f16814b.t(this.f16816d.b());
        NetworkRequestMetricBuilderUtil.d(this.f16814b);
        this.f16813a.onFailure(call, iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        FirebasePerfOkHttpClient.a(response, this.f16814b, this.f16815c, this.f16816d.b());
        this.f16813a.onResponse(call, response);
    }
}
