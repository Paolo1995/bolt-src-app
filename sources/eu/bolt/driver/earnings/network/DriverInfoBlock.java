package eu.bolt.driver.earnings.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverInfoBlock.kt */
/* loaded from: classes5.dex */
public final class DriverInfoBlock implements Parcelable {
    public static final Parcelable.Creator<DriverInfoBlock> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f41375f;
    @SerializedName("subtitle")

    /* renamed from: g  reason: collision with root package name */
    private final String f41376g;
    @SerializedName("image")

    /* renamed from: h  reason: collision with root package name */
    private final DriverImage f41377h;
    @SerializedName("show_icon")

    /* renamed from: i  reason: collision with root package name */
    private final boolean f41378i;
    @SerializedName("appearance")

    /* renamed from: j  reason: collision with root package name */
    private final Appearance f41379j;

    /* compiled from: DriverInfoBlock.kt */
    /* loaded from: classes5.dex */
    public enum Appearance {
        WARNING,
        PRIMARY,
        CRITICAL,
        NEUTRAL
    }

    /* compiled from: DriverInfoBlock.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<DriverInfoBlock> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DriverInfoBlock createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new DriverInfoBlock(parcel.readString(), parcel.readString(), (DriverImage) parcel.readParcelable(DriverInfoBlock.class.getClassLoader()), parcel.readInt() != 0, Appearance.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final DriverInfoBlock[] newArray(int i8) {
            return new DriverInfoBlock[i8];
        }
    }

    public DriverInfoBlock(String str, String subtitle, DriverImage image, boolean z7, Appearance appearance) {
        Intrinsics.f(subtitle, "subtitle");
        Intrinsics.f(image, "image");
        Intrinsics.f(appearance, "appearance");
        this.f41375f = str;
        this.f41376g = subtitle;
        this.f41377h = image;
        this.f41378i = z7;
        this.f41379j = appearance;
    }

    public final Appearance a() {
        return this.f41379j;
    }

    public final DriverImage b() {
        return this.f41377h;
    }

    public final boolean c() {
        return this.f41378i;
    }

    public final String d() {
        return this.f41376g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f41375f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverInfoBlock) {
            DriverInfoBlock driverInfoBlock = (DriverInfoBlock) obj;
            return Intrinsics.a(this.f41375f, driverInfoBlock.f41375f) && Intrinsics.a(this.f41376g, driverInfoBlock.f41376g) && Intrinsics.a(this.f41377h, driverInfoBlock.f41377h) && this.f41378i == driverInfoBlock.f41378i && this.f41379j == driverInfoBlock.f41379j;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f41375f;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.f41376g.hashCode()) * 31) + this.f41377h.hashCode()) * 31;
        boolean z7 = this.f41378i;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return ((hashCode + i8) * 31) + this.f41379j.hashCode();
    }

    public String toString() {
        String str = this.f41375f;
        String str2 = this.f41376g;
        DriverImage driverImage = this.f41377h;
        boolean z7 = this.f41378i;
        Appearance appearance = this.f41379j;
        return "DriverInfoBlock(title=" + str + ", subtitle=" + str2 + ", image=" + driverImage + ", showIcon=" + z7 + ", appearance=" + appearance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f41375f);
        out.writeString(this.f41376g);
        out.writeParcelable(this.f41377h, i8);
        out.writeInt(this.f41378i ? 1 : 0);
        out.writeString(this.f41379j.name());
    }
}
