package eu.bolt.chat.network.endpoint;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatHistory;
import eu.bolt.chat.util.Outcome;
import java.util.List;
import kotlin.coroutines.Continuation;

/* compiled from: ChatApiService.kt */
/* loaded from: classes5.dex */
public interface ChatApiService {
    Object a(String str, Continuation<? super Outcome<ChatHistory, EndpointError>> continuation);

    Object b(Continuation<? super Outcome<List<Chat>, EndpointError>> continuation);
}
