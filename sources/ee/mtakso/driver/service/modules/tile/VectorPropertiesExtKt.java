package ee.mtakso.driver.service.modules.tile;

import ee.mtakso.driver.service.modules.tile.VectorProperties;
import ee.mtakso.driver.ui.screens.order.MapStyleExtKt;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorPropertiesExt.kt */
/* loaded from: classes3.dex */
public final class VectorPropertiesExtKt {
    public static final Integer a(VectorProperties.Label label, MapStyle style) {
        Intrinsics.f(label, "<this>");
        Intrinsics.f(style, "style");
        return (Integer) MapStyleExtKt.c(style, label.e(), label.f());
    }

    public static final Integer b(VectorProperties.LocationAwarePolygon locationAwarePolygon, MapStyle style, boolean z7) {
        Intrinsics.f(locationAwarePolygon, "<this>");
        Intrinsics.f(style, "style");
        if (z7) {
            return (Integer) MapStyleExtKt.c(style, locationAwarePolygon.c(), locationAwarePolygon.d());
        }
        return (Integer) MapStyleExtKt.c(style, locationAwarePolygon.a(), locationAwarePolygon.b());
    }

    public static final Integer c(VectorProperties.Polygon polygon, MapStyle style) {
        Intrinsics.f(polygon, "<this>");
        Intrinsics.f(style, "style");
        return (Integer) MapStyleExtKt.c(style, polygon.a(), polygon.b());
    }

    public static final String d(VectorProperties.Label label, MapStyle style) {
        Intrinsics.f(label, "<this>");
        Intrinsics.f(style, "style");
        return (String) MapStyleExtKt.c(style, label.a(), label.b());
    }

    public static final Integer e(VectorProperties.LocationAwareLine locationAwareLine, MapStyle style, boolean z7) {
        Intrinsics.f(locationAwareLine, "<this>");
        Intrinsics.f(style, "style");
        if (z7) {
            return (Integer) MapStyleExtKt.c(style, locationAwareLine.a(), locationAwareLine.b());
        }
        return (Integer) MapStyleExtKt.c(style, locationAwareLine.c(), locationAwareLine.d());
    }
}
