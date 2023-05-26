package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.DriverOrderB2bState;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveOrderDetails.kt */
/* loaded from: classes3.dex */
public final class ActiveOrderDetails extends OrderDetails {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f25395a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25396b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderState f25397c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f25398d;

    /* renamed from: e  reason: collision with root package name */
    private final Order f25399e;

    /* renamed from: f  reason: collision with root package name */
    private final long f25400f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f25401g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f25402h;

    /* renamed from: i  reason: collision with root package name */
    private final Long f25403i;

    /* renamed from: j  reason: collision with root package name */
    private final long f25404j;

    /* renamed from: k  reason: collision with root package name */
    private final Long f25405k;

    /* renamed from: l  reason: collision with root package name */
    private final Long f25406l;

    /* renamed from: m  reason: collision with root package name */
    private final String f25407m;

    /* renamed from: n  reason: collision with root package name */
    private AutoOrderAcceptance f25408n;

    /* renamed from: o  reason: collision with root package name */
    private final Locatable f25409o;

    /* renamed from: p  reason: collision with root package name */
    private final DriverOrderB2bState f25410p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveOrderDetails(OrderHandle orderHandle, int i8, OrderState orderState, Long l8, Order order, long j8, boolean z7, boolean z8, Long l9, long j9, Long l10, Long l11, String str, AutoOrderAcceptance autoOrderAcceptance, Locatable locatable, DriverOrderB2bState driverOrderB2bState) {
        super(null);
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(orderState, "orderState");
        Intrinsics.f(order, "order");
        this.f25395a = orderHandle;
        this.f25396b = i8;
        this.f25397c = orderState;
        this.f25398d = l8;
        this.f25399e = order;
        this.f25400f = j8;
        this.f25401g = z7;
        this.f25402h = z8;
        this.f25403i = l9;
        this.f25404j = j9;
        this.f25405k = l10;
        this.f25406l = l11;
        this.f25407m = str;
        this.f25408n = autoOrderAcceptance;
        this.f25409o = locatable;
        this.f25410p = driverOrderB2bState;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public OrderHandle a() {
        return this.f25395a;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public OrderState b() {
        return this.f25397c;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public Long c() {
        return this.f25398d;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public int d() {
        return this.f25396b;
    }

    public final ActiveOrderDetails e(OrderHandle orderHandle, int i8, OrderState orderState, Long l8, Order order, long j8, boolean z7, boolean z8, Long l9, long j9, Long l10, Long l11, String str, AutoOrderAcceptance autoOrderAcceptance, Locatable locatable, DriverOrderB2bState driverOrderB2bState) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(orderState, "orderState");
        Intrinsics.f(order, "order");
        return new ActiveOrderDetails(orderHandle, i8, orderState, l8, order, j8, z7, z8, l9, j9, l10, l11, str, autoOrderAcceptance, locatable, driverOrderB2bState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActiveOrderDetails) {
            ActiveOrderDetails activeOrderDetails = (ActiveOrderDetails) obj;
            return Intrinsics.a(a(), activeOrderDetails.a()) && d() == activeOrderDetails.d() && b() == activeOrderDetails.b() && Intrinsics.a(c(), activeOrderDetails.c()) && Intrinsics.a(this.f25399e, activeOrderDetails.f25399e) && this.f25400f == activeOrderDetails.f25400f && this.f25401g == activeOrderDetails.f25401g && this.f25402h == activeOrderDetails.f25402h && Intrinsics.a(this.f25403i, activeOrderDetails.f25403i) && this.f25404j == activeOrderDetails.f25404j && Intrinsics.a(this.f25405k, activeOrderDetails.f25405k) && Intrinsics.a(this.f25406l, activeOrderDetails.f25406l) && Intrinsics.a(this.f25407m, activeOrderDetails.f25407m) && this.f25408n == activeOrderDetails.f25408n && Intrinsics.a(this.f25409o, activeOrderDetails.f25409o) && this.f25410p == activeOrderDetails.f25410p;
        }
        return false;
    }

    public final DriverOrderB2bState g() {
        return this.f25410p;
    }

    public final AutoOrderAcceptance h() {
        return this.f25408n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((a().hashCode() * 31) + d()) * 31) + b().hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31) + this.f25399e.hashCode()) * 31) + i0.a.a(this.f25400f)) * 31;
        boolean z7 = this.f25401g;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f25402h;
        int i10 = (i9 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        Long l8 = this.f25403i;
        int hashCode2 = (((i10 + (l8 == null ? 0 : l8.hashCode())) * 31) + i0.a.a(this.f25404j)) * 31;
        Long l9 = this.f25405k;
        int hashCode3 = (hashCode2 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.f25406l;
        int hashCode4 = (hashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.f25407m;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        AutoOrderAcceptance autoOrderAcceptance = this.f25408n;
        int hashCode6 = (hashCode5 + (autoOrderAcceptance == null ? 0 : autoOrderAcceptance.hashCode())) * 31;
        Locatable locatable = this.f25409o;
        int hashCode7 = (hashCode6 + (locatable == null ? 0 : locatable.hashCode())) * 31;
        DriverOrderB2bState driverOrderB2bState = this.f25410p;
        return hashCode7 + (driverOrderB2bState != null ? driverOrderB2bState.hashCode() : 0);
    }

    public final Order i() {
        return this.f25399e;
    }

    public final String j() {
        return this.f25407m;
    }

    public final Locatable k() {
        return this.f25409o;
    }

    public final long l() {
        return this.f25404j;
    }

    public final Long m() {
        return this.f25406l;
    }

    public final Long n() {
        return this.f25403i;
    }

    public final Long o() {
        return this.f25405k;
    }

    public final boolean p() {
        return this.f25401g;
    }

    public final boolean q() {
        return this.f25402h;
    }

    public String toString() {
        OrderHandle a8 = a();
        int d8 = d();
        OrderState b8 = b();
        Long c8 = c();
        Order order = this.f25399e;
        long j8 = this.f25400f;
        boolean z7 = this.f25401g;
        boolean z8 = this.f25402h;
        Long l8 = this.f25403i;
        long j9 = this.f25404j;
        Long l9 = this.f25405k;
        Long l10 = this.f25406l;
        String str = this.f25407m;
        AutoOrderAcceptance autoOrderAcceptance = this.f25408n;
        Locatable locatable = this.f25409o;
        DriverOrderB2bState driverOrderB2bState = this.f25410p;
        return "ActiveOrderDetails(orderHandle=" + a8 + ", version=" + d8 + ", orderState=" + b8 + ", userId=" + c8 + ", order=" + order + ", waitForConfirmationExpires=" + j8 + ", isExtraInfoShown=" + z7 + ", isExtraInfoUpdated=" + z8 + ", secondsToClient=" + l8 + ", secondsFromArrival=" + j9 + ", secondsToDestination=" + l9 + ", secondsOnStop=" + l10 + ", priceForStop=" + str + ", confirmType=" + autoOrderAcceptance + ", riderLocation=" + locatable + ", b2bState=" + driverOrderB2bState + ")";
    }
}
