package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.tools.logger.Logger;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverChatAuthorisedModule_ChatLoggerFactory implements Factory<Logger> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverChatAuthorisedModule f20726a;

    public DriverChatAuthorisedModule_ChatLoggerFactory(DriverChatAuthorisedModule driverChatAuthorisedModule) {
        this.f20726a = driverChatAuthorisedModule;
    }

    public static Logger a(DriverChatAuthorisedModule driverChatAuthorisedModule) {
        return (Logger) Preconditions.checkNotNullFromProvides(driverChatAuthorisedModule.a());
    }

    public static DriverChatAuthorisedModule_ChatLoggerFactory b(DriverChatAuthorisedModule driverChatAuthorisedModule) {
        return new DriverChatAuthorisedModule_ChatLoggerFactory(driverChatAuthorisedModule);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public Logger get() {
        return a(this.f20726a);
    }
}
