package ee.mtakso.driver.ui.interactor.activity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverActivityInteractor_Factory implements Factory<DriverActivityInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f26415a;

    public DriverActivityInteractor_Factory(Provider<DriverClient> provider) {
        this.f26415a = provider;
    }

    public static DriverActivityInteractor_Factory a(Provider<DriverClient> provider) {
        return new DriverActivityInteractor_Factory(provider);
    }

    public static DriverActivityInteractor c(DriverClient driverClient) {
        return new DriverActivityInteractor(driverClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverActivityInteractor get() {
        return c(this.f26415a.get());
    }
}
