package eu.bolt.android.maps.core.plugin.driver;

import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapCameraPosition.kt */
/* loaded from: classes5.dex */
public final class MapCameraPosition {

    /* renamed from: a  reason: collision with root package name */
    private final Locatable f36967a;

    /* renamed from: b  reason: collision with root package name */
    private final float f36968b;

    /* renamed from: c  reason: collision with root package name */
    private final float f36969c;

    /* renamed from: d  reason: collision with root package name */
    private final float f36970d;

    public MapCameraPosition(Locatable target, float f8, float f9, float f10) {
        Intrinsics.f(target, "target");
        this.f36967a = target;
        this.f36968b = f8;
        this.f36969c = f9;
        this.f36970d = f10;
    }

    public final float a() {
        return this.f36969c;
    }

    public final float b() {
        return this.f36970d;
    }

    public final float c() {
        return this.f36968b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapCameraPosition) {
            MapCameraPosition mapCameraPosition = (MapCameraPosition) obj;
            return Intrinsics.a(this.f36967a, mapCameraPosition.f36967a) && Float.compare(this.f36968b, mapCameraPosition.f36968b) == 0 && Float.compare(this.f36969c, mapCameraPosition.f36969c) == 0 && Float.compare(this.f36970d, mapCameraPosition.f36970d) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f36967a.hashCode() * 31) + Float.floatToIntBits(this.f36968b)) * 31) + Float.floatToIntBits(this.f36969c)) * 31) + Float.floatToIntBits(this.f36970d);
    }

    public String toString() {
        return "MapCameraPosition(target=" + this.f36967a + ", zoom=" + this.f36968b + ", bearing=" + this.f36969c + ", tilt=" + this.f36970d + ')';
    }
}
