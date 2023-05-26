package ee.mtakso.driver.service.geo.storage;

import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;
import q1.a;

/* compiled from: LocationEntity.kt */
/* loaded from: classes3.dex */
public final class LocationEntity {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f24437a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24438b;

    /* renamed from: c  reason: collision with root package name */
    private final double f24439c;

    /* renamed from: d  reason: collision with root package name */
    private final double f24440d;

    /* renamed from: e  reason: collision with root package name */
    private final double f24441e;

    /* renamed from: f  reason: collision with root package name */
    private final Float f24442f;

    /* renamed from: g  reason: collision with root package name */
    private final long f24443g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f24444h;

    /* renamed from: i  reason: collision with root package name */
    private final Float f24445i;

    /* renamed from: j  reason: collision with root package name */
    private final Float f24446j;

    public LocationEntity(OrderHandle orderHandle, String orderState, double d8, double d9, double d10, Float f8, long j8, boolean z7, Float f9, Float f10) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(orderState, "orderState");
        this.f24437a = orderHandle;
        this.f24438b = orderState;
        this.f24439c = d8;
        this.f24440d = d9;
        this.f24441e = d10;
        this.f24442f = f8;
        this.f24443g = j8;
        this.f24444h = z7;
        this.f24445i = f9;
        this.f24446j = f10;
    }

    public final double a() {
        return this.f24441e;
    }

    public final Float b() {
        return this.f24445i;
    }

    public final Float c() {
        return this.f24446j;
    }

    public final boolean d() {
        return this.f24444h;
    }

    public final double e() {
        return this.f24439c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationEntity) {
            LocationEntity locationEntity = (LocationEntity) obj;
            return Intrinsics.a(this.f24437a, locationEntity.f24437a) && Intrinsics.a(this.f24438b, locationEntity.f24438b) && Double.compare(this.f24439c, locationEntity.f24439c) == 0 && Double.compare(this.f24440d, locationEntity.f24440d) == 0 && Double.compare(this.f24441e, locationEntity.f24441e) == 0 && Intrinsics.a(this.f24442f, locationEntity.f24442f) && this.f24443g == locationEntity.f24443g && this.f24444h == locationEntity.f24444h && Intrinsics.a(this.f24445i, locationEntity.f24445i) && Intrinsics.a(this.f24446j, locationEntity.f24446j);
        }
        return false;
    }

    public final double f() {
        return this.f24440d;
    }

    public final OrderHandle g() {
        return this.f24437a;
    }

    public final String h() {
        return this.f24438b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.f24437a.hashCode() * 31) + this.f24438b.hashCode()) * 31) + a.a(this.f24439c)) * 31) + a.a(this.f24440d)) * 31) + a.a(this.f24441e)) * 31;
        Float f8 = this.f24442f;
        int hashCode2 = (((hashCode + (f8 == null ? 0 : f8.hashCode())) * 31) + i0.a.a(this.f24443g)) * 31;
        boolean z7 = this.f24444h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        Float f9 = this.f24445i;
        int hashCode3 = (i9 + (f9 == null ? 0 : f9.hashCode())) * 31;
        Float f10 = this.f24446j;
        return hashCode3 + (f10 != null ? f10.hashCode() : 0);
    }

    public final long i() {
        return this.f24443g;
    }

    public final Float j() {
        return this.f24442f;
    }

    public String toString() {
        OrderHandle orderHandle = this.f24437a;
        String str = this.f24438b;
        double d8 = this.f24439c;
        double d9 = this.f24440d;
        double d10 = this.f24441e;
        Float f8 = this.f24442f;
        long j8 = this.f24443g;
        boolean z7 = this.f24444h;
        Float f9 = this.f24445i;
        Float f10 = this.f24446j;
        return "LocationEntity(orderHandle=" + orderHandle + ", orderState=" + str + ", lat=" + d8 + ", lng=" + d9 + ", alt=" + d10 + ", speed=" + f8 + ", phoneTimestamp=" + j8 + ", fixed=" + z7 + ", bearing=" + f9 + ", bearingAccuracy=" + f10 + ")";
    }
}
