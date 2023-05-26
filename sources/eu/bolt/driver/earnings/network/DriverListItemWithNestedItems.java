package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverListItemWithNestedItems.kt */
/* loaded from: classes5.dex */
public final class DriverListItemWithNestedItems {
    @SerializedName("nested_items")

    /* renamed from: a  reason: collision with root package name */
    private final List<DriverListItem> f41403a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f41404b;
    @SerializedName("subtitle")

    /* renamed from: c  reason: collision with root package name */
    private final String f41405c;
    @SerializedName("title_icon")

    /* renamed from: d  reason: collision with root package name */
    private final DriverImage f41406d;
    @SerializedName("title_action_url")

    /* renamed from: e  reason: collision with root package name */
    private final String f41407e;
    @SerializedName("action_url")

    /* renamed from: f  reason: collision with root package name */
    private final String f41408f;
    @SerializedName("trailing_component")

    /* renamed from: g  reason: collision with root package name */
    private final DriverListItemComponent f41409g;
    @SerializedName("lead_component")

    /* renamed from: h  reason: collision with root package name */
    private final DriverListItemComponent f41410h;

    public final String a() {
        return this.f41408f;
    }

    public final List<DriverListItem> b() {
        return this.f41403a;
    }

    public final String c() {
        return this.f41404b;
    }

    public final DriverListItemComponent d() {
        return this.f41409g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverListItemWithNestedItems) {
            DriverListItemWithNestedItems driverListItemWithNestedItems = (DriverListItemWithNestedItems) obj;
            return Intrinsics.a(this.f41403a, driverListItemWithNestedItems.f41403a) && Intrinsics.a(this.f41404b, driverListItemWithNestedItems.f41404b) && Intrinsics.a(this.f41405c, driverListItemWithNestedItems.f41405c) && Intrinsics.a(this.f41406d, driverListItemWithNestedItems.f41406d) && Intrinsics.a(this.f41407e, driverListItemWithNestedItems.f41407e) && Intrinsics.a(this.f41408f, driverListItemWithNestedItems.f41408f) && Intrinsics.a(this.f41409g, driverListItemWithNestedItems.f41409g) && Intrinsics.a(this.f41410h, driverListItemWithNestedItems.f41410h);
        }
        return false;
    }

    public int hashCode() {
        List<DriverListItem> list = this.f41403a;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.f41404b.hashCode()) * 31;
        String str = this.f41405c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        DriverImage driverImage = this.f41406d;
        int hashCode3 = (hashCode2 + (driverImage == null ? 0 : driverImage.hashCode())) * 31;
        String str2 = this.f41407e;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f41408f;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        DriverListItemComponent driverListItemComponent = this.f41409g;
        int hashCode6 = (hashCode5 + (driverListItemComponent == null ? 0 : driverListItemComponent.hashCode())) * 31;
        DriverListItemComponent driverListItemComponent2 = this.f41410h;
        return hashCode6 + (driverListItemComponent2 != null ? driverListItemComponent2.hashCode() : 0);
    }

    public String toString() {
        List<DriverListItem> list = this.f41403a;
        String str = this.f41404b;
        String str2 = this.f41405c;
        DriverImage driverImage = this.f41406d;
        String str3 = this.f41407e;
        String str4 = this.f41408f;
        DriverListItemComponent driverListItemComponent = this.f41409g;
        DriverListItemComponent driverListItemComponent2 = this.f41410h;
        return "DriverListItemWithNestedItems(nestedItems=" + list + ", title=" + str + ", subtitle=" + str2 + ", titleIcon=" + driverImage + ", titleActionUrl=" + str3 + ", actionUrl=" + str4 + ", trailingComponent=" + driverListItemComponent + ", leadComponent=" + driverListItemComponent2 + ")";
    }
}
