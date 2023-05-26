package eu.bolt.android.maps.core.plugin.driver;

import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;
import q1.a;

/* compiled from: MarkerInfo.kt */
/* loaded from: classes5.dex */
public final class MarkerInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f36984a;

    /* renamed from: b  reason: collision with root package name */
    private final Locatable f36985b;

    /* renamed from: c  reason: collision with root package name */
    private final double f36986c;

    public MarkerInfo(int i8, Locatable point, double d8) {
        Intrinsics.f(point, "point");
        this.f36984a = i8;
        this.f36985b = point;
        this.f36986c = d8;
    }

    public final int a() {
        return this.f36984a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MarkerInfo) {
            MarkerInfo markerInfo = (MarkerInfo) obj;
            return this.f36984a == markerInfo.f36984a && Intrinsics.a(this.f36985b, markerInfo.f36985b) && Double.compare(this.f36986c, markerInfo.f36986c) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f36984a * 31) + this.f36985b.hashCode()) * 31) + a.a(this.f36986c);
    }

    public String toString() {
        return "MarkerInfo(id=" + this.f36984a + ", point=" + this.f36985b + ", rotation=" + this.f36986c + ')';
    }
}
