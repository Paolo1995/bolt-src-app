package ee.mtakso.driver.ui.screens.earnings.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.earnings.EarningsClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsInteractor_Factory implements Factory<EarningsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsClient> f28518a;

    public EarningsInteractor_Factory(Provider<EarningsClient> provider) {
        this.f28518a = provider;
    }

    public static EarningsInteractor_Factory a(Provider<EarningsClient> provider) {
        return new EarningsInteractor_Factory(provider);
    }

    public static EarningsInteractor c(EarningsClient earningsClient) {
        return new EarningsInteractor(earningsClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsInteractor get() {
        return c(this.f28518a.get());
    }
}
