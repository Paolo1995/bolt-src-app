package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ServiceModule_ProvidesAnchoredTrueTimeProviderFactory implements Factory<AnchoredTrueTimeProvider> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ServiceModule_ProvidesAnchoredTrueTimeProviderFactory f20873a = new ServiceModule_ProvidesAnchoredTrueTimeProviderFactory();

        private InstanceHolder() {
        }
    }

    public static ServiceModule_ProvidesAnchoredTrueTimeProviderFactory a() {
        return InstanceHolder.f20873a;
    }

    public static AnchoredTrueTimeProvider c() {
        return (AnchoredTrueTimeProvider) Preconditions.checkNotNullFromProvides(ServiceModule.j());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AnchoredTrueTimeProvider get() {
        return c();
    }
}
