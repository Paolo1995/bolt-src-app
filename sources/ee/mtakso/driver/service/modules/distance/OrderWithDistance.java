package ee.mtakso.driver.service.modules.distance;

import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingStopDistanceService.kt */
/* loaded from: classes3.dex */
public final class OrderWithDistance {

    /* renamed from: a  reason: collision with root package name */
    private final ActiveOrderDetails f24595a;

    /* renamed from: b  reason: collision with root package name */
    private final double f24596b;

    public OrderWithDistance(ActiveOrderDetails model, double d8) {
        Intrinsics.f(model, "model");
        this.f24595a = model;
        this.f24596b = d8;
    }

    public final double a() {
        return this.f24596b;
    }

    public final ActiveOrderDetails b() {
        return this.f24595a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderWithDistance) {
            OrderWithDistance orderWithDistance = (OrderWithDistance) obj;
            return Intrinsics.a(this.f24595a, orderWithDistance.f24595a) && Double.compare(this.f24596b, orderWithDistance.f24596b) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (this.f24595a.hashCode() * 31) + q1.a.a(this.f24596b);
    }

    public String toString() {
        ActiveOrderDetails activeOrderDetails = this.f24595a;
        double d8 = this.f24596b;
        return "OrderWithDistance(model=" + activeOrderDetails + ", distance=" + d8 + ")";
    }
}
