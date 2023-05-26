package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class LinearSystem {

    /* renamed from: r  reason: collision with root package name */
    public static boolean f4342r = false;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f4343s = true;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f4344t = true;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f4345u = true;

    /* renamed from: v  reason: collision with root package name */
    public static boolean f4346v = false;

    /* renamed from: w  reason: collision with root package name */
    private static int f4347w = 1000;

    /* renamed from: x  reason: collision with root package name */
    public static Metrics f4348x;

    /* renamed from: y  reason: collision with root package name */
    public static long f4349y;

    /* renamed from: z  reason: collision with root package name */
    public static long f4350z;

    /* renamed from: d  reason: collision with root package name */
    private Row f4354d;

    /* renamed from: g  reason: collision with root package name */
    ArrayRow[] f4357g;

    /* renamed from: n  reason: collision with root package name */
    final Cache f4364n;

    /* renamed from: q  reason: collision with root package name */
    private Row f4367q;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4351a = false;

    /* renamed from: b  reason: collision with root package name */
    int f4352b = 0;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, SolverVariable> f4353c = null;

    /* renamed from: e  reason: collision with root package name */
    private int f4355e = 32;

    /* renamed from: f  reason: collision with root package name */
    private int f4356f = 32;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4358h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4359i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean[] f4360j = new boolean[32];

    /* renamed from: k  reason: collision with root package name */
    int f4361k = 1;

    /* renamed from: l  reason: collision with root package name */
    int f4362l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f4363m = 32;

    /* renamed from: o  reason: collision with root package name */
    private SolverVariable[] f4365o = new SolverVariable[f4347w];

    /* renamed from: p  reason: collision with root package name */
    private int f4366p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Row {
        void a(Row row);

        SolverVariable b(LinearSystem linearSystem, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.f4336e = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.f4357g = null;
        this.f4357g = new ArrayRow[32];
        C();
        Cache cache = new Cache();
        this.f4364n = cache;
        this.f4354d = new PriorityGoalRow(cache);
        if (f4346v) {
            this.f4367q = new ValuesRow(cache);
        } else {
            this.f4367q = new ArrayRow(cache);
        }
    }

    private final int B(Row row, boolean z7) {
        Metrics metrics = f4348x;
        if (metrics != null) {
            metrics.f4376h++;
        }
        for (int i8 = 0; i8 < this.f4361k; i8++) {
            this.f4360j[i8] = false;
        }
        boolean z8 = false;
        int i9 = 0;
        while (!z8) {
            Metrics metrics2 = f4348x;
            if (metrics2 != null) {
                metrics2.f4377i++;
            }
            i9++;
            if (i9 >= this.f4361k * 2) {
                return i9;
            }
            if (row.getKey() != null) {
                this.f4360j[row.getKey().f4410h] = true;
            }
            SolverVariable b8 = row.b(this, this.f4360j);
            if (b8 != null) {
                boolean[] zArr = this.f4360j;
                int i10 = b8.f4410h;
                if (zArr[i10]) {
                    return i9;
                }
                zArr[i10] = true;
            }
            if (b8 != null) {
                float f8 = Float.MAX_VALUE;
                int i11 = -1;
                for (int i12 = 0; i12 < this.f4362l; i12++) {
                    ArrayRow arrayRow = this.f4357g[i12];
                    if (arrayRow.f4332a.f4417o != SolverVariable.Type.UNRESTRICTED && !arrayRow.f4337f && arrayRow.t(b8)) {
                        float j8 = arrayRow.f4336e.j(b8);
                        if (j8 < 0.0f) {
                            float f9 = (-arrayRow.f4333b) / j8;
                            if (f9 < f8) {
                                i11 = i12;
                                f8 = f9;
                            }
                        }
                    }
                }
                if (i11 > -1) {
                    ArrayRow arrayRow2 = this.f4357g[i11];
                    arrayRow2.f4332a.f4411i = -1;
                    Metrics metrics3 = f4348x;
                    if (metrics3 != null) {
                        metrics3.f4378j++;
                    }
                    arrayRow2.x(b8);
                    SolverVariable solverVariable = arrayRow2.f4332a;
                    solverVariable.f4411i = i11;
                    solverVariable.l(this, arrayRow2);
                }
            } else {
                z8 = true;
            }
        }
        return i9;
    }

    private void C() {
        int i8 = 0;
        if (f4346v) {
            while (i8 < this.f4362l) {
                ArrayRow arrayRow = this.f4357g[i8];
                if (arrayRow != null) {
                    this.f4364n.f4338a.a(arrayRow);
                }
                this.f4357g[i8] = null;
                i8++;
            }
            return;
        }
        while (i8 < this.f4362l) {
            ArrayRow arrayRow2 = this.f4357g[i8];
            if (arrayRow2 != null) {
                this.f4364n.f4339b.a(arrayRow2);
            }
            this.f4357g[i8] = null;
            i8++;
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable b8 = this.f4364n.f4340c.b();
        if (b8 == null) {
            b8 = new SolverVariable(type, str);
            b8.k(type, str);
        } else {
            b8.h();
            b8.k(type, str);
        }
        int i8 = this.f4366p;
        int i9 = f4347w;
        if (i8 >= i9) {
            int i10 = i9 * 2;
            f4347w = i10;
            this.f4365o = (SolverVariable[]) Arrays.copyOf(this.f4365o, i10);
        }
        SolverVariable[] solverVariableArr = this.f4365o;
        int i11 = this.f4366p;
        this.f4366p = i11 + 1;
        solverVariableArr[i11] = b8;
        return b8;
    }

    private final void l(ArrayRow arrayRow) {
        int i8;
        if (f4344t && arrayRow.f4337f) {
            arrayRow.f4332a.j(this, arrayRow.f4333b);
        } else {
            ArrayRow[] arrayRowArr = this.f4357g;
            int i9 = this.f4362l;
            arrayRowArr[i9] = arrayRow;
            SolverVariable solverVariable = arrayRow.f4332a;
            solverVariable.f4411i = i9;
            this.f4362l = i9 + 1;
            solverVariable.l(this, arrayRow);
        }
        if (f4344t && this.f4351a) {
            int i10 = 0;
            while (i10 < this.f4362l) {
                if (this.f4357g[i10] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.f4357g[i10];
                if (arrayRow2 != null && arrayRow2.f4337f) {
                    arrayRow2.f4332a.j(this, arrayRow2.f4333b);
                    if (f4346v) {
                        this.f4364n.f4338a.a(arrayRow2);
                    } else {
                        this.f4364n.f4339b.a(arrayRow2);
                    }
                    this.f4357g[i10] = null;
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (true) {
                        i8 = this.f4362l;
                        if (i11 >= i8) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.f4357g;
                        int i13 = i11 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i11];
                        arrayRowArr2[i13] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.f4332a;
                        if (solverVariable2.f4411i == i11) {
                            solverVariable2.f4411i = i13;
                        }
                        i12 = i11;
                        i11++;
                    }
                    if (i12 < i8) {
                        this.f4357g[i12] = null;
                    }
                    this.f4362l = i8 - 1;
                    i10--;
                }
                i10++;
            }
            this.f4351a = false;
        }
    }

    private void n() {
        for (int i8 = 0; i8 < this.f4362l; i8++) {
            ArrayRow arrayRow = this.f4357g[i8];
            arrayRow.f4332a.f4413k = arrayRow.f4333b;
        }
    }

    public static ArrayRow s(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f8) {
        return linearSystem.r().j(solverVariable, solverVariable2, f8);
    }

    private int u(Row row) throws Exception {
        boolean z7;
        int i8 = 0;
        while (true) {
            if (i8 < this.f4362l) {
                ArrayRow arrayRow = this.f4357g[i8];
                if (arrayRow.f4332a.f4417o != SolverVariable.Type.UNRESTRICTED && arrayRow.f4333b < 0.0f) {
                    z7 = true;
                    break;
                }
                i8++;
            } else {
                z7 = false;
                break;
            }
        }
        if (z7) {
            boolean z8 = false;
            int i9 = 0;
            while (!z8) {
                Metrics metrics = f4348x;
                if (metrics != null) {
                    metrics.f4379k++;
                }
                i9++;
                float f8 = Float.MAX_VALUE;
                int i10 = -1;
                int i11 = -1;
                int i12 = 0;
                for (int i13 = 0; i13 < this.f4362l; i13++) {
                    ArrayRow arrayRow2 = this.f4357g[i13];
                    if (arrayRow2.f4332a.f4417o != SolverVariable.Type.UNRESTRICTED && !arrayRow2.f4337f && arrayRow2.f4333b < 0.0f) {
                        int i14 = 9;
                        if (f4345u) {
                            int f9 = arrayRow2.f4336e.f();
                            int i15 = 0;
                            while (i15 < f9) {
                                SolverVariable b8 = arrayRow2.f4336e.b(i15);
                                float j8 = arrayRow2.f4336e.j(b8);
                                if (j8 > 0.0f) {
                                    int i16 = 0;
                                    while (i16 < i14) {
                                        float f10 = b8.f4415m[i16] / j8;
                                        if ((f10 < f8 && i16 == i12) || i16 > i12) {
                                            i11 = b8.f4410h;
                                            i12 = i16;
                                            i10 = i13;
                                            f8 = f10;
                                        }
                                        i16++;
                                        i14 = 9;
                                    }
                                }
                                i15++;
                                i14 = 9;
                            }
                        } else {
                            for (int i17 = 1; i17 < this.f4361k; i17++) {
                                SolverVariable solverVariable = this.f4364n.f4341d[i17];
                                float j9 = arrayRow2.f4336e.j(solverVariable);
                                if (j9 > 0.0f) {
                                    for (int i18 = 0; i18 < 9; i18++) {
                                        float f11 = solverVariable.f4415m[i18] / j9;
                                        if ((f11 < f8 && i18 == i12) || i18 > i12) {
                                            i11 = i17;
                                            i12 = i18;
                                            i10 = i13;
                                            f8 = f11;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i10 != -1) {
                    ArrayRow arrayRow3 = this.f4357g[i10];
                    arrayRow3.f4332a.f4411i = -1;
                    Metrics metrics2 = f4348x;
                    if (metrics2 != null) {
                        metrics2.f4378j++;
                    }
                    arrayRow3.x(this.f4364n.f4341d[i11]);
                    SolverVariable solverVariable2 = arrayRow3.f4332a;
                    solverVariable2.f4411i = i10;
                    solverVariable2.l(this, arrayRow3);
                } else {
                    z8 = true;
                }
                if (i9 > this.f4361k / 2) {
                    z8 = true;
                }
            }
            return i9;
        }
        return 0;
    }

    public static Metrics w() {
        return f4348x;
    }

    private void y() {
        int i8 = this.f4355e * 2;
        this.f4355e = i8;
        this.f4357g = (ArrayRow[]) Arrays.copyOf(this.f4357g, i8);
        Cache cache = this.f4364n;
        cache.f4341d = (SolverVariable[]) Arrays.copyOf(cache.f4341d, this.f4355e);
        int i9 = this.f4355e;
        this.f4360j = new boolean[i9];
        this.f4356f = i9;
        this.f4363m = i9;
        Metrics metrics = f4348x;
        if (metrics != null) {
            metrics.f4372d++;
            metrics.f4383o = Math.max(metrics.f4383o, i9);
            Metrics metrics2 = f4348x;
            metrics2.f4393y = metrics2.f4383o;
        }
    }

    void A(Row row) throws Exception {
        Metrics metrics = f4348x;
        if (metrics != null) {
            metrics.f4388t++;
            metrics.f4389u = Math.max(metrics.f4389u, this.f4361k);
            Metrics metrics2 = f4348x;
            metrics2.f4390v = Math.max(metrics2.f4390v, this.f4362l);
        }
        u(row);
        B(row, false);
        n();
    }

    public void D() {
        Cache cache;
        int i8 = 0;
        while (true) {
            cache = this.f4364n;
            SolverVariable[] solverVariableArr = cache.f4341d;
            if (i8 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i8];
            if (solverVariable != null) {
                solverVariable.h();
            }
            i8++;
        }
        cache.f4340c.c(this.f4365o, this.f4366p);
        this.f4366p = 0;
        Arrays.fill(this.f4364n.f4341d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f4353c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f4352b = 0;
        this.f4354d.clear();
        this.f4361k = 1;
        for (int i9 = 0; i9 < this.f4362l; i9++) {
            ArrayRow arrayRow = this.f4357g[i9];
            if (arrayRow != null) {
                arrayRow.f4334c = false;
            }
        }
        C();
        this.f4362l = 0;
        if (f4346v) {
            this.f4367q = new ValuesRow(this.f4364n);
        } else {
            this.f4367q = new ArrayRow(this.f4364n);
        }
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f8, int i8) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable q8 = q(constraintWidget.o(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable q9 = q(constraintWidget.o(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable q10 = q(constraintWidget.o(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable q11 = q(constraintWidget.o(type4));
        SolverVariable q12 = q(constraintWidget2.o(type));
        SolverVariable q13 = q(constraintWidget2.o(type2));
        SolverVariable q14 = q(constraintWidget2.o(type3));
        SolverVariable q15 = q(constraintWidget2.o(type4));
        ArrayRow r7 = r();
        double d8 = f8;
        double d9 = i8;
        r7.q(q9, q11, q13, q15, (float) (Math.sin(d8) * d9));
        d(r7);
        ArrayRow r8 = r();
        r8.q(q8, q10, q12, q14, (float) (Math.cos(d8) * d9));
        d(r8);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, float f8, SolverVariable solverVariable3, SolverVariable solverVariable4, int i9, int i10) {
        ArrayRow r7 = r();
        r7.h(solverVariable, solverVariable2, i8, f8, solverVariable3, solverVariable4, i9);
        if (i10 != 8) {
            r7.d(this, i10);
        }
        d(r7);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            return
        L3:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.f4348x
            r1 = 1
            if (r0 == 0) goto L17
            long r3 = r0.f4374f
            long r3 = r3 + r1
            r0.f4374f = r3
            boolean r3 = r8.f4337f
            if (r3 == 0) goto L17
            long r3 = r0.f4375g
            long r3 = r3 + r1
            r0.f4375g = r3
        L17:
            int r0 = r7.f4362l
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.f4363m
            if (r0 >= r4) goto L26
            int r0 = r7.f4361k
            int r0 = r0 + r3
            int r4 = r7.f4356f
            if (r0 < r4) goto L29
        L26:
            r7.y()
        L29:
            r0 = 0
            boolean r4 = r8.f4337f
            if (r4 != 0) goto La1
            r8.D(r7)
            boolean r4 = r8.isEmpty()
            if (r4 == 0) goto L38
            return
        L38:
            r8.r()
            boolean r4 = r8.f(r7)
            if (r4 == 0) goto L98
            androidx.constraintlayout.core.SolverVariable r4 = r7.p()
            r8.f4332a = r4
            int r5 = r7.f4362l
            r7.l(r8)
            int r6 = r7.f4362l
            int r5 = r5 + r3
            if (r6 != r5) goto L98
            androidx.constraintlayout.core.LinearSystem$Row r0 = r7.f4367q
            r0.a(r8)
            androidx.constraintlayout.core.LinearSystem$Row r0 = r7.f4367q
            r7.B(r0, r3)
            int r0 = r4.f4411i
            r5 = -1
            if (r0 != r5) goto L99
            androidx.constraintlayout.core.SolverVariable r0 = r8.f4332a
            if (r0 != r4) goto L76
            androidx.constraintlayout.core.SolverVariable r0 = r8.v(r4)
            if (r0 == 0) goto L76
            androidx.constraintlayout.core.Metrics r4 = androidx.constraintlayout.core.LinearSystem.f4348x
            if (r4 == 0) goto L73
            long r5 = r4.f4378j
            long r5 = r5 + r1
            r4.f4378j = r5
        L73:
            r8.x(r0)
        L76:
            boolean r0 = r8.f4337f
            if (r0 != 0) goto L7f
            androidx.constraintlayout.core.SolverVariable r0 = r8.f4332a
            r0.l(r7, r8)
        L7f:
            boolean r0 = androidx.constraintlayout.core.LinearSystem.f4346v
            if (r0 == 0) goto L8b
            androidx.constraintlayout.core.Cache r0 = r7.f4364n
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.f4338a
            r0.a(r8)
            goto L92
        L8b:
            androidx.constraintlayout.core.Cache r0 = r7.f4364n
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.f4339b
            r0.a(r8)
        L92:
            int r0 = r7.f4362l
            int r0 = r0 - r3
            r7.f4362l = r0
            goto L99
        L98:
            r3 = 0
        L99:
            boolean r0 = r8.s()
            if (r0 != 0) goto La0
            return
        La0:
            r0 = r3
        La1:
            if (r0 != 0) goto La6
            r7.l(r8)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.d(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow e(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, int i9) {
        if (f4343s && i9 == 8 && solverVariable2.f4414l && solverVariable.f4411i == -1) {
            solverVariable.j(this, solverVariable2.f4413k + i8);
            return null;
        }
        ArrayRow r7 = r();
        r7.n(solverVariable, solverVariable2, i8);
        if (i9 != 8) {
            r7.d(this, i9);
        }
        d(r7);
        return r7;
    }

    public void f(SolverVariable solverVariable, int i8) {
        if (f4343s && solverVariable.f4411i == -1) {
            float f8 = i8;
            solverVariable.j(this, f8);
            for (int i9 = 0; i9 < this.f4352b + 1; i9++) {
                SolverVariable solverVariable2 = this.f4364n.f4341d[i9];
                if (solverVariable2 != null && solverVariable2.f4421s && solverVariable2.f4422t == solverVariable.f4410h) {
                    solverVariable2.j(this, solverVariable2.f4423u + f8);
                }
            }
            return;
        }
        int i10 = solverVariable.f4411i;
        if (i10 != -1) {
            ArrayRow arrayRow = this.f4357g[i10];
            if (arrayRow.f4337f) {
                arrayRow.f4333b = i8;
                return;
            } else if (arrayRow.f4336e.f() == 0) {
                arrayRow.f4337f = true;
                arrayRow.f4333b = i8;
                return;
            } else {
                ArrayRow r7 = r();
                r7.m(solverVariable, i8);
                d(r7);
                return;
            }
        }
        ArrayRow r8 = r();
        r8.i(solverVariable, i8);
        d(r8);
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, boolean z7) {
        ArrayRow r7 = r();
        SolverVariable t7 = t();
        t7.f4412j = 0;
        r7.o(solverVariable, solverVariable2, t7, i8);
        d(r7);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, int i9) {
        ArrayRow r7 = r();
        SolverVariable t7 = t();
        t7.f4412j = 0;
        r7.o(solverVariable, solverVariable2, t7, i8);
        if (i9 != 8) {
            m(r7, (int) (r7.f4336e.j(t7) * (-1.0f)), i9);
        }
        d(r7);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, boolean z7) {
        ArrayRow r7 = r();
        SolverVariable t7 = t();
        t7.f4412j = 0;
        r7.p(solverVariable, solverVariable2, t7, i8);
        d(r7);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, int i9) {
        ArrayRow r7 = r();
        SolverVariable t7 = t();
        t7.f4412j = 0;
        r7.p(solverVariable, solverVariable2, t7, i8);
        if (i9 != 8) {
            m(r7, (int) (r7.f4336e.j(t7) * (-1.0f)), i9);
        }
        d(r7);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f8, int i8) {
        ArrayRow r7 = r();
        r7.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f8);
        if (i8 != 8) {
            r7.d(this, i8);
        }
        d(r7);
    }

    void m(ArrayRow arrayRow, int i8, int i9) {
        arrayRow.e(o(i9, null), i8);
    }

    public SolverVariable o(int i8, String str) {
        Metrics metrics = f4348x;
        if (metrics != null) {
            metrics.f4380l++;
        }
        if (this.f4361k + 1 >= this.f4356f) {
            y();
        }
        SolverVariable a8 = a(SolverVariable.Type.ERROR, str);
        int i9 = this.f4352b + 1;
        this.f4352b = i9;
        this.f4361k++;
        a8.f4410h = i9;
        a8.f4412j = i8;
        this.f4364n.f4341d[i9] = a8;
        this.f4354d.c(a8);
        return a8;
    }

    public SolverVariable p() {
        Metrics metrics = f4348x;
        if (metrics != null) {
            metrics.f4382n++;
        }
        if (this.f4361k + 1 >= this.f4356f) {
            y();
        }
        SolverVariable a8 = a(SolverVariable.Type.SLACK, null);
        int i8 = this.f4352b + 1;
        this.f4352b = i8;
        this.f4361k++;
        a8.f4410h = i8;
        this.f4364n.f4341d[i8] = a8;
        return a8;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f4361k + 1 >= this.f4356f) {
            y();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.i();
            if (solverVariable == null) {
                constraintAnchor.s(this.f4364n);
                solverVariable = constraintAnchor.i();
            }
            int i8 = solverVariable.f4410h;
            if (i8 == -1 || i8 > this.f4352b || this.f4364n.f4341d[i8] == null) {
                if (i8 != -1) {
                    solverVariable.h();
                }
                int i9 = this.f4352b + 1;
                this.f4352b = i9;
                this.f4361k++;
                solverVariable.f4410h = i9;
                solverVariable.f4417o = SolverVariable.Type.UNRESTRICTED;
                this.f4364n.f4341d[i9] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow r() {
        ArrayRow b8;
        if (f4346v) {
            b8 = this.f4364n.f4338a.b();
            if (b8 == null) {
                b8 = new ValuesRow(this.f4364n);
                f4350z++;
            } else {
                b8.y();
            }
        } else {
            b8 = this.f4364n.f4339b.b();
            if (b8 == null) {
                b8 = new ArrayRow(this.f4364n);
                f4349y++;
            } else {
                b8.y();
            }
        }
        SolverVariable.e();
        return b8;
    }

    public SolverVariable t() {
        Metrics metrics = f4348x;
        if (metrics != null) {
            metrics.f4381m++;
        }
        if (this.f4361k + 1 >= this.f4356f) {
            y();
        }
        SolverVariable a8 = a(SolverVariable.Type.SLACK, null);
        int i8 = this.f4352b + 1;
        this.f4352b = i8;
        this.f4361k++;
        a8.f4410h = i8;
        this.f4364n.f4341d[i8] = a8;
        return a8;
    }

    public Cache v() {
        return this.f4364n;
    }

    public int x(Object obj) {
        SolverVariable i8 = ((ConstraintAnchor) obj).i();
        if (i8 != null) {
            return (int) (i8.f4413k + 0.5f);
        }
        return 0;
    }

    public void z() throws Exception {
        Metrics metrics = f4348x;
        if (metrics != null) {
            metrics.f4373e++;
        }
        if (this.f4354d.isEmpty()) {
            n();
        } else if (!this.f4358h && !this.f4359i) {
            A(this.f4354d);
        } else {
            Metrics metrics2 = f4348x;
            if (metrics2 != null) {
                metrics2.f4385q++;
            }
            boolean z7 = false;
            int i8 = 0;
            while (true) {
                if (i8 < this.f4362l) {
                    if (!this.f4357g[i8].f4337f) {
                        break;
                    }
                    i8++;
                } else {
                    z7 = true;
                    break;
                }
            }
            if (!z7) {
                A(this.f4354d);
                return;
            }
            Metrics metrics3 = f4348x;
            if (metrics3 != null) {
                metrics3.f4384p++;
            }
            n();
        }
    }
}
