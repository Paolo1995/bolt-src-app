package com.mixpanel.android.java_websocket.handshake;

/* loaded from: classes3.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {

    /* renamed from: c  reason: collision with root package name */
    private String f19044c = "*";

    @Override // com.mixpanel.android.java_websocket.handshake.ClientHandshake
    public String c() {
        return this.f19044c;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder
    public void f(String str) throws IllegalArgumentException {
        if (str != null) {
            this.f19044c = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
