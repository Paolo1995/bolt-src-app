package ee.mtakso.driver.service.integration.appsflyer;

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
public final class AppsflyerManager_Factory implements Factory<AppsflyerManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f24525a;

    public AppsflyerManager_Factory(Provider<Context> provider) {
        this.f24525a = provider;
    }

    public static AppsflyerManager_Factory a(Provider<Context> provider) {
        return new AppsflyerManager_Factory(provider);
    }

    public static AppsflyerManager c(Context context) {
        return new AppsflyerManager(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppsflyerManager get() {
        return c(this.f24525a.get());
    }
}
