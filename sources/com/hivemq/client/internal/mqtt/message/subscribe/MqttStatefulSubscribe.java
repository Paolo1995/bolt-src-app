package com.hivemq.client.internal.mqtt.message.subscribe;

import com.hivemq.client.internal.mqtt.message.MqttStatefulMessage;

/* loaded from: classes3.dex */
public class MqttStatefulSubscribe extends MqttStatefulMessage.WithId<MqttSubscribe> {

    /* renamed from: d  reason: collision with root package name */
    private final int f18601d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttStatefulSubscribe(MqttSubscribe mqttSubscribe, int i8, int i9) {
        super(mqttSubscribe, i8);
        this.f18601d = i9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttStatefulMessage.WithId, com.hivemq.client.internal.mqtt.message.MqttStatefulMessage
    public String d() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.d());
        if (this.f18601d == -1) {
            str = "";
        } else {
            str = "subscriptionIdentifier=" + this.f18601d;
        }
        sb.append(str);
        return sb.toString();
    }

    public int e() {
        return this.f18601d;
    }

    public String toString() {
        return "MqttStatefulSubscribe{" + d() + '}';
    }
}
