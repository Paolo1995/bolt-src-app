package eu.bolt.chat.client;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ClientStatus;
import java.util.List;

/* compiled from: ChatClient.kt */
/* loaded from: classes5.dex */
public interface ChatClient {
    ObservableStateFlow<List<Chat>> b();

    ChatManager c(String str);

    ObservableStateFlow<ClientStatus> d();

    ClientStatus getStatus();
}
