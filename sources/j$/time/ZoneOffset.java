package j$.time;

import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.zone.ZoneRules;
import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class ZoneOffset extends ZoneId implements j$.time.temporal.l, j$.time.temporal.m, Comparable<ZoneOffset> {

    /* renamed from: b  reason: collision with root package name */
    private final int f49970b;

    /* renamed from: c  reason: collision with root package name */
    private final transient String f49971c;

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap f49966d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap f49967e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = u(0);

    /* renamed from: f  reason: collision with root package name */
    public static final ZoneOffset f49968f = u(-64800);

    /* renamed from: g  reason: collision with root package name */
    public static final ZoneOffset f49969g = u(64800);

    private ZoneOffset(int i8) {
        String sb;
        this.f49970b = i8;
        if (i8 == 0) {
            sb = "Z";
        } else {
            int abs = Math.abs(i8);
            StringBuilder sb2 = new StringBuilder();
            int i9 = abs / 3600;
            int i10 = (abs / 60) % 60;
            sb2.append(i8 < 0 ? "-" : "+");
            sb2.append(i9 < 10 ? "0" : "");
            sb2.append(i9);
            sb2.append(i10 < 10 ? ":0" : ":");
            sb2.append(i10);
            int i11 = abs % 60;
            if (i11 != 0) {
                sb2.append(i11 >= 10 ? ":" : ":0");
                sb2.append(i11);
            }
            sb = sb2.toString();
        }
        this.f49971c = sb;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static j$.time.ZoneOffset of(java.lang.String r7) {
        /*
            if (r7 == 0) goto Lbf
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.ZoneOffset.f49967e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto Ld
            return r0
        Ld:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L6a
            r1 = 3
            if (r0 == r1) goto L86
            r4 = 5
            if (r0 == r4) goto L61
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L58
            r5 = 7
            if (r0 == r5) goto L4b
            r1 = 9
            if (r0 != r1) goto L34
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r6, r2)
            int r2 = v(r7, r5, r2)
            goto L8c
        L34:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L4b:
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r1, r3)
            int r2 = v(r7, r4, r3)
            goto L8c
        L58:
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r6, r2)
            goto L8b
        L61:
            int r0 = v(r7, r2, r3)
            int r1 = v(r7, r1, r3)
            goto L8b
        L6a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L86:
            int r0 = v(r7, r2, r3)
            r1 = 0
        L8b:
            r2 = 0
        L8c:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto Lb0
            if (r3 != r5) goto L99
            goto Lb0
        L99:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        Lb0:
            if (r3 != r5) goto Lba
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = t(r7, r0, r1)
            return r7
        Lba:
            j$.time.ZoneOffset r7 = t(r0, r1, r2)
            return r7
        Lbf:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "offsetId"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.of(java.lang.String):j$.time.ZoneOffset");
    }

    public static ZoneOffset r(j$.time.temporal.l lVar) {
        if (lVar != null) {
            ZoneOffset zoneOffset = (ZoneOffset) lVar.o(j$.time.temporal.n.g());
            if (zoneOffset != null) {
                return zoneOffset;
            }
            throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + lVar + " of type " + lVar.getClass().getName());
        }
        throw new NullPointerException("temporal");
    }

    public static ZoneOffset t(int i8, int i9, int i10) {
        if (i8 < -18 || i8 > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i8 + " is not in the range -18 to 18");
        }
        if (i8 > 0) {
            if (i9 < 0 || i10 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i8 < 0) {
            if (i9 > 0 || i10 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i9 > 0 && i10 < 0) || (i9 < 0 && i10 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i9 < -59 || i9 > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: value " + i9 + " is not in the range -59 to 59");
        } else if (i10 < -59 || i10 > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: value " + i10 + " is not in the range -59 to 59");
        } else if (Math.abs(i8) != 18 || (i9 | i10) == 0) {
            return u((i9 * 60) + (i8 * 3600) + i10);
        } else {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset u(int i8) {
        if (i8 < -64800 || i8 > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i8 % 900 == 0) {
            Integer valueOf = Integer.valueOf(i8);
            ConcurrentHashMap concurrentHashMap = f49966d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(valueOf);
            if (zoneOffset == null) {
                concurrentHashMap.putIfAbsent(valueOf, new ZoneOffset(i8));
                ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(valueOf);
                f49967e.putIfAbsent(zoneOffset2.f49971c, zoneOffset2);
                return zoneOffset2;
            }
            return zoneOffset;
        }
        return new ZoneOffset(i8);
    }

    private static int v(CharSequence charSequence, int i8, boolean z7) {
        if (z7 && charSequence.charAt(i8 - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char charAt = charSequence.charAt(i8);
        char charAt2 = charSequence.charAt(i8 + 1);
        if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f49970b - this.f49970b;
    }

    @Override // j$.time.temporal.l
    public final int e(j$.time.temporal.o oVar) {
        if (oVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f49970b;
        }
        if (oVar instanceof j$.time.temporal.a) {
            throw new s("Unsupported field: " + oVar);
        }
        return j$.time.temporal.n.c(this, oVar).a(n(oVar), oVar);
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f49970b == ((ZoneOffset) obj).f49970b;
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f49971c;
    }

    @Override // j$.time.ZoneId
    public final ZoneRules getRules() {
        return ZoneRules.h(this);
    }

    @Override // j$.time.temporal.l
    public final t h(j$.time.temporal.o oVar) {
        return j$.time.temporal.n.c(this, oVar);
    }

    @Override // j$.time.ZoneId
    public int hashCode() {
        return this.f49970b;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.k j(j$.time.temporal.k kVar) {
        return kVar.d(this.f49970b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return oVar instanceof j$.time.temporal.a ? oVar == j$.time.temporal.a.OFFSET_SECONDS : oVar != null && oVar.d(this);
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        if (oVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f49970b;
        }
        if (oVar instanceof j$.time.temporal.a) {
            throw new s("Unsupported field: " + oVar);
        }
        return oVar.i(this);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        return (qVar == j$.time.temporal.n.g() || qVar == j$.time.temporal.n.i()) ? this : j$.time.temporal.n.b(this, qVar);
    }

    public final int s() {
        return this.f49970b;
    }

    @Override // j$.time.ZoneId
    public String toString() {
        return this.f49971c;
    }
}
