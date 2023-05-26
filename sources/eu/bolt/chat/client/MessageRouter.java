package eu.bolt.chat.client;

import eu.bolt.chat.network.data.MqttMessage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: MessageRouter.kt */
/* loaded from: classes5.dex */
public interface MessageRouter {
    Object a(MqttMessage mqttMessage, Continuation<? super Unit> continuation);

    SharedFlow<MessageBox> b();
}
