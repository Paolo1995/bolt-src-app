package j$.util.function;

import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class L implements N {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntPredicate f50294a;

    private /* synthetic */ L(IntPredicate intPredicate) {
        this.f50294a = intPredicate;
    }

    public static /* synthetic */ N b(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return intPredicate instanceof M ? ((M) intPredicate).f50295a : new L(intPredicate);
    }

    public final /* synthetic */ N a(N n8) {
        return b(this.f50294a.and(M.a(n8)));
    }

    public final /* synthetic */ N c() {
        return b(this.f50294a.negate());
    }

    public final /* synthetic */ N d(N n8) {
        return b(this.f50294a.or(M.a(n8)));
    }

    public final /* synthetic */ boolean e(int i8) {
        return this.f50294a.test(i8);
    }
}
