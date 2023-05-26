package ee.mtakso.driver.ui.screens.dialogs.rateme;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.RateMeTracing;
import ee.mtakso.driver.ui.interactor.rateme.RateMeFetchCategoriesInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateMeCategoryViewModel_Factory implements Factory<RateMeCategoryViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RateMeFetchCategoriesInteractor> f28348a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RateMeAnalytics> f28349b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RateMeTracing> f28350c;

    public RateMeCategoryViewModel_Factory(Provider<RateMeFetchCategoriesInteractor> provider, Provider<RateMeAnalytics> provider2, Provider<RateMeTracing> provider3) {
        this.f28348a = provider;
        this.f28349b = provider2;
        this.f28350c = provider3;
    }

    public static RateMeCategoryViewModel_Factory a(Provider<RateMeFetchCategoriesInteractor> provider, Provider<RateMeAnalytics> provider2, Provider<RateMeTracing> provider3) {
        return new RateMeCategoryViewModel_Factory(provider, provider2, provider3);
    }

    public static RateMeCategoryViewModel c(RateMeFetchCategoriesInteractor rateMeFetchCategoriesInteractor, RateMeAnalytics rateMeAnalytics, RateMeTracing rateMeTracing) {
        return new RateMeCategoryViewModel(rateMeFetchCategoriesInteractor, rateMeAnalytics, rateMeTracing);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateMeCategoryViewModel get() {
        return c(this.f28348a.get(), this.f28349b.get(), this.f28350c.get());
    }
}
