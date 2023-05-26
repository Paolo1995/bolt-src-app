package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public static float K0 = 0.5f;
    int A0;
    boolean B0;
    boolean C0;
    public float[] D0;
    protected ConstraintWidget[] E0;
    protected ConstraintWidget[] F0;
    ConstraintWidget G0;
    ConstraintWidget H0;
    public int I0;
    public int J0;
    private boolean K;
    public ConstraintAnchor V;
    public ConstraintAnchor[] W;
    protected ArrayList<ConstraintAnchor> X;
    private boolean[] Y;
    public DimensionBehaviour[] Z;

    /* renamed from: a0  reason: collision with root package name */
    public ConstraintWidget f4553a0;

    /* renamed from: b0  reason: collision with root package name */
    int f4555b0;

    /* renamed from: c  reason: collision with root package name */
    public ChainRun f4556c;

    /* renamed from: c0  reason: collision with root package name */
    int f4557c0;

    /* renamed from: d  reason: collision with root package name */
    public ChainRun f4558d;

    /* renamed from: d0  reason: collision with root package name */
    public float f4559d0;

    /* renamed from: e0  reason: collision with root package name */
    protected int f4561e0;

    /* renamed from: f0  reason: collision with root package name */
    protected int f4563f0;

    /* renamed from: g0  reason: collision with root package name */
    protected int f4565g0;

    /* renamed from: h0  reason: collision with root package name */
    int f4567h0;

    /* renamed from: i0  reason: collision with root package name */
    int f4569i0;

    /* renamed from: j0  reason: collision with root package name */
    protected int f4571j0;

    /* renamed from: k0  reason: collision with root package name */
    protected int f4573k0;

    /* renamed from: l0  reason: collision with root package name */
    int f4575l0;

    /* renamed from: m0  reason: collision with root package name */
    protected int f4577m0;

    /* renamed from: n0  reason: collision with root package name */
    protected int f4579n0;

    /* renamed from: o  reason: collision with root package name */
    public String f4580o;

    /* renamed from: o0  reason: collision with root package name */
    float f4581o0;

    /* renamed from: p0  reason: collision with root package name */
    float f4583p0;

    /* renamed from: q0  reason: collision with root package name */
    private Object f4585q0;

    /* renamed from: r0  reason: collision with root package name */
    private int f4587r0;

    /* renamed from: s0  reason: collision with root package name */
    private int f4589s0;

    /* renamed from: t0  reason: collision with root package name */
    private boolean f4591t0;

    /* renamed from: u0  reason: collision with root package name */
    private String f4593u0;

    /* renamed from: v0  reason: collision with root package name */
    private String f4595v0;

    /* renamed from: w0  reason: collision with root package name */
    boolean f4597w0;

    /* renamed from: x0  reason: collision with root package name */
    boolean f4599x0;

    /* renamed from: y0  reason: collision with root package name */
    boolean f4601y0;

    /* renamed from: z0  reason: collision with root package name */
    int f4603z0;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4552a = false;

    /* renamed from: b  reason: collision with root package name */
    public WidgetRun[] f4554b = new WidgetRun[2];

    /* renamed from: e  reason: collision with root package name */
    public HorizontalWidgetRun f4560e = null;

    /* renamed from: f  reason: collision with root package name */
    public VerticalWidgetRun f4562f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f4564g = {true, true};

    /* renamed from: h  reason: collision with root package name */
    boolean f4566h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4568i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4570j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4572k = true;

    /* renamed from: l  reason: collision with root package name */
    private int f4574l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f4576m = -1;

    /* renamed from: n  reason: collision with root package name */
    public WidgetFrame f4578n = new WidgetFrame(this);

    /* renamed from: p  reason: collision with root package name */
    private boolean f4582p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4584q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4586r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f4588s = false;

    /* renamed from: t  reason: collision with root package name */
    public int f4590t = -1;

    /* renamed from: u  reason: collision with root package name */
    public int f4592u = -1;

    /* renamed from: v  reason: collision with root package name */
    private int f4594v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f4596w = 0;

    /* renamed from: x  reason: collision with root package name */
    public int f4598x = 0;

    /* renamed from: y  reason: collision with root package name */
    public int[] f4600y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    public int f4602z = 0;
    public int A = 0;
    public float B = 1.0f;
    public int C = 0;
    public int D = 0;
    public float E = 1.0f;
    int F = -1;
    float G = 1.0f;
    private int[] H = {Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER};
    private float I = 0.0f;
    private boolean J = false;
    private boolean L = false;
    private int M = 0;
    private int N = 0;
    public ConstraintAnchor O = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor P = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor R = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor S = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor T = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor U = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4604a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f4605b;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f4605b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4605b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4605b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4605b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f4604a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4604a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4604a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4604a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4604a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4604a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4604a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4604a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4604a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.V = constraintAnchor;
        this.W = new ConstraintAnchor[]{this.O, this.Q, this.P, this.R, this.S, constraintAnchor};
        this.X = new ArrayList<>();
        this.Y = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.Z = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f4553a0 = null;
        this.f4555b0 = 0;
        this.f4557c0 = 0;
        this.f4559d0 = 0.0f;
        this.f4561e0 = -1;
        this.f4563f0 = 0;
        this.f4565g0 = 0;
        this.f4567h0 = 0;
        this.f4569i0 = 0;
        this.f4571j0 = 0;
        this.f4573k0 = 0;
        this.f4575l0 = 0;
        float f8 = K0;
        this.f4581o0 = f8;
        this.f4583p0 = f8;
        this.f4587r0 = 0;
        this.f4589s0 = 0;
        this.f4591t0 = false;
        this.f4593u0 = null;
        this.f4595v0 = null;
        this.f4601y0 = false;
        this.f4603z0 = 0;
        this.A0 = 0;
        this.D0 = new float[]{-1.0f, -1.0f};
        this.E0 = new ConstraintWidget[]{null, null};
        this.F0 = new ConstraintWidget[]{null, null};
        this.G0 = null;
        this.H0 = null;
        this.I0 = -1;
        this.J0 = -1;
        d();
    }

    private void P(StringBuilder sb, String str, int i8, int i9, int i10, int i11, int i12, int i13, float f8, float f9) {
        sb.append(str);
        sb.append(" :  {\n");
        y0(sb, "      size", i8, 0);
        y0(sb, "      min", i9, 0);
        y0(sb, "      max", i10, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        y0(sb, "      matchMin", i12, 0);
        y0(sb, "      matchDef", i13, 0);
        x0(sb, "      matchPercent", f8, 1.0f);
        sb.append("    },\n");
    }

    private void Q(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f4537f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.f4537f);
        sb.append("'");
        if (constraintAnchor.f4539h != Integer.MIN_VALUE || constraintAnchor.f4538g != 0) {
            sb.append(",");
            sb.append(constraintAnchor.f4538g);
            if (constraintAnchor.f4539h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.f4539h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d() {
        this.X.add(this.O);
        this.X.add(this.P);
        this.X.add(this.Q);
        this.X.add(this.R);
        this.X.add(this.T);
        this.X.add(this.U);
        this.X.add(this.V);
        this.X.add(this.S);
    }

    private boolean f0(int i8) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i9 = i8 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.W;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i9];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4537f;
        if (constraintAnchor4 != null && constraintAnchor4.f4537f != constraintAnchor3 && (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i9 + 1]).f4537f) != null && constraintAnchor2.f4537f == constraintAnchor) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0432 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x04cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0508 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:381:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:384:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(androidx.constraintlayout.core.LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            Method dump skipped, instructions count: 1352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private void x0(StringBuilder sb, String str, float f8, float f9) {
        if (f8 == f9) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f8);
        sb.append(",\n");
    }

    private void y0(StringBuilder sb, String str, int i8, int i9) {
        if (i8 == i9) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i8);
        sb.append(",\n");
    }

    private void z0(StringBuilder sb, String str, float f8, int i8) {
        if (f8 == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f8);
        sb.append(",");
        sb.append(i8);
        sb.append("");
        sb.append("],\n");
    }

    public DimensionBehaviour A() {
        return this.Z[0];
    }

    public void A0(int i8) {
        boolean z7;
        this.f4575l0 = i8;
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.J = z7;
    }

    public int B() {
        ConstraintAnchor constraintAnchor = this.O;
        int i8 = 0;
        if (constraintAnchor != null) {
            i8 = 0 + constraintAnchor.f4538g;
        }
        ConstraintAnchor constraintAnchor2 = this.Q;
        if (constraintAnchor2 != null) {
            return i8 + constraintAnchor2.f4538g;
        }
        return i8;
    }

    public void B0(Object obj) {
        this.f4585q0 = obj;
    }

    public int C() {
        return this.M;
    }

    public void C0(String str) {
        this.f4593u0 = str;
    }

    public int D() {
        return this.N;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0085 -> B:40:0x0086). Please submit an issue!!! */
    public void D0(String str) {
        float f8;
        int i8 = 0;
        if (str != null && str.length() != 0) {
            int i9 = -1;
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i10 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i9 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i9 = 1;
                }
                i10 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i10, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i9 == 1) {
                            f8 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f8 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f8 = 0.0f;
            } else {
                String substring4 = str.substring(i10);
                if (substring4.length() > 0) {
                    f8 = Float.parseFloat(substring4);
                }
                f8 = 0.0f;
            }
            i8 = (f8 > i8 ? 1 : (f8 == i8 ? 0 : -1));
            if (i8 > 0) {
                this.f4559d0 = f8;
                this.f4561e0 = i9;
                return;
            }
            return;
        }
        this.f4559d0 = 0.0f;
    }

    public int E(int i8) {
        if (i8 == 0) {
            return W();
        }
        if (i8 == 1) {
            return x();
        }
        return 0;
    }

    public void E0(int i8) {
        if (!this.J) {
            return;
        }
        int i9 = i8 - this.f4575l0;
        int i10 = this.f4557c0 + i9;
        this.f4565g0 = i9;
        this.P.t(i9);
        this.R.t(i10);
        this.S.t(i8);
        this.f4584q = true;
    }

    public int F() {
        return this.H[1];
    }

    public void F0(int i8, int i9) {
        if (this.f4582p) {
            return;
        }
        this.O.t(i8);
        this.Q.t(i9);
        this.f4563f0 = i8;
        this.f4555b0 = i9 - i8;
        this.f4582p = true;
    }

    public int G() {
        return this.H[0];
    }

    public void G0(int i8) {
        this.O.t(i8);
        this.f4563f0 = i8;
    }

    public int H() {
        return this.f4579n0;
    }

    public void H0(int i8) {
        this.P.t(i8);
        this.f4565g0 = i8;
    }

    public int I() {
        return this.f4577m0;
    }

    public void I0(int i8, int i9) {
        if (this.f4584q) {
            return;
        }
        this.P.t(i8);
        this.R.t(i9);
        this.f4565g0 = i8;
        this.f4557c0 = i9 - i8;
        if (this.J) {
            this.S.t(i8 + this.f4575l0);
        }
        this.f4584q = true;
    }

    public ConstraintWidget J(int i8) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i8 == 0) {
            ConstraintAnchor constraintAnchor3 = this.Q;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4537f;
            if (constraintAnchor4 != null && constraintAnchor4.f4537f == constraintAnchor3) {
                return constraintAnchor4.f4535d;
            }
            return null;
        } else if (i8 == 1 && (constraintAnchor2 = (constraintAnchor = this.R).f4537f) != null && constraintAnchor2.f4537f == constraintAnchor) {
            return constraintAnchor2.f4535d;
        } else {
            return null;
        }
    }

    public void J0(int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        int i14 = i10 - i8;
        int i15 = i11 - i9;
        this.f4563f0 = i8;
        this.f4565g0 = i9;
        if (this.f4589s0 == 8) {
            this.f4555b0 = 0;
            this.f4557c0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.Z;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i14 < (i13 = this.f4555b0)) {
            i14 = i13;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i15 < (i12 = this.f4557c0)) {
            i15 = i12;
        }
        this.f4555b0 = i14;
        this.f4557c0 = i15;
        int i16 = this.f4579n0;
        if (i15 < i16) {
            this.f4557c0 = i16;
        }
        int i17 = this.f4577m0;
        if (i14 < i17) {
            this.f4555b0 = i17;
        }
        int i18 = this.A;
        if (i18 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f4555b0 = Math.min(this.f4555b0, i18);
        }
        int i19 = this.D;
        if (i19 > 0 && this.Z[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f4557c0 = Math.min(this.f4557c0, i19);
        }
        int i20 = this.f4555b0;
        if (i14 != i20) {
            this.f4574l = i20;
        }
        int i21 = this.f4557c0;
        if (i15 != i21) {
            this.f4576m = i21;
        }
    }

    public ConstraintWidget K() {
        return this.f4553a0;
    }

    public void K0(boolean z7) {
        this.J = z7;
    }

    public ConstraintWidget L(int i8) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i8 == 0) {
            ConstraintAnchor constraintAnchor3 = this.O;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4537f;
            if (constraintAnchor4 != null && constraintAnchor4.f4537f == constraintAnchor3) {
                return constraintAnchor4.f4535d;
            }
            return null;
        } else if (i8 == 1 && (constraintAnchor2 = (constraintAnchor = this.P).f4537f) != null && constraintAnchor2.f4537f == constraintAnchor) {
            return constraintAnchor2.f4535d;
        } else {
            return null;
        }
    }

    public void L0(int i8) {
        this.f4557c0 = i8;
        int i9 = this.f4579n0;
        if (i8 < i9) {
            this.f4557c0 = i9;
        }
    }

    public int M() {
        return X() + this.f4555b0;
    }

    public void M0(float f8) {
        this.f4581o0 = f8;
    }

    public WidgetRun N(int i8) {
        if (i8 == 0) {
            return this.f4560e;
        }
        if (i8 == 1) {
            return this.f4562f;
        }
        return null;
    }

    public void N0(int i8) {
        this.f4603z0 = i8;
    }

    public void O(StringBuilder sb) {
        sb.append("  " + this.f4580o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.f4555b0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f4557c0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f4563f0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f4565g0);
        sb.append("\n");
        Q(sb, "left", this.O);
        Q(sb, "top", this.P);
        Q(sb, "right", this.Q);
        Q(sb, "bottom", this.R);
        Q(sb, "baseline", this.S);
        Q(sb, "centerX", this.T);
        Q(sb, "centerY", this.U);
        P(sb, "    width", this.f4555b0, this.f4577m0, this.H[0], this.f4574l, this.f4602z, this.f4596w, this.B, this.D0[0]);
        P(sb, "    height", this.f4557c0, this.f4579n0, this.H[1], this.f4576m, this.C, this.f4598x, this.E, this.D0[1]);
        z0(sb, "    dimensionRatio", this.f4559d0, this.f4561e0);
        x0(sb, "    horizontalBias", this.f4581o0, K0);
        x0(sb, "    verticalBias", this.f4583p0, K0);
        y0(sb, "    horizontalChainStyle", this.f4603z0, 0);
        y0(sb, "    verticalChainStyle", this.A0, 0);
        sb.append("  }");
    }

    public void O0(int i8, int i9) {
        this.f4563f0 = i8;
        int i10 = i9 - i8;
        this.f4555b0 = i10;
        int i11 = this.f4577m0;
        if (i10 < i11) {
            this.f4555b0 = i11;
        }
    }

    public void P0(DimensionBehaviour dimensionBehaviour) {
        this.Z[0] = dimensionBehaviour;
    }

    public void Q0(int i8, int i9, int i10, float f8) {
        this.f4596w = i8;
        this.f4602z = i9;
        if (i10 == Integer.MAX_VALUE) {
            i10 = 0;
        }
        this.A = i10;
        this.B = f8;
        if (f8 > 0.0f && f8 < 1.0f && i8 == 0) {
            this.f4596w = 2;
        }
    }

    public float R() {
        return this.f4583p0;
    }

    public void R0(float f8) {
        this.D0[0] = f8;
    }

    public int S() {
        return this.A0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S0(int i8, boolean z7) {
        this.Y[i8] = z7;
    }

    public DimensionBehaviour T() {
        return this.Z[1];
    }

    public void T0(boolean z7) {
        this.K = z7;
    }

    public int U() {
        int i8 = 0;
        if (this.O != null) {
            i8 = 0 + this.P.f4538g;
        }
        if (this.Q != null) {
            return i8 + this.R.f4538g;
        }
        return i8;
    }

    public void U0(boolean z7) {
        this.L = z7;
    }

    public int V() {
        return this.f4589s0;
    }

    public void V0(int i8, int i9) {
        this.M = i8;
        this.N = i9;
        Y0(false);
    }

    public int W() {
        if (this.f4589s0 == 8) {
            return 0;
        }
        return this.f4555b0;
    }

    public void W0(int i8) {
        this.H[1] = i8;
    }

    public int X() {
        ConstraintWidget constraintWidget = this.f4553a0;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).T0 + this.f4563f0;
        }
        return this.f4563f0;
    }

    public void X0(int i8) {
        this.H[0] = i8;
    }

    public int Y() {
        ConstraintWidget constraintWidget = this.f4553a0;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).U0 + this.f4565g0;
        }
        return this.f4565g0;
    }

    public void Y0(boolean z7) {
        this.f4568i = z7;
    }

    public boolean Z() {
        return this.J;
    }

    public void Z0(int i8) {
        if (i8 < 0) {
            this.f4579n0 = 0;
        } else {
            this.f4579n0 = i8;
        }
    }

    public boolean a0(int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (i8 == 0) {
            if (this.O.f4537f != null) {
                i12 = 1;
            } else {
                i12 = 0;
            }
            if (this.Q.f4537f != null) {
                i13 = 1;
            } else {
                i13 = 0;
            }
            if (i12 + i13 < 2) {
                return true;
            }
            return false;
        }
        if (this.P.f4537f != null) {
            i9 = 1;
        } else {
            i9 = 0;
        }
        if (this.R.f4537f != null) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i14 = i9 + i10;
        if (this.S.f4537f != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (i14 + i11 < 2) {
            return true;
        }
        return false;
    }

    public void a1(int i8) {
        if (i8 < 0) {
            this.f4577m0 = 0;
        } else {
            this.f4577m0 = i8;
        }
    }

    public boolean b0() {
        int size = this.X.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.X.get(i8).m()) {
                return true;
            }
        }
        return false;
    }

    public void b1(int i8, int i9) {
        this.f4563f0 = i8;
        this.f4565g0 = i9;
    }

    public boolean c0() {
        if (this.f4574l == -1 && this.f4576m == -1) {
            return false;
        }
        return true;
    }

    public void c1(ConstraintWidget constraintWidget) {
        this.f4553a0 = constraintWidget;
    }

    public boolean d0(int i8, int i9) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i8 == 0) {
            ConstraintAnchor constraintAnchor3 = this.O.f4537f;
            if (constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.Q.f4537f) != null && constraintAnchor2.n() && (this.Q.f4537f.e() - this.Q.f()) - (this.O.f4537f.e() + this.O.f()) >= i9) {
                return true;
            }
            return false;
        }
        ConstraintAnchor constraintAnchor4 = this.P.f4537f;
        if (constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.R.f4537f) != null && constraintAnchor.n() && (this.R.f4537f.e() - this.R.f()) - (this.P.f4537f.e() + this.P.f()) >= i9) {
            return true;
        }
        return false;
        return false;
    }

    public void d1(float f8) {
        this.f4583p0 = f8;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i8, boolean z7) {
        if (z7) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.a(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            g(linearSystem, constraintWidgetContainer.T1(64));
        }
        if (i8 == 0) {
            HashSet<ConstraintAnchor> d8 = this.O.d();
            if (d8 != null) {
                Iterator<ConstraintAnchor> it = d8.iterator();
                while (it.hasNext()) {
                    it.next().f4535d.e(constraintWidgetContainer, linearSystem, hashSet, i8, true);
                }
            }
            HashSet<ConstraintAnchor> d9 = this.Q.d();
            if (d9 != null) {
                Iterator<ConstraintAnchor> it2 = d9.iterator();
                while (it2.hasNext()) {
                    it2.next().f4535d.e(constraintWidgetContainer, linearSystem, hashSet, i8, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> d10 = this.P.d();
        if (d10 != null) {
            Iterator<ConstraintAnchor> it3 = d10.iterator();
            while (it3.hasNext()) {
                it3.next().f4535d.e(constraintWidgetContainer, linearSystem, hashSet, i8, true);
            }
        }
        HashSet<ConstraintAnchor> d11 = this.R.d();
        if (d11 != null) {
            Iterator<ConstraintAnchor> it4 = d11.iterator();
            while (it4.hasNext()) {
                it4.next().f4535d.e(constraintWidgetContainer, linearSystem, hashSet, i8, true);
            }
        }
        HashSet<ConstraintAnchor> d12 = this.S.d();
        if (d12 != null) {
            Iterator<ConstraintAnchor> it5 = d12.iterator();
            while (it5.hasNext()) {
                it5.next().f4535d.e(constraintWidgetContainer, linearSystem, hashSet, i8, true);
            }
        }
    }

    public void e0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i8, int i9) {
        o(type).b(constraintWidget.o(type2), i8, i9, true);
    }

    public void e1(int i8) {
        this.A0 = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (!(this instanceof VirtualLayout) && !(this instanceof Guideline)) {
            return false;
        }
        return true;
    }

    public void f1(int i8, int i9) {
        this.f4565g0 = i8;
        int i10 = i9 - i8;
        this.f4557c0 = i10;
        int i11 = this.f4579n0;
        if (i10 < i11) {
            this.f4557c0 = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(androidx.constraintlayout.core.LinearSystem r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean g0() {
        return this.f4586r;
    }

    public void g1(DimensionBehaviour dimensionBehaviour) {
        this.Z[1] = dimensionBehaviour;
    }

    public boolean h() {
        if (this.f4589s0 != 8) {
            return true;
        }
        return false;
    }

    public boolean h0(int i8) {
        return this.Y[i8];
    }

    public void h1(int i8, int i9, int i10, float f8) {
        this.f4598x = i8;
        this.C = i9;
        if (i10 == Integer.MAX_VALUE) {
            i10 = 0;
        }
        this.D = i10;
        this.E = f8;
        if (f8 > 0.0f && f8 < 1.0f && i8 == 0) {
            this.f4598x = 2;
        }
    }

    public boolean i0() {
        ConstraintAnchor constraintAnchor = this.O;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4537f;
        if (constraintAnchor2 == null || constraintAnchor2.f4537f != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.Q;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4537f;
            if (constraintAnchor4 != null && constraintAnchor4.f4537f == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void i1(float f8) {
        this.D0[1] = f8;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i8) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z7;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 == type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor o8 = o(type6);
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor o9 = o(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor o10 = o(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor o11 = o(type9);
                boolean z8 = true;
                if ((o8 != null && o8.o()) || (o9 != null && o9.o())) {
                    z7 = false;
                } else {
                    j(type6, constraintWidget, type6, 0);
                    j(type7, constraintWidget, type7, 0);
                    z7 = true;
                }
                if ((o10 != null && o10.o()) || (o11 != null && o11.o())) {
                    z8 = false;
                } else {
                    j(type8, constraintWidget, type8, 0);
                    j(type9, constraintWidget, type9, 0);
                }
                if (z7 && z8) {
                    o(type5).a(constraintWidget.o(type5), 0);
                    return;
                } else if (z7) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
                    o(type10).a(constraintWidget.o(type10), 0);
                    return;
                } else if (z8) {
                    ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                    o(type11).a(constraintWidget.o(type11), 0);
                    return;
                } else {
                    return;
                }
            }
            ConstraintAnchor.Type type12 = ConstraintAnchor.Type.LEFT;
            if (type2 != type12 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type13 = ConstraintAnchor.Type.TOP;
                if (type2 == type13 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    j(type13, constraintWidget, type2, 0);
                    j(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    o(type5).a(constraintWidget.o(type2), 0);
                    return;
                }
                return;
            }
            j(type12, constraintWidget, type2, 0);
            j(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            o(type5).a(constraintWidget.o(type2), 0);
            return;
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor o12 = o(type4);
            ConstraintAnchor o13 = constraintWidget.o(type2);
            ConstraintAnchor o14 = o(ConstraintAnchor.Type.RIGHT);
            o12.a(o13, 0);
            o14.a(o13, 0);
            o(type14).a(o13, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor o15 = constraintWidget.o(type2);
            o(type3).a(o15, 0);
            o(ConstraintAnchor.Type.BOTTOM).a(o15, 0);
            o(type15).a(o15, 0);
        } else if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            o(type16).a(constraintWidget.o(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            o(type17).a(constraintWidget.o(type17), 0);
            o(type14).a(constraintWidget.o(type2), 0);
        } else if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            o(type18).a(constraintWidget.o(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            o(type19).a(constraintWidget.o(type19), 0);
            o(type15).a(constraintWidget.o(type2), 0);
        } else {
            ConstraintAnchor o16 = o(type);
            ConstraintAnchor o17 = constraintWidget.o(type2);
            if (o16.p(o17)) {
                ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
                if (type == type20) {
                    ConstraintAnchor o18 = o(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor o19 = o(ConstraintAnchor.Type.BOTTOM);
                    if (o18 != null) {
                        o18.q();
                    }
                    if (o19 != null) {
                        o19.q();
                    }
                } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                    if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor o20 = o(type5);
                        if (o20.j() != o17) {
                            o20.q();
                        }
                        ConstraintAnchor g8 = o(type).g();
                        ConstraintAnchor o21 = o(type14);
                        if (o21.o()) {
                            g8.q();
                            o21.q();
                        }
                    }
                } else {
                    ConstraintAnchor o22 = o(type20);
                    if (o22 != null) {
                        o22.q();
                    }
                    ConstraintAnchor o23 = o(type5);
                    if (o23.j() != o17) {
                        o23.q();
                    }
                    ConstraintAnchor g9 = o(type).g();
                    ConstraintAnchor o24 = o(type15);
                    if (o24.o()) {
                        g9.q();
                        o24.q();
                    }
                }
                o16.a(o17, i8);
            }
        }
    }

    public boolean j0() {
        return this.K;
    }

    public void j1(int i8) {
        this.f4589s0 = i8;
    }

    public void k(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i8) {
        if (constraintAnchor.h() == this) {
            j(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i8);
        }
    }

    public boolean k0() {
        ConstraintAnchor constraintAnchor = this.P;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4537f;
        if (constraintAnchor2 == null || constraintAnchor2.f4537f != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.R;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4537f;
            if (constraintAnchor4 != null && constraintAnchor4.f4537f == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void k1(int i8) {
        this.f4555b0 = i8;
        int i9 = this.f4577m0;
        if (i8 < i9) {
            this.f4555b0 = i9;
        }
    }

    public void l(ConstraintWidget constraintWidget, float f8, int i8) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        e0(type, constraintWidget, type, i8, 0);
        this.I = f8;
    }

    public boolean l0() {
        return this.L;
    }

    public void l1(int i8) {
        if (i8 >= 0 && i8 <= 3) {
            this.f4594v = i8;
        }
    }

    public void m(LinearSystem linearSystem) {
        linearSystem.q(this.O);
        linearSystem.q(this.P);
        linearSystem.q(this.Q);
        linearSystem.q(this.R);
        if (this.f4575l0 > 0) {
            linearSystem.q(this.S);
        }
    }

    public boolean m0() {
        if (this.f4568i && this.f4589s0 != 8) {
            return true;
        }
        return false;
    }

    public void m1(int i8) {
        this.f4563f0 = i8;
    }

    public void n() {
        if (this.f4560e == null) {
            this.f4560e = new HorizontalWidgetRun(this);
        }
        if (this.f4562f == null) {
            this.f4562f = new VerticalWidgetRun(this);
        }
    }

    public boolean n0() {
        if (!this.f4582p && (!this.O.n() || !this.Q.n())) {
            return false;
        }
        return true;
    }

    public void n1(int i8) {
        this.f4565g0 = i8;
    }

    public ConstraintAnchor o(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f4604a[type.ordinal()]) {
            case 1:
                return this.O;
            case 2:
                return this.P;
            case 3:
                return this.Q;
            case 4:
                return this.R;
            case 5:
                return this.S;
            case 6:
                return this.V;
            case 7:
                return this.T;
            case 8:
                return this.U;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean o0() {
        if (!this.f4584q && (!this.P.n() || !this.R.n())) {
            return false;
        }
        return true;
    }

    public void o1(boolean z7, boolean z8, boolean z9, boolean z10) {
        if (this.F == -1) {
            if (z9 && !z10) {
                this.F = 0;
            } else if (!z9 && z10) {
                this.F = 1;
                if (this.f4561e0 == -1) {
                    this.G = 1.0f / this.G;
                }
            }
        }
        if (this.F == 0 && (!this.P.o() || !this.R.o())) {
            this.F = 1;
        } else if (this.F == 1 && (!this.O.o() || !this.Q.o())) {
            this.F = 0;
        }
        if (this.F == -1 && (!this.P.o() || !this.R.o() || !this.O.o() || !this.Q.o())) {
            if (this.P.o() && this.R.o()) {
                this.F = 0;
            } else if (this.O.o() && this.Q.o()) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
        if (this.F == -1) {
            int i8 = this.f4602z;
            if (i8 > 0 && this.C == 0) {
                this.F = 0;
            } else if (i8 == 0 && this.C > 0) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
    }

    public int p() {
        return this.f4575l0;
    }

    public boolean p0() {
        return this.f4588s;
    }

    public void p1(boolean z7, boolean z8) {
        int i8;
        int i9;
        boolean k8 = z7 & this.f4560e.k();
        boolean k9 = z8 & this.f4562f.k();
        HorizontalWidgetRun horizontalWidgetRun = this.f4560e;
        int i10 = horizontalWidgetRun.f4760h.f4706g;
        VerticalWidgetRun verticalWidgetRun = this.f4562f;
        int i11 = verticalWidgetRun.f4760h.f4706g;
        int i12 = horizontalWidgetRun.f4761i.f4706g;
        int i13 = verticalWidgetRun.f4761i.f4706g;
        int i14 = i13 - i11;
        if (i12 - i10 < 0 || i14 < 0 || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE) {
            i12 = 0;
            i10 = 0;
            i13 = 0;
            i11 = 0;
        }
        int i15 = i12 - i10;
        int i16 = i13 - i11;
        if (k8) {
            this.f4563f0 = i10;
        }
        if (k9) {
            this.f4565g0 = i11;
        }
        if (this.f4589s0 == 8) {
            this.f4555b0 = 0;
            this.f4557c0 = 0;
            return;
        }
        if (k8) {
            if (this.Z[0] == DimensionBehaviour.FIXED && i15 < (i9 = this.f4555b0)) {
                i15 = i9;
            }
            this.f4555b0 = i15;
            int i17 = this.f4577m0;
            if (i15 < i17) {
                this.f4555b0 = i17;
            }
        }
        if (k9) {
            if (this.Z[1] == DimensionBehaviour.FIXED && i16 < (i8 = this.f4557c0)) {
                i16 = i8;
            }
            this.f4557c0 = i16;
            int i18 = this.f4579n0;
            if (i16 < i18) {
                this.f4557c0 = i18;
            }
        }
    }

    public float q(int i8) {
        if (i8 == 0) {
            return this.f4581o0;
        }
        if (i8 == 1) {
            return this.f4583p0;
        }
        return -1.0f;
    }

    public void q0() {
        this.f4586r = true;
    }

    public void q1(LinearSystem linearSystem, boolean z7) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int x7 = linearSystem.x(this.O);
        int x8 = linearSystem.x(this.P);
        int x9 = linearSystem.x(this.Q);
        int x10 = linearSystem.x(this.R);
        if (z7 && (horizontalWidgetRun = this.f4560e) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.f4760h;
            if (dependencyNode.f4709j) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.f4761i;
                if (dependencyNode2.f4709j) {
                    x7 = dependencyNode.f4706g;
                    x9 = dependencyNode2.f4706g;
                }
            }
        }
        if (z7 && (verticalWidgetRun = this.f4562f) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.f4760h;
            if (dependencyNode3.f4709j) {
                DependencyNode dependencyNode4 = verticalWidgetRun.f4761i;
                if (dependencyNode4.f4709j) {
                    x8 = dependencyNode3.f4706g;
                    x10 = dependencyNode4.f4706g;
                }
            }
        }
        int i8 = x10 - x8;
        if (x9 - x7 < 0 || i8 < 0 || x7 == Integer.MIN_VALUE || x7 == Integer.MAX_VALUE || x8 == Integer.MIN_VALUE || x8 == Integer.MAX_VALUE || x9 == Integer.MIN_VALUE || x9 == Integer.MAX_VALUE || x10 == Integer.MIN_VALUE || x10 == Integer.MAX_VALUE) {
            x10 = 0;
            x7 = 0;
            x8 = 0;
            x9 = 0;
        }
        J0(x7, x8, x9, x10);
    }

    public int r() {
        return Y() + this.f4557c0;
    }

    public void r0() {
        this.f4588s = true;
    }

    public Object s() {
        return this.f4585q0;
    }

    public boolean s0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.Z;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour2 || dimensionBehaviourArr[1] != dimensionBehaviour2) {
            return false;
        }
        return true;
    }

    public String t() {
        return this.f4593u0;
    }

    public void t0() {
        this.O.q();
        this.P.q();
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.f4553a0 = null;
        this.I = 0.0f;
        this.f4555b0 = 0;
        this.f4557c0 = 0;
        this.f4559d0 = 0.0f;
        this.f4561e0 = -1;
        this.f4563f0 = 0;
        this.f4565g0 = 0;
        this.f4571j0 = 0;
        this.f4573k0 = 0;
        this.f4575l0 = 0;
        this.f4577m0 = 0;
        this.f4579n0 = 0;
        float f8 = K0;
        this.f4581o0 = f8;
        this.f4583p0 = f8;
        DimensionBehaviour[] dimensionBehaviourArr = this.Z;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f4585q0 = null;
        this.f4587r0 = 0;
        this.f4589s0 = 0;
        this.f4595v0 = null;
        this.f4597w0 = false;
        this.f4599x0 = false;
        this.f4603z0 = 0;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = false;
        float[] fArr = this.D0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f4590t = -1;
        this.f4592u = -1;
        int[] iArr = this.H;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f4596w = 0;
        this.f4598x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.D = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f4602z = 0;
        this.C = 0;
        this.f4566h = false;
        this.F = -1;
        this.G = 1.0f;
        this.f4601y0 = false;
        boolean[] zArr = this.f4564g;
        zArr[0] = true;
        zArr[1] = true;
        this.L = false;
        boolean[] zArr2 = this.Y;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f4568i = true;
        int[] iArr2 = this.f4600y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f4574l = -1;
        this.f4576m = -1;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f4595v0 == null) {
            str = "";
        } else {
            str = "type: " + this.f4595v0 + " ";
        }
        sb.append(str);
        if (this.f4593u0 != null) {
            str2 = "id: " + this.f4593u0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f4563f0);
        sb.append(", ");
        sb.append(this.f4565g0);
        sb.append(") - (");
        sb.append(this.f4555b0);
        sb.append(" x ");
        sb.append(this.f4557c0);
        sb.append(")");
        return sb.toString();
    }

    public DimensionBehaviour u(int i8) {
        if (i8 == 0) {
            return A();
        }
        if (i8 == 1) {
            return T();
        }
        return null;
    }

    public void u0() {
        ConstraintWidget K = K();
        if (K != null && (K instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) K()).L1()) {
            return;
        }
        int size = this.X.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.X.get(i8).q();
        }
    }

    public float v() {
        return this.f4559d0;
    }

    public void v0() {
        this.f4582p = false;
        this.f4584q = false;
        this.f4586r = false;
        this.f4588s = false;
        int size = this.X.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.X.get(i8).r();
        }
    }

    public int w() {
        return this.f4561e0;
    }

    public void w0(Cache cache) {
        this.O.s(cache);
        this.P.s(cache);
        this.Q.s(cache);
        this.R.s(cache);
        this.S.s(cache);
        this.V.s(cache);
        this.T.s(cache);
        this.U.s(cache);
    }

    public int x() {
        if (this.f4589s0 == 8) {
            return 0;
        }
        return this.f4557c0;
    }

    public float y() {
        return this.f4581o0;
    }

    public int z() {
        return this.f4603z0;
    }
}
