package ee.mtakso.driver.service.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkService_Factory implements Factory<NetworkService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f24102a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ConnectivityManager> f24103b;

    public NetworkService_Factory(Provider<Context> provider, Provider<ConnectivityManager> provider2) {
        this.f24102a = provider;
        this.f24103b = provider2;
    }

    public static NetworkService_Factory a(Provider<Context> provider, Provider<ConnectivityManager> provider2) {
        return new NetworkService_Factory(provider, provider2);
    }

    public static NetworkService c(Context context, ConnectivityManager connectivityManager) {
        return new NetworkService(context, connectivityManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NetworkService get() {
        return c(this.f24102a.get(), this.f24103b.get());
    }
}
