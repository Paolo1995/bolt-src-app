package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean N;
    int O;
    int[] P;
    View[] Q;
    final SparseIntArray R;
    final SparseIntArray S;
    SpanSizeLookup T;
    final Rect U;
    private boolean V;

    /* loaded from: classes.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int e(int i8, int i9) {
            return i8 % i9;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int f(int i8) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f7061a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f7062b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f7063c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f7064d = false;

        static int a(SparseIntArray sparseIntArray, int i8) {
            int size = sparseIntArray.size() - 1;
            int i9 = 0;
            while (i9 <= size) {
                int i10 = (i9 + size) >>> 1;
                if (sparseIntArray.keyAt(i10) < i8) {
                    i9 = i10 + 1;
                } else {
                    size = i10 - 1;
                }
            }
            int i11 = i9 - 1;
            if (i11 >= 0 && i11 < sparseIntArray.size()) {
                return sparseIntArray.keyAt(i11);
            }
            return -1;
        }

        int b(int i8, int i9) {
            if (!this.f7064d) {
                return d(i8, i9);
            }
            int i10 = this.f7062b.get(i8, -1);
            if (i10 != -1) {
                return i10;
            }
            int d8 = d(i8, i9);
            this.f7062b.put(i8, d8);
            return d8;
        }

        int c(int i8, int i9) {
            if (!this.f7063c) {
                return e(i8, i9);
            }
            int i10 = this.f7061a.get(i8, -1);
            if (i10 != -1) {
                return i10;
            }
            int e8 = e(i8, i9);
            this.f7061a.put(i8, e8);
            return e8;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int d(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.f7064d
                r1 = 0
                if (r0 == 0) goto L24
                android.util.SparseIntArray r0 = r6.f7062b
                int r0 = a(r0, r7)
                r2 = -1
                if (r0 == r2) goto L24
                android.util.SparseIntArray r2 = r6.f7062b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.c(r0, r8)
                int r0 = r6.f(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L27
                int r2 = r2 + 1
                goto L26
            L24:
                r2 = 0
                r3 = 0
            L26:
                r4 = 0
            L27:
                int r0 = r6.f(r7)
            L2b:
                if (r3 >= r7) goto L40
                int r5 = r6.f(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L38
                int r2 = r2 + 1
                r4 = 0
                goto L3d
            L38:
                if (r4 <= r8) goto L3d
                int r2 = r2 + 1
                r4 = r5
            L3d:
                int r3 = r3 + 1
                goto L2b
            L40:
                int r4 = r4 + r0
                if (r4 <= r8) goto L45
                int r2 = r2 + 1
            L45:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.d(int, int):int");
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f7063c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f7061a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f7061a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = 0
                r3 = 0
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = 0
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.e(int, int):int");
        }

        public abstract int f(int i8);

        public void g() {
            this.f7062b.clear();
        }

        public void h() {
            this.f7061a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.N = false;
        this.O = -1;
        this.R = new SparseIntArray();
        this.S = new SparseIntArray();
        this.T = new DefaultSpanSizeLookup();
        this.U = new Rect();
        o3(RecyclerView.LayoutManager.p0(context, attributeSet, i8, i9).f7268b);
    }

    private void X2(RecyclerView.Recycler recycler, RecyclerView.State state, int i8, boolean z7) {
        int i9;
        int i10;
        int i11 = 0;
        int i12 = -1;
        if (z7) {
            i12 = i8;
            i9 = 0;
            i10 = 1;
        } else {
            i9 = i8 - 1;
            i10 = -1;
        }
        while (i9 != i12) {
            View view = this.Q[i9];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int k32 = k3(recycler, state, o0(view));
            layoutParams.f7060k = k32;
            layoutParams.f7059j = i11;
            i11 += k32;
            i9 += i10;
        }
    }

    private void Y2() {
        int U = U();
        for (int i8 = 0; i8 < U; i8++) {
            LayoutParams layoutParams = (LayoutParams) T(i8).getLayoutParams();
            int a8 = layoutParams.a();
            this.R.put(a8, layoutParams.f());
            this.S.put(a8, layoutParams.e());
        }
    }

    private void Z2(int i8) {
        this.P = a3(this.P, this.O, i8);
    }

    static int[] a3(int[] iArr, int i8, int i9) {
        int i10;
        if (iArr == null || iArr.length != i8 + 1 || iArr[iArr.length - 1] != i9) {
            iArr = new int[i8 + 1];
        }
        int i11 = 0;
        iArr[0] = 0;
        int i12 = i9 / i8;
        int i13 = i9 % i8;
        int i14 = 0;
        for (int i15 = 1; i15 <= i8; i15++) {
            i11 += i13;
            if (i11 > 0 && i8 - i11 < i13) {
                i10 = i12 + 1;
                i11 -= i8;
            } else {
                i10 = i12;
            }
            i14 += i10;
            iArr[i15] = i14;
        }
        return iArr;
    }

    private void b3() {
        this.R.clear();
        this.S.clear();
    }

    private int c3(RecyclerView.State state) {
        int max;
        if (U() != 0 && state.b() != 0) {
            e2();
            boolean A2 = A2();
            View j22 = j2(!A2, true);
            View i22 = i2(!A2, true);
            if (j22 != null && i22 != null) {
                int b8 = this.T.b(o0(j22), this.O);
                int b9 = this.T.b(o0(i22), this.O);
                int min = Math.min(b8, b9);
                int max2 = Math.max(b8, b9);
                int b10 = this.T.b(state.b() - 1, this.O) + 1;
                if (this.C) {
                    max = Math.max(0, (b10 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!A2) {
                    return max;
                }
                return Math.round((max * (Math.abs(this.f7133z.d(i22) - this.f7133z.g(j22)) / ((this.T.b(o0(i22), this.O) - this.T.b(o0(j22), this.O)) + 1))) + (this.f7133z.m() - this.f7133z.g(j22)));
            }
        }
        return 0;
    }

    private int d3(RecyclerView.State state) {
        if (U() != 0 && state.b() != 0) {
            e2();
            View j22 = j2(!A2(), true);
            View i22 = i2(!A2(), true);
            if (j22 != null && i22 != null) {
                if (!A2()) {
                    return this.T.b(state.b() - 1, this.O) + 1;
                }
                int d8 = this.f7133z.d(i22) - this.f7133z.g(j22);
                int b8 = this.T.b(o0(j22), this.O);
                return (int) ((d8 / ((this.T.b(o0(i22), this.O) - b8) + 1)) * (this.T.b(state.b() - 1, this.O) + 1));
            }
        }
        return 0;
    }

    private void e3(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i8) {
        boolean z7;
        if (i8 == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        int j32 = j3(recycler, state, anchorInfo.f7135b);
        if (z7) {
            while (j32 > 0) {
                int i9 = anchorInfo.f7135b;
                if (i9 > 0) {
                    int i10 = i9 - 1;
                    anchorInfo.f7135b = i10;
                    j32 = j3(recycler, state, i10);
                } else {
                    return;
                }
            }
            return;
        }
        int b8 = state.b() - 1;
        int i11 = anchorInfo.f7135b;
        while (i11 < b8) {
            int i12 = i11 + 1;
            int j33 = j3(recycler, state, i12);
            if (j33 <= j32) {
                break;
            }
            i11 = i12;
            j32 = j33;
        }
        anchorInfo.f7135b = i11;
    }

    private void f3() {
        View[] viewArr = this.Q;
        if (viewArr == null || viewArr.length != this.O) {
            this.Q = new View[this.O];
        }
    }

    private int i3(RecyclerView.Recycler recycler, RecyclerView.State state, int i8) {
        if (!state.e()) {
            return this.T.b(i8, this.O);
        }
        int f8 = recycler.f(i8);
        if (f8 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i8);
            return 0;
        }
        return this.T.b(f8, this.O);
    }

    private int j3(RecyclerView.Recycler recycler, RecyclerView.State state, int i8) {
        if (!state.e()) {
            return this.T.c(i8, this.O);
        }
        int i9 = this.S.get(i8, -1);
        if (i9 != -1) {
            return i9;
        }
        int f8 = recycler.f(i8);
        if (f8 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i8);
            return 0;
        }
        return this.T.c(f8, this.O);
    }

    private int k3(RecyclerView.Recycler recycler, RecyclerView.State state, int i8) {
        if (!state.e()) {
            return this.T.f(i8);
        }
        int i9 = this.R.get(i8, -1);
        if (i9 != -1) {
            return i9;
        }
        int f8 = recycler.f(i8);
        if (f8 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i8);
            return 1;
        }
        return this.T.f(f8);
    }

    private void l3(float f8, int i8) {
        Z2(Math.max(Math.round(f8 * this.O), i8));
    }

    private void m3(View view, int i8, boolean z7) {
        int i9;
        int i10;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f7272g;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i12 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int g32 = g3(layoutParams.f7059j, layoutParams.f7060k);
        if (this.f7131x == 1) {
            i10 = RecyclerView.LayoutManager.V(g32, i8, i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i9 = RecyclerView.LayoutManager.V(this.f7133z.n(), i0(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int V = RecyclerView.LayoutManager.V(g32, i8, i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int V2 = RecyclerView.LayoutManager.V(this.f7133z.n(), w0(), i12, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i9 = V;
            i10 = V2;
        }
        n3(view, i10, i9, z7);
    }

    private void n3(View view, int i8, int i9, boolean z7) {
        boolean Q1;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z7) {
            Q1 = S1(view, i8, i9, layoutParams);
        } else {
            Q1 = Q1(view, i8, i9, layoutParams);
        }
        if (Q1) {
            view.measure(i8, i9);
        }
    }

    private void q3() {
        int h02;
        int paddingTop;
        if (y2() == 1) {
            h02 = v0() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            h02 = h0() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        Z2(h02 - paddingTop);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r21.f7140b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void B2(androidx.recyclerview.widget.RecyclerView.Recycler r18, androidx.recyclerview.widget.RecyclerView.State r19, androidx.recyclerview.widget.LinearLayoutManager.LayoutState r20, androidx.recyclerview.widget.LinearLayoutManager.LayoutChunkResult r21) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.B2(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, androidx.recyclerview.widget.LinearLayoutManager$LayoutState, androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int C(RecyclerView.State state) {
        if (this.V) {
            return c3(state);
        }
        return super.C(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D(RecyclerView.State state) {
        if (this.V) {
            return d3(state);
        }
        return super.D(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void D2(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i8) {
        super.D2(recycler, state, anchorInfo, i8);
        q3();
        if (state.b() > 0 && !state.e()) {
            e3(recycler, state, anchorInfo, i8);
        }
        f3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int F(RecyclerView.State state) {
        if (this.V) {
            return c3(state);
        }
        return super.F(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G(RecyclerView.State state) {
        if (this.V) {
            return d3(state);
        }
        return super.G(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        q3();
        f3();
        return super.G1(i8, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int I1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        q3();
        f3();
        return super.I1(i8, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N1(Rect rect, int i8, int i9) {
        int y7;
        int y8;
        if (this.P == null) {
            super.N1(rect, i8, i9);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f7131x == 1) {
            y8 = RecyclerView.LayoutManager.y(i9, rect.height() + paddingTop, m0());
            int[] iArr = this.P;
            y7 = RecyclerView.LayoutManager.y(i8, iArr[iArr.length - 1] + paddingLeft, n0());
        } else {
            y7 = RecyclerView.LayoutManager.y(i8, rect.width() + paddingLeft, n0());
            int[] iArr2 = this.P;
            y8 = RecyclerView.LayoutManager.y(i9, iArr2[iArr2.length - 1] + paddingTop, m0());
        }
        M1(y7, y8);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams O() {
        if (this.f7131x == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void O2(boolean z7) {
        if (!z7) {
            super.O2(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams P(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams Q(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
        if (r13 == r7) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f6, code lost:
        if (r13 == r11) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View S0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.S0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean W1() {
        if (this.I == null && !this.N) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int Y(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7131x == 1) {
            return this.O;
        }
        if (state.b() < 1) {
            return 0;
        }
        return i3(recycler, state, state.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Y0(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.X0(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i32 = i3(recycler, state, layoutParams2.a());
        if (this.f7131x == 0) {
            accessibilityNodeInfoCompat.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(layoutParams2.e(), layoutParams2.f(), i32, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(i32, 1, layoutParams2.e(), layoutParams2.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void Y1(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i8 = this.O;
        for (int i9 = 0; i9 < this.O && layoutState.c(state) && i8 > 0; i9++) {
            int i10 = layoutState.f7146d;
            layoutPrefetchRegistry.a(i10, Math.max(0, layoutState.f7149g));
            i8 -= this.T.f(i10);
            layoutState.f7146d += layoutState.f7147e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void a1(RecyclerView recyclerView, int i8, int i9) {
        this.T.h();
        this.T.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void b1(RecyclerView recyclerView) {
        this.T.h();
        this.T.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void c1(RecyclerView recyclerView, int i8, int i9, int i10) {
        this.T.h();
        this.T.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(RecyclerView recyclerView, int i8, int i9) {
        this.T.h();
        this.T.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void f1(RecyclerView recyclerView, int i8, int i9, Object obj) {
        this.T.h();
        this.T.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void g1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.e()) {
            Y2();
        }
        super.g1(recycler, state);
        b3();
    }

    int g3(int i8, int i9) {
        if (this.f7131x == 1 && z2()) {
            int[] iArr = this.P;
            int i10 = this.O;
            return iArr[i10 - i8] - iArr[(i10 - i8) - i9];
        }
        int[] iArr2 = this.P;
        return iArr2[i9 + i8] - iArr2[i8];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h1(RecyclerView.State state) {
        super.h1(state);
        this.N = false;
    }

    public int h3() {
        return this.O;
    }

    public void o3(int i8) {
        if (i8 == this.O) {
            return;
        }
        this.N = true;
        if (i8 >= 1) {
            this.O = i8;
            this.T.h();
            D1();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i8);
    }

    public void p3(SpanSizeLookup spanSizeLookup) {
        this.T = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int r0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7131x == 0) {
            return this.O;
        }
        if (state.b() < 1) {
            return 0;
        }
        return i3(recycler, state, state.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View s2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7, boolean z8) {
        int i8;
        int U = U();
        int i9 = -1;
        int i10 = 1;
        if (z8) {
            i8 = U() - 1;
            i10 = -1;
        } else {
            i9 = U;
            i8 = 0;
        }
        int b8 = state.b();
        e2();
        int m8 = this.f7133z.m();
        int i11 = this.f7133z.i();
        View view = null;
        View view2 = null;
        while (i8 != i9) {
            View T = T(i8);
            int o02 = o0(T);
            if (o02 >= 0 && o02 < b8 && j3(recycler, state, o02) == 0) {
                if (((RecyclerView.LayoutParams) T.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = T;
                    }
                } else if (this.f7133z.g(T) < i11 && this.f7133z.d(T) >= m8) {
                    return T;
                } else {
                    if (view == null) {
                        view = T;
                    }
                }
            }
            i8 += i10;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean x(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: j  reason: collision with root package name */
        int f7059j;

        /* renamed from: k  reason: collision with root package name */
        int f7060k;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7059j = -1;
            this.f7060k = 0;
        }

        public int e() {
            return this.f7059j;
        }

        public int f() {
            return this.f7060k;
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f7059j = -1;
            this.f7060k = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7059j = -1;
            this.f7060k = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7059j = -1;
            this.f7060k = 0;
        }
    }

    public GridLayoutManager(Context context, int i8) {
        super(context);
        this.N = false;
        this.O = -1;
        this.R = new SparseIntArray();
        this.S = new SparseIntArray();
        this.T = new DefaultSpanSizeLookup();
        this.U = new Rect();
        o3(i8);
    }

    public GridLayoutManager(Context context, int i8, int i9, boolean z7) {
        super(context, i9, z7);
        this.N = false;
        this.O = -1;
        this.R = new SparseIntArray();
        this.S = new SparseIntArray();
        this.T = new DefaultSpanSizeLookup();
        this.U = new Rect();
        o3(i8);
    }
}
