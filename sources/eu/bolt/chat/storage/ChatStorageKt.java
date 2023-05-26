package eu.bolt.chat.storage;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.message.ChatMessage;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatStorage.kt */
/* loaded from: classes5.dex */
public final class ChatStorageKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Function1<ChatMessage, Boolean> f39537a = new Function1<ChatMessage, Boolean>() { // from class: eu.bolt.chat.storage.ChatStorageKt$SelectAllMessagesFilter$1
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(ChatMessage it) {
            Intrinsics.f(it, "it");
            return Boolean.TRUE;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Function1<Chat, Boolean> f39538b = new Function1<Chat, Boolean>() { // from class: eu.bolt.chat.storage.ChatStorageKt$SelectAllChatsFilter$1
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(Chat it) {
            Intrinsics.f(it, "it");
            return Boolean.TRUE;
        }
    };
}
