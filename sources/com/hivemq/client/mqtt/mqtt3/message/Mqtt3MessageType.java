package com.hivemq.client.mqtt.mqtt3.message;

/* loaded from: classes3.dex */
public enum Mqtt3MessageType {
    CONNECT,
    CONNACK,
    PUBLISH,
    PUBACK,
    PUBREC,
    PUBREL,
    PUBCOMP,
    SUBSCRIBE,
    SUBACK,
    UNSUBSCRIBE,
    UNSUBACK,
    PINGREQ,
    PINGRESP,
    DISCONNECT;
    

    /* renamed from: t  reason: collision with root package name */
    private static final Mqtt3MessageType[] f18776t = values();

    public int a() {
        return ordinal() + 1;
    }
}
