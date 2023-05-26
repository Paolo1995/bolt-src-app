package ee.mtakso.driver.ui.base.statistics;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
final class BarGraphItemView extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private final int f26314f;

    /* renamed from: g  reason: collision with root package name */
    private final int f26315g;

    /* renamed from: h  reason: collision with root package name */
    private final int f26316h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f26317i;

    /* renamed from: j  reason: collision with root package name */
    private View[] f26318j;

    /* renamed from: k  reason: collision with root package name */
    private BarGraphItemModel f26319k;

    private BarGraphItemView(Context context, int i8, int i9, int i10) {
        super(context);
        this.f26314f = i8;
        this.f26315g = i9;
        this.f26316h = i10;
    }

    private void b(BarGraphItemModel barGraphItemModel) {
        if (barGraphItemModel.d().length == this.f26319k.d().length) {
            float[] d8 = barGraphItemModel.d();
            float[] d9 = this.f26319k.d();
            int length = d9.length;
            ValueAnimator[] valueAnimatorArr = new ValueAnimator[length];
            for (int i8 = 0; i8 < length; i8++) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(d8[i8], d9[i8]);
                valueAnimatorArr[i8] = ofFloat;
                ofFloat.addUpdateListener(d(this.f26318j[i8]));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(valueAnimatorArr);
            animatorSet.setDuration(200L);
            animatorSet.start();
            return;
        }
        throw new IllegalStateException("Unexpected size difference between models: " + barGraphItemModel.d().length + " != " + this.f26319k.d().length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BarGraphItemView c(Context context, BarGraphItemModel barGraphItemModel) {
        Resources resources = context.getResources();
        BarGraphItemView barGraphItemView = new BarGraphItemView(context, resources.getDimensionPixelSize(R.dimen.bargraph_bar_max_height), resources.getDimensionPixelSize(R.dimen.bargraph_bar_horizontal_margin), resources.getDimensionPixelSize(R.dimen.bargraph_label_top_margin));
        barGraphItemView.setOrientation(1);
        barGraphItemView.j(barGraphItemModel, false);
        return barGraphItemView;
    }

    private ValueAnimator.AnimatorUpdateListener d(final View view) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.ui.base.statistics.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BarGraphItemView.h(view, valueAnimator);
            }
        };
    }

    private void e(Context context, BarGraphItemModel barGraphItemModel) {
        removeAllViews();
        int[] b8 = barGraphItemModel.b();
        float[] d8 = barGraphItemModel.d();
        this.f26318j = new View[d8.length];
        int i8 = 0;
        while (true) {
            View[] viewArr = this.f26318j;
            if (i8 < viewArr.length) {
                viewArr[i8] = new View(context);
                this.f26318j[i8].setBackgroundColor(b8[i8]);
                addView(this.f26318j[i8]);
                i(this.f26318j[i8], d8[i8]);
                i8++;
            } else {
                TextView textView = new TextView(context);
                this.f26317i = textView;
                addView(textView);
                f();
                g();
                return;
            }
        }
    }

    private void f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.f26314f);
        layoutParams.weight = 1.0f;
        int i8 = this.f26315g;
        layoutParams.rightMargin = i8;
        layoutParams.leftMargin = i8;
        layoutParams.gravity = 80;
        setLayoutParams(layoutParams);
        setGravity(81);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, this.f26316h, 0, 0);
        this.f26317i.setLayoutParams(layoutParams2);
    }

    private void g() {
        this.f26317i.setTextColor(ContextUtilsKt.b(getContext(), R.attr.contentPrimary));
        TextViewCompat.o(this.f26317i, 2132017742);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(View view, ValueAnimator valueAnimator) {
        ((LinearLayout.LayoutParams) view.getLayoutParams()).weight = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.requestLayout();
    }

    private void i(View view, float f8) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = f8;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(BarGraphItemModel barGraphItemModel, boolean z7) {
        BarGraphItemModel barGraphItemModel2 = this.f26319k;
        this.f26319k = barGraphItemModel;
        if (z7 && barGraphItemModel2 != null) {
            b(barGraphItemModel2);
        } else {
            e(getContext(), barGraphItemModel);
        }
        this.f26317i.setText(barGraphItemModel.c());
    }

    @Override // android.view.View
    public void setSelected(boolean z7) {
        super.setSelected(z7);
        if (z7) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.5f);
        }
    }
}
