package ee.mtakso.driver.di.application;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.chat.ChatNetworkInfoProvider;
import ee.mtakso.driver.service.chat.ChatTerminationMessageProvider;
import ee.mtakso.driver.service.chat.DriverChatUserInfoProvider;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.driver.chat.network.ChatClient;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider;
import eu.bolt.driver.chat.service.id.ChatIdGenerator;
import eu.bolt.driver.chat.service.repo.ActiveChatsMapper;
import eu.bolt.driver.chat.service.repo.MessageTranslationRatingMapper;
import eu.bolt.driver.chat.service.rx.ChatRxSchedulers;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"eu.bolt.driver.chat.di.DriverChatDependency"})
/* loaded from: classes3.dex */
public final class DriverChatApplicationModule_ProvideChatKitDependenciesFactory implements Factory<ChatKit.Dependencies> {
    public static ChatKit.Dependencies a(DriverChatApplicationModule driverChatApplicationModule, ChatNetworkInfoProvider chatNetworkInfoProvider, DriverChatUserInfoProvider driverChatUserInfoProvider, Lazy<ChatNotificationManager> lazy, ChatForegroundProvider chatForegroundProvider, ChatTerminationMessageProvider chatTerminationMessageProvider, ChatClient chatClient, ActiveChatsMapper activeChatsMapper, MessageTranslationRatingMapper messageTranslationRatingMapper, ChatIdGenerator chatIdGenerator, ChatRxSchedulers chatRxSchedulers) {
        return (ChatKit.Dependencies) Preconditions.checkNotNullFromProvides(driverChatApplicationModule.a(chatNetworkInfoProvider, driverChatUserInfoProvider, lazy, chatForegroundProvider, chatTerminationMessageProvider, chatClient, activeChatsMapper, messageTranslationRatingMapper, chatIdGenerator, chatRxSchedulers));
    }
}
