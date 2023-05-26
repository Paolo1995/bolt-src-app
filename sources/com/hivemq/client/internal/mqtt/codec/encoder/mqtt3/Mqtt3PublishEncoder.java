package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoderContext;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.nio.ByteBuffer;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3PublishEncoder extends Mqtt3MessageEncoder<MqttStatefulPublish> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17944a = Mqtt3MessageType.PUBLISH.a() << 4;

    private void h(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf, int i8) {
        int i9;
        MqttPublish mqttPublish = (MqttPublish) mqttStatefulPublish.c();
        if (mqttStatefulPublish.g()) {
            i9 = 8;
        } else {
            i9 = 0;
        }
        int c8 = i9 | (mqttPublish.j().c() << 1);
        if (mqttPublish.r()) {
            c8 |= 1;
        }
        byteBuf.writeByte(c8 | f17944a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void i(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf) {
        ByteBuffer n8 = ((MqttPublish) mqttStatefulPublish.c()).n();
        if (n8 != null && !n8.isDirect()) {
            byteBuf.writeBytes(n8.duplicate());
        }
    }

    private void j(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf) {
        MqttPublish mqttPublish = (MqttPublish) mqttStatefulPublish.c();
        mqttPublish.q().h(byteBuf);
        if (mqttPublish.j() != MqttQos.AT_MOST_ONCE) {
            byteBuf.writeShort(mqttStatefulPublish.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: f */
    public ByteBuf c(MqttStatefulPublish mqttStatefulPublish, MqttEncoderContext mqttEncoderContext, int i8, int i9) {
        ByteBuffer n8 = ((MqttPublish) mqttStatefulPublish.c()).n();
        if (n8 != null && n8.isDirect()) {
            int remaining = i8 - n8.remaining();
            ByteBuf ioBuffer = mqttEncoderContext.a().ioBuffer(remaining, remaining);
            d(mqttStatefulPublish, ioBuffer, i9);
            return Unpooled.wrappedUnmodifiableBuffer(ioBuffer, Unpooled.wrappedBuffer(n8));
        }
        ByteBuf ioBuffer2 = mqttEncoderContext.a().ioBuffer(i8, i8);
        d(mqttStatefulPublish, ioBuffer2, i9);
        return ioBuffer2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: g */
    public void d(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf, int i8) {
        h(mqttStatefulPublish, byteBuf, i8);
        j(mqttStatefulPublish, byteBuf);
        i(mqttStatefulPublish, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: k */
    public int e(MqttStatefulPublish mqttStatefulPublish) {
        MqttPublish mqttPublish = (MqttPublish) mqttStatefulPublish.c();
        int j8 = mqttPublish.q().j() + 0;
        if (mqttPublish.j() != MqttQos.AT_MOST_ONCE) {
            j8 += 2;
        }
        ByteBuffer n8 = mqttPublish.n();
        if (n8 != null) {
            return j8 + n8.remaining();
        }
        return j8;
    }
}
