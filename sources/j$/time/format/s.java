package j$.time.format;

import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private DateTimeFormatter f50038a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f50039b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f50040c = true;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f50041d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f50041d = arrayList;
        this.f50038a = dateTimeFormatter;
        arrayList.add(new x());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(char c8, char c9) {
        return c8 == c9 || Character.toUpperCase(c8) == Character.toUpperCase(c9) || Character.toLowerCase(c8) == Character.toLowerCase(c9);
    }

    private x d() {
        ArrayList arrayList = this.f50041d;
        return (x) arrayList.get(arrayList.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(char c8, char c9) {
        return this.f50039b ? c8 == c9 : b(c8, c9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final s c() {
        s sVar = new s(this.f50038a);
        sVar.f50039b = this.f50039b;
        sVar.f50040c = this.f50040c;
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(boolean z7) {
        ArrayList arrayList;
        int size;
        if (z7) {
            arrayList = this.f50041d;
            size = arrayList.size() - 2;
        } else {
            arrayList = this.f50041d;
            size = arrayList.size() - 1;
        }
        arrayList.remove(size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w f() {
        return this.f50038a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$.time.chrono.e g() {
        j$.time.chrono.e eVar = d().f50054c;
        if (eVar == null) {
            j$.time.chrono.e b8 = this.f50038a.b();
            return b8 == null ? j$.time.chrono.f.f49977a : b8;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Locale h() {
        return this.f50038a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long i(j$.time.temporal.a aVar) {
        return (Long) d().f50052a.get(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j() {
        return this.f50039b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        return this.f50040c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(boolean z7) {
        this.f50039b = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(ZoneId zoneId) {
        if (zoneId == null) {
            throw new NullPointerException("zone");
        }
        d().f50053b = zoneId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int n(j$.time.temporal.o oVar, long j8, int i8, int i9) {
        if (oVar != null) {
            Long l8 = (Long) d().f50052a.put(oVar, Long.valueOf(j8));
            return (l8 == null || l8.longValue() == j8) ? i9 : ~i8;
        }
        throw new NullPointerException("field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o() {
        d().getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p(boolean z7) {
        this.f50040c = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q() {
        ArrayList arrayList = this.f50041d;
        x d8 = d();
        d8.getClass();
        x xVar = new x();
        xVar.f50052a.putAll(d8.f50052a);
        xVar.f50053b = d8.f50053b;
        xVar.f50054c = d8.f50054c;
        arrayList.add(xVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean r(CharSequence charSequence, int i8, CharSequence charSequence2, int i9, int i10) {
        if (i8 + i10 > charSequence.length() || i9 + i10 > charSequence2.length()) {
            return false;
        }
        if (this.f50039b) {
            for (int i11 = 0; i11 < i10; i11++) {
                if (charSequence.charAt(i8 + i11) != charSequence2.charAt(i9 + i11)) {
                    return false;
                }
            }
            return true;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            char charAt = charSequence.charAt(i8 + i12);
            char charAt2 = charSequence2.charAt(i9 + i12);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j$.time.temporal.l s(y yVar, Set set) {
        x d8 = d();
        d8.f50054c = g();
        ZoneId zoneId = d8.f50053b;
        if (zoneId == null) {
            zoneId = this.f50038a.e();
        }
        d8.f50053b = zoneId;
        d8.q(yVar, set);
        return d8;
    }

    public final String toString() {
        return d().toString();
    }
}
