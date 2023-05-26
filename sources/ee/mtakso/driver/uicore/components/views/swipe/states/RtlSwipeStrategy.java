package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwipeStrategy.kt */
/* loaded from: classes5.dex */
public final class RtlSwipeStrategy implements SwipeStrategy {

    /* renamed from: b  reason: collision with root package name */
    private final Rect f35702b;

    public RtlSwipeStrategy(Rect parentBounds) {
        Intrinsics.f(parentBounds, "parentBounds");
        this.f35702b = parentBounds;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public void a(AppCompatImageView iconView) {
        Intrinsics.f(iconView, "iconView");
        iconView.setScaleY(1.0f);
        iconView.setScaleX(1.0f);
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public int b(float f8, View sliderView) {
        Intrinsics.f(sliderView, "sliderView");
        if (f(f8, sliderView)) {
            return this.f35702b.right;
        }
        return this.f35702b.left;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public boolean c(View sliderView) {
        Intrinsics.f(sliderView, "sliderView");
        if (sliderView.getLeft() >= this.f35702b.right) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public int d(int i8, View sliderView) {
        Intrinsics.f(sliderView, "sliderView");
        if (i8 < 0) {
            return 0;
        }
        return i8;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public float e(View sliderView) {
        Intrinsics.f(sliderView, "sliderView");
        return sliderView.getLeft() / this.f35702b.width();
    }

    public boolean f(float f8, View sliderView) {
        float b8;
        Intrinsics.f(sliderView, "sliderView");
        if (f8 < 500.0f) {
            float e8 = e(sliderView);
            b8 = SwipeStrategyKt.b(this.f35702b, sliderView);
            if (e8 <= b8) {
                return false;
            }
        }
        return true;
    }
}
