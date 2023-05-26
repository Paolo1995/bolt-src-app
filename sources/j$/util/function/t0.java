package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class t0 implements java.util.function.LongUnaryOperator {

    /* renamed from: a */
    final /* synthetic */ LongUnaryOperator f50342a;

    private /* synthetic */ t0(LongUnaryOperator longUnaryOperator) {
        this.f50342a = longUnaryOperator;
    }

    public static /* synthetic */ java.util.function.LongUnaryOperator a(LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        return longUnaryOperator instanceof s0 ? ((s0) longUnaryOperator).f50340a : new t0(longUnaryOperator);
    }

    @Override // java.util.function.LongUnaryOperator
    public final /* synthetic */ java.util.function.LongUnaryOperator andThen(java.util.function.LongUnaryOperator longUnaryOperator) {
        return a(this.f50342a.andThen(s0.a(longUnaryOperator)));
    }

    @Override // java.util.function.LongUnaryOperator
    public final /* synthetic */ long applyAsLong(long j8) {
        return this.f50342a.applyAsLong(j8);
    }

    @Override // java.util.function.LongUnaryOperator
    public final /* synthetic */ java.util.function.LongUnaryOperator compose(java.util.function.LongUnaryOperator longUnaryOperator) {
        return a(this.f50342a.compose(s0.a(longUnaryOperator)));
    }
}
