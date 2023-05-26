package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.InterfaceC0135l;
import j$.util.function.Predicate;

/* renamed from: j$.util.stream.w0  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0254w0 implements B3 {

    /* renamed from: a  reason: collision with root package name */
    private static final Y0 f50698a = new Y0();

    /* renamed from: b  reason: collision with root package name */
    private static final C0 f50699b = new W0();

    /* renamed from: c  reason: collision with root package name */
    private static final D0 f50700c = new X0();

    /* renamed from: d  reason: collision with root package name */
    private static final B0 f50701d = new V0();

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f50702e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    private static final long[] f50703f = new long[0];

    /* renamed from: g  reason: collision with root package name */
    private static final double[] f50704g = new double[0];

    public /* synthetic */ AbstractC0254w0() {
    }

    public /* synthetic */ AbstractC0254w0(int i8) {
    }

    public static void A0(D0 d02, Long[] lArr, int i8) {
        if (E3.f50390a) {
            E3.a(d02.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) d02.b();
        for (int i9 = 0; i9 < jArr.length; i9++) {
            lArr[i8 + i9] = Long.valueOf(jArr[i9]);
        }
    }

    public static void B0(B0 b02, Consumer consumer) {
        if (consumer instanceof InterfaceC0135l) {
            b02.d((InterfaceC0135l) consumer);
        } else if (E3.f50390a) {
            E3.a(b02.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        } else {
            ((j$.util.D) b02.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void C0(C0 c02, Consumer consumer) {
        if (consumer instanceof j$.util.function.J) {
            c02.d((j$.util.function.J) consumer);
        } else if (E3.f50390a) {
            E3.a(c02.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
            throw null;
        } else {
            ((j$.util.G) c02.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void D0(D0 d02, Consumer consumer) {
        if (consumer instanceof InterfaceC0123e0) {
            d02.d((InterfaceC0123e0) consumer);
        } else if (E3.f50390a) {
            E3.a(d02.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        } else {
            ((j$.util.J) d02.spliterator()).forEachRemaining(consumer);
        }
    }

    public static B0 E0(B0 b02, long j8, long j9) {
        if (j8 == 0 && j9 == b02.count()) {
            return b02;
        }
        long j10 = j9 - j8;
        j$.util.D d8 = (j$.util.D) b02.spliterator();
        InterfaceC0258x0 W0 = W0(j10);
        W0.e(j10);
        for (int i8 = 0; i8 < j8 && d8.n(new j3(1)); i8++) {
        }
        for (int i9 = 0; i9 < j10 && d8.n(W0); i9++) {
        }
        W0.end();
        return W0.build();
    }

    public static C0 F0(C0 c02, long j8, long j9) {
        if (j8 == 0 && j9 == c02.count()) {
            return c02;
        }
        long j10 = j9 - j8;
        j$.util.G g8 = (j$.util.G) c02.spliterator();
        InterfaceC0262y0 g12 = g1(j10);
        g12.e(j10);
        for (int i8 = 0; i8 < j8 && g8.i(new l3(1)); i8++) {
        }
        for (int i9 = 0; i9 < j10 && g8.i(g12); i9++) {
        }
        g12.end();
        return g12.build();
    }

    public static D0 G0(D0 d02, long j8, long j9) {
        if (j8 == 0 && j9 == d02.count()) {
            return d02;
        }
        long j10 = j9 - j8;
        j$.util.J j11 = (j$.util.J) d02.spliterator();
        InterfaceC0266z0 i12 = i1(j10);
        i12.e(j10);
        for (int i8 = 0; i8 < j8 && j11.d(new n3(1)); i8++) {
        }
        for (int i9 = 0; i9 < j10 && j11.d(i12); i9++) {
        }
        i12.end();
        return i12.build();
    }

    public static F0 H0(F0 f02, long j8, long j9, IntFunction intFunction) {
        if (j8 == 0 && j9 == f02.count()) {
            return f02;
        }
        Spliterator spliterator = f02.spliterator();
        long j10 = j9 - j8;
        A0 O0 = O0(j10, intFunction);
        O0.e(j10);
        for (int i8 = 0; i8 < j8 && spliterator.tryAdvance(new X(9)); i8++) {
        }
        for (int i9 = 0; i9 < j10 && spliterator.tryAdvance(O0); i9++) {
        }
        O0.end();
        return O0.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long I0(long j8, long j9) {
        long j10 = j9 >= 0 ? j8 + j9 : Long.MAX_VALUE;
        if (j10 >= 0) {
            return j10;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Spliterator J0(int i8, Spliterator spliterator, long j8, long j9) {
        long j10 = j9 >= 0 ? j8 + j9 : Long.MAX_VALUE;
        long j11 = j10 >= 0 ? j10 : Long.MAX_VALUE;
        int[] iArr = AbstractC0229p2.f50640a;
        if (i8 != 0) {
            int i9 = iArr[i8 - 1];
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 == 4) {
                            return new k3((j$.util.D) spliterator, j8, j11);
                        }
                        StringBuilder a8 = j$.time.b.a("Unknown shape ");
                        a8.append(j$.time.b.b(i8));
                        throw new IllegalStateException(a8.toString());
                    }
                    return new o3((j$.util.J) spliterator, j8, j11);
                }
                return new m3((j$.util.G) spliterator, j8, j11);
            }
            return new q3(spliterator, j8, j11);
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long K0(long j8, long j9, long j10) {
        if (j8 >= 0) {
            return Math.max(-1L, Math.min(j8 - j9, j10));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static A0 O0(long j8, IntFunction intFunction) {
        return (j8 < 0 || j8 >= 2147483639) ? new C0239s1() : new C0163a1(j8, intFunction);
    }

    public static F0 P0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7, IntFunction intFunction) {
        long Z0 = abstractC0254w0.Z0(spliterator);
        if (Z0 < 0 || !spliterator.hasCharacteristics(16384)) {
            F0 f02 = (F0) new K0(spliterator, intFunction, abstractC0254w0).invoke();
            return z7 ? b1(f02, intFunction) : f02;
        } else if (Z0 < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) Z0);
            new C0232q1(spliterator, abstractC0254w0, objArr).invoke();
            return new I0(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static B0 Q0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        long Z0 = abstractC0254w0.Z0(spliterator);
        if (Z0 < 0 || !spliterator.hasCharacteristics(16384)) {
            B0 b02 = (B0) new K0(0, spliterator, abstractC0254w0).invoke();
            return z7 ? c1(b02) : b02;
        } else if (Z0 < 2147483639) {
            double[] dArr = new double[(int) Z0];
            new C0220n1(spliterator, abstractC0254w0, dArr).invoke();
            return new S0(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static C0 R0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        long Z0 = abstractC0254w0.Z0(spliterator);
        if (Z0 < 0 || !spliterator.hasCharacteristics(16384)) {
            C0 c02 = (C0) new K0(1, spliterator, abstractC0254w0).invoke();
            return z7 ? d1(c02) : c02;
        } else if (Z0 < 2147483639) {
            int[] iArr = new int[(int) Z0];
            new C0224o1(spliterator, abstractC0254w0, iArr).invoke();
            return new C0168b1(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static D0 S0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        long Z0 = abstractC0254w0.Z0(spliterator);
        if (Z0 < 0 || !spliterator.hasCharacteristics(16384)) {
            D0 d02 = (D0) new K0(2, spliterator, abstractC0254w0).invoke();
            return z7 ? e1(d02) : d02;
        } else if (Z0 < 2147483639) {
            long[] jArr = new long[(int) Z0];
            new C0228p1(spliterator, abstractC0254w0, jArr).invoke();
            return new C0208k1(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static H0 T0(int i8, F0 f02, F0 f03) {
        int[] iArr = G0.f50398a;
        if (i8 != 0) {
            int i9 = iArr[i8 - 1];
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 == 4) {
                            return new N0((B0) f02, (B0) f03);
                        }
                        StringBuilder a8 = j$.time.b.a("Unknown shape ");
                        a8.append(j$.time.b.b(i8));
                        throw new IllegalStateException(a8.toString());
                    }
                    return new P0((D0) f02, (D0) f03);
                }
                return new O0((C0) f02, (C0) f03);
            }
            return new R0(f02, f03);
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0258x0 W0(long j8) {
        return (j8 < 0 || j8 >= 2147483639) ? new U0() : new T0(j8);
    }

    public static G X0(j$.util.D d8) {
        return new A(d8, U2.g(d8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Z0 Y0(int i8) {
        Object obj;
        int[] iArr = G0.f50398a;
        if (i8 != 0) {
            int i9 = iArr[i8 - 1];
            if (i9 != 1) {
                if (i9 == 2) {
                    obj = f50699b;
                } else if (i9 == 3) {
                    obj = f50700c;
                } else if (i9 != 4) {
                    StringBuilder a8 = j$.time.b.a("Unknown shape ");
                    a8.append(j$.time.b.b(i8));
                    throw new IllegalStateException(a8.toString());
                } else {
                    obj = f50701d;
                }
                return (Z0) obj;
            }
            return f50698a;
        }
        throw null;
    }

    private static int a1(long j8) {
        return (j8 != -1 ? U2.f50505u : 0) | U2.f50504t;
    }

    public static F0 b1(F0 f02, IntFunction intFunction) {
        if (f02.n() > 0) {
            long count = f02.count();
            if (count < 2147483639) {
                Object[] objArr = (Object[]) intFunction.apply((int) count);
                new C0247u1(f02, objArr).invoke();
                return new I0(objArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return f02;
    }

    public static B0 c1(B0 b02) {
        if (b02.n() > 0) {
            long count = b02.count();
            if (count < 2147483639) {
                double[] dArr = new double[(int) count];
                new C0243t1(b02, dArr).invoke();
                return new S0(dArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return b02;
    }

    public static C0 d1(C0 c02) {
        if (c02.n() > 0) {
            long count = c02.count();
            if (count < 2147483639) {
                int[] iArr = new int[(int) count];
                new C0243t1(c02, iArr).invoke();
                return new C0168b1(iArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return c02;
    }

    public static D0 e1(D0 d02) {
        if (d02.n() > 0) {
            long count = d02.count();
            if (count < 2147483639) {
                long[] jArr = new long[(int) count];
                new C0243t1(d02, jArr).invoke();
                return new C0208k1(jArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return d02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0262y0 g1(long j8) {
        return (j8 < 0 || j8 >= 2147483639) ? new C0178d1() : new C0173c1(j8);
    }

    public static IntStream h1(j$.util.G g8) {
        return new C0167b0(g8, U2.g(g8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0266z0 i1(long j8) {
        return (j8 < 0 || j8 >= 2147483639) ? new C0216m1() : new C0212l1(j8);
    }

    public static InterfaceC0219n0 j1(j$.util.J j8) {
        return new C0195h0(j8, U2.g(j8));
    }

    public static G k1(AbstractC0171c abstractC0171c, long j8, long j9) {
        if (j8 >= 0) {
            return new C0225o2(abstractC0171c, a1(j9), j8, j9);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j8);
    }

    public static C0246u0 l1(j$.util.function.r rVar, EnumC0242t0 enumC0242t0) {
        rVar.getClass();
        enumC0242t0.getClass();
        return new C0246u0(4, enumC0242t0, new C0222o(3, enumC0242t0, rVar));
    }

    public static IntStream m1(AbstractC0171c abstractC0171c, long j8, long j9) {
        if (j8 >= 0) {
            return new C0209k2(abstractC0171c, a1(j9), j8, j9);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j8);
    }

    public static C0246u0 n1(j$.util.function.N n8, EnumC0242t0 enumC0242t0) {
        n8.getClass();
        enumC0242t0.getClass();
        return new C0246u0(2, enumC0242t0, new C0222o(1, enumC0242t0, n8));
    }

    public static void o0() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static InterfaceC0219n0 o1(AbstractC0171c abstractC0171c, long j8, long j9) {
        if (j8 >= 0) {
            return new C0217m2(abstractC0171c, a1(j9), j8, j9);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j8);
    }

    public static void p0(InterfaceC0179d2 interfaceC0179d2, Double d8) {
        if (E3.f50390a) {
            E3.a(interfaceC0179d2.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        } else {
            interfaceC0179d2.accept(d8.doubleValue());
        }
    }

    public static C0246u0 p1(j$.util.function.k0 k0Var, EnumC0242t0 enumC0242t0) {
        k0Var.getClass();
        enumC0242t0.getClass();
        return new C0246u0(3, enumC0242t0, new C0222o(4, enumC0242t0, k0Var));
    }

    public static void r0(InterfaceC0184e2 interfaceC0184e2, Integer num) {
        if (E3.f50390a) {
            E3.a(interfaceC0184e2.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        } else {
            interfaceC0184e2.accept(num.intValue());
        }
    }

    public static C0246u0 r1(Predicate predicate, EnumC0242t0 enumC0242t0) {
        predicate.getClass();
        enumC0242t0.getClass();
        return new C0246u0(1, enumC0242t0, new C0222o(2, enumC0242t0, predicate));
    }

    public static Stream s1(AbstractC0171c abstractC0171c, long j8, long j9) {
        if (j8 >= 0) {
            return new C0201i2(abstractC0171c, a1(j9), j8, j9);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j8);
    }

    public static void t0(InterfaceC0189f2 interfaceC0189f2, Long l8) {
        if (E3.f50390a) {
            E3.a(interfaceC0189f2.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        } else {
            interfaceC0189f2.accept(l8.longValue());
        }
    }

    public static Stream u1(Spliterator spliterator, boolean z7) {
        spliterator.getClass();
        return new V1(spliterator, U2.g(spliterator), z7);
    }

    public static void v0() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void w0() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static Object[] x0(E0 e02, IntFunction intFunction) {
        if (E3.f50390a) {
            E3.a(e02.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        } else if (e02.count() < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) e02.count());
            e02.i(objArr, 0);
            return objArr;
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static void y0(B0 b02, Double[] dArr, int i8) {
        if (E3.f50390a) {
            E3.a(b02.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) b02.b();
        for (int i9 = 0; i9 < dArr2.length; i9++) {
            dArr[i8 + i9] = Double.valueOf(dArr2[i9]);
        }
    }

    public static void z0(C0 c02, Integer[] numArr, int i8) {
        if (E3.f50390a) {
            E3.a(c02.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) c02.b();
        for (int i9 = 0; i9 < iArr.length; i9++) {
            numArr[i8 + i9] = Integer.valueOf(iArr[i9]);
        }
    }

    @Override // j$.util.stream.B3
    public /* synthetic */ int O() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void U0(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void V0(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long Z0(Spliterator spliterator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f1();

    @Override // j$.util.stream.B3
    public Object m0(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        P1 t12 = t1();
        abstractC0254w0.v1(spliterator, t12);
        return t12.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract A0 q1(long j8, IntFunction intFunction);

    public abstract P1 t1();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract InterfaceC0193g2 v1(Spliterator spliterator, InterfaceC0193g2 interfaceC0193g2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract InterfaceC0193g2 w1(InterfaceC0193g2 interfaceC0193g2);

    @Override // j$.util.stream.B3
    public Object y(AbstractC0254w0 abstractC0254w0, Spliterator spliterator) {
        return ((P1) new R1(this, abstractC0254w0, spliterator).invoke()).get();
    }
}
