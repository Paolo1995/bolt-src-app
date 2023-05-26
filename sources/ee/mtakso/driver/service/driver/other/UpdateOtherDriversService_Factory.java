package ee.mtakso.driver.service.driver.other;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UpdateOtherDriversService_Factory implements Factory<UpdateOtherDriversService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OtherDriversManager> f24350a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SurgeManager> f24351b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverFeatures> f24352c;

    public UpdateOtherDriversService_Factory(Provider<OtherDriversManager> provider, Provider<SurgeManager> provider2, Provider<DriverFeatures> provider3) {
        this.f24350a = provider;
        this.f24351b = provider2;
        this.f24352c = provider3;
    }

    public static UpdateOtherDriversService_Factory a(Provider<OtherDriversManager> provider, Provider<SurgeManager> provider2, Provider<DriverFeatures> provider3) {
        return new UpdateOtherDriversService_Factory(provider, provider2, provider3);
    }

    public static UpdateOtherDriversService c(OtherDriversManager otherDriversManager, SurgeManager surgeManager, DriverFeatures driverFeatures) {
        return new UpdateOtherDriversService(otherDriversManager, surgeManager, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UpdateOtherDriversService get() {
        return c(this.f24350a.get(), this.f24351b.get(), this.f24352c.get());
    }
}
