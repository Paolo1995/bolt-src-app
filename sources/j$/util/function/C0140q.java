package j$.util.function;

import java.util.function.DoublePredicate;

/* renamed from: j$.util.function.q  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0140q implements DoublePredicate {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f50335a;

    private /* synthetic */ C0140q(r rVar) {
        this.f50335a = rVar;
    }

    public static /* synthetic */ DoublePredicate a(r rVar) {
        if (rVar == null) {
            return null;
        }
        return rVar instanceof C0139p ? ((C0139p) rVar).f50333a : new C0140q(rVar);
    }

    @Override // java.util.function.DoublePredicate
    public final /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
        return a(((C0139p) this.f50335a).a(C0139p.b(doublePredicate)));
    }

    @Override // java.util.function.DoublePredicate
    public final /* synthetic */ DoublePredicate negate() {
        return a(((C0139p) this.f50335a).c());
    }

    @Override // java.util.function.DoublePredicate
    public final /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
        return a(((C0139p) this.f50335a).d(C0139p.b(doublePredicate)));
    }

    @Override // java.util.function.DoublePredicate
    public final /* synthetic */ boolean test(double d8) {
        return ((C0139p) this.f50335a).e(d8);
    }
}
