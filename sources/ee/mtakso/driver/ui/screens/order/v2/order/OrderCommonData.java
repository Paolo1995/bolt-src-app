package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.DriverAppStickyBanner;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderData.kt */
/* loaded from: classes3.dex */
public final class OrderCommonData {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f32217a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f32218b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderState f32219c;

    /* renamed from: d  reason: collision with root package name */
    private final GeoCoordinate f32220d;

    /* renamed from: e  reason: collision with root package name */
    private final GeoCoordinate f32221e;

    /* renamed from: f  reason: collision with root package name */
    private final String f32222f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f32223g;

    /* renamed from: h  reason: collision with root package name */
    private final BackToBackState f32224h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverAppStickyBanner f32225i;

    public OrderCommonData(OrderHandle orderHandle, Long l8, OrderState orderState, GeoCoordinate geoCoordinate, GeoCoordinate geoCoordinate2, String str, boolean z7, BackToBackState b2bState, DriverAppStickyBanner driverAppStickyBanner) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(orderState, "orderState");
        Intrinsics.f(b2bState, "b2bState");
        this.f32217a = orderHandle;
        this.f32218b = l8;
        this.f32219c = orderState;
        this.f32220d = geoCoordinate;
        this.f32221e = geoCoordinate2;
        this.f32222f = str;
        this.f32223g = z7;
        this.f32224h = b2bState;
        this.f32225i = driverAppStickyBanner;
    }

    public final BackToBackState a() {
        return this.f32224h;
    }

    public final String b() {
        return this.f32222f;
    }

    public final GeoCoordinate c() {
        return this.f32221e;
    }

    public final GeoCoordinate d() {
        return this.f32220d;
    }

    public final OrderHandle e() {
        return this.f32217a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderCommonData) {
            OrderCommonData orderCommonData = (OrderCommonData) obj;
            return Intrinsics.a(this.f32217a, orderCommonData.f32217a) && Intrinsics.a(this.f32218b, orderCommonData.f32218b) && this.f32219c == orderCommonData.f32219c && Intrinsics.a(this.f32220d, orderCommonData.f32220d) && Intrinsics.a(this.f32221e, orderCommonData.f32221e) && Intrinsics.a(this.f32222f, orderCommonData.f32222f) && this.f32223g == orderCommonData.f32223g && this.f32224h == orderCommonData.f32224h && Intrinsics.a(this.f32225i, orderCommonData.f32225i);
        }
        return false;
    }

    public final OrderState f() {
        return this.f32219c;
    }

    public final DriverAppStickyBanner g() {
        return this.f32225i;
    }

    public final Long h() {
        return this.f32218b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f32217a.hashCode() * 31;
        Long l8 = this.f32218b;
        int hashCode2 = (((hashCode + (l8 == null ? 0 : l8.hashCode())) * 31) + this.f32219c.hashCode()) * 31;
        GeoCoordinate geoCoordinate = this.f32220d;
        int hashCode3 = (hashCode2 + (geoCoordinate == null ? 0 : geoCoordinate.hashCode())) * 31;
        GeoCoordinate geoCoordinate2 = this.f32221e;
        int hashCode4 = (hashCode3 + (geoCoordinate2 == null ? 0 : geoCoordinate2.hashCode())) * 31;
        String str = this.f32222f;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z7 = this.f32223g;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int hashCode6 = (((hashCode5 + i8) * 31) + this.f32224h.hashCode()) * 31;
        DriverAppStickyBanner driverAppStickyBanner = this.f32225i;
        return hashCode6 + (driverAppStickyBanner != null ? driverAppStickyBanner.hashCode() : 0);
    }

    public final boolean i() {
        return this.f32223g;
    }

    public String toString() {
        OrderHandle orderHandle = this.f32217a;
        Long l8 = this.f32218b;
        OrderState orderState = this.f32219c;
        GeoCoordinate geoCoordinate = this.f32220d;
        GeoCoordinate geoCoordinate2 = this.f32221e;
        String str = this.f32222f;
        boolean z7 = this.f32223g;
        BackToBackState backToBackState = this.f32224h;
        DriverAppStickyBanner driverAppStickyBanner = this.f32225i;
        return "OrderCommonData(orderHandle=" + orderHandle + ", userId=" + l8 + ", orderState=" + orderState + ", firstStop=" + geoCoordinate + ", firstMapMatchedStop=" + geoCoordinate2 + ", extraInfo=" + str + ", wasExtraShown=" + z7 + ", b2bState=" + backToBackState + ", stickyBanner=" + driverAppStickyBanner + ")";
    }
}
