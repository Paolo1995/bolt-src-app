package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkParser;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ServiceModule_BindsDeepLinkParserFactory implements Factory<DeepLinkParser> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ServiceModule_BindsDeepLinkParserFactory f20872a = new ServiceModule_BindsDeepLinkParserFactory();

        private InstanceHolder() {
        }
    }

    public static DeepLinkParser a() {
        return (DeepLinkParser) Preconditions.checkNotNullFromProvides(ServiceModule.f());
    }

    public static ServiceModule_BindsDeepLinkParserFactory b() {
        return InstanceHolder.f20872a;
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public DeepLinkParser get() {
        return a();
    }
}
