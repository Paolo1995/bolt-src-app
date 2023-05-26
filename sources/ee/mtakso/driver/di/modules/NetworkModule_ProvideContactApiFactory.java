package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.contact.ContactApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class NetworkModule_ProvideContactApiFactory implements Factory<ContactApi> {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkModule f20777a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20778b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20779c;

    public NetworkModule_ProvideContactApiFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20777a = networkModule;
        this.f20778b = provider;
        this.f20779c = provider2;
    }

    public static NetworkModule_ProvideContactApiFactory a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new NetworkModule_ProvideContactApiFactory(networkModule, provider, provider2);
    }

    public static ContactApi c(NetworkModule networkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (ContactApi) Preconditions.checkNotNullFromProvides(networkModule.d(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ContactApi get() {
        return c(this.f20777a, this.f20778b.get(), this.f20779c.get());
    }
}
