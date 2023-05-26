package ee.mtakso.driver.navigation.navigators;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WazeNavigator_Factory implements Factory<WazeNavigator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PlatformManager> f21269a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppResolver> f21270b;

    public WazeNavigator_Factory(Provider<PlatformManager> provider, Provider<AppResolver> provider2) {
        this.f21269a = provider;
        this.f21270b = provider2;
    }

    public static WazeNavigator_Factory a(Provider<PlatformManager> provider, Provider<AppResolver> provider2) {
        return new WazeNavigator_Factory(provider, provider2);
    }

    public static WazeNavigator c(PlatformManager platformManager, AppResolver appResolver) {
        return new WazeNavigator(platformManager, appResolver);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WazeNavigator get() {
        return c(this.f21269a.get(), this.f21270b.get());
    }
}
