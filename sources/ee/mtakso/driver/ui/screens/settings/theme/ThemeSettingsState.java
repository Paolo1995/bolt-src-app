package ee.mtakso.driver.ui.screens.settings.theme;

import eu.bolt.driver.core.theme.AppThemeMode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeSettingsState.kt */
/* loaded from: classes5.dex */
public final class ThemeSettingsState {

    /* renamed from: a  reason: collision with root package name */
    private final List<AppThemeMode> f33304a;

    /* renamed from: b  reason: collision with root package name */
    private final AppThemeMode f33305b;

    /* JADX WARN: Multi-variable type inference failed */
    public ThemeSettingsState(List<? extends AppThemeMode> themeModes, AppThemeMode selectedThemeMode) {
        Intrinsics.f(themeModes, "themeModes");
        Intrinsics.f(selectedThemeMode, "selectedThemeMode");
        this.f33304a = themeModes;
        this.f33305b = selectedThemeMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThemeSettingsState b(ThemeSettingsState themeSettingsState, List list, AppThemeMode appThemeMode, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = themeSettingsState.f33304a;
        }
        if ((i8 & 2) != 0) {
            appThemeMode = themeSettingsState.f33305b;
        }
        return themeSettingsState.a(list, appThemeMode);
    }

    public final ThemeSettingsState a(List<? extends AppThemeMode> themeModes, AppThemeMode selectedThemeMode) {
        Intrinsics.f(themeModes, "themeModes");
        Intrinsics.f(selectedThemeMode, "selectedThemeMode");
        return new ThemeSettingsState(themeModes, selectedThemeMode);
    }

    public final AppThemeMode c() {
        return this.f33305b;
    }

    public final List<AppThemeMode> d() {
        return this.f33304a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThemeSettingsState) {
            ThemeSettingsState themeSettingsState = (ThemeSettingsState) obj;
            return Intrinsics.a(this.f33304a, themeSettingsState.f33304a) && this.f33305b == themeSettingsState.f33305b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f33304a.hashCode() * 31) + this.f33305b.hashCode();
    }

    public String toString() {
        List<AppThemeMode> list = this.f33304a;
        AppThemeMode appThemeMode = this.f33305b;
        return "ThemeSettingsState(themeModes=" + list + ", selectedThemeMode=" + appThemeMode + ")";
    }
}
