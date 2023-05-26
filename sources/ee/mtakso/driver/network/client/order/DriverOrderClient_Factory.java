package ee.mtakso.driver.network.client.order;

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
public final class DriverOrderClient_Factory implements Factory<DriverOrderClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CoroutineDispatcher> f22340a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverOrderApi> f22341b;

    public DriverOrderClient_Factory(Provider<CoroutineDispatcher> provider, Provider<DriverOrderApi> provider2) {
        this.f22340a = provider;
        this.f22341b = provider2;
    }

    public static DriverOrderClient_Factory a(Provider<CoroutineDispatcher> provider, Provider<DriverOrderApi> provider2) {
        return new DriverOrderClient_Factory(provider, provider2);
    }

    public static DriverOrderClient c(CoroutineDispatcher coroutineDispatcher, DriverOrderApi driverOrderApi) {
        return new DriverOrderClient(coroutineDispatcher, driverOrderApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverOrderClient get() {
        return c(this.f22340a.get(), this.f22341b.get());
    }
}
