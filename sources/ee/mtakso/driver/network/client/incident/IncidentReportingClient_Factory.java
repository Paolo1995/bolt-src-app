package ee.mtakso.driver.network.client.incident;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncidentReportingClient_Factory implements Factory<IncidentReportingClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<IncidentReportingApi> f22268a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22269b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22270c;

    public IncidentReportingClient_Factory(Provider<IncidentReportingApi> provider, Provider<CompositeResponseTransformer> provider2, Provider<ResponseErrorProcessor> provider3) {
        this.f22268a = provider;
        this.f22269b = provider2;
        this.f22270c = provider3;
    }

    public static IncidentReportingClient_Factory a(Provider<IncidentReportingApi> provider, Provider<CompositeResponseTransformer> provider2, Provider<ResponseErrorProcessor> provider3) {
        return new IncidentReportingClient_Factory(provider, provider2, provider3);
    }

    public static IncidentReportingClient c(Lazy<IncidentReportingApi> lazy, CompositeResponseTransformer compositeResponseTransformer, ResponseErrorProcessor responseErrorProcessor) {
        return new IncidentReportingClient(lazy, compositeResponseTransformer, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncidentReportingClient get() {
        return c(DoubleCheck.lazy(this.f22268a), this.f22269b.get(), this.f22270c.get());
    }
}
