package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.checkpoint.Confirmable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MqttIncomingPublishConfirmable implements Confirmable, Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final MqttIncomingPublishFlow f18188f;

    /* renamed from: g  reason: collision with root package name */
    private final MqttStatefulPublishWithFlows f18189g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f18190h = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Qos0 implements Confirmable {

        /* renamed from: f  reason: collision with root package name */
        private final AtomicBoolean f18191f = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttIncomingPublishConfirmable(MqttIncomingPublishFlow mqttIncomingPublishFlow, MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        this.f18188f = mqttIncomingPublishFlow;
        this.f18189g = mqttStatefulPublishWithFlows;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18189g.j(this.f18188f);
    }
}
