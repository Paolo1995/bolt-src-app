package ee.mtakso.driver.ui.views.quickaccess;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import ee.mtakso.driver.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessMainViewDelegate.kt */
/* loaded from: classes5.dex */
public final class QuickAccessMainViewDelegate {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f34471h = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f34472a;

    /* renamed from: b  reason: collision with root package name */
    private final WindowManager f34473b;

    /* renamed from: c  reason: collision with root package name */
    private QuickAccessMode f34474c;

    /* renamed from: d  reason: collision with root package name */
    private View f34475d;

    /* renamed from: e  reason: collision with root package name */
    private WindowManager.LayoutParams f34476e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34477f;

    /* renamed from: g  reason: collision with root package name */
    private ValueAnimator f34478g;

    /* compiled from: QuickAccessMainViewDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public QuickAccessMainViewDelegate(Context context, WindowManager windowManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(windowManager, "windowManager");
        this.f34472a = context;
        this.f34473b = windowManager;
        this.f34474c = QuickAccessMode.COLLAPSED;
    }

    private final WindowManager.LayoutParams d(int i8, int i9) {
        int i10;
        if (Build.VERSION.SDK_INT >= 26) {
            i10 = 2038;
        } else {
            i10 = 2002;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, i10, 8, -3);
        layoutParams.gravity = 8388659;
        layoutParams.x = i8;
        layoutParams.y = i9;
        return layoutParams;
    }

    private final ValueAnimator e(View view) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 1.1f, 1.3f), PropertyValuesHolder.ofFloat("scaleY", 1.1f, 1.3f), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.5f));
        Intrinsics.e(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n…a\", 1.0f, 0.5f)\n        )");
        ofPropertyValuesHolder.setDuration(1500L);
        ofPropertyValuesHolder.setStartDelay(500L);
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setRepeatMode(2);
        return ofPropertyValuesHolder;
    }

    private final void j() {
        View view;
        ValueAnimator e8;
        ValueAnimator valueAnimator = this.f34478g;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            return;
        }
        View view2 = this.f34475d;
        if (view2 != null) {
            view = view2.findViewById(R.id.taxifyHeadPulse);
        } else {
            view = null;
        }
        if (view != null && (e8 = e(view)) != null) {
            e8.start();
            this.f34478g = e8;
        }
    }

    private final void k() {
        ValueAnimator valueAnimator = this.f34478g;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            valueAnimator.cancel();
            View view = null;
            this.f34478g = null;
            View view2 = this.f34475d;
            if (view2 != null) {
                view = view2.findViewById(R.id.taxifyHeadPulse);
            }
            if (view != null) {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setAlpha(1.0f);
            }
        }
    }

    public final void a(View.OnAttachStateChangeListener listener) {
        Intrinsics.f(listener, "listener");
        View view = this.f34475d;
        if (view != null) {
            view.removeOnAttachStateChangeListener(listener);
        }
        View view2 = this.f34475d;
        if (view2 != null) {
            view2.addOnAttachStateChangeListener(listener);
        }
    }

    public final void b(View.OnTouchListener listener) {
        Intrinsics.f(listener, "listener");
        View view = this.f34475d;
        if (view != null) {
            view.setOnTouchListener(listener);
        }
    }

    @SuppressLint({"InflateParams"})
    public final View c(int i8, int i9) {
        View view = this.f34475d;
        if (view == null) {
            view = View.inflate(this.f34472a, R.layout.bolt_head, null);
        }
        WindowManager.LayoutParams layoutParams = this.f34476e;
        if (layoutParams == null) {
            layoutParams = d(i8, i9);
        }
        this.f34473b.addView(view, layoutParams);
        this.f34477f = true;
        this.f34475d = view;
        this.f34476e = layoutParams;
        j();
        Intrinsics.e(view, "view");
        return view;
    }

    public final void f() {
        boolean z7;
        k();
        View view = this.f34475d;
        if (view != null) {
            if (view.getWindowToken() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                view = null;
            }
            if (view != null) {
                this.f34473b.removeView(view);
            }
        }
        this.f34477f = false;
    }

    public final WindowManager.LayoutParams g() {
        return this.f34476e;
    }

    public final View h() {
        return this.f34475d;
    }

    public final void i(QuickAccessMode quickAccessMode) {
        Intrinsics.f(quickAccessMode, "<set-?>");
        this.f34474c = quickAccessMode;
    }

    public final void l(int i8, int i9) {
        WindowManager.LayoutParams layoutParams;
        if (!this.f34477f || (layoutParams = this.f34476e) == null) {
            return;
        }
        layoutParams.x = i8;
        layoutParams.y = i9;
        View view = this.f34475d;
        if (view != null) {
            this.f34473b.updateViewLayout(view, layoutParams);
        }
    }
}
