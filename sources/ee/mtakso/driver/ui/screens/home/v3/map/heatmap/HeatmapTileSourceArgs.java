package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapTileSourceArgs.kt */
/* loaded from: classes3.dex */
public final class HeatmapTileSourceArgs {

    /* renamed from: a  reason: collision with root package name */
    private final int f30218a;

    /* renamed from: b  reason: collision with root package name */
    private final MapStyle f30219b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30220c;

    /* renamed from: d  reason: collision with root package name */
    private final TileCollectionConfig f30221d;

    public HeatmapTileSourceArgs(int i8, MapStyle style, String collectionId, TileCollectionConfig tileCollectionConfig) {
        Intrinsics.f(style, "style");
        Intrinsics.f(collectionId, "collectionId");
        this.f30218a = i8;
        this.f30219b = style;
        this.f30220c = collectionId;
        this.f30221d = tileCollectionConfig;
    }

    public final String a() {
        return this.f30220c;
    }

    public final int b() {
        return this.f30218a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeatmapTileSourceArgs) {
            HeatmapTileSourceArgs heatmapTileSourceArgs = (HeatmapTileSourceArgs) obj;
            return this.f30218a == heatmapTileSourceArgs.f30218a && this.f30219b == heatmapTileSourceArgs.f30219b && Intrinsics.a(this.f30220c, heatmapTileSourceArgs.f30220c) && Intrinsics.a(this.f30221d, heatmapTileSourceArgs.f30221d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f30218a * 31) + this.f30219b.hashCode()) * 31) + this.f30220c.hashCode()) * 31;
        TileCollectionConfig tileCollectionConfig = this.f30221d;
        return hashCode + (tileCollectionConfig == null ? 0 : tileCollectionConfig.hashCode());
    }

    public String toString() {
        int i8 = this.f30218a;
        MapStyle mapStyle = this.f30219b;
        String str = this.f30220c;
        TileCollectionConfig tileCollectionConfig = this.f30221d;
        return "HeatmapTileSourceArgs(tileSize=" + i8 + ", style=" + mapStyle + ", collectionId=" + str + ", config=" + tileCollectionConfig + ")";
    }
}
