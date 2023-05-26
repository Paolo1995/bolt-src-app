package ee.mtakso.driver.ui.screens.home.v3;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkHomeRouter;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeeplinkHomeContainerCoordinator_Factory implements Factory<DeeplinkHomeContainerCoordinator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeeplinkHomeRouter> f29746a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeepLinkManager> f29747b;

    public DeeplinkHomeContainerCoordinator_Factory(Provider<DeeplinkHomeRouter> provider, Provider<DeepLinkManager> provider2) {
        this.f29746a = provider;
        this.f29747b = provider2;
    }

    public static DeeplinkHomeContainerCoordinator_Factory a(Provider<DeeplinkHomeRouter> provider, Provider<DeepLinkManager> provider2) {
        return new DeeplinkHomeContainerCoordinator_Factory(provider, provider2);
    }

    public static DeeplinkHomeContainerCoordinator c(DeeplinkHomeRouter deeplinkHomeRouter, DeepLinkManager deepLinkManager) {
        return new DeeplinkHomeContainerCoordinator(deeplinkHomeRouter, deepLinkManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeeplinkHomeContainerCoordinator get() {
        return c(this.f29746a.get(), this.f29747b.get());
    }
}
