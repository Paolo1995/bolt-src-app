package eu.bolt.android.maps.core.plugin.driver;

import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapProjection.kt */
/* loaded from: classes5.dex */
public final class MapProjection {

    /* renamed from: a  reason: collision with root package name */
    private final Locatable f36971a;

    /* renamed from: b  reason: collision with root package name */
    private final Locatable f36972b;

    /* renamed from: c  reason: collision with root package name */
    private final Locatable f36973c;

    /* renamed from: d  reason: collision with root package name */
    private final Locatable f36974d;

    /* renamed from: e  reason: collision with root package name */
    private final float f36975e;

    public MapProjection(Locatable farLeft, Locatable farRight, Locatable nearLeft, Locatable nearRight, float f8) {
        Intrinsics.f(farLeft, "farLeft");
        Intrinsics.f(farRight, "farRight");
        Intrinsics.f(nearLeft, "nearLeft");
        Intrinsics.f(nearRight, "nearRight");
        this.f36971a = farLeft;
        this.f36972b = farRight;
        this.f36973c = nearLeft;
        this.f36974d = nearRight;
        this.f36975e = f8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapProjection) {
            MapProjection mapProjection = (MapProjection) obj;
            return Intrinsics.a(this.f36971a, mapProjection.f36971a) && Intrinsics.a(this.f36972b, mapProjection.f36972b) && Intrinsics.a(this.f36973c, mapProjection.f36973c) && Intrinsics.a(this.f36974d, mapProjection.f36974d) && Float.compare(this.f36975e, mapProjection.f36975e) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f36971a.hashCode() * 31) + this.f36972b.hashCode()) * 31) + this.f36973c.hashCode()) * 31) + this.f36974d.hashCode()) * 31) + Float.floatToIntBits(this.f36975e);
    }

    public String toString() {
        return "MapProjection(farLeft=" + this.f36971a + ", farRight=" + this.f36972b + ", nearLeft=" + this.f36973c + ", nearRight=" + this.f36974d + ", zoom=" + this.f36975e + ')';
    }
}
