package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBalanceHistoryMapper_Factory implements Factory<EarningsBalanceHistoryMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsBalanceHistoryItemMapper> f28828a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverInfoBlockMapper> f28829b;

    public EarningsBalanceHistoryMapper_Factory(Provider<EarningsBalanceHistoryItemMapper> provider, Provider<DriverInfoBlockMapper> provider2) {
        this.f28828a = provider;
        this.f28829b = provider2;
    }

    public static EarningsBalanceHistoryMapper_Factory a(Provider<EarningsBalanceHistoryItemMapper> provider, Provider<DriverInfoBlockMapper> provider2) {
        return new EarningsBalanceHistoryMapper_Factory(provider, provider2);
    }

    public static EarningsBalanceHistoryMapper c(EarningsBalanceHistoryItemMapper earningsBalanceHistoryItemMapper, DriverInfoBlockMapper driverInfoBlockMapper) {
        return new EarningsBalanceHistoryMapper(earningsBalanceHistoryItemMapper, driverInfoBlockMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceHistoryMapper get() {
        return c(this.f28828a.get(), this.f28829b.get());
    }
}
