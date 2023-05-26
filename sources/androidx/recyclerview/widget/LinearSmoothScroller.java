package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {

    /* renamed from: k  reason: collision with root package name */
    protected PointF f7161k;

    /* renamed from: l  reason: collision with root package name */
    private final DisplayMetrics f7162l;

    /* renamed from: n  reason: collision with root package name */
    private float f7164n;

    /* renamed from: i  reason: collision with root package name */
    protected final LinearInterpolator f7159i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    protected final DecelerateInterpolator f7160j = new DecelerateInterpolator();

    /* renamed from: m  reason: collision with root package name */
    private boolean f7163m = false;

    /* renamed from: o  reason: collision with root package name */
    protected int f7165o = 0;

    /* renamed from: p  reason: collision with root package name */
    protected int f7166p = 0;

    public LinearSmoothScroller(Context context) {
        this.f7162l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f7163m) {
            this.f7164n = v(this.f7162l);
            this.f7163m = true;
        }
        return this.f7164n;
    }

    private int y(int i8, int i9) {
        int i10 = i8 - i9;
        if (i8 * i10 <= 0) {
            return 0;
        }
        return i10;
    }

    protected int B() {
        PointF pointF = this.f7161k;
        if (pointF != null) {
            float f8 = pointF.y;
            if (f8 != 0.0f) {
                if (f8 > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.SmoothScroller.Action action) {
        PointF a8 = a(f());
        if (a8 != null && (a8.x != 0.0f || a8.y != 0.0f)) {
            i(a8);
            this.f7161k = a8;
            this.f7165o = (int) (a8.x * 10000.0f);
            this.f7166p = (int) (a8.y * 10000.0f);
            action.d((int) (this.f7165o * 1.2f), (int) (this.f7166p * 1.2f), (int) (x(10000) * 1.2f), this.f7159i);
            return;
        }
        action.b(f());
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void l(int i8, int i9, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (c() == 0) {
            r();
            return;
        }
        this.f7165o = y(this.f7165o, i8);
        int y7 = y(this.f7166p, i9);
        this.f7166p = y7;
        if (this.f7165o == 0 && y7 == 0) {
            C(action);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void n() {
        this.f7166p = 0;
        this.f7165o = 0;
        this.f7161k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void o(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int t7 = t(view, z());
        int u7 = u(view, B());
        int w7 = w((int) Math.sqrt((t7 * t7) + (u7 * u7)));
        if (w7 > 0) {
            action.d(-t7, -u7, w7, this.f7160j);
        }
    }

    public int s(int i8, int i9, int i10, int i11, int i12) {
        if (i12 != -1) {
            if (i12 != 0) {
                if (i12 == 1) {
                    return i11 - i9;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i13 = i10 - i8;
            if (i13 > 0) {
                return i13;
            }
            int i14 = i11 - i9;
            if (i14 < 0) {
                return i14;
            }
            return 0;
        }
        return i10 - i8;
    }

    public int t(View view, int i8) {
        RecyclerView.LayoutManager e8 = e();
        if (e8 != null && e8.v()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return s(e8.b0(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, e8.e0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, e8.getPaddingLeft(), e8.v0() - e8.getPaddingRight(), i8);
        }
        return 0;
    }

    public int u(View view, int i8) {
        RecyclerView.LayoutManager e8 = e();
        if (e8 != null && e8.w()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return s(e8.f0(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, e8.Z(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, e8.getPaddingTop(), e8.h0() - e8.getPaddingBottom(), i8);
        }
        return 0;
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w(int i8) {
        return (int) Math.ceil(x(i8) / 0.3356d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int x(int i8) {
        return (int) Math.ceil(Math.abs(i8) * A());
    }

    protected int z() {
        PointF pointF = this.f7161k;
        if (pointF != null) {
            float f8 = pointF.x;
            if (f8 != 0.0f) {
                if (f8 > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }
}
