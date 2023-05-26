package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.unsubscribe.MqttStatefulUnsubscribe;
import com.hivemq.client.internal.mqtt.message.unsubscribe.MqttUnsubscribe;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3UnsubscribeEncoder extends Mqtt3MessageEncoder<MqttStatefulUnsubscribe> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17948a = (Mqtt3MessageType.UNSUBSCRIBE.a() << 4) | 2;

    private void g(ByteBuf byteBuf, int i8) {
        byteBuf.writeByte(f17948a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void h(MqttStatefulUnsubscribe mqttStatefulUnsubscribe, ByteBuf byteBuf) {
        ImmutableList<MqttTopicFilterImpl> g8 = ((MqttUnsubscribe) mqttStatefulUnsubscribe.c()).g();
        for (int i8 = 0; i8 < g8.size(); i8++) {
            g8.get(i8).h(byteBuf);
        }
    }

    private void i(MqttStatefulUnsubscribe mqttStatefulUnsubscribe, ByteBuf byteBuf) {
        byteBuf.writeShort(mqttStatefulUnsubscribe.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: f */
    public void d(MqttStatefulUnsubscribe mqttStatefulUnsubscribe, ByteBuf byteBuf, int i8) {
        g(byteBuf, i8);
        i(mqttStatefulUnsubscribe, byteBuf);
        h(mqttStatefulUnsubscribe, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder
    /* renamed from: j */
    public int e(MqttStatefulUnsubscribe mqttStatefulUnsubscribe) {
        ImmutableList<MqttTopicFilterImpl> g8 = ((MqttUnsubscribe) mqttStatefulUnsubscribe.c()).g();
        int i8 = 2;
        for (int i9 = 0; i9 < g8.size(); i9++) {
            i8 += g8.get(i9).j();
        }
        return i8;
    }
}
