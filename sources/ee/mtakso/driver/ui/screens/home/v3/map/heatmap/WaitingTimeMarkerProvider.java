package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import android.graphics.Point;
import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.tile.TileVariant;
import ee.mtakso.driver.service.modules.map.TileIndex;
import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.service.modules.tile.MvtUtils;
import ee.mtakso.driver.service.modules.tile.TileUtils;
import ee.mtakso.driver.service.modules.tile.VectorProperties;
import ee.mtakso.driver.service.modules.tile.VectorPropertiesFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarker;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.maps.tile.mvt.MvtFeature;
import eu.bolt.driver.maps.tile.mvt.MvtLayer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vector_tile.VectorTile$Tile;

/* compiled from: WaitingTimeMarkerProvider.kt */
/* loaded from: classes3.dex */
public final class WaitingTimeMarkerProvider {

    /* renamed from: a  reason: collision with root package name */
    private final TileRequestMerger f30232a;

    /* renamed from: b  reason: collision with root package name */
    private final VectorPropertiesFactory f30233b;

    @Inject
    public WaitingTimeMarkerProvider(TileRequestMerger tileRequestMerger, VectorPropertiesFactory vectorPropertiesFactory) {
        Intrinsics.f(tileRequestMerger, "tileRequestMerger");
        Intrinsics.f(vectorPropertiesFactory, "vectorPropertiesFactory");
        this.f30232a = tileRequestMerger;
        this.f30233b = vectorPropertiesFactory;
    }

    public final List<MapTileMarker<WaitingTimeMarker>> a(TileIndex tileIndex, TileCollectionConfig config, MapStyle style) {
        Point b8;
        List<MapTileMarker<WaitingTimeMarker>> k8;
        Intrinsics.f(tileIndex, "tileIndex");
        Intrinsics.f(config, "config");
        Intrinsics.f(style, "style");
        TileVariant d8 = this.f30232a.h(tileIndex).d();
        if (!(d8 instanceof TileVariant.Mvt)) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        Iterable<MvtLayer> a8 = ((TileVariant.Mvt) d8).a().a();
        ArrayList arrayList = new ArrayList();
        for (MvtLayer mvtLayer : a8) {
            Iterable<MvtFeature> b9 = mvtLayer.b();
            ArrayList arrayList2 = new ArrayList();
            for (MvtFeature mvtFeature : b9) {
                VectorProperties a9 = this.f30233b.a(mvtFeature, config);
                MapTileMarker mapTileMarker = null;
                if (mvtFeature.e() == VectorTile$Tile.GeomType.POINT && (a9 instanceof VectorProperties.Label) && (b8 = MvtUtils.f25351a.b(mvtFeature.a(), 1.0f, 1.0f)) != null) {
                    mapTileMarker = new MapTileMarker(mvtFeature.c(), TileUtils.f25352a.d(tileIndex.a(), mvtLayer.a(), b8.x, b8.y), new WaitingTimeMarker(style, (VectorProperties.Label) a9));
                }
                if (mapTileMarker != null) {
                    arrayList2.add(mapTileMarker);
                }
            }
            CollectionsKt__MutableCollectionsKt.A(arrayList, arrayList2);
        }
        return arrayList;
    }
}
