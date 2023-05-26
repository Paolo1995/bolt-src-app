package eu.bolt.android.maps.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoUtils.kt */
/* loaded from: classes5.dex */
public final class GeoUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final GeoUtils f36938a = new GeoUtils();

    private GeoUtils() {
    }

    private final double a(double d8) {
        return 2 * Math.asin(Math.sqrt(d8));
    }

    private final double c(Locatable locatable, Locatable locatable2) {
        return k(Math.toRadians(locatable.a()), Math.toRadians(locatable.b()), Math.toRadians(locatable2.a()), Math.toRadians(locatable2.b()));
    }

    private final double k(double d8, double d9, double d10, double d11) {
        return a(m(d8, d10, d9 - d11));
    }

    private final double l(double d8) {
        double sin = Math.sin(d8 * 0.5d);
        return sin * sin;
    }

    private final double m(double d8, double d9, double d10) {
        return l(d8 - d9) + (l(d10) * Math.cos(d8) * Math.cos(d9));
    }

    public final Locatable b(List<? extends Locatable> bounds) {
        Intrinsics.f(bounds, "bounds");
        double d8 = 2;
        return new MapPoint((n(bounds, new Function1<Locatable, Double>() { // from class: eu.bolt.android.maps.core.GeoUtils$centerOfBounds$north$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.a());
            }
        }) + o(bounds, new Function1<Locatable, Double>() { // from class: eu.bolt.android.maps.core.GeoUtils$centerOfBounds$south$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.a());
            }
        })) / d8, (o(bounds, new Function1<Locatable, Double>() { // from class: eu.bolt.android.maps.core.GeoUtils$centerOfBounds$west$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.b());
            }
        }) + n(bounds, new Function1<Locatable, Double>() { // from class: eu.bolt.android.maps.core.GeoUtils$centerOfBounds$east$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Double invoke(Locatable it) {
                Intrinsics.f(it, "it");
                return Double.valueOf(it.b());
            }
        })) / d8);
    }

    public final double d(Locatable from, Locatable to) {
        Intrinsics.f(from, "from");
        Intrinsics.f(to, "to");
        double radians = Math.toRadians(from.a());
        double radians2 = Math.toRadians(from.b());
        double radians3 = Math.toRadians(to.a());
        double radians4 = Math.toRadians(to.b()) - radians2;
        double atan2 = Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4))) + 6.283185307179586d;
        if (atan2 > 6.283185307179586d) {
            atan2 -= 6.283185307179586d;
        }
        return Math.toDegrees(atan2);
    }

    public final double e(double d8, double d9, double d10, double d11) {
        return f(new MapPoint(d8, d9), new MapPoint(d10, d11));
    }

    public final double f(Locatable from, Locatable to) {
        Intrinsics.f(from, "from");
        Intrinsics.f(to, "to");
        return c(from, to) * 6371009.0d;
    }

    public final Locatable g(Locatable from, double d8, double d9) {
        Intrinsics.f(from, "from");
        double d10 = d8 / 6371009.0d;
        double radians = Math.toRadians(d9);
        double radians2 = Math.toRadians(from.a());
        double radians3 = Math.toRadians(from.b());
        double cos = Math.cos(d10);
        double sin = Math.sin(d10);
        double sin2 = Math.sin(radians2);
        double cos2 = sin * Math.cos(radians2);
        double cos3 = (cos * sin2) + (Math.cos(radians) * cos2);
        return new MapPoint(Math.toDegrees(Math.asin(cos3)), Math.toDegrees(radians3 + Math.atan2(cos2 * Math.sin(radians), cos - (sin2 * cos3))));
    }

    public final List<Locatable> h(Locatable point, double d8) {
        List<Locatable> n8;
        Intrinsics.f(point, "point");
        n8 = CollectionsKt__CollectionsKt.n(g(point, d8, 0.0d), g(point, d8, 90.0d), g(point, d8, 180.0d), g(point, d8, 270.0d));
        return n8;
    }

    public final List<Locatable> i(Locatable point, double d8) {
        List<Locatable> n8;
        Intrinsics.f(point, "point");
        n8 = CollectionsKt__CollectionsKt.n(g(point, d8, 45.0d), g(point, d8, 215.0d));
        return n8;
    }

    public final List<Locatable> j(String encodedPath) {
        int i8;
        int i9;
        int i10;
        Intrinsics.f(encodedPath, "encodedPath");
        int length = encodedPath.length();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = 1;
            int i15 = 0;
            while (true) {
                i8 = i11 + 1;
                int charAt = (encodedPath.charAt(i11) - '?') - 1;
                i14 += charAt << i15;
                i15 += 5;
                if (charAt < 31) {
                    break;
                }
                i11 = i8;
            }
            if ((i14 & 1) != 0) {
                i9 = ~(i14 >> 1);
            } else {
                i9 = i14 >> 1;
            }
            int i16 = i9 + i12;
            int i17 = 1;
            int i18 = 0;
            while (true) {
                i10 = i8 + 1;
                int charAt2 = (encodedPath.charAt(i8) - '?') - 1;
                i17 += charAt2 << i18;
                i18 += 5;
                if (charAt2 < 31) {
                    break;
                }
                i8 = i10;
            }
            int i19 = i17 & 1;
            int i20 = i17 >> 1;
            if (i19 != 0) {
                i20 = ~i20;
            }
            i13 += i20;
            arrayList.add(new MapPoint(i16 * 1.0E-5d, i13 * 1.0E-5d));
            i12 = i16;
            i11 = i10;
        }
        return arrayList;
    }

    public final double n(List<? extends Locatable> items, Function1<? super Locatable, Double> selector) {
        Intrinsics.f(items, "items");
        Intrinsics.f(selector, "selector");
        double d8 = Double.MIN_VALUE;
        for (Locatable locatable : items) {
            d8 = Math.max(d8, selector.invoke(locatable).doubleValue());
        }
        return d8;
    }

    public final double o(List<? extends Locatable> items, Function1<? super Locatable, Double> selector) {
        Intrinsics.f(items, "items");
        Intrinsics.f(selector, "selector");
        double d8 = Double.MAX_VALUE;
        for (Locatable locatable : items) {
            d8 = Math.min(d8, selector.invoke(locatable).doubleValue());
        }
        return d8;
    }
}
