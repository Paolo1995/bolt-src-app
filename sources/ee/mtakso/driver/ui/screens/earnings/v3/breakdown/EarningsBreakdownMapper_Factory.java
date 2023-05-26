package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverContentTypeMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBreakdownMapper_Factory implements Factory<EarningsBreakdownMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsItemMapper> f28911a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EarningsNestedItemMapper> f28912b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverContentTypeMapper> f28913c;

    public EarningsBreakdownMapper_Factory(Provider<EarningsItemMapper> provider, Provider<EarningsNestedItemMapper> provider2, Provider<DriverContentTypeMapper> provider3) {
        this.f28911a = provider;
        this.f28912b = provider2;
        this.f28913c = provider3;
    }

    public static EarningsBreakdownMapper_Factory a(Provider<EarningsItemMapper> provider, Provider<EarningsNestedItemMapper> provider2, Provider<DriverContentTypeMapper> provider3) {
        return new EarningsBreakdownMapper_Factory(provider, provider2, provider3);
    }

    public static EarningsBreakdownMapper c(EarningsItemMapper earningsItemMapper, EarningsNestedItemMapper earningsNestedItemMapper, DriverContentTypeMapper driverContentTypeMapper) {
        return new EarningsBreakdownMapper(earningsItemMapper, earningsNestedItemMapper, driverContentTypeMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBreakdownMapper get() {
        return c(this.f28911a.get(), this.f28912b.get(), this.f28913c.get());
    }
}
