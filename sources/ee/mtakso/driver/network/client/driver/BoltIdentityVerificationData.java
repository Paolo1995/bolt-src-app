package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltIdentityVerificationData.kt */
/* loaded from: classes3.dex */
public final class BoltIdentityVerificationData implements Parcelable {
    public static final Parcelable.Creator<BoltIdentityVerificationData> CREATOR = new Creator();
    @SerializedName("flow_run_uuid")

    /* renamed from: f  reason: collision with root package name */
    private final String f21885f;

    /* compiled from: BoltIdentityVerificationData.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<BoltIdentityVerificationData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BoltIdentityVerificationData createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new BoltIdentityVerificationData(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final BoltIdentityVerificationData[] newArray(int i8) {
            return new BoltIdentityVerificationData[i8];
        }
    }

    public BoltIdentityVerificationData(String flowRunId) {
        Intrinsics.f(flowRunId, "flowRunId");
        this.f21885f = flowRunId;
    }

    public final String a() {
        return this.f21885f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BoltIdentityVerificationData) && Intrinsics.a(this.f21885f, ((BoltIdentityVerificationData) obj).f21885f);
    }

    public int hashCode() {
        return this.f21885f.hashCode();
    }

    public String toString() {
        String str = this.f21885f;
        return "BoltIdentityVerificationData(flowRunId=" + str + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f21885f);
    }
}
