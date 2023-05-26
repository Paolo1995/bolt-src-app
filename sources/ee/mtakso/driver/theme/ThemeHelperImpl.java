package ee.mtakso.driver.theme;

import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.param.field.BooleanSettingsField;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.theme.AppThemeMode;
import eu.bolt.driver.core.theme.MapTheme;
import eu.bolt.driver.core.theme.ThemeHelper;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeHelperImpl.kt */
/* loaded from: classes3.dex */
public final class ThemeHelperImpl implements ThemeHelper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f26221a;

    @Inject
    public ThemeHelperImpl(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f26221a = driverProvider;
    }

    @Override // eu.bolt.driver.core.theme.ThemeHelper
    public AppThemeMode a() {
        DriverSettings y7 = this.f26221a.y();
        if (y7 != null) {
            return y7.c();
        }
        return null;
    }

    @Override // eu.bolt.driver.core.theme.ThemeHelper
    public void b(MapTheme mapTheme) {
        boolean z7;
        Intrinsics.f(mapTheme, "mapTheme");
        if (AppThemeUtils.f34255a.c(mapTheme) == MapStyle.DARK) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f26221a.v().B().b(z7);
    }

    @Override // eu.bolt.driver.core.theme.ThemeHelper
    public RoutingCommand.ActivityClass c() {
        return new RoutingCommand.ActivityClass(new RoutingState(SimpleActivity.class, null, 2, null), SimpleActivity.class, SimpleActivity.Companion.d(SimpleActivity.f27004l, HomeFragment.class, null, false, 6, null), 0, 8, null);
    }

    @Override // eu.bolt.driver.core.theme.ThemeHelper
    public void d(AppThemeMode appThemeMode) {
        Intrinsics.f(appThemeMode, "appThemeMode");
        if (g()) {
            this.f26221a.v().W(appThemeMode);
        } else {
            this.f26221a.v().Z(appThemeMode);
        }
    }

    @Override // eu.bolt.driver.core.theme.ThemeHelper
    public AppThemeMode e() {
        DriverSettings y7 = this.f26221a.y();
        if (y7 != null) {
            return y7.n();
        }
        return null;
    }

    @Override // eu.bolt.driver.core.theme.ThemeHelper
    public boolean f() {
        BooleanSettingsField B;
        DriverSettings y7 = this.f26221a.y();
        if (y7 != null && (B = y7.B()) != null && B.a()) {
            return true;
        }
        return false;
    }

    @Override // eu.bolt.driver.core.theme.ThemeHelper
    public boolean g() {
        DriverFeatures e8 = this.f26221a.e();
        if (e8 != null) {
            return e8.q();
        }
        return false;
    }
}
