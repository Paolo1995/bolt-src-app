package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: AcceptedScheduledRides.kt */
/* loaded from: classes3.dex */
public final class AcceptedScheduledRides {
    @SerializedName("groups")

    /* renamed from: a  reason: collision with root package name */
    private final List<Group> f22313a;
    @SerializedName("detail_label_types")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, RideDetailLabelTypeInfo> f22314b;

    /* compiled from: AcceptedScheduledRides.kt */
    /* loaded from: classes3.dex */
    public static final class Group {
        @SerializedName(Name.MARK)

        /* renamed from: a  reason: collision with root package name */
        private final String f22315a;
        @SerializedName("title_html")

        /* renamed from: b  reason: collision with root package name */
        private final String f22316b;
        @SerializedName("items")

        /* renamed from: c  reason: collision with root package name */
        private final List<Item> f22317c;

        public final String a() {
            return this.f22315a;
        }

        public final List<Item> b() {
            return this.f22317c;
        }

        public final String c() {
            return this.f22316b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Group) {
                Group group = (Group) obj;
                return Intrinsics.a(this.f22315a, group.f22315a) && Intrinsics.a(this.f22316b, group.f22316b) && Intrinsics.a(this.f22317c, group.f22317c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f22315a.hashCode() * 31) + this.f22316b.hashCode()) * 31) + this.f22317c.hashCode();
        }

        public String toString() {
            String str = this.f22315a;
            String str2 = this.f22316b;
            List<Item> list = this.f22317c;
            return "Group(id=" + str + ", titleHtml=" + str2 + ", items=" + list + ")";
        }
    }

    /* compiled from: AcceptedScheduledRides.kt */
    /* loaded from: classes3.dex */
    public static final class Item {
        @SerializedName("order_handle")

        /* renamed from: a  reason: collision with root package name */
        private final OrderHandle f22318a;
        @SerializedName("ride_detail_chips")

        /* renamed from: b  reason: collision with root package name */
        private final List<RideDetailChip> f22319b;
        @SerializedName("title_html")

        /* renamed from: c  reason: collision with root package name */
        private final String f22320c;
        @SerializedName("ride_details")

        /* renamed from: d  reason: collision with root package name */
        private final List<RideDetailLabel> f22321d;
        @SerializedName("infoblock")

        /* renamed from: e  reason: collision with root package name */
        private final RideDetailInfoBlock f22322e;

        public final RideDetailInfoBlock a() {
            return this.f22322e;
        }

        public final OrderHandle b() {
            return this.f22318a;
        }

        public final List<RideDetailChip> c() {
            return this.f22319b;
        }

        public final List<RideDetailLabel> d() {
            return this.f22321d;
        }

        public final String e() {
            return this.f22320c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return Intrinsics.a(this.f22318a, item.f22318a) && Intrinsics.a(this.f22319b, item.f22319b) && Intrinsics.a(this.f22320c, item.f22320c) && Intrinsics.a(this.f22321d, item.f22321d) && Intrinsics.a(this.f22322e, item.f22322e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f22318a.hashCode() * 31) + this.f22319b.hashCode()) * 31) + this.f22320c.hashCode()) * 31) + this.f22321d.hashCode()) * 31) + this.f22322e.hashCode();
        }

        public String toString() {
            OrderHandle orderHandle = this.f22318a;
            List<RideDetailChip> list = this.f22319b;
            String str = this.f22320c;
            List<RideDetailLabel> list2 = this.f22321d;
            RideDetailInfoBlock rideDetailInfoBlock = this.f22322e;
            return "Item(orderHandle=" + orderHandle + ", rideDetailChips=" + list + ", titleHtml=" + str + ", rideDetails=" + list2 + ", infoBlock=" + rideDetailInfoBlock + ")";
        }
    }

    public final Map<String, RideDetailLabelTypeInfo> a() {
        return this.f22314b;
    }

    public final List<Group> b() {
        return this.f22313a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AcceptedScheduledRides) {
            AcceptedScheduledRides acceptedScheduledRides = (AcceptedScheduledRides) obj;
            return Intrinsics.a(this.f22313a, acceptedScheduledRides.f22313a) && Intrinsics.a(this.f22314b, acceptedScheduledRides.f22314b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22313a.hashCode() * 31;
        Map<String, RideDetailLabelTypeInfo> map = this.f22314b;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        List<Group> list = this.f22313a;
        Map<String, RideDetailLabelTypeInfo> map = this.f22314b;
        return "AcceptedScheduledRides(groups=" + list + ", detailLabelTypes=" + map + ")";
    }
}
