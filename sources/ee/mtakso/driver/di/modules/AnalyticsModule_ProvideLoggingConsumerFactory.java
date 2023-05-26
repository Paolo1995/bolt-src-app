package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.LoggingAnalyticsConsumer;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnalyticsModule_ProvideLoggingConsumerFactory implements Factory<Set<AnalyticsConsumer>> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LoggingAnalyticsConsumer> f20744a;

    public AnalyticsModule_ProvideLoggingConsumerFactory(Provider<LoggingAnalyticsConsumer> provider) {
        this.f20744a = provider;
    }

    public static AnalyticsModule_ProvideLoggingConsumerFactory a(Provider<LoggingAnalyticsConsumer> provider) {
        return new AnalyticsModule_ProvideLoggingConsumerFactory(provider);
    }

    public static Set<AnalyticsConsumer> c(LoggingAnalyticsConsumer loggingAnalyticsConsumer) {
        return (Set) Preconditions.checkNotNullFromProvides(AnalyticsModule.K(loggingAnalyticsConsumer));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Set<AnalyticsConsumer> get() {
        return c(this.f20744a.get());
    }
}
