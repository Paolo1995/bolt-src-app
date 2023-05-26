package ee.mtakso.driver.ui.theme;

import android.app.Activity;
import android.view.Window;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.utils.StatusBarUtils;
import eu.bolt.driver.core.R$style;
import eu.bolt.driver.core.theme.AppThemeMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeActivityExt.kt */
/* loaded from: classes5.dex */
public final class ThemeActivityExtKt {

    /* compiled from: ThemeActivityExt.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34259a;

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
            f34259a = iArr;
        }
    }

    public static final void a(Activity activity, AppThemeMode appThemeMode) {
        int i8;
        Intrinsics.f(activity, "<this>");
        Intrinsics.f(appThemeMode, "appThemeMode");
        int i9 = WhenMappings.f34259a[appThemeMode.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 == 4) {
                        i8 = R$style.Theme_DayNight;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i8 = 2132017818;
                }
            } else {
                i8 = R$style.Theme_Dark;
            }
        } else {
            i8 = 0;
        }
        if (i8 != 0) {
            activity.setTheme(i8);
            Window window = activity.getWindow();
            Intrinsics.e(window, "window");
            StatusBarUtils.a(window, ContextUtilsKt.d(activity, R.attr.colorPrimaryDark), ContextUtilsKt.a(activity, R.attr.isLightTheme));
        }
    }
}
