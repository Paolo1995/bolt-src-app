package j$.time.zone;

import j$.time.Clock;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.g;
import j$.util.AbstractC0156n;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class ZoneRules implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    private static final long[] f50115i = new long[0];

    /* renamed from: j  reason: collision with root package name */
    private static final b[] f50116j = new b[0];

    /* renamed from: k  reason: collision with root package name */
    private static final LocalDateTime[] f50117k = new LocalDateTime[0];

    /* renamed from: l  reason: collision with root package name */
    private static final a[] f50118l = new a[0];

    /* renamed from: a  reason: collision with root package name */
    private final long[] f50119a;

    /* renamed from: b  reason: collision with root package name */
    private final ZoneOffset[] f50120b;

    /* renamed from: c  reason: collision with root package name */
    private final long[] f50121c;

    /* renamed from: d  reason: collision with root package name */
    private final LocalDateTime[] f50122d;

    /* renamed from: e  reason: collision with root package name */
    private final ZoneOffset[] f50123e;

    /* renamed from: f  reason: collision with root package name */
    private final b[] f50124f;

    /* renamed from: g  reason: collision with root package name */
    private final TimeZone f50125g;

    /* renamed from: h  reason: collision with root package name */
    private final transient ConcurrentHashMap f50126h = new ConcurrentHashMap();

    private ZoneRules(ZoneOffset zoneOffset) {
        this.f50120b = r0;
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        long[] jArr = f50115i;
        this.f50119a = jArr;
        this.f50121c = jArr;
        this.f50122d = f50117k;
        this.f50123e = zoneOffsetArr;
        this.f50124f = f50116j;
        this.f50125g = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRules(TimeZone timeZone) {
        this.f50120b = r0;
        ZoneOffset[] zoneOffsetArr = {i(timeZone.getRawOffset())};
        long[] jArr = f50115i;
        this.f50119a = jArr;
        this.f50121c = jArr;
        this.f50122d = f50117k;
        this.f50123e = zoneOffsetArr;
        this.f50124f = f50116j;
        this.f50125g = timeZone;
    }

    private static Object a(LocalDateTime localDateTime, a aVar) {
        LocalDateTime e8 = aVar.e();
        boolean k8 = aVar.k();
        boolean w7 = localDateTime.w(e8);
        return k8 ? w7 ? aVar.i() : localDateTime.w(aVar.d()) ? aVar : aVar.h() : !w7 ? aVar.h() : localDateTime.w(aVar.d()) ? aVar.i() : aVar;
    }

    private a[] b(int i8) {
        long j8;
        Integer valueOf = Integer.valueOf(i8);
        a[] aVarArr = (a[]) this.f50126h.get(valueOf);
        if (aVarArr != null) {
            return aVarArr;
        }
        if (this.f50125g == null) {
            b[] bVarArr = this.f50124f;
            a[] aVarArr2 = new a[bVarArr.length];
            if (bVarArr.length > 0) {
                b bVar = bVarArr[0];
                throw null;
            }
            if (i8 < 2100) {
                this.f50126h.putIfAbsent(valueOf, aVarArr2);
            }
            return aVarArr2;
        } else if (i8 < 1800) {
            return f50118l;
        } else {
            long F = LocalDateTime.x(i8 - 1).F(this.f50120b[0]);
            int offset = this.f50125g.getOffset(F * 1000);
            long j9 = 31968000 + F;
            a[] aVarArr3 = f50118l;
            while (F < j9) {
                long j10 = 7776000 + F;
                long j11 = F;
                if (offset != this.f50125g.getOffset(j10 * 1000)) {
                    F = j11;
                    while (j10 - F > 1) {
                        int i9 = offset;
                        long f8 = j$.time.a.f(j10 + F, 2L);
                        long j12 = j9;
                        if (this.f50125g.getOffset(f8 * 1000) == i9) {
                            F = f8;
                        } else {
                            j10 = f8;
                        }
                        offset = i9;
                        j9 = j12;
                    }
                    j8 = j9;
                    int i10 = offset;
                    if (this.f50125g.getOffset(F * 1000) == i10) {
                        F = j10;
                    }
                    ZoneOffset i11 = i(i10);
                    offset = this.f50125g.getOffset(F * 1000);
                    ZoneOffset i12 = i(offset);
                    if (c(F, i12) == i8) {
                        a[] aVarArr4 = (a[]) Arrays.copyOf(aVarArr3, aVarArr3.length + 1);
                        aVarArr4[aVarArr4.length - 1] = new a(F, i11, i12);
                        aVarArr3 = aVarArr4;
                    }
                } else {
                    j8 = j9;
                    F = j10;
                }
                j9 = j8;
            }
            if (1916 <= i8 && i8 < 2100) {
                this.f50126h.putIfAbsent(valueOf, aVarArr3);
            }
            return aVarArr3;
        }
    }

    private static int c(long j8, ZoneOffset zoneOffset) {
        return g.z(j$.time.a.f(j8 + zoneOffset.s(), 86400L)).w();
    }

    private Object e(LocalDateTime localDateTime) {
        LocalDateTime[] localDateTimeArr;
        Object obj = null;
        int i8 = 0;
        if (this.f50125g != null) {
            a[] b8 = b(localDateTime.u());
            if (b8.length == 0) {
                return i(this.f50125g.getOffset(localDateTime.F(this.f50120b[0]) * 1000));
            }
            int length = b8.length;
            while (i8 < length) {
                a aVar = b8[i8];
                Object a8 = a(localDateTime, aVar);
                if ((a8 instanceof a) || a8.equals(aVar.i())) {
                    return a8;
                }
                i8++;
                obj = a8;
            }
            return obj;
        } else if (this.f50121c.length == 0) {
            return this.f50120b[0];
        } else {
            if (this.f50124f.length > 0) {
                if (localDateTime.v(this.f50122d[localDateTimeArr.length - 1])) {
                    a[] b9 = b(localDateTime.u());
                    int length2 = b9.length;
                    while (i8 < length2) {
                        a aVar2 = b9[i8];
                        Object a9 = a(localDateTime, aVar2);
                        if ((a9 instanceof a) || a9.equals(aVar2.i())) {
                            return a9;
                        }
                        i8++;
                        obj = a9;
                    }
                    return obj;
                }
            }
            int binarySearch = Arrays.binarySearch(this.f50122d, localDateTime);
            if (binarySearch == -1) {
                return this.f50123e[0];
            }
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            } else {
                LocalDateTime[] localDateTimeArr2 = this.f50122d;
                if (binarySearch < localDateTimeArr2.length - 1) {
                    int i9 = binarySearch + 1;
                    if (localDateTimeArr2[binarySearch].equals(localDateTimeArr2[i9])) {
                        binarySearch = i9;
                    }
                }
            }
            if ((binarySearch & 1) == 0) {
                LocalDateTime[] localDateTimeArr3 = this.f50122d;
                LocalDateTime localDateTime2 = localDateTimeArr3[binarySearch];
                LocalDateTime localDateTime3 = localDateTimeArr3[binarySearch + 1];
                ZoneOffset[] zoneOffsetArr = this.f50123e;
                int i10 = binarySearch / 2;
                ZoneOffset zoneOffset = zoneOffsetArr[i10];
                ZoneOffset zoneOffset2 = zoneOffsetArr[i10 + 1];
                return zoneOffset2.s() > zoneOffset.s() ? new a(localDateTime2, zoneOffset, zoneOffset2) : new a(localDateTime3, zoneOffset, zoneOffset2);
            }
            return this.f50123e[(binarySearch / 2) + 1];
        }
    }

    public static ZoneRules h(ZoneOffset zoneOffset) {
        if (zoneOffset != null) {
            return new ZoneRules(zoneOffset);
        }
        throw new NullPointerException("offset");
    }

    private static ZoneOffset i(int i8) {
        return ZoneOffset.u(i8 / 1000);
    }

    public final ZoneOffset d(Instant instant) {
        long[] jArr;
        ZoneOffset[] zoneOffsetArr;
        TimeZone timeZone = this.f50125g;
        if (timeZone != null) {
            return i(timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.f50121c.length == 0) {
            return this.f50120b[0];
        }
        long s7 = instant.s();
        if (this.f50124f.length > 0) {
            if (s7 > this.f50121c[jArr.length - 1]) {
                a[] b8 = b(c(s7, this.f50123e[zoneOffsetArr.length - 1]));
                a aVar = null;
                for (int i8 = 0; i8 < b8.length; i8++) {
                    aVar = b8[i8];
                    if (s7 < aVar.p()) {
                        return aVar.i();
                    }
                }
                return aVar.h();
            }
        }
        int binarySearch = Arrays.binarySearch(this.f50121c, s7);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f50123e[binarySearch + 1];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneRules) {
            ZoneRules zoneRules = (ZoneRules) obj;
            return AbstractC0156n.l(this.f50125g, zoneRules.f50125g) && Arrays.equals(this.f50119a, zoneRules.f50119a) && Arrays.equals(this.f50120b, zoneRules.f50120b) && Arrays.equals(this.f50121c, zoneRules.f50121c) && Arrays.equals(this.f50123e, zoneRules.f50123e) && Arrays.equals(this.f50124f, zoneRules.f50124f);
        }
        return false;
    }

    public final a f(LocalDateTime localDateTime) {
        Object e8 = e(localDateTime);
        if (e8 instanceof a) {
            return (a) e8;
        }
        return null;
    }

    public final List g(LocalDateTime localDateTime) {
        Object e8 = e(localDateTime);
        return e8 instanceof a ? ((a) e8).j() : Collections.singletonList((ZoneOffset) e8);
    }

    public final int hashCode() {
        TimeZone timeZone = this.f50125g;
        return (((((timeZone != null ? timeZone.hashCode() : 0) ^ Arrays.hashCode(this.f50119a)) ^ Arrays.hashCode(this.f50120b)) ^ Arrays.hashCode(this.f50121c)) ^ Arrays.hashCode(this.f50123e)) ^ Arrays.hashCode(this.f50124f);
    }

    public boolean isFixedOffset() {
        TimeZone timeZone = this.f50125g;
        if (timeZone == null) {
            return this.f50121c.length == 0;
        }
        if (!timeZone.useDaylightTime() && this.f50125g.getDSTSavings() == 0) {
            Instant instant = Instant.EPOCH;
            Instant instant2 = Clock.systemUTC().instant();
            a aVar = null;
            if (this.f50125g != null) {
                long s7 = instant2.s();
                if (instant2.t() > 0 && s7 < Long.MAX_VALUE) {
                    s7++;
                }
                int c8 = c(s7, d(instant2));
                a[] b8 = b(c8);
                int length = b8.length - 1;
                while (true) {
                    if (length >= 0) {
                        if (s7 > b8[length].p()) {
                            aVar = b8[length];
                            break;
                        }
                        length--;
                    } else if (c8 > 1800) {
                        a[] b9 = b(c8 - 1);
                        int length2 = b9.length - 1;
                        while (true) {
                            if (length2 < 0) {
                                long min = Math.min(s7 - 31104000, (Clock.systemUTC().a() / 1000) + 31968000);
                                int offset = this.f50125g.getOffset((s7 - 1) * 1000);
                                long H = g.y(1800, 1, 1).H() * 86400;
                                while (true) {
                                    if (H > min) {
                                        break;
                                    }
                                    int offset2 = this.f50125g.getOffset(min * 1000);
                                    if (offset != offset2) {
                                        int c9 = c(min, i(offset2));
                                        a[] b10 = b(c9 + 1);
                                        int length3 = b10.length - 1;
                                        while (true) {
                                            if (length3 < 0) {
                                                a[] b11 = b(c9);
                                                aVar = b11[b11.length - 1];
                                                break;
                                            } else if (s7 > b10[length3].p()) {
                                                aVar = b10[length3];
                                                break;
                                            } else {
                                                length3--;
                                            }
                                        }
                                    } else {
                                        min -= 7776000;
                                    }
                                }
                            } else if (s7 > b9[length2].p()) {
                                aVar = b9[length2];
                                break;
                            } else {
                                length2--;
                            }
                        }
                    }
                }
            } else if (this.f50121c.length != 0) {
                long s8 = instant2.s();
                if (instant2.t() > 0 && s8 < Long.MAX_VALUE) {
                    s8++;
                }
                long[] jArr = this.f50121c;
                long j8 = jArr[jArr.length - 1];
                if (this.f50124f.length > 0 && s8 > j8) {
                    ZoneOffset[] zoneOffsetArr = this.f50123e;
                    ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
                    int c10 = c(s8, zoneOffset);
                    a[] b12 = b(c10);
                    int length4 = b12.length - 1;
                    while (true) {
                        if (length4 < 0) {
                            int i8 = c10 - 1;
                            if (i8 > c(j8, zoneOffset)) {
                                a[] b13 = b(i8);
                                aVar = b13[b13.length - 1];
                            }
                        } else if (s8 > b12[length4].p()) {
                            aVar = b12[length4];
                            break;
                        } else {
                            length4--;
                        }
                    }
                }
                int binarySearch = Arrays.binarySearch(this.f50121c, s8);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                if (binarySearch > 0) {
                    int i9 = binarySearch - 1;
                    long j9 = this.f50121c[i9];
                    ZoneOffset[] zoneOffsetArr2 = this.f50123e;
                    aVar = new a(j9, zoneOffsetArr2[i9], zoneOffsetArr2[binarySearch]);
                }
            }
            if (aVar == null) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder a8;
        if (this.f50125g != null) {
            a8 = j$.time.b.a("ZoneRules[timeZone=");
            a8.append(this.f50125g.getID());
        } else {
            a8 = j$.time.b.a("ZoneRules[currentStandardOffset=");
            ZoneOffset[] zoneOffsetArr = this.f50120b;
            a8.append(zoneOffsetArr[zoneOffsetArr.length - 1]);
        }
        a8.append("]");
        return a8.toString();
    }
}
