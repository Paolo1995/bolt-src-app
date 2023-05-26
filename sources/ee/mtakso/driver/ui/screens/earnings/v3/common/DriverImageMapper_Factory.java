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
public final class DriverImageMapper_Factory implements Factory<DriverImageMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverNormalImageMapper> f29038a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverTintableImageMapper> f29039b;

    public DriverImageMapper_Factory(Provider<DriverNormalImageMapper> provider, Provider<DriverTintableImageMapper> provider2) {
        this.f29038a = provider;
        this.f29039b = provider2;
    }

    public static DriverImageMapper_Factory a(Provider<DriverNormalImageMapper> provider, Provider<DriverTintableImageMapper> provider2) {
        return new DriverImageMapper_Factory(provider, provider2);
    }

    public static DriverImageMapper c(DriverNormalImageMapper driverNormalImageMapper, DriverTintableImageMapper driverTintableImageMapper) {
        return new DriverImageMapper(driverNormalImageMapper, driverTintableImageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverImageMapper get() {
        return c(this.f29038a.get(), this.f29039b.get());
    }
}
