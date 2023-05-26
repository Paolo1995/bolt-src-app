package j$.time.temporal;

import j$.time.DateTimeException;

/* loaded from: classes2.dex */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    static final p f50103a = new p(0);

    /* renamed from: b  reason: collision with root package name */
    static final p f50104b = new p(1);

    /* renamed from: c  reason: collision with root package name */
    static final p f50105c = new p(2);

    /* renamed from: d  reason: collision with root package name */
    static final p f50106d = new p(3);

    /* renamed from: e  reason: collision with root package name */
    static final p f50107e = new p(4);

    /* renamed from: f  reason: collision with root package name */
    static final p f50108f = new p(5);

    /* renamed from: g  reason: collision with root package name */
    static final p f50109g = new p(6);

    public static int a(l lVar, o oVar) {
        t h8 = lVar.h(oVar);
        if (!h8.g()) {
            throw new s("Invalid field " + oVar + " for get() method, use getLong() instead");
        }
        long n8 = lVar.n(oVar);
        if (h8.h(n8)) {
            return (int) n8;
        }
        throw new DateTimeException("Invalid value for " + oVar + " (valid values " + h8 + "): " + n8);
    }

    public static Object b(l lVar, q qVar) {
        if (qVar == f50103a || qVar == f50104b || qVar == f50105c) {
            return null;
        }
        return qVar.c(lVar);
    }

    public static t c(l lVar, o oVar) {
        if (!(oVar instanceof a)) {
            if (oVar != null) {
                return oVar.e(lVar);
            }
            throw new NullPointerException("field");
        } else if (lVar.k(oVar)) {
            return oVar.g();
        } else {
            throw new s("Unsupported field: " + oVar);
        }
    }

    public static p d() {
        return f50104b;
    }

    public static p e() {
        return f50108f;
    }

    public static p f() {
        return f50109g;
    }

    public static p g() {
        return f50106d;
    }

    public static p h() {
        return f50105c;
    }

    public static p i() {
        return f50107e;
    }

    public static p j() {
        return f50103a;
    }
}
