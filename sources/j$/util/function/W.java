package j$.util.function;

import java.util.function.IntUnaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class W implements IntUnaryOperator {

    /* renamed from: a */
    final /* synthetic */ X f50306a;

    private /* synthetic */ W(X x7) {
        this.f50306a = x7;
    }

    public static /* synthetic */ IntUnaryOperator a(X x7) {
        if (x7 == null) {
            return null;
        }
        return x7 instanceof V ? ((V) x7).f50305a : new W(x7);
    }

    @Override // java.util.function.IntUnaryOperator
    public final /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        return a(((V) this.f50306a).a(V.d(intUnaryOperator)));
    }

    @Override // java.util.function.IntUnaryOperator
    public final /* synthetic */ int applyAsInt(int i8) {
        return ((V) this.f50306a).b(i8);
    }

    @Override // java.util.function.IntUnaryOperator
    public final /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        return a(((V) this.f50306a).c(V.d(intUnaryOperator)));
    }
}
