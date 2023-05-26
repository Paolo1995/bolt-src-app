package ee.mtakso.driver.di.authorised;

import dagger.Module;
import dagger.Provides;
import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.driver.chat.service.log.ChatLogger;

/* compiled from: DriverChatAuthorisedModule.kt */
@Module
/* loaded from: classes3.dex */
public final class DriverChatAuthorisedModule {
    @Provides
    public final Logger a() {
        return ChatLogger.f40497a;
    }
}
