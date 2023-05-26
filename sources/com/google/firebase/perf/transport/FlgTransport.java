package com.google.firebase.perf.transport;

import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.PerfMetric;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class FlgTransport {

    /* renamed from: d  reason: collision with root package name */
    private static final AndroidLogger f16818d = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private final String f16819a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TransportFactory> f16820b;

    /* renamed from: c  reason: collision with root package name */
    private Transport<PerfMetric> f16821c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlgTransport(Provider<TransportFactory> provider, String str) {
        this.f16819a = str;
        this.f16820b = provider;
    }

    private boolean a() {
        if (this.f16821c == null) {
            TransportFactory transportFactory = this.f16820b.get();
            if (transportFactory != null) {
                this.f16821c = transportFactory.a(this.f16819a, PerfMetric.class, Encoding.b("proto"), FlgTransport$$Lambda$1.a());
            } else {
                f16818d.i("Flg TransportFactory is not available at the moment");
            }
        }
        if (this.f16821c != null) {
            return true;
        }
        return false;
    }

    public void b(@NonNull PerfMetric perfMetric) {
        if (!a()) {
            f16818d.i("Unable to dispatch event because Flg Transport is not available");
        } else {
            this.f16821c.b(Event.d(perfMetric));
        }
    }
}
