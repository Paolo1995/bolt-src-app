package ee.mtakso.driver.uicore.components.views.order_stops_view;

import ee.mtakso.driver.uicore.utils.Dimens;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStopsView.kt */
/* loaded from: classes5.dex */
public final class Stop {

    /* renamed from: a  reason: collision with root package name */
    private final ItemType f35649a;

    /* renamed from: b  reason: collision with root package name */
    private final String f35650b;

    /* renamed from: c  reason: collision with root package name */
    private final String f35651c;

    /* renamed from: d  reason: collision with root package name */
    private final String f35652d;

    /* renamed from: e  reason: collision with root package name */
    private final int f35653e;

    /* renamed from: f  reason: collision with root package name */
    private final int f35654f;

    /* renamed from: g  reason: collision with root package name */
    private final int f35655g;

    public Stop(ItemType type, String str, String title, String str2, int i8, int i9, int i10) {
        Intrinsics.f(type, "type");
        Intrinsics.f(title, "title");
        this.f35649a = type;
        this.f35650b = str;
        this.f35651c = title;
        this.f35652d = str2;
        this.f35653e = i8;
        this.f35654f = i9;
        this.f35655g = i10;
    }

    public final String a() {
        return this.f35652d;
    }

    public final String b() {
        return this.f35650b;
    }

    public final int c() {
        return this.f35654f;
    }

    public final int d() {
        return this.f35655g;
    }

    public final int e() {
        return this.f35653e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Stop) {
            Stop stop = (Stop) obj;
            return this.f35649a == stop.f35649a && Intrinsics.a(this.f35650b, stop.f35650b) && Intrinsics.a(this.f35651c, stop.f35651c) && Intrinsics.a(this.f35652d, stop.f35652d) && this.f35653e == stop.f35653e && this.f35654f == stop.f35654f && this.f35655g == stop.f35655g;
        }
        return false;
    }

    public final String f() {
        return this.f35651c;
    }

    public final ItemType g() {
        return this.f35649a;
    }

    public int hashCode() {
        int hashCode = this.f35649a.hashCode() * 31;
        String str = this.f35650b;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f35651c.hashCode()) * 31;
        String str2 = this.f35652d;
        return ((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f35653e) * 31) + this.f35654f) * 31) + this.f35655g;
    }

    public String toString() {
        ItemType itemType = this.f35649a;
        String str = this.f35650b;
        String str2 = this.f35651c;
        String str3 = this.f35652d;
        int i8 = this.f35653e;
        int i9 = this.f35654f;
        int i10 = this.f35655g;
        return "Stop(type=" + itemType + ", formattedTime=" + str + ", title=" + str2 + ", distance=" + str3 + ", textColor=" + i8 + ", iconId=" + i9 + ", iconMarginStart=" + i10 + ")";
    }

    public /* synthetic */ Stop(ItemType itemType, String str, String str2, String str3, int i8, int i9, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemType, str, str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? -16777216 : i8, i9, (i11 & 64) != 0 ? Dimens.d(27) : i10);
    }
}
