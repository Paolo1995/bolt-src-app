package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ScheduledRideRequests.kt */
/* loaded from: classes3.dex */
public final class ScheduledRideRequests {
    @SerializedName("groups")

    /* renamed from: a  reason: collision with root package name */
    private final List<Group> f22579a;
    @SerializedName("accepted_requests_number")

    /* renamed from: b  reason: collision with root package name */
    private final int f22580b;
    @SerializedName("detail_label_types")

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, RideDetailLabelTypeInfo> f22581c;

    /* compiled from: ScheduledRideRequests.kt */
    /* loaded from: classes3.dex */
    public static final class Group {
        @SerializedName(Name.MARK)

        /* renamed from: a  reason: collision with root package name */
        private final String f22582a;
        @SerializedName("title_html")

        /* renamed from: b  reason: collision with root package name */
        private final String f22583b;
        @SerializedName("expandable")

        /* renamed from: c  reason: collision with root package name */
        private final boolean f22584c;
        @SerializedName("items")

        /* renamed from: d  reason: collision with root package name */
        private final List<Item> f22585d;

        public final boolean a() {
            return this.f22584c;
        }

        public final String b() {
            return this.f22582a;
        }

        public final List<Item> c() {
            return this.f22585d;
        }

        public final String d() {
            return this.f22583b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Group) {
                Group group = (Group) obj;
                return Intrinsics.a(this.f22582a, group.f22582a) && Intrinsics.a(this.f22583b, group.f22583b) && this.f22584c == group.f22584c && Intrinsics.a(this.f22585d, group.f22585d);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f22582a.hashCode() * 31) + this.f22583b.hashCode()) * 31;
            boolean z7 = this.f22584c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return ((hashCode + i8) * 31) + this.f22585d.hashCode();
        }

        public String toString() {
            String str = this.f22582a;
            String str2 = this.f22583b;
            boolean z7 = this.f22584c;
            List<Item> list = this.f22585d;
            return "Group(id=" + str + ", titleHtml=" + str2 + ", expandable=" + z7 + ", items=" + list + ")";
        }
    }

    /* compiled from: ScheduledRideRequests.kt */
    /* loaded from: classes3.dex */
    public static final class Item {
        @SerializedName("order_handle")

        /* renamed from: a  reason: collision with root package name */
        private final OrderHandle f22586a;
        @SerializedName("title_html")

        /* renamed from: b  reason: collision with root package name */
        private final String f22587b;
        @SerializedName("ride_details")

        /* renamed from: c  reason: collision with root package name */
        private final List<RideDetailLabel> f22588c;
        @SerializedName("map_points")

        /* renamed from: d  reason: collision with root package name */
        private final List<OrderMapPoint> f22589d;
        @SerializedName("route_points")

        /* renamed from: e  reason: collision with root package name */
        private final List<RideDetailRoutePoint> f22590e;

        public final List<OrderMapPoint> a() {
            return this.f22589d;
        }

        public final OrderHandle b() {
            return this.f22586a;
        }

        public final List<RideDetailLabel> c() {
            return this.f22588c;
        }

        public final List<RideDetailRoutePoint> d() {
            return this.f22590e;
        }

        public final String e() {
            return this.f22587b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return Intrinsics.a(this.f22586a, item.f22586a) && Intrinsics.a(this.f22587b, item.f22587b) && Intrinsics.a(this.f22588c, item.f22588c) && Intrinsics.a(this.f22589d, item.f22589d) && Intrinsics.a(this.f22590e, item.f22590e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f22586a.hashCode() * 31) + this.f22587b.hashCode()) * 31) + this.f22588c.hashCode()) * 31) + this.f22589d.hashCode()) * 31) + this.f22590e.hashCode();
        }

        public String toString() {
            OrderHandle orderHandle = this.f22586a;
            String str = this.f22587b;
            List<RideDetailLabel> list = this.f22588c;
            List<OrderMapPoint> list2 = this.f22589d;
            List<RideDetailRoutePoint> list3 = this.f22590e;
            return "Item(orderHandle=" + orderHandle + ", titleHtml=" + str + ", rideDetails=" + list + ", mapPoints=" + list2 + ", routePoints=" + list3 + ")";
        }
    }

    public final int a() {
        return this.f22580b;
    }

    public final Map<String, RideDetailLabelTypeInfo> b() {
        return this.f22581c;
    }

    public final List<Group> c() {
        return this.f22579a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScheduledRideRequests) {
            ScheduledRideRequests scheduledRideRequests = (ScheduledRideRequests) obj;
            return Intrinsics.a(this.f22579a, scheduledRideRequests.f22579a) && this.f22580b == scheduledRideRequests.f22580b && Intrinsics.a(this.f22581c, scheduledRideRequests.f22581c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f22579a.hashCode() * 31) + this.f22580b) * 31;
        Map<String, RideDetailLabelTypeInfo> map = this.f22581c;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        List<Group> list = this.f22579a;
        int i8 = this.f22580b;
        Map<String, RideDetailLabelTypeInfo> map = this.f22581c;
        return "ScheduledRideRequests(groups=" + list + ", acceptedRequestsNumber=" + i8 + ", detailLabelTypes=" + map + ")";
    }
}
