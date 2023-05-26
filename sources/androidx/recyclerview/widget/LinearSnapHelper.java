package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class LinearSnapHelper extends SnapHelper {

    /* renamed from: d  reason: collision with root package name */
    private OrientationHelper f7167d;

    /* renamed from: e  reason: collision with root package name */
    private OrientationHelper f7168e;

    private float m(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int U = layoutManager.U();
        if (U == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i9 = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < U; i10++) {
            View T = layoutManager.T(i10);
            int o02 = layoutManager.o0(T);
            if (o02 != -1) {
                if (o02 < i8) {
                    view = T;
                    i8 = o02;
                }
                if (o02 > i9) {
                    view2 = T;
                    i9 = o02;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(orientationHelper.d(view), orientationHelper.d(view2)) - Math.min(orientationHelper.g(view), orientationHelper.g(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i9 - i8) + 1);
    }

    private int n(@NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.g(view) + (orientationHelper.e(view) / 2)) - (orientationHelper.m() + (orientationHelper.n() / 2));
    }

    private int o(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i8, int i9) {
        int i10;
        int[] d8 = d(i8, i9);
        float m8 = m(layoutManager, orientationHelper);
        if (m8 <= 0.0f) {
            return 0;
        }
        if (Math.abs(d8[0]) > Math.abs(d8[1])) {
            i10 = d8[0];
        } else {
            i10 = d8[1];
        }
        return Math.round(i10 / m8);
    }

    private View p(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
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
    private OrientationHelper q(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7168e;
        if (orientationHelper == null || orientationHelper.f7170a != layoutManager) {
            this.f7168e = OrientationHelper.a(layoutManager);
        }
        return this.f7168e;
    }

    @NonNull
    private OrientationHelper r(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7167d;
        if (orientationHelper == null || orientationHelper.f7170a != layoutManager) {
            this.f7167d = OrientationHelper.c(layoutManager);
        }
        return this.f7167d;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] c(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.v()) {
            iArr[0] = n(view, q(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.w()) {
            iArr[1] = n(view, r(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View h(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.w()) {
            return p(layoutManager, r(layoutManager));
        }
        if (layoutManager.v()) {
            return p(layoutManager, q(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int i(RecyclerView.LayoutManager layoutManager, int i8, int i9) {
        int j02;
        View h8;
        int o02;
        int i10;
        PointF a8;
        int i11;
        int i12;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (j02 = layoutManager.j0()) == 0 || (h8 = h(layoutManager)) == null || (o02 = layoutManager.o0(h8)) == -1 || (a8 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).a(j02 - 1)) == null) {
            return -1;
        }
        int i13 = 0;
        if (layoutManager.v()) {
            i11 = o(layoutManager, q(layoutManager), i8, 0);
            if (a8.x < 0.0f) {
                i11 = -i11;
            }
        } else {
            i11 = 0;
        }
        if (layoutManager.w()) {
            i12 = o(layoutManager, r(layoutManager), 0, i9);
            if (a8.y < 0.0f) {
                i12 = -i12;
            }
        } else {
            i12 = 0;
        }
        if (layoutManager.w()) {
            i11 = i12;
        }
        if (i11 == 0) {
            return -1;
        }
        int i14 = o02 + i11;
        if (i14 >= 0) {
            i13 = i14;
        }
        if (i13 < j02) {
            return i13;
        }
        return i10;
    }
}
