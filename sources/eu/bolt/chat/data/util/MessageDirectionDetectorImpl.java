package eu.bolt.chat.data.util;

import eu.bolt.chat.data.message.MessageSender;
import eu.bolt.chat.network.data.ChatConfig;
import eu.bolt.chat.network.data.ChatMessageSender;
import eu.bolt.chat.network.data.MessageEventBase;
import eu.bolt.chat.network.data.UserMessageEvent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageDirectionDetector.kt */
/* loaded from: classes5.dex */
final class MessageDirectionDetectorImpl implements MessageDirectionDetector {

    /* renamed from: a  reason: collision with root package name */
    private final MessageSender f39032a;

    public MessageDirectionDetectorImpl(ChatConfig chatConfig) {
        Intrinsics.f(chatConfig, "chatConfig");
        this.f39032a = chatConfig.a().a();
    }

    @Override // eu.bolt.chat.data.util.MessageDirectionDetector
    public boolean a(MessageEventBase message) {
        String str;
        Intrinsics.f(message, "message");
        if (message instanceof UserMessageEvent) {
            ChatMessageSender c8 = message.c();
            if (c8 != null) {
                str = c8.a();
            } else {
                str = null;
            }
            if (Intrinsics.a(str, this.f39032a.a())) {
                return true;
            }
        }
        return false;
    }
}
