package eu.bolt.android.maps.core.plugin.driver;

import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;
import q1.a;

/* compiled from: CircleInfo.kt */
/* loaded from: classes5.dex */
public final class CircleInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f36962a;

    /* renamed from: b  reason: collision with root package name */
    private final Locatable f36963b;

    /* renamed from: c  reason: collision with root package name */
    private final double f36964c;

    public CircleInfo(int i8, Locatable center, double d8) {
        Intrinsics.f(center, "center");
        this.f36962a = i8;
        this.f36963b = center;
        this.f36964c = d8;
    }

    public final int a() {
        return this.f36962a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CircleInfo) {
            CircleInfo circleInfo = (CircleInfo) obj;
            return this.f36962a == circleInfo.f36962a && Intrinsics.a(this.f36963b, circleInfo.f36963b) && Double.compare(this.f36964c, circleInfo.f36964c) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f36962a * 31) + this.f36963b.hashCode()) * 31) + a.a(this.f36964c);
    }

    public String toString() {
        return "CircleInfo(id=" + this.f36962a + ", center=" + this.f36963b + ", radius=" + this.f36964c + ')';
    }
}
