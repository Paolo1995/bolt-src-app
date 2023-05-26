package ee.mtakso.driver.network.client.score;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverScoreClient_Factory implements Factory<DriverScoreClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverScoreApi> f22721a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22722b;

    public DriverScoreClient_Factory(Provider<DriverScoreApi> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f22721a = provider;
        this.f22722b = provider2;
    }

    public static DriverScoreClient_Factory a(Provider<DriverScoreApi> provider, Provider<ResponseErrorProcessor> provider2) {
        return new DriverScoreClient_Factory(provider, provider2);
    }

    public static DriverScoreClient c(DriverScoreApi driverScoreApi, ResponseErrorProcessor responseErrorProcessor) {
        return new DriverScoreClient(driverScoreApi, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreClient get() {
        return c(this.f22721a.get(), this.f22722b.get());
    }
}
