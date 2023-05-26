package j$.util.function;

import j$.util.function.LongUnaryOperator;

/* loaded from: classes2.dex */
public final /* synthetic */ class r0 implements LongUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50336a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LongUnaryOperator f50337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LongUnaryOperator f50338c;

    public /* synthetic */ r0(LongUnaryOperator longUnaryOperator, LongUnaryOperator longUnaryOperator2, int i8) {
        this.f50336a = i8;
        this.f50337b = longUnaryOperator;
        this.f50338c = longUnaryOperator2;
    }

    @Override // j$.util.function.LongUnaryOperator
    public final /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        switch (this.f50336a) {
            case 0:
                return LongUnaryOperator.CC.$default$andThen(this, longUnaryOperator);
            default:
                return LongUnaryOperator.CC.$default$andThen(this, longUnaryOperator);
        }
    }

    @Override // j$.util.function.LongUnaryOperator
    public final long applyAsLong(long j8) {
        switch (this.f50336a) {
            case 0:
                return this.f50338c.applyAsLong(this.f50337b.applyAsLong(j8));
            default:
                return this.f50337b.applyAsLong(this.f50338c.applyAsLong(j8));
        }
    }

    @Override // j$.util.function.LongUnaryOperator
    public final /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        switch (this.f50336a) {
            case 0:
                return LongUnaryOperator.CC.$default$compose(this, longUnaryOperator);
            default:
                return LongUnaryOperator.CC.$default$compose(this, longUnaryOperator);
        }
    }
}
