package ee.mtakso.driver.ui.screens.home.v3.map.fifo;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueTileState.kt */
/* loaded from: classes3.dex */
public final class FifoQueueTileState {

    /* renamed from: a  reason: collision with root package name */
    private final int f30204a;

    /* renamed from: b  reason: collision with root package name */
    private final MapStyle f30205b;

    /* renamed from: c  reason: collision with root package name */
    private final TileCollectionConfig f30206c;

    /* renamed from: d  reason: collision with root package name */
    private final String f30207d;

    public FifoQueueTileState() {
        this(0, null, null, null, 15, null);
    }

    public FifoQueueTileState(int i8, MapStyle mapStyle, TileCollectionConfig tileCollectionConfig, String str) {
        Intrinsics.f(mapStyle, "mapStyle");
        this.f30204a = i8;
        this.f30205b = mapStyle;
        this.f30206c = tileCollectionConfig;
        this.f30207d = str;
    }

    public final TileCollectionConfig a() {
        return this.f30206c;
    }

    public final MapStyle b() {
        return this.f30205b;
    }

    public final String c() {
        return this.f30207d;
    }

    public final int d() {
        return this.f30204a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FifoQueueTileState) {
            FifoQueueTileState fifoQueueTileState = (FifoQueueTileState) obj;
            return this.f30204a == fifoQueueTileState.f30204a && this.f30205b == fifoQueueTileState.f30205b && Intrinsics.a(this.f30206c, fifoQueueTileState.f30206c) && Intrinsics.a(this.f30207d, fifoQueueTileState.f30207d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f30204a * 31) + this.f30205b.hashCode()) * 31;
        TileCollectionConfig tileCollectionConfig = this.f30206c;
        int hashCode2 = (hashCode + (tileCollectionConfig == null ? 0 : tileCollectionConfig.hashCode())) * 31;
        String str = this.f30207d;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        int i8 = this.f30204a;
        MapStyle mapStyle = this.f30205b;
        TileCollectionConfig tileCollectionConfig = this.f30206c;
        String str = this.f30207d;
        return "FifoQueueTileState(vectorTileSize=" + i8 + ", mapStyle=" + mapStyle + ", config=" + tileCollectionConfig + ", outsideAreaId=" + str + ")";
    }

    public /* synthetic */ FifoQueueTileState(int i8, MapStyle mapStyle, TileCollectionConfig tileCollectionConfig, String str, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 512 : i8, (i9 & 2) != 0 ? MapStyle.DARK : mapStyle, (i9 & 4) != 0 ? null : tileCollectionConfig, (i9 & 8) != 0 ? null : str);
    }
}
