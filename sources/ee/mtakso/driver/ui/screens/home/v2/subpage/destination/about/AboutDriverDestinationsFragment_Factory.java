package ee.mtakso.driver.ui.screens.home.v2.subpage.destination.about;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AboutDriverDestinationsFragment_Factory implements Factory<AboutDriverDestinationsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f29742a;

    public AboutDriverDestinationsFragment_Factory(Provider<ScreenAnalytics> provider) {
        this.f29742a = provider;
    }

    public static AboutDriverDestinationsFragment_Factory a(Provider<ScreenAnalytics> provider) {
        return new AboutDriverDestinationsFragment_Factory(provider);
    }

    public static AboutDriverDestinationsFragment c(ScreenAnalytics screenAnalytics) {
        return new AboutDriverDestinationsFragment(screenAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AboutDriverDestinationsFragment get() {
        return c(this.f29742a.get());
    }
}
