package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.unsubscribe.MqttStatefulUnsubscribe;
import com.hivemq.client.internal.mqtt.message.unsubscribe.MqttUnsubscribe;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5UnsubscribeEncoder extends Mqtt5MessageWithUserPropertiesEncoder<MqttStatefulUnsubscribe> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17980a = (Mqtt5MessageType.UNSUBSCRIBE.c() << 4) | 2;

    private void n(ByteBuf byteBuf, int i8) {
        byteBuf.writeByte(f17980a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void o(MqttStatefulUnsubscribe mqttStatefulUnsubscribe, ByteBuf byteBuf) {
        ImmutableList<MqttTopicFilterImpl> g8 = ((MqttUnsubscribe) mqttStatefulUnsubscribe.c()).g();
        for (int i8 = 0; i8 < g8.size(); i8++) {
            g8.get(i8).h(byteBuf);
        }
    }

    private void p(MqttStatefulUnsubscribe mqttStatefulUnsubscribe, ByteBuf byteBuf, int i8, int i9) {
        MqttVariableByteInteger.b(i8, byteBuf);
        f(mqttStatefulUnsubscribe, byteBuf, i9);
    }

    private void q(MqttStatefulUnsubscribe mqttStatefulUnsubscribe, ByteBuf byteBuf, int i8, int i9) {
        byteBuf.writeShort(mqttStatefulUnsubscribe.a());
        p(mqttStatefulUnsubscribe, byteBuf, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: m */
    public void e(MqttStatefulUnsubscribe mqttStatefulUnsubscribe, ByteBuf byteBuf, int i8, int i9, int i10) {
        n(byteBuf, i8);
        q(mqttStatefulUnsubscribe, byteBuf, i9, i10);
        o(mqttStatefulUnsubscribe, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: r */
    public int h(MqttStatefulUnsubscribe mqttStatefulUnsubscribe) {
        return g(mqttStatefulUnsubscribe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: s */
    public int l(MqttStatefulUnsubscribe mqttStatefulUnsubscribe) {
        ImmutableList<MqttTopicFilterImpl> g8 = ((MqttUnsubscribe) mqttStatefulUnsubscribe.c()).g();
        int i8 = 2;
        for (int i9 = 0; i9 < g8.size(); i9++) {
            i8 += g8.get(i9).j();
        }
        return i8;
    }
}
