package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import ee.mtakso.driver.service.modules.map.TilePosition;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapTile.kt */
/* loaded from: classes3.dex */
public final class MapTile<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f30264a;

    /* renamed from: b  reason: collision with root package name */
    private final TilePosition f30265b;

    /* renamed from: c  reason: collision with root package name */
    private final List<MapTileMarker<T>> f30266c;

    public MapTile(String collectionId, TilePosition position, List<MapTileMarker<T>> markers) {
        Intrinsics.f(collectionId, "collectionId");
        Intrinsics.f(position, "position");
        Intrinsics.f(markers, "markers");
        this.f30264a = collectionId;
        this.f30265b = position;
        this.f30266c = markers;
    }

    public final String a() {
        return this.f30264a;
    }

    public final List<MapTileMarker<T>> b() {
        return this.f30266c;
    }

    public final TilePosition c() {
        return this.f30265b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapTile) {
            MapTile mapTile = (MapTile) obj;
            return Intrinsics.a(this.f30264a, mapTile.f30264a) && Intrinsics.a(this.f30265b, mapTile.f30265b) && Intrinsics.a(this.f30266c, mapTile.f30266c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f30264a.hashCode() * 31) + this.f30265b.hashCode()) * 31) + this.f30266c.hashCode();
    }

    public String toString() {
        String str = this.f30264a;
        TilePosition tilePosition = this.f30265b;
        List<MapTileMarker<T>> list = this.f30266c;
        return "MapTile(collectionId=" + str + ", position=" + tilePosition + ", markers=" + list + ")";
    }
}
