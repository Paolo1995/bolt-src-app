package eu.bolt.client.design.cardstack;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import eu.bolt.client.design.cardstack.DesignCardStackView;
import eu.bolt.client.design.snackbar.SwipeDismissBehaviour;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.h4;
import eu.bolt.verification.sdk.internal.i4;
import eu.bolt.verification.sdk.internal.j4;
import eu.bolt.verification.sdk.internal.l4;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.vq;
import eu.bolt.verification.sdk.internal.w;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class DesignCardStackView extends CoordinatorLayout {
    public static final a P = new a(null);
    private final l4 E;
    private h4 F;
    private h4 G;
    private h4 H;
    private final int I;
    private final float J;
    private final int K;
    private final float L;
    private boolean M;
    private ValueAnimator N;
    private final SwipeDismissBehaviour<View> O;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
    }

    /* loaded from: classes5.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j4 f40024b;

        c(j4 j4Var) {
            this.f40024b = j4Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.f(animation, "animation");
            DesignCardStackView.this.d0(this.f40024b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.f(animation, "animation");
            DesignCardStackView.this.d0(this.f40024b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.f(animation, "animation");
            DesignCardStackView.this.O.H(true);
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements SwipeDismissBehaviour.b {
        d() {
        }

        @Override // eu.bolt.client.design.snackbar.SwipeDismissBehaviour.b
        public void d(int i8) {
        }

        @Override // eu.bolt.client.design.snackbar.SwipeDismissBehaviour.b
        public void e(View view) {
            Intrinsics.f(view, "view");
            DesignCardStackView.this.n0();
        }

        @Override // eu.bolt.client.design.snackbar.SwipeDismissBehaviour.b
        public void f(float f8) {
            DesignCardStackView.this.setUpcomingItemAppearProgress(f8);
            DesignCardStackView.this.setHiddenItemAppearProgress(f8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignCardStackView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignCardStackView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.E = new l4(context);
        int a8 = f2.a(context, 8.0f);
        this.I = a8;
        this.J = 0.95f;
        this.K = a8;
        this.L = 0.95f;
        SwipeDismissBehaviour<View> swipeDismissBehaviour = new SwipeDismissBehaviour<>(false, true, true, false, false);
        swipeDismissBehaviour.F(new d());
        this.O = swipeDismissBehaviour;
        setClipToPadding(false);
    }

    public /* synthetic */ DesignCardStackView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void c0() {
        j4 b8;
        h4 h4Var = this.F;
        if (h4Var == null || (b8 = h4Var.b()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b8, View.ALPHA, b8.getAlpha(), 0.0f);
        ofFloat.addListener(new c(b8));
        ofFloat.setInterpolator(w.f45479a.a());
        ofFloat.setDuration(300L);
        ofFloat.start();
        this.N = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(View view) {
        this.O.H(this.M);
        removeView(view);
        p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(DesignCardStackView this$0, h4 this_run, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(this_run, "$this_run");
        ValueAnimator valueAnimator = this$0.N;
        boolean z7 = true;
        if (((valueAnimator == null || !valueAnimator.isRunning()) ? false : false) || this$0.O.Z()) {
            return;
        }
        if (this_run.a().g() == null) {
            Timber.f53064a.m("No card payload", new Object[0]);
        }
        if (this_run.a().e()) {
            this$0.setUpcomingItemAppearProgress(1.0f);
            this$0.setHiddenItemAppearProgress(1.0f);
            this$0.c0();
        }
    }

    private final void i0(h4 h4Var, h4 h4Var2, h4 h4Var3) {
        if (h4Var == null && h4Var2 != null && h4Var3 == null) {
            removeView(h4Var2.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(j4 view, float f8, int i8) {
        Intrinsics.f(view, "$view");
        view.setScaleX(f8);
        view.setScaleY(f8);
        view.setTranslationY(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(j4 j4Var, DesignCardStackView this$0, float f8) {
        Intrinsics.f(this$0, "this$0");
        j4Var.setScaleX(this$0.L);
        j4Var.setScaleY(this$0.L);
        j4Var.setTranslationY(this$0.K);
        j4Var.setAlpha(f8);
    }

    private final void l0(Object obj) {
        if (obj != null) {
            return;
        }
        Timber.f53064a.m("No banner payload", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        h4 h4Var = this.F;
        if (h4Var != null) {
            ValueAnimator valueAnimator = this.N;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            d0(h4Var.b());
        }
    }

    private final void p0() {
        i4 a8;
        h4 h4Var = this.F;
        l0((h4Var == null || (a8 = h4Var.a()) == null) ? null : a8.g());
        this.E.g();
        setTopItemView(this.G);
        setUpcomingItemView(this.H);
        setHiddenItemView(l4.a(this.E, vq.HIDDEN, null, 2, null));
        if (this.F != null && this.G == null && this.E.f()) {
            this.O.H(true);
        }
    }

    private final void q0() {
        SwipeDismissBehaviour<View> swipeDismissBehaviour;
        boolean z7;
        if (this.E.e()) {
            removeAllViews();
            return;
        }
        setTopItemView(this.E.b(vq.TOP, this.F));
        setUpcomingItemView(this.E.b(vq.UPCOMING, this.G));
        setHiddenItemView(this.E.b(vq.HIDDEN, this.H));
        if (this.E.f()) {
            swipeDismissBehaviour = this.O;
            z7 = true;
        } else {
            swipeDismissBehaviour = this.O;
            z7 = this.M;
        }
        swipeDismissBehaviour.H(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHiddenItemAppearProgress(final float f8) {
        h4 h4Var = this.H;
        final j4 b8 = h4Var != null ? h4Var.b() : null;
        if (b8 != null) {
            b8.post(new Runnable() { // from class: q6.b
                @Override // java.lang.Runnable
                public final void run() {
                    DesignCardStackView.k0(j4.this, this, f8);
                }
            });
        }
    }

    private final void setHiddenItemView(h4 h4Var) {
        Unit unit;
        h4 h4Var2 = this.H;
        this.H = h4Var;
        if (h4Var != null) {
            j4 b8 = h4Var.b();
            Context context = getContext();
            Intrinsics.e(context, "context");
            b8.setElevation(f2.i(context, 4.0f));
            if (h4Var.b().getParent() == null) {
                addView(h4Var.b(), 0);
            }
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            i0(this.H, h4Var2, this.G);
        }
        setHiddenItemAppearProgress(0.0f);
    }

    private final void setTopItemView(final h4 h4Var) {
        Unit unit;
        i4 a8;
        h4 h4Var2 = this.F;
        this.F = h4Var;
        if (h4Var != null) {
            h4Var.b().setUiModel(h4Var.a());
            j4 b8 = h4Var.b();
            Context context = getContext();
            Intrinsics.e(context, "context");
            b8.setElevation(f2.i(context, 6.0f));
            h4Var.b().setAlpha(1.0f);
            if (h4Var.b().getParent() == null) {
                addView(h4Var.b());
            }
            uq.y(h4Var.b(), this.O);
            h4Var.b().setOnClickListener(new View.OnClickListener() { // from class: q6.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DesignCardStackView.h0(DesignCardStackView.this, h4Var, view);
                }
            });
            if (!Intrinsics.a((h4Var2 == null || (a8 = h4Var2.a()) == null) ? null : a8.g(), h4Var.a().g())) {
                h4Var.a().g();
            }
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            i0(this.F, h4Var2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpcomingItemAppearProgress(float f8) {
        float f9;
        final j4 b8;
        float f10 = this.J;
        final float f11 = ((1 - f10) * f8) + f10;
        final int rint = (int) Math.rint((f9 - f8) * this.I);
        h4 h4Var = this.G;
        if (h4Var == null || (b8 = h4Var.b()) == null) {
            return;
        }
        b8.post(new Runnable() { // from class: q6.c
            @Override // java.lang.Runnable
            public final void run() {
                DesignCardStackView.j0(j4.this, f11, rint);
            }
        });
    }

    private final void setUpcomingItemView(h4 h4Var) {
        Unit unit;
        h4 h4Var2 = this.G;
        this.G = h4Var;
        if (h4Var != null) {
            h4Var.b().setUiModel(h4Var.a());
            j4 b8 = h4Var.b();
            Context context = getContext();
            Intrinsics.e(context, "context");
            b8.setElevation(f2.i(context, 4.0f));
            h4Var.b().setAlpha(1.0f);
            if (h4Var.b().getParent() == null) {
                addView(h4Var.b(), 0);
            }
            setUpcomingItemAppearProgress(0.0f);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            i0(this.G, h4Var2, this.F);
        }
    }

    public final b getListener() {
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void setDismissEnabled(boolean z7) {
        boolean z8 = !z7;
        this.M = z8;
        this.O.H(z8);
    }

    public final void setItems(List<i4> items) {
        Intrinsics.f(items, "items");
        this.E.d(items);
        q0();
    }

    public final void setListener(b bVar) {
    }
}
