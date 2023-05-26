package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.other.OtherDriversManager;
import ee.mtakso.driver.service.driver.other.UpdateOtherDriversService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NearbyDriversInteractor_Factory implements Factory<NearbyDriversInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UpdateOtherDriversService> f26510a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OtherDriversManager> f26511b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f26512c;

    public NearbyDriversInteractor_Factory(Provider<UpdateOtherDriversService> provider, Provider<OtherDriversManager> provider2, Provider<DriverProvider> provider3) {
        this.f26510a = provider;
        this.f26511b = provider2;
        this.f26512c = provider3;
    }

    public static NearbyDriversInteractor_Factory a(Provider<UpdateOtherDriversService> provider, Provider<OtherDriversManager> provider2, Provider<DriverProvider> provider3) {
        return new NearbyDriversInteractor_Factory(provider, provider2, provider3);
    }

    public static NearbyDriversInteractor c(UpdateOtherDriversService updateOtherDriversService, OtherDriversManager otherDriversManager, DriverProvider driverProvider) {
        return new NearbyDriversInteractor(updateOtherDriversService, otherDriversManager, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NearbyDriversInteractor get() {
        return c(this.f26510a.get(), this.f26511b.get(), this.f26512c.get());
    }
}
