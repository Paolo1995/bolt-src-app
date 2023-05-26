package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderedMarkerHolder.kt */
/* loaded from: classes3.dex */
public final class RenderedMarkerHolderKt {
    public static final RenderedMarkerHolder a(RenderedMarkerHolder renderedMarkerHolder, int i8) {
        Intrinsics.f(renderedMarkerHolder, "<this>");
        return RenderedMarkerHolder.b(renderedMarkerHolder, null, renderedMarkerHolder.e().get(Integer.valueOf(i8)), null, 5, null);
    }

    public static final RenderedMarkerHolder b(RenderedMarkerHolder renderedMarkerHolder, int i8, RenderedMarker variant, int i9) {
        Map n8;
        Intrinsics.f(renderedMarkerHolder, "<this>");
        Intrinsics.f(variant, "variant");
        n8 = MapsKt__MapsKt.n(renderedMarkerHolder.e(), TuplesKt.a(Integer.valueOf(i8), variant));
        return RenderedMarkerHolder.b(renderedMarkerHolder, null, (RenderedMarker) n8.get(Integer.valueOf(i9)), n8, 1, null);
    }

    public static final RenderedMarkerHolder c(RenderedMarkerHolder renderedMarkerHolder, int i8, int i9) {
        Map j8;
        Intrinsics.f(renderedMarkerHolder, "<this>");
        j8 = MapsKt__MapsKt.j(renderedMarkerHolder.e(), Integer.valueOf(i8));
        return RenderedMarkerHolder.b(renderedMarkerHolder, null, (RenderedMarker) j8.get(Integer.valueOf(i9)), j8, 1, null);
    }
}
