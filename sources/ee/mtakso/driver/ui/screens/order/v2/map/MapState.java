package ee.mtakso.driver.ui.screens.order.v2.map;

import ee.mtakso.driver.ui.interactor.order.active.map.MapData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapData.kt */
/* loaded from: classes3.dex */
public final class MapState {

    /* renamed from: a  reason: collision with root package name */
    private final NavigationMode f32112a;

    /* renamed from: b  reason: collision with root package name */
    private final MapData f32113b;

    public MapState(NavigationMode navigationMode, MapData data) {
        Intrinsics.f(navigationMode, "navigationMode");
        Intrinsics.f(data, "data");
        this.f32112a = navigationMode;
        this.f32113b = data;
    }

    public static /* synthetic */ MapState b(MapState mapState, NavigationMode navigationMode, MapData mapData, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            navigationMode = mapState.f32112a;
        }
        if ((i8 & 2) != 0) {
            mapData = mapState.f32113b;
        }
        return mapState.a(navigationMode, mapData);
    }

    public final MapState a(NavigationMode navigationMode, MapData data) {
        Intrinsics.f(navigationMode, "navigationMode");
        Intrinsics.f(data, "data");
        return new MapState(navigationMode, data);
    }

    public final MapData c() {
        return this.f32113b;
    }

    public final NavigationMode d() {
        return this.f32112a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapState) {
            MapState mapState = (MapState) obj;
            return this.f32112a == mapState.f32112a && Intrinsics.a(this.f32113b, mapState.f32113b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f32112a.hashCode() * 31) + this.f32113b.hashCode();
    }

    public String toString() {
        NavigationMode navigationMode = this.f32112a;
        MapData mapData = this.f32113b;
        return "MapState(navigationMode=" + navigationMode + ", data=" + mapData + ")";
    }
}
