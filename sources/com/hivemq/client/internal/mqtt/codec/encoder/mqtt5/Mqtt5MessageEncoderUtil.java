package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.datatypes.MqttBinaryData;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PayloadFormatIndicator;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Mqtt5MessageEncoderUtil {
    private Mqtt5MessageEncoderUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(boolean z7, boolean z8) {
        return z7 == z8 ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i8, boolean z7, boolean z8, ByteBuf byteBuf) {
        if (z7 != z8) {
            byteBuf.writeByte(i8);
            byteBuf.writeByte(z7 ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(int i8, long j8, long j9, ByteBuf byteBuf) {
        if (j8 != j9) {
            byteBuf.writeByte(i8);
            byteBuf.writeInt((int) j8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(int i8, MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuf byteBuf) {
        if (mqttUtf8StringImpl != null) {
            g(i8, mqttUtf8StringImpl, byteBuf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(int i8, Mqtt5PayloadFormatIndicator mqtt5PayloadFormatIndicator, ByteBuf byteBuf) {
        if (mqtt5PayloadFormatIndicator != null) {
            byteBuf.writeByte(i8);
            byteBuf.writeByte(mqtt5PayloadFormatIndicator.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(int i8, ByteBuffer byteBuffer, ByteBuf byteBuf) {
        if (byteBuffer != null) {
            byteBuf.writeByte(i8);
            MqttBinaryData.c(byteBuffer, byteBuf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(int i8, MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuf byteBuf) {
        byteBuf.writeByte(i8);
        mqttUtf8StringImpl.h(byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(int i8, int i9, int i10, ByteBuf byteBuf) {
        if (i9 != i10) {
            byteBuf.writeByte(i8);
            byteBuf.writeShort(i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(int i8, int i9, long j8, ByteBuf byteBuf) {
        if (i9 != j8) {
            j(i8, i9, byteBuf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(int i8, int i9, ByteBuf byteBuf) {
        byteBuf.writeByte(i8);
        MqttVariableByteInteger.b(i9, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(long j8, long j9) {
        return j8 == j9 ? 0 : 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(MqttUtf8StringImpl mqttUtf8StringImpl) {
        if (mqttUtf8StringImpl == null) {
            return 0;
        }
        return o(mqttUtf8StringImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(Mqtt5PayloadFormatIndicator mqtt5PayloadFormatIndicator) {
        return mqtt5PayloadFormatIndicator == null ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return 0;
        }
        return MqttBinaryData.f(byteBuffer) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(MqttUtf8StringImpl mqttUtf8StringImpl) {
        return mqttUtf8StringImpl.j() + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i8, int i9) {
        return i8 == i9 ? 0 : 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i8) {
        return MqttVariableByteInteger.c(i8) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(int i8, int i9) {
        if (i8 == i9) {
            return 0;
        }
        return q(i8);
    }
}
