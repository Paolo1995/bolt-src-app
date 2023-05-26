package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.order.UpcomingStop;
import eu.bolt.driver.earnings.network.DriverInfoBlock;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderData.kt */
/* loaded from: classes3.dex */
public final class OrderMenuData {

    /* renamed from: a  reason: collision with root package name */
    private final String f32265a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32266b;

    /* renamed from: c  reason: collision with root package name */
    private final List<UpcomingStop> f32267c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32268d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f32269e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f32270f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f32271g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f32272h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f32273i;

    /* renamed from: j  reason: collision with root package name */
    private final String f32274j;

    /* renamed from: k  reason: collision with root package name */
    private final BackToBackState f32275k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f32276l;

    /* renamed from: m  reason: collision with root package name */
    private final String f32277m;

    /* renamed from: n  reason: collision with root package name */
    private final int f32278n;

    /* renamed from: o  reason: collision with root package name */
    private final int f32279o;

    /* renamed from: p  reason: collision with root package name */
    private final int f32280p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverInfoBlock f32281q;

    public OrderMenuData(String str, String selectedNavigationName, List<UpcomingStop> upcomingStops, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str2, BackToBackState b2bState, boolean z13, String str3, int i8, int i9, int i10, DriverInfoBlock driverInfoBlock) {
        Intrinsics.f(selectedNavigationName, "selectedNavigationName");
        Intrinsics.f(upcomingStops, "upcomingStops");
        Intrinsics.f(b2bState, "b2bState");
        this.f32265a = str;
        this.f32266b = selectedNavigationName;
        this.f32267c = upcomingStops;
        this.f32268d = z7;
        this.f32269e = z8;
        this.f32270f = z9;
        this.f32271g = z10;
        this.f32272h = z11;
        this.f32273i = z12;
        this.f32274j = str2;
        this.f32275k = b2bState;
        this.f32276l = z13;
        this.f32277m = str3;
        this.f32278n = i8;
        this.f32279o = i9;
        this.f32280p = i10;
        this.f32281q = driverInfoBlock;
    }

    public final String a() {
        return this.f32274j;
    }

    public final BackToBackState b() {
        return this.f32275k;
    }

    public final boolean c() {
        return this.f32269e;
    }

    public final boolean d() {
        return this.f32268d;
    }

    public final boolean e() {
        return this.f32273i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderMenuData) {
            OrderMenuData orderMenuData = (OrderMenuData) obj;
            return Intrinsics.a(this.f32265a, orderMenuData.f32265a) && Intrinsics.a(this.f32266b, orderMenuData.f32266b) && Intrinsics.a(this.f32267c, orderMenuData.f32267c) && this.f32268d == orderMenuData.f32268d && this.f32269e == orderMenuData.f32269e && this.f32270f == orderMenuData.f32270f && this.f32271g == orderMenuData.f32271g && this.f32272h == orderMenuData.f32272h && this.f32273i == orderMenuData.f32273i && Intrinsics.a(this.f32274j, orderMenuData.f32274j) && this.f32275k == orderMenuData.f32275k && this.f32276l == orderMenuData.f32276l && Intrinsics.a(this.f32277m, orderMenuData.f32277m) && this.f32278n == orderMenuData.f32278n && this.f32279o == orderMenuData.f32279o && this.f32280p == orderMenuData.f32280p && Intrinsics.a(this.f32281q, orderMenuData.f32281q);
        }
        return false;
    }

    public final String f() {
        return this.f32265a;
    }

    public final DriverInfoBlock g() {
        return this.f32281q;
    }

    public final int h() {
        return this.f32280p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f32265a;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.f32266b.hashCode()) * 31) + this.f32267c.hashCode()) * 31;
        boolean z7 = this.f32268d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f32269e;
        int i10 = z8;
        if (z8 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean z9 = this.f32270f;
        int i12 = z9;
        if (z9 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z10 = this.f32271g;
        int i14 = z10;
        if (z10 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z11 = this.f32272h;
        int i16 = z11;
        if (z11 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z12 = this.f32273i;
        int i18 = z12;
        if (z12 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        String str2 = this.f32274j;
        int hashCode2 = (((i19 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f32275k.hashCode()) * 31;
        boolean z13 = this.f32276l;
        int i20 = (hashCode2 + (z13 ? 1 : z13 ? 1 : 0)) * 31;
        String str3 = this.f32277m;
        int hashCode3 = (((((((i20 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f32278n) * 31) + this.f32279o) * 31) + this.f32280p) * 31;
        DriverInfoBlock driverInfoBlock = this.f32281q;
        return hashCode3 + (driverInfoBlock != null ? driverInfoBlock.hashCode() : 0);
    }

    public final int i() {
        return this.f32278n;
    }

    public final int j() {
        return this.f32279o;
    }

    public final String k() {
        return this.f32266b;
    }

    public final String l() {
        return this.f32277m;
    }

    public final boolean m() {
        return this.f32276l;
    }

    public final List<UpcomingStop> n() {
        return this.f32267c;
    }

    public final boolean o() {
        return this.f32271g;
    }

    public final boolean p() {
        return this.f32272h;
    }

    public final boolean q() {
        return this.f32270f;
    }

    public String toString() {
        String str = this.f32265a;
        String str2 = this.f32266b;
        List<UpcomingStop> list = this.f32267c;
        boolean z7 = this.f32268d;
        boolean z8 = this.f32269e;
        boolean z9 = this.f32270f;
        boolean z10 = this.f32271g;
        boolean z11 = this.f32272h;
        boolean z12 = this.f32273i;
        String str3 = this.f32274j;
        BackToBackState backToBackState = this.f32275k;
        boolean z13 = this.f32276l;
        String str4 = this.f32277m;
        int i8 = this.f32278n;
        int i9 = this.f32279o;
        int i10 = this.f32280p;
        DriverInfoBlock driverInfoBlock = this.f32281q;
        return "OrderMenuData(clientName=" + str + ", selectedNavigationName=" + str2 + ", upcomingStops=" + list + ", canCancelOrder=" + z7 + ", canCalculatePrice=" + z8 + ", isWaybillEnabled=" + z9 + ", isDestinationChangeEnabled=" + z10 + ", isMatchedDestination=" + z11 + ", canEndRide=" + z12 + ", b2bOrderAddress=" + str3 + ", b2bState=" + backToBackState + ", tripSharingEnabled=" + z13 + ", summary=" + str4 + ", maxNumberOfStops=" + i8 + ", numberOfStops=" + i9 + ", maxNumberOfIntermediateStops=" + i10 + ", infoBlock=" + driverInfoBlock + ")";
    }
}
