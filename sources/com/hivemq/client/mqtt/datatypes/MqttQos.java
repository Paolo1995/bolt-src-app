package com.hivemq.client.mqtt.datatypes;

/* loaded from: classes3.dex */
public enum MqttQos {
    AT_MOST_ONCE,
    AT_LEAST_ONCE,
    EXACTLY_ONCE;
    

    /* renamed from: i  reason: collision with root package name */
    private static final MqttQos[] f18754i = values();

    public static MqttQos a(int i8) {
        if (i8 >= 0) {
            MqttQos[] mqttQosArr = f18754i;
            if (i8 < mqttQosArr.length) {
                return mqttQosArr[i8];
            }
            return null;
        }
        return null;
    }

    public int c() {
        return ordinal();
    }
}
