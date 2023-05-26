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
public final class EarningsGoalClient_Factory implements Factory<EarningsGoalClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsGoalApi> f41496a;

    public EarningsGoalClient_Factory(Provider<EarningsGoalApi> provider) {
        this.f41496a = provider;
    }

    public static EarningsGoalClient_Factory a(Provider<EarningsGoalApi> provider) {
        return new EarningsGoalClient_Factory(provider);
    }

    public static EarningsGoalClient c(EarningsGoalApi earningsGoalApi) {
        return new EarningsGoalClient(earningsGoalApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsGoalClient get() {
        return c(this.f41496a.get());
    }
}
