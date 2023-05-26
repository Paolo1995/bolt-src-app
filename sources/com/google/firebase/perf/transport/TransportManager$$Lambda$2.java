package com.google.firebase.perf.transport;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class TransportManager$$Lambda$2 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final TransportManager f16860f;

    /* renamed from: g  reason: collision with root package name */
    private final PendingPerfEvent f16861g;

    private TransportManager$$Lambda$2(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        this.f16860f = transportManager;
        this.f16861g = pendingPerfEvent;
    }

    public static Runnable a(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        return new TransportManager$$Lambda$2(transportManager, pendingPerfEvent);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16860f.z(r1.f16823a, this.f16861g.f16824b);
    }
}
