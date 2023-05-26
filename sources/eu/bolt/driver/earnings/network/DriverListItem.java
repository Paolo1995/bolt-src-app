package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverListItem.kt */
/* loaded from: classes5.dex */
public final class DriverListItem {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41383a;
    @SerializedName("title_type")

    /* renamed from: b  reason: collision with root package name */
    private final DriverContentType f41384b;
    @SerializedName("subtitle")

    /* renamed from: c  reason: collision with root package name */
    private final String f41385c;
    @SerializedName("title_icon")

    /* renamed from: d  reason: collision with root package name */
    private final DriverImage f41386d;
    @SerializedName("title_action_url")

    /* renamed from: e  reason: collision with root package name */
    private final String f41387e;
    @SerializedName("action_url")

    /* renamed from: f  reason: collision with root package name */
    private final String f41388f;
    @SerializedName("trailing_component")

    /* renamed from: g  reason: collision with root package name */
    private final DriverListItemComponent f41389g;
    @SerializedName("lead_component")

    /* renamed from: h  reason: collision with root package name */
    private final DriverListItemComponent f41390h;

    public final String a() {
        return this.f41388f;
    }

    public final String b() {
        return this.f41385c;
    }

    public final String c() {
        return this.f41383a;
    }

    public final DriverContentType d() {
        return this.f41384b;
    }

    public final DriverListItemComponent e() {
        return this.f41389g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverListItem) {
            DriverListItem driverListItem = (DriverListItem) obj;
            return Intrinsics.a(this.f41383a, driverListItem.f41383a) && this.f41384b == driverListItem.f41384b && Intrinsics.a(this.f41385c, driverListItem.f41385c) && Intrinsics.a(this.f41386d, driverListItem.f41386d) && Intrinsics.a(this.f41387e, driverListItem.f41387e) && Intrinsics.a(this.f41388f, driverListItem.f41388f) && Intrinsics.a(this.f41389g, driverListItem.f41389g) && Intrinsics.a(this.f41390h, driverListItem.f41390h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f41383a.hashCode() * 31;
        DriverContentType driverContentType = this.f41384b;
        int hashCode2 = (hashCode + (driverContentType == null ? 0 : driverContentType.hashCode())) * 31;
        String str = this.f41385c;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        DriverImage driverImage = this.f41386d;
        int hashCode4 = (hashCode3 + (driverImage == null ? 0 : driverImage.hashCode())) * 31;
        String str2 = this.f41387e;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f41388f;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        DriverListItemComponent driverListItemComponent = this.f41389g;
        int hashCode7 = (hashCode6 + (driverListItemComponent == null ? 0 : driverListItemComponent.hashCode())) * 31;
        DriverListItemComponent driverListItemComponent2 = this.f41390h;
        return hashCode7 + (driverListItemComponent2 != null ? driverListItemComponent2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f41383a;
        DriverContentType driverContentType = this.f41384b;
        String str2 = this.f41385c;
        DriverImage driverImage = this.f41386d;
        String str3 = this.f41387e;
        String str4 = this.f41388f;
        DriverListItemComponent driverListItemComponent = this.f41389g;
        DriverListItemComponent driverListItemComponent2 = this.f41390h;
        return "DriverListItem(title=" + str + ", titleType=" + driverContentType + ", subtitle=" + str2 + ", titleIcon=" + driverImage + ", titleActionUrl=" + str3 + ", actionUrl=" + str4 + ", trailingComponent=" + driverListItemComponent + ", leadComponent=" + driverListItemComponent2 + ")";
    }
}
