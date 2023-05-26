package j$.util.function;

import java.util.function.LongToIntFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class p0 implements LongToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q0 f50334a;

    private /* synthetic */ p0(q0 q0Var) {
        this.f50334a = q0Var;
    }

    public static /* synthetic */ LongToIntFunction a(q0 q0Var) {
        if (q0Var == null) {
            return null;
        }
        return q0Var instanceof o0 ? ((o0) q0Var).f50332a : new p0(q0Var);
    }

    @Override // java.util.function.LongToIntFunction
    public final /* synthetic */ int applyAsInt(long j8) {
        return ((o0) this.f50334a).a(j8);
    }
}
