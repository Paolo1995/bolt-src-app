package ee.mtakso.driver.network.client;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class ShardApiProvider_Factory implements Factory<ShardApiProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ApiFactory> f21341a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21342b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OkHttpClient> f21343c;

    public ShardApiProvider_Factory(Provider<ApiFactory> provider, Provider<DriverProvider> provider2, Provider<OkHttpClient> provider3) {
        this.f21341a = provider;
        this.f21342b = provider2;
        this.f21343c = provider3;
    }

    public static ShardApiProvider_Factory a(Provider<ApiFactory> provider, Provider<DriverProvider> provider2, Provider<OkHttpClient> provider3) {
        return new ShardApiProvider_Factory(provider, provider2, provider3);
    }

    public static ShardApiProvider c(ApiFactory apiFactory, DriverProvider driverProvider, Lazy<OkHttpClient> lazy) {
        return new ShardApiProvider(apiFactory, driverProvider, lazy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ShardApiProvider get() {
        return c(this.f21341a.get(), this.f21342b.get(), DoubleCheck.lazy(this.f21343c));
    }
}
