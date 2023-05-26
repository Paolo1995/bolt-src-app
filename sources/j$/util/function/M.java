package j$.util.function;

import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class M implements IntPredicate {

    /* renamed from: a */
    final /* synthetic */ N f50295a;

    private /* synthetic */ M(N n8) {
        this.f50295a = n8;
    }

    public static /* synthetic */ IntPredicate a(N n8) {
        if (n8 == null) {
            return null;
        }
        return n8 instanceof L ? ((L) n8).f50294a : new M(n8);
    }

    @Override // java.util.function.IntPredicate
    public final /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return a(((L) this.f50295a).a(L.b(intPredicate)));
    }

    @Override // java.util.function.IntPredicate
    public final /* synthetic */ IntPredicate negate() {
        return a(((L) this.f50295a).c());
    }

    @Override // java.util.function.IntPredicate
    public final /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return a(((L) this.f50295a).d(L.b(intPredicate)));
    }

    @Override // java.util.function.IntPredicate
    public final /* synthetic */ boolean test(int i8) {
        return ((L) this.f50295a).e(i8);
    }
}
