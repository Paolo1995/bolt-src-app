package eu.bolt.driver.chat;

import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.driver.chat.di.DriverChatApplicationComponent;
import eu.bolt.driver.chat.di.DriverChatAutorisedComponent;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.log.ChatLogger;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager;
import eu.bolt.driver.chat.ui.screen.conversation.ConversationActivity;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.util.AssertUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverChatSdk.kt */
/* loaded from: classes5.dex */
public final class DriverChatSdk {

    /* renamed from: a  reason: collision with root package name */
    public static final DriverChatSdk f40388a = new DriverChatSdk();

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f40389b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile DriverChatApplicationComponent f40390c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile DriverChatAutorisedComponent f40391d;

    private DriverChatSdk() {
    }

    public final RoutingCommand a() {
        return ConversationActivity.f40587p.a();
    }

    public final DriverChatAutorisedComponent b() {
        DriverChatAutorisedComponent driverChatAutorisedComponent = f40391d;
        if (driverChatAutorisedComponent != null) {
            return driverChatAutorisedComponent;
        }
        throw new IllegalStateException("Chat Component is not initialized yet. Call setChatComponent to initialize it".toString());
    }

    public final ChatManager c() {
        ChatManager chatManager;
        DriverChatApplicationComponent driverChatApplicationComponent = f40390c;
        if (driverChatApplicationComponent != null) {
            chatManager = driverChatApplicationComponent.L();
        } else {
            chatManager = null;
        }
        if (chatManager != null) {
            return chatManager;
        }
        throw new IllegalStateException("Chat Manager is not initialized yet. Call createChatManager to initialize it".toString());
    }

    public final ChatNotificationManager d() {
        ChatNotificationManager chatNotificationManager;
        DriverChatApplicationComponent driverChatApplicationComponent = f40390c;
        if (driverChatApplicationComponent != null) {
            chatNotificationManager = driverChatApplicationComponent.n1();
        } else {
            chatNotificationManager = null;
        }
        if (chatNotificationManager != null) {
            return chatNotificationManager;
        }
        throw new IllegalStateException("Chat application component is not initialized yet. Call initChatSdk to initialize it".toString());
    }

    public final synchronized void e(DriverChatApplicationComponent applicationComponent) {
        Intrinsics.f(applicationComponent, "applicationComponent");
        if (f40389b) {
            AssertUtils.f41299a.a("Detekt attempt to initialize chat SDK for second time");
            return;
        }
        f40390c = applicationComponent;
        ChatKit.l(ChatKit.f37877a, ChatLogger.f40497a, applicationComponent.n(), null, 4, null);
        f40389b = true;
    }

    public final synchronized void f(DriverChatAutorisedComponent chatAutorisedComponent) {
        Intrinsics.f(chatAutorisedComponent, "chatAutorisedComponent");
        f40391d = chatAutorisedComponent;
    }

    public final synchronized void g() {
        f40391d = null;
    }
}
