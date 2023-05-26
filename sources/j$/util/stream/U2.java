package j$.util.stream;

import j$.util.Map;
import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum DISTINCT uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class U2 {
    public static final U2 DISTINCT;
    public static final U2 ORDERED;
    public static final U2 SHORT_CIRCUIT;
    public static final U2 SIZED;
    public static final U2 SORTED;

    /* renamed from: f  reason: collision with root package name */
    static final int f50490f;

    /* renamed from: g  reason: collision with root package name */
    static final int f50491g;

    /* renamed from: h  reason: collision with root package name */
    static final int f50492h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f50493i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f50494j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f50495k;

    /* renamed from: l  reason: collision with root package name */
    static final int f50496l;

    /* renamed from: m  reason: collision with root package name */
    static final int f50497m;

    /* renamed from: n  reason: collision with root package name */
    static final int f50498n;

    /* renamed from: o  reason: collision with root package name */
    static final int f50499o;

    /* renamed from: p  reason: collision with root package name */
    static final int f50500p;

    /* renamed from: q  reason: collision with root package name */
    static final int f50501q;

    /* renamed from: r  reason: collision with root package name */
    static final int f50502r;

    /* renamed from: s  reason: collision with root package name */
    static final int f50503s;

    /* renamed from: t  reason: collision with root package name */
    static final int f50504t;

    /* renamed from: u  reason: collision with root package name */
    static final int f50505u;

    /* renamed from: v  reason: collision with root package name */
    private static final /* synthetic */ U2[] f50506v;

    /* renamed from: a  reason: collision with root package name */
    private final Map f50507a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50508b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50509c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50510d;

    /* renamed from: e  reason: collision with root package name */
    private final int f50511e;

    static {
        T2 t22 = T2.SPLITERATOR;
        S2 j8 = j(t22);
        T2 t23 = T2.STREAM;
        j8.a(t23);
        T2 t24 = T2.OP;
        j8.f50476a.put(t24, 3);
        U2 u22 = new U2("DISTINCT", 0, 0, j8);
        DISTINCT = u22;
        S2 j9 = j(t22);
        j9.a(t23);
        j9.f50476a.put(t24, 3);
        U2 u23 = new U2("SORTED", 1, 1, j9);
        SORTED = u23;
        S2 j10 = j(t22);
        j10.a(t23);
        j10.f50476a.put(t24, 3);
        T2 t25 = T2.TERMINAL_OP;
        j10.f50476a.put(t25, 2);
        T2 t26 = T2.UPSTREAM_TERMINAL_OP;
        j10.f50476a.put(t26, 2);
        U2 u24 = new U2("ORDERED", 2, 2, j10);
        ORDERED = u24;
        S2 j11 = j(t22);
        j11.a(t23);
        j11.f50476a.put(t24, 2);
        U2 u25 = new U2("SIZED", 3, 3, j11);
        SIZED = u25;
        S2 j12 = j(t24);
        j12.a(t25);
        U2 u26 = new U2("SHORT_CIRCUIT", 4, 12, j12);
        SHORT_CIRCUIT = u26;
        f50506v = new U2[]{u22, u23, u24, u25, u26};
        f50490f = e(t22);
        f50491g = e(t23);
        f50492h = e(t24);
        e(t25);
        e(t26);
        int i8 = 0;
        for (U2 u27 : values()) {
            i8 |= u27.f50511e;
        }
        f50493i = i8;
        int i9 = f50491g;
        f50494j = i9;
        int i10 = i9 << 1;
        f50495k = i10;
        f50496l = i9 | i10;
        U2 u28 = DISTINCT;
        f50497m = u28.f50509c;
        f50498n = u28.f50510d;
        U2 u29 = SORTED;
        f50499o = u29.f50509c;
        f50500p = u29.f50510d;
        U2 u210 = ORDERED;
        f50501q = u210.f50509c;
        f50502r = u210.f50510d;
        U2 u211 = SIZED;
        f50503s = u211.f50509c;
        f50504t = u211.f50510d;
        f50505u = SHORT_CIRCUIT.f50509c;
    }

    private U2(String str, int i8, int i9, S2 s22) {
        for (T2 t22 : T2.values()) {
            Map.EL.a(s22.f50476a, t22, 0);
        }
        this.f50507a = s22.f50476a;
        int i10 = i9 * 2;
        this.f50508b = i10;
        this.f50509c = 1 << i10;
        this.f50510d = 2 << i10;
        this.f50511e = 3 << i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i8, int i9) {
        return i8 | (i9 & (i8 == 0 ? f50493i : ~(((f50494j & i8) << 1) | i8 | ((f50495k & i8) >> 1))));
    }

    private static int e(T2 t22) {
        U2[] values;
        int i8 = 0;
        for (U2 u22 : values()) {
            i8 |= ((Integer) u22.f50507a.get(t22)).intValue() << u22.f50508b;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(Spliterator spliterator) {
        int characteristics = spliterator.characteristics();
        return ((characteristics & 4) == 0 || spliterator.getComparator() == null) ? f50490f & characteristics : f50490f & characteristics & (-5);
    }

    private static S2 j(T2 t22) {
        S2 s22 = new S2(new EnumMap(T2.class));
        s22.a(t22);
        return s22;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i8) {
        return i8 & ((~i8) >> 1) & f50494j;
    }

    public static U2 valueOf(String str) {
        return (U2) Enum.valueOf(U2.class, str);
    }

    public static U2[] values() {
        return (U2[]) f50506v.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(int i8) {
        return (i8 & this.f50511e) == this.f50509c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i(int i8) {
        int i9 = this.f50511e;
        return (i8 & i9) == i9;
    }
}
