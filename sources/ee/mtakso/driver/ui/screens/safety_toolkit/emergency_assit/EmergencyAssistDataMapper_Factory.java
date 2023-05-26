package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmergencyAssistDataMapper_Factory implements Factory<EmergencyAssistDataMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverImageMapper> f32670a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f32671b;

    public EmergencyAssistDataMapper_Factory(Provider<DriverImageMapper> provider, Provider<DriverProvider> provider2) {
        this.f32670a = provider;
        this.f32671b = provider2;
    }

    public static EmergencyAssistDataMapper_Factory a(Provider<DriverImageMapper> provider, Provider<DriverProvider> provider2) {
        return new EmergencyAssistDataMapper_Factory(provider, provider2);
    }

    public static EmergencyAssistDataMapper c(DriverImageMapper driverImageMapper, DriverProvider driverProvider) {
        return new EmergencyAssistDataMapper(driverImageMapper, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistDataMapper get() {
        return c(this.f32670a.get(), this.f32671b.get());
    }
}
