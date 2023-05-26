package ee.mtakso.driver.network.usage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUsage.kt */
@Keep
/* loaded from: classes3.dex */
public final class NetworkUsage implements Parcelable {
    public static final Parcelable.Creator<NetworkUsage> CREATOR = new Creator();
    private final long receivedBytes;
    private final long sentBytes;
    private final long totalBytes;

    /* compiled from: NetworkUsage.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<NetworkUsage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final NetworkUsage createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new NetworkUsage(parcel.readLong(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final NetworkUsage[] newArray(int i8) {
            return new NetworkUsage[i8];
        }
    }

    public NetworkUsage(long j8, long j9, long j10) {
        this.sentBytes = j8;
        this.receivedBytes = j9;
        this.totalBytes = j10;
    }

    public static /* synthetic */ NetworkUsage copy$default(NetworkUsage networkUsage, long j8, long j9, long j10, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = networkUsage.sentBytes;
        }
        long j11 = j8;
        if ((i8 & 2) != 0) {
            j9 = networkUsage.receivedBytes;
        }
        long j12 = j9;
        if ((i8 & 4) != 0) {
            j10 = networkUsage.totalBytes;
        }
        return networkUsage.copy(j11, j12, j10);
    }

    public final long component1() {
        return this.sentBytes;
    }

    public final long component2() {
        return this.receivedBytes;
    }

    public final long component3() {
        return this.totalBytes;
    }

    public final NetworkUsage copy(long j8, long j9, long j10) {
        return new NetworkUsage(j8, j9, j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NetworkUsage) {
            NetworkUsage networkUsage = (NetworkUsage) obj;
            return this.sentBytes == networkUsage.sentBytes && this.receivedBytes == networkUsage.receivedBytes && this.totalBytes == networkUsage.totalBytes;
        }
        return false;
    }

    public final long getReceivedBytes() {
        return this.receivedBytes;
    }

    public final long getSentBytes() {
        return this.sentBytes;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public int hashCode() {
        return (((a.a(this.sentBytes) * 31) + a.a(this.receivedBytes)) * 31) + a.a(this.totalBytes);
    }

    public String toString() {
        long j8 = this.sentBytes;
        long j9 = this.receivedBytes;
        long j10 = this.totalBytes;
        return "NetworkUsage(sentBytes=" + j8 + ", receivedBytes=" + j9 + ", totalBytes=" + j10 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.sentBytes);
        out.writeLong(this.receivedBytes);
        out.writeLong(this.totalBytes);
    }
}
