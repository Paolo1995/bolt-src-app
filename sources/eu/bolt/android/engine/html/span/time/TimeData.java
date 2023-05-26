package eu.bolt.android.engine.html.span.time;

import android.os.Parcel;
import android.os.Parcelable;
import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeData.kt */
/* loaded from: classes5.dex */
public final class TimeData implements Parcelable {
    public static final Parcelable.Creator<TimeData> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final long f36892f;

    /* renamed from: g  reason: collision with root package name */
    private final String f36893g;

    /* renamed from: h  reason: collision with root package name */
    private final String f36894h;

    /* compiled from: TimeData.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TimeData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TimeData createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new TimeData(parcel.readLong(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final TimeData[] newArray(int i8) {
            return new TimeData[i8];
        }
    }

    public TimeData(long j8, String format, String str) {
        Intrinsics.f(format, "format");
        this.f36892f = j8;
        this.f36893g = format;
        this.f36894h = str;
    }

    public final String a() {
        return this.f36894h;
    }

    public final String b() {
        return this.f36893g;
    }

    public final long c() {
        return this.f36892f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimeData) {
            TimeData timeData = (TimeData) obj;
            return this.f36892f == timeData.f36892f && Intrinsics.a(this.f36893g, timeData.f36893g) && Intrinsics.a(this.f36894h, timeData.f36894h);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((a.a(this.f36892f) * 31) + this.f36893g.hashCode()) * 31;
        String str = this.f36894h;
        return a8 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        long j8 = this.f36892f;
        String str = this.f36893g;
        String str2 = this.f36894h;
        return "TimeData(timestamp=" + j8 + ", format=" + str + ", amFormat=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f36892f);
        out.writeString(this.f36893g);
        out.writeString(this.f36894h);
    }
}
