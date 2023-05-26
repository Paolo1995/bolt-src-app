package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f7356a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f7357b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.OnScrollListener f7358c = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.SnapHelper.1

        /* renamed from: a  reason: collision with root package name */
        boolean f7359a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void a(RecyclerView recyclerView, int i8) {
            super.a(recyclerView, i8);
            if (i8 == 0 && this.f7359a) {
                this.f7359a = false;
                SnapHelper.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void b(RecyclerView recyclerView, int i8, int i9) {
            if (i8 != 0 || i9 != 0) {
                this.f7359a = true;
            }
        }
    };

    private void g() {
        this.f7356a.g1(this.f7358c);
        this.f7356a.setOnFlingListener(null);
    }

    private void j() throws IllegalStateException {
        if (this.f7356a.getOnFlingListener() == null) {
            this.f7356a.l(this.f7358c);
            this.f7356a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean k(@NonNull RecyclerView.LayoutManager layoutManager, int i8, int i9) {
        RecyclerView.SmoothScroller e8;
        int i10;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (e8 = e(layoutManager)) == null || (i10 = i(layoutManager, i8, i9)) == -1) {
            return false;
        }
        e8.p(i10);
        layoutManager.U1(e8);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean a(int i8, int i9) {
        RecyclerView.LayoutManager layoutManager = this.f7356a.getLayoutManager();
        if (layoutManager == null || this.f7356a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f7356a.getMinFlingVelocity();
        if ((Math.abs(i9) <= minFlingVelocity && Math.abs(i8) <= minFlingVelocity) || !k(layoutManager, i8, i9)) {
            return false;
        }
        return true;
    }

    public void b(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f7356a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.f7356a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f7357b = new Scroller(this.f7356a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    public abstract int[] c(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view);

    public int[] d(int i8, int i9) {
        this.f7357b.fling(0, 0, i8, i9, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return new int[]{this.f7357b.getFinalX(), this.f7357b.getFinalY()};
    }

    protected RecyclerView.SmoothScroller e(@NonNull RecyclerView.LayoutManager layoutManager) {
        return f(layoutManager);
    }

    @Deprecated
    protected LinearSmoothScroller f(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.f7356a.getContext()) { // from class: androidx.recyclerview.widget.SnapHelper.2
            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void o(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                SnapHelper snapHelper = SnapHelper.this;
                RecyclerView recyclerView = snapHelper.f7356a;
                if (recyclerView == null) {
                    return;
                }
                int[] c8 = snapHelper.c(recyclerView.getLayoutManager(), view);
                int i8 = c8[0];
                int i9 = c8[1];
                int w7 = w(Math.max(Math.abs(i8), Math.abs(i9)));
                if (w7 > 0) {
                    action.d(i8, i9, w7, this.f7160j);
                }
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float v(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }
        };
    }

    public abstract View h(RecyclerView.LayoutManager layoutManager);

    public abstract int i(RecyclerView.LayoutManager layoutManager, int i8, int i9);

    void l() {
        RecyclerView.LayoutManager layoutManager;
        View h8;
        RecyclerView recyclerView = this.f7356a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (h8 = h(layoutManager)) == null) {
            return;
        }
        int[] c8 = c(layoutManager, h8);
        int i8 = c8[0];
        if (i8 != 0 || c8[1] != 0) {
            this.f7356a.t1(i8, c8[1]);
        }
    }
}
