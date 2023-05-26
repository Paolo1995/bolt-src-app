package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapTileMarker.kt */
/* loaded from: classes3.dex */
public final class MapTileMarker<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f30268a;

    /* renamed from: b  reason: collision with root package name */
    private final Locatable f30269b;

    /* renamed from: c  reason: collision with root package name */
    private final T f30270c;

    public MapTileMarker(String id, Locatable position, T t7) {
        Intrinsics.f(id, "id");
        Intrinsics.f(position, "position");
        this.f30268a = id;
        this.f30269b = position;
        this.f30270c = t7;
    }

    public final String a() {
        return this.f30268a;
    }

    public final T b() {
        return this.f30270c;
    }

    public final Locatable c() {
        return this.f30269b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapTileMarker) {
            MapTileMarker mapTileMarker = (MapTileMarker) obj;
            return Intrinsics.a(this.f30268a, mapTileMarker.f30268a) && Intrinsics.a(this.f30269b, mapTileMarker.f30269b) && Intrinsics.a(this.f30270c, mapTileMarker.f30270c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f30268a.hashCode() * 31) + this.f30269b.hashCode()) * 31;
        T t7 = this.f30270c;
        return hashCode + (t7 == null ? 0 : t7.hashCode());
    }

    public String toString() {
        String str = this.f30268a;
        Locatable locatable = this.f30269b;
        T t7 = this.f30270c;
        return "MapTileMarker(id=" + str + ", position=" + locatable + ", payload=" + t7 + ")";
    }
}
