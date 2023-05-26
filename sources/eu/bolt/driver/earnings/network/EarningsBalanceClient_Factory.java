package eu.bolt.driver.earnings.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class EarningsBalanceClient_Factory implements Factory<EarningsBalanceClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsBalanceApi> f41478a;

    public EarningsBalanceClient_Factory(Provider<EarningsBalanceApi> provider) {
        this.f41478a = provider;
    }

    public static EarningsBalanceClient_Factory a(Provider<EarningsBalanceApi> provider) {
        return new EarningsBalanceClient_Factory(provider);
    }

    public static EarningsBalanceClient c(EarningsBalanceApi earningsBalanceApi) {
        return new EarningsBalanceClient(earningsBalanceApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceClient get() {
        return c(this.f41478a.get());
    }
}
