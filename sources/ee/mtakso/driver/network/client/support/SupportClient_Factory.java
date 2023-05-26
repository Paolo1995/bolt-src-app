package ee.mtakso.driver.network.client.support;

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
public final class SupportClient_Factory implements Factory<SupportClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SupportApi> f22854a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22855b;

    public SupportClient_Factory(Provider<SupportApi> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f22854a = provider;
        this.f22855b = provider2;
    }

    public static SupportClient_Factory a(Provider<SupportApi> provider, Provider<ResponseErrorProcessor> provider2) {
        return new SupportClient_Factory(provider, provider2);
    }

    public static SupportClient c(Lazy<SupportApi> lazy, ResponseErrorProcessor responseErrorProcessor) {
        return new SupportClient(lazy, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SupportClient get() {
        return c(DoubleCheck.lazy(this.f22854a), this.f22855b.get());
    }
}
