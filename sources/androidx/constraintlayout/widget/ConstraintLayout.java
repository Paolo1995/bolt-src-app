package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.common.api.Api;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.internal.http2.Http2Connection;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static SharedValues D;
    Measurer A;
    private int B;
    private int C;

    /* renamed from: f  reason: collision with root package name */
    SparseArray<View> f4972f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<ConstraintHelper> f4973g;

    /* renamed from: h  reason: collision with root package name */
    protected ConstraintWidgetContainer f4974h;

    /* renamed from: i  reason: collision with root package name */
    private int f4975i;

    /* renamed from: j  reason: collision with root package name */
    private int f4976j;

    /* renamed from: k  reason: collision with root package name */
    private int f4977k;

    /* renamed from: l  reason: collision with root package name */
    private int f4978l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f4979m;

    /* renamed from: n  reason: collision with root package name */
    private int f4980n;

    /* renamed from: o  reason: collision with root package name */
    private ConstraintSet f4981o;

    /* renamed from: p  reason: collision with root package name */
    protected ConstraintLayoutStates f4982p;

    /* renamed from: q  reason: collision with root package name */
    private int f4983q;

    /* renamed from: r  reason: collision with root package name */
    private HashMap<String, Integer> f4984r;

    /* renamed from: s  reason: collision with root package name */
    private int f4985s;

    /* renamed from: t  reason: collision with root package name */
    private int f4986t;

    /* renamed from: u  reason: collision with root package name */
    int f4987u;

    /* renamed from: v  reason: collision with root package name */
    int f4988v;

    /* renamed from: w  reason: collision with root package name */
    int f4989w;

    /* renamed from: x  reason: collision with root package name */
    int f4990x;

    /* renamed from: y  reason: collision with root package name */
    private SparseArray<ConstraintWidget> f4991y;

    /* renamed from: z  reason: collision with root package name */
    private ConstraintsChangedListener f4992z;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4993a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f4993a = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4993a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4993a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4993a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Measurer implements BasicMeasure.Measurer {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f5044a;

        /* renamed from: b  reason: collision with root package name */
        int f5045b;

        /* renamed from: c  reason: collision with root package name */
        int f5046c;

        /* renamed from: d  reason: collision with root package name */
        int f5047d;

        /* renamed from: e  reason: collision with root package name */
        int f5048e;

        /* renamed from: f  reason: collision with root package name */
        int f5049f;

        /* renamed from: g  reason: collision with root package name */
        int f5050g;

        public Measurer(ConstraintLayout constraintLayout) {
            this.f5044a = constraintLayout;
        }

        private boolean d(int i8, int i9, int i10) {
            if (i8 == i9) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i8);
            View.MeasureSpec.getSize(i8);
            int mode2 = View.MeasureSpec.getMode(i9);
            int size = View.MeasureSpec.getSize(i9);
            if (mode2 == 1073741824) {
                if ((mode == Integer.MIN_VALUE || mode == 0) && i10 == size) {
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void a() {
            int childCount = this.f5044a.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = this.f5044a.getChildAt(i8);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).a(this.f5044a);
                }
            }
            int size = this.f5044a.f4973g.size();
            if (size > 0) {
                for (int i9 = 0; i9 < size; i9++) {
                    ((ConstraintHelper) this.f5044a.f4973g.get(i9)).q(this.f5044a);
                }
            }
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            int baseline;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            boolean z13;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z20;
            boolean z21;
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.V() == 8 && !constraintWidget.j0()) {
                measure.f4683e = 0;
                measure.f4684f = 0;
                measure.f4685g = 0;
            } else if (constraintWidget.K() == null) {
            } else {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f4679a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.f4680b;
                int i13 = measure.f4681c;
                int i14 = measure.f4682d;
                int i15 = this.f5045b + this.f5046c;
                int i16 = this.f5047d;
                View view = (View) constraintWidget.s();
                int[] iArr = AnonymousClass1.f4993a;
                int i17 = iArr[dimensionBehaviour.ordinal()];
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 != 4) {
                                makeMeasureSpec = 0;
                            } else {
                                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f5049f, i16, -2);
                                if (constraintWidget.f4596w == 1) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                int i18 = measure.f4688j;
                                if (i18 == BasicMeasure.Measure.f4677l || i18 == BasicMeasure.Measure.f4678m) {
                                    if (view.getMeasuredHeight() == constraintWidget.x()) {
                                        z20 = true;
                                    } else {
                                        z20 = false;
                                    }
                                    if (measure.f4688j != BasicMeasure.Measure.f4678m && z19 && ((!z19 || !z20) && !(view instanceof Placeholder) && !constraintWidget.n0())) {
                                        z21 = false;
                                    } else {
                                        z21 = true;
                                    }
                                    if (z21) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.W(), Pow2.MAX_POW2);
                                    }
                                }
                            }
                        } else {
                            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f5049f, i16 + constraintWidget.B(), -1);
                        }
                    } else {
                        makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f5049f, i16, -2);
                    }
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, Pow2.MAX_POW2);
                }
                int i19 = iArr[dimensionBehaviour2.ordinal()];
                if (i19 != 1) {
                    if (i19 != 2) {
                        if (i19 != 3) {
                            if (i19 != 4) {
                                makeMeasureSpec2 = 0;
                            } else {
                                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f5050g, i15, -2);
                                if (constraintWidget.f4598x == 1) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                int i20 = measure.f4688j;
                                if (i20 == BasicMeasure.Measure.f4677l || i20 == BasicMeasure.Measure.f4678m) {
                                    if (view.getMeasuredWidth() == constraintWidget.W()) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    if (measure.f4688j != BasicMeasure.Measure.f4678m && z16 && ((!z16 || !z17) && !(view instanceof Placeholder) && !constraintWidget.o0())) {
                                        z18 = false;
                                    } else {
                                        z18 = true;
                                    }
                                    if (z18) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.x(), Pow2.MAX_POW2);
                                    }
                                }
                            }
                        } else {
                            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f5050g, i15 + constraintWidget.U(), -1);
                        }
                    } else {
                        makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f5050g, i15, -2);
                    }
                } else {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, Pow2.MAX_POW2);
                }
                ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.K();
                if (constraintWidgetContainer != null && Optimizer.b(ConstraintLayout.this.f4980n, Spliterator.NONNULL) && view.getMeasuredWidth() == constraintWidget.W() && view.getMeasuredWidth() < constraintWidgetContainer.W() && view.getMeasuredHeight() == constraintWidget.x() && view.getMeasuredHeight() < constraintWidgetContainer.x() && view.getBaseline() == constraintWidget.p() && !constraintWidget.m0()) {
                    if (d(constraintWidget.C(), makeMeasureSpec, constraintWidget.W()) && d(constraintWidget.D(), makeMeasureSpec2, constraintWidget.x())) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if (z15) {
                        measure.f4683e = constraintWidget.W();
                        measure.f4684f = constraintWidget.x();
                        measure.f4685g = constraintWidget.p();
                        return;
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour3) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (dimensionBehaviour2 != dimensionBehaviour4 && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.FIXED) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                if (dimensionBehaviour != dimensionBehaviour4 && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z7 && constraintWidget.f4559d0 > 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z8 && constraintWidget.f4559d0 > 0.0f) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (view == null) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int i21 = measure.f4688j;
                if (i21 != BasicMeasure.Measure.f4677l && i21 != BasicMeasure.Measure.f4678m && z7 && constraintWidget.f4596w == 0 && z8 && constraintWidget.f4598x == 0) {
                    i12 = -1;
                    i10 = 0;
                    baseline = 0;
                    i8 = 0;
                } else {
                    if ((view instanceof VirtualLayout) && (constraintWidget instanceof androidx.constraintlayout.core.widgets.VirtualLayout)) {
                        ((VirtualLayout) view).u((androidx.constraintlayout.core.widgets.VirtualLayout) constraintWidget, makeMeasureSpec, makeMeasureSpec2);
                    } else {
                        view.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                    constraintWidget.V0(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    int i22 = constraintWidget.f4602z;
                    if (i22 > 0) {
                        i8 = Math.max(i22, measuredWidth);
                    } else {
                        i8 = measuredWidth;
                    }
                    int i23 = constraintWidget.A;
                    if (i23 > 0) {
                        i8 = Math.min(i23, i8);
                    }
                    int i24 = constraintWidget.C;
                    if (i24 > 0) {
                        i10 = Math.max(i24, measuredHeight);
                        i9 = makeMeasureSpec;
                    } else {
                        i9 = makeMeasureSpec;
                        i10 = measuredHeight;
                    }
                    int i25 = constraintWidget.D;
                    if (i25 > 0) {
                        i10 = Math.min(i25, i10);
                    }
                    if (!Optimizer.b(ConstraintLayout.this.f4980n, 1)) {
                        if (z11 && z9) {
                            i8 = (int) ((i10 * constraintWidget.f4559d0) + 0.5f);
                        } else if (z12 && z10) {
                            i10 = (int) ((i8 / constraintWidget.f4559d0) + 0.5f);
                        }
                    }
                    if (measuredWidth != i8 || measuredHeight != i10) {
                        if (measuredWidth != i8) {
                            i11 = View.MeasureSpec.makeMeasureSpec(i8, Pow2.MAX_POW2);
                        } else {
                            i11 = i9;
                        }
                        if (measuredHeight != i10) {
                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, Pow2.MAX_POW2);
                        }
                        view.measure(i11, makeMeasureSpec2);
                        constraintWidget.V0(i11, makeMeasureSpec2);
                        i8 = view.getMeasuredWidth();
                        i10 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                    i12 = -1;
                }
                if (baseline != i12) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (i8 == measure.f4681c && i10 == measure.f4682d) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                measure.f4687i = z14;
                if (layoutParams.f5007g0) {
                    z13 = true;
                }
                if (z13 && baseline != -1 && constraintWidget.p() != baseline) {
                    measure.f4687i = true;
                }
                measure.f4683e = i8;
                measure.f4684f = i10;
                measure.f4686h = z13;
                measure.f4685g = baseline;
            }
        }

        public void c(int i8, int i9, int i10, int i11, int i12, int i13) {
            this.f5045b = i10;
            this.f5046c = i11;
            this.f5047d = i12;
            this.f5048e = i13;
            this.f5049f = i8;
            this.f5050g = i9;
        }
    }

    public ConstraintLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4972f = new SparseArray<>();
        this.f4973g = new ArrayList<>(4);
        this.f4974h = new ConstraintWidgetContainer();
        this.f4975i = 0;
        this.f4976j = 0;
        this.f4977k = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f4978l = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f4979m = true;
        this.f4980n = 257;
        this.f4981o = null;
        this.f4982p = null;
        this.f4983q = -1;
        this.f4984r = new HashMap<>();
        this.f4985s = -1;
        this.f4986t = -1;
        this.f4987u = -1;
        this.f4988v = -1;
        this.f4989w = 0;
        this.f4990x = 0;
        this.f4991y = new SparseArray<>();
        this.A = new Measurer(this);
        this.B = 0;
        this.C = 0;
        q(attributeSet, 0, 0);
    }

    private boolean A() {
        int childCount = getChildCount();
        boolean z7 = false;
        int i8 = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            } else if (getChildAt(i8).isLayoutRequested()) {
                z7 = true;
                break;
            } else {
                i8++;
            }
        }
        if (z7) {
            w();
        }
        return z7;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    public static SharedValues getSharedValues() {
        if (D == null) {
            D = new SharedValues();
        }
        return D;
    }

    private final ConstraintWidget h(int i8) {
        if (i8 == 0) {
            return this.f4974h;
        }
        View view = this.f4972f.get(i8);
        if (view == null && (view = findViewById(i8)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f4974h;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f5037v0;
    }

    private void q(AttributeSet attributeSet, int i8, int i9) {
        this.f4974h.B0(this);
        this.f4974h.V1(this.A);
        this.f4972f.put(getId(), this);
        this.f4981o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f5303n1, i8, i9);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.f5387x1) {
                    this.f4975i = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4975i);
                } else if (index == R$styleable.f5395y1) {
                    this.f4976j = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4976j);
                } else if (index == R$styleable.f5371v1) {
                    this.f4977k = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4977k);
                } else if (index == R$styleable.f5379w1) {
                    this.f4978l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4978l);
                } else if (index == R$styleable.f5242g3) {
                    this.f4980n = obtainStyledAttributes.getInt(index, this.f4980n);
                } else if (index == R$styleable.f5196b2) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            t(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f4982p = null;
                        }
                    }
                } else if (index == R$styleable.F1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f4981o = constraintSet;
                        constraintSet.r(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f4981o = null;
                    }
                    this.f4983q = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4974h.W1(this.f4980n);
    }

    private void s() {
        this.f4979m = true;
        this.f4985s = -1;
        this.f4986t = -1;
        this.f4987u = -1;
        this.f4988v = -1;
        this.f4989w = 0;
        this.f4990x = 0;
    }

    private void w() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            ConstraintWidget p8 = p(getChildAt(i8));
            if (p8 != null) {
                p8.t0();
            }
        }
        if (isInEditMode) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    x(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    h(childAt.getId()).C0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f4983q != -1) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt2 = getChildAt(i10);
                if (childAt2.getId() == this.f4983q && (childAt2 instanceof Constraints)) {
                    this.f4981o = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.f4981o;
        if (constraintSet != null) {
            constraintSet.d(this, true);
        }
        this.f4974h.u1();
        int size = this.f4973g.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                this.f4973g.get(i11).s(this);
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt3 = getChildAt(i12);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).b(this);
            }
        }
        this.f4991y.clear();
        this.f4991y.put(0, this.f4974h);
        this.f4991y.put(getId(), this.f4974h);
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt4 = getChildAt(i13);
            this.f4991y.put(childAt4.getId(), p(childAt4));
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt5 = getChildAt(i14);
            ConstraintWidget p9 = p(childAt5);
            if (p9 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.f4974h.a(p9);
                d(isInEditMode, childAt5, p9, layoutParams, this.f4991y);
            }
        }
    }

    private void z(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i8, ConstraintAnchor.Type type) {
        View view = this.f4972f.get(i8);
        ConstraintWidget constraintWidget2 = sparseArray.get(i8);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.f5007g0 = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f5007g0 = true;
                layoutParams2.f5037v0.K0(true);
            }
            constraintWidget.o(type2).b(constraintWidget2.o(type), layoutParams.D, layoutParams.C, true);
            constraintWidget.K0(true);
            constraintWidget.o(ConstraintAnchor.Type.TOP).q();
            constraintWidget.o(ConstraintAnchor.Type.BOTTOM).q();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void d(boolean z7, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i8;
        layoutParams.a();
        layoutParams.f5039w0 = false;
        constraintWidget.j1(view.getVisibility());
        if (layoutParams.f5013j0) {
            constraintWidget.T0(true);
            constraintWidget.j1(8);
        }
        constraintWidget.B0(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).o(constraintWidget, this.f4974h.P1());
        }
        if (layoutParams.f5009h0) {
            androidx.constraintlayout.core.widgets.Guideline guideline = (androidx.constraintlayout.core.widgets.Guideline) constraintWidget;
            int i9 = layoutParams.f5031s0;
            int i10 = layoutParams.f5033t0;
            float f8 = layoutParams.f5035u0;
            if (f8 != -1.0f) {
                guideline.z1(f8);
                return;
            } else if (i9 != -1) {
                guideline.x1(i9);
                return;
            } else if (i10 != -1) {
                guideline.y1(i10);
                return;
            } else {
                return;
            }
        }
        int i11 = layoutParams.f5017l0;
        int i12 = layoutParams.f5019m0;
        int i13 = layoutParams.f5021n0;
        int i14 = layoutParams.f5023o0;
        int i15 = layoutParams.f5025p0;
        int i16 = layoutParams.f5027q0;
        float f9 = layoutParams.f5029r0;
        int i17 = layoutParams.f5024p;
        if (i17 != -1) {
            ConstraintWidget constraintWidget6 = sparseArray.get(i17);
            if (constraintWidget6 != null) {
                constraintWidget.l(constraintWidget6, layoutParams.f5028r, layoutParams.f5026q);
            }
        } else {
            if (i11 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray.get(i11);
                if (constraintWidget7 != null) {
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget.e0(type, constraintWidget7, type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i15);
                }
            } else if (i12 != -1 && (constraintWidget2 = sparseArray.get(i12)) != null) {
                constraintWidget.e0(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i15);
            }
            if (i13 != -1) {
                ConstraintWidget constraintWidget8 = sparseArray.get(i13);
                if (constraintWidget8 != null) {
                    constraintWidget.e0(ConstraintAnchor.Type.RIGHT, constraintWidget8, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i16);
                }
            } else if (i14 != -1 && (constraintWidget3 = sparseArray.get(i14)) != null) {
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.e0(type2, constraintWidget3, type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i16);
            }
            int i18 = layoutParams.f5010i;
            if (i18 != -1) {
                ConstraintWidget constraintWidget9 = sparseArray.get(i18);
                if (constraintWidget9 != null) {
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                    constraintWidget.e0(type3, constraintWidget9, type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f5040x);
                }
            } else {
                int i19 = layoutParams.f5012j;
                if (i19 != -1 && (constraintWidget4 = sparseArray.get(i19)) != null) {
                    constraintWidget.e0(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f5040x);
                }
            }
            int i20 = layoutParams.f5014k;
            if (i20 != -1) {
                ConstraintWidget constraintWidget10 = sparseArray.get(i20);
                if (constraintWidget10 != null) {
                    constraintWidget.e0(ConstraintAnchor.Type.BOTTOM, constraintWidget10, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f5042z);
                }
            } else {
                int i21 = layoutParams.f5016l;
                if (i21 != -1 && (constraintWidget5 = sparseArray.get(i21)) != null) {
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget.e0(type4, constraintWidget5, type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f5042z);
                }
            }
            int i22 = layoutParams.f5018m;
            if (i22 != -1) {
                z(constraintWidget, layoutParams, sparseArray, i22, ConstraintAnchor.Type.BASELINE);
            } else {
                int i23 = layoutParams.f5020n;
                if (i23 != -1) {
                    z(constraintWidget, layoutParams, sparseArray, i23, ConstraintAnchor.Type.TOP);
                } else {
                    int i24 = layoutParams.f5022o;
                    if (i24 != -1) {
                        z(constraintWidget, layoutParams, sparseArray, i24, ConstraintAnchor.Type.BOTTOM);
                    }
                }
            }
            if (f9 >= 0.0f) {
                constraintWidget.M0(f9);
            }
            float f10 = layoutParams.H;
            if (f10 >= 0.0f) {
                constraintWidget.d1(f10);
            }
        }
        if (z7 && ((i8 = layoutParams.X) != -1 || layoutParams.Y != -1)) {
            constraintWidget.b1(i8, layoutParams.Y);
        }
        if (!layoutParams.f5003e0) {
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                if (layoutParams.f4995a0) {
                    constraintWidget.P0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.P0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.o(ConstraintAnchor.Type.LEFT).f4538g = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                constraintWidget.o(ConstraintAnchor.Type.RIGHT).f4538g = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            } else {
                constraintWidget.P0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.k1(0);
            }
        } else {
            constraintWidget.P0(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.k1(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                constraintWidget.P0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
        if (!layoutParams.f5005f0) {
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                if (layoutParams.f4997b0) {
                    constraintWidget.g1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.g1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.o(ConstraintAnchor.Type.TOP).f4538g = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                constraintWidget.o(ConstraintAnchor.Type.BOTTOM).f4538g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            } else {
                constraintWidget.g1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.L0(0);
            }
        } else {
            constraintWidget.g1(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.L0(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                constraintWidget.g1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
        constraintWidget.D0(layoutParams.I);
        constraintWidget.R0(layoutParams.L);
        constraintWidget.i1(layoutParams.M);
        constraintWidget.N0(layoutParams.N);
        constraintWidget.e1(layoutParams.O);
        constraintWidget.l1(layoutParams.f5001d0);
        constraintWidget.Q0(layoutParams.P, layoutParams.R, layoutParams.T, layoutParams.V);
        constraintWidget.h1(layoutParams.Q, layoutParams.S, layoutParams.U, layoutParams.W);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.f4973g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f4973g.get(i8).r(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i10 = (int) ((parseInt / 1080.0f) * width);
                        int i11 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f8 = i10;
                        float f9 = i11;
                        float f10 = i10 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f8, f9, f10, f9, paint);
                        float parseInt4 = i11 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f10, f9, f10, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f8, parseInt4, paint);
                        canvas.drawLine(f8, parseInt4, f8, f9, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f8, f9, f10, parseInt4, paint);
                        canvas.drawLine(f8, parseInt4, f10, f9, paint);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void forceLayout() {
        s();
        super.forceLayout();
    }

    public Object g(int i8, Object obj) {
        if (i8 == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.f4984r;
            if (hashMap != null && hashMap.containsKey(str)) {
                return this.f4984r.get(str);
            }
            return null;
        }
        return null;
    }

    public int getMaxHeight() {
        return this.f4978l;
    }

    public int getMaxWidth() {
        return this.f4977k;
    }

    public int getMinHeight() {
        return this.f4976j;
    }

    public int getMinWidth() {
        return this.f4975i;
    }

    public int getOptimizationLevel() {
        return this.f4974h.J1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.f4974h.f4580o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.f4974h.f4580o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.f4974h.f4580o = "parent";
            }
        }
        if (this.f4974h.t() == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f4974h;
            constraintWidgetContainer.C0(constraintWidgetContainer.f4580o);
            Log.v("ConstraintLayout", " setDebugName " + this.f4974h.t());
        }
        Iterator<ConstraintWidget> it = this.f4974h.r1().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.s();
            if (view != null) {
                if (next.f4580o == null && (id = view.getId()) != -1) {
                    next.f4580o = getContext().getResources().getResourceEntryName(id);
                }
                if (next.t() == null) {
                    next.C0(next.f4580o);
                    Log.v("ConstraintLayout", " setDebugName " + next.t());
                }
            }
        }
        this.f4974h.O(sb);
        return sb.toString();
    }

    public View l(int i8) {
        return this.f4972f.get(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f5037v0;
            if ((childAt.getVisibility() != 8 || layoutParams.f5009h0 || layoutParams.f5011i0 || layoutParams.f5015k0 || isInEditMode) && !layoutParams.f5013j0) {
                int X = constraintWidget.X();
                int Y = constraintWidget.Y();
                int W = constraintWidget.W() + X;
                int x7 = constraintWidget.x() + Y;
                childAt.layout(X, Y, W, x7);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(X, Y, W, x7);
                }
            }
        }
        int size = this.f4973g.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.f4973g.get(i13).p(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.B == i8) {
            int i10 = this.C;
        }
        if (!this.f4979m) {
            int childCount = getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                } else if (getChildAt(i11).isLayoutRequested()) {
                    this.f4979m = true;
                    break;
                } else {
                    i11++;
                }
            }
        }
        boolean z7 = this.f4979m;
        this.B = i8;
        this.C = i9;
        this.f4974h.Y1(r());
        if (this.f4979m) {
            this.f4979m = false;
            if (A()) {
                this.f4974h.a2();
            }
        }
        v(this.f4974h, this.f4980n, i8, i9);
        u(i8, i9, this.f4974h.W(), this.f4974h.x(), this.f4974h.Q1(), this.f4974h.O1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget p8 = p(view);
        if ((view instanceof Guideline) && !(p8 instanceof androidx.constraintlayout.core.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.Guideline guideline = new androidx.constraintlayout.core.widgets.Guideline();
            layoutParams.f5037v0 = guideline;
            layoutParams.f5009h0 = true;
            guideline.A1(layoutParams.Z);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.t();
            ((LayoutParams) view.getLayoutParams()).f5011i0 = true;
            if (!this.f4973g.contains(constraintHelper)) {
                this.f4973g.add(constraintHelper);
            }
        }
        this.f4972f.put(view.getId(), view);
        this.f4979m = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f4972f.remove(view.getId());
        this.f4974h.t1(p(view));
        this.f4973g.remove(view);
        this.f4979m = true;
    }

    public final ConstraintWidget p(View view) {
        if (view == this) {
            return this.f4974h;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).f5037v0;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).f5037v0;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r() {
        boolean z7;
        if ((getContext().getApplicationInfo().flags & 4194304) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        s();
        super.requestLayout();
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f4981o = constraintSet;
    }

    @Override // android.view.View
    public void setId(int i8) {
        this.f4972f.remove(getId());
        super.setId(i8);
        this.f4972f.put(getId(), this);
    }

    public void setMaxHeight(int i8) {
        if (i8 == this.f4978l) {
            return;
        }
        this.f4978l = i8;
        requestLayout();
    }

    public void setMaxWidth(int i8) {
        if (i8 == this.f4977k) {
            return;
        }
        this.f4977k = i8;
        requestLayout();
    }

    public void setMinHeight(int i8) {
        if (i8 == this.f4976j) {
            return;
        }
        this.f4976j = i8;
        requestLayout();
    }

    public void setMinWidth(int i8) {
        if (i8 == this.f4975i) {
            return;
        }
        this.f4975i = i8;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.f4992z = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.f4982p;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.c(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i8) {
        this.f4980n = i8;
        this.f4974h.W1(i8);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void t(int i8) {
        this.f4982p = new ConstraintLayoutStates(getContext(), this, i8);
    }

    protected void u(int i8, int i9, int i10, int i11, boolean z7, boolean z8) {
        Measurer measurer = this.A;
        int i12 = measurer.f5048e;
        int resolveSizeAndState = View.resolveSizeAndState(i10 + measurer.f5047d, i8, 0);
        int min = Math.min(this.f4977k, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f4978l, View.resolveSizeAndState(i11 + i12, i9, 0) & 16777215);
        if (z7) {
            min |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z8) {
            min2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(min, min2);
        this.f4985s = min;
        this.f4986t = min2;
    }

    protected void v(ConstraintWidgetContainer constraintWidgetContainer, int i8, int i9, int i10) {
        int i11;
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i12 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.A.c(i9, i10, max, max2, paddingWidth, i12);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            i11 = Math.max(0, getPaddingLeft());
        } else if (r()) {
            i11 = max4;
        } else {
            i11 = max3;
        }
        int i13 = size - paddingWidth;
        int i14 = size2 - i12;
        y(constraintWidgetContainer, mode, i13, mode2, i14);
        constraintWidgetContainer.R1(i8, mode, i13, mode2, i14, this.f4985s, this.f4986t, i11, max);
    }

    public void x(int i8, Object obj, Object obj2) {
        if (i8 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f4984r == null) {
                this.f4984r = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f4984r.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    protected void y(ConstraintWidgetContainer constraintWidgetContainer, int i8, int i9, int i10, int i11) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Measurer measurer = this.A;
        int i12 = measurer.f5048e;
        int i13 = measurer.f5047d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i8 != Integer.MIN_VALUE) {
            if (i8 != 0) {
                if (i8 != 1073741824) {
                    dimensionBehaviour = dimensionBehaviour2;
                    i9 = 0;
                } else {
                    i9 = Math.min(this.f4977k - i13, i9);
                    dimensionBehaviour = dimensionBehaviour2;
                }
            } else {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i9 = Math.max(0, this.f4975i);
                }
                i9 = 0;
            }
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i9 = Math.max(0, this.f4975i);
            }
        }
        if (i10 != Integer.MIN_VALUE) {
            if (i10 != 0) {
                if (i10 == 1073741824) {
                    i11 = Math.min(this.f4978l - i12, i11);
                }
                i11 = 0;
            } else {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i11 = Math.max(0, this.f4976j);
                }
                i11 = 0;
            }
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i11 = Math.max(0, this.f4976j);
            }
        }
        if (i9 != constraintWidgetContainer.W() || i11 != constraintWidgetContainer.x()) {
            constraintWidgetContainer.N1();
        }
        constraintWidgetContainer.m1(0);
        constraintWidgetContainer.n1(0);
        constraintWidgetContainer.X0(this.f4977k - i13);
        constraintWidgetContainer.W0(this.f4978l - i12);
        constraintWidgetContainer.a1(0);
        constraintWidgetContainer.Z0(0);
        constraintWidgetContainer.P0(dimensionBehaviour);
        constraintWidgetContainer.k1(i9);
        constraintWidgetContainer.g1(dimensionBehaviour2);
        constraintWidgetContainer.L0(i11);
        constraintWidgetContainer.a1(this.f4975i - i13);
        constraintWidgetContainer.Z0(this.f4976j - i12);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f4972f = new SparseArray<>();
        this.f4973g = new ArrayList<>(4);
        this.f4974h = new ConstraintWidgetContainer();
        this.f4975i = 0;
        this.f4976j = 0;
        this.f4977k = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f4978l = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f4979m = true;
        this.f4980n = 257;
        this.f4981o = null;
        this.f4982p = null;
        this.f4983q = -1;
        this.f4984r = new HashMap<>();
        this.f4985s = -1;
        this.f4986t = -1;
        this.f4987u = -1;
        this.f4988v = -1;
        this.f4989w = 0;
        this.f4990x = 0;
        this.f4991y = new SparseArray<>();
        this.A = new Measurer(this);
        this.B = 0;
        this.C = 0;
        q(attributeSet, i8, 0);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        boolean E;
        boolean F;
        public float G;
        public float H;
        public String I;
        float J;
        int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* renamed from: a  reason: collision with root package name */
        public int f4994a;

        /* renamed from: a0  reason: collision with root package name */
        public boolean f4995a0;

        /* renamed from: b  reason: collision with root package name */
        public int f4996b;

        /* renamed from: b0  reason: collision with root package name */
        public boolean f4997b0;

        /* renamed from: c  reason: collision with root package name */
        public float f4998c;

        /* renamed from: c0  reason: collision with root package name */
        public String f4999c0;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5000d;

        /* renamed from: d0  reason: collision with root package name */
        public int f5001d0;

        /* renamed from: e  reason: collision with root package name */
        public int f5002e;

        /* renamed from: e0  reason: collision with root package name */
        boolean f5003e0;

        /* renamed from: f  reason: collision with root package name */
        public int f5004f;

        /* renamed from: f0  reason: collision with root package name */
        boolean f5005f0;

        /* renamed from: g  reason: collision with root package name */
        public int f5006g;

        /* renamed from: g0  reason: collision with root package name */
        boolean f5007g0;

        /* renamed from: h  reason: collision with root package name */
        public int f5008h;

        /* renamed from: h0  reason: collision with root package name */
        boolean f5009h0;

        /* renamed from: i  reason: collision with root package name */
        public int f5010i;

        /* renamed from: i0  reason: collision with root package name */
        boolean f5011i0;

        /* renamed from: j  reason: collision with root package name */
        public int f5012j;

        /* renamed from: j0  reason: collision with root package name */
        boolean f5013j0;

        /* renamed from: k  reason: collision with root package name */
        public int f5014k;

        /* renamed from: k0  reason: collision with root package name */
        boolean f5015k0;

        /* renamed from: l  reason: collision with root package name */
        public int f5016l;

        /* renamed from: l0  reason: collision with root package name */
        int f5017l0;

        /* renamed from: m  reason: collision with root package name */
        public int f5018m;

        /* renamed from: m0  reason: collision with root package name */
        int f5019m0;

        /* renamed from: n  reason: collision with root package name */
        public int f5020n;

        /* renamed from: n0  reason: collision with root package name */
        int f5021n0;

        /* renamed from: o  reason: collision with root package name */
        public int f5022o;

        /* renamed from: o0  reason: collision with root package name */
        int f5023o0;

        /* renamed from: p  reason: collision with root package name */
        public int f5024p;

        /* renamed from: p0  reason: collision with root package name */
        int f5025p0;

        /* renamed from: q  reason: collision with root package name */
        public int f5026q;

        /* renamed from: q0  reason: collision with root package name */
        int f5027q0;

        /* renamed from: r  reason: collision with root package name */
        public float f5028r;

        /* renamed from: r0  reason: collision with root package name */
        float f5029r0;

        /* renamed from: s  reason: collision with root package name */
        public int f5030s;

        /* renamed from: s0  reason: collision with root package name */
        int f5031s0;

        /* renamed from: t  reason: collision with root package name */
        public int f5032t;

        /* renamed from: t0  reason: collision with root package name */
        int f5033t0;

        /* renamed from: u  reason: collision with root package name */
        public int f5034u;

        /* renamed from: u0  reason: collision with root package name */
        float f5035u0;

        /* renamed from: v  reason: collision with root package name */
        public int f5036v;

        /* renamed from: v0  reason: collision with root package name */
        ConstraintWidget f5037v0;

        /* renamed from: w  reason: collision with root package name */
        public int f5038w;

        /* renamed from: w0  reason: collision with root package name */
        public boolean f5039w0;

        /* renamed from: x  reason: collision with root package name */
        public int f5040x;

        /* renamed from: y  reason: collision with root package name */
        public int f5041y;

        /* renamed from: z  reason: collision with root package name */
        public int f5042z;

        /* loaded from: classes.dex */
        private static class Table {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f5043a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f5043a = sparseIntArray;
                sparseIntArray.append(R$styleable.R2, 64);
                sparseIntArray.append(R$styleable.f5364u2, 65);
                sparseIntArray.append(R$styleable.D2, 8);
                sparseIntArray.append(R$styleable.E2, 9);
                sparseIntArray.append(R$styleable.G2, 10);
                sparseIntArray.append(R$styleable.H2, 11);
                sparseIntArray.append(R$styleable.N2, 12);
                sparseIntArray.append(R$styleable.M2, 13);
                sparseIntArray.append(R$styleable.f5277k2, 14);
                sparseIntArray.append(R$styleable.f5268j2, 15);
                sparseIntArray.append(R$styleable.f5232f2, 16);
                sparseIntArray.append(R$styleable.f5250h2, 52);
                sparseIntArray.append(R$styleable.f5241g2, 53);
                sparseIntArray.append(R$styleable.f5286l2, 2);
                sparseIntArray.append(R$styleable.f5304n2, 3);
                sparseIntArray.append(R$styleable.f5295m2, 4);
                sparseIntArray.append(R$styleable.W2, 49);
                sparseIntArray.append(R$styleable.X2, 50);
                sparseIntArray.append(R$styleable.f5340r2, 5);
                sparseIntArray.append(R$styleable.f5348s2, 6);
                sparseIntArray.append(R$styleable.f5356t2, 7);
                sparseIntArray.append(R$styleable.f5187a2, 67);
                sparseIntArray.append(R$styleable.f5312o1, 1);
                sparseIntArray.append(R$styleable.I2, 17);
                sparseIntArray.append(R$styleable.J2, 18);
                sparseIntArray.append(R$styleable.f5331q2, 19);
                sparseIntArray.append(R$styleable.f5322p2, 20);
                sparseIntArray.append(R$styleable.f5197b3, 21);
                sparseIntArray.append(R$styleable.f5224e3, 22);
                sparseIntArray.append(R$styleable.f5206c3, 23);
                sparseIntArray.append(R$styleable.Z2, 24);
                sparseIntArray.append(R$styleable.f5215d3, 25);
                sparseIntArray.append(R$styleable.f5188a3, 26);
                sparseIntArray.append(R$styleable.Y2, 55);
                sparseIntArray.append(R$styleable.f5233f3, 54);
                sparseIntArray.append(R$styleable.f5404z2, 29);
                sparseIntArray.append(R$styleable.O2, 30);
                sparseIntArray.append(R$styleable.f5313o2, 44);
                sparseIntArray.append(R$styleable.B2, 45);
                sparseIntArray.append(R$styleable.Q2, 46);
                sparseIntArray.append(R$styleable.A2, 47);
                sparseIntArray.append(R$styleable.P2, 48);
                sparseIntArray.append(R$styleable.f5214d2, 27);
                sparseIntArray.append(R$styleable.f5205c2, 28);
                sparseIntArray.append(R$styleable.S2, 31);
                sparseIntArray.append(R$styleable.f5372v2, 32);
                sparseIntArray.append(R$styleable.U2, 33);
                sparseIntArray.append(R$styleable.T2, 34);
                sparseIntArray.append(R$styleable.V2, 35);
                sparseIntArray.append(R$styleable.f5388x2, 36);
                sparseIntArray.append(R$styleable.f5380w2, 37);
                sparseIntArray.append(R$styleable.f5396y2, 38);
                sparseIntArray.append(R$styleable.C2, 39);
                sparseIntArray.append(R$styleable.L2, 40);
                sparseIntArray.append(R$styleable.F2, 41);
                sparseIntArray.append(R$styleable.f5259i2, 42);
                sparseIntArray.append(R$styleable.f5223e2, 43);
                sparseIntArray.append(R$styleable.K2, 51);
                sparseIntArray.append(R$styleable.f5251h3, 66);
            }

            private Table() {
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4994a = -1;
            this.f4996b = -1;
            this.f4998c = -1.0f;
            this.f5000d = true;
            this.f5002e = -1;
            this.f5004f = -1;
            this.f5006g = -1;
            this.f5008h = -1;
            this.f5010i = -1;
            this.f5012j = -1;
            this.f5014k = -1;
            this.f5016l = -1;
            this.f5018m = -1;
            this.f5020n = -1;
            this.f5022o = -1;
            this.f5024p = -1;
            this.f5026q = 0;
            this.f5028r = 0.0f;
            this.f5030s = -1;
            this.f5032t = -1;
            this.f5034u = -1;
            this.f5036v = -1;
            this.f5038w = Integer.MIN_VALUE;
            this.f5040x = Integer.MIN_VALUE;
            this.f5041y = Integer.MIN_VALUE;
            this.f5042z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4995a0 = false;
            this.f4997b0 = false;
            this.f4999c0 = null;
            this.f5001d0 = 0;
            this.f5003e0 = true;
            this.f5005f0 = true;
            this.f5007g0 = false;
            this.f5009h0 = false;
            this.f5011i0 = false;
            this.f5013j0 = false;
            this.f5015k0 = false;
            this.f5017l0 = -1;
            this.f5019m0 = -1;
            this.f5021n0 = -1;
            this.f5023o0 = -1;
            this.f5025p0 = Integer.MIN_VALUE;
            this.f5027q0 = Integer.MIN_VALUE;
            this.f5029r0 = 0.5f;
            this.f5037v0 = new ConstraintWidget();
            this.f5039w0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5303n1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                int i9 = Table.f5043a.get(index);
                switch (i9) {
                    case 1:
                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f5024p);
                        this.f5024p = resourceId;
                        if (resourceId == -1) {
                            this.f5024p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f5026q = obtainStyledAttributes.getDimensionPixelSize(index, this.f5026q);
                        break;
                    case 4:
                        float f8 = obtainStyledAttributes.getFloat(index, this.f5028r) % 360.0f;
                        this.f5028r = f8;
                        if (f8 < 0.0f) {
                            this.f5028r = (360.0f - f8) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f4994a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4994a);
                        break;
                    case 6:
                        this.f4996b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4996b);
                        break;
                    case 7:
                        this.f4998c = obtainStyledAttributes.getFloat(index, this.f4998c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f5002e);
                        this.f5002e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f5002e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f5004f);
                        this.f5004f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f5004f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f5006g);
                        this.f5006g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f5006g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f5008h);
                        this.f5008h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f5008h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f5010i);
                        this.f5010i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f5010i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f5012j);
                        this.f5012j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f5012j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f5014k);
                        this.f5014k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f5014k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f5016l);
                        this.f5016l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f5016l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f5018m);
                        this.f5018m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f5018m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f5030s);
                        this.f5030s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f5030s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f5032t);
                        this.f5032t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f5032t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f5034u);
                        this.f5034u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f5034u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f5036v);
                        this.f5036v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f5036v = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f5038w = obtainStyledAttributes.getDimensionPixelSize(index, this.f5038w);
                        break;
                    case 22:
                        this.f5040x = obtainStyledAttributes.getDimensionPixelSize(index, this.f5040x);
                        break;
                    case 23:
                        this.f5041y = obtainStyledAttributes.getDimensionPixelSize(index, this.f5041y);
                        break;
                    case 24:
                        this.f5042z = obtainStyledAttributes.getDimensionPixelSize(index, this.f5042z);
                        break;
                    case 25:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.f4995a0 = obtainStyledAttributes.getBoolean(index, this.f4995a0);
                        break;
                    case 28:
                        this.f4997b0 = obtainStyledAttributes.getBoolean(index, this.f4997b0);
                        break;
                    case 29:
                        this.G = obtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 30:
                        this.H = obtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case 31:
                        int i10 = obtainStyledAttributes.getInt(index, 0);
                        this.P = i10;
                        if (i10 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i11 = obtainStyledAttributes.getInt(index, 0);
                        this.Q = i11;
                        if (i11 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.V = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case 36:
                        try {
                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.U) == -2) {
                                this.U = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.W = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i9) {
                            case 44:
                                ConstraintSet.w(this, obtainStyledAttributes.getString(index));
                                continue;
                            case 45:
                                this.L = obtainStyledAttributes.getFloat(index, this.L);
                                continue;
                            case 46:
                                this.M = obtainStyledAttributes.getFloat(index, this.M);
                                continue;
                            case 47:
                                this.N = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.O = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.X = obtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                continue;
                            case 50:
                                this.Y = obtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                continue;
                            case 51:
                                this.f4999c0 = obtainStyledAttributes.getString(index);
                                continue;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f5020n);
                                this.f5020n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f5020n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f5022o);
                                this.f5022o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f5022o = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 54:
                                this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                continue;
                            case 55:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                continue;
                            default:
                                switch (i9) {
                                    case 64:
                                        ConstraintSet.u(this, obtainStyledAttributes, index, 0);
                                        this.E = true;
                                        continue;
                                    case 65:
                                        ConstraintSet.u(this, obtainStyledAttributes, index, 1);
                                        this.F = true;
                                        continue;
                                    case 66:
                                        this.f5001d0 = obtainStyledAttributes.getInt(index, this.f5001d0);
                                        continue;
                                    case 67:
                                        this.f5000d = obtainStyledAttributes.getBoolean(index, this.f5000d);
                                        continue;
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f5009h0 = false;
            this.f5003e0 = true;
            this.f5005f0 = true;
            int i8 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i8 == -2 && this.f4995a0) {
                this.f5003e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i9 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i9 == -2 && this.f4997b0) {
                this.f5005f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i8 == 0 || i8 == -1) {
                this.f5003e0 = false;
                if (i8 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f4995a0 = true;
                }
            }
            if (i9 == 0 || i9 == -1) {
                this.f5005f0 = false;
                if (i9 == 0 && this.Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f4997b0 = true;
                }
            }
            if (this.f4998c != -1.0f || this.f4994a != -1 || this.f4996b != -1) {
                this.f5009h0 = true;
                this.f5003e0 = true;
                this.f5005f0 = true;
                if (!(this.f5037v0 instanceof androidx.constraintlayout.core.widgets.Guideline)) {
                    this.f5037v0 = new androidx.constraintlayout.core.widgets.Guideline();
                }
                ((androidx.constraintlayout.core.widgets.Guideline) this.f5037v0).A1(this.Z);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f4994a = -1;
            this.f4996b = -1;
            this.f4998c = -1.0f;
            this.f5000d = true;
            this.f5002e = -1;
            this.f5004f = -1;
            this.f5006g = -1;
            this.f5008h = -1;
            this.f5010i = -1;
            this.f5012j = -1;
            this.f5014k = -1;
            this.f5016l = -1;
            this.f5018m = -1;
            this.f5020n = -1;
            this.f5022o = -1;
            this.f5024p = -1;
            this.f5026q = 0;
            this.f5028r = 0.0f;
            this.f5030s = -1;
            this.f5032t = -1;
            this.f5034u = -1;
            this.f5036v = -1;
            this.f5038w = Integer.MIN_VALUE;
            this.f5040x = Integer.MIN_VALUE;
            this.f5041y = Integer.MIN_VALUE;
            this.f5042z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4995a0 = false;
            this.f4997b0 = false;
            this.f4999c0 = null;
            this.f5001d0 = 0;
            this.f5003e0 = true;
            this.f5005f0 = true;
            this.f5007g0 = false;
            this.f5009h0 = false;
            this.f5011i0 = false;
            this.f5013j0 = false;
            this.f5015k0 = false;
            this.f5017l0 = -1;
            this.f5019m0 = -1;
            this.f5021n0 = -1;
            this.f5023o0 = -1;
            this.f5025p0 = Integer.MIN_VALUE;
            this.f5027q0 = Integer.MIN_VALUE;
            this.f5029r0 = 0.5f;
            this.f5037v0 = new ConstraintWidget();
            this.f5039w0 = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4994a = -1;
            this.f4996b = -1;
            this.f4998c = -1.0f;
            this.f5000d = true;
            this.f5002e = -1;
            this.f5004f = -1;
            this.f5006g = -1;
            this.f5008h = -1;
            this.f5010i = -1;
            this.f5012j = -1;
            this.f5014k = -1;
            this.f5016l = -1;
            this.f5018m = -1;
            this.f5020n = -1;
            this.f5022o = -1;
            this.f5024p = -1;
            this.f5026q = 0;
            this.f5028r = 0.0f;
            this.f5030s = -1;
            this.f5032t = -1;
            this.f5034u = -1;
            this.f5036v = -1;
            this.f5038w = Integer.MIN_VALUE;
            this.f5040x = Integer.MIN_VALUE;
            this.f5041y = Integer.MIN_VALUE;
            this.f5042z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4995a0 = false;
            this.f4997b0 = false;
            this.f4999c0 = null;
            this.f5001d0 = 0;
            this.f5003e0 = true;
            this.f5005f0 = true;
            this.f5007g0 = false;
            this.f5009h0 = false;
            this.f5011i0 = false;
            this.f5013j0 = false;
            this.f5015k0 = false;
            this.f5017l0 = -1;
            this.f5019m0 = -1;
            this.f5021n0 = -1;
            this.f5023o0 = -1;
            this.f5025p0 = Integer.MIN_VALUE;
            this.f5027q0 = Integer.MIN_VALUE;
            this.f5029r0 = 0.5f;
            this.f5037v0 = new ConstraintWidget();
            this.f5039w0 = false;
        }
    }
}
