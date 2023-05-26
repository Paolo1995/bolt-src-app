package eu.bolt.client.design.listitem;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.selection.PaymentProfileSwitch;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.f5;
import eu.bolt.verification.sdk.internal.ie;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: classes5.dex */
public final class DesignSelectedPaymentView extends ConstraintLayout {
    private static final a F = new a(null);
    private final f5 E;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignSelectedPaymentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignSelectedPaymentView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        f5 a8 = f5.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.E = a8;
        if (getMinHeight() == 0) {
            setMinHeight(f2.a(context, 56.0f));
        }
        a8.f42963h.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.client.design.listitem.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DesignSelectedPaymentView.H(DesignSelectedPaymentView.this, view);
            }
        });
    }

    public /* synthetic */ DesignSelectedPaymentView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final float E(boolean z7) {
        return z7 ? 1.0f : 0.4f;
    }

    private final void F() {
        TransitionManager.c(this);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.v0(0);
        transitionSet.n0(new ChangeBounds().c(this.E.f42958c).c(this.E.f42962g));
        transitionSet.n0(new Fade().c(this.E.f42958c));
        transitionSet.c0(200L);
        TransitionManager.b(this, transitionSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(DesignSelectedPaymentView this$0, ValueAnimator it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.E.f42958c.setTranslationX(floatValue);
        this$0.E.f42962g.setTranslationX(floatValue);
        this$0.E.f42957b.setTranslationX(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(DesignSelectedPaymentView this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.E.f42963h.B();
    }

    private final int I(boolean z7) {
        int b8;
        b8 = MathKt__MathJVMKt.b(255 * E(z7));
        return b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DesignSelectedPaymentView this$0, ValueAnimator it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.E.f42963h.setAlpha(floatValue);
        this$0.E.f42958c.setAlpha(floatValue);
        this$0.E.f42962g.setAlpha(floatValue);
        this$0.E.f42957b.setAlpha(floatValue);
    }

    public final Animator getPaymentIntroAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.E.getRoot().getWidth() * 0.25f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: eu.bolt.client.design.listitem.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DesignSelectedPaymentView.G(DesignSelectedPaymentView.this, valueAnimator);
            }
        });
        Unit unit = Unit.f50853a;
        animatorSet.playTogether(ofFloat);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: eu.bolt.client.design.listitem.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DesignSelectedPaymentView.J(DesignSelectedPaymentView.this, valueAnimator);
            }
        });
        animatorSet.playTogether(ofFloat2);
        return animatorSet;
    }

    @Override // android.view.View
    public void setClickable(boolean z7) {
        super.setClickable(z7);
        if (z7) {
            setBackgroundResource(R$drawable.selectable_background);
        } else {
            Context context = getContext();
            Intrinsics.e(context, "context");
            setBackgroundColor(f2.b(context, R$color.F));
        }
        DesignImageView designImageView = this.E.f42957b;
        Intrinsics.e(designImageView, "binding.arrowImage");
        designImageView.setVisibility(z7 ? 0 : 8);
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        this.E.f42963h.setEnabled(z7);
        this.E.f42960e.setImageAlpha(I(z7));
        this.E.f42962g.setEnabled(z7);
        this.E.f42958c.setEnabled(z7);
        this.E.f42958c.setAlpha(E(z7));
        this.E.f42957b.setImageAlpha(I(z7));
        this.E.f42959d.setImageAlpha(I(z7));
    }

    public final void setPaymentMethod(b paymentUiModel) {
        Intrinsics.f(paymentUiModel, "paymentUiModel");
        PaymentProfileSwitch paymentProfileSwitch = this.E.f42963h;
        Intrinsics.e(paymentProfileSwitch, "binding.paymentProfileSwitch");
        if (paymentProfileSwitch.getVisibility() == 0) {
            F();
        }
        throw null;
    }

    public final void setPaymentProfileSwitchListener(ie listener) {
        Intrinsics.f(listener, "listener");
    }

    public final void setPaymentSwitchEnabled(boolean z7) {
        this.E.f42963h.setEnabled(z7);
    }

    public final void setPersonalProfileEnabled(boolean z7) {
        this.E.f42963h.setPersonalProfileEnabled(z7);
    }
}
