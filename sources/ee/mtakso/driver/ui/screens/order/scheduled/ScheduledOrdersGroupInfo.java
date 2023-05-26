package ee.mtakso.driver.ui.screens.order.scheduled;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersGroupInfo.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersGroupInfo implements Parcelable {

    /* renamed from: f  reason: collision with root package name */
    private final String f31784f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31785g;

    /* renamed from: h  reason: collision with root package name */
    private final OrderHandle f31786h;

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f31783i = new Companion(null);
    public static final Parcelable.Creator<ScheduledOrdersGroupInfo> CREATOR = new Creator();

    /* compiled from: ScheduledOrdersGroupInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ScheduledOrdersGroupInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ScheduledOrdersGroupInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ScheduledOrdersGroupInfo createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new ScheduledOrdersGroupInfo(parcel.readString(), parcel.readString(), OrderHandle.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ScheduledOrdersGroupInfo[] newArray(int i8) {
            return new ScheduledOrdersGroupInfo[i8];
        }
    }

    public ScheduledOrdersGroupInfo(String id, String titleHtml, OrderHandle lastOrderHandle) {
        Intrinsics.f(id, "id");
        Intrinsics.f(titleHtml, "titleHtml");
        Intrinsics.f(lastOrderHandle, "lastOrderHandle");
        this.f31784f = id;
        this.f31785g = titleHtml;
        this.f31786h = lastOrderHandle;
    }

    public final String a() {
        return this.f31784f;
    }

    public final OrderHandle b() {
        return this.f31786h;
    }

    public final String c() {
        return this.f31785g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScheduledOrdersGroupInfo) {
            ScheduledOrdersGroupInfo scheduledOrdersGroupInfo = (ScheduledOrdersGroupInfo) obj;
            return Intrinsics.a(this.f31784f, scheduledOrdersGroupInfo.f31784f) && Intrinsics.a(this.f31785g, scheduledOrdersGroupInfo.f31785g) && Intrinsics.a(this.f31786h, scheduledOrdersGroupInfo.f31786h);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f31784f.hashCode() * 31) + this.f31785g.hashCode()) * 31) + this.f31786h.hashCode();
    }

    public String toString() {
        String str = this.f31784f;
        String str2 = this.f31785g;
        OrderHandle orderHandle = this.f31786h;
        return "ScheduledOrdersGroupInfo(id=" + str + ", titleHtml=" + str2 + ", lastOrderHandle=" + orderHandle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f31784f);
        out.writeString(this.f31785g);
        this.f31786h.writeToParcel(out, i8);
    }
}
