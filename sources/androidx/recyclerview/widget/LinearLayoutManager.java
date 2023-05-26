package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private boolean A;
    private boolean B;
    boolean C;
    private boolean D;
    private boolean E;
    int F;
    int G;
    private boolean H;
    SavedState I;
    final AnchorInfo J;
    private final LayoutChunkResult K;
    private int L;
    private int[] M;

    /* renamed from: x  reason: collision with root package name */
    int f7131x;

    /* renamed from: y  reason: collision with root package name */
    private LayoutState f7132y;

    /* renamed from: z  reason: collision with root package name */
    OrientationHelper f7133z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        OrientationHelper f7134a;

        /* renamed from: b  reason: collision with root package name */
        int f7135b;

        /* renamed from: c  reason: collision with root package name */
        int f7136c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7137d;

        /* renamed from: e  reason: collision with root package name */
        boolean f7138e;

        AnchorInfo() {
            e();
        }

        void a() {
            int m8;
            if (this.f7137d) {
                m8 = this.f7134a.i();
            } else {
                m8 = this.f7134a.m();
            }
            this.f7136c = m8;
        }

        public void b(View view, int i8) {
            if (this.f7137d) {
                this.f7136c = this.f7134a.d(view) + this.f7134a.o();
            } else {
                this.f7136c = this.f7134a.g(view);
            }
            this.f7135b = i8;
        }

        public void c(View view, int i8) {
            int o8 = this.f7134a.o();
            if (o8 >= 0) {
                b(view, i8);
                return;
            }
            this.f7135b = i8;
            if (this.f7137d) {
                int i9 = (this.f7134a.i() - o8) - this.f7134a.d(view);
                this.f7136c = this.f7134a.i() - i9;
                if (i9 > 0) {
                    int e8 = this.f7136c - this.f7134a.e(view);
                    int m8 = this.f7134a.m();
                    int min = e8 - (m8 + Math.min(this.f7134a.g(view) - m8, 0));
                    if (min < 0) {
                        this.f7136c += Math.min(i9, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g8 = this.f7134a.g(view);
            int m9 = g8 - this.f7134a.m();
            this.f7136c = g8;
            if (m9 > 0) {
                int i10 = (this.f7134a.i() - Math.min(0, (this.f7134a.i() - o8) - this.f7134a.d(view))) - (g8 + this.f7134a.e(view));
                if (i10 < 0) {
                    this.f7136c -= Math.min(m9, -i10);
                }
            }
        }

        boolean d(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (!layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < state.b()) {
                return true;
            }
            return false;
        }

        void e() {
            this.f7135b = -1;
            this.f7136c = Integer.MIN_VALUE;
            this.f7137d = false;
            this.f7138e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f7135b + ", mCoordinate=" + this.f7136c + ", mLayoutFromEnd=" + this.f7137d + ", mValid=" + this.f7138e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class LayoutChunkResult {

        /* renamed from: a  reason: collision with root package name */
        public int f7139a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7140b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7141c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f7142d;

        protected LayoutChunkResult() {
        }

        void a() {
            this.f7139a = 0;
            this.f7140b = false;
            this.f7141c = false;
            this.f7142d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LayoutState {

        /* renamed from: b  reason: collision with root package name */
        int f7144b;

        /* renamed from: c  reason: collision with root package name */
        int f7145c;

        /* renamed from: d  reason: collision with root package name */
        int f7146d;

        /* renamed from: e  reason: collision with root package name */
        int f7147e;

        /* renamed from: f  reason: collision with root package name */
        int f7148f;

        /* renamed from: g  reason: collision with root package name */
        int f7149g;

        /* renamed from: k  reason: collision with root package name */
        int f7153k;

        /* renamed from: m  reason: collision with root package name */
        boolean f7155m;

        /* renamed from: a  reason: collision with root package name */
        boolean f7143a = true;

        /* renamed from: h  reason: collision with root package name */
        int f7150h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f7151i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f7152j = false;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.ViewHolder> f7154l = null;

        LayoutState() {
        }

        private View e() {
            int size = this.f7154l.size();
            for (int i8 = 0; i8 < size; i8++) {
                View view = this.f7154l.get(i8).f7332a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.f7146d == layoutParams.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f8 = f(view);
            if (f8 == null) {
                this.f7146d = -1;
            } else {
                this.f7146d = ((RecyclerView.LayoutParams) f8.getLayoutParams()).a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.State state) {
            int i8 = this.f7146d;
            if (i8 >= 0 && i8 < state.b()) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.Recycler recycler) {
            if (this.f7154l != null) {
                return e();
            }
            View o8 = recycler.o(this.f7146d);
            this.f7146d += this.f7147e;
            return o8;
        }

        public View f(View view) {
            int a8;
            int size = this.f7154l.size();
            View view2 = null;
            int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i9 = 0; i9 < size; i9++) {
                View view3 = this.f7154l.get(i9).f7332a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (a8 = (layoutParams.a() - this.f7146d) * this.f7147e) >= 0 && a8 < i8) {
                    view2 = view3;
                    if (a8 == 0) {
                        break;
                    }
                    i8 = a8;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
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
        int f7156f;

        /* renamed from: g  reason: collision with root package name */
        int f7157g;

        /* renamed from: h  reason: collision with root package name */
        boolean f7158h;

        public SavedState() {
        }

        boolean a() {
            if (this.f7156f >= 0) {
                return true;
            }
            return false;
        }

        void b() {
            this.f7156f = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeInt(this.f7156f);
            parcel.writeInt(this.f7157g);
            parcel.writeInt(this.f7158h ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f7156f = parcel.readInt();
            this.f7157g = parcel.readInt();
            this.f7158h = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f7156f = savedState.f7156f;
            this.f7157g = savedState.f7157g;
            this.f7158h = savedState.f7158h;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void C2(RecyclerView.Recycler recycler, RecyclerView.State state, int i8, int i9) {
        boolean z7;
        if (state.g() && U() != 0 && !state.e() && W1()) {
            List<RecyclerView.ViewHolder> k8 = recycler.k();
            int size = k8.size();
            int o02 = o0(T(0));
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                RecyclerView.ViewHolder viewHolder = k8.get(i12);
                if (!viewHolder.x()) {
                    char c8 = 1;
                    if (viewHolder.o() < o02) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7 != this.C) {
                        c8 = 65535;
                    }
                    if (c8 == 65535) {
                        i10 += this.f7133z.e(viewHolder.f7332a);
                    } else {
                        i11 += this.f7133z.e(viewHolder.f7332a);
                    }
                }
            }
            this.f7132y.f7154l = k8;
            if (i10 > 0) {
                V2(o0(w2()), i8);
                LayoutState layoutState = this.f7132y;
                layoutState.f7150h = i10;
                layoutState.f7145c = 0;
                layoutState.a();
                f2(recycler, this.f7132y, state, false);
            }
            if (i11 > 0) {
                T2(o0(v2()), i9);
                LayoutState layoutState2 = this.f7132y;
                layoutState2.f7150h = i11;
                layoutState2.f7145c = 0;
                layoutState2.a();
                f2(recycler, this.f7132y, state, false);
            }
            this.f7132y.f7154l = null;
        }
    }

    private void E2(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f7143a && !layoutState.f7155m) {
            int i8 = layoutState.f7149g;
            int i9 = layoutState.f7151i;
            if (layoutState.f7148f == -1) {
                G2(recycler, i8, i9);
            } else {
                H2(recycler, i8, i9);
            }
        }
    }

    private void F2(RecyclerView.Recycler recycler, int i8, int i9) {
        if (i8 == i9) {
            return;
        }
        if (i9 > i8) {
            for (int i10 = i9 - 1; i10 >= i8; i10--) {
                x1(i10, recycler);
            }
            return;
        }
        while (i8 > i9) {
            x1(i8, recycler);
            i8--;
        }
    }

    private void G2(RecyclerView.Recycler recycler, int i8, int i9) {
        int U = U();
        if (i8 < 0) {
            return;
        }
        int h8 = (this.f7133z.h() - i8) + i9;
        if (this.C) {
            for (int i10 = 0; i10 < U; i10++) {
                View T = T(i10);
                if (this.f7133z.g(T) < h8 || this.f7133z.q(T) < h8) {
                    F2(recycler, 0, i10);
                    return;
                }
            }
            return;
        }
        int i11 = U - 1;
        for (int i12 = i11; i12 >= 0; i12--) {
            View T2 = T(i12);
            if (this.f7133z.g(T2) < h8 || this.f7133z.q(T2) < h8) {
                F2(recycler, i11, i12);
                return;
            }
        }
    }

    private void H2(RecyclerView.Recycler recycler, int i8, int i9) {
        if (i8 < 0) {
            return;
        }
        int i10 = i8 - i9;
        int U = U();
        if (this.C) {
            int i11 = U - 1;
            for (int i12 = i11; i12 >= 0; i12--) {
                View T = T(i12);
                if (this.f7133z.d(T) > i10 || this.f7133z.p(T) > i10) {
                    F2(recycler, i11, i12);
                    return;
                }
            }
            return;
        }
        for (int i13 = 0; i13 < U; i13++) {
            View T2 = T(i13);
            if (this.f7133z.d(T2) > i10 || this.f7133z.p(T2) > i10) {
                F2(recycler, 0, i13);
                return;
            }
        }
    }

    private void J2() {
        if (this.f7131x != 1 && z2()) {
            this.C = !this.B;
        } else {
            this.C = this.B;
        }
    }

    private boolean P2(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View s22;
        boolean z7;
        boolean z8 = false;
        if (U() == 0) {
            return false;
        }
        View g02 = g0();
        if (g02 != null && anchorInfo.d(g02, state)) {
            anchorInfo.c(g02, o0(g02));
            return true;
        }
        boolean z9 = this.A;
        boolean z10 = this.D;
        if (z9 != z10 || (s22 = s2(recycler, state, anchorInfo.f7137d, z10)) == null) {
            return false;
        }
        anchorInfo.b(s22, o0(s22));
        if (!state.e() && W1()) {
            int g8 = this.f7133z.g(s22);
            int d8 = this.f7133z.d(s22);
            int m8 = this.f7133z.m();
            int i8 = this.f7133z.i();
            if (d8 <= m8 && g8 < m8) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (g8 >= i8 && d8 > i8) {
                z8 = true;
            }
            if (z7 || z8) {
                if (anchorInfo.f7137d) {
                    m8 = i8;
                }
                anchorInfo.f7136c = m8;
            }
        }
        return true;
    }

    private boolean Q2(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i8;
        boolean z7;
        int g8;
        boolean z8 = false;
        if (!state.e() && (i8 = this.F) != -1) {
            if (i8 >= 0 && i8 < state.b()) {
                anchorInfo.f7135b = this.F;
                SavedState savedState = this.I;
                if (savedState != null && savedState.a()) {
                    boolean z9 = this.I.f7158h;
                    anchorInfo.f7137d = z9;
                    if (z9) {
                        anchorInfo.f7136c = this.f7133z.i() - this.I.f7157g;
                    } else {
                        anchorInfo.f7136c = this.f7133z.m() + this.I.f7157g;
                    }
                    return true;
                } else if (this.G == Integer.MIN_VALUE) {
                    View N = N(this.F);
                    if (N != null) {
                        if (this.f7133z.e(N) > this.f7133z.n()) {
                            anchorInfo.a();
                            return true;
                        } else if (this.f7133z.g(N) - this.f7133z.m() < 0) {
                            anchorInfo.f7136c = this.f7133z.m();
                            anchorInfo.f7137d = false;
                            return true;
                        } else if (this.f7133z.i() - this.f7133z.d(N) < 0) {
                            anchorInfo.f7136c = this.f7133z.i();
                            anchorInfo.f7137d = true;
                            return true;
                        } else {
                            if (anchorInfo.f7137d) {
                                g8 = this.f7133z.d(N) + this.f7133z.o();
                            } else {
                                g8 = this.f7133z.g(N);
                            }
                            anchorInfo.f7136c = g8;
                        }
                    } else {
                        if (U() > 0) {
                            if (this.F < o0(T(0))) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7 == this.C) {
                                z8 = true;
                            }
                            anchorInfo.f7137d = z8;
                        }
                        anchorInfo.a();
                    }
                    return true;
                } else {
                    boolean z10 = this.C;
                    anchorInfo.f7137d = z10;
                    if (z10) {
                        anchorInfo.f7136c = this.f7133z.i() - this.G;
                    } else {
                        anchorInfo.f7136c = this.f7133z.m() + this.G;
                    }
                    return true;
                }
            }
            this.F = -1;
            this.G = Integer.MIN_VALUE;
        }
        return false;
    }

    private void R2(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int i8;
        if (Q2(state, anchorInfo) || P2(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        if (this.D) {
            i8 = state.b() - 1;
        } else {
            i8 = 0;
        }
        anchorInfo.f7135b = i8;
    }

    private void S2(int i8, int i9, boolean z7, RecyclerView.State state) {
        int i10;
        int m8;
        this.f7132y.f7155m = I2();
        this.f7132y.f7148f = i8;
        int[] iArr = this.M;
        boolean z8 = false;
        iArr[0] = 0;
        int i11 = 1;
        iArr[1] = 0;
        X1(state, iArr);
        int max = Math.max(0, this.M[0]);
        int max2 = Math.max(0, this.M[1]);
        if (i8 == 1) {
            z8 = true;
        }
        LayoutState layoutState = this.f7132y;
        if (z8) {
            i10 = max2;
        } else {
            i10 = max;
        }
        layoutState.f7150h = i10;
        if (!z8) {
            max = max2;
        }
        layoutState.f7151i = max;
        if (z8) {
            layoutState.f7150h = i10 + this.f7133z.j();
            View v22 = v2();
            LayoutState layoutState2 = this.f7132y;
            if (this.C) {
                i11 = -1;
            }
            layoutState2.f7147e = i11;
            int o02 = o0(v22);
            LayoutState layoutState3 = this.f7132y;
            layoutState2.f7146d = o02 + layoutState3.f7147e;
            layoutState3.f7144b = this.f7133z.d(v22);
            m8 = this.f7133z.d(v22) - this.f7133z.i();
        } else {
            View w22 = w2();
            this.f7132y.f7150h += this.f7133z.m();
            LayoutState layoutState4 = this.f7132y;
            if (!this.C) {
                i11 = -1;
            }
            layoutState4.f7147e = i11;
            int o03 = o0(w22);
            LayoutState layoutState5 = this.f7132y;
            layoutState4.f7146d = o03 + layoutState5.f7147e;
            layoutState5.f7144b = this.f7133z.g(w22);
            m8 = (-this.f7133z.g(w22)) + this.f7133z.m();
        }
        LayoutState layoutState6 = this.f7132y;
        layoutState6.f7145c = i9;
        if (z7) {
            layoutState6.f7145c = i9 - m8;
        }
        layoutState6.f7149g = m8;
    }

    private void T2(int i8, int i9) {
        int i10;
        this.f7132y.f7145c = this.f7133z.i() - i9;
        LayoutState layoutState = this.f7132y;
        if (this.C) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        layoutState.f7147e = i10;
        layoutState.f7146d = i8;
        layoutState.f7148f = 1;
        layoutState.f7144b = i9;
        layoutState.f7149g = Integer.MIN_VALUE;
    }

    private void U2(AnchorInfo anchorInfo) {
        T2(anchorInfo.f7135b, anchorInfo.f7136c);
    }

    private void V2(int i8, int i9) {
        int i10;
        this.f7132y.f7145c = i9 - this.f7133z.m();
        LayoutState layoutState = this.f7132y;
        layoutState.f7146d = i8;
        if (this.C) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        layoutState.f7147e = i10;
        layoutState.f7148f = -1;
        layoutState.f7144b = i9;
        layoutState.f7149g = Integer.MIN_VALUE;
    }

    private void W2(AnchorInfo anchorInfo) {
        V2(anchorInfo.f7135b, anchorInfo.f7136c);
    }

    private int Z1(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        e2();
        return ScrollbarHelper.a(state, this.f7133z, j2(!this.E, true), i2(!this.E, true), this, this.E);
    }

    private int a2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        e2();
        return ScrollbarHelper.b(state, this.f7133z, j2(!this.E, true), i2(!this.E, true), this, this.E, this.C);
    }

    private int b2(RecyclerView.State state) {
        if (U() == 0) {
            return 0;
        }
        e2();
        return ScrollbarHelper.c(state, this.f7133z, j2(!this.E, true), i2(!this.E, true), this, this.E);
    }

    private View h2() {
        return o2(0, U());
    }

    private View m2() {
        return o2(U() - 1, -1);
    }

    private View q2() {
        if (this.C) {
            return h2();
        }
        return m2();
    }

    private View r2() {
        if (this.C) {
            return m2();
        }
        return h2();
    }

    private int t2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7) {
        int i9;
        int i10 = this.f7133z.i() - i8;
        if (i10 > 0) {
            int i11 = -K2(-i10, recycler, state);
            int i12 = i8 + i11;
            if (z7 && (i9 = this.f7133z.i() - i12) > 0) {
                this.f7133z.r(i9);
                return i9 + i11;
            }
            return i11;
        }
        return 0;
    }

    private int u2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7) {
        int m8;
        int m9 = i8 - this.f7133z.m();
        if (m9 > 0) {
            int i9 = -K2(m9, recycler, state);
            int i10 = i8 + i9;
            if (z7 && (m8 = i10 - this.f7133z.m()) > 0) {
                this.f7133z.r(-m8);
                return i9 - m8;
            }
            return i9;
        }
        return 0;
    }

    private View v2() {
        int U;
        if (this.C) {
            U = 0;
        } else {
            U = U() - 1;
        }
        return T(U);
    }

    private View w2() {
        int i8;
        if (this.C) {
            i8 = U() - 1;
        } else {
            i8 = 0;
        }
        return T(i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void A(int i8, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z7;
        int i9;
        SavedState savedState = this.I;
        int i10 = -1;
        if (savedState != null && savedState.a()) {
            SavedState savedState2 = this.I;
            z7 = savedState2.f7158h;
            i9 = savedState2.f7156f;
        } else {
            J2();
            z7 = this.C;
            i9 = this.F;
            if (i9 == -1) {
                i9 = z7 ? i8 - 1 : 0;
            }
        }
        if (!z7) {
            i10 = 1;
        }
        for (int i11 = 0; i11 < this.L && i9 >= 0 && i9 < i8; i11++) {
            layoutPrefetchRegistry.a(i9, 0);
            i9 += i10;
        }
    }

    public boolean A2() {
        return this.E;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int B(RecyclerView.State state) {
        return Z1(state);
    }

    void B2(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        boolean z7;
        int i8;
        int i9;
        int i10;
        int i11;
        int f8;
        boolean z8;
        View d8 = layoutState.d(recycler);
        if (d8 == null) {
            layoutChunkResult.f7140b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) d8.getLayoutParams();
        if (layoutState.f7154l == null) {
            boolean z9 = this.C;
            if (layoutState.f7148f == -1) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z9 == z8) {
                o(d8);
            } else {
                p(d8, 0);
            }
        } else {
            boolean z10 = this.C;
            if (layoutState.f7148f == -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z10 == z7) {
                m(d8);
            } else {
                n(d8, 0);
            }
        }
        J0(d8, 0, 0);
        layoutChunkResult.f7139a = this.f7133z.e(d8);
        if (this.f7131x == 1) {
            if (z2()) {
                f8 = v0() - getPaddingRight();
                i11 = f8 - this.f7133z.f(d8);
            } else {
                i11 = getPaddingLeft();
                f8 = this.f7133z.f(d8) + i11;
            }
            if (layoutState.f7148f == -1) {
                int i12 = layoutState.f7144b;
                i10 = i12;
                i9 = f8;
                i8 = i12 - layoutChunkResult.f7139a;
            } else {
                int i13 = layoutState.f7144b;
                i8 = i13;
                i9 = f8;
                i10 = layoutChunkResult.f7139a + i13;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f9 = this.f7133z.f(d8) + paddingTop;
            if (layoutState.f7148f == -1) {
                int i14 = layoutState.f7144b;
                i9 = i14;
                i8 = paddingTop;
                i10 = f9;
                i11 = i14 - layoutChunkResult.f7139a;
            } else {
                int i15 = layoutState.f7144b;
                i8 = paddingTop;
                i9 = layoutChunkResult.f7139a + i15;
                i10 = f9;
                i11 = i15;
            }
        }
        I0(d8, i11, i8, i9, i10);
        if (layoutParams.c() || layoutParams.b()) {
            layoutChunkResult.f7141c = true;
        }
        layoutChunkResult.f7142d = d8.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int C(RecyclerView.State state) {
        return a2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int D(RecyclerView.State state) {
        return b2(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D2(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i8) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int E(RecyclerView.State state) {
        return Z1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int F(RecyclerView.State state) {
        return a2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G(RecyclerView.State state) {
        return b2(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7131x == 1) {
            return 0;
        }
        return K2(i8, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void H1(int i8) {
        this.F = i8;
        this.G = Integer.MIN_VALUE;
        SavedState savedState = this.I;
        if (savedState != null) {
            savedState.b();
        }
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int I1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7131x == 0) {
            return 0;
        }
        return K2(i8, recycler, state);
    }

    boolean I2() {
        if (this.f7133z.k() == 0 && this.f7133z.h() == 0) {
            return true;
        }
        return false;
    }

    int K2(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i9;
        if (U() == 0 || i8 == 0) {
            return 0;
        }
        e2();
        this.f7132y.f7143a = true;
        if (i8 > 0) {
            i9 = 1;
        } else {
            i9 = -1;
        }
        int abs = Math.abs(i8);
        S2(i9, abs, true, state);
        LayoutState layoutState = this.f7132y;
        int f22 = layoutState.f7149g + f2(recycler, layoutState, state, false);
        if (f22 < 0) {
            return 0;
        }
        if (abs > f22) {
            i8 = i9 * f22;
        }
        this.f7133z.r(-i8);
        this.f7132y.f7153k = i8;
        return i8;
    }

    public void L2(int i8, int i9) {
        this.F = i8;
        this.G = i9;
        SavedState savedState = this.I;
        if (savedState != null) {
            savedState.b();
        }
        D1();
    }

    public void M2(int i8) {
        if (i8 != 0 && i8 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i8);
        }
        r(null);
        if (i8 != this.f7131x || this.f7133z == null) {
            OrientationHelper b8 = OrientationHelper.b(this, i8);
            this.f7133z = b8;
            this.J.f7134a = b8;
            this.f7131x = i8;
            D1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View N(int i8) {
        int U = U();
        if (U == 0) {
            return null;
        }
        int o02 = i8 - o0(T(0));
        if (o02 >= 0 && o02 < U) {
            View T = T(o02);
            if (o0(T) == i8) {
                return T;
            }
        }
        return super.N(i8);
    }

    public void N2(boolean z7) {
        r(null);
        if (z7 == this.B) {
            return;
        }
        this.B = z7;
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams O() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void O2(boolean z7) {
        r(null);
        if (this.D == z7) {
            return;
        }
        this.D = z7;
        D1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void R0(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.R0(recyclerView, recycler);
        if (this.H) {
            u1(recycler);
            recycler.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    boolean R1() {
        if (i0() != 1073741824 && w0() != 1073741824 && x0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View S0(View view, int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int c22;
        View q22;
        View v22;
        J2();
        if (U() == 0 || (c22 = c2(i8)) == Integer.MIN_VALUE) {
            return null;
        }
        e2();
        S2(c22, (int) (this.f7133z.n() * 0.33333334f), false, state);
        LayoutState layoutState = this.f7132y;
        layoutState.f7149g = Integer.MIN_VALUE;
        layoutState.f7143a = false;
        f2(recycler, layoutState, state, true);
        if (c22 == -1) {
            q22 = r2();
        } else {
            q22 = q2();
        }
        if (c22 == -1) {
            v22 = w2();
        } else {
            v22 = v2();
        }
        if (v22.hasFocusable()) {
            if (q22 == null) {
                return null;
            }
            return v22;
        }
        return q22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T0(AccessibilityEvent accessibilityEvent) {
        super.T0(accessibilityEvent);
        if (U() > 0) {
            accessibilityEvent.setFromIndex(k2());
            accessibilityEvent.setToIndex(n2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T1(RecyclerView recyclerView, RecyclerView.State state, int i8) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.p(i8);
        U1(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean W1() {
        if (this.I == null && this.A == this.D) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X1(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i8;
        int x22 = x2(state);
        if (this.f7132y.f7148f == -1) {
            i8 = 0;
        } else {
            i8 = x22;
            x22 = 0;
        }
        iArr[0] = x22;
        iArr[1] = i8;
    }

    void Y1(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i8 = layoutState.f7146d;
        if (i8 >= 0 && i8 < state.b()) {
            layoutPrefetchRegistry.a(i8, Math.max(0, layoutState.f7149g));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF a(int i8) {
        if (U() == 0) {
            return null;
        }
        boolean z7 = false;
        int i9 = 1;
        if (i8 < o0(T(0))) {
            z7 = true;
        }
        if (z7 != this.C) {
            i9 = -1;
        }
        if (this.f7131x == 0) {
            return new PointF(i9, 0.0f);
        }
        return new PointF(0.0f, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c2(int i8) {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 17) {
                    if (i8 != 33) {
                        if (i8 != 66) {
                            if (i8 == 130 && this.f7131x == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.f7131x == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.f7131x == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f7131x == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f7131x != 1 && z2()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f7131x == 1 || !z2()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void d(@NonNull View view, @NonNull View view2, int i8, int i9) {
        char c8;
        r("Cannot drop a view during a scroll or layout calculation");
        e2();
        J2();
        int o02 = o0(view);
        int o03 = o0(view2);
        if (o02 < o03) {
            c8 = 1;
        } else {
            c8 = 65535;
        }
        if (this.C) {
            if (c8 == 1) {
                L2(o03, this.f7133z.i() - (this.f7133z.g(view2) + this.f7133z.e(view)));
            } else {
                L2(o03, this.f7133z.i() - this.f7133z.d(view2));
            }
        } else if (c8 == 65535) {
            L2(o03, this.f7133z.g(view2));
        } else {
            L2(o03, this.f7133z.d(view2) - this.f7133z.e(view));
        }
    }

    LayoutState d2() {
        return new LayoutState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e2() {
        if (this.f7132y == null) {
            this.f7132y = d2();
        }
    }

    int f2(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z7) {
        int i8 = layoutState.f7145c;
        int i9 = layoutState.f7149g;
        if (i9 != Integer.MIN_VALUE) {
            if (i8 < 0) {
                layoutState.f7149g = i9 + i8;
            }
            E2(recycler, layoutState);
        }
        int i10 = layoutState.f7145c + layoutState.f7150h;
        LayoutChunkResult layoutChunkResult = this.K;
        while (true) {
            if ((!layoutState.f7155m && i10 <= 0) || !layoutState.c(state)) {
                break;
            }
            layoutChunkResult.a();
            B2(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f7140b) {
                layoutState.f7144b += layoutChunkResult.f7139a * layoutState.f7148f;
                if (!layoutChunkResult.f7141c || layoutState.f7154l != null || !state.e()) {
                    int i11 = layoutState.f7145c;
                    int i12 = layoutChunkResult.f7139a;
                    layoutState.f7145c = i11 - i12;
                    i10 -= i12;
                }
                int i13 = layoutState.f7149g;
                if (i13 != Integer.MIN_VALUE) {
                    int i14 = i13 + layoutChunkResult.f7139a;
                    layoutState.f7149g = i14;
                    int i15 = layoutState.f7145c;
                    if (i15 < 0) {
                        layoutState.f7149g = i14 + i15;
                    }
                    E2(recycler, layoutState);
                }
                if (z7 && layoutChunkResult.f7142d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i8 - layoutState.f7145c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void g1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int t22;
        int i13;
        View N;
        int g8;
        int i14;
        int i15 = -1;
        if ((this.I != null || this.F != -1) && state.b() == 0) {
            u1(recycler);
            return;
        }
        SavedState savedState = this.I;
        if (savedState != null && savedState.a()) {
            this.F = this.I.f7156f;
        }
        e2();
        this.f7132y.f7143a = false;
        J2();
        View g02 = g0();
        AnchorInfo anchorInfo = this.J;
        if (anchorInfo.f7138e && this.F == -1 && this.I == null) {
            if (g02 != null && (this.f7133z.g(g02) >= this.f7133z.i() || this.f7133z.d(g02) <= this.f7133z.m())) {
                this.J.c(g02, o0(g02));
            }
        } else {
            anchorInfo.e();
            AnchorInfo anchorInfo2 = this.J;
            anchorInfo2.f7137d = this.C ^ this.D;
            R2(recycler, state, anchorInfo2);
            this.J.f7138e = true;
        }
        LayoutState layoutState = this.f7132y;
        if (layoutState.f7153k >= 0) {
            i8 = 1;
        } else {
            i8 = -1;
        }
        layoutState.f7148f = i8;
        int[] iArr = this.M;
        iArr[0] = 0;
        iArr[1] = 0;
        X1(state, iArr);
        int max = Math.max(0, this.M[0]) + this.f7133z.m();
        int max2 = Math.max(0, this.M[1]) + this.f7133z.j();
        if (state.e() && (i13 = this.F) != -1 && this.G != Integer.MIN_VALUE && (N = N(i13)) != null) {
            if (this.C) {
                i14 = this.f7133z.i() - this.f7133z.d(N);
                g8 = this.G;
            } else {
                g8 = this.f7133z.g(N) - this.f7133z.m();
                i14 = this.G;
            }
            int i16 = i14 - g8;
            if (i16 > 0) {
                max += i16;
            } else {
                max2 -= i16;
            }
        }
        AnchorInfo anchorInfo3 = this.J;
        if (!anchorInfo3.f7137d ? !this.C : this.C) {
            i15 = 1;
        }
        D2(recycler, state, anchorInfo3, i15);
        H(recycler);
        this.f7132y.f7155m = I2();
        this.f7132y.f7152j = state.e();
        this.f7132y.f7151i = 0;
        AnchorInfo anchorInfo4 = this.J;
        if (anchorInfo4.f7137d) {
            W2(anchorInfo4);
            LayoutState layoutState2 = this.f7132y;
            layoutState2.f7150h = max;
            f2(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.f7132y;
            i10 = layoutState3.f7144b;
            int i17 = layoutState3.f7146d;
            int i18 = layoutState3.f7145c;
            if (i18 > 0) {
                max2 += i18;
            }
            U2(this.J);
            LayoutState layoutState4 = this.f7132y;
            layoutState4.f7150h = max2;
            layoutState4.f7146d += layoutState4.f7147e;
            f2(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.f7132y;
            i9 = layoutState5.f7144b;
            int i19 = layoutState5.f7145c;
            if (i19 > 0) {
                V2(i17, i10);
                LayoutState layoutState6 = this.f7132y;
                layoutState6.f7150h = i19;
                f2(recycler, layoutState6, state, false);
                i10 = this.f7132y.f7144b;
            }
        } else {
            U2(anchorInfo4);
            LayoutState layoutState7 = this.f7132y;
            layoutState7.f7150h = max2;
            f2(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.f7132y;
            i9 = layoutState8.f7144b;
            int i20 = layoutState8.f7146d;
            int i21 = layoutState8.f7145c;
            if (i21 > 0) {
                max += i21;
            }
            W2(this.J);
            LayoutState layoutState9 = this.f7132y;
            layoutState9.f7150h = max;
            layoutState9.f7146d += layoutState9.f7147e;
            f2(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.f7132y;
            i10 = layoutState10.f7144b;
            int i22 = layoutState10.f7145c;
            if (i22 > 0) {
                T2(i20, i9);
                LayoutState layoutState11 = this.f7132y;
                layoutState11.f7150h = i22;
                f2(recycler, layoutState11, state, false);
                i9 = this.f7132y.f7144b;
            }
        }
        if (U() > 0) {
            if (this.C ^ this.D) {
                int t23 = t2(i9, recycler, state, true);
                i11 = i10 + t23;
                i12 = i9 + t23;
                t22 = u2(i11, recycler, state, false);
            } else {
                int u22 = u2(i10, recycler, state, true);
                i11 = i10 + u22;
                i12 = i9 + u22;
                t22 = t2(i12, recycler, state, false);
            }
            i10 = i11 + t22;
            i9 = i12 + t22;
        }
        C2(recycler, state, i10, i9);
        if (!state.e()) {
            this.f7133z.s();
        } else {
            this.J.e();
        }
        this.A = this.D;
    }

    public int g2() {
        View p22 = p2(0, U(), true, false);
        if (p22 == null) {
            return -1;
        }
        return o0(p22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h1(RecyclerView.State state) {
        super.h1(state);
        this.I = null;
        this.F = -1;
        this.G = Integer.MIN_VALUE;
        this.J.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i2(boolean z7, boolean z8) {
        if (this.C) {
            return p2(0, U(), z7, z8);
        }
        return p2(U() - 1, -1, z7, z8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View j2(boolean z7, boolean z8) {
        if (this.C) {
            return p2(U() - 1, -1, z7, z8);
        }
        return p2(0, U(), z7, z8);
    }

    public int k2() {
        View p22 = p2(0, U(), false, true);
        if (p22 == null) {
            return -1;
        }
        return o0(p22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void l1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.F != -1) {
                savedState.b();
            }
            D1();
        }
    }

    public int l2() {
        View p22 = p2(U() - 1, -1, true, false);
        if (p22 == null) {
            return -1;
        }
        return o0(p22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable m1() {
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        if (U() > 0) {
            e2();
            boolean z7 = this.A ^ this.C;
            savedState.f7158h = z7;
            if (z7) {
                View v22 = v2();
                savedState.f7157g = this.f7133z.i() - this.f7133z.d(v22);
                savedState.f7156f = o0(v22);
            } else {
                View w22 = w2();
                savedState.f7156f = o0(w22);
                savedState.f7157g = this.f7133z.g(w22) - this.f7133z.m();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    public int n2() {
        View p22 = p2(U() - 1, -1, false, true);
        if (p22 == null) {
            return -1;
        }
        return o0(p22);
    }

    View o2(int i8, int i9) {
        char c8;
        int i10;
        int i11;
        e2();
        if (i9 > i8) {
            c8 = 1;
        } else if (i9 < i8) {
            c8 = 65535;
        } else {
            c8 = 0;
        }
        if (c8 == 0) {
            return T(i8);
        }
        if (this.f7133z.g(T(i8)) < this.f7133z.m()) {
            i10 = 16644;
            i11 = 16388;
        } else {
            i10 = 4161;
            i11 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.f7131x == 0) {
            return this.f7251j.a(i8, i9, i10, i11);
        }
        return this.f7252k.a(i8, i9, i10, i11);
    }

    View p2(int i8, int i9, boolean z7, boolean z8) {
        int i10;
        e2();
        int i11 = 320;
        if (z7) {
            i10 = 24579;
        } else {
            i10 = 320;
        }
        if (!z8) {
            i11 = 0;
        }
        if (this.f7131x == 0) {
            return this.f7251j.a(i8, i9, i10, i11);
        }
        return this.f7252k.a(i8, i9, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void r(String str) {
        if (this.I == null) {
            super.r(str);
        }
    }

    View s2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z7, boolean z8) {
        int i8;
        int i9;
        boolean z9;
        boolean z10;
        e2();
        int U = U();
        int i10 = -1;
        if (z8) {
            i8 = U() - 1;
            i9 = -1;
        } else {
            i10 = U;
            i8 = 0;
            i9 = 1;
        }
        int b8 = state.b();
        int m8 = this.f7133z.m();
        int i11 = this.f7133z.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i8 != i10) {
            View T = T(i8);
            int o02 = o0(T);
            int g8 = this.f7133z.g(T);
            int d8 = this.f7133z.d(T);
            if (o02 >= 0 && o02 < b8) {
                if (((RecyclerView.LayoutParams) T.getLayoutParams()).c()) {
                    if (view3 == null) {
                        view3 = T;
                    }
                } else {
                    if (d8 <= m8 && g8 < m8) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (g8 >= i11 && d8 > i11) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z9 && !z10) {
                        return T;
                    }
                    if (z7) {
                        if (!z10) {
                            if (view != null) {
                            }
                            view = T;
                        }
                        view2 = T;
                    } else {
                        if (!z9) {
                            if (view != null) {
                            }
                            view = T;
                        }
                        view2 = T;
                    }
                }
            }
            i8 += i9;
        }
        if (view == null) {
            if (view2 != null) {
                return view2;
            }
            return view3;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean v() {
        if (this.f7131x == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean w() {
        if (this.f7131x == 1) {
            return true;
        }
        return false;
    }

    @Deprecated
    protected int x2(RecyclerView.State state) {
        if (state.d()) {
            return this.f7133z.n();
        }
        return 0;
    }

    public int y2() {
        return this.f7131x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void z(int i8, int i9, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i10;
        if (this.f7131x != 0) {
            i8 = i9;
        }
        if (U() != 0 && i8 != 0) {
            e2();
            if (i8 > 0) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            S2(i10, Math.abs(i8), true, state);
            Y1(state, this.f7132y, layoutPrefetchRegistry);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean z0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z2() {
        if (k0() == 1) {
            return true;
        }
        return false;
    }

    public LinearLayoutManager(Context context, int i8, boolean z7) {
        this.f7131x = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = Integer.MIN_VALUE;
        this.I = null;
        this.J = new AnchorInfo();
        this.K = new LayoutChunkResult();
        this.L = 2;
        this.M = new int[2];
        M2(i8);
        N2(z7);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        this.f7131x = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = Integer.MIN_VALUE;
        this.I = null;
        this.J = new AnchorInfo();
        this.K = new LayoutChunkResult();
        this.L = 2;
        this.M = new int[2];
        RecyclerView.LayoutManager.Properties p02 = RecyclerView.LayoutManager.p0(context, attributeSet, i8, i9);
        M2(p02.f7267a);
        N2(p02.f7269c);
        O2(p02.f7270d);
    }
}
