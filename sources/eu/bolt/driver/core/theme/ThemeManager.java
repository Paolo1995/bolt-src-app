package eu.bolt.driver.core.theme;

import android.os.Build;
import eu.bolt.driver.core.field.SimpleField;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: ThemeManager.kt */
/* loaded from: classes5.dex */
public final class ThemeManager {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f40981d = {Reflection.d(new MutablePropertyReference1Impl(ThemeManager.class, "theme", "getTheme()Leu/bolt/driver/core/theme/AppThemeMode;", 0))};

    /* renamed from: a  reason: collision with root package name */
    private final boolean f40982a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f40983b;

    /* renamed from: c  reason: collision with root package name */
    private final SimpleField f40984c;

    /* compiled from: ThemeManager.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40985a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f40986b;

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
            f40985a = iArr;
            int[] iArr2 = new int[AppThemeMode.values().length];
            try {
                iArr2[AppThemeMode.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AppThemeMode.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AppThemeMode.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AppThemeMode.DAY_NIGHT_SYSTEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f40986b = iArr2;
        }
    }

    public ThemeManager(SimpleField<AppThemeMode> themeField, boolean z7) {
        Lazy b8;
        Intrinsics.f(themeField, "themeField");
        this.f40982a = z7;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Theme>() { // from class: eu.bolt.driver.core.theme.ThemeManager$defaultThemeMode$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Theme invoke() {
                if (Build.VERSION.SDK_INT < 29) {
                    return Theme.LIGHT;
                }
                return Theme.SYSTEM;
            }
        });
        this.f40983b = b8;
        this.f40984c = themeField;
    }

    private final Theme b() {
        return (Theme) this.f40983b.getValue();
    }

    private final AppThemeMode c() {
        return (AppThemeMode) this.f40984c.a(this, f40981d[0]);
    }

    private final Theme d(AppThemeMode appThemeMode) {
        int i8 = WhenMappings.f40986b[appThemeMode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return Theme.SYSTEM;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return Theme.LIGHT;
            }
            return Theme.DARK;
        }
        return Theme.LEGACY;
    }

    public final Theme a() {
        if (this.f40982a) {
            return d(c());
        }
        return b();
    }
}
