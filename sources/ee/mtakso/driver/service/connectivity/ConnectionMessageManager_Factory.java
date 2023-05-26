package ee.mtakso.driver.service.connectivity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ConnectionMessageManager_Factory implements Factory<ConnectionMessageManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<NetworkService> f24086a;

    public ConnectionMessageManager_Factory(Provider<NetworkService> provider) {
        this.f24086a = provider;
    }

    public static ConnectionMessageManager_Factory a(Provider<NetworkService> provider) {
        return new ConnectionMessageManager_Factory(provider);
    }

    public static ConnectionMessageManager c(NetworkService networkService) {
        return new ConnectionMessageManager(networkService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConnectionMessageManager get() {
        return c(this.f24086a.get());
    }
}
