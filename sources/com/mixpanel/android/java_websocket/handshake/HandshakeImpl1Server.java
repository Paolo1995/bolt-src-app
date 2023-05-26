package com.mixpanel.android.java_websocket.handshake;

/* loaded from: classes3.dex */
public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {

    /* renamed from: c  reason: collision with root package name */
    private short f19045c;

    /* renamed from: d  reason: collision with root package name */
    private String f19046d;

    @Override // com.mixpanel.android.java_websocket.handshake.ServerHandshake
    public String a() {
        return this.f19046d;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder
    public void e(short s7) {
        this.f19045c = s7;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder
    public void g(String str) {
        this.f19046d = str;
    }
}
