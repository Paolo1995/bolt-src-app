package j$.time;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Duration f49956c = new Duration(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f49957a;

    /* renamed from: b  reason: collision with root package name */
    private final int f49958b;

    static {
        BigInteger.valueOf(1000000000L);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private Duration(long j8, int i8) {
        this.f49957a = j8;
        this.f49958b = i8;
    }

    private static Duration d(long j8, int i8) {
        return (((long) i8) | j8) == 0 ? f49956c : new Duration(j8, i8);
    }

    public static Duration g(long j8) {
        long j9 = j8 / 1000000000;
        int i8 = (int) (j8 % 1000000000);
        if (i8 < 0) {
            i8 = (int) (i8 + 1000000000);
            j9--;
        }
        return d(j9, i8);
    }

    public static Duration h() {
        return d(a.c(Long.MAX_VALUE, a.f(999999999L, 1000000000L)), (int) a.d(999999999L, 1000000000L));
    }

    public static Duration i(long j8) {
        return d(j8, 0);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int compare = Long.compare(this.f49957a, duration2.f49957a);
        return compare != 0 ? compare : this.f49958b - duration2.f49958b;
    }

    public final long e() {
        return this.f49957a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            return this.f49957a == duration.f49957a && this.f49958b == duration.f49958b;
        }
        return false;
    }

    public final int hashCode() {
        long j8 = this.f49957a;
        return (this.f49958b * 51) + ((int) (j8 ^ (j8 >>> 32)));
    }

    public long toMillis() {
        return a.c(a.e(this.f49957a, 1000L), this.f49958b / 1000000);
    }

    public final String toString() {
        if (this == f49956c) {
            return "PT0S";
        }
        long j8 = this.f49957a;
        long j9 = j8 / 3600;
        int i8 = (int) ((j8 % 3600) / 60);
        int i9 = (int) (j8 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j9 != 0) {
            sb.append(j9);
            sb.append('H');
        }
        if (i8 != 0) {
            sb.append(i8);
            sb.append('M');
        }
        if (i9 == 0 && this.f49958b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i9 >= 0 || this.f49958b <= 0) {
            sb.append(i9);
        } else if (i9 == -1) {
            sb.append("-0");
        } else {
            sb.append(i9 + 1);
        }
        if (this.f49958b > 0) {
            int length = sb.length();
            sb.append(i9 < 0 ? 2000000000 - this.f49958b : this.f49958b + 1000000000);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
