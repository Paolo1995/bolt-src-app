package eu.bolt.driver.core.ui.theme;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import eu.bolt.driver.core.R$attr;
import eu.bolt.driver.core.R$style;
import eu.bolt.driver.core.theme.Theme;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppThemeUiUtils.kt */
/* loaded from: classes5.dex */
public final class AppThemeUiUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AppThemeUiUtils f41180a = new AppThemeUiUtils();

    /* compiled from: AppThemeUiUtils.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41181a;

        static {
            int[] iArr = new int[Theme.values().length];
            try {
                iArr[Theme.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Theme.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Theme.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Theme.SYSTEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f41181a = iArr;
        }
    }

    private AppThemeUiUtils() {
    }

    public final void a(Activity target, Theme appThemeMode) {
        int i8;
        Intrinsics.f(target, "target");
        Intrinsics.f(appThemeMode, "appThemeMode");
        int i9 = WhenMappings.f41181a[appThemeMode.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 == 4) {
                        i8 = R$style.Theme_DayNight;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i8 = R$style.f40789c;
                }
            } else {
                i8 = R$style.Theme_Dark;
            }
        } else {
            i8 = 0;
        }
        if (i8 != 0) {
            target.setTheme(i8);
            int color = ContextCompat.getColor(target, ContextUtilsKt.d(target, R$attr.f40762a));
            boolean a8 = ContextUtilsKt.a(target, R$attr.f40763b);
            target.getWindow().addFlags(Integer.MIN_VALUE);
            target.getWindow().setStatusBarColor(color);
            new WindowInsetsControllerCompat(target.getWindow(), target.getWindow().getDecorView()).d(a8);
        }
    }
}
