package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.internal.util.collections.HandleList;
import com.hivemq.client.mqtt.datatypes.MqttQos;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MqttStatefulPublishWithFlows extends HandleList<MqttIncomingPublishFlow> {

    /* renamed from: d  reason: collision with root package name */
    final MqttStatefulPublish f18228d;

    /* renamed from: e  reason: collision with root package name */
    long f18229e;

    /* renamed from: f  reason: collision with root package name */
    long f18230f;

    /* renamed from: g  reason: collision with root package name */
    boolean f18231g;

    /* renamed from: h  reason: collision with root package name */
    private int f18232h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttStatefulPublishWithFlows(MqttStatefulPublish mqttStatefulPublish) {
        this.f18228d = mqttStatefulPublish;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(MqttIncomingPublishFlow mqttIncomingPublishFlow) {
        boolean z7 = true;
        int i8 = this.f18232h - 1;
        this.f18232h = i8;
        if (i8 != 0) {
            z7 = false;
        }
        mqttIncomingPublishFlow.h(z7);
    }

    @Override // com.hivemq.client.internal.util.collections.HandleList
    /* renamed from: k */
    public HandleList.Handle<MqttIncomingPublishFlow> i(MqttIncomingPublishFlow mqttIncomingPublishFlow) {
        if (((MqttPublish) this.f18228d.c()).j() != MqttQos.AT_MOST_ONCE && mqttIncomingPublishFlow.f18194k) {
            this.f18232h++;
            mqttIncomingPublishFlow.k();
        }
        return super.i(mqttIncomingPublishFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        if (this.f18232h == 0) {
            return true;
        }
        return false;
    }
}
