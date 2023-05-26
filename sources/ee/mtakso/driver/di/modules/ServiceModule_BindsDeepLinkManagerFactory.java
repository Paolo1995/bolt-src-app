package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ServiceModule_BindsDeepLinkManagerFactory implements Factory<DeepLinkManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeepLinkParser> f20871a;

    public ServiceModule_BindsDeepLinkManagerFactory(Provider<DeepLinkParser> provider) {
        this.f20871a = provider;
    }

    public static DeepLinkManager a(DeepLinkParser deepLinkParser) {
        return (DeepLinkManager) Preconditions.checkNotNullFromProvides(ServiceModule.e(deepLinkParser));
    }

    public static ServiceModule_BindsDeepLinkManagerFactory b(Provider<DeepLinkParser> provider) {
        return new ServiceModule_BindsDeepLinkManagerFactory(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public DeepLinkManager get() {
        return a(this.f20871a.get());
    }
}
