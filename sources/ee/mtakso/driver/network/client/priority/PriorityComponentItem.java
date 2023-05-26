package ee.mtakso.driver.network.client.priority;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreconditionItem.kt */
/* loaded from: classes3.dex */
public final class PriorityComponentItem implements Parcelable {
    public static final Parcelable.Creator<PriorityComponentItem> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22687f;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: g  reason: collision with root package name */
    private final String f22688g;
    @SerializedName("action_url")

    /* renamed from: h  reason: collision with root package name */
    private final String f22689h;

    /* compiled from: PreconditionItem.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PriorityComponentItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PriorityComponentItem createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new PriorityComponentItem(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PriorityComponentItem[] newArray(int i8) {
            return new PriorityComponentItem[i8];
        }
    }

    public PriorityComponentItem(String title, String value, String str) {
        Intrinsics.f(title, "title");
        Intrinsics.f(value, "value");
        this.f22687f = title;
        this.f22688g = value;
        this.f22689h = str;
    }

    public final String a() {
        return this.f22689h;
    }

    public final String b() {
        return this.f22687f;
    }

    public final String c() {
        return this.f22688g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22687f);
        out.writeString(this.f22688g);
        out.writeString(this.f22689h);
    }
}
