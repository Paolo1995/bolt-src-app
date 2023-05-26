package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.earnings.network.EarningsClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBreakdownViewModel_Factory implements Factory<EarningsBreakdownViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsClient> f28957a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EarningsBreakdownMapper> f28958b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EarningsBreakdownStubFactory> f28959c;

    public EarningsBreakdownViewModel_Factory(Provider<EarningsClient> provider, Provider<EarningsBreakdownMapper> provider2, Provider<EarningsBreakdownStubFactory> provider3) {
        this.f28957a = provider;
        this.f28958b = provider2;
        this.f28959c = provider3;
    }

    public static EarningsBreakdownViewModel_Factory a(Provider<EarningsClient> provider, Provider<EarningsBreakdownMapper> provider2, Provider<EarningsBreakdownStubFactory> provider3) {
        return new EarningsBreakdownViewModel_Factory(provider, provider2, provider3);
    }

    public static EarningsBreakdownViewModel c(EarningsClient earningsClient, EarningsBreakdownMapper earningsBreakdownMapper, EarningsBreakdownStubFactory earningsBreakdownStubFactory) {
        return new EarningsBreakdownViewModel(earningsClient, earningsBreakdownMapper, earningsBreakdownStubFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBreakdownViewModel get() {
        return c(this.f28957a.get(), this.f28958b.get(), this.f28959c.get());
    }
}
