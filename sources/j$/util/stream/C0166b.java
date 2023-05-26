package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0120d;
import j$.util.function.InterfaceC0129h0;
import j$.util.function.InterfaceC0146x;
import j$.util.function.LongUnaryOperator;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;

/* renamed from: j$.util.stream.b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0166b implements IntFunction, j$.util.function.w0, BiConsumer, InterfaceC0146x, Supplier, ToDoubleFunction, ToIntFunction, j$.util.function.U, j$.util.function.z0, LongUnaryOperator, ToLongFunction, j$.util.function.C0, InterfaceC0129h0, InterfaceC0120d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50541a;

    public /* synthetic */ C0166b(int i8) {
        this.f50541a = i8;
    }

    @Override // j$.util.function.w0
    public final void accept(Object obj, double d8) {
        switch (this.f50541a) {
            case 2:
                double[] dArr = (double[]) obj;
                int i8 = D.f50378s;
                AbstractC0218n.a(dArr, d8);
                dArr[2] = dArr[2] + d8;
                return;
            default:
                double[] dArr2 = (double[]) obj;
                int i9 = D.f50378s;
                dArr2[2] = dArr2[2] + 1.0d;
                AbstractC0218n.a(dArr2, d8);
                dArr2[3] = dArr2[3] + d8;
                return;
        }
    }

    @Override // j$.util.function.z0
    public final void accept(Object obj, int i8) {
        long[] jArr = (long[]) obj;
        int i9 = AbstractC0182e0.f50570s;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + i8;
    }

    @Override // j$.util.function.C0
    public final void accept(Object obj, long j8) {
        long[] jArr = (long[]) obj;
        int i8 = AbstractC0207k0.f50604s;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j8;
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f50541a) {
            case 3:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                int i8 = D.f50378s;
                AbstractC0218n.a(dArr, dArr2[0]);
                AbstractC0218n.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                return;
            case 7:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                int i9 = D.f50378s;
                AbstractC0218n.a(dArr3, dArr4[0]);
                AbstractC0218n.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                return;
            case 19:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                int i10 = AbstractC0182e0.f50570s;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                return;
            default:
                long[] jArr3 = (long[]) obj;
                long[] jArr4 = (long[]) obj2;
                int i11 = AbstractC0207k0.f50604s;
                jArr3[0] = jArr3[0] + jArr4[0];
                jArr3[1] = jArr3[1] + jArr4[1];
                return;
        }
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f50541a) {
            case 3:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 7:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 19:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    @Override // j$.util.function.LongUnaryOperator
    public final /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        return LongUnaryOperator.CC.$default$andThen(this, longUnaryOperator);
    }

    @Override // j$.util.function.IntFunction
    public final Object apply(int i8) {
        switch (this.f50541a) {
            case 0:
                return new Object[i8];
            case 1:
                int i9 = D.f50378s;
                return new Double[i8];
            case 14:
                int i10 = U.f50480h;
                return new Object[i8];
            case 20:
                int i11 = AbstractC0182e0.f50570s;
                return new Integer[i8];
            default:
                int i12 = AbstractC0207k0.f50604s;
                return new Long[i8];
        }
    }

    @Override // j$.util.function.InterfaceC0129h0
    public final Object apply(long j8) {
        switch (this.f50541a) {
            case 27:
                return AbstractC0254w0.W0(j8);
            default:
                return AbstractC0254w0.g1(j8);
        }
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return new N0((B0) obj, (B0) obj2);
    }

    @Override // j$.util.function.ToDoubleFunction
    public final double applyAsDouble(Object obj) {
        int i8 = D.f50378s;
        return ((Double) obj).doubleValue();
    }

    @Override // j$.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        int i8 = AbstractC0182e0.f50570s;
        return ((Integer) obj).intValue();
    }

    @Override // j$.util.function.InterfaceC0146x
    public final long applyAsLong(double d8) {
        int i8 = D.f50378s;
        return 1L;
    }

    @Override // j$.util.function.U
    public final long applyAsLong(int i8) {
        int i9 = AbstractC0182e0.f50570s;
        return 1L;
    }

    @Override // j$.util.function.LongUnaryOperator
    public final long applyAsLong(long j8) {
        int i8 = AbstractC0207k0.f50604s;
        return 1L;
    }

    @Override // j$.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        int i8 = AbstractC0207k0.f50604s;
        return ((Long) obj).longValue();
    }

    @Override // j$.util.function.LongUnaryOperator
    public final /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        return LongUnaryOperator.CC.$default$compose(this, longUnaryOperator);
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        switch (this.f50541a) {
            case 5:
                int i8 = D.f50378s;
                return new double[4];
            case 6:
            case 7:
            case 8:
            case 14:
            case 15:
            case 16:
            default:
                int i9 = AbstractC0207k0.f50604s;
                return new long[2];
            case 9:
                int i10 = D.f50378s;
                return new double[3];
            case 10:
                return new I();
            case 11:
                return new K();
            case 12:
                return new L();
            case 13:
                return new J();
            case 17:
                int i11 = AbstractC0182e0.f50570s;
                return new long[2];
        }
    }
}
