package ee.mtakso.driver.di.application;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.service.chat.ChatNetworkInfoProvider;
import ee.mtakso.driver.service.chat.ChatTerminationMessageProvider;
import ee.mtakso.driver.service.chat.DriverChatUserInfoProvider;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.CreateChatInteractor;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.DynamicChatConfig;
import eu.bolt.driver.chat.DynamicChatConfigProvider;
import eu.bolt.driver.chat.StaticChatConfig;
import eu.bolt.driver.chat.network.ChatClient;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider;
import eu.bolt.driver.chat.service.id.ChatIdGenerator;
import eu.bolt.driver.chat.service.repo.ActiveChatsMapper;
import eu.bolt.driver.chat.service.repo.ChatExternalNetworkRepoImpl;
import eu.bolt.driver.chat.service.repo.ChatHistoryMapper;
import eu.bolt.driver.chat.service.repo.MessageTranslationRatingMapper;
import eu.bolt.driver.chat.service.rx.ChatRxSchedulers;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager;
import eu.bolt.driver.chat.ui.notification.DriverChatPushDelegate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverChatApplicationModule.kt */
@Module(includes = {DriverChatApplicationBindings.class})
/* loaded from: classes3.dex */
public final class DriverChatApplicationModule {
    @Provides
    public final ChatKit.Dependencies a(ChatNetworkInfoProvider chatNetworkInfoProvider, DriverChatUserInfoProvider userInfoProvider, Lazy<ChatNotificationManager> lazyNotificationManager, ChatForegroundProvider foregroundStateProvider, ChatTerminationMessageProvider terminationMessageProvider, ChatClient chatClient, ActiveChatsMapper activeChatsMapper, MessageTranslationRatingMapper messageTranslationRatingMapper, ChatIdGenerator idGenerator, ChatRxSchedulers rx) {
        Intrinsics.f(chatNetworkInfoProvider, "chatNetworkInfoProvider");
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        Intrinsics.f(lazyNotificationManager, "lazyNotificationManager");
        Intrinsics.f(foregroundStateProvider, "foregroundStateProvider");
        Intrinsics.f(terminationMessageProvider, "terminationMessageProvider");
        Intrinsics.f(chatClient, "chatClient");
        Intrinsics.f(activeChatsMapper, "activeChatsMapper");
        Intrinsics.f(messageTranslationRatingMapper, "messageTranslationRatingMapper");
        Intrinsics.f(idGenerator, "idGenerator");
        Intrinsics.f(rx, "rx");
        return new ChatKit.Dependencies(chatNetworkInfoProvider, idGenerator, rx, userInfoProvider, new DriverChatPushDelegate(lazyNotificationManager), new ChatExternalNetworkRepoImpl(chatClient, activeChatsMapper, new ChatHistoryMapper(userInfoProvider), messageTranslationRatingMapper), foregroundStateProvider, terminationMessageProvider);
    }

    @Provides
    public final ChatManager b(final DriverChatUserInfoProvider userInfoProvider, ChatRepo chatRepo, ChatConnectionProvider connectionProvider, CreateChatInteractor createChatInteractor) {
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        Intrinsics.f(chatRepo, "chatRepo");
        Intrinsics.f(connectionProvider, "connectionProvider");
        Intrinsics.f(createChatInteractor, "createChatInteractor");
        return new ChatManager(new StaticChatConfig(userInfoProvider.getDeviceId(), userInfoProvider.o(), userInfoProvider.m(), userInfoProvider.d()), new DynamicChatConfigProvider() { // from class: ee.mtakso.driver.di.application.DriverChatApplicationModule$provideChatManager$1
            @Override // eu.bolt.driver.chat.DynamicChatConfigProvider
            public DynamicChatConfig a() {
                String b8 = DriverChatUserInfoProvider.this.b();
                String n8 = DriverChatUserInfoProvider.this.n();
                String f8 = DriverChatUserInfoProvider.this.f();
                String a8 = DriverChatUserInfoProvider.this.a();
                String q8 = DriverChatUserInfoProvider.this.q();
                if (q8 == null) {
                    q8 = "";
                }
                return new DynamicChatConfig(b8, n8, f8, a8, q8);
            }
        }, chatRepo, connectionProvider, createChatInteractor);
    }
}
