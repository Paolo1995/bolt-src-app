package ee.mtakso.driver.di.modules;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideGsonFactory implements Factory<Gson> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20798a;

    public NetworkModule_ProvideGsonFactory(NetworkModule networkModule) {
        this.f20798a = networkModule;
    }

    public static NetworkModule_ProvideGsonFactory a(NetworkModule networkModule) {
        return new NetworkModule_ProvideGsonFactory(networkModule);
    }

    public static Gson c(NetworkModule networkModule) {
        return (Gson) Preconditions.checkNotNullFromProvides(networkModule.k());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Gson get() {
        return c(this.f20798a);
    }
}
