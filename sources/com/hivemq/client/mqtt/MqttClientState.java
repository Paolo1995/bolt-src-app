package com.hivemq.client.mqtt;

import java.util.EnumSet;

/* loaded from: classes3.dex */
public enum MqttClientState {
    DISCONNECTED,
    CONNECTING,
    CONNECTED,
    DISCONNECTED_RECONNECT,
    CONNECTING_RECONNECT;
    

    /* renamed from: k  reason: collision with root package name */
    private static final EnumSet<MqttClientState> f18741k = EnumSet.of(CONNECTED, DISCONNECTED_RECONNECT, CONNECTING_RECONNECT);

    public boolean a() {
        return f18741k.contains(this);
    }
}
