package eu.bolt.driver.core.theme;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppThemeManager.kt */
/* loaded from: classes5.dex */
public final class AppThemeManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40959a;

    /* renamed from: b  reason: collision with root package name */
    private final RoutingManager f40960b;

    /* renamed from: c  reason: collision with root package name */
    private final ThemeHelper f40961c;

    /* compiled from: AppThemeManager.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40962a;

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
            f40962a = iArr;
        }
    }

    @Inject
    public AppThemeManager(Context context, RoutingManager routingManager, ThemeHelper themeHelper) {
        Intrinsics.f(context, "context");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(themeHelper, "themeHelper");
        this.f40959a = context;
        this.f40960b = routingManager;
        this.f40961c = themeHelper;
    }

    public final void a(AppThemeMode appThemeMode) {
        Intrinsics.f(appThemeMode, "appThemeMode");
        this.f40961c.d(appThemeMode);
        RoutingCommand.ActivityClass c8 = this.f40961c.c();
        AppCompatDelegate.W(appThemeMode.c());
        this.f40960b.b(c8, true);
    }

    public final void b(MapTheme mapStyle) {
        Intrinsics.f(mapStyle, "mapStyle");
        this.f40961c.b(mapStyle);
    }

    public final AppThemeMode c() {
        int i8;
        boolean g8 = this.f40961c.g();
        AppThemeMode a8 = this.f40961c.a();
        AppThemeMode e8 = this.f40961c.e();
        if (g8) {
            if (a8 == null) {
                i8 = -1;
            } else {
                i8 = WhenMappings.f40962a[a8.ordinal()];
            }
            if (i8 == -1 || i8 == 1) {
                return AppThemeMode.f40966g.a();
            }
            return a8;
        } else if (e8 == null) {
            return AppThemeMode.f40966g.a();
        } else {
            return e8;
        }
    }

    public final MapTheme d() {
        boolean g8 = this.f40961c.g();
        boolean f8 = this.f40961c.f();
        int i8 = WhenMappings.f40962a[c().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        int i9 = this.f40959a.getResources().getConfiguration().uiMode & 48;
                        if (i9 != 16) {
                            if (i9 != 32) {
                                return MapTheme.LIGHT;
                            }
                            return MapTheme.DARK;
                        }
                        return MapTheme.LIGHT;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return MapTheme.LIGHT;
            }
            return MapTheme.DARK;
        } else if (!g8 && f8) {
            return MapTheme.DARK;
        } else {
            return MapTheme.LIGHT;
        }
    }
}
