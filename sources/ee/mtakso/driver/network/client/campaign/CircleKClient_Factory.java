package ee.mtakso.driver.network.client.campaign;

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
public final class CircleKClient_Factory implements Factory<CircleKClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CircleKApi> f21625a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f21626b;

    public CircleKClient_Factory(Provider<CircleKApi> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f21625a = provider;
        this.f21626b = provider2;
    }

    public static CircleKClient_Factory a(Provider<CircleKApi> provider, Provider<ResponseErrorProcessor> provider2) {
        return new CircleKClient_Factory(provider, provider2);
    }

    public static CircleKClient c(Lazy<CircleKApi> lazy, ResponseErrorProcessor responseErrorProcessor) {
        return new CircleKClient(lazy, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CircleKClient get() {
        return c(DoubleCheck.lazy(this.f21625a), this.f21626b.get());
    }
}
