package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.service.driver.DriverManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverStateChangeFailInteractor_Factory implements Factory<DriverStateChangeFailInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverManager> f26470a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverClient> f26471b;

    public DriverStateChangeFailInteractor_Factory(Provider<DriverManager> provider, Provider<DriverClient> provider2) {
        this.f26470a = provider;
        this.f26471b = provider2;
    }

    public static DriverStateChangeFailInteractor_Factory a(Provider<DriverManager> provider, Provider<DriverClient> provider2) {
        return new DriverStateChangeFailInteractor_Factory(provider, provider2);
    }

    public static DriverStateChangeFailInteractor c(DriverManager driverManager, DriverClient driverClient) {
        return new DriverStateChangeFailInteractor(driverManager, driverClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverStateChangeFailInteractor get() {
        return c(this.f26470a.get(), this.f26471b.get());
    }
}
