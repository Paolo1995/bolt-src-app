package ee.mtakso.driver.ui.screens.order;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MarkerParamsFactory_Factory implements Factory<MarkerParamsFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f30975a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppThemeManager> f30976b;

    public MarkerParamsFactory_Factory(Provider<Context> provider, Provider<AppThemeManager> provider2) {
        this.f30975a = provider;
        this.f30976b = provider2;
    }

    public static MarkerParamsFactory_Factory a(Provider<Context> provider, Provider<AppThemeManager> provider2) {
        return new MarkerParamsFactory_Factory(provider, provider2);
    }

    public static MarkerParamsFactory c(Context context, AppThemeManager appThemeManager) {
        return new MarkerParamsFactory(context, appThemeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MarkerParamsFactory get() {
        return c(this.f30975a.get(), this.f30976b.get());
    }
}
