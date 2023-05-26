package j$.util.function;

import java.util.function.LongToDoubleFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class m0 implements LongToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n0 f50330a;

    private /* synthetic */ m0(n0 n0Var) {
        this.f50330a = n0Var;
    }

    public static /* synthetic */ LongToDoubleFunction a(n0 n0Var) {
        if (n0Var == null) {
            return null;
        }
        return n0Var instanceof l0 ? ((l0) n0Var).f50328a : new m0(n0Var);
    }

    @Override // java.util.function.LongToDoubleFunction
    public final /* synthetic */ double applyAsDouble(long j8) {
        return ((l0) this.f50330a).a(j8);
    }
}
