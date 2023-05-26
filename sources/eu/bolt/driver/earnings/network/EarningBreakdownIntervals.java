package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningBreakdownIntervals.kt */
/* loaded from: classes5.dex */
public final class EarningBreakdownIntervals {
    @SerializedName("modes")

    /* renamed from: a  reason: collision with root package name */
    private final List<Mode> f41414a;

    /* compiled from: EarningBreakdownIntervals.kt */
    /* loaded from: classes5.dex */
    public static final class Interval {
        @SerializedName("start_date")

        /* renamed from: a  reason: collision with root package name */
        private final long f41415a;
        @SerializedName("end_date")

        /* renamed from: b  reason: collision with root package name */
        private final long f41416b;
        @SerializedName("title")

        /* renamed from: c  reason: collision with root package name */
        private final String f41417c;
        @SerializedName("is_default")

        /* renamed from: d  reason: collision with root package name */
        private final boolean f41418d;

        public final long a() {
            return this.f41416b;
        }

        public final long b() {
            return this.f41415a;
        }

        public final String c() {
            return this.f41417c;
        }

        public final boolean d() {
            return this.f41418d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Interval) {
                Interval interval = (Interval) obj;
                return this.f41415a == interval.f41415a && this.f41416b == interval.f41416b && Intrinsics.a(this.f41417c, interval.f41417c) && this.f41418d == interval.f41418d;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a8 = ((((i0.a.a(this.f41415a) * 31) + i0.a.a(this.f41416b)) * 31) + this.f41417c.hashCode()) * 31;
            boolean z7 = this.f41418d;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return a8 + i8;
        }

        public String toString() {
            long j8 = this.f41415a;
            long j9 = this.f41416b;
            String str = this.f41417c;
            boolean z7 = this.f41418d;
            return "Interval(startDateUtcInSeconds=" + j8 + ", endDateUtcInSeconds=" + j9 + ", title=" + str + ", isDefault=" + z7 + ")";
        }
    }

    /* compiled from: EarningBreakdownIntervals.kt */
    /* loaded from: classes5.dex */
    public static final class Mode {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41419a;
        @SerializedName("intervals")

        /* renamed from: b  reason: collision with root package name */
        private final List<Interval> f41420b;
        @SerializedName("is_default")

        /* renamed from: c  reason: collision with root package name */
        private final boolean f41421c;

        public final List<Interval> a() {
            return this.f41420b;
        }

        public final String b() {
            return this.f41419a;
        }

        public final boolean c() {
            return this.f41421c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Mode) {
                Mode mode = (Mode) obj;
                return Intrinsics.a(this.f41419a, mode.f41419a) && Intrinsics.a(this.f41420b, mode.f41420b) && this.f41421c == mode.f41421c;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f41419a.hashCode() * 31) + this.f41420b.hashCode()) * 31;
            boolean z7 = this.f41421c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            String str = this.f41419a;
            List<Interval> list = this.f41420b;
            boolean z7 = this.f41421c;
            return "Mode(title=" + str + ", intervals=" + list + ", isDefault=" + z7 + ")";
        }
    }

    public final List<Mode> a() {
        return this.f41414a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EarningBreakdownIntervals) && Intrinsics.a(this.f41414a, ((EarningBreakdownIntervals) obj).f41414a);
    }

    public int hashCode() {
        return this.f41414a.hashCode();
    }

    public String toString() {
        List<Mode> list = this.f41414a;
        return "EarningBreakdownIntervals(modes=" + list + ")";
    }
}
