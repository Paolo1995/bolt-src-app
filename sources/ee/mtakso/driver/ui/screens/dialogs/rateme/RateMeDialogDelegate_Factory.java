package ee.mtakso.driver.ui.screens.dialogs.rateme;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateMeDialogDelegate_Factory implements Factory<RateMeDialogDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RateMePrefsManager> f28374a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RateMeAnalytics> f28375b;

    public RateMeDialogDelegate_Factory(Provider<RateMePrefsManager> provider, Provider<RateMeAnalytics> provider2) {
        this.f28374a = provider;
        this.f28375b = provider2;
    }

    public static RateMeDialogDelegate_Factory a(Provider<RateMePrefsManager> provider, Provider<RateMeAnalytics> provider2) {
        return new RateMeDialogDelegate_Factory(provider, provider2);
    }

    public static RateMeDialogDelegate c(RateMePrefsManager rateMePrefsManager, RateMeAnalytics rateMeAnalytics) {
        return new RateMeDialogDelegate(rateMePrefsManager, rateMeAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateMeDialogDelegate get() {
        return c(this.f28374a.get(), this.f28375b.get());
    }
}
