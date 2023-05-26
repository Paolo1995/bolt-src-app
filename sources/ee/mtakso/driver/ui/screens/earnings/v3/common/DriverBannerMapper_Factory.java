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
public final class DriverBannerMapper_Factory implements Factory<DriverBannerMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverImageMapper> f29021a;

    public DriverBannerMapper_Factory(Provider<DriverImageMapper> provider) {
        this.f29021a = provider;
    }

    public static DriverBannerMapper_Factory a(Provider<DriverImageMapper> provider) {
        return new DriverBannerMapper_Factory(provider);
    }

    public static DriverBannerMapper c(DriverImageMapper driverImageMapper) {
        return new DriverBannerMapper(driverImageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverBannerMapper get() {
        return c(this.f29021a.get());
    }
}
