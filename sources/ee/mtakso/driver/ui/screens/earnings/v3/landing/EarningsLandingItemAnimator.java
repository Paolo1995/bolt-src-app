package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsPieChartItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator;
import ee.mtakso.driver.uikit.widgets.chart.PieChartView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsLandingItemAnimator.kt */
/* loaded from: classes3.dex */
public final class EarningsLandingItemAnimator extends RecyclerViewItemAnimator {
    private final ValueAnimator m0(final EarningsPieChartItemDelegate.ViewHolder viewHolder) {
        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EarningsLandingItemAnimator.n0(EarningsPieChartItemDelegate.ViewHolder.this, animator, valueAnimator);
            }
        });
        animator.setDuration(750L);
        animator.setInterpolator(new DecelerateInterpolator());
        Intrinsics.e(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(EarningsPieChartItemDelegate.ViewHolder holder, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.f(holder, "$holder");
        Intrinsics.f(it, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        ((PieChartView) holder.O(R.id.pieChartView)).setSegmentScale(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(RecyclerView.ViewHolder viewHolder, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.f(it, "it");
        View view = ((EarningsPieChartItemDelegate.ViewHolder) viewHolder).f7332a;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationX(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(RecyclerView.ViewHolder viewHolder, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.f(it, "it");
        View view = ((EarningsPieChartItemDelegate.ViewHolder) viewHolder).f7332a;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationY(((Float) animatedValue).floatValue());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator
    public Animator f0(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        return null;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator
    @SuppressLint({"Recycle"})
    public Animator g0(RecyclerView.ViewHolder viewHolder, final RecyclerView.ViewHolder viewHolder2, int i8, int i9, int i10, int i11) {
        if ((viewHolder instanceof StaticItemDelegate.ViewHolder) && (viewHolder2 instanceof EarningsPieChartItemDelegate.ViewHolder)) {
            StaticItemDelegate.ViewHolder viewHolder3 = (StaticItemDelegate.ViewHolder) viewHolder;
            float translationX = viewHolder3.f7332a.getTranslationX();
            viewHolder3.f7332a.setAlpha(0.0f);
            EarningsPieChartItemDelegate.ViewHolder viewHolder4 = (EarningsPieChartItemDelegate.ViewHolder) viewHolder2;
            viewHolder4.f7332a.setTranslationX(-((int) ((i10 - i8) - translationX)));
            viewHolder4.f7332a.setTranslationY(-((int) ((i11 - i9) - viewHolder3.f7332a.getTranslationY())));
            ((PieChartView) viewHolder4.O(R.id.pieChartView)).setSegmentScale(0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            final ValueAnimator ofFloat = ValueAnimator.ofFloat(viewHolder4.f7332a.getTranslationX(), 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EarningsLandingItemAnimator.o0(RecyclerView.ViewHolder.this, ofFloat, valueAnimator);
                }
            });
            Unit unit = Unit.f50853a;
            final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(viewHolder4.f7332a.getTranslationY(), 0.0f);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EarningsLandingItemAnimator.p0(RecyclerView.ViewHolder.this, ofFloat2, valueAnimator);
                }
            });
            animatorSet.playTogether(m0(viewHolder4), ofFloat, ofFloat2);
            animatorSet.setDuration(750L);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            return animatorSet;
        }
        return null;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.RecyclerViewItemAnimator
    public void i0(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof EarningsPieChartItemDelegate.ViewHolder) {
            EarningsPieChartItemDelegate.ViewHolder viewHolder2 = (EarningsPieChartItemDelegate.ViewHolder) viewHolder;
            viewHolder2.f7332a.setAlpha(1.0f);
            viewHolder2.f7332a.setTranslationX(0.0f);
            viewHolder2.f7332a.setTranslationY(0.0f);
            ((PieChartView) viewHolder2.O(R.id.pieChartView)).setSegmentScale(1.0f);
        } else if (viewHolder instanceof StaticItemDelegate.ViewHolder) {
            StaticItemDelegate.ViewHolder viewHolder3 = (StaticItemDelegate.ViewHolder) viewHolder;
            viewHolder3.f7332a.setAlpha(1.0f);
            viewHolder3.f7332a.setTranslationX(0.0f);
            viewHolder3.f7332a.setTranslationY(0.0f);
        }
    }
}
