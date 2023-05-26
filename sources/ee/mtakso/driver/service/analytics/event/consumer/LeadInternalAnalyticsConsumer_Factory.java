package ee.mtakso.driver.service.analytics.event.consumer;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.analytics.AnalyticsClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LeadInternalAnalyticsConsumer_Factory implements Factory<LeadInternalAnalyticsConsumer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnalyticsClient> f23491a;

    public LeadInternalAnalyticsConsumer_Factory(Provider<AnalyticsClient> provider) {
        this.f23491a = provider;
    }

    public static LeadInternalAnalyticsConsumer_Factory a(Provider<AnalyticsClient> provider) {
        return new LeadInternalAnalyticsConsumer_Factory(provider);
    }

    public static LeadInternalAnalyticsConsumer c(AnalyticsClient analyticsClient) {
        return new LeadInternalAnalyticsConsumer(analyticsClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LeadInternalAnalyticsConsumer get() {
        return c(this.f23491a.get());
    }
}
