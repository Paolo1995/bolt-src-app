package eu.bolt.android.chat;

import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.CreateChatInteractor;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.repo.ChatRepo;

/* compiled from: ChatDependencyProvider.kt */
/* loaded from: classes5.dex */
public interface ChatDependencyProvider {
    ChatConnectionProvider a();

    ReadMessageInteractor b();

    SendChatMessageInteractor c();

    ChatPushHandler d();

    RequestReplySuggestionsInteractor e();

    CreateChatInteractor f();

    ChatRepo g();
}
