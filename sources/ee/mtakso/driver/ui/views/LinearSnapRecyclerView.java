package ee.mtakso.driver.ui.views;

import android.animation.FloatEvaluator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinearSnapRecyclerView.kt */
@SuppressLint({"CustomViewStyleable"})
/* loaded from: classes5.dex */
public final class LinearSnapRecyclerView extends RecyclerView {
    private final SnapHelper Q0;
    private final FloatEvaluator R0;
    public Map<Integer, View> S0;

    /* compiled from: LinearSnapRecyclerView.kt */
    /* loaded from: classes5.dex */
    private static final class MarginDecoration extends RecyclerView.ItemDecoration {
        private final void l(Rect rect, View view, RecyclerView recyclerView) {
            int i8;
            int l8 = recyclerView.j0(view).l();
            if (l8 == 0) {
                int width = (recyclerView.getWidth() / 2) - (view.getWidth() / 2);
                if (recyclerView.getLayoutDirection() == 1) {
                    rect.right = width;
                    return;
                } else {
                    rect.left = width;
                    return;
                }
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                i8 = adapter.r();
            } else {
                i8 = 0;
            }
            if (l8 == i8 - 1) {
                int width2 = (recyclerView.getWidth() / 2) - (view.getWidth() / 2);
                if (recyclerView.getLayoutDirection() == 1) {
                    rect.left = width2;
                } else {
                    rect.right = width2;
                }
            }
        }

        private final void m(Rect rect, View view, RecyclerView recyclerView) {
            int i8;
            int l8 = recyclerView.j0(view).l();
            if (l8 == 0) {
                rect.top = (recyclerView.getHeight() / 2) - (view.getHeight() / 2);
                return;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                i8 = adapter.r();
            } else {
                i8 = 0;
            }
            if (l8 == i8 - 1) {
                rect.bottom = (recyclerView.getHeight() / 2) - (view.getHeight() / 2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void g(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager;
            Intrinsics.f(outRect, "outRect");
            Intrinsics.f(view, "view");
            Intrinsics.f(parent, "parent");
            Intrinsics.f(state, "state");
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager == null) {
                return;
            }
            int y22 = linearLayoutManager.y2();
            if (y22 != 0) {
                if (y22 == 1) {
                    m(outRect, view, parent);
                    return;
                }
                return;
            }
            l(outRect, view, parent);
        }
    }

    /* compiled from: LinearSnapRecyclerView.kt */
    /* loaded from: classes5.dex */
    private static final class SnapHelper extends LinearSnapHelper {
        private final View s(LinearLayoutManager linearLayoutManager) {
            int v02;
            int c8;
            int y22 = linearLayoutManager.y2();
            if (y22 != 0) {
                if (y22 != 1) {
                    v02 = 0;
                } else {
                    v02 = linearLayoutManager.h0() / 2;
                }
            } else {
                v02 = linearLayoutManager.v0() / 2;
            }
            int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            View view = null;
            int U = linearLayoutManager.U();
            for (int i9 = 0; i9 < U; i9++) {
                View T = linearLayoutManager.T(i9);
                if (T != null) {
                    int y23 = linearLayoutManager.y2();
                    if (y23 == 0) {
                        c8 = LinearSnapRecyclerViewKt.c(T);
                    } else {
                        c8 = y23 != 1 ? 0 : LinearSnapRecyclerViewKt.d(T);
                    }
                    int abs = Math.abs(v02 - c8);
                    if (abs < i8) {
                        view = T;
                        i8 = abs;
                    }
                }
            }
            return view;
        }

        @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
        public int[] c(RecyclerView.LayoutManager layoutManager, View targetView) {
            LinearLayoutManager linearLayoutManager;
            int[] iArr;
            int c8;
            int d8;
            Intrinsics.f(layoutManager, "layoutManager");
            Intrinsics.f(targetView, "targetView");
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager == null) {
                return new int[]{0, 0};
            }
            int y22 = linearLayoutManager.y2();
            if (y22 == 0) {
                c8 = LinearSnapRecyclerViewKt.c(targetView);
                iArr = new int[]{c8 - (((LinearLayoutManager) layoutManager).v0() / 2), 0};
            } else if (y22 == 1) {
                d8 = LinearSnapRecyclerViewKt.d(targetView);
                iArr = new int[]{0, d8 - (((LinearLayoutManager) layoutManager).h0() / 2)};
            } else {
                return new int[]{0, 0};
            }
            return iArr;
        }

        @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View h(RecyclerView.LayoutManager layoutManager) {
            LinearLayoutManager linearLayoutManager;
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager == null) {
                return super.h(layoutManager);
            }
            return s(linearLayoutManager);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearSnapRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearSnapRecyclerView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.S0 = new LinkedHashMap();
        SnapHelper snapHelper = new SnapHelper();
        this.Q0 = snapHelper;
        this.R0 = new FloatEvaluator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.F2, i8, 0);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…lerView, defStyleAttr, 0)");
        int i9 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        setLayoutManager(new LinearLayoutManager(context, i9, false));
        h(new MarginDecoration());
        setItemAnimator(null);
        snapHelper.b(this);
    }

    public final View G1() {
        return this.Q0.h(getLayoutManager());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        if (z7) {
            y0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void p1(int i8) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if ((layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).y2() == 0) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException("Unsupported layout " + layoutManager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void x1(int i8) {
        if (isLayoutSuppressed()) {
            return;
        }
        final Context context = getContext();
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: ee.mtakso.driver.ui.views.LinearSnapRecyclerView$smoothScrollToPosition$smoothScroller$1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int t(View view, int i9) {
                LinearLayoutManager linearLayoutManager;
                int width;
                int c8;
                RecyclerView.LayoutManager e8 = e();
                if (e8 instanceof LinearLayoutManager) {
                    linearLayoutManager = (LinearLayoutManager) e8;
                } else {
                    linearLayoutManager = null;
                }
                if (linearLayoutManager == null) {
                    return 0;
                }
                int y22 = linearLayoutManager.y2();
                if (y22 != 0) {
                    if (y22 != 1) {
                        return 0;
                    }
                    width = LinearSnapRecyclerView.this.getHeight() / 2;
                    c8 = LinearSnapRecyclerViewKt.d(view);
                } else {
                    width = LinearSnapRecyclerView.this.getWidth() / 2;
                    c8 = LinearSnapRecyclerViewKt.c(view);
                }
                return width - c8;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int x(int i9) {
                LinearLayoutManager linearLayoutManager;
                int width;
                float f8;
                FloatEvaluator floatEvaluator;
                RecyclerView.LayoutManager e8 = e();
                if (e8 instanceof LinearLayoutManager) {
                    linearLayoutManager = (LinearLayoutManager) e8;
                } else {
                    linearLayoutManager = null;
                }
                if (linearLayoutManager == null) {
                    return 0;
                }
                int y22 = linearLayoutManager.y2();
                if (y22 != 0) {
                    if (y22 != 1) {
                        f8 = 0.0f;
                        float max = Math.max(0.0f, Math.min(1.0f, 1 - (i9 / f8)));
                        floatEvaluator = LinearSnapRecyclerView.this.R0;
                        return (int) (floatEvaluator.evaluate(max, (Number) Float.valueOf(1.0f), (Number) Float.valueOf(10.0f)).floatValue() * super.x(i9));
                    }
                    width = LinearSnapRecyclerView.this.getHeight();
                } else {
                    width = LinearSnapRecyclerView.this.getWidth();
                }
                f8 = width / 2.0f;
                float max2 = Math.max(0.0f, Math.min(1.0f, 1 - (i9 / f8)));
                floatEvaluator = LinearSnapRecyclerView.this.R0;
                return (int) (floatEvaluator.evaluate(max2, (Number) Float.valueOf(1.0f), (Number) Float.valueOf(10.0f)).floatValue() * super.x(i9));
            }
        };
        linearSmoothScroller.p(i8);
        LinearLayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            layoutManager.U1(linearSmoothScroller);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public LinearLayoutManager getLayoutManager() {
        RecyclerView.LayoutManager layoutManager = super.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        return null;
    }

    public /* synthetic */ LinearSnapRecyclerView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
