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
public final class LoyaltyOfferDetailsDeeplinkMapper_Factory implements Factory<LoyaltyOfferDetailsDeeplinkMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PartnerOffersAnalytics> f29988a;

    public LoyaltyOfferDetailsDeeplinkMapper_Factory(Provider<PartnerOffersAnalytics> provider) {
        this.f29988a = provider;
    }

    public static LoyaltyOfferDetailsDeeplinkMapper_Factory a(Provider<PartnerOffersAnalytics> provider) {
        return new LoyaltyOfferDetailsDeeplinkMapper_Factory(provider);
    }

    public static LoyaltyOfferDetailsDeeplinkMapper c(PartnerOffersAnalytics partnerOffersAnalytics) {
        return new LoyaltyOfferDetailsDeeplinkMapper(partnerOffersAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LoyaltyOfferDetailsDeeplinkMapper get() {
        return c(this.f29988a.get());
    }
}
