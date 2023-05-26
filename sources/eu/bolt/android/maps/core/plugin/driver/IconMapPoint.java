package eu.bolt.android.maps.core.plugin.driver;

import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IconMapPoint.kt */
/* loaded from: classes5.dex */
public final class IconMapPoint {

    /* renamed from: a  reason: collision with root package name */
    private final Locatable f36965a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36966b;

    public IconMapPoint(Locatable point, int i8) {
        Intrinsics.f(point, "point");
        this.f36965a = point;
        this.f36966b = i8;
    }

    public final int a() {
        return this.f36966b;
    }

    public final Locatable b() {
        return this.f36965a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IconMapPoint) {
            IconMapPoint iconMapPoint = (IconMapPoint) obj;
            return Intrinsics.a(this.f36965a, iconMapPoint.f36965a) && this.f36966b == iconMapPoint.f36966b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f36965a.hashCode() * 31) + this.f36966b;
    }

    public String toString() {
        return "IconMapPoint(point=" + this.f36965a + ", icon=" + this.f36966b + ')';
    }
}
