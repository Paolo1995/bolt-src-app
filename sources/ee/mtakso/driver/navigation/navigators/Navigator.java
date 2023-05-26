package ee.mtakso.driver.navigation.navigators;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Navigator.kt */
/* loaded from: classes3.dex */
public interface Navigator {

    /* compiled from: Navigator.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        NO_NAVIGATION_SELECTED(0),
        TAXIFY_NAVIGATION(1),
        GOOGLE_MAPS(2),
        WAZE(3),
        YANDEX_MAPS(4),
        YANDEX_NAVIGATION(5),
        TWO_GIS_NAVIGATION(6),
        CITY_GUIDE_NAVIGATION(7),
        MAPS_ME(8),
        PETAL_MAPS(9);
        

        /* renamed from: g  reason: collision with root package name */
        public static final Companion f21237g = new Companion(null);

        /* renamed from: f  reason: collision with root package name */
        private final int f21249f;

        /* compiled from: Navigator.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Type a(int i8) {
                Type type;
                boolean z7;
                Type[] values = Type.values();
                int length = values.length;
                int i9 = 0;
                while (true) {
                    if (i9 < length) {
                        type = values[i9];
                        if (type.c() == i8) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            break;
                        }
                        i9++;
                    } else {
                        type = null;
                        break;
                    }
                }
                if (type != null) {
                    return type;
                }
                throw new IllegalStateException("Cannot find navigator by internalId (" + i8 + ")");
            }
        }

        /* compiled from: Navigator.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f21250a;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.TAXIFY_NAVIGATION.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.CITY_GUIDE_NAVIGATION.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Type.GOOGLE_MAPS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Type.WAZE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Type.YANDEX_MAPS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Type.YANDEX_NAVIGATION.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Type.TWO_GIS_NAVIGATION.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[Type.MAPS_ME.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[Type.PETAL_MAPS.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[Type.NO_NAVIGATION_SELECTED.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                f21250a = iArr;
            }
        }

        Type(int i8) {
            this.f21249f = i8;
        }

        public final int c() {
            return this.f21249f;
        }

        public final String e() {
            switch (WhenMappings.f21250a[ordinal()]) {
                case 1:
                    return "in-app navigation";
                case 2:
                    return "city guide navigation";
                case 3:
                    return "google maps navigation";
                case 4:
                    return "waze navigation";
                case 5:
                    return "yandex maps navigation";
                case 6:
                    return "yandex navi navigation";
                case 7:
                    return "2gis navigation";
                case 8:
                    return "mapsme navigation";
                case 9:
                    return "petal maps navigation";
                case 10:
                    return null;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    String a(Context context);

    boolean b();

    int c();

    Type getType();
}
