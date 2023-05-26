package eu.bolt.chat.client;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.data.ChatStatus;
import eu.bolt.chat.data.QuickReplySuggestion;
import eu.bolt.chat.data.message.ChatMessage;
import java.util.List;

/* compiled from: ChatManager.kt */
/* loaded from: classes5.dex */
public interface ChatManager {
    void c(List<String> list);

    ObservableStateFlow<Integer> f();

    ObservableStateFlow<List<ChatMessage>> j();

    void k(String str);

    ObservableStateFlow<List<QuickReplySuggestion>> m();

    void o(String str);

    ObservableStateFlow<ChatStatus> r();
}
