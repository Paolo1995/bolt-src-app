package com.google.firebase.perf.transport;

/* loaded from: classes3.dex */
final /* synthetic */ class TransportManager$$Lambda$3 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final TransportManager f16862f;

    private TransportManager$$Lambda$3(TransportManager transportManager) {
        this.f16862f = transportManager;
    }

    public static Runnable a(TransportManager transportManager) {
        return new TransportManager$$Lambda$3(transportManager);
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.f16853o.a(this.f16862f.f16856r);
    }
}
