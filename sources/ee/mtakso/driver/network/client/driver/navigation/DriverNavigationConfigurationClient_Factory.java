package ee.mtakso.driver.network.client.driver.navigation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"eu.bolt.driver.core.di.coroutine.dispatcher.DispatcherIO"})
/* loaded from: classes3.dex */
public final class DriverNavigationConfigurationClient_Factory implements Factory<DriverNavigationConfigurationClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CoroutineDispatcher> f22061a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverNavigationConfigurationApi> f22062b;

    public DriverNavigationConfigurationClient_Factory(Provider<CoroutineDispatcher> provider, Provider<DriverNavigationConfigurationApi> provider2) {
        this.f22061a = provider;
        this.f22062b = provider2;
    }

    public static DriverNavigationConfigurationClient_Factory a(Provider<CoroutineDispatcher> provider, Provider<DriverNavigationConfigurationApi> provider2) {
        return new DriverNavigationConfigurationClient_Factory(provider, provider2);
    }

    public static DriverNavigationConfigurationClient c(CoroutineDispatcher coroutineDispatcher, DriverNavigationConfigurationApi driverNavigationConfigurationApi) {
        return new DriverNavigationConfigurationClient(coroutineDispatcher, driverNavigationConfigurationApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverNavigationConfigurationClient get() {
        return c(this.f22061a.get(), this.f22062b.get());
    }
}
