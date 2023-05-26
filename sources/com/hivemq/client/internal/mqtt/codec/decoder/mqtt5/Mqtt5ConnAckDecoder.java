package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttClientIdentifierImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertyImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.auth.MqttEnhancedAuth;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAckRestrictions;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAckReturnCode;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAckReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAckRestrictions;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import javax.inject.Singleton;
import okhttp3.internal.http2.Settings;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5ConnAckDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttConnAck a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        boolean z7;
        MqttEnhancedAuth mqttEnhancedAuth;
        MqttUtf8StringImpl mqttUtf8StringImpl;
        MqttUtf8StringImpl mqttUtf8StringImpl2;
        MqttConnAckRestrictions mqttConnAckRestrictions;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode;
        ImmutableList.Builder<MqttUserPropertyImpl> builder;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        MqttMessageDecoderUtil.a(0, i8);
        if (byteBuf.readableBytes() < 3) {
            return c(byteBuf);
        }
        short readUnsignedByte = byteBuf.readUnsignedByte();
        if ((readUnsignedByte & 254) == 0) {
            if ((readUnsignedByte & 1) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Mqtt5ConnAckReasonCode c8 = Mqtt5ConnAckReasonCode.c(byteBuf.readUnsignedByte());
            if (c8 != null) {
                if (c8 != Mqtt5ConnAckReasonCode.SUCCESS && z7) {
                    throw new MqttDecoderException("session present must be 0 if reason code is not SUCCESS");
                }
                Mqtt5MessageDecoderUtil.c(byteBuf);
                long j8 = -1;
                MqttQos mqttQos = Mqtt5ConnAckRestrictions.f18844a;
                MqttUtf8StringImpl mqttUtf8StringImpl3 = null;
                int i9 = -1;
                boolean z23 = false;
                MqttUtf8StringImpl mqttUtf8StringImpl4 = null;
                boolean z24 = false;
                boolean z25 = false;
                ByteBuffer byteBuffer = null;
                MqttUtf8StringImpl mqttUtf8StringImpl5 = null;
                int i10 = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                MqttUtf8StringImpl mqttUtf8StringImpl6 = null;
                int i11 = 268435460;
                int i12 = 0;
                boolean z26 = true;
                boolean z27 = true;
                boolean z28 = true;
                MqttClientIdentifierImpl mqttClientIdentifierImpl = null;
                boolean z29 = true;
                boolean z30 = false;
                boolean z31 = false;
                boolean z32 = false;
                ImmutableList.Builder<MqttUserPropertyImpl> builder2 = null;
                boolean z33 = false;
                boolean z34 = false;
                boolean z35 = false;
                while (byteBuf.isReadable()) {
                    int g8 = Mqtt5MessageDecoderUtil.g(byteBuf);
                    switch (g8) {
                        case 17:
                            z8 = z23;
                            z9 = z7;
                            z10 = z32;
                            z11 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            z12 = z31;
                            j8 = Mqtt5MessageDecoderUtil.l(j8, byteBuf);
                            z13 = z11;
                            z32 = z10;
                            break;
                        case 18:
                            z8 = z23;
                            z9 = z7;
                            z10 = z32;
                            z11 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            z12 = z31;
                            if (mqttClientIdentifierImpl == null) {
                                mqttClientIdentifierImpl = MqttClientIdentifierImpl.q(byteBuf);
                                if (mqttClientIdentifierImpl == null) {
                                    throw MqttMessageDecoderUtil.f("client identifier");
                                }
                                z13 = z11;
                                z32 = z10;
                                break;
                            } else {
                                throw Mqtt5MessageDecoderUtil.q("client identifier");
                            }
                        case 19:
                            z8 = z23;
                            z9 = z7;
                            z10 = z32;
                            z11 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            z12 = z31;
                            i9 = Mqtt5MessageDecoderUtil.v(i9, -1, "server keep alive", byteBuf);
                            z13 = z11;
                            z32 = z10;
                            break;
                        case 20:
                        case 23:
                        case 24:
                        case 25:
                        case 27:
                        case 29:
                        case 30:
                        case 32:
                        case 35:
                        default:
                            throw Mqtt5MessageDecoderUtil.x(g8);
                        case 21:
                            z8 = z23;
                            z9 = z7;
                            z14 = z31;
                            z10 = z32;
                            z15 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            mqttUtf8StringImpl3 = Mqtt5MessageDecoderUtil.e(mqttUtf8StringImpl3, byteBuf);
                            z12 = z14;
                            z13 = z15;
                            z32 = z10;
                            break;
                        case 22:
                            z8 = z23;
                            z9 = z7;
                            z14 = z31;
                            z10 = z32;
                            z15 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            byteBuffer = Mqtt5MessageDecoderUtil.d(byteBuffer, byteBuf, mqttDecoderContext);
                            z12 = z14;
                            z13 = z15;
                            z32 = z10;
                            break;
                        case 26:
                            z8 = z23;
                            z9 = z7;
                            z14 = z31;
                            z10 = z32;
                            z15 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            if (mqttDecoderContext.d()) {
                                mqttUtf8StringImpl4 = Mqtt5MessageDecoderUtil.m(mqttUtf8StringImpl4, "response information", byteBuf);
                                z12 = z14;
                                z13 = z15;
                                z32 = z10;
                                break;
                            } else {
                                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "response information must not be included if it was not requested");
                            }
                        case 28:
                            z8 = z23;
                            z9 = z7;
                            z14 = z31;
                            z10 = z32;
                            z15 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            mqttUtf8StringImpl6 = Mqtt5MessageDecoderUtil.k(mqttUtf8StringImpl6, byteBuf);
                            z12 = z14;
                            z13 = z15;
                            z32 = z10;
                            break;
                        case 31:
                            z8 = z23;
                            z9 = z7;
                            z14 = z31;
                            z10 = z32;
                            z15 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            mqttUtf8StringImpl5 = Mqtt5MessageDecoderUtil.i(mqttUtf8StringImpl5, byteBuf);
                            z12 = z14;
                            z13 = z15;
                            z32 = z10;
                            break;
                        case 33:
                            z8 = z23;
                            z9 = z7;
                            boolean z36 = z31;
                            z10 = z32;
                            boolean z37 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            i10 = Mqtt5MessageDecoderUtil.w(z25, "receive maximum", byteBuf);
                            if (i10 != 0) {
                                if (i10 != 65535) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                z30 |= z16;
                                z12 = z36;
                                z13 = z37;
                                z25 = true;
                                z32 = z10;
                                break;
                            } else {
                                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "receive maximum must not be 0");
                            }
                        case 34:
                            z8 = z23;
                            z9 = z7;
                            boolean z38 = z31;
                            z10 = z32;
                            boolean z39 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            i12 = Mqtt5MessageDecoderUtil.w(z24, "receive maximum", byteBuf);
                            if (i12 != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            z30 |= z17;
                            z12 = z38;
                            z13 = z39;
                            z24 = true;
                            z32 = z10;
                            break;
                        case 36:
                            z8 = z23;
                            z9 = z7;
                            z10 = z32;
                            boolean z40 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            short s7 = Mqtt5MessageDecoderUtil.s(z31, "maximum Qos", byteBuf);
                            if (s7 != 0 && s7 != 1) {
                                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "wrong maximum Qos");
                            }
                            MqttQos a8 = MqttQos.a(s7);
                            if (a8 != Mqtt5ConnAckRestrictions.f18844a) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            z30 |= z18;
                            mqttQos = a8;
                            z13 = z40;
                            z12 = true;
                            z32 = z10;
                            break;
                        case 37:
                            z8 = z23;
                            z9 = z7;
                            boolean z41 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            boolean a9 = Mqtt5MessageDecoderUtil.a(z32, "retain available", byteBuf);
                            if (!a9) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            z30 |= z19;
                            z26 = a9;
                            z13 = z41;
                            z12 = z31;
                            z32 = true;
                            break;
                        case 38:
                            z8 = z23;
                            z9 = z7;
                            boolean z42 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            z13 = z42;
                            builder = Mqtt5MessageDecoderUtil.n(builder2, byteBuf);
                            z12 = z31;
                            break;
                        case 39:
                            z8 = z23;
                            z9 = z7;
                            boolean z43 = z33;
                            mqtt5ConnAckReasonCode = c8;
                            long u7 = Mqtt5MessageDecoderUtil.u(z43, "maximum packet size", byteBuf);
                            if (u7 != 0) {
                                if (u7 < 268435460) {
                                    i11 = (int) u7;
                                    builder = builder2;
                                    z30 = true;
                                } else {
                                    builder = builder2;
                                }
                                z13 = true;
                                z12 = z31;
                                break;
                            } else {
                                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "maximum packet size must not be 0");
                            }
                        case 40:
                            z8 = z23;
                            z9 = z7;
                            boolean a10 = Mqtt5MessageDecoderUtil.a(z34, "wildcard subscription available", byteBuf);
                            if (!a10) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            z30 |= z20;
                            z27 = a10;
                            z13 = z33;
                            z34 = true;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            z12 = z31;
                            break;
                        case 41:
                            z8 = z23;
                            z9 = z7;
                            boolean a11 = Mqtt5MessageDecoderUtil.a(z35, "subscription identifier available", byteBuf);
                            if (!a11) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            z30 |= z21;
                            z29 = a11;
                            z13 = z33;
                            z35 = true;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            z12 = z31;
                            break;
                        case 42:
                            boolean a12 = Mqtt5MessageDecoderUtil.a(z23, "shared subscription available", byteBuf);
                            if (!a12) {
                                z22 = true;
                            } else {
                                z22 = false;
                            }
                            z30 |= z22;
                            z28 = a12;
                            z9 = z7;
                            z13 = z33;
                            z8 = true;
                            mqtt5ConnAckReasonCode = c8;
                            builder = builder2;
                            z12 = z31;
                            break;
                    }
                    z31 = z12;
                    z23 = z8;
                    z7 = z9;
                    builder2 = builder;
                    c8 = mqtt5ConnAckReasonCode;
                    z33 = z13;
                }
                Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode2 = c8;
                boolean z44 = z7;
                ImmutableList.Builder<MqttUserPropertyImpl> builder3 = builder2;
                if (mqttUtf8StringImpl3 != null) {
                    mqttEnhancedAuth = new MqttEnhancedAuth(mqttUtf8StringImpl3, byteBuffer);
                } else if (byteBuffer == null) {
                    mqttEnhancedAuth = null;
                } else {
                    throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "auth data must not be included if auth method is absent");
                }
                MqttConnAckRestrictions mqttConnAckRestrictions2 = MqttConnAckRestrictions.f18517j;
                if (z30) {
                    mqttUtf8StringImpl = mqttUtf8StringImpl5;
                    mqttUtf8StringImpl2 = mqttUtf8StringImpl6;
                    mqttConnAckRestrictions = new MqttConnAckRestrictions(i10, i11, i12, mqttQos, z26, z27, z28, z29);
                } else {
                    mqttUtf8StringImpl = mqttUtf8StringImpl5;
                    mqttUtf8StringImpl2 = mqttUtf8StringImpl6;
                    mqttConnAckRestrictions = mqttConnAckRestrictions2;
                }
                return new MqttConnAck(mqtt5ConnAckReasonCode2, z44, j8, i9, mqttClientIdentifierImpl, mqttEnhancedAuth, mqttConnAckRestrictions, mqttUtf8StringImpl4, mqttUtf8StringImpl2, mqttUtf8StringImpl, MqttUserPropertiesImpl.b(builder3));
            }
            throw Mqtt5MessageDecoderUtil.y();
        }
        throw new MqttDecoderException("wrong CONNACK flags, bits 7-1 must be 0");
    }

    public MqttConnAck c(ByteBuf byteBuf) throws MqttDecoderException {
        if (byteBuf.readableBytes() == 2) {
            byteBuf.readUnsignedByte();
            if (Mqtt3ConnAckReturnCode.a(byteBuf.readUnsignedByte()) == Mqtt3ConnAckReturnCode.UNSUPPORTED_PROTOCOL_VERSION) {
                return new MqttConnAck(Mqtt5ConnAckReasonCode.UNSUPPORTED_PROTOCOL_VERSION, false, -1L, -1, null, null, MqttConnAckRestrictions.f18517j, null, null, null, MqttUserPropertiesImpl.f17992c);
            }
        }
        throw MqttMessageDecoderUtil.g();
    }
}
