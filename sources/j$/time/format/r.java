package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: f  reason: collision with root package name */
    private static final C0105a f50031f = new j$.time.temporal.q() { // from class: j$.time.format.a
        @Override // j$.time.temporal.q
        public final Object c(j$.time.temporal.l lVar) {
            int i8 = r.f50032g;
            ZoneId zoneId = (ZoneId) lVar.o(j$.time.temporal.n.j());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f50032g = 0;

    /* renamed from: a  reason: collision with root package name */
    private r f50033a;

    /* renamed from: b  reason: collision with root package name */
    private final r f50034b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f50035c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f50036d;

    /* renamed from: e  reason: collision with root package name */
    private int f50037e;

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.format.a] */
    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', j$.time.temporal.a.ERA);
        hashMap.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        hashMap.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.o oVar = j$.time.temporal.j.f50100a;
        hashMap.put('Q', oVar);
        hashMap.put('q', oVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        hashMap.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        hashMap.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        hashMap.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        hashMap.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        hashMap.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        hashMap.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', j$.time.temporal.a.NANO_OF_DAY);
    }

    public r() {
        this.f50033a = this;
        this.f50035c = new ArrayList();
        this.f50037e = -1;
        this.f50034b = null;
        this.f50036d = false;
    }

    private r(r rVar) {
        this.f50033a = this;
        this.f50035c = new ArrayList();
        this.f50037e = -1;
        this.f50034b = rVar;
        this.f50036d = true;
    }

    private int d(g gVar) {
        if (gVar != null) {
            r rVar = this.f50033a;
            rVar.getClass();
            rVar.f50035c.add(gVar);
            r rVar2 = this.f50033a;
            rVar2.f50037e = -1;
            return rVar2.f50035c.size() - 1;
        }
        throw new NullPointerException("pp");
    }

    private void j(j jVar) {
        j b8;
        int i8;
        r rVar = this.f50033a;
        int i9 = rVar.f50037e;
        if (i9 < 0) {
            rVar.f50037e = d(jVar);
            return;
        }
        j jVar2 = (j) rVar.f50035c.get(i9);
        if (jVar.f50008b == jVar.f50009c) {
            i8 = jVar.f50010d;
            if (i8 == 4) {
                b8 = jVar2.c(jVar.f50009c);
                d(jVar.b());
                this.f50033a.f50037e = i9;
                this.f50033a.f50035c.set(i9, b8);
            }
        }
        b8 = jVar2.b();
        this.f50033a.f50037e = d(jVar);
        this.f50033a.f50035c.set(i9, b8);
    }

    private DateTimeFormatter u(Locale locale, y yVar, j$.time.chrono.f fVar) {
        if (locale != null) {
            while (this.f50033a.f50034b != null) {
                n();
            }
            f fVar2 = new f(this.f50035c, false);
            w wVar = w.f50051a;
            return new DateTimeFormatter(fVar2, locale, yVar, fVar);
        }
        throw new NullPointerException("locale");
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            throw new NullPointerException("formatter");
        }
        d(dateTimeFormatter.h());
    }

    public final void b(j$.time.temporal.a aVar) {
        d(new h(aVar));
    }

    public final void c() {
        d(new i());
    }

    public final void e(char c8) {
        d(new e(c8));
    }

    public final void f(String str) {
        if (str.length() > 0) {
            d(str.length() == 1 ? new e(str.charAt(0)) : new o(str));
        }
    }

    public final void g(String str, String str2) {
        d(new k(str, str2));
    }

    public final void h() {
        d(k.f50013d);
    }

    public final void i(j$.time.temporal.a aVar, HashMap hashMap) {
        if (aVar == null) {
            throw new NullPointerException("field");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(hashMap);
        A a8 = A.FULL;
        d(new p(aVar, a8, new b(new v(Collections.singletonMap(a8, linkedHashMap)))));
    }

    public final void k(j$.time.temporal.o oVar, int i8) {
        if (oVar == null) {
            throw new NullPointerException("field");
        }
        if (i8 >= 1 && i8 <= 19) {
            j(new j(oVar, i8, i8, 4));
            return;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i8);
    }

    public final r l(j$.time.temporal.o oVar, int i8, int i9, int i10) {
        if (i8 == i9 && i10 == 4) {
            k(oVar, i9);
            return this;
        } else if (oVar != null) {
            if (i10 != 0) {
                if (i8 < 1 || i8 > 19) {
                    throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i8);
                } else if (i9 < 1 || i9 > 19) {
                    throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i9);
                } else if (i9 >= i8) {
                    j(new j(oVar, i8, i9, i10));
                    return this;
                } else {
                    throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i9 + " < " + i8);
                }
            }
            throw new NullPointerException("signStyle");
        } else {
            throw new NullPointerException("field");
        }
    }

    public final void m() {
        d(new q(f50031f));
    }

    public final void n() {
        r rVar = this.f50033a;
        if (rVar.f50034b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (rVar.f50035c.size() <= 0) {
            this.f50033a = this.f50033a.f50034b;
            return;
        }
        r rVar2 = this.f50033a;
        f fVar = new f(rVar2.f50035c, rVar2.f50036d);
        this.f50033a = this.f50033a.f50034b;
        d(fVar);
    }

    public final void o() {
        r rVar = this.f50033a;
        rVar.f50037e = -1;
        this.f50033a = new r(rVar);
    }

    public final void p() {
        d(n.INSENSITIVE);
    }

    public final void q() {
        d(n.SENSITIVE);
    }

    public final void r() {
        d(n.LENIENT);
    }

    public final DateTimeFormatter s() {
        return u(Locale.getDefault(), y.SMART, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DateTimeFormatter t(y yVar, j$.time.chrono.f fVar) {
        return u(Locale.getDefault(), yVar, fVar);
    }
}
