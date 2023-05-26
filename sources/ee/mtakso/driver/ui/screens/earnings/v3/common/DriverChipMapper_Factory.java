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
public final class DriverChipMapper_Factory implements Factory<DriverChipMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverImageMapper> f29032a;

    public DriverChipMapper_Factory(Provider<DriverImageMapper> provider) {
        this.f29032a = provider;
    }

    public static DriverChipMapper_Factory a(Provider<DriverImageMapper> provider) {
        return new DriverChipMapper_Factory(provider);
    }

    public static DriverChipMapper c(DriverImageMapper driverImageMapper) {
        return new DriverChipMapper(driverImageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverChipMapper get() {
        return c(this.f29032a.get());
    }
}
