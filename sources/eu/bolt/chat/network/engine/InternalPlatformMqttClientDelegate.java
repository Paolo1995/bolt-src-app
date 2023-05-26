package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.data.MqttMessage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: PlatformMqttClientDelegate.kt */
/* loaded from: classes5.dex */
public interface InternalPlatformMqttClientDelegate extends PlatformMqttClientDelegate {
    SharedFlow<SubscriptionEvent> b();

    Object d(int i8, MqttMessage mqttMessage, Continuation<? super Unit> continuation);

    Object g(Continuation<? super Unit> continuation);

    SharedFlow<ConnectionEvent> j();

    SharedFlow<IdentifiablePublishingEvent> k();
}
