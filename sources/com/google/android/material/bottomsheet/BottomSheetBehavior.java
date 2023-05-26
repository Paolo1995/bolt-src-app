package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: h0  reason: collision with root package name */
    private static final int f12988h0 = R$style.Widget_Design_BottomSheet_Modal;
    private boolean A;
    private final BottomSheetBehavior<V>.StateSettlingTracker B;
    private ValueAnimator C;
    int D;
    int E;
    int F;
    float G;
    int H;
    float I;
    boolean J;
    private boolean K;
    private boolean L;
    int M;
    int N;
    ViewDragHelper O;
    private boolean P;
    private int Q;
    private boolean R;
    private float S;
    private int T;
    int U;
    int V;
    WeakReference<V> W;
    WeakReference<View> X;
    WeakReference<View> Y;
    @NonNull
    private final ArrayList<BottomSheetCallback> Z;

    /* renamed from: a  reason: collision with root package name */
    private int f12989a;

    /* renamed from: a0  reason: collision with root package name */
    private VelocityTracker f12990a0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12991b;

    /* renamed from: b0  reason: collision with root package name */
    int f12992b0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12993c;

    /* renamed from: c0  reason: collision with root package name */
    private int f12994c0;

    /* renamed from: d  reason: collision with root package name */
    private float f12995d;

    /* renamed from: d0  reason: collision with root package name */
    boolean f12996d0;

    /* renamed from: e  reason: collision with root package name */
    private int f12997e;

    /* renamed from: e0  reason: collision with root package name */
    private Map<View, Integer> f12998e0;

    /* renamed from: f  reason: collision with root package name */
    private int f12999f;

    /* renamed from: f0  reason: collision with root package name */
    final SparseIntArray f13000f0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13001g;

    /* renamed from: g0  reason: collision with root package name */
    private final ViewDragHelper.Callback f13002g0;

    /* renamed from: h  reason: collision with root package name */
    private int f13003h;

    /* renamed from: i  reason: collision with root package name */
    private int f13004i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialShapeDrawable f13005j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f13006k;

    /* renamed from: l  reason: collision with root package name */
    private int f13007l;

    /* renamed from: m  reason: collision with root package name */
    private int f13008m;

    /* renamed from: n  reason: collision with root package name */
    private int f13009n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13010o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13011p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13012q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13013r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13014s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13015t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f13016u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f13017v;

    /* renamed from: w  reason: collision with root package name */
    private int f13018w;

    /* renamed from: x  reason: collision with root package name */
    private int f13019x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13020y;

    /* renamed from: z  reason: collision with root package name */
    private ShapeAppearanceModel f13021z;

    /* loaded from: classes.dex */
    public static abstract class BottomSheetCallback {
        void a(@NonNull View view) {
        }

        public abstract void b(@NonNull View view, float f8);

        public abstract void c(@NonNull View view, int i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class StateSettlingTracker {

        /* renamed from: a  reason: collision with root package name */
        private int f13037a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13038b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f13039c;

        private StateSettlingTracker() {
            this.f13039c = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    StateSettlingTracker.this.f13038b = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.O;
                    if (viewDragHelper != null && viewDragHelper.m(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        stateSettlingTracker.c(stateSettlingTracker.f13037a);
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.M == 2) {
                        bottomSheetBehavior.R0(stateSettlingTracker2.f13037a);
                    }
                }
            };
        }

        void c(int i8) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.W;
            if (weakReference != null && weakReference.get() != null) {
                this.f13037a = i8;
                if (!this.f13038b) {
                    ViewCompat.k0(BottomSheetBehavior.this.W.get(), this.f13039c);
                    this.f13038b = true;
                }
            }
        }
    }

    public BottomSheetBehavior() {
        this.f12989a = 0;
        this.f12991b = true;
        this.f12993c = false;
        this.f13007l = -1;
        this.f13008m = -1;
        this.B = new StateSettlingTracker();
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = 4;
        this.N = 4;
        this.S = 0.1f;
        this.Z = new ArrayList<>();
        this.f13000f0 = new SparseIntArray();
        this.f13002g0 = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4

            /* renamed from: a  reason: collision with root package name */
            private long f13028a;

            private boolean n(@NonNull View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (top > (bottomSheetBehavior.V + bottomSheetBehavior.m0()) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(@NonNull View view, int i8, int i9) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(@NonNull View view, int i8, int i9) {
                return MathUtils.b(i8, BottomSheetBehavior.this.m0(), e(view));
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(@NonNull View view) {
                if (BottomSheetBehavior.this.d0()) {
                    return BottomSheetBehavior.this.V;
                }
                return BottomSheetBehavior.this.H;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i8) {
                if (i8 == 1 && BottomSheetBehavior.this.L) {
                    BottomSheetBehavior.this.R0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(@NonNull View view, int i8, int i9, int i10, int i11) {
                BottomSheetBehavior.this.i0(i9);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
                if (r11.T0(r4, (r10 * 100.0f) / r11.V) != false) goto L5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
                if (r10 > r8.f13029b.F) goto L6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
                if (java.lang.Math.abs(r9.getTop() - r8.f13029b.m0()) < java.lang.Math.abs(r9.getTop() - r8.f13029b.F)) goto L5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00d0, code lost:
                if (r8.f13029b.W0() == false) goto L6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00f2, code lost:
                if (java.lang.Math.abs(r10 - r8.f13029b.E) < java.lang.Math.abs(r10 - r8.f13029b.H)) goto L5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x010e, code lost:
                if (r8.f13029b.W0() != false) goto L13;
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x0128, code lost:
                if (r8.f13029b.W0() == false) goto L6;
             */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(@androidx.annotation.NonNull android.view.View r9, float r10, float r11) {
                /*
                    Method dump skipped, instructions count: 309
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(@NonNull View view, int i8) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i9 = bottomSheetBehavior.M;
                if (i9 == 1 || bottomSheetBehavior.f12996d0) {
                    return false;
                }
                if (i9 == 3 && bottomSheetBehavior.f12992b0 == i8) {
                    WeakReference<View> weakReference = bottomSheetBehavior.Y;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.f13028a = System.currentTimeMillis();
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.W;
                if (weakReference2 != null && weakReference2.get() == view) {
                    return true;
                }
                return false;
            }
        };
    }

    private void A0() {
        this.f12992b0 = -1;
        VelocityTracker velocityTracker = this.f12990a0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f12990a0 = null;
        }
    }

    private void B0(@NonNull SavedState savedState) {
        int i8 = this.f12989a;
        if (i8 == 0) {
            return;
        }
        if (i8 == -1 || (i8 & 1) == 1) {
            this.f12999f = savedState.f13033i;
        }
        if (i8 == -1 || (i8 & 2) == 2) {
            this.f12991b = savedState.f13034j;
        }
        if (i8 == -1 || (i8 & 4) == 4) {
            this.J = savedState.f13035k;
        }
        if (i8 == -1 || (i8 & 8) == 8) {
            this.K = savedState.f13036l;
        }
    }

    private void C0(V v7, Runnable runnable) {
        if (w0(v7)) {
            v7.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void S0(@NonNull View view) {
        final boolean z7;
        if (Build.VERSION.SDK_INT >= 29 && !t0() && !this.f13001g) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!this.f13011p && !this.f13012q && !this.f13013r && !this.f13015t && !this.f13016u && !this.f13017v && !z7) {
            return;
        }
        ViewUtils.b(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public androidx.core.view.WindowInsetsCompat a(android.view.View r11, androidx.core.view.WindowInsetsCompat r12, com.google.android.material.internal.ViewUtils.RelativePadding r13) {
                /*
                    r10 = this;
                    int r0 = androidx.core.view.WindowInsetsCompat.Type.c()
                    androidx.core.graphics.Insets r0 = r12.f(r0)
                    int r1 = androidx.core.view.WindowInsetsCompat.Type.b()
                    androidx.core.graphics.Insets r1 = r12.f(r1)
                    com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    int r3 = r0.f5738b
                    com.google.android.material.bottomsheet.BottomSheetBehavior.P(r2, r3)
                    boolean r2 = com.google.android.material.internal.ViewUtils.f(r11)
                    int r3 = r11.getPaddingBottom()
                    int r4 = r11.getPaddingLeft()
                    int r5 = r11.getPaddingRight()
                    com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.Q(r6)
                    if (r6 == 0) goto L41
                    com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    int r6 = r12.i()
                    com.google.android.material.bottomsheet.BottomSheetBehavior.S(r3, r6)
                    int r3 = r13.f13689d
                    com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.R(r6)
                    int r3 = r3 + r6
                L41:
                    com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.T(r6)
                    if (r6 == 0) goto L53
                    if (r2 == 0) goto L4e
                    int r4 = r13.f13688c
                    goto L50
                L4e:
                    int r4 = r13.f13686a
                L50:
                    int r6 = r0.f5737a
                    int r4 = r4 + r6
                L53:
                    com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.U(r6)
                    if (r6 == 0) goto L66
                    if (r2 == 0) goto L60
                    int r13 = r13.f13686a
                    goto L62
                L60:
                    int r13 = r13.f13688c
                L62:
                    int r2 = r0.f5739c
                    int r5 = r13 + r2
                L66:
                    android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                    android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                    com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.V(r2)
                    r6 = 0
                    r7 = 1
                    if (r2 == 0) goto L80
                    int r2 = r13.leftMargin
                    int r8 = r0.f5737a
                    if (r2 == r8) goto L80
                    r13.leftMargin = r8
                    r2 = 1
                    goto L81
                L80:
                    r2 = 0
                L81:
                    com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.W(r8)
                    if (r8 == 0) goto L92
                    int r8 = r13.rightMargin
                    int r9 = r0.f5739c
                    if (r8 == r9) goto L92
                    r13.rightMargin = r9
                    r2 = 1
                L92:
                    com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.F(r8)
                    if (r8 == 0) goto La3
                    int r8 = r13.topMargin
                    int r0 = r0.f5738b
                    if (r8 == r0) goto La3
                    r13.topMargin = r0
                    goto La4
                La3:
                    r7 = r2
                La4:
                    if (r7 == 0) goto La9
                    r11.setLayoutParams(r13)
                La9:
                    int r13 = r11.getPaddingTop()
                    r11.setPadding(r4, r13, r5, r3)
                    boolean r11 = r2
                    if (r11 == 0) goto Lbb
                    com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    int r13 = r1.f5740d
                    com.google.android.material.bottomsheet.BottomSheetBehavior.G(r11, r13)
                Lbb:
                    com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.Q(r11)
                    if (r11 != 0) goto Lc7
                    boolean r11 = r2
                    if (r11 == 0) goto Lcc
                Lc7:
                    com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                    com.google.android.material.bottomsheet.BottomSheetBehavior.H(r11, r6)
                Lcc:
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass3.a(android.view.View, androidx.core.view.WindowInsetsCompat, com.google.android.material.internal.ViewUtils$RelativePadding):androidx.core.view.WindowInsetsCompat");
            }
        });
    }

    private boolean U0() {
        if (this.O != null && (this.L || this.M == 1)) {
            return true;
        }
        return false;
    }

    private int X(View view, int i8, int i9) {
        return ViewCompat.c(view, view.getResources().getString(i8), f0(i9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(View view, int i8, boolean z7) {
        boolean z8;
        int q02 = q0(i8);
        ViewDragHelper viewDragHelper = this.O;
        if (viewDragHelper != null && (!z7 ? viewDragHelper.O(view, view.getLeft(), q02) : viewDragHelper.M(view.getLeft(), q02))) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            R0(2);
            b1(i8, true);
            this.B.c(i8);
            return;
        }
        R0(i8);
    }

    private void Z() {
        int b02 = b0();
        if (this.f12991b) {
            this.H = Math.max(this.V - b02, this.E);
        } else {
            this.H = this.V - b02;
        }
    }

    private void Z0() {
        WeakReference<V> weakReference = this.W;
        if (weakReference != null) {
            a1(weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.X;
        if (weakReference2 != null) {
            a1(weakReference2.get(), 1);
        }
    }

    private void a0() {
        this.F = (int) (this.V * (1.0f - this.G));
    }

    private void a1(View view, int i8) {
        if (view == null) {
            return;
        }
        e0(view, i8);
        int i9 = 6;
        if (!this.f12991b && this.M != 6) {
            this.f13000f0.put(i8, X(view, R$string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.J && v0() && this.M != 5) {
            z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6061y, 5);
        }
        int i10 = this.M;
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 == 6) {
                    z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6060x, 4);
                    z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6059w, 3);
                    return;
                }
                return;
            }
            if (this.f12991b) {
                i9 = 3;
            }
            z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6059w, i9);
            return;
        }
        if (this.f12991b) {
            i9 = 4;
        }
        z0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6060x, i9);
    }

    private int b0() {
        int i8;
        if (this.f13001g) {
            return Math.min(Math.max(this.f13003h, this.V - ((this.U * 9) / 16)), this.T) + this.f13018w;
        }
        if (!this.f13010o && !this.f13011p && (i8 = this.f13009n) > 0) {
            return Math.max(this.f12999f, i8 + this.f13004i);
        }
        return this.f12999f + this.f13018w;
    }

    private void b1(int i8, boolean z7) {
        boolean s02;
        ValueAnimator valueAnimator;
        if (i8 != 2 && this.A != (s02 = s0()) && this.f13005j != null) {
            this.A = s02;
            float f8 = 0.0f;
            if (z7 && (valueAnimator = this.C) != null) {
                if (valueAnimator.isRunning()) {
                    this.C.reverse();
                    return;
                }
                if (!s02) {
                    f8 = 1.0f;
                }
                this.C.setFloatValues(1.0f - f8, f8);
                this.C.start();
                return;
            }
            ValueAnimator valueAnimator2 = this.C;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.C.cancel();
            }
            MaterialShapeDrawable materialShapeDrawable = this.f13005j;
            if (!this.A) {
                f8 = 1.0f;
            }
            materialShapeDrawable.d0(f8);
        }
    }

    private float c0(int i8) {
        float f8;
        float f9;
        int i9 = this.H;
        if (i8 <= i9 && i9 != m0()) {
            int i10 = this.H;
            f8 = i10 - i8;
            f9 = i10 - m0();
        } else {
            int i11 = this.H;
            f8 = i11 - i8;
            f9 = this.V - i11;
        }
        return f8 / f9;
    }

    private void c1(boolean z7) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z7) {
            if (this.f12998e0 == null) {
                this.f12998e0 = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = coordinatorLayout.getChildAt(i8);
            if (childAt != this.W.get()) {
                if (z7) {
                    this.f12998e0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.f12993c) {
                        ViewCompat.D0(childAt, 4);
                    }
                } else if (this.f12993c && (map = this.f12998e0) != null && map.containsKey(childAt)) {
                    ViewCompat.D0(childAt, this.f12998e0.get(childAt).intValue());
                }
            }
        }
        if (!z7) {
            this.f12998e0 = null;
        } else if (this.f12993c) {
            this.W.get().sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d0() {
        if (u0() && v0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(boolean z7) {
        V v7;
        if (this.W != null) {
            Z();
            if (this.M == 4 && (v7 = this.W.get()) != null) {
                if (z7) {
                    Q0(4);
                } else {
                    v7.requestLayout();
                }
            }
        }
    }

    private void e0(View view, int i8) {
        if (view == null) {
            return;
        }
        ViewCompat.m0(view, 524288);
        ViewCompat.m0(view, 262144);
        ViewCompat.m0(view, 1048576);
        int i9 = this.f13000f0.get(i8, -1);
        if (i9 != -1) {
            ViewCompat.m0(view, i9);
            this.f13000f0.delete(i8);
        }
    }

    private AccessibilityViewCommand f0(final int i8) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean a(@NonNull View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.Q0(i8);
                return true;
            }
        };
    }

    private void g0(@NonNull Context context) {
        if (this.f13021z == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f13021z);
        this.f13005j = materialShapeDrawable;
        materialShapeDrawable.R(context);
        ColorStateList colorStateList = this.f13006k;
        if (colorStateList != null) {
            this.f13005j.c0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842801, typedValue, true);
        this.f13005j.setTint(typedValue.data);
    }

    private void h0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.C = ofFloat;
        ofFloat.setDuration(500L);
        this.C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.f13005j != null) {
                    BottomSheetBehavior.this.f13005j.d0(floatValue);
                }
            }
        });
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> k0(@NonNull V v7) {
        ViewGroup.LayoutParams layoutParams = v7.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior f8 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
            if (f8 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f8;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int l0(int i8, int i9, int i10, int i11) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, i9, i11);
        if (i10 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i10 = Math.min(size, i10);
            }
            return View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i10), Pow2.MAX_POW2);
    }

    private int q0(int i8) {
        if (i8 != 3) {
            if (i8 != 4) {
                if (i8 != 5) {
                    if (i8 == 6) {
                        return this.F;
                    }
                    throw new IllegalArgumentException("Invalid state to get top offset: " + i8);
                }
                return this.V;
            }
            return this.H;
        }
        return m0();
    }

    private float r0() {
        VelocityTracker velocityTracker = this.f12990a0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f12995d);
        return this.f12990a0.getYVelocity(this.f12992b0);
    }

    private boolean s0() {
        if (this.M == 3 && (this.f13020y || m0() == 0)) {
            return true;
        }
        return false;
    }

    private boolean w0(V v7) {
        ViewParent parent = v7.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.V(v7)) {
            return true;
        }
        return false;
    }

    private void z0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i8) {
        ViewCompat.o0(view, accessibilityActionCompat, null, f0(i8));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8, int i9) {
        this.Q = 0;
        this.R = false;
        if ((i8 & 2) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r4.getTop() <= r2.F) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        if (java.lang.Math.abs(r3 - r2.E) < java.lang.Math.abs(r3 - r2.H)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
        if (W0() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.H)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a7, code lost:
        if (java.lang.Math.abs(r3 - r2.F) < java.lang.Math.abs(r3 - r2.H)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a9, code lost:
        r0 = 6;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.m0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.R0(r0)
            return
        Lf:
            boolean r3 = r2.x0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.Y
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.R
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.Q
            r5 = 6
            r6 = 4
            if (r3 <= 0) goto L3a
            boolean r3 = r2.f12991b
            if (r3 == 0) goto L30
            goto Laa
        L30:
            int r3 = r4.getTop()
            int r6 = r2.F
            if (r3 <= r6) goto Laa
            goto La9
        L3a:
            boolean r3 = r2.J
            if (r3 == 0) goto L4a
            float r3 = r2.r0()
            boolean r3 = r2.V0(r4, r3)
            if (r3 == 0) goto L4a
            r0 = 5
            goto Laa
        L4a:
            int r3 = r2.Q
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f12991b
            if (r1 == 0) goto L68
            int r5 = r2.E
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.F
            if (r3 >= r1) goto L7e
            int r1 = r2.H
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.W0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f12991b
            if (r3 == 0) goto L94
        L92:
            r0 = 4
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.F
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = 6
        Laa:
            r3 = 0
            r2.Y0(r4, r0, r3)
            r2.R = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
        if (!v7.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.M == 1 && actionMasked == 0) {
            return true;
        }
        if (U0()) {
            this.O.F(motionEvent);
        }
        if (actionMasked == 0) {
            A0();
        }
        if (this.f12990a0 == null) {
            this.f12990a0 = VelocityTracker.obtain();
        }
        this.f12990a0.addMovement(motionEvent);
        if (U0() && actionMasked == 2 && !this.P && Math.abs(this.f12994c0 - motionEvent.getY()) > this.O.z()) {
            this.O.b(v7, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.P;
    }

    public void D0(boolean z7) {
        this.L = z7;
    }

    public void E0(int i8) {
        if (i8 >= 0) {
            this.D = i8;
            b1(this.M, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void F0(boolean z7) {
        int i8;
        if (this.f12991b == z7) {
            return;
        }
        this.f12991b = z7;
        if (this.W != null) {
            Z();
        }
        if (this.f12991b && this.M == 6) {
            i8 = 3;
        } else {
            i8 = this.M;
        }
        R0(i8);
        b1(this.M, true);
        Z0();
    }

    public void G0(boolean z7) {
        this.f13010o = z7;
    }

    public void H0(float f8) {
        if (f8 > 0.0f && f8 < 1.0f) {
            this.G = f8;
            if (this.W != null) {
                a0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void I0(boolean z7) {
        if (this.J != z7) {
            this.J = z7;
            if (!z7 && this.M == 5) {
                Q0(4);
            }
            Z0();
        }
    }

    public void J0(int i8) {
        this.f13008m = i8;
    }

    public void K0(int i8) {
        this.f13007l = i8;
    }

    public void L0(int i8) {
        M0(i8, false);
    }

    public final void M0(int i8, boolean z7) {
        boolean z8 = true;
        if (i8 == -1) {
            if (!this.f13001g) {
                this.f13001g = true;
            }
            z8 = false;
        } else {
            if (this.f13001g || this.f12999f != i8) {
                this.f13001g = false;
                this.f12999f = Math.max(0, i8);
            }
            z8 = false;
        }
        if (z8) {
            d1(z7);
        }
    }

    public void N0(int i8) {
        this.f12989a = i8;
    }

    public void O0(int i8) {
        this.f12997e = i8;
    }

    public void P0(boolean z7) {
        this.K = z7;
    }

    public void Q0(int i8) {
        String str;
        final int i9;
        if (i8 != 1 && i8 != 2) {
            if (!this.J && i8 == 5) {
                Log.w("BottomSheetBehavior", "Cannot set state: " + i8);
                return;
            }
            if (i8 == 6 && this.f12991b && q0(i8) <= this.E) {
                i9 = 3;
            } else {
                i9 = i8;
            }
            WeakReference<V> weakReference = this.W;
            if (weakReference != null && weakReference.get() != null) {
                final V v7 = this.W.get();
                C0(v7, new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BottomSheetBehavior.this.Y0(v7, i9, false);
                    }
                });
                return;
            }
            R0(i8);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("STATE_");
        if (i8 == 1) {
            str = "DRAGGING";
        } else {
            str = "SETTLING";
        }
        sb.append(str);
        sb.append(" should not be set externally.");
        throw new IllegalArgumentException(sb.toString());
    }

    void R0(int i8) {
        V v7;
        if (this.M == i8) {
            return;
        }
        this.M = i8;
        if (i8 == 4 || i8 == 3 || i8 == 6 || (this.J && i8 == 5)) {
            this.N = i8;
        }
        WeakReference<V> weakReference = this.W;
        if (weakReference == null || (v7 = weakReference.get()) == null) {
            return;
        }
        if (i8 == 3) {
            c1(true);
        } else if (i8 == 6 || i8 == 5 || i8 == 4) {
            c1(false);
        }
        b1(i8, true);
        for (int i9 = 0; i9 < this.Z.size(); i9++) {
            this.Z.get(i9).c(v7, i8);
        }
        Z0();
    }

    public boolean T0(long j8, float f8) {
        return false;
    }

    boolean V0(@NonNull View view, float f8) {
        if (this.K) {
            return true;
        }
        if (!v0() || view.getTop() < this.H) {
            return false;
        }
        if (Math.abs((view.getTop() + (f8 * this.S)) - this.H) / b0() > 0.5f) {
            return true;
        }
        return false;
    }

    public boolean W0() {
        return false;
    }

    public boolean X0() {
        return true;
    }

    public void Y(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.Z.contains(bottomSheetCallback)) {
            this.Z.add(bottomSheetCallback);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void g(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.g(layoutParams);
        this.W = null;
        this.O = null;
    }

    void i0(int i8) {
        V v7 = this.W.get();
        if (v7 != null && !this.Z.isEmpty()) {
            float c02 = c0(i8);
            for (int i9 = 0; i9 < this.Z.size(); i9++) {
                this.Z.get(i9).b(v7, c02);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void j() {
        super.j();
        this.W = null;
        this.O = null;
    }

    View j0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.X(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View j02 = j0(viewGroup.getChildAt(i8));
                if (j02 != null) {
                    return j02;
                }
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
        boolean z7;
        View view;
        ViewDragHelper viewDragHelper;
        if (v7.isShown() && this.L) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                A0();
            }
            if (this.f12990a0 == null) {
                this.f12990a0 = VelocityTracker.obtain();
            }
            this.f12990a0.addMovement(motionEvent);
            View view2 = null;
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.f12996d0 = false;
                    this.f12992b0 = -1;
                    if (this.P) {
                        this.P = false;
                        return false;
                    }
                }
            } else {
                int x7 = (int) motionEvent.getX();
                this.f12994c0 = (int) motionEvent.getY();
                if (this.M != 2) {
                    WeakReference<View> weakReference = this.Y;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.C(view, x7, this.f12994c0)) {
                        this.f12992b0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f12996d0 = true;
                    }
                }
                if (this.f12992b0 == -1 && !coordinatorLayout.C(v7, x7, this.f12994c0)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.P = z7;
            }
            if (!this.P && (viewDragHelper = this.O) != null && viewDragHelper.N(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.Y;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.P || this.M == 1 || coordinatorLayout.C(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || Math.abs(this.f12994c0 - motionEvent.getY()) <= this.O.z()) {
                return false;
            }
            return true;
        }
        this.P = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8) {
        if (ViewCompat.B(coordinatorLayout) && !ViewCompat.B(v7)) {
            v7.setFitsSystemWindows(true);
        }
        if (this.W == null) {
            this.f13003h = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.f12488c);
            S0(v7);
            this.W = new WeakReference<>(v7);
            MaterialShapeDrawable materialShapeDrawable = this.f13005j;
            if (materialShapeDrawable != null) {
                ViewCompat.w0(v7, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.f13005j;
                float f8 = this.I;
                if (f8 == -1.0f) {
                    f8 = ViewCompat.y(v7);
                }
                materialShapeDrawable2.b0(f8);
            } else {
                ColorStateList colorStateList = this.f13006k;
                if (colorStateList != null) {
                    ViewCompat.x0(v7, colorStateList);
                }
            }
            Z0();
            if (ViewCompat.C(v7) == 0) {
                ViewCompat.D0(v7, 1);
            }
        }
        if (this.O == null) {
            this.O = ViewDragHelper.o(coordinatorLayout, this.f13002g0);
        }
        int top = v7.getTop();
        coordinatorLayout.J(v7, i8);
        this.U = coordinatorLayout.getWidth();
        this.V = coordinatorLayout.getHeight();
        int height = v7.getHeight();
        this.T = height;
        int i9 = this.V;
        int i10 = i9 - height;
        int i11 = this.f13019x;
        if (i10 < i11) {
            if (this.f13014s) {
                this.T = i9;
            } else {
                this.T = i9 - i11;
            }
        }
        this.E = Math.max(0, i9 - this.T);
        a0();
        Z();
        int i12 = this.M;
        if (i12 == 3) {
            ViewCompat.d0(v7, m0());
        } else if (i12 == 6) {
            ViewCompat.d0(v7, this.F);
        } else if (this.J && i12 == 5) {
            ViewCompat.d0(v7, this.V);
        } else if (i12 == 4) {
            ViewCompat.d0(v7, this.H);
        } else if (i12 == 1 || i12 == 2) {
            ViewCompat.d0(v7, top - v7.getTop());
        }
        b1(this.M, false);
        this.Y = new WeakReference<>(j0(v7));
        for (int i13 = 0; i13 < this.Z.size(); i13++) {
            this.Z.get(i13).a(v7);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v7.getLayoutParams();
        v7.measure(l0(i8, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, this.f13007l, marginLayoutParams.width), l0(i10, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, this.f13008m, marginLayoutParams.height));
        return true;
    }

    public int m0() {
        int i8;
        if (this.f12991b) {
            return this.E;
        }
        int i9 = this.D;
        if (this.f13014s) {
            i8 = 0;
        } else {
            i8 = this.f13019x;
        }
        return Math.max(i9, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialShapeDrawable n0() {
        return this.f13005j;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, float f8, float f9) {
        WeakReference<View> weakReference;
        if (!x0() || (weakReference = this.Y) == null || view != weakReference.get()) {
            return false;
        }
        if (this.M == 3 && !super.o(coordinatorLayout, v7, view, f8, f9)) {
            return false;
        }
        return true;
    }

    public int o0() {
        if (this.f13001g) {
            return -1;
        }
        return this.f12999f;
    }

    public int p0() {
        return this.M;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, @NonNull int[] iArr, int i10) {
        View view2;
        if (i10 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.Y;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (x0() && view != view2) {
            return;
        }
        int top = v7.getTop();
        int i11 = top - i9;
        if (i9 > 0) {
            if (i11 < m0()) {
                int m02 = top - m0();
                iArr[1] = m02;
                ViewCompat.d0(v7, -m02);
                R0(3);
            } else if (!this.L) {
                return;
            } else {
                iArr[1] = i9;
                ViewCompat.d0(v7, -i9);
                R0(1);
            }
        } else if (i9 < 0 && !view.canScrollVertically(-1)) {
            if (i11 > this.H && !d0()) {
                int i12 = top - this.H;
                iArr[1] = i12;
                ViewCompat.d0(v7, -i12);
                R0(4);
            } else if (!this.L) {
                return;
            } else {
                iArr[1] = i9;
                ViewCompat.d0(v7, -i9);
                R0(1);
            }
        }
        i0(v7.getTop());
        this.Q = i9;
        this.R = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, int i10, int i11, int i12, @NonNull int[] iArr) {
    }

    public boolean t0() {
        return this.f13010o;
    }

    public boolean u0() {
        return this.J;
    }

    public boolean v0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.x(coordinatorLayout, v7, savedState.a());
        B0(savedState);
        int i8 = savedState.f13032h;
        if (i8 != 1 && i8 != 2) {
            this.M = i8;
            this.N = i8;
            return;
        }
        this.M = 4;
        this.N = 4;
    }

    public boolean x0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7) {
        return new SavedState(super.y(coordinatorLayout, v7), (BottomSheetBehavior<?>) this);
    }

    public void y0(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.Z.remove(bottomSheetCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        final int f13032h;

        /* renamed from: i  reason: collision with root package name */
        int f13033i;

        /* renamed from: j  reason: collision with root package name */
        boolean f13034j;

        /* renamed from: k  reason: collision with root package name */
        boolean f13035k;

        /* renamed from: l  reason: collision with root package name */
        boolean f13036l;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13032h = parcel.readInt();
            this.f13033i = parcel.readInt();
            this.f13034j = parcel.readInt() == 1;
            this.f13035k = parcel.readInt() == 1;
            this.f13036l = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f13032h);
            parcel.writeInt(this.f13033i);
            parcel.writeInt(this.f13034j ? 1 : 0);
            parcel.writeInt(this.f13035k ? 1 : 0);
            parcel.writeInt(this.f13036l ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f13032h = bottomSheetBehavior.M;
            this.f13033i = ((BottomSheetBehavior) bottomSheetBehavior).f12999f;
            this.f13034j = ((BottomSheetBehavior) bottomSheetBehavior).f12991b;
            this.f13035k = bottomSheetBehavior.J;
            this.f13036l = ((BottomSheetBehavior) bottomSheetBehavior).K;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i8;
        this.f12989a = 0;
        this.f12991b = true;
        this.f12993c = false;
        this.f13007l = -1;
        this.f13008m = -1;
        this.B = new StateSettlingTracker();
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = 4;
        this.N = 4;
        this.S = 0.1f;
        this.Z = new ArrayList<>();
        this.f13000f0 = new SparseIntArray();
        this.f13002g0 = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4

            /* renamed from: a  reason: collision with root package name */
            private long f13028a;

            private boolean n(@NonNull View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (top > (bottomSheetBehavior.V + bottomSheetBehavior.m0()) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(@NonNull View view, int i82, int i9) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(@NonNull View view, int i82, int i9) {
                return MathUtils.b(i82, BottomSheetBehavior.this.m0(), e(view));
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(@NonNull View view) {
                if (BottomSheetBehavior.this.d0()) {
                    return BottomSheetBehavior.this.V;
                }
                return BottomSheetBehavior.this.H;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i82) {
                if (i82 == 1 && BottomSheetBehavior.this.L) {
                    BottomSheetBehavior.this.R0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(@NonNull View view, int i82, int i9, int i10, int i11) {
                BottomSheetBehavior.this.i0(i9);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(@androidx.annotation.NonNull android.view.View r9, float r10, float r11) {
                /*
                    Method dump skipped, instructions count: 309
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(@NonNull View view, int i82) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i9 = bottomSheetBehavior.M;
                if (i9 == 1 || bottomSheetBehavior.f12996d0) {
                    return false;
                }
                if (i9 == 3 && bottomSheetBehavior.f12992b0 == i82) {
                    WeakReference<View> weakReference = bottomSheetBehavior.Y;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.f13028a = System.currentTimeMillis();
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.W;
                if (weakReference2 != null && weakReference2.get() == view) {
                    return true;
                }
                return false;
            }
        };
        this.f13004i = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f12523d0);
        int i9 = R$styleable.f12559h0;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.f13006k = MaterialResources.a(context, obtainStyledAttributes, i9);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.f12713z0)) {
            this.f13021z = ShapeAppearanceModel.e(context, attributeSet, R$attr.bottomSheetStyle, f12988h0).m();
        }
        g0(context);
        h0();
        this.I = obtainStyledAttributes.getDimension(R$styleable.f12550g0, -1.0f);
        int i10 = R$styleable.f12532e0;
        if (obtainStyledAttributes.hasValue(i10)) {
            K0(obtainStyledAttributes.getDimensionPixelSize(i10, -1));
        }
        int i11 = R$styleable.f12541f0;
        if (obtainStyledAttributes.hasValue(i11)) {
            J0(obtainStyledAttributes.getDimensionPixelSize(i11, -1));
        }
        int i12 = R$styleable.f12613n0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i12);
        if (peekValue != null && (i8 = peekValue.data) == -1) {
            L0(i8);
        } else {
            L0(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        I0(obtainStyledAttributes.getBoolean(R$styleable.f12604m0, false));
        G0(obtainStyledAttributes.getBoolean(R$styleable.f12649r0, false));
        F0(obtainStyledAttributes.getBoolean(R$styleable.f12586k0, true));
        P0(obtainStyledAttributes.getBoolean(R$styleable.f12640q0, false));
        D0(obtainStyledAttributes.getBoolean(R$styleable.f12568i0, true));
        N0(obtainStyledAttributes.getInt(R$styleable.f12622o0, 0));
        H0(obtainStyledAttributes.getFloat(R$styleable.f12595l0, 0.5f));
        int i13 = R$styleable.f12577j0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i13);
        if (peekValue2 != null && peekValue2.type == 16) {
            E0(peekValue2.data);
        } else {
            E0(obtainStyledAttributes.getDimensionPixelOffset(i13, 0));
        }
        O0(obtainStyledAttributes.getInt(R$styleable.f12631p0, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION));
        this.f13011p = obtainStyledAttributes.getBoolean(R$styleable.f12681v0, false);
        this.f13012q = obtainStyledAttributes.getBoolean(R$styleable.f12689w0, false);
        this.f13013r = obtainStyledAttributes.getBoolean(R$styleable.f12697x0, false);
        this.f13014s = obtainStyledAttributes.getBoolean(R$styleable.f12705y0, true);
        this.f13015t = obtainStyledAttributes.getBoolean(R$styleable.f12657s0, false);
        this.f13016u = obtainStyledAttributes.getBoolean(R$styleable.f12665t0, false);
        this.f13017v = obtainStyledAttributes.getBoolean(R$styleable.f12673u0, false);
        this.f13020y = obtainStyledAttributes.getBoolean(R$styleable.A0, true);
        obtainStyledAttributes.recycle();
        this.f12995d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
