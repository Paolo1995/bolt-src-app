package ee.mtakso.driver.ui.screens.order.scheduled;

import android.annotation.SuppressLint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapPointWithBearing.kt */
/* loaded from: classes3.dex */
public final class MapPointWithBearingKt {
    @SuppressLint({"RtlHardcoded"})
    public static final int a(MapPointWithBearing mapPointWithBearing) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        Intrinsics.f(mapPointWithBearing, "<this>");
        double c8 = mapPointWithBearing.c();
        boolean z13 = true;
        if (0.0d <= c8 && c8 <= 45.0d) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            if (45.0d <= c8 && c8 <= 90.0d) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                return 51;
            }
            if (90.0d <= c8 && c8 <= 135.0d) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                return 83;
            }
            if (135.0d <= c8 && c8 <= 180.0d) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return 81;
            }
            if (180.0d <= c8 && c8 <= 215.0d) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return 81;
            }
            if (215.0d <= c8 && c8 <= 270.0d) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                return 85;
            }
            if ((270.0d > c8 || c8 > 315.0d) ? false : false) {
                return 53;
            }
        }
        return 49;
    }
}
