package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttBinaryData;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertyImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class Mqtt5MessageDecoderUtil {
    private Mqtt5MessageDecoderUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(boolean z7, String str, ByteBuf byteBuf) throws MqttDecoderException {
        if (!z7) {
            if (byteBuf.readableBytes() >= 1) {
                byte readByte = byteBuf.readByte();
                if (readByte == 0) {
                    return false;
                }
                if (readByte == 1) {
                    return true;
                }
                Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = Mqtt5DisconnectReasonCode.PROTOCOL_ERROR;
                throw new MqttDecoderException(mqtt5DisconnectReasonCode, "malformed boolean for " + str);
            }
            throw p();
        }
        throw q(str);
    }

    private static void b(String str, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        if (mqttDecoderContext.c()) {
            return;
        }
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = Mqtt5DisconnectReasonCode.PROTOCOL_ERROR;
        throw new MqttDecoderException(mqtt5DisconnectReasonCode, str + " must not be included if problem information is not requested");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ByteBuf byteBuf) throws MqttDecoderException {
        int a8 = MqttVariableByteInteger.a(byteBuf);
        if (a8 >= 0) {
            if (byteBuf.readableBytes() != a8) {
                if (byteBuf.readableBytes() < a8) {
                    throw MqttMessageDecoderUtil.g();
                }
                throw new MqttDecoderException("must not have a payload");
            }
            return;
        }
        throw p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer d(ByteBuffer byteBuffer, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        return f(byteBuffer, "auth data", byteBuf, mqttDecoderContext.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttUtf8StringImpl e(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuf byteBuf) throws MqttDecoderException {
        return m(mqttUtf8StringImpl, "auth method", byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer f(ByteBuffer byteBuffer, String str, ByteBuf byteBuf, boolean z7) throws MqttDecoderException {
        if (byteBuffer == null) {
            ByteBuffer a8 = MqttBinaryData.a(byteBuf, z7);
            if (a8 != null) {
                return a8;
            }
            throw new MqttDecoderException("malformed binary data for " + str);
        }
        throw q(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(ByteBuf byteBuf) throws MqttDecoderException {
        int a8 = MqttVariableByteInteger.a(byteBuf);
        if (a8 >= 0) {
            return a8;
        }
        throw new MqttDecoderException("malformed property identifier");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(ByteBuf byteBuf) throws MqttDecoderException {
        int a8 = MqttVariableByteInteger.a(byteBuf);
        if (a8 >= 0) {
            if (byteBuf.readableBytes() >= a8) {
                return a8;
            }
            throw MqttMessageDecoderUtil.g();
        }
        throw p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttUtf8StringImpl i(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuf byteBuf) throws MqttDecoderException {
        return m(mqttUtf8StringImpl, "reason string", byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttUtf8StringImpl j(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        b("reason string", mqttDecoderContext);
        return i(mqttUtf8StringImpl, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttUtf8StringImpl k(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuf byteBuf) throws MqttDecoderException {
        return m(mqttUtf8StringImpl, "server reference", byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long l(long j8, ByteBuf byteBuf) throws MqttDecoderException {
        return t(j8, -1L, "session expiry interval", byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttUtf8StringImpl m(MqttUtf8StringImpl mqttUtf8StringImpl, String str, ByteBuf byteBuf) throws MqttDecoderException {
        if (mqttUtf8StringImpl == null) {
            MqttUtf8StringImpl f8 = MqttUtf8StringImpl.f(byteBuf);
            if (f8 != null) {
                return f8;
            }
            throw MqttMessageDecoderUtil.f(str);
        }
        throw q(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableList.Builder<MqttUserPropertyImpl> n(ImmutableList.Builder<MqttUserPropertyImpl> builder, ByteBuf byteBuf) throws MqttDecoderException {
        MqttUserPropertyImpl c8 = MqttUserPropertyImpl.c(byteBuf);
        if (c8 != null) {
            if (builder == null) {
                builder = b.v();
            }
            builder.a(c8);
            return builder;
        }
        throw new MqttDecoderException("malformed user property");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableList.Builder<MqttUserPropertyImpl> o(ImmutableList.Builder<MqttUserPropertyImpl> builder, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        b("user property", mqttDecoderContext);
        return n(builder, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttDecoderException p() {
        return new MqttDecoderException("malformed properties length");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttDecoderException q(String str) {
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = Mqtt5DisconnectReasonCode.PROTOCOL_ERROR;
        return new MqttDecoderException(mqtt5DisconnectReasonCode, str + " must not be included more than once");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttDecoderException r() {
        return new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "must contain at least one reason code");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short s(boolean z7, String str, ByteBuf byteBuf) throws MqttDecoderException {
        if (!z7) {
            if (byteBuf.readableBytes() >= 1) {
                return byteBuf.readUnsignedByte();
            }
            throw p();
        }
        throw q(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long t(long j8, long j9, String str, ByteBuf byteBuf) throws MqttDecoderException {
        boolean z7;
        if (j8 != j9) {
            z7 = true;
        } else {
            z7 = false;
        }
        return u(z7, str, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long u(boolean z7, String str, ByteBuf byteBuf) throws MqttDecoderException {
        if (!z7) {
            if (byteBuf.readableBytes() >= 4) {
                return byteBuf.readUnsignedInt();
            }
            throw p();
        }
        throw q(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i8, int i9, String str, ByteBuf byteBuf) throws MqttDecoderException {
        boolean z7;
        if (i8 != i9) {
            z7 = true;
        } else {
            z7 = false;
        }
        return w(z7, str, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(boolean z7, String str, ByteBuf byteBuf) throws MqttDecoderException {
        if (!z7) {
            if (byteBuf.readableBytes() >= 2) {
                return byteBuf.readUnsignedShort();
            }
            throw p();
        }
        throw q(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttDecoderException x(int i8) {
        return new MqttDecoderException("wrong property with identifier " + i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MqttDecoderException y() {
        return new MqttDecoderException("wrong reason code");
    }
}
