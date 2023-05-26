package eu.bolt.chat.data.message;

import kotlinx.datetime.LocalDateTime;

/* compiled from: ChatMessage.kt */
/* loaded from: classes5.dex */
public interface ChatMessage extends IdentifiableChatMessage {
    ChatMessage a(MessageStatus messageStatus);

    LocalDateTime b();

    MessageStatus getStatus();
}
