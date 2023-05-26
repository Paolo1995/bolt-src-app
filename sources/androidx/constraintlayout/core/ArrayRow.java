package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {

    /* renamed from: e  reason: collision with root package name */
    public ArrayRowVariables f4336e;

    /* renamed from: a  reason: collision with root package name */
    SolverVariable f4332a = null;

    /* renamed from: b  reason: collision with root package name */
    float f4333b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f4334c = false;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<SolverVariable> f4335d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    boolean f4337f = false;

    /* loaded from: classes.dex */
    public interface ArrayRowVariables {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i8);

        void c(SolverVariable solverVariable, float f8, boolean z7);

        void clear();

        void d();

        float e(SolverVariable solverVariable, boolean z7);

        int f();

        float g(ArrayRow arrayRow, boolean z7);

        void h(SolverVariable solverVariable, float f8);

        float i(int i8);

        float j(SolverVariable solverVariable);

        void k(float f8);
    }

    public ArrayRow() {
    }

    private boolean u(SolverVariable solverVariable, LinearSystem linearSystem) {
        if (solverVariable.f4420r <= 1) {
            return true;
        }
        return false;
    }

    private SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int f8 = this.f4336e.f();
        SolverVariable solverVariable2 = null;
        float f9 = 0.0f;
        for (int i8 = 0; i8 < f8; i8++) {
            float i9 = this.f4336e.i(i8);
            if (i9 < 0.0f) {
                SolverVariable b8 = this.f4336e.b(i8);
                if ((zArr == null || !zArr[b8.f4410h]) && b8 != solverVariable && (((type = b8.f4417o) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && i9 < f9)) {
                    f9 = i9;
                    solverVariable2 = b8;
                }
            }
        }
        return solverVariable2;
    }

    public void A(LinearSystem linearSystem, SolverVariable solverVariable, boolean z7) {
        if (solverVariable != null && solverVariable.f4414l) {
            this.f4333b += solverVariable.f4413k * this.f4336e.j(solverVariable);
            this.f4336e.e(solverVariable, z7);
            if (z7) {
                solverVariable.f(this);
            }
            if (LinearSystem.f4344t && this.f4336e.f() == 0) {
                this.f4337f = true;
                linearSystem.f4351a = true;
            }
        }
    }

    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z7) {
        this.f4333b += arrayRow.f4333b * this.f4336e.g(arrayRow, z7);
        if (z7) {
            arrayRow.f4332a.f(this);
        }
        if (LinearSystem.f4344t && this.f4332a != null && this.f4336e.f() == 0) {
            this.f4337f = true;
            linearSystem.f4351a = true;
        }
    }

    public void C(LinearSystem linearSystem, SolverVariable solverVariable, boolean z7) {
        if (solverVariable != null && solverVariable.f4421s) {
            float j8 = this.f4336e.j(solverVariable);
            this.f4333b += solverVariable.f4423u * j8;
            this.f4336e.e(solverVariable, z7);
            if (z7) {
                solverVariable.f(this);
            }
            this.f4336e.c(linearSystem.f4364n.f4341d[solverVariable.f4422t], j8, z7);
            if (LinearSystem.f4344t && this.f4336e.f() == 0) {
                this.f4337f = true;
                linearSystem.f4351a = true;
            }
        }
    }

    public void D(LinearSystem linearSystem) {
        if (linearSystem.f4357g.length == 0) {
            return;
        }
        boolean z7 = false;
        while (!z7) {
            int f8 = this.f4336e.f();
            for (int i8 = 0; i8 < f8; i8++) {
                SolverVariable b8 = this.f4336e.b(i8);
                if (b8.f4411i != -1 || b8.f4414l || b8.f4421s) {
                    this.f4335d.add(b8);
                }
            }
            int size = this.f4335d.size();
            if (size > 0) {
                for (int i9 = 0; i9 < size; i9++) {
                    SolverVariable solverVariable = this.f4335d.get(i9);
                    if (solverVariable.f4414l) {
                        A(linearSystem, solverVariable, true);
                    } else if (solverVariable.f4421s) {
                        C(linearSystem, solverVariable, true);
                    } else {
                        B(linearSystem, linearSystem.f4357g[solverVariable.f4411i], true);
                    }
                }
                this.f4335d.clear();
            } else {
                z7 = true;
            }
        }
        if (LinearSystem.f4344t && this.f4332a != null && this.f4336e.f() == 0) {
            this.f4337f = true;
            linearSystem.f4351a = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void a(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.f4332a = null;
            this.f4336e.clear();
            for (int i8 = 0; i8 < arrayRow.f4336e.f(); i8++) {
                this.f4336e.c(arrayRow.f4336e.b(i8), arrayRow.f4336e.i(i8), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable b(LinearSystem linearSystem, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void c(SolverVariable solverVariable) {
        int i8 = solverVariable.f4412j;
        float f8 = 1.0f;
        if (i8 != 1) {
            if (i8 == 2) {
                f8 = 1000.0f;
            } else if (i8 == 3) {
                f8 = 1000000.0f;
            } else if (i8 == 4) {
                f8 = 1.0E9f;
            } else if (i8 == 5) {
                f8 = 1.0E12f;
            }
        }
        this.f4336e.h(solverVariable, f8);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.f4336e.clear();
        this.f4332a = null;
        this.f4333b = 0.0f;
    }

    public ArrayRow d(LinearSystem linearSystem, int i8) {
        this.f4336e.h(linearSystem.o(i8, "ep"), 1.0f);
        this.f4336e.h(linearSystem.o(i8, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow e(SolverVariable solverVariable, int i8) {
        this.f4336e.h(solverVariable, i8);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(LinearSystem linearSystem) {
        boolean z7;
        SolverVariable g8 = g(linearSystem);
        if (g8 == null) {
            z7 = true;
        } else {
            x(g8);
            z7 = false;
        }
        if (this.f4336e.f() == 0) {
            this.f4337f = true;
        }
        return z7;
    }

    SolverVariable g(LinearSystem linearSystem) {
        boolean u7;
        boolean u8;
        int f8 = this.f4336e.f();
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        boolean z7 = false;
        boolean z8 = false;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i8 = 0; i8 < f8; i8++) {
            float i9 = this.f4336e.i(i8);
            SolverVariable b8 = this.f4336e.b(i8);
            if (b8.f4417o == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    u8 = u(b8, linearSystem);
                } else if (f9 > i9) {
                    u8 = u(b8, linearSystem);
                } else if (!z7 && u(b8, linearSystem)) {
                    f9 = i9;
                    solverVariable = b8;
                    z7 = true;
                }
                z7 = u8;
                f9 = i9;
                solverVariable = b8;
            } else if (solverVariable == null && i9 < 0.0f) {
                if (solverVariable2 == null) {
                    u7 = u(b8, linearSystem);
                } else if (f10 > i9) {
                    u7 = u(b8, linearSystem);
                } else if (!z8 && u(b8, linearSystem)) {
                    f10 = i9;
                    solverVariable2 = b8;
                    z8 = true;
                }
                z8 = u7;
                f10 = i9;
                solverVariable2 = b8;
            }
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.f4332a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow h(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, float f8, SolverVariable solverVariable3, SolverVariable solverVariable4, int i9) {
        if (solverVariable2 == solverVariable3) {
            this.f4336e.h(solverVariable, 1.0f);
            this.f4336e.h(solverVariable4, 1.0f);
            this.f4336e.h(solverVariable2, -2.0f);
            return this;
        }
        if (f8 == 0.5f) {
            this.f4336e.h(solverVariable, 1.0f);
            this.f4336e.h(solverVariable2, -1.0f);
            this.f4336e.h(solverVariable3, -1.0f);
            this.f4336e.h(solverVariable4, 1.0f);
            if (i8 > 0 || i9 > 0) {
                this.f4333b = (-i8) + i9;
            }
        } else if (f8 <= 0.0f) {
            this.f4336e.h(solverVariable, -1.0f);
            this.f4336e.h(solverVariable2, 1.0f);
            this.f4333b = i8;
        } else if (f8 >= 1.0f) {
            this.f4336e.h(solverVariable4, -1.0f);
            this.f4336e.h(solverVariable3, 1.0f);
            this.f4333b = -i9;
        } else {
            float f9 = 1.0f - f8;
            this.f4336e.h(solverVariable, f9 * 1.0f);
            this.f4336e.h(solverVariable2, f9 * (-1.0f));
            this.f4336e.h(solverVariable3, (-1.0f) * f8);
            this.f4336e.h(solverVariable4, 1.0f * f8);
            if (i8 > 0 || i9 > 0) {
                this.f4333b = ((-i8) * f9) + (i9 * f8);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow i(SolverVariable solverVariable, int i8) {
        this.f4332a = solverVariable;
        float f8 = i8;
        solverVariable.f4413k = f8;
        this.f4333b = f8;
        this.f4337f = true;
        return this;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.f4332a == null && this.f4333b == 0.0f && this.f4336e.f() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow j(SolverVariable solverVariable, SolverVariable solverVariable2, float f8) {
        this.f4336e.h(solverVariable, -1.0f);
        this.f4336e.h(solverVariable2, f8);
        return this;
    }

    public ArrayRow k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f8) {
        this.f4336e.h(solverVariable, -1.0f);
        this.f4336e.h(solverVariable2, 1.0f);
        this.f4336e.h(solverVariable3, f8);
        this.f4336e.h(solverVariable4, -f8);
        return this;
    }

    public ArrayRow l(float f8, float f9, float f10, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f4333b = 0.0f;
        if (f9 != 0.0f && f8 != f10) {
            if (f8 == 0.0f) {
                this.f4336e.h(solverVariable, 1.0f);
                this.f4336e.h(solverVariable2, -1.0f);
            } else if (f10 == 0.0f) {
                this.f4336e.h(solverVariable3, 1.0f);
                this.f4336e.h(solverVariable4, -1.0f);
            } else {
                float f11 = (f8 / f9) / (f10 / f9);
                this.f4336e.h(solverVariable, 1.0f);
                this.f4336e.h(solverVariable2, -1.0f);
                this.f4336e.h(solverVariable4, f11);
                this.f4336e.h(solverVariable3, -f11);
            }
        } else {
            this.f4336e.h(solverVariable, 1.0f);
            this.f4336e.h(solverVariable2, -1.0f);
            this.f4336e.h(solverVariable4, 1.0f);
            this.f4336e.h(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow m(SolverVariable solverVariable, int i8) {
        if (i8 < 0) {
            this.f4333b = i8 * (-1);
            this.f4336e.h(solverVariable, 1.0f);
        } else {
            this.f4333b = i8;
            this.f4336e.h(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow n(SolverVariable solverVariable, SolverVariable solverVariable2, int i8) {
        boolean z7 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z7 = true;
            }
            this.f4333b = i8;
        }
        if (!z7) {
            this.f4336e.h(solverVariable, -1.0f);
            this.f4336e.h(solverVariable2, 1.0f);
        } else {
            this.f4336e.h(solverVariable, 1.0f);
            this.f4336e.h(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i8) {
        boolean z7 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z7 = true;
            }
            this.f4333b = i8;
        }
        if (!z7) {
            this.f4336e.h(solverVariable, -1.0f);
            this.f4336e.h(solverVariable2, 1.0f);
            this.f4336e.h(solverVariable3, 1.0f);
        } else {
            this.f4336e.h(solverVariable, 1.0f);
            this.f4336e.h(solverVariable2, -1.0f);
            this.f4336e.h(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i8) {
        boolean z7 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z7 = true;
            }
            this.f4333b = i8;
        }
        if (!z7) {
            this.f4336e.h(solverVariable, -1.0f);
            this.f4336e.h(solverVariable2, 1.0f);
            this.f4336e.h(solverVariable3, -1.0f);
        } else {
            this.f4336e.h(solverVariable, 1.0f);
            this.f4336e.h(solverVariable2, -1.0f);
            this.f4336e.h(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f8) {
        this.f4336e.h(solverVariable3, 0.5f);
        this.f4336e.h(solverVariable4, 0.5f);
        this.f4336e.h(solverVariable, -0.5f);
        this.f4336e.h(solverVariable2, -0.5f);
        this.f4333b = -f8;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f8 = this.f4333b;
        if (f8 < 0.0f) {
            this.f4333b = f8 * (-1.0f);
            this.f4336e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        SolverVariable solverVariable = this.f4332a;
        if (solverVariable != null && (solverVariable.f4417o == SolverVariable.Type.UNRESTRICTED || this.f4333b >= 0.0f)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(SolverVariable solverVariable) {
        return this.f4336e.a(solverVariable);
    }

    public String toString() {
        return z();
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f4332a;
        if (solverVariable2 != null) {
            this.f4336e.h(solverVariable2, -1.0f);
            this.f4332a.f4411i = -1;
            this.f4332a = null;
        }
        float e8 = this.f4336e.e(solverVariable, true) * (-1.0f);
        this.f4332a = solverVariable;
        if (e8 == 1.0f) {
            return;
        }
        this.f4333b /= e8;
        this.f4336e.k(e8);
    }

    public void y() {
        this.f4332a = null;
        this.f4336e.clear();
        this.f4333b = 0.0f;
        this.f4337f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String z() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.z():java.lang.String");
    }

    public ArrayRow(Cache cache) {
        this.f4336e = new ArrayLinkedVariables(this, cache);
    }
}
