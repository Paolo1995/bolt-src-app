package com.hivemq.client.internal.mqtt.handler.subscribe;

import com.hivemq.client.internal.mqtt.handler.util.FlowWithEventLoop;
import io.reactivex.disposables.Disposable;

/* loaded from: classes3.dex */
class MqttSubOrUnsubAckFlow<T> extends FlowWithEventLoop implements MqttSubscriptionFlow<T>, Disposable {
}
