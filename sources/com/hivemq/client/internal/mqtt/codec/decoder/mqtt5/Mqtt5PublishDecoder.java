package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttBinaryData;
import com.hivemq.client.internal.mqtt.datatypes.MqttTopicImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertyImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.internal.util.ByteBufferUtil;
import com.hivemq.client.internal.util.Utf8Util;
import com.hivemq.client.internal.util.collections.ImmutableIntList;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.a;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PayloadFormatIndicator;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5PublishDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttStatefulPublish a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        boolean z7;
        boolean z8;
        MqttTopicImpl mqttTopicImpl;
        ByteBuffer byteBuffer;
        ImmutableIntList b8;
        MqttUtf8StringImpl mqttUtf8StringImpl;
        ByteBuffer byteBuffer2;
        int i9;
        boolean z9;
        ImmutableIntList.Builder builder;
        int i10 = 1;
        if ((i8 & 8) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        MqttQos d8 = MqttMessageDecoderUtil.d(i8, z7);
        if ((i8 & 1) != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (byteBuf.readableBytes() >= 3) {
            byte[] b9 = MqttBinaryData.b(byteBuf);
            if (b9 != null) {
                if (b9.length != 0) {
                    MqttTopicImpl v7 = MqttTopicImpl.v(b9);
                    if (v7 != null) {
                        mqttTopicImpl = v7;
                    } else {
                        throw MqttMessageDecoderUtil.e();
                    }
                } else {
                    mqttTopicImpl = null;
                }
                int c8 = MqttMessageDecoderUtil.c(d8, byteBuf);
                int h8 = Mqtt5MessageDecoderUtil.h(byteBuf);
                long j8 = Long.MAX_VALUE;
                int readerIndex = byteBuf.readerIndex();
                MqttUtf8StringImpl mqttUtf8StringImpl2 = null;
                ByteBuffer byteBuffer3 = null;
                Mqtt5PayloadFormatIndicator mqtt5PayloadFormatIndicator = null;
                ImmutableList.Builder<MqttUserPropertyImpl> builder2 = null;
                int i11 = 0;
                MqttTopicImpl mqttTopicImpl2 = null;
                ImmutableIntList.Builder builder3 = null;
                while (true) {
                    int readerIndex2 = byteBuf.readerIndex() - readerIndex;
                    if (readerIndex2 < h8) {
                        int g8 = Mqtt5MessageDecoderUtil.g(byteBuf);
                        if (g8 != i10) {
                            if (g8 != 2) {
                                if (g8 != 3) {
                                    if (g8 != 8) {
                                        if (g8 != 9) {
                                            if (g8 != 11) {
                                                if (g8 != 35) {
                                                    if (g8 == 38) {
                                                        builder2 = Mqtt5MessageDecoderUtil.n(builder2, byteBuf);
                                                    } else {
                                                        throw Mqtt5MessageDecoderUtil.x(g8);
                                                    }
                                                } else {
                                                    i11 = Mqtt5MessageDecoderUtil.v(i11, 0, "topic alias", byteBuf);
                                                    if (i11 == 0) {
                                                        throw new MqttDecoderException(Mqtt5DisconnectReasonCode.TOPIC_ALIAS_INVALID, "topic alias must not be 0");
                                                    }
                                                }
                                            } else {
                                                if (builder3 == null) {
                                                    builder = a.a();
                                                } else {
                                                    builder = builder3;
                                                }
                                                int a8 = MqttVariableByteInteger.a(byteBuf);
                                                if (a8 >= 0) {
                                                    if (a8 != 0) {
                                                        builder.a(a8);
                                                        builder3 = builder;
                                                    } else {
                                                        throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "subscription identifier must not be 0");
                                                    }
                                                } else {
                                                    throw new MqttDecoderException("malformed subscription identifier");
                                                }
                                            }
                                        } else {
                                            byteBuffer3 = Mqtt5MessageDecoderUtil.f(byteBuffer3, "correlation data", byteBuf, mqttDecoderContext.f());
                                        }
                                    } else if (mqttTopicImpl2 == null) {
                                        mqttTopicImpl2 = MqttTopicImpl.s(byteBuf);
                                        if (mqttTopicImpl2 == null) {
                                            throw new MqttDecoderException(Mqtt5DisconnectReasonCode.TOPIC_NAME_INVALID, "malformed response topic");
                                        }
                                    } else {
                                        throw Mqtt5MessageDecoderUtil.q("response topic");
                                    }
                                } else {
                                    mqttUtf8StringImpl2 = Mqtt5MessageDecoderUtil.m(mqttUtf8StringImpl2, "content type", byteBuf);
                                }
                                i9 = h8;
                                h8 = i9;
                                i10 = 1;
                            } else {
                                mqttUtf8StringImpl = mqttUtf8StringImpl2;
                                byteBuffer2 = byteBuffer3;
                                i9 = h8;
                                j8 = Mqtt5MessageDecoderUtil.t(j8, Long.MAX_VALUE, "message expiry interval", byteBuf);
                                mqtt5PayloadFormatIndicator = mqtt5PayloadFormatIndicator;
                            }
                        } else {
                            mqttUtf8StringImpl = mqttUtf8StringImpl2;
                            byteBuffer2 = byteBuffer3;
                            i9 = h8;
                            if (mqtt5PayloadFormatIndicator != null) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            short s7 = Mqtt5MessageDecoderUtil.s(z9, "payload format indicator", byteBuf);
                            mqtt5PayloadFormatIndicator = Mqtt5PayloadFormatIndicator.a(s7);
                            if (mqtt5PayloadFormatIndicator == null) {
                                throw new MqttDecoderException("wrong payload format indicator: " + ((int) s7));
                            }
                        }
                        mqttUtf8StringImpl2 = mqttUtf8StringImpl;
                        byteBuffer3 = byteBuffer2;
                        h8 = i9;
                        i10 = 1;
                    } else {
                        MqttUtf8StringImpl mqttUtf8StringImpl3 = mqttUtf8StringImpl2;
                        ByteBuffer byteBuffer4 = byteBuffer3;
                        if (readerIndex2 == h8) {
                            if (i11 != 0) {
                                MqttTopicImpl[] b10 = mqttDecoderContext.b();
                                if (b10 != null && i11 <= b10.length) {
                                    if (mqttTopicImpl == null) {
                                        mqttTopicImpl = b10[i11 - 1];
                                        if (mqttTopicImpl == null) {
                                            throw new MqttDecoderException(Mqtt5DisconnectReasonCode.TOPIC_ALIAS_INVALID, "topic alias has no mapping");
                                        }
                                    } else {
                                        b10[i11 - 1] = mqttTopicImpl;
                                        i11 |= 65536;
                                    }
                                } else {
                                    throw new MqttDecoderException(Mqtt5DisconnectReasonCode.TOPIC_ALIAS_INVALID, "topic alias must not exceed topic alias maximum");
                                }
                            } else if (mqttTopicImpl == null) {
                                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "topic alias must be present if topic name is zero length");
                            }
                            int i12 = i11;
                            MqttTopicImpl mqttTopicImpl3 = mqttTopicImpl;
                            int readableBytes = byteBuf.readableBytes();
                            if (readableBytes > 0) {
                                ByteBuffer a9 = ByteBufferUtil.a(readableBytes, mqttDecoderContext.g());
                                byteBuf.readBytes(a9);
                                a9.position(0);
                                if (mqtt5PayloadFormatIndicator == Mqtt5PayloadFormatIndicator.UTF_8 && mqttDecoderContext.h() && Utf8Util.b(ByteBufferUtil.c(a9)) != 0) {
                                    throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PAYLOAD_FORMAT_INVALID, "payload is not valid UTF-8");
                                }
                                byteBuffer = a9;
                            } else {
                                byteBuffer = null;
                            }
                            MqttPublish mqttPublish = new MqttPublish(mqttTopicImpl3, byteBuffer, d8, z8, j8, mqtt5PayloadFormatIndicator, mqttUtf8StringImpl3, mqttTopicImpl2, byteBuffer4, MqttUserPropertiesImpl.b(builder2), null);
                            if (builder3 == null) {
                                b8 = MqttStatefulPublish.f18564g;
                            } else {
                                b8 = builder3.b();
                            }
                            return mqttPublish.g(c8, z7, i12, b8);
                        }
                        throw Mqtt5MessageDecoderUtil.p();
                    }
                }
            } else {
                throw MqttMessageDecoderUtil.e();
            }
        } else {
            throw MqttMessageDecoderUtil.g();
        }
    }
}
