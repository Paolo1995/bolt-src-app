package eu.bolt.chat.chatcore.network.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageSeenConfirmationEntity;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.mqtt.MqttController;
import eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo;
import eu.bolt.chat.chatcore.repo.ChatNetworkRepo;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatNetworkRepoImpl.kt */
@Singleton
/* loaded from: classes5.dex */
public final class ChatNetworkRepoImpl implements ChatNetworkRepo {

    /* renamed from: a  reason: collision with root package name */
    private final MqttController f38364a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatExternalNetworkRepo f38365b;

    @Inject
    public ChatNetworkRepoImpl(MqttController mqttController, ChatExternalNetworkRepo chatExternalNetworkRepo) {
        Intrinsics.f(mqttController, "mqttController");
        Intrinsics.f(chatExternalNetworkRepo, "chatExternalNetworkRepo");
        this.f38364a = mqttController;
        this.f38365b = chatExternalNetworkRepo;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Completable a(ChatRequestReplySuggestionsEntity replySuggestionsRequest) {
        Intrinsics.f(replySuggestionsRequest, "replySuggestionsRequest");
        return this.f38364a.a(replySuggestionsRequest);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Single<List<ChatEntity>> b() {
        return this.f38365b.b();
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Single<ChatHistoryEntity> c(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return this.f38365b.c(chatId);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Completable d(ChatConnectionEntity chatConnectionEntity, Function0<Unit> onClientInit) {
        Intrinsics.f(chatConnectionEntity, "chatConnectionEntity");
        Intrinsics.f(onClientInit, "onClientInit");
        return this.f38364a.d(chatConnectionEntity, onClientInit);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Completable disconnect() {
        return this.f38364a.disconnect();
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Completable e(ChatMessageSeenConfirmationEntity messagesConfirmation) {
        Intrinsics.f(messagesConfirmation, "messagesConfirmation");
        return this.f38364a.e(messagesConfirmation);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Completable f(ChatMessageEntity message) {
        Intrinsics.f(message, "message");
        return this.f38364a.f(message);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatNetworkRepo
    public Flowable<ChatEvent> g() {
        return this.f38364a.g();
    }
}
