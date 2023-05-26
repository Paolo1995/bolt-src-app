package ee.mtakso.driver.ui.screens.earnings.v3.explanation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.earnings.network.EarningsClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsPayoutExplanationViewModel_Factory implements Factory<EarningsPayoutExplanationViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsClient> f29087a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f29088b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverInfoBlockMapper> f29089c;

    public EarningsPayoutExplanationViewModel_Factory(Provider<EarningsClient> provider, Provider<HtmlEngine> provider2, Provider<DriverInfoBlockMapper> provider3) {
        this.f29087a = provider;
        this.f29088b = provider2;
        this.f29089c = provider3;
    }

    public static EarningsPayoutExplanationViewModel_Factory a(Provider<EarningsClient> provider, Provider<HtmlEngine> provider2, Provider<DriverInfoBlockMapper> provider3) {
        return new EarningsPayoutExplanationViewModel_Factory(provider, provider2, provider3);
    }

    public static EarningsPayoutExplanationViewModel c(EarningsClient earningsClient, HtmlEngine htmlEngine, DriverInfoBlockMapper driverInfoBlockMapper) {
        return new EarningsPayoutExplanationViewModel(earningsClient, htmlEngine, driverInfoBlockMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsPayoutExplanationViewModel get() {
        return c(this.f29087a.get(), this.f29088b.get(), this.f29089c.get());
    }
}
