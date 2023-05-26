package eu.bolt.chat.client;

import eu.bolt.chat.client.DefaultChatSubscriber;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.QoS;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ChatSubscriber.kt */
/* loaded from: classes5.dex */
public interface ChatSubscriber {
    Object a(String str, QoS qoS, FlowCollector<? super DefaultChatSubscriber.SubscriptionStatus> flowCollector, FlowCollector<? super MqttMessage> flowCollector2, Continuation<? super Unit> continuation);

    void clear();
}
