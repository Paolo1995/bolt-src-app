package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverButtonMapper_Factory implements Factory<DriverButtonMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverButtonSizeMapper> f29026a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverButtonAppearanceMapper> f29027b;

    public DriverButtonMapper_Factory(Provider<DriverButtonSizeMapper> provider, Provider<DriverButtonAppearanceMapper> provider2) {
        this.f29026a = provider;
        this.f29027b = provider2;
    }

    public static DriverButtonMapper_Factory a(Provider<DriverButtonSizeMapper> provider, Provider<DriverButtonAppearanceMapper> provider2) {
        return new DriverButtonMapper_Factory(provider, provider2);
    }

    public static DriverButtonMapper c(DriverButtonSizeMapper driverButtonSizeMapper, DriverButtonAppearanceMapper driverButtonAppearanceMapper) {
        return new DriverButtonMapper(driverButtonSizeMapper, driverButtonAppearanceMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverButtonMapper get() {
        return c(this.f29026a.get(), this.f29027b.get());
    }
}
