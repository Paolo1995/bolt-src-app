package com.hivemq.client.internal.mqtt.codec.encoder;

/* loaded from: classes3.dex */
public abstract class MqttMessageEncoders {

    /* renamed from: a  reason: collision with root package name */
    protected final MqttMessageEncoder<?>[] f17919a = new MqttMessageEncoder[16];

    public final MqttMessageEncoder<?> a(int i8) {
        if (i8 >= 0) {
            MqttMessageEncoder<?>[] mqttMessageEncoderArr = this.f17919a;
            if (i8 < mqttMessageEncoderArr.length) {
                return mqttMessageEncoderArr[i8];
            }
            return null;
        }
        return null;
    }
}
