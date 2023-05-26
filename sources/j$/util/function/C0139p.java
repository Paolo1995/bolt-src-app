package j$.util.function;

import java.util.function.DoublePredicate;

/* renamed from: j$.util.function.p  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0139p implements r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoublePredicate f50333a;

    private /* synthetic */ C0139p(DoublePredicate doublePredicate) {
        this.f50333a = doublePredicate;
    }

    public static /* synthetic */ r b(DoublePredicate doublePredicate) {
        if (doublePredicate == null) {
            return null;
        }
        return doublePredicate instanceof C0140q ? ((C0140q) doublePredicate).f50335a : new C0139p(doublePredicate);
    }

    public final /* synthetic */ r a(r rVar) {
        return b(this.f50333a.and(C0140q.a(rVar)));
    }

    public final /* synthetic */ r c() {
        return b(this.f50333a.negate());
    }

    public final /* synthetic */ r d(r rVar) {
        return b(this.f50333a.or(C0140q.a(rVar)));
    }

    public final /* synthetic */ boolean e(double d8) {
        return this.f50333a.test(d8);
    }
}
