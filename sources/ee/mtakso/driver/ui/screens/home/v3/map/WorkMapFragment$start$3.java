package ee.mtakso.driver.ui.screens.home.v3.map;

import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarker;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerRenderer;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarker;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkMapFragment.kt */
/* loaded from: classes3.dex */
/* synthetic */ class WorkMapFragment$start$3 extends FunctionReferenceImpl implements Function1<MapTileMarker<WaitingTimeMarker>, MarkerParams> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkMapFragment$start$3(Object obj) {
        super(1, obj, WaitingTimeMarkerRenderer.class, "render", "render(Lee/mtakso/driver/ui/screens/home/v3/map/marker/MapTileMarker;)Leu/bolt/android/maps/core/plugin/driver/MarkerParams;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final MarkerParams invoke(MapTileMarker<WaitingTimeMarker> p02) {
        Intrinsics.f(p02, "p0");
        return ((WaitingTimeMarkerRenderer) this.f50989g).d(p02);
    }
}
