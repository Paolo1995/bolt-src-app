package ee.mtakso.voip_client;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipPeer.kt */
/* loaded from: classes5.dex */
public final class VoipPeer implements Parcelable {
    public static final Parcelable.Creator<VoipPeer> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f36537f;

    /* renamed from: g  reason: collision with root package name */
    private final String f36538g;

    /* renamed from: h  reason: collision with root package name */
    private final String f36539h;

    /* compiled from: VoipPeer.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<VoipPeer> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final VoipPeer createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new VoipPeer(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final VoipPeer[] newArray(int i8) {
            return new VoipPeer[i8];
        }
    }

    public VoipPeer(String id, String str, String str2) {
        Intrinsics.f(id, "id");
        this.f36537f = id;
        this.f36538g = str;
        this.f36539h = str2;
    }

    public final String a() {
        return this.f36537f;
    }

    public final String b() {
        return this.f36538g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VoipPeer) {
            VoipPeer voipPeer = (VoipPeer) obj;
            return Intrinsics.a(this.f36537f, voipPeer.f36537f) && Intrinsics.a(this.f36538g, voipPeer.f36538g) && Intrinsics.a(this.f36539h, voipPeer.f36539h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f36537f.hashCode() * 31;
        String str = this.f36538g;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f36539h;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f36537f;
        String str2 = this.f36538g;
        String str3 = this.f36539h;
        return "VoipPeer(id=" + str + ", name=" + str2 + ", avatarUrl=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f36537f);
        out.writeString(this.f36538g);
        out.writeString(this.f36539h);
    }
}
