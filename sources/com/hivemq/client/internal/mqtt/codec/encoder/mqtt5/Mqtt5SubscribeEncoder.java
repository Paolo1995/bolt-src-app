package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttStatefulSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5SubscribeEncoder extends Mqtt5MessageWithUserPropertiesEncoder<MqttStatefulSubscribe> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17978a = (Mqtt5MessageType.SUBSCRIBE.c() << 4) | 2;

    private void n(ByteBuf byteBuf, int i8) {
        byteBuf.writeByte(f17978a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void o(MqttStatefulSubscribe mqttStatefulSubscribe, ByteBuf byteBuf) {
        ImmutableList<MqttSubscription> g8 = ((MqttSubscribe) mqttStatefulSubscribe.c()).g();
        for (int i8 = 0; i8 < g8.size(); i8++) {
            MqttSubscription mqttSubscription = g8.get(i8);
            mqttSubscription.g().h(byteBuf);
            byteBuf.writeByte(mqttSubscription.e());
        }
    }

    private void p(MqttStatefulSubscribe mqttStatefulSubscribe, ByteBuf byteBuf, int i8, int i9) {
        MqttVariableByteInteger.b(i8, byteBuf);
        Mqtt5MessageEncoderUtil.i(11, mqttStatefulSubscribe.e(), -1L, byteBuf);
        f(mqttStatefulSubscribe, byteBuf, i9);
    }

    private void q(MqttStatefulSubscribe mqttStatefulSubscribe, ByteBuf byteBuf, int i8, int i9) {
        byteBuf.writeShort(mqttStatefulSubscribe.a());
        p(mqttStatefulSubscribe, byteBuf, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: m */
    public void e(MqttStatefulSubscribe mqttStatefulSubscribe, ByteBuf byteBuf, int i8, int i9, int i10) {
        n(byteBuf, i8);
        q(mqttStatefulSubscribe, byteBuf, i9, i10);
        o(mqttStatefulSubscribe, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: r */
    public int h(MqttStatefulSubscribe mqttStatefulSubscribe) {
        return g(mqttStatefulSubscribe) + 0 + Mqtt5MessageEncoderUtil.r(mqttStatefulSubscribe.e(), -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: s */
    public int l(MqttStatefulSubscribe mqttStatefulSubscribe) {
        ImmutableList<MqttSubscription> g8 = ((MqttSubscribe) mqttStatefulSubscribe.c()).g();
        int i8 = 2;
        for (int i9 = 0; i9 < g8.size(); i9++) {
            i8 += g8.get(i9).g().j() + 1;
        }
        return i8;
    }
}
