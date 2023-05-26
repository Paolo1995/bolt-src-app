package eu.bolt.driver.core.theme;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class AppThemeManager_Factory implements Factory<AppThemeManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f40963a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f40964b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ThemeHelper> f40965c;

    public AppThemeManager_Factory(Provider<Context> provider, Provider<RoutingManager> provider2, Provider<ThemeHelper> provider3) {
        this.f40963a = provider;
        this.f40964b = provider2;
        this.f40965c = provider3;
    }

    public static AppThemeManager_Factory a(Provider<Context> provider, Provider<RoutingManager> provider2, Provider<ThemeHelper> provider3) {
        return new AppThemeManager_Factory(provider, provider2, provider3);
    }

    public static AppThemeManager c(Context context, RoutingManager routingManager, ThemeHelper themeHelper) {
        return new AppThemeManager(context, routingManager, themeHelper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppThemeManager get() {
        return c(this.f40963a.get(), this.f40964b.get(), this.f40965c.get());
    }
}
