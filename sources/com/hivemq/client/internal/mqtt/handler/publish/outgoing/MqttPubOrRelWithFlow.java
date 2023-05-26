package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.util.collections.NodeList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class MqttPubOrRelWithFlow extends NodeList.Node<MqttPubOrRelWithFlow> {

    /* renamed from: c  reason: collision with root package name */
    private final MqttAckFlow f18290c;

    /* renamed from: d  reason: collision with root package name */
    int f18291d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttPubOrRelWithFlow(MqttAckFlow mqttAckFlow) {
        this.f18290c = mqttAckFlow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttAckFlow c() {
        return this.f18290c;
    }
}
