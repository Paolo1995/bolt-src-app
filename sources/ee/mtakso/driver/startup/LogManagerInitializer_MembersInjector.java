package ee.mtakso.driver.startup;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.log.LogManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogManagerInitializer_MembersInjector implements MembersInjector<LogManagerInitializer> {
    @InjectedFieldSignature("ee.mtakso.driver.startup.LogManagerInitializer.logManager")
    public static void a(LogManagerInitializer logManagerInitializer, LogManager logManager) {
        logManagerInitializer.f26219a = logManager;
    }
}
