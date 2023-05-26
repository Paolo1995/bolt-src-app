package ee.mtakso.driver.service.modules.distance;

import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderWithOptionalDistance.kt */
/* loaded from: classes3.dex */
public final class OrderWithOptionalDistance {

    /* renamed from: a  reason: collision with root package name */
    private final ActiveOrderDetails f24597a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f24598b;

    public OrderWithOptionalDistance(ActiveOrderDetails model, Double d8) {
        Intrinsics.f(model, "model");
        this.f24597a = model;
        this.f24598b = d8;
    }

    public final Double a() {
        return this.f24598b;
    }

    public final ActiveOrderDetails b() {
        return this.f24597a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderWithOptionalDistance) {
            OrderWithOptionalDistance orderWithOptionalDistance = (OrderWithOptionalDistance) obj;
            return Intrinsics.a(this.f24597a, orderWithOptionalDistance.f24597a) && Intrinsics.a(this.f24598b, orderWithOptionalDistance.f24598b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f24597a.hashCode() * 31;
        Double d8 = this.f24598b;
        return hashCode + (d8 == null ? 0 : d8.hashCode());
    }

    public String toString() {
        ActiveOrderDetails activeOrderDetails = this.f24597a;
        Double d8 = this.f24598b;
        return "OrderWithOptionalDistance(model=" + activeOrderDetails + ", distance=" + d8 + ")";
    }

    public /* synthetic */ OrderWithOptionalDistance(ActiveOrderDetails activeOrderDetails, Double d8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(activeOrderDetails, (i8 & 2) != 0 ? null : d8);
    }
}
