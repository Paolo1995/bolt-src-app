package ee.mtakso.driver.uikit.utils;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
/* loaded from: classes5.dex */
public final class Padding implements Parcelable {
    public static final Parcelable.Creator<Padding> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final int f36052f;

    /* renamed from: g  reason: collision with root package name */
    private final int f36053g;

    /* renamed from: h  reason: collision with root package name */
    private final int f36054h;

    /* renamed from: i  reason: collision with root package name */
    private final int f36055i;

    /* compiled from: Padding.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<Padding> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final Padding createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new Padding(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final Padding[] newArray(int i8) {
            return new Padding[i8];
        }
    }

    public Padding() {
        this(0, 0, 0, 0, 15, null);
    }

    public Padding(int i8, int i9, int i10, int i11) {
        this.f36052f = i8;
        this.f36053g = i9;
        this.f36054h = i10;
        this.f36055i = i11;
    }

    public final int a() {
        return this.f36055i;
    }

    public final int b() {
        return this.f36052f;
    }

    public final int c() {
        return this.f36054h;
    }

    public final int d() {
        return this.f36053g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Padding) {
            Padding padding = (Padding) obj;
            return this.f36052f == padding.f36052f && this.f36053g == padding.f36053g && this.f36054h == padding.f36054h && this.f36055i == padding.f36055i;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f36052f * 31) + this.f36053g) * 31) + this.f36054h) * 31) + this.f36055i;
    }

    public String toString() {
        int i8 = this.f36052f;
        int i9 = this.f36053g;
        int i10 = this.f36054h;
        int i11 = this.f36055i;
        return "Padding(left=" + i8 + ", top=" + i9 + ", right=" + i10 + ", bottom=" + i11 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeInt(this.f36052f);
        out.writeInt(this.f36053g);
        out.writeInt(this.f36054h);
        out.writeInt(this.f36055i);
    }

    public /* synthetic */ Padding(int i8, int i9, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i8, (i12 & 2) != 0 ? 0 : i9, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
