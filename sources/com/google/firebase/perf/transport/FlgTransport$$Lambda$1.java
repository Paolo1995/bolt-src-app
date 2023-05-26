package com.google.firebase.perf.transport;

import com.google.android.datatransport.Transformer;
import com.google.firebase.perf.v1.PerfMetric;

/* loaded from: classes3.dex */
final /* synthetic */ class FlgTransport$$Lambda$1 implements Transformer {

    /* renamed from: a  reason: collision with root package name */
    private static final FlgTransport$$Lambda$1 f16822a = new FlgTransport$$Lambda$1();

    private FlgTransport$$Lambda$1() {
    }

    public static Transformer a() {
        return f16822a;
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        return ((PerfMetric) obj).toByteArray();
    }
}
