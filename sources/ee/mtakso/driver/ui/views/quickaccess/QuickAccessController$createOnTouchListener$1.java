package ee.mtakso.driver.ui.views.quickaccess;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.GestureDetectorCompat;
import ee.mtakso.driver.utils.animations.AnimationUtils;
import eu.bolt.kalev.Kalev;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: QuickAccessController.kt */
/* loaded from: classes5.dex */
public final class QuickAccessController$createOnTouchListener$1 implements View.OnTouchListener {

    /* renamed from: f  reason: collision with root package name */
    private float f34422f;

    /* renamed from: g  reason: collision with root package name */
    private float f34423g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f34424h = true;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ QuickAccessController f34425i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ WindowManager.LayoutParams f34426j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuickAccessController$createOnTouchListener$1(QuickAccessController quickAccessController, WindowManager.LayoutParams layoutParams) {
        this.f34425i = quickAccessController;
        this.f34426j = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WindowManager.LayoutParams params, QuickAccessController this$0, ValueAnimator valueAnimator) {
        Intrinsics.f(params, "$params");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        params.y = intValue;
        this$0.E(params.x, intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WindowManager.LayoutParams params, QuickAccessController this$0, ValueAnimator valueAnimator) {
        Intrinsics.f(params, "$params");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        params.y = intValue;
        this$0.E(params.x, intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WindowManager.LayoutParams params, QuickAccessController this$0, ValueAnimator valueAnimator) {
        Intrinsics.f(params, "$params");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        params.x = intValue;
        this$0.E(intValue, params.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(WindowManager.LayoutParams params, QuickAccessController this$0, ValueAnimator valueAnimator) {
        Intrinsics.f(params, "$params");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        params.x = intValue;
        this$0.E(intValue, params.y);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent event) {
        GestureDetectorCompat gestureDetectorCompat;
        WindowManager windowManager;
        Intrinsics.f(view, "view");
        Intrinsics.f(event, "event");
        Kalev.b("headIcon -> onTouch(" + event + ")");
        gestureDetectorCompat = this.f34425i.f34408n;
        gestureDetectorCompat.a(event);
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f34425i.o(this.f34426j);
                Point point = new Point();
                windowManager = this.f34425i.f34401g;
                windowManager.getDefaultDisplay().getSize(point);
                int i8 = this.f34426j.y;
                int height = (point.y - i8) - view.getHeight();
                int i9 = this.f34426j.x;
                int width = (point.x - i9) - view.getWidth();
                StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
                String format = String.format("headIcon -> onTouch Up(params { x: %s, y: %s }, screenSize { x: %s, y: %s }, distance { left: %s, right: %s, top: %s, bottom: %s})", Arrays.copyOf(new Object[]{Integer.valueOf(this.f34426j.x), Integer.valueOf(this.f34426j.y), Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf(i9), Integer.valueOf(width), Integer.valueOf(i8), Integer.valueOf(height)}, 8));
                Intrinsics.e(format, "format(format, *args)");
                Kalev.b(format);
                if (Math.min(height, i8) < Math.min(i9, width)) {
                    if (i8 < height) {
                        final WindowManager.LayoutParams layoutParams = this.f34426j;
                        int i10 = layoutParams.y;
                        final QuickAccessController quickAccessController = this.f34425i;
                        AnimationUtils.a(250L, i10, 0, new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.e
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                QuickAccessController$createOnTouchListener$1.e(layoutParams, quickAccessController, valueAnimator);
                            }
                        });
                        return true;
                    }
                    int i11 = this.f34426j.y;
                    int height2 = point.y - view.getHeight();
                    final WindowManager.LayoutParams layoutParams2 = this.f34426j;
                    final QuickAccessController quickAccessController2 = this.f34425i;
                    AnimationUtils.a(250L, i11, height2, new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.f
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            QuickAccessController$createOnTouchListener$1.f(layoutParams2, quickAccessController2, valueAnimator);
                        }
                    });
                    return true;
                } else if (i9 < width) {
                    final WindowManager.LayoutParams layoutParams3 = this.f34426j;
                    int i12 = layoutParams3.x;
                    final QuickAccessController quickAccessController3 = this.f34425i;
                    AnimationUtils.a(250L, i12, 0, new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.g
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            QuickAccessController$createOnTouchListener$1.g(layoutParams3, quickAccessController3, valueAnimator);
                        }
                    });
                    return true;
                } else {
                    int i13 = this.f34426j.x;
                    int width2 = point.x - view.getWidth();
                    final WindowManager.LayoutParams layoutParams4 = this.f34426j;
                    final QuickAccessController quickAccessController4 = this.f34425i;
                    AnimationUtils.a(250L, i13, width2, new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.h
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            QuickAccessController$createOnTouchListener$1.h(layoutParams4, quickAccessController4, valueAnimator);
                        }
                    });
                    return true;
                }
            }
            if (action == 2) {
                int abs = Math.abs((int) (this.f34422f - event.getRawX()));
                int abs2 = Math.abs((int) (this.f34423g - event.getRawY()));
                if (!this.f34424h) {
                    this.f34426j.x = ((int) event.getRawX()) - (view.getWidth() / 2);
                    this.f34426j.y = ((int) event.getRawY()) - (view.getHeight() / 2);
                    QuickAccessController quickAccessController5 = this.f34425i;
                    WindowManager.LayoutParams layoutParams5 = this.f34426j;
                    quickAccessController5.E(layoutParams5.x, layoutParams5.y);
                    return true;
                } else if (abs > 100 || abs2 > 100) {
                    this.f34424h = false;
                }
            }
            return false;
        }
        this.f34422f = event.getRawX();
        this.f34423g = event.getRawY();
        this.f34424h = true;
        return true;
    }
}
