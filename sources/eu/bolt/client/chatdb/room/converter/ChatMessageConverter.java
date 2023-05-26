package eu.bolt.client.chatdb.room.converter;

import eu.bolt.client.chatdb.room.message.MessageStatusDBModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageConverter.kt */
/* loaded from: classes5.dex */
public final class ChatMessageConverter {
    public final int a(MessageStatusDBModel status) {
        Intrinsics.f(status, "status");
        return status.ordinal();
    }

    public final MessageStatusDBModel b(int i8) {
        return MessageStatusDBModel.values()[i8];
    }
}
