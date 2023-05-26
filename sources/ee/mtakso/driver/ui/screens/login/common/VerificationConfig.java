package ee.mtakso.driver.ui.screens.login.common;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationChannel;
import i0.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationConfig.kt */
/* loaded from: classes3.dex */
public final class VerificationConfig implements Parcelable {
    public static final Parcelable.Creator<VerificationConfig> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f30439f;

    /* renamed from: g  reason: collision with root package name */
    private final VerificationChannel f30440g;

    /* renamed from: h  reason: collision with root package name */
    private final String f30441h;

    /* renamed from: i  reason: collision with root package name */
    private final int f30442i;

    /* renamed from: j  reason: collision with root package name */
    private final int f30443j;

    /* renamed from: k  reason: collision with root package name */
    private final List<VerificationChannel> f30444k;

    /* renamed from: l  reason: collision with root package name */
    private final long f30445l;

    /* compiled from: VerificationConfig.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<VerificationConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final VerificationConfig createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            VerificationChannel valueOf = VerificationChannel.valueOf(parcel.readString());
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i8 = 0; i8 != readInt3; i8++) {
                arrayList.add(VerificationChannel.valueOf(parcel.readString()));
            }
            return new VerificationConfig(readString, valueOf, readString2, readInt, readInt2, arrayList, parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final VerificationConfig[] newArray(int i8) {
            return new VerificationConfig[i8];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VerificationConfig(String token, VerificationChannel channel, String target, int i8, int i9, List<? extends VerificationChannel> availableChannels, long j8) {
        Intrinsics.f(token, "token");
        Intrinsics.f(channel, "channel");
        Intrinsics.f(target, "target");
        Intrinsics.f(availableChannels, "availableChannels");
        this.f30439f = token;
        this.f30440g = channel;
        this.f30441h = target;
        this.f30442i = i8;
        this.f30443j = i9;
        this.f30444k = availableChannels;
        this.f30445l = j8;
    }

    public final VerificationConfig a(String token, VerificationChannel channel, String target, int i8, int i9, List<? extends VerificationChannel> availableChannels, long j8) {
        Intrinsics.f(token, "token");
        Intrinsics.f(channel, "channel");
        Intrinsics.f(target, "target");
        Intrinsics.f(availableChannels, "availableChannels");
        return new VerificationConfig(token, channel, target, i8, i9, availableChannels, j8);
    }

    public final List<VerificationChannel> c() {
        return this.f30444k;
    }

    public final int d() {
        return this.f30442i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f30443j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerificationConfig) {
            VerificationConfig verificationConfig = (VerificationConfig) obj;
            return Intrinsics.a(this.f30439f, verificationConfig.f30439f) && this.f30440g == verificationConfig.f30440g && Intrinsics.a(this.f30441h, verificationConfig.f30441h) && this.f30442i == verificationConfig.f30442i && this.f30443j == verificationConfig.f30443j && Intrinsics.a(this.f30444k, verificationConfig.f30444k) && this.f30445l == verificationConfig.f30445l;
        }
        return false;
    }

    public final long f() {
        return this.f30445l;
    }

    public final String g() {
        return this.f30441h;
    }

    public final String h() {
        return this.f30439f;
    }

    public int hashCode() {
        return (((((((((((this.f30439f.hashCode() * 31) + this.f30440g.hashCode()) * 31) + this.f30441h.hashCode()) * 31) + this.f30442i) * 31) + this.f30443j) * 31) + this.f30444k.hashCode()) * 31) + a.a(this.f30445l);
    }

    public String toString() {
        String str = this.f30439f;
        VerificationChannel verificationChannel = this.f30440g;
        String str2 = this.f30441h;
        int i8 = this.f30442i;
        int i9 = this.f30443j;
        List<VerificationChannel> list = this.f30444k;
        long j8 = this.f30445l;
        return "VerificationConfig(token=" + str + ", channel=" + verificationChannel + ", target=" + str2 + ", codeLength=" + i8 + ", reSendTimeout=" + i9 + ", availableChannels=" + list + ", requestedAt=" + j8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f30439f);
        out.writeString(this.f30440g.name());
        out.writeString(this.f30441h);
        out.writeInt(this.f30442i);
        out.writeInt(this.f30443j);
        List<VerificationChannel> list = this.f30444k;
        out.writeInt(list.size());
        for (VerificationChannel verificationChannel : list) {
            out.writeString(verificationChannel.name());
        }
        out.writeLong(this.f30445l);
    }
}
