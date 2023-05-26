package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.MqttStatefulConnect;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3ConnectEncoder extends Mqtt3MessageEncoder<MqttStatefulConnect> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17932a = Mqtt3MessageType.CONNECT.a() << 4;

    private void g(ByteBuf byteBuf, int i8) {
        byteBuf.writeByte(f17932a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void h(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf) {
        mqttStatefulConnect.e().h(byteBuf);
        j(mqttStatefulConnect, byteBuf);
        MqttSimpleAuth i8 = mqttStatefulConnect.c().i();
        if (i8 != null) {
            MqttMessageEncoderUtil.a(i8.b(), byteBuf);
            MqttMessageEncoderUtil.b(i8.a(), byteBuf);
        }
    }

    private void i(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf) {
        MqttConnect c8 = mqttStatefulConnect.c();
        MqttUtf8StringImpl.f17997i.h(byteBuf);
        byteBuf.writeByte(4);
        MqttSimpleAuth i8 = c8.i();
        int i9 = 0;
        if (i8 != null) {
            if (i8.b() != null) {
                i9 = 128;
            }
            if (i8.a() != null) {
                i9 |= 64;
            }
        }
        c8.j();
        if (c8.m()) {
            i9 |= 2;
        }
        byteBuf.writeByte(i9);
        byteBuf.writeShort(c8.g());
    }

    private void j(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf) {
        mqttStatefulConnect.c().j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: f */
    public void d(MqttStatefulConnect mqttStatefulConnect, ByteBuf byteBuf, int i8) {
        g(byteBuf, i8);
        i(mqttStatefulConnect, byteBuf);
        h(mqttStatefulConnect, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: k */
    public int e(MqttStatefulConnect mqttStatefulConnect) {
        MqttConnect c8 = mqttStatefulConnect.c();
        int j8 = mqttStatefulConnect.e().j() + 10;
        MqttSimpleAuth i8 = c8.i();
        if (i8 != null) {
            j8 = j8 + MqttMessageEncoderUtil.f(i8.b()) + MqttMessageEncoderUtil.g(i8.a());
        }
        c8.j();
        return j8;
    }
}
