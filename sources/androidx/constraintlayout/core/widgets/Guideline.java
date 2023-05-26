package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Guideline extends ConstraintWidget {
    protected float L0 = -1.0f;
    protected int M0 = -1;
    protected int N0 = -1;
    protected boolean O0 = true;
    private ConstraintAnchor P0 = this.P;
    private int Q0 = 0;
    private int R0 = 0;
    private boolean S0;

    /* renamed from: androidx.constraintlayout.core.widgets.Guideline$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4671a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f4671a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4671a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4671a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4671a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4671a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4671a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4671a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4671a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4671a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        this.X.clear();
        this.X.add(this.P0);
        int length = this.W.length;
        for (int i8 = 0; i8 < length; i8++) {
            this.W[i8] = this.P0;
        }
    }

    public void A1(int i8) {
        if (this.Q0 == i8) {
            return;
        }
        this.Q0 = i8;
        this.X.clear();
        if (this.Q0 == 1) {
            this.P0 = this.O;
        } else {
            this.P0 = this.P;
        }
        this.X.add(this.P0);
        int length = this.W.length;
        for (int i9 = 0; i9 < length; i9++) {
            this.W[i9] = this.P0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(LinearSystem linearSystem, boolean z7) {
        boolean z8;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) K();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor o8 = constraintWidgetContainer.o(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor o9 = constraintWidgetContainer.o(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.f4553a0;
        boolean z9 = true;
        if (constraintWidget != null && constraintWidget.Z[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (this.Q0 == 0) {
            o8 = constraintWidgetContainer.o(ConstraintAnchor.Type.TOP);
            o9 = constraintWidgetContainer.o(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.f4553a0;
            z8 = (constraintWidget2 == null || constraintWidget2.Z[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) ? false : false;
        }
        if (this.S0 && this.P0.n()) {
            SolverVariable q8 = linearSystem.q(this.P0);
            linearSystem.f(q8, this.P0.e());
            if (this.M0 != -1) {
                if (z8) {
                    linearSystem.h(linearSystem.q(o9), q8, 0, 5);
                }
            } else if (this.N0 != -1 && z8) {
                SolverVariable q9 = linearSystem.q(o9);
                linearSystem.h(q8, linearSystem.q(o8), 0, 5);
                linearSystem.h(q9, q8, 0, 5);
            }
            this.S0 = false;
        } else if (this.M0 != -1) {
            SolverVariable q10 = linearSystem.q(this.P0);
            linearSystem.e(q10, linearSystem.q(o8), this.M0, 8);
            if (z8) {
                linearSystem.h(linearSystem.q(o9), q10, 0, 5);
            }
        } else if (this.N0 != -1) {
            SolverVariable q11 = linearSystem.q(this.P0);
            SolverVariable q12 = linearSystem.q(o9);
            linearSystem.e(q11, q12, -this.N0, 8);
            if (z8) {
                linearSystem.h(q11, linearSystem.q(o8), 0, 5);
                linearSystem.h(q12, q11, 0, 5);
            }
        } else if (this.L0 != -1.0f) {
            linearSystem.d(LinearSystem.s(linearSystem, linearSystem.q(this.P0), linearSystem.q(o9), this.L0));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean n0() {
        return this.S0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor o(ConstraintAnchor.Type type) {
        int i8 = AnonymousClass1.f4671a[type.ordinal()];
        if (i8 != 1 && i8 != 2) {
            if ((i8 == 3 || i8 == 4) && this.Q0 == 0) {
                return this.P0;
            }
            return null;
        } else if (this.Q0 == 1) {
            return this.P0;
        } else {
            return null;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean o0() {
        return this.S0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void q1(LinearSystem linearSystem, boolean z7) {
        if (K() == null) {
            return;
        }
        int x7 = linearSystem.x(this.P0);
        if (this.Q0 == 1) {
            m1(x7);
            n1(0);
            L0(K().x());
            k1(0);
            return;
        }
        m1(0);
        n1(x7);
        k1(K().W());
        L0(0);
    }

    public ConstraintAnchor r1() {
        return this.P0;
    }

    public int s1() {
        return this.Q0;
    }

    public int t1() {
        return this.M0;
    }

    public int u1() {
        return this.N0;
    }

    public float v1() {
        return this.L0;
    }

    public void w1(int i8) {
        this.P0.t(i8);
        this.S0 = true;
    }

    public void x1(int i8) {
        if (i8 > -1) {
            this.L0 = -1.0f;
            this.M0 = i8;
            this.N0 = -1;
        }
    }

    public void y1(int i8) {
        if (i8 > -1) {
            this.L0 = -1.0f;
            this.M0 = -1;
            this.N0 = i8;
        }
    }

    public void z1(float f8) {
        if (f8 > -1.0f) {
            this.L0 = f8;
            this.M0 = -1;
            this.N0 = -1;
        }
    }
}
