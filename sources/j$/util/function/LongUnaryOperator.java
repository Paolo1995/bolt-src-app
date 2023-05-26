package j$.util.function;

/* loaded from: classes2.dex */
public interface LongUnaryOperator {

    /* renamed from: j$.util.function.LongUnaryOperator$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static LongUnaryOperator $default$andThen(LongUnaryOperator longUnaryOperator, LongUnaryOperator longUnaryOperator2) {
            longUnaryOperator2.getClass();
            return new r0(longUnaryOperator, longUnaryOperator2, 0);
        }

        public static LongUnaryOperator $default$compose(LongUnaryOperator longUnaryOperator, LongUnaryOperator longUnaryOperator2) {
            longUnaryOperator2.getClass();
            return new r0(longUnaryOperator, longUnaryOperator2, 1);
        }
    }

    LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator);

    long applyAsLong(long j8);

    LongUnaryOperator compose(LongUnaryOperator longUnaryOperator);
}
