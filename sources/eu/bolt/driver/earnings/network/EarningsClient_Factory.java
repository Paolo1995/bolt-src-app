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
public final class EarningsClient_Factory implements Factory<EarningsClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsApi> f41490a;

    public EarningsClient_Factory(Provider<EarningsApi> provider) {
        this.f41490a = provider;
    }

    public static EarningsClient_Factory a(Provider<EarningsApi> provider) {
        return new EarningsClient_Factory(provider);
    }

    public static EarningsClient c(EarningsApi earningsApi) {
        return new EarningsClient(earningsApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsClient get() {
        return c(this.f41490a.get());
    }
}
