package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import eu.bolt.driver.earnings.network.DriverInfoBlock;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Order.kt */
/* loaded from: classes3.dex */
public final class Order {
    @SerializedName("ride_type_labels")
    private final List<String> A;
    @SerializedName("acceptance_block_appearance")
    private final AcceptanceBlockAppearance B;
    @SerializedName("map_points")
    private final List<OrderMapPoint> C;
    @SerializedName("ride_summary")
    private final String D;
    @SerializedName("short_hand_description")
    private final String E;
    @SerializedName("max_number_of_stops")
    private final int F;
    @SerializedName("number_of_stops")
    private final int G;
    @SerializedName("max_number_of_intermediate_stops")
    private final int H;
    @SerializedName("acceptance_block_header")
    private final String I;
    @SerializedName("sticky_banner")
    private final DriverAppStickyBanner J;
    @SerializedName("ride_details_infoblock")
    private final DriverInfoBlock K;
    @SerializedName("pickup_time")
    private final Long L;
    @SerializedName("category_price_info")
    private final String M;
    @SerializedName("version")

    /* renamed from: a  reason: collision with root package name */
    private final int f22382a;
    @SerializedName("user_id")

    /* renamed from: b  reason: collision with root package name */
    private final long f22383b;
    @SerializedName("state")

    /* renamed from: c  reason: collision with root package name */
    private final OrderState f22384c;
    @SerializedName("time_to_client")

    /* renamed from: d  reason: collision with root package name */
    private int f22385d;
    @SerializedName("upcoming_stops")

    /* renamed from: e  reason: collision with root package name */
    private List<UpcomingStop> f22386e;
    @SerializedName("wait_for_confirmation_expires")

    /* renamed from: f  reason: collision with root package name */
    private final long f22387f;
    @SerializedName("extra_info")

    /* renamed from: g  reason: collision with root package name */
    private final String f22388g;
    @SerializedName("client_name")

    /* renamed from: h  reason: collision with root package name */
    private final String f22389h;
    @SerializedName("min_client_wait_time")

    /* renamed from: i  reason: collision with root package name */
    private final int f22390i;
    @SerializedName("has_price_calculation")

    /* renamed from: j  reason: collision with root package name */
    private final boolean f22391j;
    @SerializedName("paid_wait_time_free_seconds")

    /* renamed from: k  reason: collision with root package name */
    private final Integer f22392k;
    @SerializedName("category_name")

    /* renamed from: l  reason: collision with root package name */
    private final String f22393l;
    @SerializedName("managed_by_fleet")

    /* renamed from: m  reason: collision with root package name */
    private final Boolean f22394m;
    @SerializedName("order_finish_message")

    /* renamed from: n  reason: collision with root package name */
    private final String f22395n;
    @SerializedName("seconds_from_arrival")

    /* renamed from: o  reason: collision with root package name */
    private final long f22396o;
    @SerializedName("client_rating")

    /* renamed from: p  reason: collision with root package name */
    private final double f22397p;
    @SerializedName("show_client_rating")

    /* renamed from: q  reason: collision with root package name */
    private final boolean f22398q;
    @SerializedName("client_rides_count_str")

    /* renamed from: r  reason: collision with root package name */
    private final String f22399r;
    @SerializedName("optional_ride_info")

    /* renamed from: s  reason: collision with root package name */
    private final OptionalRideInfo f22400s;
    @SerializedName("payment_type")

    /* renamed from: t  reason: collision with root package name */
    private final PaymentType f22401t;
    @SerializedName("display_destination")

    /* renamed from: u  reason: collision with root package name */
    private final String f22402u;
    @SerializedName("ride_details")

    /* renamed from: v  reason: collision with root package name */
    private final List<Label> f22403v;
    @SerializedName("surge_multiplier_data")

    /* renamed from: w  reason: collision with root package name */
    private final Label f22404w;
    @SerializedName("ride_distance_str")

    /* renamed from: x  reason: collision with root package name */
    private final String f22405x;
    @SerializedName("route_meta")

    /* renamed from: y  reason: collision with root package name */
    private final String f22406y;
    @SerializedName("confirm_type")

    /* renamed from: z  reason: collision with root package name */
    private final AutoOrderAcceptance f22407z;

    public final long A() {
        return this.f22396o;
    }

    public final int B() {
        return this.f22390i;
    }

    public final String C() {
        return this.E;
    }

    public final boolean D() {
        return this.f22398q;
    }

    public final OrderState E() {
        return this.f22384c;
    }

    public final DriverAppStickyBanner F() {
        return this.J;
    }

    public final Label G() {
        return this.f22404w;
    }

    public final List<UpcomingStop> H() {
        return this.f22386e;
    }

    public final long I() {
        return this.f22387f;
    }

    public final Boolean J() {
        return this.f22394m;
    }

    public final AcceptanceBlockAppearance a() {
        return this.B;
    }

    public final String b() {
        return this.I;
    }

    public final String c() {
        return this.f22393l;
    }

    public final String d() {
        return this.M;
    }

    public final String e() {
        return this.f22389h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Order) {
            Order order = (Order) obj;
            return this.f22382a == order.f22382a && this.f22383b == order.f22383b && this.f22384c == order.f22384c && this.f22385d == order.f22385d && Intrinsics.a(this.f22386e, order.f22386e) && this.f22387f == order.f22387f && Intrinsics.a(this.f22388g, order.f22388g) && Intrinsics.a(this.f22389h, order.f22389h) && this.f22390i == order.f22390i && this.f22391j == order.f22391j && Intrinsics.a(this.f22392k, order.f22392k) && Intrinsics.a(this.f22393l, order.f22393l) && Intrinsics.a(this.f22394m, order.f22394m) && Intrinsics.a(this.f22395n, order.f22395n) && this.f22396o == order.f22396o && Double.compare(this.f22397p, order.f22397p) == 0 && this.f22398q == order.f22398q && Intrinsics.a(this.f22399r, order.f22399r) && Intrinsics.a(this.f22400s, order.f22400s) && this.f22401t == order.f22401t && Intrinsics.a(this.f22402u, order.f22402u) && Intrinsics.a(this.f22403v, order.f22403v) && Intrinsics.a(this.f22404w, order.f22404w) && Intrinsics.a(this.f22405x, order.f22405x) && Intrinsics.a(this.f22406y, order.f22406y) && this.f22407z == order.f22407z && Intrinsics.a(this.A, order.A) && this.B == order.B && Intrinsics.a(this.C, order.C) && Intrinsics.a(this.D, order.D) && Intrinsics.a(this.E, order.E) && this.F == order.F && this.G == order.G && this.H == order.H && Intrinsics.a(this.I, order.I) && Intrinsics.a(this.J, order.J) && Intrinsics.a(this.K, order.K) && Intrinsics.a(this.L, order.L) && Intrinsics.a(this.M, order.M);
        }
        return false;
    }

    public final double f() {
        return this.f22397p;
    }

    public final String g() {
        return this.f22399r;
    }

    public final AutoOrderAcceptance h() {
        return this.f22407z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((((((((((((this.f22382a * 31) + i0.a.a(this.f22383b)) * 31) + this.f22384c.hashCode()) * 31) + this.f22385d) * 31) + this.f22386e.hashCode()) * 31) + i0.a.a(this.f22387f)) * 31) + this.f22388g.hashCode()) * 31;
        String str = this.f22389h;
        int hashCode = (((a8 + (str == null ? 0 : str.hashCode())) * 31) + this.f22390i) * 31;
        boolean z7 = this.f22391j;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        Integer num = this.f22392k;
        int hashCode2 = (i9 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.f22393l;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.f22394m;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.f22395n;
        int hashCode5 = (((((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + i0.a.a(this.f22396o)) * 31) + q1.a.a(this.f22397p)) * 31;
        boolean z8 = this.f22398q;
        int i10 = (hashCode5 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        String str4 = this.f22399r;
        int hashCode6 = (i10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        OptionalRideInfo optionalRideInfo = this.f22400s;
        int hashCode7 = (hashCode6 + (optionalRideInfo == null ? 0 : optionalRideInfo.hashCode())) * 31;
        PaymentType paymentType = this.f22401t;
        int hashCode8 = (hashCode7 + (paymentType == null ? 0 : paymentType.hashCode())) * 31;
        String str5 = this.f22402u;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<Label> list = this.f22403v;
        int hashCode10 = (hashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        Label label = this.f22404w;
        int hashCode11 = (hashCode10 + (label == null ? 0 : label.hashCode())) * 31;
        String str6 = this.f22405x;
        int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f22406y;
        int hashCode13 = (hashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        AutoOrderAcceptance autoOrderAcceptance = this.f22407z;
        int hashCode14 = (hashCode13 + (autoOrderAcceptance == null ? 0 : autoOrderAcceptance.hashCode())) * 31;
        List<String> list2 = this.A;
        int hashCode15 = (hashCode14 + (list2 == null ? 0 : list2.hashCode())) * 31;
        AcceptanceBlockAppearance acceptanceBlockAppearance = this.B;
        int hashCode16 = (((hashCode15 + (acceptanceBlockAppearance == null ? 0 : acceptanceBlockAppearance.hashCode())) * 31) + this.C.hashCode()) * 31;
        String str8 = this.D;
        int hashCode17 = (hashCode16 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.E;
        int hashCode18 = (((((((hashCode17 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.F) * 31) + this.G) * 31) + this.H) * 31;
        String str10 = this.I;
        int hashCode19 = (hashCode18 + (str10 == null ? 0 : str10.hashCode())) * 31;
        DriverAppStickyBanner driverAppStickyBanner = this.J;
        int hashCode20 = (hashCode19 + (driverAppStickyBanner == null ? 0 : driverAppStickyBanner.hashCode())) * 31;
        DriverInfoBlock driverInfoBlock = this.K;
        int hashCode21 = (hashCode20 + (driverInfoBlock == null ? 0 : driverInfoBlock.hashCode())) * 31;
        Long l8 = this.L;
        int hashCode22 = (hashCode21 + (l8 == null ? 0 : l8.hashCode())) * 31;
        String str11 = this.M;
        return hashCode22 + (str11 != null ? str11.hashCode() : 0);
    }

    public final String i() {
        return this.f22402u;
    }

    public final String j() {
        return this.f22388g;
    }

    public final Integer k() {
        return this.f22392k;
    }

    public final List<OrderMapPoint> l() {
        return this.C;
    }

    public final int m() {
        return this.H;
    }

    public final int n() {
        return this.F;
    }

    public final int o() {
        return this.G;
    }

    public final OptionalRideInfo p() {
        return this.f22400s;
    }

    public final String q() {
        return this.f22395n;
    }

    public final PaymentType r() {
        return this.f22401t;
    }

    public final Long s() {
        return this.L;
    }

    public final boolean t() {
        return this.f22391j;
    }

    public String toString() {
        int i8 = this.f22382a;
        long j8 = this.f22383b;
        OrderState orderState = this.f22384c;
        int i9 = this.f22385d;
        List<UpcomingStop> list = this.f22386e;
        long j9 = this.f22387f;
        String str = this.f22388g;
        String str2 = this.f22389h;
        int i10 = this.f22390i;
        boolean z7 = this.f22391j;
        Integer num = this.f22392k;
        String str3 = this.f22393l;
        Boolean bool = this.f22394m;
        String str4 = this.f22395n;
        long j10 = this.f22396o;
        double d8 = this.f22397p;
        boolean z8 = this.f22398q;
        String str5 = this.f22399r;
        OptionalRideInfo optionalRideInfo = this.f22400s;
        PaymentType paymentType = this.f22401t;
        String str6 = this.f22402u;
        List<Label> list2 = this.f22403v;
        Label label = this.f22404w;
        String str7 = this.f22405x;
        String str8 = this.f22406y;
        AutoOrderAcceptance autoOrderAcceptance = this.f22407z;
        List<String> list3 = this.A;
        AcceptanceBlockAppearance acceptanceBlockAppearance = this.B;
        List<OrderMapPoint> list4 = this.C;
        String str9 = this.D;
        String str10 = this.E;
        int i11 = this.F;
        int i12 = this.G;
        int i13 = this.H;
        String str11 = this.I;
        DriverAppStickyBanner driverAppStickyBanner = this.J;
        DriverInfoBlock driverInfoBlock = this.K;
        Long l8 = this.L;
        String str12 = this.M;
        return "Order(version=" + i8 + ", userId=" + j8 + ", state=" + orderState + ", timeToClient=" + i9 + ", upcomingStops=" + list + ", waitForConfirmationExpiresTimestamp=" + j9 + ", extraInfo=" + str + ", clientName=" + str2 + ", secondsToWaitForClient=" + i10 + ", priceCalculation=" + z7 + ", freeTimeAllowedForClient=" + num + ", category=" + str3 + ", isManagedByFleet=" + bool + ", orderFinishMessage=" + str4 + ", secondsFromArrival=" + j10 + ", clientRating=" + d8 + ", shouldShowClientRating=" + z8 + ", clientRidesCount=" + str5 + ", optionalRideInfo=" + optionalRideInfo + ", paymentType=" + paymentType + ", displayDestination=" + str6 + ", rideDetails=" + list2 + ", surgeLabel=" + label + ", rideDistance=" + str7 + ", routeMeta=" + str8 + ", confirmType=" + autoOrderAcceptance + ", rideTypeLabels=" + list3 + ", acceptanceBlockAppearance=" + acceptanceBlockAppearance + ", mapPoints=" + list4 + ", rideSummary=" + str9 + ", shortHandDescription=" + str10 + ", maxNumberOfStops=" + i11 + ", numberOfStops=" + i12 + ", maxNumberOfIntermediateStops=" + i13 + ", acceptanceBlockHeader=" + str11 + ", stickyBanner=" + driverAppStickyBanner + ", rideDetailsInfoBlock=" + driverInfoBlock + ", pickupTimeInSeconds=" + l8 + ", categoryPriceInfo=" + str12 + ")";
    }

    public final List<Label> u() {
        return this.f22403v;
    }

    public final DriverInfoBlock v() {
        return this.K;
    }

    public final String w() {
        return this.f22405x;
    }

    public final String x() {
        return this.D;
    }

    public final List<String> y() {
        return this.A;
    }

    public final String z() {
        return this.f22406y;
    }
}
