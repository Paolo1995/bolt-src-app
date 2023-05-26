package j$.util;

/* loaded from: classes2.dex */
public final class Spliterators {

    /* renamed from: a  reason: collision with root package name */
    private static final Spliterator f50165a = new Y();

    /* renamed from: b  reason: collision with root package name */
    private static final G f50166b = new W();

    /* renamed from: c  reason: collision with root package name */
    private static final J f50167c = new X();

    /* renamed from: d  reason: collision with root package name */
    private static final D f50168d = new V();

    private static void a(int i8, int i9, int i10) {
        if (i9 <= i10) {
            if (i9 < 0) {
                throw new ArrayIndexOutOfBoundsException(i9);
            }
            if (i10 > i8) {
                throw new ArrayIndexOutOfBoundsException(i10);
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("origin(" + i9 + ") > fence(" + i10 + ")");
    }

    public static D b() {
        return f50168d;
    }

    public static G c() {
        return f50166b;
    }

    public static J d() {
        return f50167c;
    }

    public static Spliterator e() {
        return f50165a;
    }

    public static InterfaceC0159q f(D d8) {
        d8.getClass();
        return new S(d8);
    }

    public static InterfaceC0270u g(G g8) {
        g8.getClass();
        return new P(g8);
    }

    public static InterfaceC0274y h(J j8) {
        j8.getClass();
        return new Q(j8);
    }

    public static java.util.Iterator i(Spliterator spliterator) {
        spliterator.getClass();
        return new O(spliterator);
    }

    public static D j(double[] dArr, int i8, int i9) {
        dArr.getClass();
        a(dArr.length, i8, i9);
        return new U(dArr, i8, i9, 1040);
    }

    public static G k(int[] iArr, int i8, int i9) {
        iArr.getClass();
        a(iArr.length, i8, i9);
        return new Z(iArr, i8, i9, 1040);
    }

    public static J l(long[] jArr, int i8, int i9) {
        jArr.getClass();
        a(jArr.length, i8, i9);
        return new b0(jArr, i8, i9, 1040);
    }

    public static <T> Spliterator<T> spliterator(Object[] objArr, int i8, int i9, int i10) {
        objArr.getClass();
        a(objArr.length, i8, i9);
        return new T(objArr, i8, i9, i10);
    }
}
