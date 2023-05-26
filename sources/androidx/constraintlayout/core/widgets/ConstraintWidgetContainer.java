package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private int O0;
    public Metrics R0;
    int T0;
    int U0;
    int V0;
    int W0;
    BasicMeasure M0 = new BasicMeasure(this);
    public DependencyGraph N0 = new DependencyGraph(this);
    protected BasicMeasure.Measurer P0 = null;
    private boolean Q0 = false;
    protected LinearSystem S0 = new LinearSystem();
    public int X0 = 0;
    public int Y0 = 0;
    ChainHead[] Z0 = new ChainHead[4];

    /* renamed from: a1  reason: collision with root package name */
    ChainHead[] f4611a1 = new ChainHead[4];

    /* renamed from: b1  reason: collision with root package name */
    public boolean f4612b1 = false;

    /* renamed from: c1  reason: collision with root package name */
    public boolean f4613c1 = false;

    /* renamed from: d1  reason: collision with root package name */
    public boolean f4614d1 = false;

    /* renamed from: e1  reason: collision with root package name */
    public int f4615e1 = 0;

    /* renamed from: f1  reason: collision with root package name */
    public int f4616f1 = 0;

    /* renamed from: g1  reason: collision with root package name */
    private int f4617g1 = 257;

    /* renamed from: h1  reason: collision with root package name */
    public boolean f4618h1 = false;

    /* renamed from: i1  reason: collision with root package name */
    private boolean f4619i1 = false;

    /* renamed from: j1  reason: collision with root package name */
    private boolean f4620j1 = false;

    /* renamed from: k1  reason: collision with root package name */
    int f4621k1 = 0;

    /* renamed from: l1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f4622l1 = null;

    /* renamed from: m1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f4623m1 = null;

    /* renamed from: n1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f4624n1 = null;

    /* renamed from: o1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f4625o1 = null;

    /* renamed from: p1  reason: collision with root package name */
    HashSet<ConstraintWidget> f4626p1 = new HashSet<>();

    /* renamed from: q1  reason: collision with root package name */
    public BasicMeasure.Measure f4627q1 = new BasicMeasure.Measure();

    private void A1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.S0.h(solverVariable, this.S0.q(constraintAnchor), 0, 5);
    }

    private void B1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.S0.h(this.S0.q(constraintAnchor), solverVariable, 0, 5);
    }

    private void C1(ConstraintWidget constraintWidget) {
        int i8 = this.Y0 + 1;
        ChainHead[] chainHeadArr = this.Z0;
        if (i8 >= chainHeadArr.length) {
            this.Z0 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.Z0[this.Y0] = new ChainHead(constraintWidget, 1, P1());
        this.Y0++;
    }

    public static boolean S1(int i8, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i9) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i10;
        int i11;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.V() != 8 && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier)) {
            measure.f4679a = constraintWidget.A();
            measure.f4680b = constraintWidget.T();
            measure.f4681c = constraintWidget.W();
            measure.f4682d = constraintWidget.x();
            measure.f4687i = false;
            measure.f4688j = i9;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f4679a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (measure.f4680b == dimensionBehaviour2) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z7 && constraintWidget.f4559d0 > 0.0f) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z8 && constraintWidget.f4559d0 > 0.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z7 && constraintWidget.a0(0) && constraintWidget.f4596w == 0 && !z9) {
                measure.f4679a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z8 && constraintWidget.f4598x == 0) {
                    measure.f4679a = ConstraintWidget.DimensionBehaviour.FIXED;
                }
                z7 = false;
            }
            if (z8 && constraintWidget.a0(1) && constraintWidget.f4598x == 0 && !z10) {
                measure.f4680b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z7 && constraintWidget.f4596w == 0) {
                    measure.f4680b = ConstraintWidget.DimensionBehaviour.FIXED;
                }
                z8 = false;
            }
            if (constraintWidget.n0()) {
                measure.f4679a = ConstraintWidget.DimensionBehaviour.FIXED;
                z7 = false;
            }
            if (constraintWidget.o0()) {
                measure.f4680b = ConstraintWidget.DimensionBehaviour.FIXED;
                z8 = false;
            }
            if (z9) {
                if (constraintWidget.f4600y[0] == 4) {
                    measure.f4679a = ConstraintWidget.DimensionBehaviour.FIXED;
                } else if (!z8) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.f4680b;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    if (dimensionBehaviour3 == dimensionBehaviour4) {
                        i11 = measure.f4682d;
                    } else {
                        measure.f4679a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        measurer.b(constraintWidget, measure);
                        i11 = measure.f4684f;
                    }
                    measure.f4679a = dimensionBehaviour4;
                    measure.f4681c = (int) (constraintWidget.v() * i11);
                }
            }
            if (z10) {
                if (constraintWidget.f4600y[1] == 4) {
                    measure.f4680b = ConstraintWidget.DimensionBehaviour.FIXED;
                } else if (!z7) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.f4679a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                    if (dimensionBehaviour5 == dimensionBehaviour6) {
                        i10 = measure.f4681c;
                    } else {
                        measure.f4680b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        measurer.b(constraintWidget, measure);
                        i10 = measure.f4683e;
                    }
                    measure.f4680b = dimensionBehaviour6;
                    if (constraintWidget.w() == -1) {
                        measure.f4682d = (int) (i10 / constraintWidget.v());
                    } else {
                        measure.f4682d = (int) (constraintWidget.v() * i10);
                    }
                }
            }
            measurer.b(constraintWidget, measure);
            constraintWidget.k1(measure.f4683e);
            constraintWidget.L0(measure.f4684f);
            constraintWidget.K0(measure.f4686h);
            constraintWidget.A0(measure.f4685g);
            measure.f4688j = BasicMeasure.Measure.f4676k;
            return measure.f4687i;
        }
        measure.f4683e = 0;
        measure.f4684f = 0;
        return false;
    }

    private void U1() {
        this.X0 = 0;
        this.Y0 = 0;
    }

    private void x1(ConstraintWidget constraintWidget) {
        int i8 = this.X0 + 1;
        ChainHead[] chainHeadArr = this.f4611a1;
        if (i8 >= chainHeadArr.length) {
            this.f4611a1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.f4611a1[this.X0] = new ChainHead(constraintWidget, 0, P1());
        this.X0++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f4624n1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f4624n1.get().e()) {
            this.f4624n1 = new WeakReference<>(constraintAnchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f4622l1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f4622l1.get().e()) {
            this.f4622l1 = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean F1(boolean z7) {
        return this.N0.f(z7);
    }

    public boolean G1(boolean z7) {
        return this.N0.g(z7);
    }

    public boolean H1(boolean z7, int i8) {
        return this.N0.h(z7, i8);
    }

    public BasicMeasure.Measurer I1() {
        return this.P0;
    }

    public int J1() {
        return this.f4617g1;
    }

    public LinearSystem K1() {
        return this.S0;
    }

    public boolean L1() {
        return false;
    }

    public void M1() {
        this.N0.j();
    }

    public void N1() {
        this.N0.k();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void O(StringBuilder sb) {
        sb.append(this.f4580o + ":{\n");
        sb.append("  actualWidth:" + this.f4555b0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f4557c0);
        sb.append("\n");
        Iterator<ConstraintWidget> it = r1().iterator();
        while (it.hasNext()) {
            it.next().O(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public boolean O1() {
        return this.f4620j1;
    }

    public boolean P1() {
        return this.Q0;
    }

    public boolean Q1() {
        return this.f4619i1;
    }

    public long R1(int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.T0 = i15;
        this.U0 = i16;
        return this.M0.d(this, i8, i15, i16, i9, i10, i11, i12, i13, i14);
    }

    public boolean T1(int i8) {
        if ((this.f4617g1 & i8) == i8) {
            return true;
        }
        return false;
    }

    public void V1(BasicMeasure.Measurer measurer) {
        this.P0 = measurer;
        this.N0.n(measurer);
    }

    public void W1(int i8) {
        this.f4617g1 = i8;
        LinearSystem.f4342r = T1(512);
    }

    public void X1(int i8) {
        this.O0 = i8;
    }

    public void Y1(boolean z7) {
        this.Q0 = z7;
    }

    public boolean Z1(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean T1 = T1(64);
        q1(linearSystem, T1);
        int size = this.L0.size();
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget = this.L0.get(i8);
            constraintWidget.q1(linearSystem, T1);
            if (constraintWidget.c0()) {
                z7 = true;
            }
        }
        return z7;
    }

    public void a2() {
        this.M0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void p1(boolean z7, boolean z8) {
        super.p1(z7, z8);
        int size = this.L0.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.L0.get(i8).p1(z7, z8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x031d  */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s1() {
        /*
            Method dump skipped, instructions count: 826
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.s1():void");
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void t0() {
        this.S0.D();
        this.T0 = 0;
        this.V0 = 0;
        this.U0 = 0;
        this.W0 = 0;
        this.f4618h1 = false;
        super.t0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v1(ConstraintWidget constraintWidget, int i8) {
        if (i8 == 0) {
            x1(constraintWidget);
        } else if (i8 == 1) {
            C1(constraintWidget);
        }
    }

    public boolean w1(LinearSystem linearSystem) {
        int i8;
        boolean T1 = T1(64);
        g(linearSystem, T1);
        int size = this.L0.size();
        boolean z7 = false;
        for (int i9 = 0; i9 < size; i9++) {
            ConstraintWidget constraintWidget = this.L0.get(i9);
            constraintWidget.S0(0, false);
            constraintWidget.S0(1, false);
            if (constraintWidget instanceof Barrier) {
                z7 = true;
            }
        }
        if (z7) {
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget2 = this.L0.get(i10);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).y1();
                }
            }
        }
        this.f4626p1.clear();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget3 = this.L0.get(i11);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.f4626p1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(linearSystem, T1);
                }
            }
        }
        while (this.f4626p1.size() > 0) {
            int size2 = this.f4626p1.size();
            Iterator<ConstraintWidget> it = this.f4626p1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it.next();
                if (virtualLayout.v1(this.f4626p1)) {
                    virtualLayout.g(linearSystem, T1);
                    this.f4626p1.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.f4626p1.size()) {
                Iterator<ConstraintWidget> it2 = this.f4626p1.iterator();
                while (it2.hasNext()) {
                    it2.next().g(linearSystem, T1);
                }
                this.f4626p1.clear();
            }
        }
        if (LinearSystem.f4342r) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget4 = this.L0.get(i12);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            if (A() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                i8 = 0;
            } else {
                i8 = 1;
            }
            e(this, linearSystem, hashSet, i8, false);
            Iterator<ConstraintWidget> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                Optimizer.a(this, linearSystem, next);
                next.g(linearSystem, T1);
            }
        } else {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget5 = this.L0.get(i13);
                if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.Z;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.P0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.g1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget5.g(linearSystem, T1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.P0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.g1(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.a(this, linearSystem, constraintWidget5);
                    if (!constraintWidget5.f()) {
                        constraintWidget5.g(linearSystem, T1);
                    }
                }
            }
        }
        if (this.X0 > 0) {
            Chain.b(this, linearSystem, null, 0);
        }
        if (this.Y0 > 0) {
            Chain.b(this, linearSystem, null, 1);
        }
        return true;
    }

    public void y1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f4625o1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f4625o1.get().e()) {
            this.f4625o1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void z1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f4623m1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f4623m1.get().e()) {
            this.f4623m1 = new WeakReference<>(constraintAnchor);
        }
    }
}
