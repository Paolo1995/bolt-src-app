package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoderContext;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoderUtil;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
abstract class Mqtt3MessageEncoder<M extends MqttMessage> extends MqttMessageEncoder<M> {

    /* loaded from: classes3.dex */
    static abstract class Mqtt3MessageWithIdEncoder<M extends MqttMessage.WithId> extends MqttMessageEncoder<M> {
        private void d(M m8, ByteBuf byteBuf) {
            e(byteBuf);
            f(m8, byteBuf);
        }

        private void e(ByteBuf byteBuf) {
            byteBuf.writeByte(g());
            byteBuf.writeByte(2);
        }

        private void f(M m8, ByteBuf byteBuf) {
            byteBuf.writeShort(m8.a());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
        /* renamed from: c */
        public ByteBuf b(M m8, MqttEncoderContext mqttEncoderContext) {
            if (4 <= mqttEncoderContext.b()) {
                ByteBuf ioBuffer = mqttEncoderContext.a().ioBuffer(4, 4);
                d(m8, ioBuffer);
                return ioBuffer;
            }
            throw MqttMessageEncoderUtil.e(m8, 4, mqttEncoderContext.b());
        }

        abstract int g();
    }

    @Override // com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
    protected ByteBuf b(M m8, MqttEncoderContext mqttEncoderContext) {
        int e8 = e(m8);
        int d8 = MqttMessageEncoderUtil.d(e8);
        if (d8 <= mqttEncoderContext.b()) {
            return c(m8, mqttEncoderContext, d8, e8);
        }
        throw MqttMessageEncoderUtil.e(m8, d8, mqttEncoderContext.b());
    }

    ByteBuf c(M m8, MqttEncoderContext mqttEncoderContext, int i8, int i9) {
        ByteBuf ioBuffer = mqttEncoderContext.a().ioBuffer(i8, i8);
        d(m8, ioBuffer, i9);
        return ioBuffer;
    }

    abstract void d(M m8, ByteBuf byteBuf, int i8);

    abstract int e(M m8);
}
