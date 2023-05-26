package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b  reason: collision with root package name */
    private int f4533b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4534c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintWidget f4535d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f4536e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintAnchor f4537f;

    /* renamed from: i  reason: collision with root package name */
    SolverVariable f4540i;

    /* renamed from: a  reason: collision with root package name */
    private HashSet<ConstraintAnchor> f4532a = null;

    /* renamed from: g  reason: collision with root package name */
    public int f4538g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f4539h = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintAnchor$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4541a;

        static {
            int[] iArr = new int[Type.values().length];
            f4541a = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4541a[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4541a[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4541a[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4541a[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4541a[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4541a[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4541a[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4541a[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f4535d = constraintWidget;
        this.f4536e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i8) {
        return b(constraintAnchor, i8, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i8, int i9, boolean z7) {
        if (constraintAnchor == null) {
            q();
            return true;
        } else if (!z7 && !p(constraintAnchor)) {
            return false;
        } else {
            this.f4537f = constraintAnchor;
            if (constraintAnchor.f4532a == null) {
                constraintAnchor.f4532a = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.f4537f.f4532a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f4538g = i8;
            this.f4539h = i9;
            return true;
        }
    }

    public void c(int i8, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        HashSet<ConstraintAnchor> hashSet = this.f4532a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                Grouping.a(it.next().f4535d, i8, arrayList, widgetGroup);
            }
        }
    }

    public HashSet<ConstraintAnchor> d() {
        return this.f4532a;
    }

    public int e() {
        if (!this.f4534c) {
            return 0;
        }
        return this.f4533b;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f4535d.V() == 8) {
            return 0;
        }
        if (this.f4539h != Integer.MIN_VALUE && (constraintAnchor = this.f4537f) != null && constraintAnchor.f4535d.V() == 8) {
            return this.f4539h;
        }
        return this.f4538g;
    }

    public final ConstraintAnchor g() {
        switch (AnonymousClass1.f4541a[this.f4536e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f4535d.Q;
            case 3:
                return this.f4535d.O;
            case 4:
                return this.f4535d.R;
            case 5:
                return this.f4535d.P;
            default:
                throw new AssertionError(this.f4536e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f4535d;
    }

    public SolverVariable i() {
        return this.f4540i;
    }

    public ConstraintAnchor j() {
        return this.f4537f;
    }

    public Type k() {
        return this.f4536e;
    }

    public boolean l() {
        HashSet<ConstraintAnchor> hashSet = this.f4532a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f4532a;
        if (hashSet == null || hashSet.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean n() {
        return this.f4534c;
    }

    public boolean o() {
        if (this.f4537f != null) {
            return true;
        }
        return false;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        boolean z7;
        boolean z8;
        boolean z9 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type k8 = constraintAnchor.k();
        Type type = this.f4536e;
        if (k8 == type) {
            if (type == Type.BASELINE && (!constraintAnchor.h().Z() || !h().Z())) {
                return false;
            }
            return true;
        }
        switch (AnonymousClass1.f4541a[type.ordinal()]) {
            case 1:
                if (k8 == Type.BASELINE || k8 == Type.CENTER_X || k8 == Type.CENTER_Y) {
                    return false;
                }
                return true;
            case 2:
            case 3:
                if (k8 != Type.LEFT && k8 != Type.RIGHT) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (constraintAnchor.h() instanceof Guideline) {
                    return (z7 || k8 == Type.CENTER_X) ? true : true;
                }
                return z7;
            case 4:
            case 5:
                if (k8 != Type.TOP && k8 != Type.BOTTOM) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (constraintAnchor.h() instanceof Guideline) {
                    return (z8 || k8 == Type.CENTER_Y) ? true : true;
                }
                return z8;
            case 6:
                if (k8 == Type.LEFT || k8 == Type.RIGHT) {
                    return false;
                }
                return true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f4536e.name());
        }
    }

    public void q() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f4537f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f4532a) != null) {
            hashSet.remove(this);
            if (this.f4537f.f4532a.size() == 0) {
                this.f4537f.f4532a = null;
            }
        }
        this.f4532a = null;
        this.f4537f = null;
        this.f4538g = 0;
        this.f4539h = Integer.MIN_VALUE;
        this.f4534c = false;
        this.f4533b = 0;
    }

    public void r() {
        this.f4534c = false;
        this.f4533b = 0;
    }

    public void s(Cache cache) {
        SolverVariable solverVariable = this.f4540i;
        if (solverVariable == null) {
            this.f4540i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.h();
        }
    }

    public void t(int i8) {
        this.f4533b = i8;
        this.f4534c = true;
    }

    public String toString() {
        return this.f4535d.t() + ":" + this.f4536e.toString();
    }

    public void u(int i8) {
        if (o()) {
            this.f4539h = i8;
        }
    }
}
