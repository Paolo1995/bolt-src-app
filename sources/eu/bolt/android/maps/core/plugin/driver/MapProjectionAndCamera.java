package eu.bolt.android.maps.core.plugin.driver;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapProjectionAndCamera.kt */
/* loaded from: classes5.dex */
public final class MapProjectionAndCamera {

    /* renamed from: a  reason: collision with root package name */
    private final MapProjection f36976a;

    /* renamed from: b  reason: collision with root package name */
    private final MapCameraPosition f36977b;

    public MapProjectionAndCamera(MapProjection projection, MapCameraPosition camera) {
        Intrinsics.f(projection, "projection");
        Intrinsics.f(camera, "camera");
        this.f36976a = projection;
        this.f36977b = camera;
    }

    public final MapCameraPosition a() {
        return this.f36977b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapProjectionAndCamera) {
            MapProjectionAndCamera mapProjectionAndCamera = (MapProjectionAndCamera) obj;
            return Intrinsics.a(this.f36976a, mapProjectionAndCamera.f36976a) && Intrinsics.a(this.f36977b, mapProjectionAndCamera.f36977b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f36976a.hashCode() * 31) + this.f36977b.hashCode();
    }

    public String toString() {
        return "MapProjectionAndCamera(projection=" + this.f36976a + ", camera=" + this.f36977b + ')';
    }
}
