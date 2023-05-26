package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    @NonNull
    OrientationHelper A;
    private int B;
    private int C;
    @NonNull
    private final LayoutState D;
    private BitSet G;
    private boolean L;
    private boolean M;
    private SavedState N;
    private int O;
    private int[] T;

    /* renamed from: y  reason: collision with root package name */
    Span[] f7363y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    OrientationHelper f7364z;

    /* renamed from: x  reason: collision with root package name */
    private int f7362x = -1;
    boolean E = false;
    boolean F = false;
    int H = -1;
    int I = Integer.MIN_VALUE;
    LazySpanLookup J = new LazySpanLookup();
    private int K = 2;
    private final Rect P = new Rect();
    private final AnchorInfo Q = new AnchorInfo();
    private boolean R = false;
    private boolean S = true;
    private final Runnable U = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.d2();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        int f7366a;

        /* renamed from: b  reason: collision with root package name */
        int f7367b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7368c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7369d;

        /* renamed from: e  reason: collision with root package name */
        boolean f7370e;

        /* renamed from: f  reason: collision with root package name */
        int[] f7371f;

        AnchorInfo() {
            c();
        }

        void a() {
            int m8;
            if (this.f7368c) {
                m8 = StaggeredGridLayoutManager.this.f7364z.i();
            } else {
                m8 = StaggeredGridLayoutManager.this.f7364z.m();
            }
            this.f7367b = m8;
        }

        void b(int i8) {
            if (this.f7368c) {
                this.f7367b = StaggeredGridLayoutManager.this.f7364z.i() - i8;
            } else {
                this.f7367b = StaggeredGridLayoutManager.this.f7364z.m() + i8;
            }
        }

        void c() {
            this.f7366a = -1;
            this.f7367b = Integer.MIN_VALUE;
            this.f7368c = false;
            this.f7369d = false;
            this.f7370e = false;
            int[] iArr = this.f7371f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f7371f;
            if (iArr == null || iArr.length < length) {
                this.f7371f = new int[StaggeredGridLayoutManager.this.f7363y.length];
            }
            for (int i8 = 0; i8 < length; i8++) {
                this.f7371f[i8] = spanArr[i8].p(Integer.MIN_VALUE);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: j  reason: collision with root package name */
        Span f7373j;

        /* renamed from: k  reason: collision with root package name */
        boolean f7374k;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f7374k;
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
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
        int f7381f;

        /* renamed from: g  reason: collision with root package name */
        int f7382g;

        /* renamed from: h  reason: collision with root package name */
        int f7383h;

        /* renamed from: i  reason: collision with root package name */
        int[] f7384i;

        /* renamed from: j  reason: collision with root package name */
        int f7385j;

        /* renamed from: k  reason: collision with root package name */
        int[] f7386k;

        /* renamed from: l  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f7387l;

        /* renamed from: m  reason: collision with root package name */
        boolean f7388m;

        /* renamed from: n  reason: collision with root package name */
        boolean f7389n;

        /* renamed from: o  reason: collision with root package name */
        boolean f7390o;

        public SavedState() {
        }

        void a() {
            this.f7384i = null;
            this.f7383h = 0;
            this.f7381f = -1;
            this.f7382g = -1;
        }

        void b() {
            this.f7384i = null;
            this.f7383h = 0;
            this.f7385j = 0;
            this.f7386k = null;
            this.f7387l = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeInt(this.f7381f);
            parcel.writeInt(this.f7382g);
            parcel.writeInt(this.f7383h);
            if (this.f7383h > 0) {
                parcel.writeIntArray(this.f7384i);
            }
            parcel.writeInt(this.f7385j);
            if (this.f7385j > 0) {
                parcel.writeIntArray(this.f7386k);
            }
            parcel.writeInt(this.f7388m ? 1 : 0);
            parcel.writeInt(this.f7389n ? 1 : 0);
            parcel.writeInt(this.f7390o ? 1 : 0);
            parcel.writeList(this.f7387l);
        }

        SavedState(Parcel parcel) {
            this.f7381f = parcel.readInt();
            this.f7382g = parcel.readInt();
            int readInt = parcel.readInt();
            this.f7383h = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f7384i = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f7385j = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f7386k = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f7388m = parcel.readInt() == 1;
            this.f7389n = parcel.readInt() == 1;
            this.f7390o = parcel.readInt() == 1;
            this.f7387l = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f7383h = savedState.f7383h;
            this.f7381f = savedState.f7381f;
            this.f7382g = savedState.f7382g;
            this.f7384i = savedState.f7384i;
            this.f7385j = savedState.f7385j;
            this.f7386k = savedState.f7386k;
            this.f7388m = savedState.f7388m;
            this.f7389n = savedState.f7389n;
            this.f7390o = savedState.f7390o;
            this.f7387l = savedState.f7387l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Span {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f7391a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f7392b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f7393c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f7394d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f7395e;

        Span(int i8) {
            this.f7395e = i8;
        }

        void a(View view) {
            LayoutParams n8 = n(view);
            n8.f7373j = this;
            this.f7391a.add(view);
            this.f7393c = Integer.MIN_VALUE;
            if (this.f7391a.size() == 1) {
                this.f7392b = Integer.MIN_VALUE;
            }
            if (n8.c() || n8.b()) {
                this.f7394d += StaggeredGridLayoutManager.this.f7364z.e(view);
            }
        }

        void b(boolean z7, int i8) {
            int p8;
            if (z7) {
                p8 = l(Integer.MIN_VALUE);
            } else {
                p8 = p(Integer.MIN_VALUE);
            }
            e();
            if (p8 == Integer.MIN_VALUE) {
                return;
            }
            if (!z7 || p8 >= StaggeredGridLayoutManager.this.f7364z.i()) {
                if (!z7 && p8 > StaggeredGridLayoutManager.this.f7364z.m()) {
                    return;
                }
                if (i8 != Integer.MIN_VALUE) {
                    p8 += i8;
                }
                this.f7393c = p8;
                this.f7392b = p8;
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem f8;
            ArrayList<View> arrayList = this.f7391a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams n8 = n(view);
            this.f7393c = StaggeredGridLayoutManager.this.f7364z.d(view);
            if (n8.f7374k && (f8 = StaggeredGridLayoutManager.this.J.f(n8.a())) != null && f8.f7378g == 1) {
                this.f7393c += f8.a(this.f7395e);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem f8;
            View view = this.f7391a.get(0);
            LayoutParams n8 = n(view);
            this.f7392b = StaggeredGridLayoutManager.this.f7364z.g(view);
            if (n8.f7374k && (f8 = StaggeredGridLayoutManager.this.J.f(n8.a())) != null && f8.f7378g == -1) {
                this.f7392b -= f8.a(this.f7395e);
            }
        }

        void e() {
            this.f7391a.clear();
            q();
            this.f7394d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.E) {
                return i(this.f7391a.size() - 1, -1, true);
            }
            return i(0, this.f7391a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.E) {
                return i(0, this.f7391a.size(), true);
            }
            return i(this.f7391a.size() - 1, -1, true);
        }

        int h(int i8, int i9, boolean z7, boolean z8, boolean z9) {
            int i10;
            boolean z10;
            int m8 = StaggeredGridLayoutManager.this.f7364z.m();
            int i11 = StaggeredGridLayoutManager.this.f7364z.i();
            if (i9 > i8) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            while (i8 != i9) {
                View view = this.f7391a.get(i8);
                int g8 = StaggeredGridLayoutManager.this.f7364z.g(view);
                int d8 = StaggeredGridLayoutManager.this.f7364z.d(view);
                boolean z11 = false;
                if (!z9 ? g8 < i11 : g8 <= i11) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z9 ? d8 > m8 : d8 >= m8) {
                    z11 = true;
                }
                if (z10 && z11) {
                    if (z7 && z8) {
                        if (g8 >= m8 && d8 <= i11) {
                            return StaggeredGridLayoutManager.this.o0(view);
                        }
                    } else if (z8) {
                        return StaggeredGridLayoutManager.this.o0(view);
                    } else {
                        if (g8 < m8 || d8 > i11) {
                            return StaggeredGridLayoutManager.this.o0(view);
                        }
                    }
                }
                i8 += i10;
            }
            return -1;
        }

        int i(int i8, int i9, boolean z7) {
            return h(i8, i9, false, false, z7);
        }

        public int j() {
            return this.f7394d;
        }

        int k() {
            int i8 = this.f7393c;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            c();
            return this.f7393c;
        }

        int l(int i8) {
            int i9 = this.f7393c;
            if (i9 != Integer.MIN_VALUE) {
                return i9;
            }
            if (this.f7391a.size() == 0) {
                return i8;
            }
            c();
            return this.f7393c;
        }

        public View m(int i8, int i9) {
            View view = null;
            if (i9 == -1) {
                int size = this.f7391a.size();
                int i10 = 0;
                while (i10 < size) {
                    View view2 = this.f7391a.get(i10);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.E && staggeredGridLayoutManager.o0(view2) <= i8) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.E && staggeredGridLayoutManager2.o0(view2) >= i8) || !view2.hasFocusable()) {
                        break;
                    }
                    i10++;
                    view = view2;
                }
            } else {
                int size2 = this.f7391a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f7391a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.E && staggeredGridLayoutManager3.o0(view3) >= i8) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.E && staggeredGridLayoutManager4.o0(view3) <= i8) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        LayoutParams n(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int o() {
            int i8 = this.f7392b;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            d();
            return this.f7392b;
        }

        int p(int i8) {
            int i9 = this.f7392b;
            if (i9 != Integer.MIN_VALUE) {
                return i9;
            }
            if (this.f7391a.size() == 0) {
                return i8;
            }
            d();
            return this.f7392b;
        }

        void q() {
            this.f7392b = Integer.MIN_VALUE;
            this.f7393c = Integer.MIN_VALUE;
        }

        void r(int i8) {
            int i9 = this.f7392b;
            if (i9 != Integer.MIN_VALUE) {
                this.f7392b = i9 + i8;
            }
            int i10 = this.f7393c;
            if (i10 != Integer.MIN_VALUE) {
                this.f7393c = i10 + i8;
            }
        }

        void s() {
            int size = this.f7391a.size();
            View remove = this.f7391a.remove(size - 1);
            LayoutParams n8 = n(remove);
            n8.f7373j = null;
            if (n8.c() || n8.b()) {
                this.f7394d -= StaggeredGridLayoutManager.this.f7364z.e(remove);
            }
            if (size == 1) {
                this.f7392b = Integer.MIN_VALUE;
            }
            this.f7393c = Integer.MIN_VALUE;
        }

        void t() {
            View remove = this.f7391a.remove(0);
            LayoutParams n8 = n(remove);
            n8.f7373j = null;
            if (this.f7391a.size() == 0) {
                this.f7393c = Integer.MIN_VALUE;
            }
            if (n8.c() || n8.b()) {
                this.f7394d -= StaggeredGridLayoutManager.this.f7364z.e(remove);
            }
            this.f7392b = Integer.MIN_VALUE;
        }

        void u(View view) {
            LayoutParams n8 = n(view);
            n8.f7373j = this;
            this.f7391a.add(0, view);
            this.f7392b = Integer.MIN_VALUE;
            if (this.f7391a.size() == 1) {
                this.f7393c = Integer.MIN_VALUE;
            }
            if (n8.c() || n8.b()) {
                this.f7394d += StaggeredGridLayoutManager.this.f7364z.e(view);
            }
        }

        void v(int i8) {
            this.f7392b = i8;
            this.f7393c = i8;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        RecyclerView.LayoutManager.Properties p02 = RecyclerView.LayoutManager.p0(context, attributeSet, i8, i9);
        S2(p02.f7267a);
        U2(p02.f7268b);
        T2(p02.f7269c);
        this.D = new LayoutState();
        l2();
    }

    private Span A2(LayoutState layoutState) {
        int i8;
        int i9;
        int i10 = -1;
        if (I2(layoutState.f7126e)) {
            i8 = this.f7362x - 1;
            i9 = -1;
        } else {
            i8 = 0;
            i10 = this.f7362x;
            i9 = 1;
        }
        Span span = null;
        if (layoutState.f7126e == 1) {
            int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int m8 = this.f7364z.m();
            while (i8 != i10) {
                Span span2 = this.f7363y[i8];
                int l8 = span2.l(m8);
                if (l8 < i11) {
                    span = span2;
                    i11 = l8;
                }
                i8 += i9;
            }
            return span;
        }
        int i12 = Integer.MIN_VALUE;
        int i13 = this.f7364z.i();
        while (i8 != i10) {
            Span span3 = this.f7363y[i8];
            int p8 = span3.p(i13);
            if (p8 > i12) {
                span = span3;
                i12 = p8;
            }
            i8 += i9;
        }
        return span;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.F
            if (r0 == 0) goto L9
            int r0 = r6.v2()
            goto Ld
        L9:
            int r0 = r6.u2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.J
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.J
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.J
            r7.j(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.J
            r9.k(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.J
            r9.j(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.F
            if (r7 == 0) goto L4d
            int r7 = r6.u2()
            goto L51
        L4d:
            int r7 = r6.v2()
        L51:
            if (r3 > r7) goto L56
            r6.D1()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B2(int, int, int):void");
    }

    private void F2(View view, int i8, int i9, boolean z7) {
        boolean Q1;
        u(view, this.P);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.P;
        int c32 = c3(i8, i10 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.P;
        int c33 = c3(i9, i11 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z7) {
            Q1 = S1(view, c32, c33, layoutParams);
        } else {
            Q1 = Q1(view, c32, c33, layoutParams);
        }
        if (Q1) {
            view.measure(c32, c33);
        }
    }

    private void G2(View view, LayoutParams layoutParams, boolean z7) {
        if (layoutParams.f7374k) {
            if (this.B == 1) {
                F2(view, this.O, RecyclerView.LayoutManager.V(h0(), i0(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z7);
            } else {
                F2(view, RecyclerView.LayoutManager.V(v0(), w0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.O, z7);
            }
        } else if (this.B == 1) {
            F2(view, RecyclerView.LayoutManager.V(this.C, w0(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.V(h0(), i0(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z7);
        } else {
            F2(view, RecyclerView.LayoutManager.V(v0(), w0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.V(this.C, i0(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z7);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0157, code lost:
        if (d2() != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void H2(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.H2(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    private boolean I2(int i8) {
        boolean z7;
        boolean z8;
        boolean z9;
        if (this.B == 0) {
            if (i8 == -1) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9 != this.F) {
                return true;
            }
            return false;
        }
        if (i8 == -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 == this.F) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8 == E2()) {
            return true;
        }
        return false;
    }

    private void K2(View view) {
        for (int i8 = this.f7362x - 1; i8 >= 0; i8--) {
            this.f7363y[i8].u(view);
        }
    }

    private void L2(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int min;
        int min2;
        if (layoutState.f7122a && !layoutState.f7130i) {
            if (layoutState.f7123b == 0) {
                if (layoutState.f7126e == -1) {
                    M2(recycler, layoutState.f7128g);
                } else {
                    N2(recycler, layoutState.f7127f);
                }
            } else if (layoutState.f7126e == -1) {
                int i8 = layoutState.f7127f;
                int x22 = i8 - x2(i8);
                if (x22 < 0) {
                    min2 = layoutState.f7128g;
                } else {
                    min2 = layoutState.f7128g - Math.min(x22, layoutState.f7123b);
                }
                M2(recycler, min2);
            } else {
                int y22 = y2(layoutState.f7128g) - layoutState.f7128g;
                if (y22 < 0) {
                    min = layoutState.f7127f;
                } else {
                    min = Math.min(y22, layoutState.f7123b) + layoutState.f7127f;
                }
                N2(recycler, min);
            }
        }
    }

    private void M2(RecyclerView.Recycler recycler, int i8) {
        for (int U = U() - 1; U >= 0; U--) {
            View T = T(U);
            if (this.f7364z.g(T) >= i8 && this.f7364z.q(T) >= i8) {
                LayoutParams layoutParams = (LayoutParams) T.getLayoutParams();
                if (layoutParams.f7374k) {
                    for (int i9 = 0; i9 < this.f7362x; i9++) {
                        if (this.f7363y[i9].f7391a.size() == 1) {
                            return;
                        }
                    }
                    for (int i10 = 0; i10 < this.f7362x; i10++) {
                        this.f7363y[i10].s();
                    }
                } else if (layoutParams.f7373j.f7391a.size() == 1) {
                    return;
                } else {
                    layoutParams.f7373j.s();
                }
                w1(T, recycler);
            } else {
                return;
            }
        }
    }

    private void N2(RecyclerView.Recycler recycler, int i8) {
        while (U() > 0) {
            View T = T(0);
            if (this.f7364z.d(T) <= i8 && this.f7364z.p(T) <= i8) {
                LayoutParams layoutParams = (LayoutParams) T.getLayoutParams();
                if (layoutParams.f7374k) {
                    for (int i9 = 0; i9 < this.f7362x; i9++) {
                        if (this.f7363y[i9].f7391a.size() == 1) {
                            return;
                        }
                    }
                    for (int i10 = 0; i10 < this.f7362x; i10++) {
                        this.f7363y[i10].t();
                    }
                } else if (layoutParams.f7373j.f7391a.size() == 1) {
                    return;
                } else {
                    layoutParams.f7373j.t();
                }
                w1(T, recycler);
            } else {
                return;
            }
        }
    }

    private void O2() {
        if (this.A.k() == 1073741824) {
            return;
        }
        float f8 = 0.0f;
        int U = U();
        for (int i8 = 0; i8 < U; i8++) {
            View T = T(i8);
            float e8 = this.A.e(T);
            if (e8 >= f8) {
                if (((LayoutParams) T.getLayoutParams()).e()) {
                    e8 = (e8 * 1.0f) / this.f7362x;
                }
                f8 = Math.max(f8, e8);
            }
        }
        int i9 = this.C;
        int round = Math.round(f8 * this.f7362x);
        if (this.A.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.A.n());
        }
        a3(round);
        if (this.C == i9) {
            return;
        }
        for (int i10 = 0; i10 < U; i10++) {
            View T2 = T(i10);
            LayoutParams layoutParams = (LayoutParams) T2.getLayoutParams();
            if (!layoutParams.f7374k) {
                if (E2() && this.B == 1) {
                    int i11 = this.f7362x;
                    int i12 = layoutParams.f7373j.f7395e;
                    T2.offsetLeftAndRight(((-((i11 - 1) - i12)) * this.C) - ((-((i11 - 1) - i12)) * i9));
                } else {
                    int i13 = layoutParams.f7373j.f7395e;
                    int i14 = this.C * i13;
                    int i15 = i13 * i9;
                    if (this.B == 1) {
                        T2.offsetLeftAndRight(i14 - i15);
                    } else {
                        T2.offsetTopAndBottom(i14 - i15);
                    }
                }
            }
        }
    }

    private void P2() {
        if (this.B != 1 && E2()) {
            this.F = !this.E;
        } else {
            this.F = this.E;
        }
    }

    private void R2(int i8) {
        boolean z7;
        LayoutState layoutState = this.D;
        layoutState.f7126e = i8;
        boolean z8 = this.F;
        int i9 = 1;
        if (i8 == -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z8 != z7) {
            i9 = -1;
        }
        layoutState.f7125d = i9;
    }

    private void V2(int i8, int i9) {
        for (int i10 = 0; i10 < this.f7362x; i10++) {
            if (!this.f7363y[i10].f7391a.isEmpty()) {
                b3(this.f7363y[i10], i8, i9);
            }
        }
    }

    private boolean W2(RecyclerView.State state, AnchorInfo anchorInfo) {
        int n22;
        if (this.L) {
            n22 = r2(state.b());
        } else {
            n22 = n2(state.b());
        }
        anchorInfo.f7366a = n22;
        anchorInfo.f7367b = Integer.MIN_VALUE;
        return true;
    }

    private void X1(View view) {
        for (int i8 = this.f7362x - 1; i8 >= 0; i8--) {
            this.f7363y[i8].a(view);
        }
    }

    private void Y1(AnchorInfo anchorInfo) {
        int m8;
        SavedState savedState = this.N;
        int i8 = savedState.f7383h;
        if (i8 > 0) {
            if (i8 == this.f7362x) {
                for (int i9 = 0; i9 < this.f7362x; i9++) {
                    this.f7363y[i9].e();
                    SavedState savedState2 = this.N;
                    int i10 = savedState2.f7384i[i9];
                    if (i10 != Integer.MIN_VALUE) {
                        if (savedState2.f7389n) {
                            m8 = this.f7364z.i();
                        } else {
                            m8 = this.f7364z.m();
                        }
                        i10 += m8;
                    }
                    this.f7363y[i9].v(i10);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.N;
                savedState3.f7381f = savedState3.f7382g;
            }
        }
        SavedState savedState4 = this.N;
        this.M = savedState4.f7390o;
        T2(savedState4.f7388m);
        P2();
        SavedState savedState5 = this.N;
        int i11 = savedState5.f7381f;
        if (i11 != -1) {
            this.H = i11;
            anchorInfo.f7368c = savedState5.f7389n;
        } else {
            anchorInfo.f7368c = this.F;
        }
        if (savedState5.f7385j > 1) {
            LazySpanLookup lazySpanLookup = this.J;
            lazySpanLookup.f7375a = savedState5.f7386k;
            lazySpanLookup.f7376b = savedState5.f7387l;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Z2(int r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.LayoutState r0 = r4.D
            r1 = 0
            r0.f7123b = r1
            r0.f7124c = r5
            boolean r0 = r4.F0()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.F
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f7364z
            int r5 = r5.n()
            goto L2f
        L25:
            androidx.recyclerview.widget.OrientationHelper r5 = r4.f7364z
            int r5 = r5.n()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.X()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.LayoutState r0 = r4.D
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f7364z
            int r3 = r3.m()
            int r3 = r3 - r6
            r0.f7127f = r3
            androidx.recyclerview.widget.LayoutState r6 = r4.D
            androidx.recyclerview.widget.OrientationHelper r0 = r4.f7364z
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.f7128g = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.LayoutState r0 = r4.D
            androidx.recyclerview.widget.OrientationHelper r3 = r4.f7364z
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.f7128g = r3
            androidx.recyclerview.widget.LayoutState r5 = r4.D
            int r6 = -r6
            r5.f7127f = r6
        L5d:
            androidx.recyclerview.widget.LayoutState r5 = r4.D
            r5.f7129h = r1
            r5.f7122a = r2
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f7364z
            int r6 = r6.k()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.OrientationHelper r6 = r4.f7364z
            int r6 = r6.h()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.f7130i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Z2(int, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private void b2(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f7126e == 1) {
            if (layoutParams.f7374k) {
                X1(view);
            } else {
                layoutParams.f7373j.a(view);
            }
        } else if (layoutParams.f7374k) {
            K2(view);
        } else {
            layoutParams.f7373j.u(view);
        }
    }

    private void b3(Span span, int i8, int i9) {
        int j8 = span.j();
        if (i8 == -1) {
            if (span.o() + j8 <= i9) {
                this.G.set(span.f7395e, false);
            }
        } else if (span.k() - j8 >= i9) {
            this.G.set(span.f7395e, false);
        }
    }

    private int c2(int i8) {
        boolean z7;
        if (U() == 0) {
            if (!this.F) {
                return -1;
            }
            return 1;
        }
        if (i8 < u2()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 != this.F) {
            return -1;
        }
        return 1;
    }

    private int c3(int i8, int i9, int i10) {
        if (i9 == 0 && i10 == 0) {
            return i8;
        }
        int mode = View.MeasureSpec.getMode(i8);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i8;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i8) - i9) - i10), mode);
    }

    private boolean e2(Span span) {
        if (this.F) {
            if (span.k() < this.f7364z.i()) {
                ArrayList<View> arrayList = span.f7391a;
                return !span.n(arrayList.get(arrayList.size() - 1)).f7374k;
            }
        } else if (span.o() > this.f7364z.m()) {
            return !span.n(span.f7391a.get(0)).f7374k;
        }
        return false;
    }

    private int f2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.f7364z, p2(!this.S), o2(!this.S), this, this.S);
    }

    private int g2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.f7364z, p2(!this.S), o2(!this.S), this, this.S, this.F);
    }

    private int h2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        return ScrollbarHelper.c(state, this.f7364z, p2(!this.S), o2(!this.S), this, this.S);
    }

    private int i2(int i8) {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 17) {
                    if (i8 != 33) {
                        if (i8 != 66) {
                            if (i8 == 130 && this.B == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.B == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.B == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.B == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.B != 1 && E2()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.B == 1 || !E2()) {
            return -1;
        } else {
            return 1;
        }
    }

    private LazySpanLookup.FullSpanItem j2(int i8) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f7379h = new int[this.f7362x];
        for (int i9 = 0; i9 < this.f7362x; i9++) {
            fullSpanItem.f7379h[i9] = i8 - this.f7363y[i9].l(i8);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem k2(int i8) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f7379h = new int[this.f7362x];
        for (int i9 = 0; i9 < this.f7362x; i9++) {
            fullSpanItem.f7379h[i9] = this.f7363y[i9].p(i8) - i8;
        }
        return fullSpanItem;
    }

    private void l2() {
        this.f7364z = OrientationHelper.b(this, this.B);
        this.A = OrientationHelper.b(this, 1 - this.B);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int m2(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i8;
        int i9;
        int m8;
        int w22;
        boolean z7;
        Span span;
        int p8;
        int e8;
        int i10;
        int m9;
        int i11;
        int e9;
        int i12;
        boolean a22;
        int l8;
        ?? r9 = 0;
        this.G.set(0, this.f7362x, true);
        if (this.D.f7130i) {
            if (layoutState.f7126e == 1) {
                i9 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            } else {
                i9 = Integer.MIN_VALUE;
            }
        } else {
            if (layoutState.f7126e == 1) {
                i8 = layoutState.f7128g + layoutState.f7123b;
            } else {
                i8 = layoutState.f7127f - layoutState.f7123b;
            }
            i9 = i8;
        }
        V2(layoutState.f7126e, i9);
        if (this.F) {
            m8 = this.f7364z.i();
        } else {
            m8 = this.f7364z.m();
        }
        int i13 = m8;
        boolean z8 = false;
        while (layoutState.a(state) && (this.D.f7130i || !this.G.isEmpty())) {
            View b8 = layoutState.b(recycler);
            LayoutParams layoutParams = (LayoutParams) b8.getLayoutParams();
            int a8 = layoutParams.a();
            int g8 = this.J.g(a8);
            if (g8 == -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                if (layoutParams.f7374k) {
                    span = this.f7363y[r9];
                } else {
                    span = A2(layoutState);
                }
                this.J.n(a8, span);
            } else {
                span = this.f7363y[g8];
            }
            Span span2 = span;
            layoutParams.f7373j = span2;
            if (layoutState.f7126e == 1) {
                o(b8);
            } else {
                p(b8, r9);
            }
            G2(b8, layoutParams, r9);
            if (layoutState.f7126e == 1) {
                if (layoutParams.f7374k) {
                    l8 = w2(i13);
                } else {
                    l8 = span2.l(i13);
                }
                int e10 = this.f7364z.e(b8) + l8;
                if (z7 && layoutParams.f7374k) {
                    LazySpanLookup.FullSpanItem j22 = j2(l8);
                    j22.f7378g = -1;
                    j22.f7377f = a8;
                    this.J.a(j22);
                }
                i10 = e10;
                e8 = l8;
            } else {
                if (layoutParams.f7374k) {
                    p8 = z2(i13);
                } else {
                    p8 = span2.p(i13);
                }
                e8 = p8 - this.f7364z.e(b8);
                if (z7 && layoutParams.f7374k) {
                    LazySpanLookup.FullSpanItem k22 = k2(p8);
                    k22.f7378g = 1;
                    k22.f7377f = a8;
                    this.J.a(k22);
                }
                i10 = p8;
            }
            if (layoutParams.f7374k && layoutState.f7125d == -1) {
                if (z7) {
                    this.R = true;
                } else {
                    if (layoutState.f7126e == 1) {
                        a22 = Z1();
                    } else {
                        a22 = a2();
                    }
                    if (!a22) {
                        LazySpanLookup.FullSpanItem f8 = this.J.f(a8);
                        if (f8 != null) {
                            f8.f7380i = true;
                        }
                        this.R = true;
                    }
                }
            }
            b2(b8, layoutParams, layoutState);
            if (E2() && this.B == 1) {
                if (layoutParams.f7374k) {
                    i12 = this.A.i();
                } else {
                    i12 = this.A.i() - (((this.f7362x - 1) - span2.f7395e) * this.C);
                }
                e9 = i12;
                i11 = i12 - this.A.e(b8);
            } else {
                if (layoutParams.f7374k) {
                    m9 = this.A.m();
                } else {
                    m9 = (span2.f7395e * this.C) + this.A.m();
                }
                i11 = m9;
                e9 = this.A.e(b8) + m9;
            }
            if (this.B == 1) {
                I0(b8, i11, e8, e9, i10);
            } else {
                I0(b8, e8, i11, i10, e9);
            }
            if (layoutParams.f7374k) {
                V2(this.D.f7126e, i9);
            } else {
                b3(span2, this.D.f7126e, i9);
            }
            L2(recycler, this.D);
            if (this.D.f7129h && b8.hasFocusable()) {
                if (layoutParams.f7374k) {
                    this.G.clear();
                } else {
                    this.G.set(span2.f7395e, false);
                    z8 = true;
                    r9 = 0;
                }
            }
            z8 = true;
            r9 = 0;
        }
        if (!z8) {
            L2(recycler, this.D);
        }
        if (this.D.f7126e == -1) {
            w22 = this.f7364z.m() - z2(this.f7364z.m());
        } else {
            w22 = w2(this.f7364z.i()) - this.f7364z.i();
        }
        if (w22 > 0) {
            return Math.min(layoutState.f7123b, w22);
        }
        return 0;
    }

    private int n2(int i8) {
        int U = U();
        for (int i9 = 0; i9 < U; i9++) {
            int o02 = o0(T(i9));
            if (o02 >= 0 && o02 < i8) {
                return o02;
            }
        }
        return 0;
    }

    private int r2(int i8) {
        for (int U = U() - 1; U >= 0; U--) {
            int o02 = o0(T(U));
            if (o02 >= 0 && o02 < i8) {
                return o02;
            }
        }
        return 0;
    }

    private void s2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7) {
        int i8;
        int w22 = w2(Integer.MIN_VALUE);
        if (w22 != Integer.MIN_VALUE && (i8 = this.f7364z.i() - w22) > 0) {
            int i9 = i8 - (-Q2(-i8, recycler, state));
            if (z7 && i9 > 0) {
                this.f7364z.r(i9);
            }
        }
    }

    private void t2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7) {
        int m8;
        int z22 = z2(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (z22 != Integer.MAX_VALUE && (m8 = z22 - this.f7364z.m()) > 0) {
            int Q2 = m8 - Q2(m8, recycler, state);
            if (z7 && Q2 > 0) {
                this.f7364z.r(-Q2);
            }
        }
    }

    private int w2(int i8) {
        int l8 = this.f7363y[0].l(i8);
        for (int i9 = 1; i9 < this.f7362x; i9++) {
            int l9 = this.f7363y[i9].l(i8);
            if (l9 > l8) {
                l8 = l9;
            }
        }
        return l8;
    }

    private int x2(int i8) {
        int p8 = this.f7363y[0].p(i8);
        for (int i9 = 1; i9 < this.f7362x; i9++) {
            int p9 = this.f7363y[i9].p(i8);
            if (p9 > p8) {
                p8 = p9;
            }
        }
        return p8;
    }

    private int y2(int i8) {
        int l8 = this.f7363y[0].l(i8);
        for (int i9 = 1; i9 < this.f7362x; i9++) {
            int l9 = this.f7363y[i9].l(i8);
            if (l9 < l8) {
                l8 = l9;
            }
        }
        return l8;
    }

    private int z2(int i8) {
        int p8 = this.f7363y[0].p(i8);
        for (int i9 = 1; i9 < this.f7362x; i9++) {
            int p9 = this.f7363y[i9].p(i8);
            if (p9 < p8) {
                p8 = p9;
            }
        }
        return p8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        return f2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int C(RecyclerView.State state) {
        return g2(state);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View C2() {
        /*
            r12 = this;
            int r0 = r12.U()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f7362x
            r2.<init>(r3)
            int r3 = r12.f7362x
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.B
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.E2()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.F
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.T(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f7373j
            int r9 = r9.f7395e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f7373j
            boolean r9 = r12.e2(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r8.f7373j
            int r9 = r9.f7395e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f7374k
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.T(r9)
            boolean r10 = r12.F
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f7364z
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f7364z
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.OrientationHelper r10 = r12.f7364z
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r12.f7364z
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r8 = r8.f7373j
            int r8 = r8.f7395e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$Span r9 = r9.f7373j
            int r9 = r9.f7395e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.C2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D(RecyclerView.State state) {
        return h2(state);
    }

    public void D2() {
        this.J.b();
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int E(RecyclerView.State state) {
        return f2(state);
    }

    boolean E2() {
        if (k0() == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int F(RecyclerView.State state) {
        return g2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G(RecyclerView.State state) {
        return h2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return Q2(i8, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void H1(int i8) {
        SavedState savedState = this.N;
        if (savedState != null && savedState.f7381f != i8) {
            savedState.a();
        }
        this.H = i8;
        this.I = Integer.MIN_VALUE;
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int I1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return Q2(i8, recycler, state);
    }

    void J2(int i8, RecyclerView.State state) {
        int u22;
        int i9;
        if (i8 > 0) {
            u22 = v2();
            i9 = 1;
        } else {
            u22 = u2();
            i9 = -1;
        }
        this.D.f7122a = true;
        Z2(u22, state);
        R2(i9);
        LayoutState layoutState = this.D;
        layoutState.f7124c = u22 + layoutState.f7125d;
        layoutState.f7123b = Math.abs(i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void L0(int i8) {
        super.L0(i8);
        for (int i9 = 0; i9 < this.f7362x; i9++) {
            this.f7363y[i9].r(i8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void M0(int i8) {
        super.M0(i8);
        for (int i9 = 0; i9 < this.f7362x; i9++) {
            this.f7363y[i9].r(i8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N0(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.J.b();
        for (int i8 = 0; i8 < this.f7362x; i8++) {
            this.f7363y[i8].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void N1(Rect rect, int i8, int i9) {
        int y7;
        int y8;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.B == 1) {
            y8 = RecyclerView.LayoutManager.y(i9, rect.height() + paddingTop, m0());
            y7 = RecyclerView.LayoutManager.y(i8, (this.C * this.f7362x) + paddingLeft, n0());
        } else {
            y7 = RecyclerView.LayoutManager.y(i8, rect.width() + paddingLeft, n0());
            y8 = RecyclerView.LayoutManager.y(i9, (this.C * this.f7362x) + paddingTop, m0());
        }
        M1(y7, y8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams O() {
        if (this.B == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
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

    int Q2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (U() == 0 || i8 == 0) {
            return 0;
        }
        J2(i8, state);
        int m22 = m2(recycler, this.D, state);
        if (this.D.f7123b >= m22) {
            if (i8 < 0) {
                i8 = -m22;
            } else {
                i8 = m22;
            }
        }
        this.f7364z.r(-i8);
        this.L = this.F;
        LayoutState layoutState = this.D;
        layoutState.f7123b = 0;
        L2(recycler, layoutState);
        return i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void R0(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.R0(recyclerView, recycler);
        y1(this.U);
        for (int i8 = 0; i8 < this.f7362x; i8++) {
            this.f7363y[i8].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View S0(View view, int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View M;
        int u22;
        boolean z7;
        boolean z8;
        int g8;
        int g9;
        int g10;
        View m8;
        if (U() == 0 || (M = M(view)) == null) {
            return null;
        }
        P2();
        int i22 = i2(i8);
        if (i22 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) M.getLayoutParams();
        boolean z9 = layoutParams.f7374k;
        Span span = layoutParams.f7373j;
        if (i22 == 1) {
            u22 = v2();
        } else {
            u22 = u2();
        }
        Z2(u22, state);
        R2(i22);
        LayoutState layoutState = this.D;
        layoutState.f7124c = layoutState.f7125d + u22;
        layoutState.f7123b = (int) (this.f7364z.n() * 0.33333334f);
        LayoutState layoutState2 = this.D;
        layoutState2.f7129h = true;
        layoutState2.f7122a = false;
        m2(recycler, layoutState2, state);
        this.L = this.F;
        if (!z9 && (m8 = span.m(u22, i22)) != null && m8 != M) {
            return m8;
        }
        if (I2(i22)) {
            for (int i9 = this.f7362x - 1; i9 >= 0; i9--) {
                View m9 = this.f7363y[i9].m(u22, i22);
                if (m9 != null && m9 != M) {
                    return m9;
                }
            }
        } else {
            for (int i10 = 0; i10 < this.f7362x; i10++) {
                View m10 = this.f7363y[i10].m(u22, i22);
                if (m10 != null && m10 != M) {
                    return m10;
                }
            }
        }
        boolean z10 = !this.E;
        if (i22 == -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z10 == z7) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z9) {
            if (z8) {
                g10 = span.f();
            } else {
                g10 = span.g();
            }
            View N = N(g10);
            if (N != null && N != M) {
                return N;
            }
        }
        if (I2(i22)) {
            for (int i11 = this.f7362x - 1; i11 >= 0; i11--) {
                if (i11 != span.f7395e) {
                    if (z8) {
                        g9 = this.f7363y[i11].f();
                    } else {
                        g9 = this.f7363y[i11].g();
                    }
                    View N2 = N(g9);
                    if (N2 != null && N2 != M) {
                        return N2;
                    }
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f7362x; i12++) {
                if (z8) {
                    g8 = this.f7363y[i12].f();
                } else {
                    g8 = this.f7363y[i12].g();
                }
                View N3 = N(g8);
                if (N3 != null && N3 != M) {
                    return N3;
                }
            }
        }
        return null;
    }

    public void S2(int i8) {
        if (i8 != 0 && i8 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        r(null);
        if (i8 == this.B) {
            return;
        }
        this.B = i8;
        OrientationHelper orientationHelper = this.f7364z;
        this.f7364z = this.A;
        this.A = orientationHelper;
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T0(AccessibilityEvent accessibilityEvent) {
        super.T0(accessibilityEvent);
        if (U() > 0) {
            View p22 = p2(false);
            View o22 = o2(false);
            if (p22 != null && o22 != null) {
                int o02 = o0(p22);
                int o03 = o0(o22);
                if (o02 < o03) {
                    accessibilityEvent.setFromIndex(o02);
                    accessibilityEvent.setToIndex(o03);
                    return;
                }
                accessibilityEvent.setFromIndex(o03);
                accessibilityEvent.setToIndex(o02);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T1(RecyclerView recyclerView, RecyclerView.State state, int i8) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.p(i8);
        U1(linearSmoothScroller);
    }

    public void T2(boolean z7) {
        r(null);
        SavedState savedState = this.N;
        if (savedState != null && savedState.f7388m != z7) {
            savedState.f7388m = z7;
        }
        this.E = z7;
        D1();
    }

    public void U2(int i8) {
        r(null);
        if (i8 != this.f7362x) {
            D2();
            this.f7362x = i8;
            this.G = new BitSet(this.f7362x);
            this.f7363y = new Span[this.f7362x];
            for (int i9 = 0; i9 < this.f7362x; i9++) {
                this.f7363y[i9] = new Span(i9);
            }
            D1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean W1() {
        if (this.N == null) {
            return true;
        }
        return false;
    }

    boolean X2(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i8;
        int u22;
        int m8;
        boolean z7 = false;
        if (!state.e() && (i8 = this.H) != -1) {
            if (i8 >= 0 && i8 < state.b()) {
                SavedState savedState = this.N;
                if (savedState != null && savedState.f7381f != -1 && savedState.f7383h >= 1) {
                    anchorInfo.f7367b = Integer.MIN_VALUE;
                    anchorInfo.f7366a = this.H;
                } else {
                    View N = N(this.H);
                    if (N != null) {
                        if (this.F) {
                            u22 = v2();
                        } else {
                            u22 = u2();
                        }
                        anchorInfo.f7366a = u22;
                        if (this.I != Integer.MIN_VALUE) {
                            if (anchorInfo.f7368c) {
                                anchorInfo.f7367b = (this.f7364z.i() - this.I) - this.f7364z.d(N);
                            } else {
                                anchorInfo.f7367b = (this.f7364z.m() + this.I) - this.f7364z.g(N);
                            }
                            return true;
                        } else if (this.f7364z.e(N) > this.f7364z.n()) {
                            if (anchorInfo.f7368c) {
                                m8 = this.f7364z.i();
                            } else {
                                m8 = this.f7364z.m();
                            }
                            anchorInfo.f7367b = m8;
                            return true;
                        } else {
                            int g8 = this.f7364z.g(N) - this.f7364z.m();
                            if (g8 < 0) {
                                anchorInfo.f7367b = -g8;
                                return true;
                            }
                            int i9 = this.f7364z.i() - this.f7364z.d(N);
                            if (i9 < 0) {
                                anchorInfo.f7367b = i9;
                                return true;
                            }
                            anchorInfo.f7367b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i10 = this.H;
                        anchorInfo.f7366a = i10;
                        int i11 = this.I;
                        if (i11 == Integer.MIN_VALUE) {
                            if (c2(i10) == 1) {
                                z7 = true;
                            }
                            anchorInfo.f7368c = z7;
                            anchorInfo.a();
                        } else {
                            anchorInfo.b(i11);
                        }
                        anchorInfo.f7369d = true;
                    }
                }
                return true;
            }
            this.H = -1;
            this.I = Integer.MIN_VALUE;
        }
        return false;
    }

    void Y2(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (X2(state, anchorInfo) || W2(state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.f7366a = 0;
    }

    boolean Z1() {
        int l8 = this.f7363y[0].l(Integer.MIN_VALUE);
        for (int i8 = 1; i8 < this.f7362x; i8++) {
            if (this.f7363y[i8].l(Integer.MIN_VALUE) != l8) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF a(int i8) {
        int c22 = c2(i8);
        PointF pointF = new PointF();
        if (c22 == 0) {
            return null;
        }
        if (this.B == 0) {
            pointF.x = c22;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = c22;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void a1(RecyclerView recyclerView, int i8, int i9) {
        B2(i8, i9, 1);
    }

    boolean a2() {
        int p8 = this.f7363y[0].p(Integer.MIN_VALUE);
        for (int i8 = 1; i8 < this.f7362x; i8++) {
            if (this.f7363y[i8].p(Integer.MIN_VALUE) != p8) {
                return false;
            }
        }
        return true;
    }

    void a3(int i8) {
        this.C = i8 / this.f7362x;
        this.O = View.MeasureSpec.makeMeasureSpec(i8, this.A.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void b1(RecyclerView recyclerView) {
        this.J.b();
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void c1(RecyclerView recyclerView, int i8, int i9, int i10) {
        B2(i8, i9, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(RecyclerView recyclerView, int i8, int i9) {
        B2(i8, i9, 2);
    }

    boolean d2() {
        int u22;
        int v22;
        int i8;
        if (U() == 0 || this.K == 0 || !y0()) {
            return false;
        }
        if (this.F) {
            u22 = v2();
            v22 = u2();
        } else {
            u22 = u2();
            v22 = v2();
        }
        if (u22 == 0 && C2() != null) {
            this.J.b();
            E1();
            D1();
            return true;
        } else if (!this.R) {
            return false;
        } else {
            if (this.F) {
                i8 = -1;
            } else {
                i8 = 1;
            }
            int i9 = v22 + 1;
            LazySpanLookup.FullSpanItem e8 = this.J.e(u22, i9, i8, true);
            if (e8 == null) {
                this.R = false;
                this.J.d(i9);
                return false;
            }
            LazySpanLookup.FullSpanItem e9 = this.J.e(u22, e8.f7377f, i8 * (-1), true);
            if (e9 == null) {
                this.J.d(e8.f7377f);
            } else {
                this.J.d(e9.f7377f + 1);
            }
            E1();
            D1();
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void f1(RecyclerView recyclerView, int i8, int i9, Object obj) {
        B2(i8, i9, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void g1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        H2(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h1(RecyclerView.State state) {
        super.h1(state);
        this.H = -1;
        this.I = Integer.MIN_VALUE;
        this.N = null;
        this.Q.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void l1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.N = savedState;
            if (this.H != -1) {
                savedState.a();
                this.N.b();
            }
            D1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable m1() {
        int u22;
        int p8;
        int m8;
        int[] iArr;
        if (this.N != null) {
            return new SavedState(this.N);
        }
        SavedState savedState = new SavedState();
        savedState.f7388m = this.E;
        savedState.f7389n = this.L;
        savedState.f7390o = this.M;
        LazySpanLookup lazySpanLookup = this.J;
        if (lazySpanLookup != null && (iArr = lazySpanLookup.f7375a) != null) {
            savedState.f7386k = iArr;
            savedState.f7385j = iArr.length;
            savedState.f7387l = lazySpanLookup.f7376b;
        } else {
            savedState.f7385j = 0;
        }
        if (U() > 0) {
            if (this.L) {
                u22 = v2();
            } else {
                u22 = u2();
            }
            savedState.f7381f = u22;
            savedState.f7382g = q2();
            int i8 = this.f7362x;
            savedState.f7383h = i8;
            savedState.f7384i = new int[i8];
            for (int i9 = 0; i9 < this.f7362x; i9++) {
                if (this.L) {
                    p8 = this.f7363y[i9].l(Integer.MIN_VALUE);
                    if (p8 != Integer.MIN_VALUE) {
                        m8 = this.f7364z.i();
                        p8 -= m8;
                        savedState.f7384i[i9] = p8;
                    } else {
                        savedState.f7384i[i9] = p8;
                    }
                } else {
                    p8 = this.f7363y[i9].p(Integer.MIN_VALUE);
                    if (p8 != Integer.MIN_VALUE) {
                        m8 = this.f7364z.m();
                        p8 -= m8;
                        savedState.f7384i[i9] = p8;
                    } else {
                        savedState.f7384i[i9] = p8;
                    }
                }
            }
        } else {
            savedState.f7381f = -1;
            savedState.f7382g = -1;
            savedState.f7383h = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void n1(int i8) {
        if (i8 == 0) {
            d2();
        }
    }

    View o2(boolean z7) {
        int m8 = this.f7364z.m();
        int i8 = this.f7364z.i();
        View view = null;
        for (int U = U() - 1; U >= 0; U--) {
            View T = T(U);
            int g8 = this.f7364z.g(T);
            int d8 = this.f7364z.d(T);
            if (d8 > m8 && g8 < i8) {
                if (d8 > i8 && z7) {
                    if (view == null) {
                        view = T;
                    }
                } else {
                    return T;
                }
            }
        }
        return view;
    }

    View p2(boolean z7) {
        int m8 = this.f7364z.m();
        int i8 = this.f7364z.i();
        int U = U();
        View view = null;
        for (int i9 = 0; i9 < U; i9++) {
            View T = T(i9);
            int g8 = this.f7364z.g(T);
            if (this.f7364z.d(T) > m8 && g8 < i8) {
                if (g8 < m8 && z7) {
                    if (view == null) {
                        view = T;
                    }
                } else {
                    return T;
                }
            }
        }
        return view;
    }

    int q2() {
        View p22;
        if (this.F) {
            p22 = o2(true);
        } else {
            p22 = p2(true);
        }
        if (p22 == null) {
            return -1;
        }
        return o0(p22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void r(String str) {
        if (this.N == null) {
            super.r(str);
        }
    }

    int u2() {
        if (U() == 0) {
            return 0;
        }
        return o0(T(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean v() {
        if (this.B == 0) {
            return true;
        }
        return false;
    }

    int v2() {
        int U = U();
        if (U == 0) {
            return 0;
        }
        return o0(T(U - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean w() {
        if (this.B == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean x(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void z(int i8, int i9, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int l8;
        int i10;
        if (this.B != 0) {
            i8 = i9;
        }
        if (U() != 0 && i8 != 0) {
            J2(i8, state);
            int[] iArr = this.T;
            if (iArr == null || iArr.length < this.f7362x) {
                this.T = new int[this.f7362x];
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f7362x; i12++) {
                LayoutState layoutState = this.D;
                if (layoutState.f7125d == -1) {
                    l8 = layoutState.f7127f;
                    i10 = this.f7363y[i12].p(l8);
                } else {
                    l8 = this.f7363y[i12].l(layoutState.f7128g);
                    i10 = this.D.f7128g;
                }
                int i13 = l8 - i10;
                if (i13 >= 0) {
                    this.T[i11] = i13;
                    i11++;
                }
            }
            Arrays.sort(this.T, 0, i11);
            for (int i14 = 0; i14 < i11 && this.D.a(state); i14++) {
                layoutPrefetchRegistry.a(this.D.f7124c, this.T[i14]);
                LayoutState layoutState2 = this.D;
                layoutState2.f7124c += layoutState2.f7125d;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean z0() {
        if (this.K != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f7375a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f7376b;

        LazySpanLookup() {
        }

        private int i(int i8) {
            if (this.f7376b == null) {
                return -1;
            }
            FullSpanItem f8 = f(i8);
            if (f8 != null) {
                this.f7376b.remove(f8);
            }
            int size = this.f7376b.size();
            int i9 = 0;
            while (true) {
                if (i9 < size) {
                    if (this.f7376b.get(i9).f7377f >= i8) {
                        break;
                    }
                    i9++;
                } else {
                    i9 = -1;
                    break;
                }
            }
            if (i9 == -1) {
                return -1;
            }
            this.f7376b.remove(i9);
            return this.f7376b.get(i9).f7377f;
        }

        private void l(int i8, int i9) {
            List<FullSpanItem> list = this.f7376b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f7376b.get(size);
                int i10 = fullSpanItem.f7377f;
                if (i10 >= i8) {
                    fullSpanItem.f7377f = i10 + i9;
                }
            }
        }

        private void m(int i8, int i9) {
            List<FullSpanItem> list = this.f7376b;
            if (list == null) {
                return;
            }
            int i10 = i8 + i9;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f7376b.get(size);
                int i11 = fullSpanItem.f7377f;
                if (i11 >= i8) {
                    if (i11 < i10) {
                        this.f7376b.remove(size);
                    } else {
                        fullSpanItem.f7377f = i11 - i9;
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f7376b == null) {
                this.f7376b = new ArrayList();
            }
            int size = this.f7376b.size();
            for (int i8 = 0; i8 < size; i8++) {
                FullSpanItem fullSpanItem2 = this.f7376b.get(i8);
                if (fullSpanItem2.f7377f == fullSpanItem.f7377f) {
                    this.f7376b.remove(i8);
                }
                if (fullSpanItem2.f7377f >= fullSpanItem.f7377f) {
                    this.f7376b.add(i8, fullSpanItem);
                    return;
                }
            }
            this.f7376b.add(fullSpanItem);
        }

        void b() {
            int[] iArr = this.f7375a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f7376b = null;
        }

        void c(int i8) {
            int[] iArr = this.f7375a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i8, 10) + 1];
                this.f7375a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i8 >= iArr.length) {
                int[] iArr3 = new int[o(i8)];
                this.f7375a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f7375a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i8) {
            List<FullSpanItem> list = this.f7376b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f7376b.get(size).f7377f >= i8) {
                        this.f7376b.remove(size);
                    }
                }
            }
            return h(i8);
        }

        public FullSpanItem e(int i8, int i9, int i10, boolean z7) {
            List<FullSpanItem> list = this.f7376b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                FullSpanItem fullSpanItem = this.f7376b.get(i11);
                int i12 = fullSpanItem.f7377f;
                if (i12 >= i9) {
                    return null;
                }
                if (i12 >= i8 && (i10 == 0 || fullSpanItem.f7378g == i10 || (z7 && fullSpanItem.f7380i))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i8) {
            List<FullSpanItem> list = this.f7376b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f7376b.get(size);
                if (fullSpanItem.f7377f == i8) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int g(int i8) {
            int[] iArr = this.f7375a;
            if (iArr != null && i8 < iArr.length) {
                return iArr[i8];
            }
            return -1;
        }

        int h(int i8) {
            int[] iArr = this.f7375a;
            if (iArr == null || i8 >= iArr.length) {
                return -1;
            }
            int i9 = i(i8);
            if (i9 == -1) {
                int[] iArr2 = this.f7375a;
                Arrays.fill(iArr2, i8, iArr2.length, -1);
                return this.f7375a.length;
            }
            int min = Math.min(i9 + 1, this.f7375a.length);
            Arrays.fill(this.f7375a, i8, min, -1);
            return min;
        }

        void j(int i8, int i9) {
            int[] iArr = this.f7375a;
            if (iArr != null && i8 < iArr.length) {
                int i10 = i8 + i9;
                c(i10);
                int[] iArr2 = this.f7375a;
                System.arraycopy(iArr2, i8, iArr2, i10, (iArr2.length - i8) - i9);
                Arrays.fill(this.f7375a, i8, i10, -1);
                l(i8, i9);
            }
        }

        void k(int i8, int i9) {
            int[] iArr = this.f7375a;
            if (iArr != null && i8 < iArr.length) {
                int i10 = i8 + i9;
                c(i10);
                int[] iArr2 = this.f7375a;
                System.arraycopy(iArr2, i10, iArr2, i8, (iArr2.length - i8) - i9);
                int[] iArr3 = this.f7375a;
                Arrays.fill(iArr3, iArr3.length - i9, iArr3.length, -1);
                m(i8, i9);
            }
        }

        void n(int i8, Span span) {
            c(i8);
            this.f7375a[i8] = span.f7395e;
        }

        int o(int i8) {
            int length = this.f7375a.length;
            while (length <= i8) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public FullSpanItem[] newArray(int i8) {
                    return new FullSpanItem[i8];
                }
            };

            /* renamed from: f  reason: collision with root package name */
            int f7377f;

            /* renamed from: g  reason: collision with root package name */
            int f7378g;

            /* renamed from: h  reason: collision with root package name */
            int[] f7379h;

            /* renamed from: i  reason: collision with root package name */
            boolean f7380i;

            FullSpanItem(Parcel parcel) {
                this.f7377f = parcel.readInt();
                this.f7378g = parcel.readInt();
                this.f7380i = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f7379h = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i8) {
                int[] iArr = this.f7379h;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i8];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f7377f + ", mGapDir=" + this.f7378g + ", mHasUnwantedGapAfter=" + this.f7380i + ", mGapPerSpan=" + Arrays.toString(this.f7379h) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i8) {
                parcel.writeInt(this.f7377f);
                parcel.writeInt(this.f7378g);
                parcel.writeInt(this.f7380i ? 1 : 0);
                int[] iArr = this.f7379h;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f7379h);
                    return;
                }
                parcel.writeInt(0);
            }

            FullSpanItem() {
            }
        }
    }
}
