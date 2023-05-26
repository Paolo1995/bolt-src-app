package ee.mtakso.driver.service.routing;

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
public final class AppRoutingManager_Factory implements Factory<AppRoutingManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f25871a;

    public AppRoutingManager_Factory(Provider<Context> provider) {
        this.f25871a = provider;
    }

    public static AppRoutingManager_Factory a(Provider<Context> provider) {
        return new AppRoutingManager_Factory(provider);
    }

    public static AppRoutingManager c(Context context) {
        return new AppRoutingManager(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppRoutingManager get() {
        return c(this.f25871a.get());
    }
}
