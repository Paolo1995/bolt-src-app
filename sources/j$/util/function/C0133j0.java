package j$.util.function;

import java.util.function.LongPredicate;

/* renamed from: j$.util.function.j0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0133j0 implements LongPredicate {

    /* renamed from: a */
    final /* synthetic */ k0 f50326a;

    private /* synthetic */ C0133j0(k0 k0Var) {
        this.f50326a = k0Var;
    }

    public static /* synthetic */ LongPredicate a(k0 k0Var) {
        if (k0Var == null) {
            return null;
        }
        return k0Var instanceof C0131i0 ? ((C0131i0) k0Var).f50324a : new C0133j0(k0Var);
    }

    @Override // java.util.function.LongPredicate
    public final /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
        return a(((C0131i0) this.f50326a).a(C0131i0.b(longPredicate)));
    }

    @Override // java.util.function.LongPredicate
    public final /* synthetic */ LongPredicate negate() {
        return a(((C0131i0) this.f50326a).c());
    }

    @Override // java.util.function.LongPredicate
    public final /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
        return a(((C0131i0) this.f50326a).d(C0131i0.b(longPredicate)));
    }

    @Override // java.util.function.LongPredicate
    public final /* synthetic */ boolean test(long j8) {
        return ((C0131i0) this.f50326a).e(j8);
    }
}
