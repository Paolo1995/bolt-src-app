package com.hivemq.client.mqtt.mqtt5.message.publish;

/* loaded from: classes3.dex */
public enum Mqtt5PayloadFormatIndicator {
    UNSPECIFIED,
    UTF_8;

    public static Mqtt5PayloadFormatIndicator a(int i8) {
        Mqtt5PayloadFormatIndicator mqtt5PayloadFormatIndicator = UNSPECIFIED;
        if (i8 == mqtt5PayloadFormatIndicator.c()) {
            return mqtt5PayloadFormatIndicator;
        }
        Mqtt5PayloadFormatIndicator mqtt5PayloadFormatIndicator2 = UTF_8;
        if (i8 == mqtt5PayloadFormatIndicator2.c()) {
            return mqtt5PayloadFormatIndicator2;
        }
        return null;
    }

    public int c() {
        return ordinal();
    }
}
