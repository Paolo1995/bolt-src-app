package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: d  reason: collision with root package name */
    private OrientationHelper f7173d;

    /* renamed from: e  reason: collision with root package name */
    private OrientationHelper f7174e;

    private int m(@NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.g(view) + (orientationHelper.e(view) / 2)) - (orientationHelper.m() + (orientationHelper.n() / 2));
    }

    private View n(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int U = layoutManager.U();
        View view = null;
        if (U == 0) {
            return null;
        }
        int m8 = orientationHelper.m() + (orientationHelper.n() / 2);
        int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i9 = 0; i9 < U; i9++) {
            View T = layoutManager.T(i9);
            int abs = Math.abs((orientationHelper.g(T) + (orientationHelper.e(T) / 2)) - m8);
            if (abs < i8) {
                view = T;
                i8 = abs;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper o(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7174e;
        if (orientationHelper == null || orientationHelper.f7170a != layoutManager) {
            this.f7174e = OrientationHelper.a(layoutManager);
        }
        return this.f7174e;
    }

    private OrientationHelper p(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.w()) {
            return q(layoutManager);
        }
        if (layoutManager.v()) {
            return o(layoutManager);
        }
        return null;
    }

    @NonNull
    private OrientationHelper q(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7173d;
        if (orientationHelper == null || orientationHelper.f7170a != layoutManager) {
            this.f7173d = OrientationHelper.c(layoutManager);
        }
        return this.f7173d;
    }

    private boolean r(RecyclerView.LayoutManager layoutManager, int i8, int i9) {
        if (layoutManager.v()) {
            if (i8 > 0) {
                return true;
            }
            return false;
        } else if (i9 > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean s(RecyclerView.LayoutManager layoutManager) {
        PointF a8;
        int j02 = layoutManager.j0();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (a8 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).a(j02 - 1)) == null) {
            return false;
        }
        if (a8.x >= 0.0f && a8.y >= 0.0f) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] c(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.v()) {
            iArr[0] = m(view, o(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.w()) {
            iArr[1] = m(view, q(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected RecyclerView.SmoothScroller e(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.f7356a.getContext()) { // from class: androidx.recyclerview.widget.PagerSnapHelper.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void o(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] c8 = pagerSnapHelper.c(pagerSnapHelper.f7356a.getLayoutManager(), view);
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

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int x(int i8) {
                return Math.min(100, super.x(i8));
            }
        };
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View h(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.w()) {
            return n(layoutManager, q(layoutManager));
        }
        if (layoutManager.v()) {
            return n(layoutManager, o(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int i(RecyclerView.LayoutManager layoutManager, int i8, int i9) {
        OrientationHelper p8;
        int i10;
        int j02 = layoutManager.j0();
        if (j02 == 0 || (p8 = p(layoutManager)) == null) {
            return -1;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int U = layoutManager.U();
        View view = null;
        View view2 = null;
        for (int i13 = 0; i13 < U; i13++) {
            View T = layoutManager.T(i13);
            if (T != null) {
                int m8 = m(T, p8);
                if (m8 <= 0 && m8 > i11) {
                    view2 = T;
                    i11 = m8;
                }
                if (m8 >= 0 && m8 < i12) {
                    view = T;
                    i12 = m8;
                }
            }
        }
        boolean r7 = r(layoutManager, i8, i9);
        if (r7 && view != null) {
            return layoutManager.o0(view);
        }
        if (!r7 && view2 != null) {
            return layoutManager.o0(view2);
        }
        if (r7) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int o02 = layoutManager.o0(view);
        if (s(layoutManager) == r7) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        int i14 = o02 + i10;
        if (i14 < 0 || i14 >= j02) {
            return -1;
        }
        return i14;
    }
}
