package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.timed.TimedConsumer;
import ee.mtakso.driver.service.analytics.timed.consumer.log.LoggingTimedConsumer;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnalyticsModule_ProvideLoggingTimedConsumerFactory implements Factory<Set<TimedConsumer>> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LoggingTimedConsumer> f20745a;

    public AnalyticsModule_ProvideLoggingTimedConsumerFactory(Provider<LoggingTimedConsumer> provider) {
        this.f20745a = provider;
    }

    public static AnalyticsModule_ProvideLoggingTimedConsumerFactory a(Provider<LoggingTimedConsumer> provider) {
        return new AnalyticsModule_ProvideLoggingTimedConsumerFactory(provider);
    }

    public static Set<TimedConsumer> c(LoggingTimedConsumer loggingTimedConsumer) {
        return (Set) Preconditions.checkNotNullFromProvides(AnalyticsModule.L(loggingTimedConsumer));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Set<TimedConsumer> get() {
        return c(this.f20745a.get());
    }
}
