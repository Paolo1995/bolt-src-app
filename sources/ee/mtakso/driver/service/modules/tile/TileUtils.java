package ee.mtakso.driver.service.modules.tile;

import ee.mtakso.driver.service.modules.map.TilePosition;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapPoint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileUtils.kt */
/* loaded from: classes3.dex */
public final class TileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TileUtils f25352a = new TileUtils();

    private TileUtils() {
    }

    private final int a(double d8, int i8) {
        int i9 = 1 << i8;
        double d9 = 1;
        return Math.max(Math.min((int) Math.floor(((d9 - (Math.log(Math.tan(Math.toRadians(d8)) + (d9 / Math.cos(Math.toRadians(d8)))) / 3.141592653589793d)) / 2) * i9), i9 - 1), 0);
    }

    private final int b(double d8, int i8) {
        int i9 = 1 << i8;
        return Math.max(Math.min((int) Math.floor(((d8 + 180) / 360) * i9), i9 - 1), 0);
    }

    public final TilePosition c(Locatable locatable, int i8) {
        Intrinsics.f(locatable, "locatable");
        return new TilePosition(b(locatable.b(), i8), a(locatable.a(), i8), i8);
    }

    public final Locatable d(TilePosition coordinates, int i8, int i9, int i10) {
        Intrinsics.f(coordinates, "coordinates");
        double d8 = i8;
        double a8 = coordinates.a() + (i9 / d8);
        double b8 = coordinates.b() + (i10 / d8);
        double pow = Math.pow(2.0d, coordinates.c());
        double d9 = 180;
        return new MapPoint((Math.atan(Math.sinh((1 - ((2 * b8) / pow)) * 3.141592653589793d)) * d9) / 3.141592653589793d, ((a8 / pow) * 360) - d9);
    }
}
