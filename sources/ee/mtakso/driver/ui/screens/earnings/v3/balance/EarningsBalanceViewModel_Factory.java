package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.earnings.network.EarningsBalanceClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBalanceViewModel_Factory implements Factory<EarningsBalanceViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsBalanceClient> f28864a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EarningsBalanceHeaderMapper> f28865b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EarningsBalanceHistoryMapper> f28866c;

    public EarningsBalanceViewModel_Factory(Provider<EarningsBalanceClient> provider, Provider<EarningsBalanceHeaderMapper> provider2, Provider<EarningsBalanceHistoryMapper> provider3) {
        this.f28864a = provider;
        this.f28865b = provider2;
        this.f28866c = provider3;
    }

    public static EarningsBalanceViewModel_Factory a(Provider<EarningsBalanceClient> provider, Provider<EarningsBalanceHeaderMapper> provider2, Provider<EarningsBalanceHistoryMapper> provider3) {
        return new EarningsBalanceViewModel_Factory(provider, provider2, provider3);
    }

    public static EarningsBalanceViewModel c(EarningsBalanceClient earningsBalanceClient, EarningsBalanceHeaderMapper earningsBalanceHeaderMapper, EarningsBalanceHistoryMapper earningsBalanceHistoryMapper) {
        return new EarningsBalanceViewModel(earningsBalanceClient, earningsBalanceHeaderMapper, earningsBalanceHistoryMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceViewModel get() {
        return c(this.f28864a.get(), this.f28865b.get(), this.f28866c.get());
    }
}
