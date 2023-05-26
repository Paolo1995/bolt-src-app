package com.hivemq.client.internal.mqtt.codec.decoder;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public final class MqttMessageDecoderUtil {
    private MqttMessageDecoderUtil() {
    }

    public static void a(int i8, int i9) throws MqttDecoderException {
        if (i8 == i9) {
            return;
        }
        throw new MqttDecoderException("fixed header flags must be " + i8 + " but were " + i9);
    }

    public static void b(int i8, int i9) throws MqttDecoderException {
        if (i8 == i9) {
            return;
        }
        throw new MqttDecoderException("remaining length must be " + i8 + " but was " + i9);
    }

    public static int c(MqttQos mqttQos, ByteBuf byteBuf) throws MqttDecoderException {
        if (mqttQos == MqttQos.AT_MOST_ONCE) {
            return -1;
        }
        if (byteBuf.readableBytes() >= 2) {
            return byteBuf.readUnsignedShort();
        }
        throw g();
    }

    public static MqttQos d(int i8, boolean z7) throws MqttDecoderException {
        MqttQos a8 = MqttQos.a((i8 & 6) >> 1);
        if (a8 != null) {
            if (a8 == MqttQos.AT_MOST_ONCE && z7) {
                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "DUP flag must be 0 if QoS is 0");
            }
            return a8;
        }
        throw new MqttDecoderException("wrong QoS");
    }

    public static MqttDecoderException e() {
        return new MqttDecoderException(Mqtt5DisconnectReasonCode.TOPIC_NAME_INVALID, "malformed topic");
    }

    public static MqttDecoderException f(String str) {
        return new MqttDecoderException("malformed UTF-8 string for " + str);
    }

    public static MqttDecoderException g() {
        return new MqttDecoderException("remaining length too short");
    }
}
