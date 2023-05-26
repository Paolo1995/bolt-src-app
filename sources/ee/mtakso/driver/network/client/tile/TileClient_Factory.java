package ee.mtakso.driver.network.client.tile;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.UrlFactory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class TileClient_Factory implements Factory<TileClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f22868a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UrlFactory> f22869b;

    public TileClient_Factory(Provider<OkHttpClient> provider, Provider<UrlFactory> provider2) {
        this.f22868a = provider;
        this.f22869b = provider2;
    }

    public static TileClient_Factory a(Provider<OkHttpClient> provider, Provider<UrlFactory> provider2) {
        return new TileClient_Factory(provider, provider2);
    }

    public static TileClient c(OkHttpClient okHttpClient, UrlFactory urlFactory) {
        return new TileClient(okHttpClient, urlFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TileClient get() {
        return c(this.f22868a.get(), this.f22869b.get());
    }
}
