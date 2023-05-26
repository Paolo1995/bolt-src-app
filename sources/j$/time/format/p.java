package j$.time.format;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p implements g {

    /* renamed from: a  reason: collision with root package name */
    private final j$.time.temporal.o f50024a;

    /* renamed from: b  reason: collision with root package name */
    private final A f50025b;

    /* renamed from: c  reason: collision with root package name */
    private final b f50026c;

    /* renamed from: d  reason: collision with root package name */
    private volatile j f50027d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j$.time.temporal.a aVar, A a8, b bVar) {
        this.f50024a = aVar;
        this.f50025b = a8;
        this.f50026c = bVar;
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        String a8;
        j$.time.chrono.f fVar;
        Long e8 = uVar.e(this.f50024a);
        if (e8 == null) {
            return false;
        }
        j$.time.chrono.e eVar = (j$.time.chrono.e) uVar.d().o(j$.time.temporal.n.d());
        if (eVar == null || eVar == (fVar = j$.time.chrono.f.f49977a)) {
            b bVar = this.f50026c;
            long longValue = e8.longValue();
            A a9 = this.f50025b;
            uVar.c();
            a8 = bVar.f49997a.a(longValue, a9);
        } else {
            b bVar2 = this.f50026c;
            j$.time.temporal.o oVar = this.f50024a;
            long longValue2 = e8.longValue();
            A a10 = this.f50025b;
            uVar.c();
            bVar2.getClass();
            a8 = (eVar == fVar || !(oVar instanceof j$.time.temporal.a)) ? bVar2.f49997a.a(longValue2, a10) : null;
        }
        if (a8 != null) {
            sb.append(a8);
            return true;
        }
        if (this.f50027d == null) {
            this.f50027d = new j(this.f50024a, 1, 19, 1);
        }
        return this.f50027d.d(uVar, sb);
    }

    @Override // j$.time.format.g
    public final int e(s sVar, CharSequence charSequence, int i8) {
        j$.time.chrono.e eVar;
        int length = charSequence.length();
        if (i8 < 0 || i8 > length) {
            throw new IndexOutOfBoundsException();
        }
        Iterator it = null;
        A a8 = sVar.k() ? this.f50025b : null;
        j$.time.chrono.e g8 = sVar.g();
        if (g8 == null || g8 == (eVar = j$.time.chrono.f.f49977a)) {
            b bVar = this.f50026c;
            sVar.h();
            it = bVar.f49997a.b(a8);
        } else {
            b bVar2 = this.f50026c;
            j$.time.temporal.o oVar = this.f50024a;
            sVar.h();
            bVar2.getClass();
            if (g8 == eVar || !(oVar instanceof j$.time.temporal.a)) {
                it = bVar2.f49997a.b(a8);
            }
        }
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                if (sVar.r(str, 0, charSequence, i8, str.length())) {
                    return sVar.n(this.f50024a, ((Long) entry.getValue()).longValue(), i8, str.length() + i8);
                }
            }
            if (sVar.k()) {
                return ~i8;
            }
        }
        if (this.f50027d == null) {
            this.f50027d = new j(this.f50024a, 1, 19, 1);
        }
        return this.f50027d.e(sVar, charSequence, i8);
    }

    public final String toString() {
        StringBuilder a8;
        Object obj;
        if (this.f50025b == A.FULL) {
            a8 = j$.time.b.a("Text(");
            obj = this.f50024a;
        } else {
            a8 = j$.time.b.a("Text(");
            a8.append(this.f50024a);
            a8.append(",");
            obj = this.f50025b;
        }
        a8.append(obj);
        a8.append(")");
        return a8.toString();
    }
}
