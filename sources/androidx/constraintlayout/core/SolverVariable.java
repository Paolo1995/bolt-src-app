package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: w  reason: collision with root package name */
    private static int f4407w = 1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4408f;

    /* renamed from: g  reason: collision with root package name */
    private String f4409g;

    /* renamed from: k  reason: collision with root package name */
    public float f4413k;

    /* renamed from: o  reason: collision with root package name */
    Type f4417o;

    /* renamed from: h  reason: collision with root package name */
    public int f4410h = -1;

    /* renamed from: i  reason: collision with root package name */
    int f4411i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f4412j = 0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4414l = false;

    /* renamed from: m  reason: collision with root package name */
    float[] f4415m = new float[9];

    /* renamed from: n  reason: collision with root package name */
    float[] f4416n = new float[9];

    /* renamed from: p  reason: collision with root package name */
    ArrayRow[] f4418p = new ArrayRow[16];

    /* renamed from: q  reason: collision with root package name */
    int f4419q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f4420r = 0;

    /* renamed from: s  reason: collision with root package name */
    boolean f4421s = false;

    /* renamed from: t  reason: collision with root package name */
    int f4422t = -1;

    /* renamed from: u  reason: collision with root package name */
    float f4423u = 0.0f;

    /* renamed from: v  reason: collision with root package name */
    HashSet<ArrayRow> f4424v = null;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f4417o = type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
        f4407w++;
    }

    public final void a(ArrayRow arrayRow) {
        int i8 = 0;
        while (true) {
            int i9 = this.f4419q;
            if (i8 < i9) {
                if (this.f4418p[i8] == arrayRow) {
                    return;
                }
                i8++;
            } else {
                ArrayRow[] arrayRowArr = this.f4418p;
                if (i9 >= arrayRowArr.length) {
                    this.f4418p = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f4418p;
                int i10 = this.f4419q;
                arrayRowArr2[i10] = arrayRow;
                this.f4419q = i10 + 1;
                return;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(SolverVariable solverVariable) {
        return this.f4410h - solverVariable.f4410h;
    }

    public final void f(ArrayRow arrayRow) {
        int i8 = this.f4419q;
        int i9 = 0;
        while (i9 < i8) {
            if (this.f4418p[i9] == arrayRow) {
                while (i9 < i8 - 1) {
                    ArrayRow[] arrayRowArr = this.f4418p;
                    int i10 = i9 + 1;
                    arrayRowArr[i9] = arrayRowArr[i10];
                    i9 = i10;
                }
                this.f4419q--;
                return;
            }
            i9++;
        }
    }

    public void h() {
        this.f4409g = null;
        this.f4417o = Type.UNKNOWN;
        this.f4412j = 0;
        this.f4410h = -1;
        this.f4411i = -1;
        this.f4413k = 0.0f;
        this.f4414l = false;
        this.f4421s = false;
        this.f4422t = -1;
        this.f4423u = 0.0f;
        int i8 = this.f4419q;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f4418p[i9] = null;
        }
        this.f4419q = 0;
        this.f4420r = 0;
        this.f4408f = false;
        Arrays.fill(this.f4416n, 0.0f);
    }

    public void j(LinearSystem linearSystem, float f8) {
        this.f4413k = f8;
        this.f4414l = true;
        this.f4421s = false;
        this.f4422t = -1;
        this.f4423u = 0.0f;
        int i8 = this.f4419q;
        this.f4411i = -1;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f4418p[i9].A(linearSystem, this, false);
        }
        this.f4419q = 0;
    }

    public void k(Type type, String str) {
        this.f4417o = type;
    }

    public final void l(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i8 = this.f4419q;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f4418p[i9].B(linearSystem, arrayRow, false);
        }
        this.f4419q = 0;
    }

    public String toString() {
        if (this.f4409g != null) {
            return "" + this.f4409g;
        }
        return "" + this.f4410h;
    }
}
