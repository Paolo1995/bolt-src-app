package ee.mtakso.driver.network.cache;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CacheProvider_Factory implements Factory<CacheProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f21309a;

    public CacheProvider_Factory(Provider<Context> provider) {
        this.f21309a = provider;
    }

    public static CacheProvider_Factory a(Provider<Context> provider) {
        return new CacheProvider_Factory(provider);
    }

    public static CacheProvider c(Context context) {
        return new CacheProvider(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CacheProvider get() {
        return c(this.f21309a.get());
    }
}
