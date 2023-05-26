package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsNestedItemMapper_Factory implements Factory<EarningsNestedItemMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverImageMapper> f28965a;

    public EarningsNestedItemMapper_Factory(Provider<DriverImageMapper> provider) {
        this.f28965a = provider;
    }

    public static EarningsNestedItemMapper_Factory a(Provider<DriverImageMapper> provider) {
        return new EarningsNestedItemMapper_Factory(provider);
    }

    public static EarningsNestedItemMapper c(DriverImageMapper driverImageMapper) {
        return new EarningsNestedItemMapper(driverImageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsNestedItemMapper get() {
        return c(this.f28965a.get());
    }
}
