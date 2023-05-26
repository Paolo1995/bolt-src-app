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
public final class InternalAnalyticsConsumer_Factory implements Factory<InternalAnalyticsConsumer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnalyticsClient> f23487a;

    public InternalAnalyticsConsumer_Factory(Provider<AnalyticsClient> provider) {
        this.f23487a = provider;
    }

    public static InternalAnalyticsConsumer_Factory a(Provider<AnalyticsClient> provider) {
        return new InternalAnalyticsConsumer_Factory(provider);
    }

    public static InternalAnalyticsConsumer c(AnalyticsClient analyticsClient) {
        return new InternalAnalyticsConsumer(analyticsClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InternalAnalyticsConsumer get() {
        return c(this.f23487a.get());
    }
}
