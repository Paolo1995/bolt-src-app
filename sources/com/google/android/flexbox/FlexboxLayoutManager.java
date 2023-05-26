package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements FlexContainer, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final Rect X = new Rect();
    private int A;
    private boolean C;
    private boolean D;
    private RecyclerView.Recycler G;
    private RecyclerView.State H;
    private LayoutState I;
    private OrientationHelper K;
    private OrientationHelper L;
    private SavedState M;
    private boolean R;
    private final Context T;
    private View U;

    /* renamed from: x  reason: collision with root package name */
    private int f12423x;

    /* renamed from: y  reason: collision with root package name */
    private int f12424y;

    /* renamed from: z  reason: collision with root package name */
    private int f12425z;
    private int B = -1;
    private List<FlexLine> E = new ArrayList();
    private final FlexboxHelper F = new FlexboxHelper(this);
    private AnchorInfo J = new AnchorInfo();
    private int N = -1;
    private int O = Integer.MIN_VALUE;
    private int P = Integer.MIN_VALUE;
    private int Q = Integer.MIN_VALUE;
    private SparseArray<View> S = new SparseArray<>();
    private int V = -1;
    private FlexboxHelper.FlexLinesResult W = new FlexboxHelper.FlexLinesResult();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        private int f12426a;

        /* renamed from: b  reason: collision with root package name */
        private int f12427b;

        /* renamed from: c  reason: collision with root package name */
        private int f12428c;

        /* renamed from: d  reason: collision with root package name */
        private int f12429d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f12430e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12431f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f12432g;

        private AnchorInfo() {
            this.f12429d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            int m8;
            int v02;
            if (!FlexboxLayoutManager.this.l() && FlexboxLayoutManager.this.C) {
                if (this.f12430e) {
                    v02 = FlexboxLayoutManager.this.K.i();
                } else {
                    v02 = FlexboxLayoutManager.this.v0() - FlexboxLayoutManager.this.K.m();
                }
                this.f12428c = v02;
                return;
            }
            if (this.f12430e) {
                m8 = FlexboxLayoutManager.this.K.i();
            } else {
                m8 = FlexboxLayoutManager.this.K.m();
            }
            this.f12428c = m8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.f12424y == 0 ? FlexboxLayoutManager.this.L : FlexboxLayoutManager.this.K;
            if (!FlexboxLayoutManager.this.l() && FlexboxLayoutManager.this.C) {
                if (this.f12430e) {
                    this.f12428c = orientationHelper.g(view) + orientationHelper.o();
                } else {
                    this.f12428c = orientationHelper.d(view);
                }
            } else if (this.f12430e) {
                this.f12428c = orientationHelper.d(view) + orientationHelper.o();
            } else {
                this.f12428c = orientationHelper.g(view);
            }
            this.f12426a = FlexboxLayoutManager.this.o0(view);
            int i8 = 0;
            this.f12432g = false;
            int[] iArr = FlexboxLayoutManager.this.F.f12389c;
            int i9 = this.f12426a;
            if (i9 == -1) {
                i9 = 0;
            }
            int i10 = iArr[i9];
            if (i10 != -1) {
                i8 = i10;
            }
            this.f12427b = i8;
            if (FlexboxLayoutManager.this.E.size() > this.f12427b) {
                this.f12426a = ((FlexLine) FlexboxLayoutManager.this.E.get(this.f12427b)).f12383o;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            this.f12426a = -1;
            this.f12427b = -1;
            this.f12428c = Integer.MIN_VALUE;
            boolean z7 = false;
            this.f12431f = false;
            this.f12432g = false;
            if (FlexboxLayoutManager.this.l()) {
                if (FlexboxLayoutManager.this.f12424y == 0) {
                    if (FlexboxLayoutManager.this.f12423x == 1) {
                        z7 = true;
                    }
                    this.f12430e = z7;
                    return;
                }
                if (FlexboxLayoutManager.this.f12424y == 2) {
                    z7 = true;
                }
                this.f12430e = z7;
            } else if (FlexboxLayoutManager.this.f12424y == 0) {
                if (FlexboxLayoutManager.this.f12423x == 3) {
                    z7 = true;
                }
                this.f12430e = z7;
            } else {
                if (FlexboxLayoutManager.this.f12424y == 2) {
                    z7 = true;
                }
                this.f12430e = z7;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f12426a + ", mFlexLinePosition=" + this.f12427b + ", mCoordinate=" + this.f12428c + ", mPerpendicularCoordinate=" + this.f12429d + ", mLayoutFromEnd=" + this.f12430e + ", mValid=" + this.f12431f + ", mAssignedFromSavedState=" + this.f12432g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LayoutState {

        /* renamed from: a  reason: collision with root package name */
        private int f12443a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12444b;

        /* renamed from: c  reason: collision with root package name */
        private int f12445c;

        /* renamed from: d  reason: collision with root package name */
        private int f12446d;

        /* renamed from: e  reason: collision with root package name */
        private int f12447e;

        /* renamed from: f  reason: collision with root package name */
        private int f12448f;

        /* renamed from: g  reason: collision with root package name */
        private int f12449g;

        /* renamed from: h  reason: collision with root package name */
        private int f12450h;

        /* renamed from: i  reason: collision with root package name */
        private int f12451i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f12452j;

        private LayoutState() {
            this.f12450h = 1;
            this.f12451i = 1;
        }

        static /* synthetic */ int i(LayoutState layoutState) {
            int i8 = layoutState.f12445c;
            layoutState.f12445c = i8 + 1;
            return i8;
        }

        static /* synthetic */ int j(LayoutState layoutState) {
            int i8 = layoutState.f12445c;
            layoutState.f12445c = i8 - 1;
            return i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean w(RecyclerView.State state, List<FlexLine> list) {
            int i8;
            int i9 = this.f12446d;
            if (i9 >= 0 && i9 < state.b() && (i8 = this.f12445c) >= 0 && i8 < list.size()) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f12443a + ", mFlexLinePosition=" + this.f12445c + ", mPosition=" + this.f12446d + ", mOffset=" + this.f12447e + ", mScrollingOffset=" + this.f12448f + ", mLastScrollDelta=" + this.f12449g + ", mItemDirection=" + this.f12450h + ", mLayoutDirection=" + this.f12451i + '}';
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        RecyclerView.LayoutManager.Properties p02 = RecyclerView.LayoutManager.p0(context, attributeSet, i8, i9);
        int i10 = p02.f7267a;
        if (i10 != 0) {
            if (i10 == 1) {
                if (p02.f7269c) {
                    P2(3);
                } else {
                    P2(2);
                }
            }
        } else if (p02.f7269c) {
            P2(1);
        } else {
            P2(0);
        }
        Q2(1);
        O2(4);
        J1(true);
        this.T = context;
    }

    private int A2(View view) {
        return e0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private int B2(View view) {
        return f0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    private int C2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z7;
        if (U() == 0 || i8 == 0) {
            return 0;
        }
        l2();
        int i9 = 1;
        this.I.f12452j = true;
        if (!l() && this.C) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 ? i8 <= 0 : i8 >= 0) {
            i9 = -1;
        }
        int abs = Math.abs(i8);
        W2(i9, abs);
        int m22 = this.I.f12448f + m2(recycler, state, this.I);
        if (m22 < 0) {
            return 0;
        }
        if (z7) {
            if (abs > m22) {
                i8 = (-i9) * m22;
            }
        } else if (abs > m22) {
            i8 = i9 * m22;
        }
        this.K.r(-i8);
        this.I.f12449g = i8;
        return i8;
    }

    private int D2(int i8) {
        int height;
        int h02;
        int i9;
        boolean z7 = false;
        if (U() == 0 || i8 == 0) {
            return 0;
        }
        l2();
        boolean l8 = l();
        View view = this.U;
        if (l8) {
            height = view.getWidth();
        } else {
            height = view.getHeight();
        }
        if (l8) {
            h02 = v0();
        } else {
            h02 = h0();
        }
        if (k0() == 1) {
            z7 = true;
        }
        if (z7) {
            int abs = Math.abs(i8);
            if (i8 < 0) {
                i9 = Math.min((h02 + this.J.f12429d) - height, abs);
            } else if (this.J.f12429d + i8 > 0) {
                i9 = this.J.f12429d;
            } else {
                return i8;
            }
        } else if (i8 > 0) {
            return Math.min((h02 - this.J.f12429d) - height, i8);
        } else {
            if (this.J.f12429d + i8 < 0) {
                i9 = this.J.f12429d;
            } else {
                return i8;
            }
        }
        return -i9;
    }

    private static boolean E0(int i8, int i9, int i10) {
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        if (i10 > 0 && i8 != i10) {
            return false;
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return true;
            }
            if (mode != 1073741824 || size != i8) {
                return false;
            }
            return true;
        } else if (size < i8) {
            return false;
        } else {
            return true;
        }
    }

    private boolean E2(View view, boolean z7) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int v02 = v0() - getPaddingRight();
        int h02 = h0() - getPaddingBottom();
        int z22 = z2(view);
        int B2 = B2(view);
        int A2 = A2(view);
        int x22 = x2(view);
        if (paddingLeft <= z22 && v02 >= A2) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z22 < v02 && A2 < paddingLeft) {
            z9 = false;
        } else {
            z9 = true;
        }
        if (paddingTop <= B2 && h02 >= x22) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (B2 < h02 && x22 < paddingTop) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z7) {
            if (z8 && z10) {
                return true;
            }
            return false;
        } else if (z9 && z11) {
            return true;
        } else {
            return false;
        }
    }

    private int F2(FlexLine flexLine, LayoutState layoutState) {
        if (l()) {
            return G2(flexLine, layoutState);
        }
        return H2(flexLine, layoutState);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int G2(com.google.android.flexbox.FlexLine r22, com.google.android.flexbox.FlexboxLayoutManager.LayoutState r23) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.G2(com.google.android.flexbox.FlexLine, com.google.android.flexbox.FlexboxLayoutManager$LayoutState):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int H2(com.google.android.flexbox.FlexLine r26, com.google.android.flexbox.FlexboxLayoutManager.LayoutState r27) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.H2(com.google.android.flexbox.FlexLine, com.google.android.flexbox.FlexboxLayoutManager$LayoutState):int");
    }

    private void I2(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f12452j) {
            return;
        }
        if (layoutState.f12451i == -1) {
            K2(recycler, layoutState);
        } else {
            L2(recycler, layoutState);
        }
    }

    private void J2(RecyclerView.Recycler recycler, int i8, int i9) {
        while (i9 >= i8) {
            x1(i9, recycler);
            i9--;
        }
    }

    private void K2(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f12448f < 0) {
            return;
        }
        this.K.h();
        int unused = layoutState.f12448f;
        int U = U();
        if (U == 0) {
            return;
        }
        int i8 = U - 1;
        int i9 = this.F.f12389c[o0(T(i8))];
        if (i9 == -1) {
            return;
        }
        FlexLine flexLine = this.E.get(i9);
        int i10 = i8;
        while (true) {
            if (i10 < 0) {
                break;
            }
            View T = T(i10);
            if (!e2(T, layoutState.f12448f)) {
                break;
            }
            if (flexLine.f12383o == o0(T)) {
                if (i9 <= 0) {
                    U = i10;
                    break;
                }
                i9 += layoutState.f12451i;
                flexLine = this.E.get(i9);
                U = i10;
            }
            i10--;
        }
        J2(recycler, U, i8);
    }

    private void L2(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int U;
        if (layoutState.f12448f < 0 || (U = U()) == 0) {
            return;
        }
        int i8 = this.F.f12389c[o0(T(0))];
        int i9 = -1;
        if (i8 == -1) {
            return;
        }
        FlexLine flexLine = this.E.get(i8);
        int i10 = 0;
        while (true) {
            if (i10 >= U) {
                break;
            }
            View T = T(i10);
            if (!f2(T, layoutState.f12448f)) {
                break;
            }
            if (flexLine.f12384p == o0(T)) {
                if (i8 >= this.E.size() - 1) {
                    i9 = i10;
                    break;
                }
                i8 += layoutState.f12451i;
                flexLine = this.E.get(i8);
                i9 = i10;
            }
            i10++;
        }
        J2(recycler, 0, i9);
    }

    private void M2() {
        int w02;
        boolean z7;
        if (l()) {
            w02 = i0();
        } else {
            w02 = w0();
        }
        LayoutState layoutState = this.I;
        if (w02 != 0 && w02 != Integer.MIN_VALUE) {
            z7 = false;
        } else {
            z7 = true;
        }
        layoutState.f12444b = z7;
    }

    private void N2() {
        boolean z7;
        boolean z8;
        boolean z9;
        int k02 = k0();
        int i8 = this.f12423x;
        boolean z10 = false;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        this.C = false;
                        this.D = false;
                        return;
                    }
                    if (k02 == 1) {
                        z10 = true;
                    }
                    this.C = z10;
                    if (this.f12424y == 2) {
                        this.C = !z10;
                    }
                    this.D = true;
                    return;
                }
                if (k02 == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                this.C = z9;
                if (this.f12424y == 2) {
                    this.C = !z9;
                }
                this.D = false;
                return;
            }
            if (k02 != 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            this.C = z8;
            if (this.f12424y == 2) {
                z10 = true;
            }
            this.D = z10;
            return;
        }
        if (k02 == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.C = z7;
        if (this.f12424y == 2) {
            z10 = true;
        }
        this.D = z10;
    }

    private boolean Q1(View view, int i8, int i9, RecyclerView.LayoutParams layoutParams) {
        if (!view.isLayoutRequested() && D0() && E0(view.getWidth(), i8, ((ViewGroup.MarginLayoutParams) layoutParams).width) && E0(view.getHeight(), i9, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
            return false;
        }
        return true;
    }

    private boolean R2(RecyclerView.State state, AnchorInfo anchorInfo) {
        View n22;
        int m8;
        boolean z7 = false;
        if (U() == 0) {
            return false;
        }
        if (anchorInfo.f12430e) {
            n22 = q2(state.b());
        } else {
            n22 = n2(state.b());
        }
        if (n22 != null) {
            anchorInfo.r(n22);
            if (!state.e() && W1()) {
                if ((this.K.g(n22) >= this.K.i() || this.K.d(n22) < this.K.m()) ? true : true) {
                    if (anchorInfo.f12430e) {
                        m8 = this.K.i();
                    } else {
                        m8 = this.K.m();
                    }
                    anchorInfo.f12428c = m8;
                }
            }
            return true;
        }
        return false;
    }

    private boolean S2(RecyclerView.State state, AnchorInfo anchorInfo, SavedState savedState) {
        int i8;
        int g8;
        boolean z7 = false;
        if (!state.e() && (i8 = this.N) != -1) {
            if (i8 >= 0 && i8 < state.b()) {
                anchorInfo.f12426a = this.N;
                anchorInfo.f12427b = this.F.f12389c[anchorInfo.f12426a];
                SavedState savedState2 = this.M;
                if (savedState2 != null && savedState2.g(state.b())) {
                    anchorInfo.f12428c = this.K.m() + savedState.f12454g;
                    anchorInfo.f12432g = true;
                    anchorInfo.f12427b = -1;
                    return true;
                } else if (this.O == Integer.MIN_VALUE) {
                    View N = N(this.N);
                    if (N != null) {
                        if (this.K.e(N) > this.K.n()) {
                            anchorInfo.q();
                            return true;
                        } else if (this.K.g(N) - this.K.m() < 0) {
                            anchorInfo.f12428c = this.K.m();
                            anchorInfo.f12430e = false;
                            return true;
                        } else if (this.K.i() - this.K.d(N) < 0) {
                            anchorInfo.f12428c = this.K.i();
                            anchorInfo.f12430e = true;
                            return true;
                        } else {
                            if (anchorInfo.f12430e) {
                                g8 = this.K.d(N) + this.K.o();
                            } else {
                                g8 = this.K.g(N);
                            }
                            anchorInfo.f12428c = g8;
                        }
                    } else {
                        if (U() > 0) {
                            if (this.N < o0(T(0))) {
                                z7 = true;
                            }
                            anchorInfo.f12430e = z7;
                        }
                        anchorInfo.q();
                    }
                    return true;
                } else {
                    if (l() || !this.C) {
                        anchorInfo.f12428c = this.K.m() + this.O;
                    } else {
                        anchorInfo.f12428c = this.O - this.K.j();
                    }
                    return true;
                }
            }
            this.N = -1;
            this.O = Integer.MIN_VALUE;
        }
        return false;
    }

    private void T2(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!S2(state, anchorInfo, this.M) && !R2(state, anchorInfo)) {
            anchorInfo.q();
            anchorInfo.f12426a = 0;
            anchorInfo.f12427b = 0;
        }
    }

    private void U2(int i8) {
        if (i8 >= s2()) {
            return;
        }
        int U = U();
        this.F.t(U);
        this.F.u(U);
        this.F.s(U);
        if (i8 >= this.F.f12389c.length) {
            return;
        }
        this.V = i8;
        View y22 = y2();
        if (y22 == null) {
            return;
        }
        this.N = o0(y22);
        if (!l() && this.C) {
            this.O = this.K.d(y22) + this.K.j();
        } else {
            this.O = this.K.g(y22) - this.K.m();
        }
    }

    private void V2(int i8) {
        int i9;
        int i10;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(v0(), w0());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(h0(), i0());
        int v02 = v0();
        int h02 = h0();
        boolean z7 = true;
        if (l()) {
            int i11 = this.P;
            z7 = (i11 == Integer.MIN_VALUE || i11 == v02) ? false : false;
            i9 = this.I.f12444b ? this.T.getResources().getDisplayMetrics().heightPixels : this.I.f12443a;
        } else {
            int i12 = this.Q;
            z7 = (i12 == Integer.MIN_VALUE || i12 == h02) ? false : false;
            if (!this.I.f12444b) {
                i9 = this.I.f12443a;
            } else {
                i9 = this.T.getResources().getDisplayMetrics().widthPixels;
            }
        }
        int i13 = i9;
        this.P = v02;
        this.Q = h02;
        int i14 = this.V;
        if (i14 == -1 && (this.N != -1 || z7)) {
            if (this.J.f12430e) {
                return;
            }
            this.E.clear();
            this.W.a();
            if (l()) {
                this.F.e(this.W, makeMeasureSpec, makeMeasureSpec2, i13, this.J.f12426a, this.E);
            } else {
                this.F.h(this.W, makeMeasureSpec, makeMeasureSpec2, i13, this.J.f12426a, this.E);
            }
            this.E = this.W.f12392a;
            this.F.p(makeMeasureSpec, makeMeasureSpec2);
            this.F.X();
            AnchorInfo anchorInfo = this.J;
            anchorInfo.f12427b = this.F.f12389c[anchorInfo.f12426a];
            this.I.f12445c = this.J.f12427b;
            return;
        }
        if (i14 == -1) {
            i10 = this.J.f12426a;
        } else {
            i10 = Math.min(i14, this.J.f12426a);
        }
        int i15 = i10;
        this.W.a();
        if (l()) {
            if (this.E.size() > 0) {
                this.F.j(this.E, i15);
                this.F.b(this.W, makeMeasureSpec, makeMeasureSpec2, i13, i15, this.J.f12426a, this.E);
            } else {
                this.F.s(i8);
                this.F.d(this.W, makeMeasureSpec, makeMeasureSpec2, i13, 0, this.E);
            }
        } else if (this.E.size() > 0) {
            this.F.j(this.E, i15);
            this.F.b(this.W, makeMeasureSpec2, makeMeasureSpec, i13, i15, this.J.f12426a, this.E);
        } else {
            this.F.s(i8);
            this.F.g(this.W, makeMeasureSpec, makeMeasureSpec2, i13, 0, this.E);
        }
        this.E = this.W.f12392a;
        this.F.q(makeMeasureSpec, makeMeasureSpec2, i15);
        this.F.Y(i15);
    }

    private void W2(int i8, int i9) {
        boolean z7;
        int i10;
        this.I.f12451i = i8;
        boolean l8 = l();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(v0(), w0());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(h0(), i0());
        int i11 = 0;
        if (!l8 && this.C) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i8 == 1) {
            View T = T(U() - 1);
            this.I.f12447e = this.K.d(T);
            int o02 = o0(T);
            View r22 = r2(T, this.E.get(this.F.f12389c[o02]));
            this.I.f12450h = 1;
            LayoutState layoutState = this.I;
            layoutState.f12446d = o02 + layoutState.f12450h;
            if (this.F.f12389c.length <= this.I.f12446d) {
                this.I.f12445c = -1;
            } else {
                LayoutState layoutState2 = this.I;
                layoutState2.f12445c = this.F.f12389c[layoutState2.f12446d];
            }
            if (z7) {
                this.I.f12447e = this.K.g(r22);
                this.I.f12448f = (-this.K.g(r22)) + this.K.m();
                LayoutState layoutState3 = this.I;
                if (layoutState3.f12448f >= 0) {
                    i11 = this.I.f12448f;
                }
                layoutState3.f12448f = i11;
            } else {
                this.I.f12447e = this.K.d(r22);
                this.I.f12448f = this.K.d(r22) - this.K.i();
            }
            if ((this.I.f12445c == -1 || this.I.f12445c > this.E.size() - 1) && this.I.f12446d <= getFlexItemCount()) {
                int i12 = i9 - this.I.f12448f;
                this.W.a();
                if (i12 > 0) {
                    if (l8) {
                        this.F.d(this.W, makeMeasureSpec, makeMeasureSpec2, i12, this.I.f12446d, this.E);
                    } else {
                        this.F.g(this.W, makeMeasureSpec, makeMeasureSpec2, i12, this.I.f12446d, this.E);
                    }
                    this.F.q(makeMeasureSpec, makeMeasureSpec2, this.I.f12446d);
                    this.F.Y(this.I.f12446d);
                }
            }
        } else {
            View T2 = T(0);
            this.I.f12447e = this.K.g(T2);
            int o03 = o0(T2);
            View o22 = o2(T2, this.E.get(this.F.f12389c[o03]));
            this.I.f12450h = 1;
            int i13 = this.F.f12389c[o03];
            if (i13 == -1) {
                i13 = 0;
            }
            if (i13 <= 0) {
                this.I.f12446d = -1;
            } else {
                this.I.f12446d = o03 - this.E.get(i13 - 1).b();
            }
            LayoutState layoutState4 = this.I;
            if (i13 > 0) {
                i10 = i13 - 1;
            } else {
                i10 = 0;
            }
            layoutState4.f12445c = i10;
            if (z7) {
                this.I.f12447e = this.K.d(o22);
                this.I.f12448f = this.K.d(o22) - this.K.i();
                LayoutState layoutState5 = this.I;
                if (layoutState5.f12448f >= 0) {
                    i11 = this.I.f12448f;
                }
                layoutState5.f12448f = i11;
            } else {
                this.I.f12447e = this.K.g(o22);
                this.I.f12448f = (-this.K.g(o22)) + this.K.m();
            }
        }
        LayoutState layoutState6 = this.I;
        layoutState6.f12443a = i9 - layoutState6.f12448f;
    }

    private void X2(AnchorInfo anchorInfo, boolean z7, boolean z8) {
        if (!z8) {
            this.I.f12444b = false;
        } else {
            M2();
        }
        if (!l() && this.C) {
            this.I.f12443a = anchorInfo.f12428c - getPaddingRight();
        } else {
            this.I.f12443a = this.K.i() - anchorInfo.f12428c;
        }
        this.I.f12446d = anchorInfo.f12426a;
        this.I.f12450h = 1;
        this.I.f12451i = 1;
        this.I.f12447e = anchorInfo.f12428c;
        this.I.f12448f = Integer.MIN_VALUE;
        this.I.f12445c = anchorInfo.f12427b;
        if (z7 && this.E.size() > 1 && anchorInfo.f12427b >= 0 && anchorInfo.f12427b < this.E.size() - 1) {
            LayoutState.i(this.I);
            this.I.f12446d += this.E.get(anchorInfo.f12427b).b();
        }
    }

    private void Y2(AnchorInfo anchorInfo, boolean z7, boolean z8) {
        if (!z8) {
            this.I.f12444b = false;
        } else {
            M2();
        }
        if (!l() && this.C) {
            this.I.f12443a = (this.U.getWidth() - anchorInfo.f12428c) - this.K.m();
        } else {
            this.I.f12443a = anchorInfo.f12428c - this.K.m();
        }
        this.I.f12446d = anchorInfo.f12426a;
        this.I.f12450h = 1;
        this.I.f12451i = -1;
        this.I.f12447e = anchorInfo.f12428c;
        this.I.f12448f = Integer.MIN_VALUE;
        this.I.f12445c = anchorInfo.f12427b;
        if (z7 && anchorInfo.f12427b > 0 && this.E.size() > anchorInfo.f12427b) {
            LayoutState.j(this.I);
            this.I.f12446d -= this.E.get(anchorInfo.f12427b).b();
        }
    }

    private boolean e2(View view, int i8) {
        if (!l() && this.C) {
            if (this.K.d(view) <= i8) {
                return true;
            }
            return false;
        } else if (this.K.g(view) >= this.K.h() - i8) {
            return true;
        } else {
            return false;
        }
    }

    private boolean f2(View view, int i8) {
        if (!l() && this.C) {
            if (this.K.h() - this.K.g(view) <= i8) {
                return true;
            }
            return false;
        } else if (this.K.d(view) <= i8) {
            return true;
        } else {
            return false;
        }
    }

    private void g2() {
        this.E.clear();
        this.J.s();
        this.J.f12429d = 0;
    }

    private int h2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        int b8 = state.b();
        l2();
        View n22 = n2(b8);
        View q22 = q2(b8);
        if (state.b() == 0 || n22 == null || q22 == null) {
            return 0;
        }
        return Math.min(this.K.n(), this.K.d(q22) - this.K.g(n22));
    }

    private int i2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        int b8 = state.b();
        View n22 = n2(b8);
        View q22 = q2(b8);
        if (state.b() != 0 && n22 != null && q22 != null) {
            int o02 = o0(n22);
            int o03 = o0(q22);
            int abs = Math.abs(this.K.d(q22) - this.K.g(n22));
            int[] iArr = this.F.f12389c;
            int i8 = iArr[o02];
            if (i8 != 0 && i8 != -1) {
                return Math.round((i8 * (abs / ((iArr[o03] - i8) + 1))) + (this.K.m() - this.K.g(n22)));
            }
        }
        return 0;
    }

    private int j2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        int b8 = state.b();
        View n22 = n2(b8);
        View q22 = q2(b8);
        if (state.b() == 0 || n22 == null || q22 == null) {
            return 0;
        }
        int p22 = p2();
        return (int) ((Math.abs(this.K.d(q22) - this.K.g(n22)) / ((s2() - p22) + 1)) * state.b());
    }

    private void k2() {
        if (this.I == null) {
            this.I = new LayoutState();
        }
    }

    private void l2() {
        if (this.K != null) {
            return;
        }
        if (l()) {
            if (this.f12424y == 0) {
                this.K = OrientationHelper.a(this);
                this.L = OrientationHelper.c(this);
                return;
            }
            this.K = OrientationHelper.c(this);
            this.L = OrientationHelper.a(this);
        } else if (this.f12424y == 0) {
            this.K = OrientationHelper.c(this);
            this.L = OrientationHelper.a(this);
        } else {
            this.K = OrientationHelper.a(this);
            this.L = OrientationHelper.c(this);
        }
    }

    private int m2(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState) {
        if (layoutState.f12448f != Integer.MIN_VALUE) {
            if (layoutState.f12443a < 0) {
                layoutState.f12448f += layoutState.f12443a;
            }
            I2(recycler, layoutState);
        }
        int i8 = layoutState.f12443a;
        int i9 = layoutState.f12443a;
        int i10 = 0;
        boolean l8 = l();
        while (true) {
            if ((i9 > 0 || this.I.f12444b) && layoutState.w(state, this.E)) {
                FlexLine flexLine = this.E.get(layoutState.f12445c);
                layoutState.f12446d = flexLine.f12383o;
                i10 += F2(flexLine, layoutState);
                if (l8 || !this.C) {
                    layoutState.f12447e += flexLine.a() * layoutState.f12451i;
                } else {
                    layoutState.f12447e -= flexLine.a() * layoutState.f12451i;
                }
                i9 -= flexLine.a();
            }
        }
        layoutState.f12443a -= i10;
        if (layoutState.f12448f != Integer.MIN_VALUE) {
            layoutState.f12448f += i10;
            if (layoutState.f12443a < 0) {
                layoutState.f12448f += layoutState.f12443a;
            }
            I2(recycler, layoutState);
        }
        return i8 - layoutState.f12443a;
    }

    private View n2(int i8) {
        View u22 = u2(0, U(), i8);
        if (u22 == null) {
            return null;
        }
        int i9 = this.F.f12389c[o0(u22)];
        if (i9 == -1) {
            return null;
        }
        return o2(u22, this.E.get(i9));
    }

    private View o2(View view, FlexLine flexLine) {
        boolean l8 = l();
        int i8 = flexLine.f12376h;
        for (int i9 = 1; i9 < i8; i9++) {
            View T = T(i9);
            if (T != null && T.getVisibility() != 8) {
                if (this.C && !l8) {
                    if (this.K.d(view) >= this.K.d(T)) {
                    }
                    view = T;
                } else {
                    if (this.K.g(view) <= this.K.g(T)) {
                    }
                    view = T;
                }
            }
        }
        return view;
    }

    private View q2(int i8) {
        View u22 = u2(U() - 1, -1, i8);
        if (u22 == null) {
            return null;
        }
        return r2(u22, this.E.get(this.F.f12389c[o0(u22)]));
    }

    private View r2(View view, FlexLine flexLine) {
        boolean l8 = l();
        int U = (U() - flexLine.f12376h) - 1;
        for (int U2 = U() - 2; U2 > U; U2--) {
            View T = T(U2);
            if (T != null && T.getVisibility() != 8) {
                if (this.C && !l8) {
                    if (this.K.g(view) <= this.K.g(T)) {
                    }
                    view = T;
                } else {
                    if (this.K.d(view) >= this.K.d(T)) {
                    }
                    view = T;
                }
            }
        }
        return view;
    }

    private View t2(int i8, int i9, boolean z7) {
        int i10;
        if (i9 > i8) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        while (i8 != i9) {
            View T = T(i8);
            if (E2(T, z7)) {
                return T;
            }
            i8 += i10;
        }
        return null;
    }

    private View u2(int i8, int i9, int i10) {
        int i11;
        l2();
        k2();
        int m8 = this.K.m();
        int i12 = this.K.i();
        if (i9 > i8) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        View view = null;
        View view2 = null;
        while (i8 != i9) {
            View T = T(i8);
            int o02 = o0(T);
            if (o02 >= 0 && o02 < i10) {
                if (((RecyclerView.LayoutParams) T.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = T;
                    }
                } else if (this.K.g(T) >= m8 && this.K.d(T) <= i12) {
                    return T;
                } else {
                    if (view == null) {
                        view = T;
                    }
                }
            }
            i8 += i11;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    private int v2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7) {
        boolean z8;
        int i9;
        int i10;
        if (!l() && this.C) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            int m8 = i8 - this.K.m();
            if (m8 <= 0) {
                return 0;
            }
            i9 = C2(m8, recycler, state);
        } else {
            int i11 = this.K.i() - i8;
            if (i11 <= 0) {
                return 0;
            }
            i9 = -C2(-i11, recycler, state);
        }
        int i12 = i8 + i9;
        if (z7 && (i10 = this.K.i() - i12) > 0) {
            this.K.r(i10);
            return i10 + i9;
        }
        return i9;
    }

    private int w2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7) {
        int i9;
        int m8;
        if (!l() && this.C) {
            int i10 = this.K.i() - i8;
            if (i10 <= 0) {
                return 0;
            }
            i9 = C2(-i10, recycler, state);
        } else {
            int m9 = i8 - this.K.m();
            if (m9 <= 0) {
                return 0;
            }
            i9 = -C2(m9, recycler, state);
        }
        int i11 = i8 + i9;
        if (z7 && (m8 = i11 - this.K.m()) > 0) {
            this.K.r(-m8);
            return i9 - m8;
        }
        return i9;
    }

    private int x2(View view) {
        return Z(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private View y2() {
        return T(0);
    }

    private int z2(View view) {
        return b0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        return h2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int C(RecyclerView.State state) {
        return i2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D(RecyclerView.State state) {
        return j2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int E(RecyclerView.State state) {
        return h2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int F(RecyclerView.State state) {
        return i2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G(RecyclerView.State state) {
        return j2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (l() && (this.f12424y != 0 || !l())) {
            int D2 = D2(i8);
            this.J.f12429d += D2;
            this.L.r(-D2);
            return D2;
        }
        int C2 = C2(i8, recycler, state);
        this.S.clear();
        return C2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void H1(int i8) {
        this.N = i8;
        this.O = Integer.MIN_VALUE;
        SavedState savedState = this.M;
        if (savedState != null) {
            savedState.h();
        }
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int I1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!l() && (this.f12424y != 0 || l())) {
            int D2 = D2(i8);
            this.J.f12429d += D2;
            this.L.r(-D2);
            return D2;
        }
        int C2 = C2(i8, recycler, state);
        this.S.clear();
        return C2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N0(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams O() {
        return new LayoutParams(-2, -2);
    }

    public void O2(int i8) {
        int i9 = this.A;
        if (i9 != i8) {
            if (i9 == 4 || i8 == 4) {
                t1();
                g2();
            }
            this.A = i8;
            D1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams P(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void P0(RecyclerView recyclerView) {
        super.P0(recyclerView);
        this.U = (View) recyclerView.getParent();
    }

    public void P2(int i8) {
        if (this.f12423x != i8) {
            t1();
            this.f12423x = i8;
            this.K = null;
            this.L = null;
            g2();
            D1();
        }
    }

    public void Q2(int i8) {
        if (i8 != 2) {
            int i9 = this.f12424y;
            if (i9 != i8) {
                if (i9 == 0 || i8 == 0) {
                    t1();
                    g2();
                }
                this.f12424y = i8;
                this.K = null;
                this.L = null;
                D1();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void R0(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.R0(recyclerView, recycler);
        if (this.R) {
            u1(recycler);
            recycler.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T1(RecyclerView recyclerView, RecyclerView.State state, int i8) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.p(i8);
        U1(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF a(int i8) {
        int i9;
        if (U() == 0) {
            return null;
        }
        if (i8 < o0(T(0))) {
            i9 = -1;
        } else {
            i9 = 1;
        }
        if (l()) {
            return new PointF(0.0f, i9);
        }
        return new PointF(i9, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void a1(@NonNull RecyclerView recyclerView, int i8, int i9) {
        super.a1(recyclerView, i8, i9);
        U2(i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void b(View view, int i8, int i9, FlexLine flexLine) {
        u(view, X);
        if (l()) {
            int l02 = l0(view) + q0(view);
            flexLine.f12373e += l02;
            flexLine.f12374f += l02;
            return;
        }
        int t02 = t0(view) + S(view);
        flexLine.f12373e += t02;
        flexLine.f12374f += t02;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int c(int i8, int i9, int i10) {
        return RecyclerView.LayoutManager.V(v0(), w0(), i9, i10, v());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void c1(@NonNull RecyclerView recyclerView, int i8, int i9, int i10) {
        super.c1(recyclerView, i8, i9, i10);
        U2(Math.min(i8, i9));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(@NonNull RecyclerView recyclerView, int i8, int i9) {
        super.d1(recyclerView, i8, i9);
        U2(i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View e(int i8) {
        View view = this.S.get(i8);
        if (view != null) {
            return view;
        }
        return this.G.o(i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void e1(@NonNull RecyclerView recyclerView, int i8, int i9) {
        super.e1(recyclerView, i8, i9);
        U2(i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int f(int i8, int i9, int i10) {
        return RecyclerView.LayoutManager.V(h0(), i0(), i9, i10, w());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void f1(@NonNull RecyclerView recyclerView, int i8, int i9, Object obj) {
        super.f1(recyclerView, i8, i9, obj);
        U2(i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int g(View view) {
        int l02;
        int q02;
        if (l()) {
            l02 = t0(view);
            q02 = S(view);
        } else {
            l02 = l0(view);
            q02 = q0(view);
        }
        return l02 + q02;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void g1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i8;
        int i9;
        this.G = recycler;
        this.H = state;
        int b8 = state.b();
        if (b8 == 0 && state.e()) {
            return;
        }
        N2();
        l2();
        k2();
        this.F.t(b8);
        this.F.u(b8);
        this.F.s(b8);
        this.I.f12452j = false;
        SavedState savedState = this.M;
        if (savedState != null && savedState.g(b8)) {
            this.N = this.M.f12453f;
        }
        if (!this.J.f12431f || this.N != -1 || this.M != null) {
            this.J.s();
            T2(state, this.J);
            this.J.f12431f = true;
        }
        H(recycler);
        if (this.J.f12430e) {
            Y2(this.J, false, true);
        } else {
            X2(this.J, false, true);
        }
        V2(b8);
        if (this.J.f12430e) {
            m2(recycler, state, this.I);
            i9 = this.I.f12447e;
            X2(this.J, true, false);
            m2(recycler, state, this.I);
            i8 = this.I.f12447e;
        } else {
            m2(recycler, state, this.I);
            i8 = this.I.f12447e;
            Y2(this.J, true, false);
            m2(recycler, state, this.I);
            i9 = this.I.f12447e;
        }
        if (U() > 0) {
            if (this.J.f12430e) {
                w2(i9 + v2(i8, recycler, state, true), recycler, state, false);
            } else {
                v2(i8 + w2(i9, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.A;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.f12423x;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return this.H.b();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.E;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.f12424y;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        if (this.E.size() == 0) {
            return 0;
        }
        int i8 = Integer.MIN_VALUE;
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            i8 = Math.max(i8, this.E.get(i9).f12373e);
        }
        return i8;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.B;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.E.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            i8 += this.E.get(i9).f12375g;
        }
        return i8;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void h(FlexLine flexLine) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h1(RecyclerView.State state) {
        super.h1(state);
        this.M = null;
        this.N = -1;
        this.O = Integer.MIN_VALUE;
        this.V = -1;
        this.J.s();
        this.S.clear();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View i(int i8) {
        return e(i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void j(int i8, View view) {
        this.S.put(i8, view);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int k(View view, int i8, int i9) {
        int t02;
        int S;
        if (l()) {
            t02 = l0(view);
            S = q0(view);
        } else {
            t02 = t0(view);
            S = S(view);
        }
        return t02 + S;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean l() {
        int i8 = this.f12423x;
        if (i8 == 0 || i8 == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void l1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.M = (SavedState) parcelable;
            D1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable m1() {
        if (this.M != null) {
            return new SavedState(this.M);
        }
        SavedState savedState = new SavedState();
        if (U() <= 0) {
            savedState.h();
        } else {
            View y22 = y2();
            savedState.f12453f = o0(y22);
            savedState.f12454g = this.K.g(y22) - this.K.m();
        }
        return savedState;
    }

    public int p2() {
        View t22 = t2(0, U(), false);
        if (t22 == null) {
            return -1;
        }
        return o0(t22);
    }

    public int s2() {
        View t22 = t2(U() - 1, -1, false);
        if (t22 == null) {
            return -1;
        }
        return o0(t22);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<FlexLine> list) {
        this.E = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean v() {
        int i8;
        if (this.f12424y == 0) {
            return l();
        }
        if (l()) {
            int v02 = v0();
            View view = this.U;
            if (view != null) {
                i8 = view.getWidth();
            } else {
                i8 = 0;
            }
            if (v02 <= i8) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean w() {
        int i8;
        if (this.f12424y == 0) {
            return !l();
        }
        if (l()) {
            return true;
        }
        int h02 = h0();
        View view = this.U;
        if (view != null) {
            i8 = view.getHeight();
        } else {
            i8 = 0;
        }
        if (h02 > i8) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean x(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        private int f12453f;

        /* renamed from: g  reason: collision with root package name */
        private int f12454g;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g(int i8) {
            int i9 = this.f12453f;
            if (i9 >= 0 && i9 < i8) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f12453f = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f12453f + ", mAnchorOffset=" + this.f12454g + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeInt(this.f12453f);
            parcel.writeInt(this.f12454g);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.f12453f = parcel.readInt();
            this.f12454g = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.f12453f = savedState.f12453f;
            this.f12454g = savedState.f12454g;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public LayoutParams[] newArray(int i8) {
                return new LayoutParams[i8];
            }
        };

        /* renamed from: j  reason: collision with root package name */
        private float f12434j;

        /* renamed from: k  reason: collision with root package name */
        private float f12435k;

        /* renamed from: l  reason: collision with root package name */
        private int f12436l;

        /* renamed from: m  reason: collision with root package name */
        private float f12437m;

        /* renamed from: n  reason: collision with root package name */
        private int f12438n;

        /* renamed from: o  reason: collision with root package name */
        private int f12439o;

        /* renamed from: p  reason: collision with root package name */
        private int f12440p;

        /* renamed from: q  reason: collision with root package name */
        private int f12441q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f12442r;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12434j = 0.0f;
            this.f12435k = 1.0f;
            this.f12436l = -1;
            this.f12437m = -1.0f;
            this.f12440p = 16777215;
            this.f12441q = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void C0(int i8) {
            this.f12438n = i8;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int D0() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void F(int i8) {
            this.f12439o = i8;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int G0() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float N() {
            return this.f12434j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float Y() {
            return this.f12437m;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean Z() {
            return this.f12442r;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int Z0() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int c0() {
            return this.f12440p;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int c1() {
            return this.f12439o;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int f1() {
            return this.f12441q;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int k() {
            return this.f12436l;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float m() {
            return this.f12435k;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int w() {
            return this.f12438n;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeFloat(this.f12434j);
            parcel.writeFloat(this.f12435k);
            parcel.writeInt(this.f12436l);
            parcel.writeFloat(this.f12437m);
            parcel.writeInt(this.f12438n);
            parcel.writeInt(this.f12439o);
            parcel.writeInt(this.f12440p);
            parcel.writeInt(this.f12441q);
            parcel.writeByte(this.f12442r ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int y() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f12434j = 0.0f;
            this.f12435k = 1.0f;
            this.f12436l = -1;
            this.f12437m = -1.0f;
            this.f12440p = 16777215;
            this.f12441q = 16777215;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f12434j = 0.0f;
            this.f12435k = 1.0f;
            this.f12436l = -1;
            this.f12437m = -1.0f;
            this.f12440p = 16777215;
            this.f12441q = 16777215;
            this.f12434j = parcel.readFloat();
            this.f12435k = parcel.readFloat();
            this.f12436l = parcel.readInt();
            this.f12437m = parcel.readFloat();
            this.f12438n = parcel.readInt();
            this.f12439o = parcel.readInt();
            this.f12440p = parcel.readInt();
            this.f12441q = parcel.readInt();
            this.f12442r = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
