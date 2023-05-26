package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class s0 implements LongUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ java.util.function.LongUnaryOperator f50340a;

    private /* synthetic */ s0(java.util.function.LongUnaryOperator longUnaryOperator) {
        this.f50340a = longUnaryOperator;
    }

    public static /* synthetic */ LongUnaryOperator a(java.util.function.LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        return longUnaryOperator instanceof t0 ? ((t0) longUnaryOperator).f50342a : new s0(longUnaryOperator);
    }

    @Override // j$.util.function.LongUnaryOperator
    public final /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        return a(this.f50340a.andThen(t0.a(longUnaryOperator)));
    }

    @Override // j$.util.function.LongUnaryOperator
    public final /* synthetic */ long applyAsLong(long j8) {
        return this.f50340a.applyAsLong(j8);
    }

    @Override // j$.util.function.LongUnaryOperator
    public final /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        return a(this.f50340a.compose(t0.a(longUnaryOperator)));
    }
}
