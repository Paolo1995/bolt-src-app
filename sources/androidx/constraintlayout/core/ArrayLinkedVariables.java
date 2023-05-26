package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {

    /* renamed from: l  reason: collision with root package name */
    private static float f4320l = 0.001f;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayRow f4322b;

    /* renamed from: c  reason: collision with root package name */
    protected final Cache f4323c;

    /* renamed from: a  reason: collision with root package name */
    int f4321a = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f4324d = 8;

    /* renamed from: e  reason: collision with root package name */
    private SolverVariable f4325e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f4326f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f4327g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f4328h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f4329i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f4330j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4331k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f4322b = arrayRow;
        this.f4323c = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean a(SolverVariable solverVariable) {
        int i8 = this.f4329i;
        if (i8 == -1) {
            return false;
        }
        for (int i9 = 0; i8 != -1 && i9 < this.f4321a; i9++) {
            if (this.f4326f[i8] == solverVariable.f4410h) {
                return true;
            }
            i8 = this.f4327g[i8];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable b(int i8) {
        int i9 = this.f4329i;
        for (int i10 = 0; i9 != -1 && i10 < this.f4321a; i10++) {
            if (i10 == i8) {
                return this.f4323c.f4341d[this.f4326f[i9]];
            }
            i9 = this.f4327g[i9];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void c(SolverVariable solverVariable, float f8, boolean z7) {
        float f9 = f4320l;
        if (f8 > (-f9) && f8 < f9) {
            return;
        }
        int i8 = this.f4329i;
        if (i8 == -1) {
            this.f4329i = 0;
            this.f4328h[0] = f8;
            this.f4326f[0] = solverVariable.f4410h;
            this.f4327g[0] = -1;
            solverVariable.f4420r++;
            solverVariable.a(this.f4322b);
            this.f4321a++;
            if (!this.f4331k) {
                int i9 = this.f4330j + 1;
                this.f4330j = i9;
                int[] iArr = this.f4326f;
                if (i9 >= iArr.length) {
                    this.f4331k = true;
                    this.f4330j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i10 = -1;
        for (int i11 = 0; i8 != -1 && i11 < this.f4321a; i11++) {
            int i12 = this.f4326f[i8];
            int i13 = solverVariable.f4410h;
            if (i12 == i13) {
                float[] fArr = this.f4328h;
                float f10 = fArr[i8] + f8;
                float f11 = f4320l;
                if (f10 > (-f11) && f10 < f11) {
                    f10 = 0.0f;
                }
                fArr[i8] = f10;
                if (f10 == 0.0f) {
                    if (i8 == this.f4329i) {
                        this.f4329i = this.f4327g[i8];
                    } else {
                        int[] iArr2 = this.f4327g;
                        iArr2[i10] = iArr2[i8];
                    }
                    if (z7) {
                        solverVariable.f(this.f4322b);
                    }
                    if (this.f4331k) {
                        this.f4330j = i8;
                    }
                    solverVariable.f4420r--;
                    this.f4321a--;
                    return;
                }
                return;
            }
            if (i12 < i13) {
                i10 = i8;
            }
            i8 = this.f4327g[i8];
        }
        int i14 = this.f4330j;
        int i15 = i14 + 1;
        if (this.f4331k) {
            int[] iArr3 = this.f4326f;
            if (iArr3[i14] != -1) {
                i14 = iArr3.length;
            }
        } else {
            i14 = i15;
        }
        int[] iArr4 = this.f4326f;
        if (i14 >= iArr4.length && this.f4321a < iArr4.length) {
            int i16 = 0;
            while (true) {
                int[] iArr5 = this.f4326f;
                if (i16 >= iArr5.length) {
                    break;
                } else if (iArr5[i16] == -1) {
                    i14 = i16;
                    break;
                } else {
                    i16++;
                }
            }
        }
        int[] iArr6 = this.f4326f;
        if (i14 >= iArr6.length) {
            i14 = iArr6.length;
            int i17 = this.f4324d * 2;
            this.f4324d = i17;
            this.f4331k = false;
            this.f4330j = i14 - 1;
            this.f4328h = Arrays.copyOf(this.f4328h, i17);
            this.f4326f = Arrays.copyOf(this.f4326f, this.f4324d);
            this.f4327g = Arrays.copyOf(this.f4327g, this.f4324d);
        }
        this.f4326f[i14] = solverVariable.f4410h;
        this.f4328h[i14] = f8;
        if (i10 != -1) {
            int[] iArr7 = this.f4327g;
            iArr7[i14] = iArr7[i10];
            iArr7[i10] = i14;
        } else {
            this.f4327g[i14] = this.f4329i;
            this.f4329i = i14;
        }
        solverVariable.f4420r++;
        solverVariable.a(this.f4322b);
        this.f4321a++;
        if (!this.f4331k) {
            this.f4330j++;
        }
        int i18 = this.f4330j;
        int[] iArr8 = this.f4326f;
        if (i18 >= iArr8.length) {
            this.f4331k = true;
            this.f4330j = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i8 = this.f4329i;
        for (int i9 = 0; i8 != -1 && i9 < this.f4321a; i9++) {
            SolverVariable solverVariable = this.f4323c.f4341d[this.f4326f[i8]];
            if (solverVariable != null) {
                solverVariable.f(this.f4322b);
            }
            i8 = this.f4327g[i8];
        }
        this.f4329i = -1;
        this.f4330j = -1;
        this.f4331k = false;
        this.f4321a = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void d() {
        int i8 = this.f4329i;
        for (int i9 = 0; i8 != -1 && i9 < this.f4321a; i9++) {
            float[] fArr = this.f4328h;
            fArr[i8] = fArr[i8] * (-1.0f);
            i8 = this.f4327g[i8];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float e(SolverVariable solverVariable, boolean z7) {
        if (this.f4325e == solverVariable) {
            this.f4325e = null;
        }
        int i8 = this.f4329i;
        if (i8 == -1) {
            return 0.0f;
        }
        int i9 = 0;
        int i10 = -1;
        while (i8 != -1 && i9 < this.f4321a) {
            if (this.f4326f[i8] == solverVariable.f4410h) {
                if (i8 == this.f4329i) {
                    this.f4329i = this.f4327g[i8];
                } else {
                    int[] iArr = this.f4327g;
                    iArr[i10] = iArr[i8];
                }
                if (z7) {
                    solverVariable.f(this.f4322b);
                }
                solverVariable.f4420r--;
                this.f4321a--;
                this.f4326f[i8] = -1;
                if (this.f4331k) {
                    this.f4330j = i8;
                }
                return this.f4328h[i8];
            }
            i9++;
            i10 = i8;
            i8 = this.f4327g[i8];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int f() {
        return this.f4321a;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float g(ArrayRow arrayRow, boolean z7) {
        float j8 = j(arrayRow.f4332a);
        e(arrayRow.f4332a, z7);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f4336e;
        int f8 = arrayRowVariables.f();
        for (int i8 = 0; i8 < f8; i8++) {
            SolverVariable b8 = arrayRowVariables.b(i8);
            c(b8, arrayRowVariables.j(b8) * j8, z7);
        }
        return j8;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void h(SolverVariable solverVariable, float f8) {
        if (f8 == 0.0f) {
            e(solverVariable, true);
            return;
        }
        int i8 = this.f4329i;
        if (i8 == -1) {
            this.f4329i = 0;
            this.f4328h[0] = f8;
            this.f4326f[0] = solverVariable.f4410h;
            this.f4327g[0] = -1;
            solverVariable.f4420r++;
            solverVariable.a(this.f4322b);
            this.f4321a++;
            if (!this.f4331k) {
                int i9 = this.f4330j + 1;
                this.f4330j = i9;
                int[] iArr = this.f4326f;
                if (i9 >= iArr.length) {
                    this.f4331k = true;
                    this.f4330j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i10 = -1;
        for (int i11 = 0; i8 != -1 && i11 < this.f4321a; i11++) {
            int i12 = this.f4326f[i8];
            int i13 = solverVariable.f4410h;
            if (i12 == i13) {
                this.f4328h[i8] = f8;
                return;
            }
            if (i12 < i13) {
                i10 = i8;
            }
            i8 = this.f4327g[i8];
        }
        int i14 = this.f4330j;
        int i15 = i14 + 1;
        if (this.f4331k) {
            int[] iArr2 = this.f4326f;
            if (iArr2[i14] != -1) {
                i14 = iArr2.length;
            }
        } else {
            i14 = i15;
        }
        int[] iArr3 = this.f4326f;
        if (i14 >= iArr3.length && this.f4321a < iArr3.length) {
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.f4326f;
                if (i16 >= iArr4.length) {
                    break;
                } else if (iArr4[i16] == -1) {
                    i14 = i16;
                    break;
                } else {
                    i16++;
                }
            }
        }
        int[] iArr5 = this.f4326f;
        if (i14 >= iArr5.length) {
            i14 = iArr5.length;
            int i17 = this.f4324d * 2;
            this.f4324d = i17;
            this.f4331k = false;
            this.f4330j = i14 - 1;
            this.f4328h = Arrays.copyOf(this.f4328h, i17);
            this.f4326f = Arrays.copyOf(this.f4326f, this.f4324d);
            this.f4327g = Arrays.copyOf(this.f4327g, this.f4324d);
        }
        this.f4326f[i14] = solverVariable.f4410h;
        this.f4328h[i14] = f8;
        if (i10 != -1) {
            int[] iArr6 = this.f4327g;
            iArr6[i14] = iArr6[i10];
            iArr6[i10] = i14;
        } else {
            this.f4327g[i14] = this.f4329i;
            this.f4329i = i14;
        }
        solverVariable.f4420r++;
        solverVariable.a(this.f4322b);
        int i18 = this.f4321a + 1;
        this.f4321a = i18;
        if (!this.f4331k) {
            this.f4330j++;
        }
        int[] iArr7 = this.f4326f;
        if (i18 >= iArr7.length) {
            this.f4331k = true;
        }
        if (this.f4330j >= iArr7.length) {
            this.f4331k = true;
            this.f4330j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float i(int i8) {
        int i9 = this.f4329i;
        for (int i10 = 0; i9 != -1 && i10 < this.f4321a; i10++) {
            if (i10 == i8) {
                return this.f4328h[i9];
            }
            i9 = this.f4327g[i9];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float j(SolverVariable solverVariable) {
        int i8 = this.f4329i;
        for (int i9 = 0; i8 != -1 && i9 < this.f4321a; i9++) {
            if (this.f4326f[i8] == solverVariable.f4410h) {
                return this.f4328h[i8];
            }
            i8 = this.f4327g[i8];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void k(float f8) {
        int i8 = this.f4329i;
        for (int i9 = 0; i8 != -1 && i9 < this.f4321a; i9++) {
            float[] fArr = this.f4328h;
            fArr[i8] = fArr[i8] / f8;
            i8 = this.f4327g[i8];
        }
    }

    public String toString() {
        int i8 = this.f4329i;
        String str = "";
        for (int i9 = 0; i8 != -1 && i9 < this.f4321a; i9++) {
            str = ((str + " -> ") + this.f4328h[i8] + " : ") + this.f4323c.f4341d[this.f4326f[i8]];
            i8 = this.f4327g[i8];
        }
        return str;
    }
}
