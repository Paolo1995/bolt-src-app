package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoderContext;
import com.hivemq.client.internal.mqtt.datatypes.MqttBinaryData;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.internal.util.collections.ImmutableIntList;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.nio.ByteBuffer;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5PublishEncoder extends Mqtt5MessageWithUserPropertiesEncoder<MqttStatefulPublish> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17976a = Mqtt5MessageType.PUBLISH.c() << 4;

    private void o(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf, int i8) {
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
        byteBuf.writeByte(c8 | f17976a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void q(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf) {
        ByteBuffer n8 = ((MqttPublish) mqttStatefulPublish.c()).n();
        if (n8 != null && !n8.isDirect()) {
            byteBuf.writeBytes(n8.duplicate());
        }
    }

    private void r(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf, int i8, int i9) {
        MqttVariableByteInteger.b(i8, byteBuf);
        p((MqttPublish) mqttStatefulPublish.c(), byteBuf);
        f(mqttStatefulPublish, byteBuf, i9);
        Mqtt5MessageEncoderUtil.h(35, mqttStatefulPublish.f(), 0, byteBuf);
        ImmutableIntList e8 = mqttStatefulPublish.e();
        for (int i10 = 0; i10 < e8.size(); i10++) {
            Mqtt5MessageEncoderUtil.j(11, e8.get(i10), byteBuf);
        }
    }

    private void s(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf, int i8, int i9) {
        MqttPublish mqttPublish = (MqttPublish) mqttStatefulPublish.c();
        if (mqttStatefulPublish.f() != 0 && !mqttStatefulPublish.h()) {
            MqttBinaryData.e(byteBuf);
        } else {
            mqttPublish.q().h(byteBuf);
        }
        if (mqttPublish.j() != MqttQos.AT_MOST_ONCE) {
            byteBuf.writeShort(mqttStatefulPublish.a());
        }
        r(mqttStatefulPublish, byteBuf, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: m */
    public ByteBuf d(MqttStatefulPublish mqttStatefulPublish, MqttEncoderContext mqttEncoderContext, int i8, int i9, int i10, int i11) {
        ByteBuffer n8 = ((MqttPublish) mqttStatefulPublish.c()).n();
        if (n8 != null && n8.isDirect()) {
            int remaining = i8 - n8.remaining();
            ByteBuf ioBuffer = mqttEncoderContext.a().ioBuffer(remaining, remaining);
            e(mqttStatefulPublish, ioBuffer, i9, i10, i11);
            return Unpooled.wrappedUnmodifiableBuffer(ioBuffer, Unpooled.wrappedBuffer(n8));
        }
        ByteBuf ioBuffer2 = mqttEncoderContext.a().ioBuffer(i8, i8);
        e(mqttStatefulPublish, ioBuffer2, i9, i10, i11);
        return ioBuffer2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: n */
    public void e(MqttStatefulPublish mqttStatefulPublish, ByteBuf byteBuf, int i8, int i9, int i10) {
        o(mqttStatefulPublish, byteBuf, i8);
        s(mqttStatefulPublish, byteBuf, i9, i10);
        q(mqttStatefulPublish, byteBuf);
    }

    final void p(MqttPublish mqttPublish, ByteBuf byteBuf) {
        Mqtt5MessageEncoderUtil.c(2, mqttPublish.m(), Long.MAX_VALUE, byteBuf);
        Mqtt5MessageEncoderUtil.e(1, mqttPublish.o(), byteBuf);
        Mqtt5MessageEncoderUtil.d(3, mqttPublish.k(), byteBuf);
        Mqtt5MessageEncoderUtil.d(8, mqttPublish.p(), byteBuf);
        Mqtt5MessageEncoderUtil.f(9, mqttPublish.l(), byteBuf);
    }

    final int t(MqttPublish mqttPublish) {
        return Mqtt5MessageEncoderUtil.k(mqttPublish.m(), Long.MAX_VALUE) + 0 + Mqtt5MessageEncoderUtil.m(mqttPublish.o()) + Mqtt5MessageEncoderUtil.l(mqttPublish.k()) + Mqtt5MessageEncoderUtil.l(mqttPublish.p()) + Mqtt5MessageEncoderUtil.n(mqttPublish.l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: u */
    public int h(MqttStatefulPublish mqttStatefulPublish) {
        int t7 = t((MqttPublish) mqttStatefulPublish.c()) + 0 + g(mqttStatefulPublish) + Mqtt5MessageEncoderUtil.p(mqttStatefulPublish.f(), 0);
        ImmutableIntList e8 = mqttStatefulPublish.e();
        for (int i8 = 0; i8 < e8.size(); i8++) {
            t7 += Mqtt5MessageEncoderUtil.q(e8.get(i8));
        }
        return t7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: v */
    public int l(MqttStatefulPublish mqttStatefulPublish) {
        int j8;
        MqttPublish mqttPublish = (MqttPublish) mqttStatefulPublish.c();
        if (mqttStatefulPublish.f() != 0 && !mqttStatefulPublish.h()) {
            j8 = 2;
        } else {
            j8 = mqttPublish.q().j() + 0;
        }
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
