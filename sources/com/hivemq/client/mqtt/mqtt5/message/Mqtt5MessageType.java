package com.hivemq.client.mqtt.mqtt5.message;

/* loaded from: classes3.dex */
public enum Mqtt5MessageType {
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
    DISCONNECT,
    AUTH;
    

    /* renamed from: u  reason: collision with root package name */
    private static final Mqtt5MessageType[] f18816u = values();

    public static Mqtt5MessageType a(int i8) {
        if (i8 >= 1) {
            Mqtt5MessageType[] mqtt5MessageTypeArr = f18816u;
            if (i8 <= mqtt5MessageTypeArr.length) {
                return mqtt5MessageTypeArr[i8 - 1];
            }
            return null;
        }
        return null;
    }

    public int c() {
        return ordinal() + 1;
    }
}
