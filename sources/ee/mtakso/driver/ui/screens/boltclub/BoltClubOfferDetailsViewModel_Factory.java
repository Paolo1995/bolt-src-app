package ee.mtakso.driver.ui.screens.boltclub;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BoltClubOfferDetailsViewModel_Factory implements Factory<BoltClubOfferDetailsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BoltClubClient> f27157a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BoltClubDataMapper> f27158b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LanguageManager> f27159c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f27160d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PartnerOffersAnalytics> f27161e;

    public BoltClubOfferDetailsViewModel_Factory(Provider<BoltClubClient> provider, Provider<BoltClubDataMapper> provider2, Provider<LanguageManager> provider3, Provider<CompositeUrlLauncher> provider4, Provider<PartnerOffersAnalytics> provider5) {
        this.f27157a = provider;
        this.f27158b = provider2;
        this.f27159c = provider3;
        this.f27160d = provider4;
        this.f27161e = provider5;
    }

    public static BoltClubOfferDetailsViewModel_Factory a(Provider<BoltClubClient> provider, Provider<BoltClubDataMapper> provider2, Provider<LanguageManager> provider3, Provider<CompositeUrlLauncher> provider4, Provider<PartnerOffersAnalytics> provider5) {
        return new BoltClubOfferDetailsViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static BoltClubOfferDetailsViewModel c(BoltClubClient boltClubClient, BoltClubDataMapper boltClubDataMapper, LanguageManager languageManager, CompositeUrlLauncher compositeUrlLauncher, PartnerOffersAnalytics partnerOffersAnalytics) {
        return new BoltClubOfferDetailsViewModel(boltClubClient, boltClubDataMapper, languageManager, compositeUrlLauncher, partnerOffersAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltClubOfferDetailsViewModel get() {
        return c(this.f27157a.get(), this.f27158b.get(), this.f27159c.get(), this.f27160d.get(), this.f27161e.get());
    }
}
