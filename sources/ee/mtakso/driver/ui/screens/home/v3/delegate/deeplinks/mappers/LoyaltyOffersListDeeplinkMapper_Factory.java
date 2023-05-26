package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LoyaltyOffersListDeeplinkMapper_Factory implements Factory<LoyaltyOffersListDeeplinkMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PartnerOffersAnalytics> f29991a;

    public LoyaltyOffersListDeeplinkMapper_Factory(Provider<PartnerOffersAnalytics> provider) {
        this.f29991a = provider;
    }

    public static LoyaltyOffersListDeeplinkMapper_Factory a(Provider<PartnerOffersAnalytics> provider) {
        return new LoyaltyOffersListDeeplinkMapper_Factory(provider);
    }

    public static LoyaltyOffersListDeeplinkMapper c(PartnerOffersAnalytics partnerOffersAnalytics) {
        return new LoyaltyOffersListDeeplinkMapper(partnerOffersAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LoyaltyOffersListDeeplinkMapper get() {
        return c(this.f29991a.get());
    }
}
