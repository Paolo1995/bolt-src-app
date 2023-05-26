package ee.mtakso.driver.utils;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.core.PlatformManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class AppResolver_Factory implements Factory<AppResolver> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f36279a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PlatformManager> f36280b;

    public AppResolver_Factory(Provider<Context> provider, Provider<PlatformManager> provider2) {
        this.f36279a = provider;
        this.f36280b = provider2;
    }

    public static AppResolver_Factory a(Provider<Context> provider, Provider<PlatformManager> provider2) {
        return new AppResolver_Factory(provider, provider2);
    }

    public static AppResolver c(Context context, PlatformManager platformManager) {
        return new AppResolver(context, platformManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppResolver get() {
        return c(this.f36279a.get(), this.f36280b.get());
    }
}
