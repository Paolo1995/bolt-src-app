package com.hivemq.client.internal.mqtt.codec.encoder;

import com.hivemq.client.internal.mqtt.datatypes.MqttBinaryData;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import com.hivemq.client.mqtt.exceptions.MqttEncodeException;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class MqttMessageEncoderUtil {
    private MqttMessageEncoderUtil() {
    }

    public static void a(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuf byteBuf) {
        if (mqttUtf8StringImpl != null) {
            mqttUtf8StringImpl.h(byteBuf);
        }
    }

    public static void b(ByteBuffer byteBuffer, ByteBuf byteBuf) {
        if (byteBuffer != null) {
            MqttBinaryData.c(byteBuffer, byteBuf);
        }
    }

    public static int c(int i8) {
        return MqttVariableByteInteger.c(i8) + i8;
    }

    public static int d(int i8) {
        return c(i8) + 1;
    }

    public static MqttEncodeException e(MqttMessage mqttMessage, int i8, int i9) {
        return new MqttEncodeException(mqttMessage.getType() + " exceeded maximum packet size, minimal possible encoded length: " + i8 + ", maximum: " + i9 + ".");
    }

    public static int f(MqttUtf8StringImpl mqttUtf8StringImpl) {
        if (mqttUtf8StringImpl == null) {
            return 0;
        }
        return mqttUtf8StringImpl.j();
    }

    public static int g(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return 0;
        }
        return MqttBinaryData.f(byteBuffer);
    }
}
