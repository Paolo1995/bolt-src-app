package com.hivemq.client.internal.mqtt.handler.disconnect;

import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.internal.rx.CompletableFlow;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5DisconnectException;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;

/* loaded from: classes3.dex */
public class MqttDisconnectEvent {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f18141a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttDisconnectSource f18142b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ByUser extends MqttDisconnectEvent {

        /* renamed from: c  reason: collision with root package name */
        private final CompletableFlow f18143c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ByUser(MqttDisconnect mqttDisconnect, CompletableFlow completableFlow) {
            super(new Mqtt5DisconnectException(mqttDisconnect, "Client sent DISCONNECT"), MqttDisconnectSource.USER);
            this.f18143c = completableFlow;
        }

        public CompletableFlow d() {
            return this.f18143c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttDisconnectEvent(Throwable th, MqttDisconnectSource mqttDisconnectSource) {
        this.f18141a = th;
        this.f18142b = mqttDisconnectSource;
    }

    public Throwable a() {
        return this.f18141a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttDisconnect b() {
        Throwable th = this.f18141a;
        if (th instanceof Mqtt5DisconnectException) {
            Mqtt5Disconnect a8 = ((Mqtt5DisconnectException) th).a();
            if (a8 instanceof MqttDisconnect) {
                return (MqttDisconnect) a8;
            }
            return null;
        }
        return null;
    }

    public MqttDisconnectSource c() {
        return this.f18142b;
    }
}
