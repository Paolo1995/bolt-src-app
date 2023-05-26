package ee.mtakso.driver.network.client.analytics;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnalyticsClient_Factory implements Factory<AnalyticsClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnalyticsApi> f21352a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LeadAnalyticsApi> f21353b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f21354c;

    public AnalyticsClient_Factory(Provider<AnalyticsApi> provider, Provider<LeadAnalyticsApi> provider2, Provider<ResponseErrorProcessor> provider3) {
        this.f21352a = provider;
        this.f21353b = provider2;
        this.f21354c = provider3;
    }

    public static AnalyticsClient_Factory a(Provider<AnalyticsApi> provider, Provider<LeadAnalyticsApi> provider2, Provider<ResponseErrorProcessor> provider3) {
        return new AnalyticsClient_Factory(provider, provider2, provider3);
    }

    public static AnalyticsClient c(Lazy<AnalyticsApi> lazy, Lazy<LeadAnalyticsApi> lazy2, ResponseErrorProcessor responseErrorProcessor) {
        return new AnalyticsClient(lazy, lazy2, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AnalyticsClient get() {
        return c(DoubleCheck.lazy(this.f21352a), DoubleCheck.lazy(this.f21353b), this.f21354c.get());
    }
}
