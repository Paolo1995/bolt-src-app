package ee.mtakso.driver.ui.screens.home.v3.delegate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeeplinkDelegate_Factory implements Factory<DeeplinkDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeepLinkParser> f29873a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeepLinkManager> f29874b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f29875c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RoutingManager> f29876d;

    public DeeplinkDelegate_Factory(Provider<DeepLinkParser> provider, Provider<DeepLinkManager> provider2, Provider<CompositeUrlLauncher> provider3, Provider<RoutingManager> provider4) {
        this.f29873a = provider;
        this.f29874b = provider2;
        this.f29875c = provider3;
        this.f29876d = provider4;
    }

    public static DeeplinkDelegate_Factory a(Provider<DeepLinkParser> provider, Provider<DeepLinkManager> provider2, Provider<CompositeUrlLauncher> provider3, Provider<RoutingManager> provider4) {
        return new DeeplinkDelegate_Factory(provider, provider2, provider3, provider4);
    }

    public static DeeplinkDelegate c(DeepLinkParser deepLinkParser, DeepLinkManager deepLinkManager, CompositeUrlLauncher compositeUrlLauncher, RoutingManager routingManager) {
        return new DeeplinkDelegate(deepLinkParser, deepLinkManager, compositeUrlLauncher, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeeplinkDelegate get() {
        return c(this.f29873a.get(), this.f29874b.get(), this.f29875c.get(), this.f29876d.get());
    }
}
