package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttStatefulSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3SubscribeEncoder extends Mqtt3MessageEncoder<MqttStatefulSubscribe> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17946a = (Mqtt3MessageType.SUBSCRIBE.a() << 4) | 2;

    private void g(ByteBuf byteBuf, int i8) {
        byteBuf.writeByte(f17946a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void h(MqttStatefulSubscribe mqttStatefulSubscribe, ByteBuf byteBuf) {
        ImmutableList<MqttSubscription> g8 = ((MqttSubscribe) mqttStatefulSubscribe.c()).g();
        for (int i8 = 0; i8 < g8.size(); i8++) {
            MqttSubscription mqttSubscription = g8.get(i8);
            mqttSubscription.g().h(byteBuf);
            byteBuf.writeByte(mqttSubscription.f().c());
        }
    }

    private void i(MqttStatefulSubscribe mqttStatefulSubscribe, ByteBuf byteBuf) {
        byteBuf.writeShort(mqttStatefulSubscribe.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: f */
    public void d(MqttStatefulSubscribe mqttStatefulSubscribe, ByteBuf byteBuf, int i8) {
        g(byteBuf, i8);
        i(mqttStatefulSubscribe, byteBuf);
        h(mqttStatefulSubscribe, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: j */
    public int e(MqttStatefulSubscribe mqttStatefulSubscribe) {
        ImmutableList<MqttSubscription> g8 = ((MqttSubscribe) mqttStatefulSubscribe.c()).g();
        int i8 = 2;
        for (int i9 = 0; i9 < g8.size(); i9++) {
            i8 += g8.get(i9).g().j() + 1;
        }
        return i8;
    }
}
