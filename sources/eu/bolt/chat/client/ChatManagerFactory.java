package eu.bolt.chat.client;

import eu.bolt.chat.data.EndChatInfo;

/* compiled from: ChatManagerFactory.kt */
/* loaded from: classes5.dex */
public interface ChatManagerFactory {
    void a(String str, EndChatInfo endChatInfo);

    void clear();

    InternalChatManager get(String str);
}
