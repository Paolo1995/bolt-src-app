package j$.util.function;

import java.util.function.DoubleUnaryOperator;

/* renamed from: j$.util.function.y  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0147y implements A {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleUnaryOperator f50348a;

    private /* synthetic */ C0147y(DoubleUnaryOperator doubleUnaryOperator) {
        this.f50348a = doubleUnaryOperator;
    }

    public static /* synthetic */ A d(DoubleUnaryOperator doubleUnaryOperator) {
        if (doubleUnaryOperator == null) {
            return null;
        }
        return doubleUnaryOperator instanceof C0148z ? ((C0148z) doubleUnaryOperator).f50350a : new C0147y(doubleUnaryOperator);
    }

    public final /* synthetic */ A a(A a8) {
        return d(this.f50348a.andThen(C0148z.a(a8)));
    }

    public final /* synthetic */ double b(double d8) {
        return this.f50348a.applyAsDouble(d8);
    }

    public final /* synthetic */ A c(A a8) {
        return d(this.f50348a.compose(C0148z.a(a8)));
    }
}
