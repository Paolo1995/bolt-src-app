package ee.mtakso.driver.service.earnings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.earnings.network.EarningsClient;
import eu.bolt.driver.earnings.network.EarningsGoalClient;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsManager_Factory implements Factory<EarningsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsClient> f24363a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EarningsGoalClient> f24364b;

    public EarningsManager_Factory(Provider<EarningsClient> provider, Provider<EarningsGoalClient> provider2) {
        this.f24363a = provider;
        this.f24364b = provider2;
    }

    public static EarningsManager_Factory a(Provider<EarningsClient> provider, Provider<EarningsGoalClient> provider2) {
        return new EarningsManager_Factory(provider, provider2);
    }

    public static EarningsManager c(EarningsClient earningsClient, EarningsGoalClient earningsGoalClient) {
        return new EarningsManager(earningsClient, earningsGoalClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsManager get() {
        return c(this.f24363a.get(), this.f24364b.get());
    }
}
