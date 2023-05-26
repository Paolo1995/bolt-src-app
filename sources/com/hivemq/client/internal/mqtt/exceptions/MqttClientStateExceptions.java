package com.hivemq.client.internal.mqtt.exceptions;

import com.hivemq.client.mqtt.exceptions.MqttClientStateException;

/* loaded from: classes3.dex */
public final class MqttClientStateExceptions {
    private MqttClientStateExceptions() {
    }

    public static MqttClientStateException a() {
        return new MqttClientStateException("MQTT client is already connected or connecting.");
    }

    public static MqttClientStateException b() {
        return new MqttClientStateException("MQTT client is not connected.");
    }
}
