package ee.mtakso.driver.ui.screens.order.scheduled;

import eu.bolt.android.maps.core.Locatable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderMapPoints.kt */
/* loaded from: classes3.dex */
public final class OrderMapPoints {

    /* renamed from: a  reason: collision with root package name */
    private final List<Locatable> f31636a;

    /* renamed from: b  reason: collision with root package name */
    private final List<MapPointWithBearing> f31637b;

    /* JADX WARN: Multi-variable type inference failed */
    public OrderMapPoints(List<? extends Locatable> bounds, List<MapPointWithBearing> points) {
        Intrinsics.f(bounds, "bounds");
        Intrinsics.f(points, "points");
        this.f31636a = bounds;
        this.f31637b = points;
    }

    public final List<Locatable> a() {
        return this.f31636a;
    }

    public final List<MapPointWithBearing> b() {
        return this.f31637b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderMapPoints) {
            OrderMapPoints orderMapPoints = (OrderMapPoints) obj;
            return Intrinsics.a(this.f31636a, orderMapPoints.f31636a) && Intrinsics.a(this.f31637b, orderMapPoints.f31637b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f31636a.hashCode() * 31) + this.f31637b.hashCode();
    }

    public String toString() {
        List<Locatable> list = this.f31636a;
        List<MapPointWithBearing> list2 = this.f31637b;
        return "OrderMapPoints(bounds=" + list + ", points=" + list2 + ")";
    }
}
