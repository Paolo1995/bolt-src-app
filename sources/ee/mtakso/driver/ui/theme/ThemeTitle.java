package ee.mtakso.driver.ui.theme;

import eu.bolt.driver.core.theme.Theme;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeTitle.kt */
/* loaded from: classes5.dex */
public enum ThemeTitle {
    LIGHT("light"),
    DARK("dark");
    

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f34260g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final String f34264f;

    /* compiled from: ThemeTitle.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* compiled from: ThemeTitle.kt */
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f34265a;

            static {
                int[] iArr = new int[Theme.values().length];
                try {
                    iArr[Theme.LIGHT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f34265a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Theme theme) {
            Intrinsics.f(theme, "theme");
            if (WhenMappings.f34265a[theme.ordinal()] == 1) {
                return ThemeTitle.LIGHT.c();
            }
            return ThemeTitle.DARK.c();
        }
    }

    ThemeTitle(String str) {
        this.f34264f = str;
    }

    public final String c() {
        return this.f34264f;
    }
}
