package com.hivemq.client.mqtt.mqtt5.message.subscribe;

/* loaded from: classes3.dex */
public enum Mqtt5RetainHandling {
    SEND,
    SEND_IF_SUBSCRIPTION_DOES_NOT_EXIST,
    DO_NOT_SEND;

    public static Mqtt5RetainHandling a(int i8) {
        Mqtt5RetainHandling mqtt5RetainHandling = SEND;
        if (i8 == mqtt5RetainHandling.c()) {
            return mqtt5RetainHandling;
        }
        Mqtt5RetainHandling mqtt5RetainHandling2 = SEND_IF_SUBSCRIPTION_DOES_NOT_EXIST;
        if (i8 == mqtt5RetainHandling2.c()) {
            return mqtt5RetainHandling2;
        }
        Mqtt5RetainHandling mqtt5RetainHandling3 = DO_NOT_SEND;
        if (i8 == mqtt5RetainHandling3.c()) {
            return mqtt5RetainHandling3;
        }
        return null;
    }

    public int c() {
        return ordinal();
    }
}
