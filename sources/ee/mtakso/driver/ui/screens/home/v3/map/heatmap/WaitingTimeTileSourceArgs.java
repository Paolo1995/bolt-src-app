package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingTimeTileSourceArgs.kt */
/* loaded from: classes3.dex */
public final class WaitingTimeTileSourceArgs {

    /* renamed from: a  reason: collision with root package name */
    private final MapStyle f30252a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30253b;

    /* renamed from: c  reason: collision with root package name */
    private final TileCollectionConfig f30254c;

    public WaitingTimeTileSourceArgs(MapStyle style, String collectionId, TileCollectionConfig config) {
        Intrinsics.f(style, "style");
        Intrinsics.f(collectionId, "collectionId");
        Intrinsics.f(config, "config");
        this.f30252a = style;
        this.f30253b = collectionId;
        this.f30254c = config;
    }

    public final String a() {
        return this.f30253b;
    }

    public final TileCollectionConfig b() {
        return this.f30254c;
    }

    public final MapStyle c() {
        return this.f30252a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WaitingTimeTileSourceArgs) {
            WaitingTimeTileSourceArgs waitingTimeTileSourceArgs = (WaitingTimeTileSourceArgs) obj;
            return this.f30252a == waitingTimeTileSourceArgs.f30252a && Intrinsics.a(this.f30253b, waitingTimeTileSourceArgs.f30253b) && Intrinsics.a(this.f30254c, waitingTimeTileSourceArgs.f30254c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f30252a.hashCode() * 31) + this.f30253b.hashCode()) * 31) + this.f30254c.hashCode();
    }

    public String toString() {
        MapStyle mapStyle = this.f30252a;
        String str = this.f30253b;
        TileCollectionConfig tileCollectionConfig = this.f30254c;
        return "WaitingTimeTileSourceArgs(style=" + mapStyle + ", collectionId=" + str + ", config=" + tileCollectionConfig + ")";
    }
}
