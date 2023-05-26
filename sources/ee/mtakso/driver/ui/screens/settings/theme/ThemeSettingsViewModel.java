package ee.mtakso.driver.ui.screens.settings.theme;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.theme.AppThemeMode;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class ThemeSettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final AppThemeManager f33306f;

    /* renamed from: g  reason: collision with root package name */
    private final SettingsAnalytics f33307g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<ThemeSettingsState> f33308h;

    @Inject
    public ThemeSettingsViewModel(AppThemeManager appThemeManager, SettingsAnalytics analytics) {
        List n8;
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(analytics, "analytics");
        this.f33306f = appThemeManager;
        this.f33307g = analytics;
        n8 = CollectionsKt__CollectionsKt.n(AppThemeMode.DAY_NIGHT_SYSTEM, AppThemeMode.DARK, AppThemeMode.LIGHT);
        this.f33308h = new MutableLiveData<>(new ThemeSettingsState(n8, appThemeManager.c()));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f33307g.A2();
    }

    public final LiveData<ThemeSettingsState> D() {
        return this.f33308h;
    }

    public final void E(AppThemeMode themeMode) {
        Intrinsics.f(themeMode, "themeMode");
        if (themeMode == ((ThemeSettingsState) LiveDataExtKt.b(this.f33308h)).c()) {
            return;
        }
        this.f33306f.a(themeMode);
        MutableLiveData<ThemeSettingsState> mutableLiveData = this.f33308h;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "themeSettingsStateData.requireValue()");
        mutableLiveData.o(ThemeSettingsState.b((ThemeSettingsState) b8, null, this.f33306f.c(), 1, null));
        this.f33307g.d2(themeMode);
    }
}
