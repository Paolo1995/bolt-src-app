package j$.time.format;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_LOCAL_DATE;

    /* renamed from: h  reason: collision with root package name */
    public static final DateTimeFormatter f49985h;

    /* renamed from: i  reason: collision with root package name */
    public static final DateTimeFormatter f49986i;

    /* renamed from: j  reason: collision with root package name */
    public static final DateTimeFormatter f49987j;

    /* renamed from: a  reason: collision with root package name */
    private final f f49988a;

    /* renamed from: b  reason: collision with root package name */
    private final Locale f49989b;

    /* renamed from: c  reason: collision with root package name */
    private final w f49990c;

    /* renamed from: d  reason: collision with root package name */
    private final y f49991d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f49992e;

    /* renamed from: f  reason: collision with root package name */
    private final j$.time.chrono.e f49993f;

    /* renamed from: g  reason: collision with root package name */
    private final ZoneId f49994g;

    static {
        r rVar = new r();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        rVar.l(aVar, 4, 10, 5);
        rVar.e('-');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        rVar.k(aVar2, 2);
        rVar.e('-');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        rVar.k(aVar3, 2);
        y yVar = y.STRICT;
        j$.time.chrono.f fVar = j$.time.chrono.f.f49977a;
        DateTimeFormatter t7 = rVar.t(yVar, fVar);
        ISO_LOCAL_DATE = t7;
        r rVar2 = new r();
        rVar2.p();
        rVar2.a(t7);
        rVar2.h();
        rVar2.t(yVar, fVar);
        r rVar3 = new r();
        rVar3.p();
        rVar3.a(t7);
        rVar3.o();
        rVar3.h();
        rVar3.t(yVar, fVar);
        r rVar4 = new r();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        rVar4.k(aVar4, 2);
        rVar4.e(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        rVar4.k(aVar5, 2);
        rVar4.o();
        rVar4.e(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        rVar4.k(aVar6, 2);
        rVar4.o();
        rVar4.b(j$.time.temporal.a.NANO_OF_SECOND);
        DateTimeFormatter t8 = rVar4.t(yVar, null);
        r rVar5 = new r();
        rVar5.p();
        rVar5.a(t8);
        rVar5.h();
        rVar5.t(yVar, null);
        r rVar6 = new r();
        rVar6.p();
        rVar6.a(t8);
        rVar6.o();
        rVar6.h();
        rVar6.t(yVar, null);
        r rVar7 = new r();
        rVar7.p();
        rVar7.a(t7);
        rVar7.e('T');
        rVar7.a(t8);
        DateTimeFormatter t9 = rVar7.t(yVar, fVar);
        f49985h = t9;
        r rVar8 = new r();
        rVar8.p();
        rVar8.a(t9);
        rVar8.h();
        DateTimeFormatter t10 = rVar8.t(yVar, fVar);
        f49986i = t10;
        r rVar9 = new r();
        rVar9.a(t10);
        rVar9.o();
        rVar9.e('[');
        rVar9.q();
        rVar9.m();
        rVar9.e(']');
        rVar9.t(yVar, fVar);
        r rVar10 = new r();
        rVar10.a(t9);
        rVar10.o();
        rVar10.h();
        rVar10.o();
        rVar10.e('[');
        rVar10.q();
        rVar10.m();
        rVar10.e(']');
        rVar10.t(yVar, fVar);
        r rVar11 = new r();
        rVar11.p();
        rVar11.l(aVar, 4, 10, 5);
        rVar11.e('-');
        rVar11.k(j$.time.temporal.a.DAY_OF_YEAR, 3);
        rVar11.o();
        rVar11.h();
        rVar11.t(yVar, fVar);
        r rVar12 = new r();
        rVar12.p();
        rVar12.l(j$.time.temporal.j.f50102c, 4, 10, 5);
        rVar12.f("-W");
        rVar12.k(j$.time.temporal.j.f50101b, 2);
        rVar12.e('-');
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        rVar12.k(aVar7, 1);
        rVar12.o();
        rVar12.h();
        rVar12.t(yVar, fVar);
        r rVar13 = new r();
        rVar13.p();
        rVar13.c();
        f49987j = rVar13.t(yVar, null);
        r rVar14 = new r();
        rVar14.p();
        rVar14.k(aVar, 4);
        rVar14.k(aVar2, 2);
        rVar14.k(aVar3, 2);
        rVar14.o();
        rVar14.g("+HHMMss", "Z");
        rVar14.t(yVar, fVar);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        r rVar15 = new r();
        rVar15.p();
        rVar15.r();
        rVar15.o();
        rVar15.i(aVar7, hashMap);
        rVar15.f(", ");
        rVar15.n();
        rVar15.l(aVar3, 1, 2, 4);
        rVar15.e(' ');
        rVar15.i(aVar2, hashMap2);
        rVar15.e(' ');
        rVar15.k(aVar, 4);
        rVar15.e(' ');
        rVar15.k(aVar4, 2);
        rVar15.e(':');
        rVar15.k(aVar5, 2);
        rVar15.o();
        rVar15.e(':');
        rVar15.k(aVar6, 2);
        rVar15.n();
        rVar15.e(' ');
        rVar15.g("+HHMM", "GMT");
        rVar15.t(y.SMART, fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeFormatter(f fVar, Locale locale, y yVar, j$.time.chrono.f fVar2) {
        w wVar = w.f50051a;
        this.f49988a = fVar;
        this.f49992e = null;
        if (locale == null) {
            throw new NullPointerException("locale");
        }
        this.f49989b = locale;
        this.f49990c = wVar;
        if (yVar == null) {
            throw new NullPointerException("resolverStyle");
        }
        this.f49991d = yVar;
        this.f49993f = fVar2;
        this.f49994g = null;
    }

    private j$.time.temporal.l g(CharSequence charSequence) {
        String charSequence2;
        ParsePosition parsePosition = new ParsePosition(0);
        if (charSequence != null) {
            s sVar = new s(this);
            int e8 = this.f49988a.e(sVar, charSequence, parsePosition.getIndex());
            if (e8 < 0) {
                parsePosition.setErrorIndex(~e8);
                sVar = null;
            } else {
                parsePosition.setIndex(e8);
            }
            if (sVar == null || parsePosition.getErrorIndex() >= 0 || parsePosition.getIndex() < charSequence.length()) {
                if (charSequence.length() > 64) {
                    charSequence2 = charSequence.subSequence(0, 64).toString() + "...";
                } else {
                    charSequence2 = charSequence.toString();
                }
                if (parsePosition.getErrorIndex() >= 0) {
                    String str = "Text '" + charSequence2 + "' could not be parsed at index " + parsePosition.getErrorIndex();
                    parsePosition.getErrorIndex();
                    throw new DateTimeParseException(str, charSequence);
                }
                String str2 = "Text '" + charSequence2 + "' could not be parsed, unparsed text found at index " + parsePosition.getIndex();
                parsePosition.getIndex();
                throw new DateTimeParseException(str2, charSequence);
            }
            return sVar.s(this.f49991d, this.f49992e);
        }
        throw new NullPointerException("text");
    }

    public final String a(j$.time.temporal.l lVar) {
        StringBuilder sb = new StringBuilder(32);
        if (lVar != null) {
            try {
                this.f49988a.d(new u(lVar, this), sb);
                return sb.toString();
            } catch (IOException e8) {
                throw new DateTimeException(e8.getMessage(), e8);
            }
        }
        throw new NullPointerException("temporal");
    }

    public final j$.time.chrono.e b() {
        return this.f49993f;
    }

    public final w c() {
        return this.f49990c;
    }

    public final Locale d() {
        return this.f49989b;
    }

    public final ZoneId e() {
        return this.f49994g;
    }

    public final Object f(CharSequence charSequence, j$.time.h hVar) {
        String charSequence2;
        if (charSequence != null) {
            try {
                return ((x) g(charSequence)).o(hVar);
            } catch (DateTimeParseException e8) {
                throw e8;
            } catch (RuntimeException e9) {
                if (charSequence.length() > 64) {
                    charSequence2 = charSequence.subSequence(0, 64).toString() + "...";
                } else {
                    charSequence2 = charSequence.toString();
                }
                throw new DateTimeParseException("Text '" + charSequence2 + "' could not be parsed: " + e9.getMessage(), charSequence, e9);
            }
        }
        throw new NullPointerException("text");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f h() {
        return this.f49988a.a();
    }

    public final String toString() {
        String fVar = this.f49988a.toString();
        return fVar.startsWith("[") ? fVar : fVar.substring(1, fVar.length() - 1);
    }
}
