package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoderContext;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import com.hivemq.client.internal.mqtt.message.MqttMessage.WithUserProperties;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import io.netty.buffer.ByteBuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class Mqtt5MessageWithUserPropertiesEncoder<M extends MqttMessage.WithUserProperties> extends MqttMessageEncoder<M> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class WithReason<M extends MqttMessageWithUserProperties.WithReason> extends Mqtt5MessageWithUserPropertiesEncoder<M> {

        /* loaded from: classes3.dex */
        static abstract class WithOmissibleCode<M extends MqttMessageWithUserProperties.WithReason.WithCode<R>, R extends Mqtt5ReasonCode> extends WithReason<M> {

            /* loaded from: classes3.dex */
            static abstract class WithId<M extends MqttMessageWithUserProperties.WithReason.WithCode.WithId<R>, R extends Mqtt5ReasonCode> extends WithOmissibleCode<M, R> {
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
                /* renamed from: C */
                public int r(M m8) {
                    return 2;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
                /* renamed from: D */
                public void u(M m8, ByteBuf byteBuf) {
                    byteBuf.writeShort(m8.a());
                }

                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder, com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
                protected /* bridge */ /* synthetic */ ByteBuf b(MqttMessage mqttMessage, MqttEncoderContext mqttEncoderContext) {
                    return super.b((MqttMessageWithUserProperties.WithReason.WithCode.WithId) mqttMessage, mqttEncoderContext);
                }

                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
                protected /* bridge */ /* synthetic */ void e(MqttMessage.WithUserProperties withUserProperties, ByteBuf byteBuf, int i8, int i9, int i10) {
                    super.e((MqttMessageWithUserProperties.WithReason.WithCode.WithId) withUserProperties, byteBuf, i8, i9, i10);
                }

                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
                /* bridge */ /* synthetic */ int h(MqttMessage.WithUserProperties withUserProperties) {
                    return super.h((MqttMessageWithUserProperties.WithReason.WithCode.WithId) withUserProperties);
                }

                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
                /* bridge */ /* synthetic */ int i(MqttMessage.WithUserProperties withUserProperties, int i8, int i9) {
                    return super.i((MqttMessageWithUserProperties.WithReason.WithCode.WithId) withUserProperties, i8, i9);
                }

                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
                /* bridge */ /* synthetic */ int j(MqttMessage.WithUserProperties withUserProperties, int i8) {
                    return super.j((MqttMessageWithUserProperties.WithReason.WithCode.WithId) withUserProperties, i8);
                }

                @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
                /* bridge */ /* synthetic */ int l(MqttMessage.WithUserProperties withUserProperties) {
                    return super.l((MqttMessageWithUserProperties.WithReason.WithCode.WithId) withUserProperties);
                }
            }

            private void v(ByteBuf byteBuf, int i8) {
                byteBuf.writeByte(y());
                MqttVariableByteInteger.b(i8, byteBuf);
            }

            private void w(M m8, ByteBuf byteBuf, int i8, int i9) {
                u(m8, byteBuf);
                Mqtt5ReasonCode h8 = m8.h();
                if (i8 == 0) {
                    if (h8 != x()) {
                        byteBuf.writeByte(h8.getCode());
                        return;
                    }
                    return;
                }
                byteBuf.writeByte(h8.getCode());
                MqttVariableByteInteger.b(i8, byteBuf);
                t(m8, byteBuf);
                m(m8, byteBuf, i9);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
            /* renamed from: A */
            public final int j(M m8, int i8) {
                if (i8 == 0) {
                    if (m8.h() == x()) {
                        return -1;
                    }
                    return 0;
                }
                return super.j(m8, i8);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
            /* renamed from: B */
            public final int l(M m8) {
                return r(m8) + 1;
            }

            @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder, com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
            protected /* bridge */ /* synthetic */ ByteBuf b(MqttMessage mqttMessage, MqttEncoderContext mqttEncoderContext) {
                return super.b((MqttMessageWithUserProperties.WithReason.WithCode) mqttMessage, mqttEncoderContext);
            }

            @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason, com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
            /* bridge */ /* synthetic */ int i(MqttMessage.WithUserProperties withUserProperties, int i8, int i9) {
                return super.i((MqttMessageWithUserProperties.WithReason.WithCode) withUserProperties, i8, i9);
            }

            int q(M m8) {
                return 0;
            }

            int r(M m8) {
                return 0;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
            /* renamed from: s */
            public void e(M m8, ByteBuf byteBuf, int i8, int i9, int i10) {
                v(byteBuf, i8);
                w(m8, byteBuf, i9, i10);
            }

            void t(M m8, ByteBuf byteBuf) {
            }

            void u(M m8, ByteBuf byteBuf) {
            }

            abstract R x();

            abstract int y();

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
            /* renamed from: z */
            public final int h(M m8) {
                return n(m8) + q(m8);
            }
        }

        private int p(M m8) {
            return Mqtt5MessageEncoderUtil.l(m8.f());
        }

        @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder, com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
        protected /* bridge */ /* synthetic */ ByteBuf b(MqttMessage mqttMessage, MqttEncoderContext mqttEncoderContext) {
            return super.b((MqttMessageWithUserProperties.WithReason) mqttMessage, mqttEncoderContext);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void m(M m8, ByteBuf byteBuf, int i8) {
            if (i8 == 0) {
                Mqtt5MessageEncoderUtil.d(31, m8.f(), byteBuf);
            }
            if (i8 <= 1) {
                m8.b().d(byteBuf);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int n(M m8) {
            return p(m8) + m8.b().e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
        /* renamed from: o */
        public int i(M m8, int i8, int i9) {
            int p8;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 != 2) {
                        return -1;
                    }
                    p8 = m8.b().e();
                } else {
                    p8 = p(m8);
                }
                return i8 - p8;
            }
            return i8;
        }
    }

    private int k(M m8, int i8, int i9) {
        return i8 + j(m8, i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
    /* renamed from: c */
    public ByteBuf b(M m8, MqttEncoderContext mqttEncoderContext) {
        int h8 = h(m8);
        int l8 = l(m8);
        int k8 = k(m8, l8, h8);
        int i8 = h8;
        int i9 = k8;
        int d8 = MqttMessageEncoderUtil.d(k8);
        int i10 = 0;
        while (d8 > mqttEncoderContext.b()) {
            i10++;
            i8 = i(m8, i8, i10);
            if (i8 >= 0) {
                i9 = k(m8, l8, i8);
                d8 = MqttMessageEncoderUtil.d(i9);
            } else {
                throw MqttMessageEncoderUtil.e(m8, d8, mqttEncoderContext.b());
            }
        }
        return d(m8, mqttEncoderContext, d8, i9, i8, i10);
    }

    ByteBuf d(M m8, MqttEncoderContext mqttEncoderContext, int i8, int i9, int i10, int i11) {
        ByteBuf ioBuffer = mqttEncoderContext.a().ioBuffer(i8, i8);
        e(m8, ioBuffer, i9, i10, i11);
        return ioBuffer;
    }

    abstract void e(M m8, ByteBuf byteBuf, int i8, int i9, int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(M m8, ByteBuf byteBuf, int i8) {
        if (i8 == 0) {
            m8.b().d(byteBuf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(M m8) {
        return m8.b().e();
    }

    abstract int h(M m8);

    int i(M m8, int i8, int i9) {
        if (i9 != 0) {
            if (i9 != 1) {
                return -1;
            }
            return i8 - m8.b().e();
        }
        return i8;
    }

    int j(M m8, int i8) {
        return MqttMessageEncoderUtil.c(i8);
    }

    abstract int l(M m8);
}
