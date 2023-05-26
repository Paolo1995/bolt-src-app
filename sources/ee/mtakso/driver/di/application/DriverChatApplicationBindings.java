package ee.mtakso.driver.di.application;

import dagger.Binds;
import dagger.Module;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import eu.bolt.driver.chat.service.analytics.ChatAnalytics;
import eu.bolt.driver.chat.service.id.ChatIdGenerator;
import eu.bolt.driver.chat.ui.notification.ChatNotificationDrawer;

/* compiled from: DriverChatApplicationBindings.kt */
@Module
/* loaded from: classes3.dex */
public interface DriverChatApplicationBindings {
    @Binds
    IdGenerator a(ChatIdGenerator chatIdGenerator);

    @Binds
    ChatNotificationDrawer b(UiNotificationManager uiNotificationManager);

    @Binds
    ChatAnalytics c(AnalyticsImpl analyticsImpl);
}
