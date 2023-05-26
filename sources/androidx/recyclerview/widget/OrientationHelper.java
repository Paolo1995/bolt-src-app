package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class OrientationHelper {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.LayoutManager f7170a;

    /* renamed from: b  reason: collision with root package name */
    private int f7171b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f7172c;

    public static OrientationHelper a(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.1
            @Override // androidx.recyclerview.widget.OrientationHelper
            public int d(View view) {
                return this.f7170a.e0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f7170a.d0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f7170a.c0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int g(View view) {
                return this.f7170a.b0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int h() {
                return this.f7170a.v0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int i() {
                return this.f7170a.v0() - this.f7170a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int j() {
                return this.f7170a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int k() {
                return this.f7170a.w0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int l() {
                return this.f7170a.i0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int m() {
                return this.f7170a.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int n() {
                return (this.f7170a.v0() - this.f7170a.getPaddingLeft()) - this.f7170a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int p(View view) {
                this.f7170a.u0(view, true, this.f7172c);
                return this.f7172c.right;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int q(View view) {
                this.f7170a.u0(view, true, this.f7172c);
                return this.f7172c.left;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void r(int i8) {
                this.f7170a.L0(i8);
            }
        };
    }

    public static OrientationHelper b(RecyclerView.LayoutManager layoutManager, int i8) {
        if (i8 != 0) {
            if (i8 == 1) {
                return c(layoutManager);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(layoutManager);
    }

    public static OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.2
            @Override // androidx.recyclerview.widget.OrientationHelper
            public int d(View view) {
                return this.f7170a.Z(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f7170a.c0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f7170a.d0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int g(View view) {
                return this.f7170a.f0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int h() {
                return this.f7170a.h0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int i() {
                return this.f7170a.h0() - this.f7170a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int j() {
                return this.f7170a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int k() {
                return this.f7170a.i0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int l() {
                return this.f7170a.w0();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int m() {
                return this.f7170a.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int n() {
                return (this.f7170a.h0() - this.f7170a.getPaddingTop()) - this.f7170a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int p(View view) {
                this.f7170a.u0(view, true, this.f7172c);
                return this.f7172c.bottom;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int q(View view) {
                this.f7170a.u0(view, true, this.f7172c);
                return this.f7172c.top;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void r(int i8) {
                this.f7170a.M0(i8);
            }
        };
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f7171b) {
            return 0;
        }
        return n() - this.f7171b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i8);

    public void s() {
        this.f7171b = n();
    }

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f7171b = Integer.MIN_VALUE;
        this.f7172c = new Rect();
        this.f7170a = layoutManager;
    }
}
