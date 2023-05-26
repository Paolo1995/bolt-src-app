package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwipeStrategy.kt */
/* loaded from: classes5.dex */
public final class LtrSwipeStrategy implements SwipeStrategy {

    /* renamed from: b  reason: collision with root package name */
    private final Rect f35701b;

    public LtrSwipeStrategy(Rect parentBounds) {
        Intrinsics.f(parentBounds, "parentBounds");
        this.f35701b = parentBounds;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public void a(AppCompatImageView iconView) {
        Intrinsics.f(iconView, "iconView");
        iconView.setScaleY(-1.0f);
        iconView.setScaleX(-1.0f);
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public int b(float f8, View sliderView) {
        int i8;
        Intrinsics.f(sliderView, "sliderView");
        if (f(f8, sliderView)) {
            i8 = this.f35701b.left;
        } else {
            i8 = this.f35701b.right;
        }
        return i8 - sliderView.getWidth();
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public boolean c(View sliderView) {
        Intrinsics.f(sliderView, "sliderView");
        if (sliderView.getRight() <= this.f35701b.left) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public int d(int i8, View sliderView) {
        Intrinsics.f(sliderView, "sliderView");
        int right = sliderView.getRight();
        int i9 = this.f35701b.right;
        if (right > i9) {
            return i9 - sliderView.getWidth();
        }
        return i8;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.SwipeStrategy
    public float e(View sliderView) {
        Intrinsics.f(sliderView, "sliderView");
        return (this.f35701b.width() - sliderView.getRight()) / this.f35701b.width();
    }

    public boolean f(float f8, View sliderView) {
        float b8;
        Intrinsics.f(sliderView, "sliderView");
        if (f8 > -500.0f) {
            float e8 = e(sliderView);
            b8 = SwipeStrategyKt.b(this.f35701b, sliderView);
            if (e8 <= b8) {
                return false;
            }
        }
        return true;
    }
}
