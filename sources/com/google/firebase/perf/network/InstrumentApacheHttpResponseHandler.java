package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* loaded from: classes3.dex */
public class InstrumentApacheHttpResponseHandler<T> implements ResponseHandler<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ResponseHandler<? extends T> f16810a;

    /* renamed from: b  reason: collision with root package name */
    private final Timer f16811b;

    /* renamed from: c  reason: collision with root package name */
    private final NetworkRequestMetricBuilder f16812c;

    public InstrumentApacheHttpResponseHandler(ResponseHandler<? extends T> responseHandler, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        this.f16810a = responseHandler;
        this.f16811b = timer;
        this.f16812c = networkRequestMetricBuilder;
    }

    public T handleResponse(HttpResponse httpResponse) throws IOException {
        this.f16812c.t(this.f16811b.b());
        this.f16812c.l(httpResponse.getStatusLine().getStatusCode());
        Long a8 = NetworkRequestMetricBuilderUtil.a(httpResponse);
        if (a8 != null) {
            this.f16812c.r(a8.longValue());
        }
        String b8 = NetworkRequestMetricBuilderUtil.b(httpResponse);
        if (b8 != null) {
            this.f16812c.q(b8);
        }
        this.f16812c.b();
        return (T) this.f16810a.handleResponse(httpResponse);
    }
}
