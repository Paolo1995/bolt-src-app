package eu.bolt.chat.chatcore.mqtt;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageSeenConfirmationEntity;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.network.repo.ChatEvent;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: MqttController.kt */
/* loaded from: classes5.dex */
public interface MqttController {
    Completable a(ChatRequestReplySuggestionsEntity chatRequestReplySuggestionsEntity);

    Completable d(ChatConnectionEntity chatConnectionEntity, Function0<Unit> function0);

    Completable disconnect();

    Completable e(ChatMessageSeenConfirmationEntity chatMessageSeenConfirmationEntity);

    Completable f(ChatMessageEntity chatMessageEntity);

    Flowable<ChatEvent> g();
}
