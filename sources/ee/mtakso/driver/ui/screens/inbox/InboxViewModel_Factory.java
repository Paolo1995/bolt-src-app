package ee.mtakso.driver.ui.screens.inbox;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.ui.interactor.inbox.InboxItemsInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InboxViewModel_Factory implements Factory<InboxViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<InboxItemsInteractor> f30366a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NewsAnalytics> f30367b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CleverTapManager> f30368c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PartnerOffersAnalytics> f30369d;

    public InboxViewModel_Factory(Provider<InboxItemsInteractor> provider, Provider<NewsAnalytics> provider2, Provider<CleverTapManager> provider3, Provider<PartnerOffersAnalytics> provider4) {
        this.f30366a = provider;
        this.f30367b = provider2;
        this.f30368c = provider3;
        this.f30369d = provider4;
    }

    public static InboxViewModel_Factory a(Provider<InboxItemsInteractor> provider, Provider<NewsAnalytics> provider2, Provider<CleverTapManager> provider3, Provider<PartnerOffersAnalytics> provider4) {
        return new InboxViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static InboxViewModel c(InboxItemsInteractor inboxItemsInteractor, NewsAnalytics newsAnalytics, CleverTapManager cleverTapManager, PartnerOffersAnalytics partnerOffersAnalytics) {
        return new InboxViewModel(inboxItemsInteractor, newsAnalytics, cleverTapManager, partnerOffersAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InboxViewModel get() {
        return c(this.f30366a.get(), this.f30367b.get(), this.f30368c.get(), this.f30369d.get());
    }
}
