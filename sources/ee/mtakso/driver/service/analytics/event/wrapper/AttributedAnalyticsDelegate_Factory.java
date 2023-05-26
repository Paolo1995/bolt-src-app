package ee.mtakso.driver.service.analytics.event.wrapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AttributedAnalyticsDelegate_Factory implements Factory<AttributedAnalyticsDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnalyticsImpl> f23520a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AdvertiserIdProvider> f23521b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppsflyerManager> f23522c;

    public AttributedAnalyticsDelegate_Factory(Provider<AnalyticsImpl> provider, Provider<AdvertiserIdProvider> provider2, Provider<AppsflyerManager> provider3) {
        this.f23520a = provider;
        this.f23521b = provider2;
        this.f23522c = provider3;
    }

    public static AttributedAnalyticsDelegate_Factory a(Provider<AnalyticsImpl> provider, Provider<AdvertiserIdProvider> provider2, Provider<AppsflyerManager> provider3) {
        return new AttributedAnalyticsDelegate_Factory(provider, provider2, provider3);
    }

    public static AttributedAnalyticsDelegate c(AnalyticsImpl analyticsImpl, AdvertiserIdProvider advertiserIdProvider, AppsflyerManager appsflyerManager) {
        return new AttributedAnalyticsDelegate(analyticsImpl, advertiserIdProvider, appsflyerManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AttributedAnalyticsDelegate get() {
        return c(this.f23520a.get(), this.f23521b.get(), this.f23522c.get());
    }
}
