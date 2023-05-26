package ee.mtakso.driver.ui.interactor.order;

import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.utils.Optional;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderData.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderData {

    /* renamed from: a  reason: collision with root package name */
    private final Optional<GeoLocation> f26692a;

    /* renamed from: b  reason: collision with root package name */
    private final Optional<IncomingOrderDetails> f26693b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26694c;

    public IncomingOrderData(Optional<GeoLocation> driverLocation, Optional<IncomingOrderDetails> orderDetails, boolean z7) {
        Intrinsics.f(driverLocation, "driverLocation");
        Intrinsics.f(orderDetails, "orderDetails");
        this.f26692a = driverLocation;
        this.f26693b = orderDetails;
        this.f26694c = z7;
    }

    public final Optional<GeoLocation> a() {
        return this.f26692a;
    }

    public final Optional<IncomingOrderDetails> b() {
        return this.f26693b;
    }

    public final boolean c() {
        return this.f26694c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IncomingOrderData) {
            IncomingOrderData incomingOrderData = (IncomingOrderData) obj;
            return Intrinsics.a(this.f26692a, incomingOrderData.f26692a) && Intrinsics.a(this.f26693b, incomingOrderData.f26693b) && this.f26694c == incomingOrderData.f26694c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f26692a.hashCode() * 31) + this.f26693b.hashCode()) * 31;
        boolean z7 = this.f26694c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        Optional<GeoLocation> optional = this.f26692a;
        Optional<IncomingOrderDetails> optional2 = this.f26693b;
        boolean z7 = this.f26694c;
        return "IncomingOrderData(driverLocation=" + optional + ", orderDetails=" + optional2 + ", isMatchedDestination=" + z7 + ")";
    }
}
