package ee.mtakso.driver.di.modules;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.converter.gson.GsonConverterFactory;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidesGsonConverterFactoryFactory implements Factory<GsonConverterFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20843a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f20844b;

    public NetworkModule_ProvidesGsonConverterFactoryFactory(NetworkModule networkModule, Provider<Gson> provider) {
        this.f20843a = networkModule;
        this.f20844b = provider;
    }

    public static NetworkModule_ProvidesGsonConverterFactoryFactory a(NetworkModule networkModule, Provider<Gson> provider) {
        return new NetworkModule_ProvidesGsonConverterFactoryFactory(networkModule, provider);
    }

    public static GsonConverterFactory c(NetworkModule networkModule, Gson gson) {
        return (GsonConverterFactory) Preconditions.checkNotNullFromProvides(networkModule.B(gson));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GsonConverterFactory get() {
        return c(this.f20843a, this.f20844b.get());
    }
}
