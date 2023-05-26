package ee.mtakso.driver.network.client.driver;

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
public final class DriverConfigurationClient_Factory implements Factory<DriverConfigurationClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CoroutineDispatcher> f21913a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverConfigurationApi> f21914b;

    public DriverConfigurationClient_Factory(Provider<CoroutineDispatcher> provider, Provider<DriverConfigurationApi> provider2) {
        this.f21913a = provider;
        this.f21914b = provider2;
    }

    public static DriverConfigurationClient_Factory a(Provider<CoroutineDispatcher> provider, Provider<DriverConfigurationApi> provider2) {
        return new DriverConfigurationClient_Factory(provider, provider2);
    }

    public static DriverConfigurationClient c(CoroutineDispatcher coroutineDispatcher, DriverConfigurationApi driverConfigurationApi) {
        return new DriverConfigurationClient(coroutineDispatcher, driverConfigurationApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverConfigurationClient get() {
        return c(this.f21913a.get(), this.f21914b.get());
    }
}
