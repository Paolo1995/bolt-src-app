package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {

    /* renamed from: g  reason: collision with root package name */
    private int f4397g;

    /* renamed from: h  reason: collision with root package name */
    private SolverVariable[] f4398h;

    /* renamed from: i  reason: collision with root package name */
    private SolverVariable[] f4399i;

    /* renamed from: j  reason: collision with root package name */
    private int f4400j;

    /* renamed from: k  reason: collision with root package name */
    GoalVariableAccessor f4401k;

    /* renamed from: l  reason: collision with root package name */
    Cache f4402l;

    /* loaded from: classes.dex */
    class GoalVariableAccessor {

        /* renamed from: a  reason: collision with root package name */
        SolverVariable f4404a;

        /* renamed from: b  reason: collision with root package name */
        PriorityGoalRow f4405b;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.f4405b = priorityGoalRow;
        }

        public boolean a(SolverVariable solverVariable, float f8) {
            boolean z7 = true;
            if (this.f4404a.f4408f) {
                for (int i8 = 0; i8 < 9; i8++) {
                    float[] fArr = this.f4404a.f4416n;
                    float f9 = fArr[i8] + (solverVariable.f4416n[i8] * f8);
                    fArr[i8] = f9;
                    if (Math.abs(f9) < 1.0E-4f) {
                        this.f4404a.f4416n[i8] = 0.0f;
                    } else {
                        z7 = false;
                    }
                }
                if (z7) {
                    PriorityGoalRow.this.G(this.f4404a);
                }
                return false;
            }
            for (int i9 = 0; i9 < 9; i9++) {
                float f10 = solverVariable.f4416n[i9];
                if (f10 != 0.0f) {
                    float f11 = f10 * f8;
                    if (Math.abs(f11) < 1.0E-4f) {
                        f11 = 0.0f;
                    }
                    this.f4404a.f4416n[i9] = f11;
                } else {
                    this.f4404a.f4416n[i9] = 0.0f;
                }
            }
            return true;
        }

        public void b(SolverVariable solverVariable) {
            this.f4404a = solverVariable;
        }

        public final boolean c() {
            for (int i8 = 8; i8 >= 0; i8--) {
                float f8 = this.f4404a.f4416n[i8];
                if (f8 > 0.0f) {
                    return false;
                }
                if (f8 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i8 = 8;
            while (true) {
                if (i8 < 0) {
                    break;
                }
                float f8 = solverVariable.f4416n[i8];
                float f9 = this.f4404a.f4416n[i8];
                if (f9 == f8) {
                    i8--;
                } else if (f9 < f8) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f4404a.f4416n, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f4404a != null) {
                for (int i8 = 0; i8 < 9; i8++) {
                    str = str + this.f4404a.f4416n[i8] + " ";
                }
            }
            return str + "] " + this.f4404a;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.f4397g = 128;
        this.f4398h = new SolverVariable[128];
        this.f4399i = new SolverVariable[128];
        this.f4400j = 0;
        this.f4401k = new GoalVariableAccessor(this);
        this.f4402l = cache;
    }

    private final void F(SolverVariable solverVariable) {
        int i8;
        int i9 = this.f4400j + 1;
        SolverVariable[] solverVariableArr = this.f4398h;
        if (i9 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f4398h = solverVariableArr2;
            this.f4399i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f4398h;
        int i10 = this.f4400j;
        solverVariableArr3[i10] = solverVariable;
        int i11 = i10 + 1;
        this.f4400j = i11;
        if (i11 > 1 && solverVariableArr3[i11 - 1].f4410h > solverVariable.f4410h) {
            int i12 = 0;
            while (true) {
                i8 = this.f4400j;
                if (i12 >= i8) {
                    break;
                }
                this.f4399i[i12] = this.f4398h[i12];
                i12++;
            }
            Arrays.sort(this.f4399i, 0, i8, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f4410h - solverVariable3.f4410h;
                }
            });
            for (int i13 = 0; i13 < this.f4400j; i13++) {
                this.f4398h[i13] = this.f4399i[i13];
            }
        }
        solverVariable.f4408f = true;
        solverVariable.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(SolverVariable solverVariable) {
        int i8 = 0;
        while (i8 < this.f4400j) {
            if (this.f4398h[i8] == solverVariable) {
                while (true) {
                    int i9 = this.f4400j;
                    if (i8 < i9 - 1) {
                        SolverVariable[] solverVariableArr = this.f4398h;
                        int i10 = i8 + 1;
                        solverVariableArr[i8] = solverVariableArr[i10];
                        i8 = i10;
                    } else {
                        this.f4400j = i9 - 1;
                        solverVariable.f4408f = false;
                        return;
                    }
                }
            } else {
                i8++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z7) {
        SolverVariable solverVariable = arrayRow.f4332a;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f4336e;
        int f8 = arrayRowVariables.f();
        for (int i8 = 0; i8 < f8; i8++) {
            SolverVariable b8 = arrayRowVariables.b(i8);
            float i9 = arrayRowVariables.i(i8);
            this.f4401k.b(b8);
            if (this.f4401k.a(solverVariable, i9)) {
                F(b8);
            }
            this.f4333b += arrayRow.f4333b * i9;
        }
        G(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable b(LinearSystem linearSystem, boolean[] zArr) {
        int i8 = -1;
        for (int i9 = 0; i9 < this.f4400j; i9++) {
            SolverVariable solverVariable = this.f4398h[i9];
            if (!zArr[solverVariable.f4410h]) {
                this.f4401k.b(solverVariable);
                if (i8 == -1) {
                    if (!this.f4401k.c()) {
                    }
                    i8 = i9;
                } else {
                    if (!this.f4401k.d(this.f4398h[i8])) {
                    }
                    i8 = i9;
                }
            }
        }
        if (i8 == -1) {
            return null;
        }
        return this.f4398h[i8];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void c(SolverVariable solverVariable) {
        this.f4401k.b(solverVariable);
        this.f4401k.e();
        solverVariable.f4416n[solverVariable.f4412j] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.f4400j = 0;
        this.f4333b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.f4400j == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.f4333b + ") : ";
        for (int i8 = 0; i8 < this.f4400j; i8++) {
            this.f4401k.b(this.f4398h[i8]);
            str = str + this.f4401k + " ";
        }
        return str;
    }
}
