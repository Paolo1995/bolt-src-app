package ee.mtakso.driver.service.analytics.event.consumer;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LoggingAnalyticsConsumer_Factory implements Factory<LoggingAnalyticsConsumer> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final LoggingAnalyticsConsumer_Factory f23493a = new LoggingAnalyticsConsumer_Factory();

        private InstanceHolder() {
        }
    }

    public static LoggingAnalyticsConsumer_Factory a() {
        return InstanceHolder.f23493a;
    }

    public static LoggingAnalyticsConsumer c() {
        return new LoggingAnalyticsConsumer();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LoggingAnalyticsConsumer get() {
        return c();
    }
}
