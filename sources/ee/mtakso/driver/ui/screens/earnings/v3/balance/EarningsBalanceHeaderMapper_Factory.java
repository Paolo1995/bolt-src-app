package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverBannerMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.EarningsBalanceStateTypeMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBalanceHeaderMapper_Factory implements Factory<EarningsBalanceHeaderMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsBalanceStateTypeMapper> f28803a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverButtonMapper> f28804b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverInfoBlockMapper> f28805c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverBannerMapper> f28806d;

    public EarningsBalanceHeaderMapper_Factory(Provider<EarningsBalanceStateTypeMapper> provider, Provider<DriverButtonMapper> provider2, Provider<DriverInfoBlockMapper> provider3, Provider<DriverBannerMapper> provider4) {
        this.f28803a = provider;
        this.f28804b = provider2;
        this.f28805c = provider3;
        this.f28806d = provider4;
    }

    public static EarningsBalanceHeaderMapper_Factory a(Provider<EarningsBalanceStateTypeMapper> provider, Provider<DriverButtonMapper> provider2, Provider<DriverInfoBlockMapper> provider3, Provider<DriverBannerMapper> provider4) {
        return new EarningsBalanceHeaderMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static EarningsBalanceHeaderMapper c(EarningsBalanceStateTypeMapper earningsBalanceStateTypeMapper, DriverButtonMapper driverButtonMapper, DriverInfoBlockMapper driverInfoBlockMapper, DriverBannerMapper driverBannerMapper) {
        return new EarningsBalanceHeaderMapper(earningsBalanceStateTypeMapper, driverButtonMapper, driverInfoBlockMapper, driverBannerMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceHeaderMapper get() {
        return c(this.f28803a.get(), this.f28804b.get(), this.f28805c.get(), this.f28806d.get());
    }
}
