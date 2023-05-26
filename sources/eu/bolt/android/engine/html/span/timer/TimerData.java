package eu.bolt.android.engine.html.span.timer;

import android.os.Parcel;
import android.os.Parcelable;
import i0.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: TimerData.kt */
/* loaded from: classes5.dex */
public final class TimerData implements Parcelable {
    public static final Parcelable.Creator<TimerData> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final long f36905f;

    /* renamed from: g  reason: collision with root package name */
    private final String f36906g;

    /* renamed from: h  reason: collision with root package name */
    private final TypeTimer f36907h;

    /* renamed from: i  reason: collision with root package name */
    private final String f36908i;

    /* renamed from: j  reason: collision with root package name */
    private final String f36909j;

    /* renamed from: k  reason: collision with root package name */
    private final String f36910k;

    /* renamed from: l  reason: collision with root package name */
    private final String f36911l;

    /* compiled from: TimerData.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TimerData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TimerData createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new TimerData(parcel.readLong(), parcel.readString(), TypeTimer.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final TimerData[] newArray(int i8) {
            return new TimerData[i8];
        }
    }

    /* compiled from: TimerData.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36912a;

        static {
            int[] iArr = new int[TypeTimer.values().length];
            iArr[TypeTimer.COUNT_DOWN.ordinal()] = 1;
            iArr[TypeTimer.COUNT_UP.ordinal()] = 2;
            f36912a = iArr;
        }
    }

    public TimerData(long j8, String format, TypeTimer type, String str, String str2, String str3, String str4) {
        Intrinsics.f(format, "format");
        Intrinsics.f(type, "type");
        this.f36905f = j8;
        this.f36906g = format;
        this.f36907h = type;
        this.f36908i = str;
        this.f36909j = str2;
        this.f36910k = str3;
        this.f36911l = str4;
    }

    public final String a() {
        return this.f36908i;
    }

    public final String b() {
        return this.f36906g;
    }

    public final String c() {
        return this.f36911l;
    }

    public final String d() {
        return this.f36910k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f36909j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimerData) {
            TimerData timerData = (TimerData) obj;
            return this.f36905f == timerData.f36905f && Intrinsics.a(this.f36906g, timerData.f36906g) && this.f36907h == timerData.f36907h && Intrinsics.a(this.f36908i, timerData.f36908i) && Intrinsics.a(this.f36909j, timerData.f36909j) && Intrinsics.a(this.f36910k, timerData.f36910k) && Intrinsics.a(this.f36911l, timerData.f36911l);
        }
        return false;
    }

    public final long f(long j8) {
        long e8;
        long e9;
        int i8 = WhenMappings.f36912a[this.f36907h.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                e9 = RangesKt___RangesKt.e(j8 - this.f36905f, 0L);
                return e9;
            }
            throw new NoWhenBranchMatchedException();
        }
        e8 = RangesKt___RangesKt.e(this.f36905f - j8, 0L);
        return e8;
    }

    public int hashCode() {
        int a8 = ((((a.a(this.f36905f) * 31) + this.f36906g.hashCode()) * 31) + this.f36907h.hashCode()) * 31;
        String str = this.f36908i;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f36909j;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f36910k;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f36911l;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f36905f;
        String str = this.f36906g;
        TypeTimer typeTimer = this.f36907h;
        String str2 = this.f36908i;
        String str3 = this.f36909j;
        String str4 = this.f36910k;
        String str5 = this.f36911l;
        return "TimerData(timestamp=" + j8 + ", format=" + str + ", type=" + typeTimer + ", countDownEndText=" + str2 + ", lessThanMinuteFormat=" + str3 + ", lessThanHourFormat=" + str4 + ", lessThanDayFormat=" + str5 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f36905f);
        out.writeString(this.f36906g);
        out.writeString(this.f36907h.name());
        out.writeString(this.f36908i);
        out.writeString(this.f36909j);
        out.writeString(this.f36910k);
        out.writeString(this.f36911l);
    }
}
