package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.NewsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SettingsDeeplinkMapper;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeeplinkHomeRouter_Factory implements Factory<DeeplinkHomeRouter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SettingsDeeplinkMapper> f29960a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NewsDeeplinkMapper> f29961b;

    public DeeplinkHomeRouter_Factory(Provider<SettingsDeeplinkMapper> provider, Provider<NewsDeeplinkMapper> provider2) {
        this.f29960a = provider;
        this.f29961b = provider2;
    }

    public static DeeplinkHomeRouter_Factory a(Provider<SettingsDeeplinkMapper> provider, Provider<NewsDeeplinkMapper> provider2) {
        return new DeeplinkHomeRouter_Factory(provider, provider2);
    }

    public static DeeplinkHomeRouter c(SettingsDeeplinkMapper settingsDeeplinkMapper, NewsDeeplinkMapper newsDeeplinkMapper) {
        return new DeeplinkHomeRouter(settingsDeeplinkMapper, newsDeeplinkMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeeplinkHomeRouter get() {
        return c(this.f29960a.get(), this.f29961b.get());
    }
}
