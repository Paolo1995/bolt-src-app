package eu.bolt.driver.chat.ui.notification;

import dagger.Lazy;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverChatPushDelegate.kt */
/* loaded from: classes5.dex */
public final class DriverChatPushDelegate implements ChatPushDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<ChatNotificationManager> f40582a;

    public DriverChatPushDelegate(Lazy<ChatNotificationManager> managerLazy) {
        Intrinsics.f(managerLazy, "managerLazy");
        this.f40582a = managerLazy;
    }

    @Override // eu.bolt.chat.chatcore.push.ChatPushDelegate
    public void a(String chatId) {
        Intrinsics.f(chatId, "chatId");
    }

    @Override // eu.bolt.chat.chatcore.push.ChatPushDelegate
    public void b(ChatEntity chat, ChatMessageEntity message) {
        Intrinsics.f(chat, "chat");
        Intrinsics.f(message, "message");
        this.f40582a.get().e(chat, message);
    }
}
