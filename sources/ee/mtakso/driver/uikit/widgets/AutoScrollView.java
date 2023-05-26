package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AutoScrollView.kt */
/* loaded from: classes5.dex */
public final class AutoScrollView extends NestedScrollView {
    private static final Companion N = new Companion(null);
    private int J;
    private boolean K;
    private final Runnable L;
    public Map<Integer, View> M;

    /* compiled from: AutoScrollView.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoScrollView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.M = new LinkedHashMap();
        this.J = 1;
        this.L = new Runnable() { // from class: ee.mtakso.driver.uikit.widgets.a
            @Override // java.lang.Runnable
            public final void run() {
                AutoScrollView.c0(AutoScrollView.this);
            }
        };
    }

    private final void Z() {
        if (!isAttachedToWindow()) {
            return;
        }
        boolean z7 = true;
        if (getChildCount() < 1) {
            return;
        }
        int b02 = b0();
        this.K = (this.J == 0 || b02 == 0) ? false : false;
        double height = b02 / getHeight();
        int i8 = this.J;
        if (i8 > 0 && b02 > 0) {
            S(0, b0(), a0(height));
        } else if (i8 < 0 && getScrollY() > 0) {
            S(0, 0, a0(height));
        }
    }

    private final int a0(double d8) {
        int d9;
        d9 = RangesKt___RangesKt.d((int) (d8 * 15000), 1400);
        return d9;
    }

    private final int b0() {
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt.getBottom() > getHeight()) {
            return childAt.getBottom() - getHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AutoScrollView this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.Z();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        int i8;
        int i9;
        super.computeScroll();
        if (getScrollY() >= b0() && (i9 = this.J) > 0) {
            this.J = i9 * (-1);
            getHandler().removeCallbacks(this.L);
            getHandler().postDelayed(this.L, 0L);
        } else if (getScrollY() <= 0 && (i8 = this.J) < 0) {
            this.J = i8 * (-1);
            getHandler().removeCallbacks(this.L);
            getHandler().postDelayed(this.L, 0L);
        } else if (b0() == 0) {
            this.K = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ViewCompat.W(this) && !this.K) {
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        if (!this.K) {
            Z();
        }
    }

    public /* synthetic */ AutoScrollView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
