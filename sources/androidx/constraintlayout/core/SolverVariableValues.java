package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {

    /* renamed from: n  reason: collision with root package name */
    private static float f4431n = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    private final int f4432a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f4433b = 16;

    /* renamed from: c  reason: collision with root package name */
    private int f4434c = 16;

    /* renamed from: d  reason: collision with root package name */
    int[] f4435d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    int[] f4436e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    int[] f4437f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    float[] f4438g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    int[] f4439h = new int[16];

    /* renamed from: i  reason: collision with root package name */
    int[] f4440i = new int[16];

    /* renamed from: j  reason: collision with root package name */
    int f4441j = 0;

    /* renamed from: k  reason: collision with root package name */
    int f4442k = -1;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayRow f4443l;

    /* renamed from: m  reason: collision with root package name */
    protected final Cache f4444m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.f4443l = arrayRow;
        this.f4444m = cache;
        clear();
    }

    private void l(SolverVariable solverVariable, int i8) {
        int[] iArr;
        int i9 = solverVariable.f4410h % this.f4434c;
        int[] iArr2 = this.f4435d;
        int i10 = iArr2[i9];
        if (i10 == -1) {
            iArr2[i9] = i8;
        } else {
            while (true) {
                iArr = this.f4436e;
                int i11 = iArr[i10];
                if (i11 == -1) {
                    break;
                }
                i10 = i11;
            }
            iArr[i10] = i8;
        }
        this.f4436e[i8] = -1;
    }

    private void m(int i8, SolverVariable solverVariable, float f8) {
        this.f4437f[i8] = solverVariable.f4410h;
        this.f4438g[i8] = f8;
        this.f4439h[i8] = -1;
        this.f4440i[i8] = -1;
        solverVariable.a(this.f4443l);
        solverVariable.f4420r++;
        this.f4441j++;
    }

    private int n() {
        for (int i8 = 0; i8 < this.f4433b; i8++) {
            if (this.f4437f[i8] == -1) {
                return i8;
            }
        }
        return -1;
    }

    private void o() {
        int i8 = this.f4433b * 2;
        this.f4437f = Arrays.copyOf(this.f4437f, i8);
        this.f4438g = Arrays.copyOf(this.f4438g, i8);
        this.f4439h = Arrays.copyOf(this.f4439h, i8);
        this.f4440i = Arrays.copyOf(this.f4440i, i8);
        this.f4436e = Arrays.copyOf(this.f4436e, i8);
        for (int i9 = this.f4433b; i9 < i8; i9++) {
            this.f4437f[i9] = -1;
            this.f4436e[i9] = -1;
        }
        this.f4433b = i8;
    }

    private void q(int i8, SolverVariable solverVariable, float f8) {
        int n8 = n();
        m(n8, solverVariable, f8);
        if (i8 != -1) {
            this.f4439h[n8] = i8;
            int[] iArr = this.f4440i;
            iArr[n8] = iArr[i8];
            iArr[i8] = n8;
        } else {
            this.f4439h[n8] = -1;
            if (this.f4441j > 0) {
                this.f4440i[n8] = this.f4442k;
                this.f4442k = n8;
            } else {
                this.f4440i[n8] = -1;
            }
        }
        int i9 = this.f4440i[n8];
        if (i9 != -1) {
            this.f4439h[i9] = n8;
        }
        l(solverVariable, n8);
    }

    private void r(SolverVariable solverVariable) {
        int[] iArr;
        int i8;
        int i9 = solverVariable.f4410h;
        int i10 = i9 % this.f4434c;
        int[] iArr2 = this.f4435d;
        int i11 = iArr2[i10];
        if (i11 == -1) {
            return;
        }
        if (this.f4437f[i11] == i9) {
            int[] iArr3 = this.f4436e;
            iArr2[i10] = iArr3[i11];
            iArr3[i11] = -1;
            return;
        }
        while (true) {
            iArr = this.f4436e;
            i8 = iArr[i11];
            if (i8 == -1 || this.f4437f[i8] == i9) {
                break;
            }
            i11 = i8;
        }
        if (i8 != -1 && this.f4437f[i8] == i9) {
            iArr[i11] = iArr[i8];
            iArr[i8] = -1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean a(SolverVariable solverVariable) {
        if (p(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable b(int i8) {
        int i9 = this.f4441j;
        if (i9 == 0) {
            return null;
        }
        int i10 = this.f4442k;
        for (int i11 = 0; i11 < i9; i11++) {
            if (i11 == i8 && i10 != -1) {
                return this.f4444m.f4341d[this.f4437f[i10]];
            }
            i10 = this.f4440i[i10];
            if (i10 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void c(SolverVariable solverVariable, float f8, boolean z7) {
        float f9 = f4431n;
        if (f8 > (-f9) && f8 < f9) {
            return;
        }
        int p8 = p(solverVariable);
        if (p8 == -1) {
            h(solverVariable, f8);
            return;
        }
        float[] fArr = this.f4438g;
        float f10 = fArr[p8] + f8;
        fArr[p8] = f10;
        float f11 = f4431n;
        if (f10 > (-f11) && f10 < f11) {
            fArr[p8] = 0.0f;
            e(solverVariable, z7);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i8 = this.f4441j;
        for (int i9 = 0; i9 < i8; i9++) {
            SolverVariable b8 = b(i9);
            if (b8 != null) {
                b8.f(this.f4443l);
            }
        }
        for (int i10 = 0; i10 < this.f4433b; i10++) {
            this.f4437f[i10] = -1;
            this.f4436e[i10] = -1;
        }
        for (int i11 = 0; i11 < this.f4434c; i11++) {
            this.f4435d[i11] = -1;
        }
        this.f4441j = 0;
        this.f4442k = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void d() {
        int i8 = this.f4441j;
        int i9 = this.f4442k;
        for (int i10 = 0; i10 < i8; i10++) {
            float[] fArr = this.f4438g;
            fArr[i9] = fArr[i9] * (-1.0f);
            i9 = this.f4440i[i9];
            if (i9 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float e(SolverVariable solverVariable, boolean z7) {
        int p8 = p(solverVariable);
        if (p8 == -1) {
            return 0.0f;
        }
        r(solverVariable);
        float f8 = this.f4438g[p8];
        if (this.f4442k == p8) {
            this.f4442k = this.f4440i[p8];
        }
        this.f4437f[p8] = -1;
        int[] iArr = this.f4439h;
        int i8 = iArr[p8];
        if (i8 != -1) {
            int[] iArr2 = this.f4440i;
            iArr2[i8] = iArr2[p8];
        }
        int i9 = this.f4440i[p8];
        if (i9 != -1) {
            iArr[i9] = iArr[p8];
        }
        this.f4441j--;
        solverVariable.f4420r--;
        if (z7) {
            solverVariable.f(this.f4443l);
        }
        return f8;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int f() {
        return this.f4441j;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float g(ArrayRow arrayRow, boolean z7) {
        float j8 = j(arrayRow.f4332a);
        e(arrayRow.f4332a, z7);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.f4336e;
        int f8 = solverVariableValues.f();
        int i8 = 0;
        int i9 = 0;
        while (i8 < f8) {
            int i10 = solverVariableValues.f4437f[i9];
            if (i10 != -1) {
                c(this.f4444m.f4341d[i10], solverVariableValues.f4438g[i9] * j8, z7);
                i8++;
            }
            i9++;
        }
        return j8;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void h(SolverVariable solverVariable, float f8) {
        float f9 = f4431n;
        if (f8 > (-f9) && f8 < f9) {
            e(solverVariable, true);
            return;
        }
        if (this.f4441j == 0) {
            m(0, solverVariable, f8);
            l(solverVariable, 0);
            this.f4442k = 0;
            return;
        }
        int p8 = p(solverVariable);
        if (p8 != -1) {
            this.f4438g[p8] = f8;
            return;
        }
        if (this.f4441j + 1 >= this.f4433b) {
            o();
        }
        int i8 = this.f4441j;
        int i9 = this.f4442k;
        int i10 = -1;
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = this.f4437f[i9];
            int i13 = solverVariable.f4410h;
            if (i12 == i13) {
                this.f4438g[i9] = f8;
                return;
            }
            if (i12 < i13) {
                i10 = i9;
            }
            i9 = this.f4440i[i9];
            if (i9 == -1) {
                break;
            }
        }
        q(i10, solverVariable, f8);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float i(int i8) {
        int i9 = this.f4441j;
        int i10 = this.f4442k;
        for (int i11 = 0; i11 < i9; i11++) {
            if (i11 == i8) {
                return this.f4438g[i10];
            }
            i10 = this.f4440i[i10];
            if (i10 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float j(SolverVariable solverVariable) {
        int p8 = p(solverVariable);
        if (p8 != -1) {
            return this.f4438g[p8];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void k(float f8) {
        int i8 = this.f4441j;
        int i9 = this.f4442k;
        for (int i10 = 0; i10 < i8; i10++) {
            float[] fArr = this.f4438g;
            fArr[i9] = fArr[i9] / f8;
            i9 = this.f4440i[i9];
            if (i9 == -1) {
                return;
            }
        }
    }

    public int p(SolverVariable solverVariable) {
        if (this.f4441j != 0 && solverVariable != null) {
            int i8 = solverVariable.f4410h;
            int i9 = this.f4435d[i8 % this.f4434c];
            if (i9 == -1) {
                return -1;
            }
            if (this.f4437f[i9] == i8) {
                return i9;
            }
            do {
                i9 = this.f4436e[i9];
                if (i9 == -1) {
                    break;
                }
            } while (this.f4437f[i9] != i8);
            if (i9 != -1 && this.f4437f[i9] == i8) {
                return i9;
            }
        }
        return -1;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i8 = this.f4441j;
        for (int i9 = 0; i9 < i8; i9++) {
            SolverVariable b8 = b(i9);
            if (b8 != null) {
                String str4 = str3 + b8 + " = " + i(i9) + " ";
                int p8 = p(b8);
                String str5 = str4 + "[p: ";
                if (this.f4439h[p8] != -1) {
                    str = str5 + this.f4444m.f4341d[this.f4437f[this.f4439h[p8]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f4440i[p8] != -1) {
                    str2 = str6 + this.f4444m.f4341d[this.f4437f[this.f4440i[p8]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }
}
