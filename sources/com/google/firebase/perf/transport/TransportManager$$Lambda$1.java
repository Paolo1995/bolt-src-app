package com.google.firebase.perf.transport;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class TransportManager$$Lambda$1 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final TransportManager f16859f;

    private TransportManager$$Lambda$1(TransportManager transportManager) {
        this.f16859f = transportManager;
    }

    public static Runnable a(TransportManager transportManager) {
        return new TransportManager$$Lambda$1(transportManager);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16859f.y();
    }
}
