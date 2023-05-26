package ee.mtakso.driver.ui.theme;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.theme.AppThemeMode;
import eu.bolt.driver.core.theme.MapTheme;
import eu.bolt.driver.core.theme.Theme;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppThemeUtils.kt */
/* loaded from: classes5.dex */
public final class AppThemeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AppThemeUtils f34255a = new AppThemeUtils();

    /* compiled from: AppThemeUtils.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34256a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f34257b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f34258c;

        static {
            int[] iArr = new int[AppThemeMode.values().length];
            try {
                iArr[AppThemeMode.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppThemeMode.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppThemeMode.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppThemeMode.DAY_NIGHT_SYSTEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f34256a = iArr;
            int[] iArr2 = new int[MapTheme.values().length];
            try {
                iArr2[MapTheme.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MapTheme.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f34257b = iArr2;
            int[] iArr3 = new int[MapStyle.values().length];
            try {
                iArr3[MapStyle.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[MapStyle.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f34258c = iArr3;
        }
    }

    private AppThemeUtils() {
    }

    public final Integer a(AppThemeMode appThemeMode) {
        Intrinsics.f(appThemeMode, "appThemeMode");
        int i8 = WhenMappings.f34256a[appThemeMode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return Integer.valueOf((int) R.string.settings_app_theme_system);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return Integer.valueOf((int) R.string.settings_app_theme_light);
            }
            return Integer.valueOf((int) R.string.settings_app_theme_dark);
        }
        return null;
    }

    public final String b(Context context) {
        Intrinsics.f(context, "context");
        if (ContextUtilsKt.a(context, R.attr.isLightTheme)) {
            return ThemeTitle.f34260g.a(Theme.LIGHT);
        }
        return ThemeTitle.f34260g.a(Theme.DARK);
    }

    public final MapStyle c(MapTheme mapTheme) {
        Intrinsics.f(mapTheme, "mapTheme");
        int i8 = WhenMappings.f34257b[mapTheme.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return MapStyle.DARK;
            }
            throw new NoWhenBranchMatchedException();
        }
        return MapStyle.LIGHT;
    }

    public final MapTheme d(MapStyle mapStyle) {
        Intrinsics.f(mapStyle, "mapStyle");
        int i8 = WhenMappings.f34258c[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return MapTheme.DARK;
            }
            throw new NoWhenBranchMatchedException();
        }
        return MapTheme.LIGHT;
    }
}
