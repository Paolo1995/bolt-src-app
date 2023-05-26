package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.PartnerAuthorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvidePartnerBoltDriverVerificationRetrofitBuilderFactory implements Factory<Retrofit.Builder> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20808a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20809b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20810c;

    public NetworkModule_ProvidePartnerBoltDriverVerificationRetrofitBuilderFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20808a = networkModule;
        this.f20809b = provider;
        this.f20810c = provider2;
    }

    public static NetworkModule_ProvidePartnerBoltDriverVerificationRetrofitBuilderFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvidePartnerBoltDriverVerificationRetrofitBuilderFactory(networkModule, provider, provider2);
    }

    public static Retrofit.Builder c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (Retrofit.Builder) Preconditions.checkNotNullFromProvides(networkModule.o(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Retrofit.Builder get() {
        return c(this.f20808a, this.f20809b.get(), this.f20810c.get());
    }
}
