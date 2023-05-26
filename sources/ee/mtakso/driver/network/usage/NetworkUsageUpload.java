package ee.mtakso.driver.network.usage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUsageUpload.kt */
@Keep
/* loaded from: classes3.dex */
public final class NetworkUsageUpload implements Parcelable {
    public static final Parcelable.Creator<NetworkUsageUpload> CREATOR = new Creator();
    private final long lastUploadTimeInMs;
    private final NetworkUsage networkUsage;

    /* compiled from: NetworkUsageUpload.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<NetworkUsageUpload> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final NetworkUsageUpload createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new NetworkUsageUpload(parcel.readLong(), NetworkUsage.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final NetworkUsageUpload[] newArray(int i8) {
            return new NetworkUsageUpload[i8];
        }
    }

    public NetworkUsageUpload(long j8, NetworkUsage networkUsage) {
        Intrinsics.f(networkUsage, "networkUsage");
        this.lastUploadTimeInMs = j8;
        this.networkUsage = networkUsage;
    }

    public static /* synthetic */ NetworkUsageUpload copy$default(NetworkUsageUpload networkUsageUpload, long j8, NetworkUsage networkUsage, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = networkUsageUpload.lastUploadTimeInMs;
        }
        if ((i8 & 2) != 0) {
            networkUsage = networkUsageUpload.networkUsage;
        }
        return networkUsageUpload.copy(j8, networkUsage);
    }

    public final long component1() {
        return this.lastUploadTimeInMs;
    }

    public final NetworkUsage component2() {
        return this.networkUsage;
    }

    public final NetworkUsageUpload copy(long j8, NetworkUsage networkUsage) {
        Intrinsics.f(networkUsage, "networkUsage");
        return new NetworkUsageUpload(j8, networkUsage);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NetworkUsageUpload) {
            NetworkUsageUpload networkUsageUpload = (NetworkUsageUpload) obj;
            return this.lastUploadTimeInMs == networkUsageUpload.lastUploadTimeInMs && Intrinsics.a(this.networkUsage, networkUsageUpload.networkUsage);
        }
        return false;
    }

    public final long getLastUploadTimeInMs() {
        return this.lastUploadTimeInMs;
    }

    public final NetworkUsage getNetworkUsage() {
        return this.networkUsage;
    }

    public int hashCode() {
        return (a.a(this.lastUploadTimeInMs) * 31) + this.networkUsage.hashCode();
    }

    public String toString() {
        long j8 = this.lastUploadTimeInMs;
        NetworkUsage networkUsage = this.networkUsage;
        return "NetworkUsageUpload(lastUploadTimeInMs=" + j8 + ", networkUsage=" + networkUsage + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.lastUploadTimeInMs);
        this.networkUsage.writeToParcel(out, i8);
    }
}
