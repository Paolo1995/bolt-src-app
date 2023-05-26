package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverSessionExpireMessageInteractor_Factory implements Factory<DriverSessionExpireMessageInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceSettings> f26464a;

    public DriverSessionExpireMessageInteractor_Factory(Provider<DeviceSettings> provider) {
        this.f26464a = provider;
    }

    public static DriverSessionExpireMessageInteractor_Factory a(Provider<DeviceSettings> provider) {
        return new DriverSessionExpireMessageInteractor_Factory(provider);
    }

    public static DriverSessionExpireMessageInteractor c(DeviceSettings deviceSettings) {
        return new DriverSessionExpireMessageInteractor(deviceSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverSessionExpireMessageInteractor get() {
        return c(this.f26464a.get());
    }
}
