package com.hivemq.client.internal.mqtt.handler.disconnect;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.exceptions.MqttClientStateExceptions;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.internal.rx.CompletableFlow;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes3.dex */
public class MqttDisconnectCompletable extends Completable {

    /* renamed from: f  reason: collision with root package name */
    private final MqttClientConfig f18139f;

    /* renamed from: g  reason: collision with root package name */
    private final MqttDisconnect f18140g;

    public MqttDisconnectCompletable(MqttClientConfig mqttClientConfig, MqttDisconnect mqttDisconnect) {
        this.f18139f = mqttClientConfig;
        this.f18140g = mqttDisconnect;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        MqttClientConnectionConfig n8 = this.f18139f.n();
        if (n8 == null) {
            EmptyDisposable.f(MqttClientStateExceptions.b(), completableObserver);
            return;
        }
        MqttDisconnectHandler mqttDisconnectHandler = (MqttDisconnectHandler) n8.b().pipeline().get("disconnect");
        if (mqttDisconnectHandler == null) {
            EmptyDisposable.f(MqttClientStateExceptions.b(), completableObserver);
            return;
        }
        CompletableFlow completableFlow = new CompletableFlow(completableObserver);
        completableObserver.onSubscribe(completableFlow);
        mqttDisconnectHandler.l(this.f18140g, completableFlow);
    }
}
