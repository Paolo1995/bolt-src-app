package j$.util.function;

import java.util.function.DoubleUnaryOperator;

/* renamed from: j$.util.function.z  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0148z implements DoubleUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f50350a;

    private /* synthetic */ C0148z(A a8) {
        this.f50350a = a8;
    }

    public static /* synthetic */ DoubleUnaryOperator a(A a8) {
        if (a8 == null) {
            return null;
        }
        return a8 instanceof C0147y ? ((C0147y) a8).f50348a : new C0148z(a8);
    }

    @Override // java.util.function.DoubleUnaryOperator
    public final /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
        return a(((C0147y) this.f50350a).a(C0147y.d(doubleUnaryOperator)));
    }

    @Override // java.util.function.DoubleUnaryOperator
    public final /* synthetic */ double applyAsDouble(double d8) {
        return ((C0147y) this.f50350a).b(d8);
    }

    @Override // java.util.function.DoubleUnaryOperator
    public final /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
        return a(((C0147y) this.f50350a).c(C0147y.d(doubleUnaryOperator)));
    }
}
