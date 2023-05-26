package j$.util.function;

import java.util.function.IntBinaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class D implements F {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntBinaryOperator f50276a;

    private /* synthetic */ D(IntBinaryOperator intBinaryOperator) {
        this.f50276a = intBinaryOperator;
    }

    public static /* synthetic */ F a(IntBinaryOperator intBinaryOperator) {
        if (intBinaryOperator == null) {
            return null;
        }
        return intBinaryOperator instanceof E ? ((E) intBinaryOperator).f50280a : new D(intBinaryOperator);
    }

    @Override // j$.util.function.F
    public final /* synthetic */ int applyAsInt(int i8, int i9) {
        return this.f50276a.applyAsInt(i8, i9);
    }
}
