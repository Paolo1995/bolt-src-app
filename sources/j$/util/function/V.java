package j$.util.function;

import java.util.function.IntUnaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class V implements X {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntUnaryOperator f50305a;

    private /* synthetic */ V(IntUnaryOperator intUnaryOperator) {
        this.f50305a = intUnaryOperator;
    }

    public static /* synthetic */ X d(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        return intUnaryOperator instanceof W ? ((W) intUnaryOperator).f50306a : new V(intUnaryOperator);
    }

    public final /* synthetic */ X a(X x7) {
        return d(this.f50305a.andThen(W.a(x7)));
    }

    public final /* synthetic */ int b(int i8) {
        return this.f50305a.applyAsInt(i8);
    }

    public final /* synthetic */ X c(X x7) {
        return d(this.f50305a.compose(W.a(x7)));
    }
}
