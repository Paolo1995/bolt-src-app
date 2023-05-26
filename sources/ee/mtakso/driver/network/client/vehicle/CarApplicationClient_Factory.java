package ee.mtakso.driver.network.client.vehicle;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CarApplicationClient_Factory implements Factory<CarApplicationClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CarApplicationApi> f22901a;

    public CarApplicationClient_Factory(Provider<CarApplicationApi> provider) {
        this.f22901a = provider;
    }

    public static CarApplicationClient_Factory a(Provider<CarApplicationApi> provider) {
        return new CarApplicationClient_Factory(provider);
    }

    public static CarApplicationClient c(CarApplicationApi carApplicationApi) {
        return new CarApplicationClient(carApplicationApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CarApplicationClient get() {
        return c(this.f22901a.get());
    }
}
