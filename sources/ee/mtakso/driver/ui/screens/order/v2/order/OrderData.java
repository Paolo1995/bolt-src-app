package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderData.kt */
/* loaded from: classes3.dex */
public abstract class OrderData {

    /* compiled from: OrderData.kt */
    /* loaded from: classes3.dex */
    public static final class DrivingWithClientData extends OrderData {

        /* renamed from: a  reason: collision with root package name */
        private final Long f32226a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32227b;

        /* renamed from: c  reason: collision with root package name */
        private final RideStep f32228c;

        /* renamed from: d  reason: collision with root package name */
        private final PaymentType f32229d;

        /* renamed from: e  reason: collision with root package name */
        private final GeoCoordinate f32230e;

        /* renamed from: f  reason: collision with root package name */
        private final OrderMenuData f32231f;

        /* renamed from: g  reason: collision with root package name */
        private final OrderCommonData f32232g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DrivingWithClientData(Long l8, String str, RideStep rideStep, PaymentType paymentType, GeoCoordinate geoCoordinate, OrderMenuData menuData, OrderCommonData common) {
            super(null);
            Intrinsics.f(rideStep, "rideStep");
            Intrinsics.f(paymentType, "paymentType");
            Intrinsics.f(menuData, "menuData");
            Intrinsics.f(common, "common");
            this.f32226a = l8;
            this.f32227b = str;
            this.f32228c = rideStep;
            this.f32229d = paymentType;
            this.f32230e = geoCoordinate;
            this.f32231f = menuData;
            this.f32232g = common;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderCommonData a() {
            return this.f32232g;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderMenuData b() {
            return this.f32231f;
        }

        public final String c() {
            return this.f32227b;
        }

        public final GeoCoordinate d() {
            return this.f32230e;
        }

        public final Long e() {
            return this.f32226a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DrivingWithClientData) {
                DrivingWithClientData drivingWithClientData = (DrivingWithClientData) obj;
                return Intrinsics.a(this.f32226a, drivingWithClientData.f32226a) && Intrinsics.a(this.f32227b, drivingWithClientData.f32227b) && this.f32228c == drivingWithClientData.f32228c && this.f32229d == drivingWithClientData.f32229d && Intrinsics.a(this.f32230e, drivingWithClientData.f32230e) && Intrinsics.a(b(), drivingWithClientData.b()) && Intrinsics.a(a(), drivingWithClientData.a());
            }
            return false;
        }

        public final PaymentType f() {
            return this.f32229d;
        }

        public final RideStep g() {
            return this.f32228c;
        }

        public int hashCode() {
            Long l8 = this.f32226a;
            int hashCode = (l8 == null ? 0 : l8.hashCode()) * 31;
            String str = this.f32227b;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f32228c.hashCode()) * 31) + this.f32229d.hashCode()) * 31;
            GeoCoordinate geoCoordinate = this.f32230e;
            return ((((hashCode2 + (geoCoordinate != null ? geoCoordinate.hashCode() : 0)) * 31) + b().hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            Long l8 = this.f32226a;
            String str = this.f32227b;
            RideStep rideStep = this.f32228c;
            PaymentType paymentType = this.f32229d;
            GeoCoordinate geoCoordinate = this.f32230e;
            OrderMenuData b8 = b();
            OrderCommonData a8 = a();
            return "DrivingWithClientData(etaSeconds=" + l8 + ", address=" + str + ", rideStep=" + rideStep + ", paymentType=" + paymentType + ", destination=" + geoCoordinate + ", menuData=" + b8 + ", common=" + a8 + ")";
        }
    }

    /* compiled from: OrderData.kt */
    /* loaded from: classes3.dex */
    public static final class GoingToPickupData extends OrderData {

        /* renamed from: a  reason: collision with root package name */
        private final Long f32233a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32234b;

        /* renamed from: c  reason: collision with root package name */
        private final String f32235c;

        /* renamed from: d  reason: collision with root package name */
        private final String f32236d;

        /* renamed from: e  reason: collision with root package name */
        private final String f32237e;

        /* renamed from: f  reason: collision with root package name */
        private final String f32238f;

        /* renamed from: g  reason: collision with root package name */
        private final String f32239g;

        /* renamed from: h  reason: collision with root package name */
        private final OrderMenuData f32240h;

        /* renamed from: i  reason: collision with root package name */
        private final OrderCommonData f32241i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoingToPickupData(Long l8, String str, String str2, String str3, String str4, String str5, String str6, OrderMenuData menuData, OrderCommonData common) {
            super(null);
            Intrinsics.f(menuData, "menuData");
            Intrinsics.f(common, "common");
            this.f32233a = l8;
            this.f32234b = str;
            this.f32235c = str2;
            this.f32236d = str3;
            this.f32237e = str4;
            this.f32238f = str5;
            this.f32239g = str6;
            this.f32240h = menuData;
            this.f32241i = common;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderCommonData a() {
            return this.f32241i;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderMenuData b() {
            return this.f32240h;
        }

        public final String c() {
            return this.f32234b;
        }

        public final String d() {
            return this.f32239g;
        }

        public final String e() {
            return this.f32235c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GoingToPickupData) {
                GoingToPickupData goingToPickupData = (GoingToPickupData) obj;
                return Intrinsics.a(this.f32233a, goingToPickupData.f32233a) && Intrinsics.a(this.f32234b, goingToPickupData.f32234b) && Intrinsics.a(this.f32235c, goingToPickupData.f32235c) && Intrinsics.a(this.f32236d, goingToPickupData.f32236d) && Intrinsics.a(this.f32237e, goingToPickupData.f32237e) && Intrinsics.a(this.f32238f, goingToPickupData.f32238f) && Intrinsics.a(this.f32239g, goingToPickupData.f32239g) && Intrinsics.a(b(), goingToPickupData.b()) && Intrinsics.a(a(), goingToPickupData.a());
            }
            return false;
        }

        public final String f() {
            return this.f32236d;
        }

        public final String g() {
            return this.f32237e;
        }

        public final Long h() {
            return this.f32233a;
        }

        public int hashCode() {
            Long l8 = this.f32233a;
            int hashCode = (l8 == null ? 0 : l8.hashCode()) * 31;
            String str = this.f32234b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f32235c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f32236d;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f32237e;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f32238f;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f32239g;
            return ((((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + b().hashCode()) * 31) + a().hashCode();
        }

        public final String i() {
            return this.f32238f;
        }

        public String toString() {
            Long l8 = this.f32233a;
            String str = this.f32234b;
            String str2 = this.f32235c;
            String str3 = this.f32236d;
            String str4 = this.f32237e;
            String str5 = this.f32238f;
            String str6 = this.f32239g;
            OrderMenuData b8 = b();
            OrderCommonData a8 = a();
            return "GoingToPickupData(etaSeconds=" + l8 + ", address=" + str + ", clientName=" + str2 + ", clientRating=" + str3 + ", clientRidesCount=" + str4 + ", shortHandDescription=" + str5 + ", categoryAndPriceLabel=" + str6 + ", menuData=" + b8 + ", common=" + a8 + ")";
        }
    }

    /* compiled from: OrderData.kt */
    /* loaded from: classes3.dex */
    public static final class WaitingForClientData extends OrderData {

        /* renamed from: a  reason: collision with root package name */
        private final String f32242a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32243b;

        /* renamed from: c  reason: collision with root package name */
        private final String f32244c;

        /* renamed from: d  reason: collision with root package name */
        private final String f32245d;

        /* renamed from: e  reason: collision with root package name */
        private final WaitingTime f32246e;

        /* renamed from: f  reason: collision with root package name */
        private final String f32247f;

        /* renamed from: g  reason: collision with root package name */
        private final OrderMenuData f32248g;

        /* renamed from: h  reason: collision with root package name */
        private final OrderCommonData f32249h;

        /* compiled from: OrderData.kt */
        /* loaded from: classes3.dex */
        public interface WaitingTime {

            /* compiled from: OrderData.kt */
            /* loaded from: classes3.dex */
            public static final class Free implements WaitingTime {

                /* renamed from: a  reason: collision with root package name */
                private final long f32250a;

                private /* synthetic */ Free(long j8) {
                    this.f32250a = j8;
                }

                public static final /* synthetic */ Free b(long j8) {
                    return new Free(j8);
                }

                public static long c(long j8) {
                    return j8;
                }

                public static boolean d(long j8, Object obj) {
                    return (obj instanceof Free) && j8 == ((Free) obj).g();
                }

                public static int e(long j8) {
                    return i0.a.a(j8);
                }

                public static String f(long j8) {
                    return "Free(seconds=" + j8 + ")";
                }

                @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData.WaitingForClientData.WaitingTime
                public long a() {
                    return this.f32250a;
                }

                public boolean equals(Object obj) {
                    return d(this.f32250a, obj);
                }

                public final /* synthetic */ long g() {
                    return this.f32250a;
                }

                public int hashCode() {
                    return e(this.f32250a);
                }

                public String toString() {
                    return f(this.f32250a);
                }
            }

            /* compiled from: OrderData.kt */
            /* loaded from: classes3.dex */
            public static final class Paid implements WaitingTime {

                /* renamed from: a  reason: collision with root package name */
                private final long f32251a;

                private /* synthetic */ Paid(long j8) {
                    this.f32251a = j8;
                }

                public static final /* synthetic */ Paid b(long j8) {
                    return new Paid(j8);
                }

                public static long c(long j8) {
                    return j8;
                }

                public static boolean d(long j8, Object obj) {
                    return (obj instanceof Paid) && j8 == ((Paid) obj).g();
                }

                public static int e(long j8) {
                    return i0.a.a(j8);
                }

                public static String f(long j8) {
                    return "Paid(seconds=" + j8 + ")";
                }

                @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData.WaitingForClientData.WaitingTime
                public long a() {
                    return this.f32251a;
                }

                public boolean equals(Object obj) {
                    return d(this.f32251a, obj);
                }

                public final /* synthetic */ long g() {
                    return this.f32251a;
                }

                public int hashCode() {
                    return e(this.f32251a);
                }

                public String toString() {
                    return f(this.f32251a);
                }
            }

            /* compiled from: OrderData.kt */
            /* loaded from: classes3.dex */
            public static final class PickUp implements WaitingTime {

                /* renamed from: a  reason: collision with root package name */
                private final long f32252a;

                private /* synthetic */ PickUp(long j8) {
                    this.f32252a = j8;
                }

                public static final /* synthetic */ PickUp b(long j8) {
                    return new PickUp(j8);
                }

                public static long c(long j8) {
                    return j8;
                }

                public static boolean d(long j8, Object obj) {
                    return (obj instanceof PickUp) && j8 == ((PickUp) obj).g();
                }

                public static int e(long j8) {
                    return i0.a.a(j8);
                }

                public static String f(long j8) {
                    return "PickUp(seconds=" + j8 + ")";
                }

                @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData.WaitingForClientData.WaitingTime
                public long a() {
                    return this.f32252a;
                }

                public boolean equals(Object obj) {
                    return d(this.f32252a, obj);
                }

                public final /* synthetic */ long g() {
                    return this.f32252a;
                }

                public int hashCode() {
                    return e(this.f32252a);
                }

                public String toString() {
                    return f(this.f32252a);
                }
            }

            long a();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingForClientData(String str, String str2, String str3, String str4, WaitingTime waitingTime, String str5, OrderMenuData menuData, OrderCommonData common) {
            super(null);
            Intrinsics.f(waitingTime, "waitingTime");
            Intrinsics.f(menuData, "menuData");
            Intrinsics.f(common, "common");
            this.f32242a = str;
            this.f32243b = str2;
            this.f32244c = str3;
            this.f32245d = str4;
            this.f32246e = waitingTime;
            this.f32247f = str5;
            this.f32248g = menuData;
            this.f32249h = common;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderCommonData a() {
            return this.f32249h;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderMenuData b() {
            return this.f32248g;
        }

        public final String c() {
            return this.f32245d;
        }

        public final String d() {
            return this.f32247f;
        }

        public final String e() {
            return this.f32242a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WaitingForClientData) {
                WaitingForClientData waitingForClientData = (WaitingForClientData) obj;
                return Intrinsics.a(this.f32242a, waitingForClientData.f32242a) && Intrinsics.a(this.f32243b, waitingForClientData.f32243b) && Intrinsics.a(this.f32244c, waitingForClientData.f32244c) && Intrinsics.a(this.f32245d, waitingForClientData.f32245d) && Intrinsics.a(this.f32246e, waitingForClientData.f32246e) && Intrinsics.a(this.f32247f, waitingForClientData.f32247f) && Intrinsics.a(b(), waitingForClientData.b()) && Intrinsics.a(a(), waitingForClientData.a());
            }
            return false;
        }

        public final String f() {
            return this.f32243b;
        }

        public final String g() {
            return this.f32244c;
        }

        public final WaitingTime h() {
            return this.f32246e;
        }

        public int hashCode() {
            String str = this.f32242a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f32243b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f32244c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f32245d;
            int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f32246e.hashCode()) * 31;
            String str5 = this.f32247f;
            return ((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + b().hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            String str = this.f32242a;
            String str2 = this.f32243b;
            String str3 = this.f32244c;
            String str4 = this.f32245d;
            WaitingTime waitingTime = this.f32246e;
            String str5 = this.f32247f;
            OrderMenuData b8 = b();
            OrderCommonData a8 = a();
            return "WaitingForClientData(clientName=" + str + ", clientRating=" + str2 + ", clientRidesCount=" + str3 + ", address=" + str4 + ", waitingTime=" + waitingTime + ", categoryAndPriceLabel=" + str5 + ", menuData=" + b8 + ", common=" + a8 + ")";
        }
    }

    /* compiled from: OrderData.kt */
    /* loaded from: classes3.dex */
    public static final class WaitingOnStopData extends OrderData {

        /* renamed from: a  reason: collision with root package name */
        private final long f32253a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32254b;

        /* renamed from: c  reason: collision with root package name */
        private final String f32255c;

        /* renamed from: d  reason: collision with root package name */
        private final PaymentType f32256d;

        /* renamed from: e  reason: collision with root package name */
        private final OrderMenuData f32257e;

        /* renamed from: f  reason: collision with root package name */
        private final OrderCommonData f32258f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingOnStopData(long j8, String waitingPrice, String str, PaymentType paymentType, OrderMenuData menuData, OrderCommonData common) {
            super(null);
            Intrinsics.f(waitingPrice, "waitingPrice");
            Intrinsics.f(paymentType, "paymentType");
            Intrinsics.f(menuData, "menuData");
            Intrinsics.f(common, "common");
            this.f32253a = j8;
            this.f32254b = waitingPrice;
            this.f32255c = str;
            this.f32256d = paymentType;
            this.f32257e = menuData;
            this.f32258f = common;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderCommonData a() {
            return this.f32258f;
        }

        @Override // ee.mtakso.driver.ui.screens.order.v2.order.OrderData
        public OrderMenuData b() {
            return this.f32257e;
        }

        public final String c() {
            return this.f32255c;
        }

        public final PaymentType d() {
            return this.f32256d;
        }

        public final String e() {
            return this.f32254b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WaitingOnStopData) {
                WaitingOnStopData waitingOnStopData = (WaitingOnStopData) obj;
                return this.f32253a == waitingOnStopData.f32253a && Intrinsics.a(this.f32254b, waitingOnStopData.f32254b) && Intrinsics.a(this.f32255c, waitingOnStopData.f32255c) && this.f32256d == waitingOnStopData.f32256d && Intrinsics.a(b(), waitingOnStopData.b()) && Intrinsics.a(a(), waitingOnStopData.a());
            }
            return false;
        }

        public final long f() {
            return this.f32253a;
        }

        public int hashCode() {
            int a8 = ((i0.a.a(this.f32253a) * 31) + this.f32254b.hashCode()) * 31;
            String str = this.f32255c;
            return ((((((a8 + (str == null ? 0 : str.hashCode())) * 31) + this.f32256d.hashCode()) * 31) + b().hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            long j8 = this.f32253a;
            String str = this.f32254b;
            String str2 = this.f32255c;
            PaymentType paymentType = this.f32256d;
            OrderMenuData b8 = b();
            OrderCommonData a8 = a();
            return "WaitingOnStopData(waitingTime=" + j8 + ", waitingPrice=" + str + ", address=" + str2 + ", paymentType=" + paymentType + ", menuData=" + b8 + ", common=" + a8 + ")";
        }
    }

    private OrderData() {
    }

    public /* synthetic */ OrderData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract OrderCommonData a();

    public abstract OrderMenuData b();
}
