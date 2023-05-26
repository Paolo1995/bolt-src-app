package com.hivemq.client.internal.mqtt.codec.decoder;

/* loaded from: classes3.dex */
public abstract class MqttMessageDecoders {

    /* renamed from: a  reason: collision with root package name */
    protected final MqttMessageDecoder[] f17872a = new MqttMessageDecoder[16];

    public final MqttMessageDecoder a(int i8) {
        if (i8 >= 0) {
            MqttMessageDecoder[] mqttMessageDecoderArr = this.f17872a;
            if (i8 < mqttMessageDecoderArr.length) {
                return mqttMessageDecoderArr[i8];
            }
            return null;
        }
        return null;
    }
}
