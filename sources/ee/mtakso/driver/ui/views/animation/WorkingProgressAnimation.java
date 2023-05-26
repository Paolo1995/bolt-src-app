package ee.mtakso.driver.ui.views.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.views.animation.WorkingProgressAnimation;

/* loaded from: classes5.dex */
public class WorkingProgressAnimation {

    /* renamed from: e  reason: collision with root package name */
    private static int f34342e = 1600;

    /* renamed from: a  reason: collision with root package name */
    private ObjectAnimator f34343a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f34344b;

    /* renamed from: c  reason: collision with root package name */
    private long f34345c;

    /* renamed from: d  reason: collision with root package name */
    private long f34346d;

    public WorkingProgressAnimation(View view, int i8, long j8) {
        float f8;
        int i9 = i8 / 4;
        view.setTranslationX(0.0f);
        view.getLayoutParams().width = i9;
        view.requestLayout();
        if (view.getResources().getBoolean(R.bool.isRtl)) {
            f8 = -1.0f;
        } else {
            f8 = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, (i8 - i9) * f8);
        this.f34343a = ofFloat;
        ofFloat.addUpdateListener(c(j8));
        this.f34343a.setRepeatCount(-1);
        this.f34343a.setRepeatMode(2);
        this.f34343a.setDuration(f34342e);
        this.f34343a.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    private ValueAnimator.AnimatorUpdateListener c(final long j8) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: l5.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WorkingProgressAnimation.this.d(j8, valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(long j8, ValueAnimator valueAnimator) {
        if (j8 >= this.f34345c) {
            e();
        }
    }

    public void b(long j8) {
        this.f34345c = j8 + Math.round(f34342e * 3);
        if (!this.f34344b) {
            this.f34344b = true;
            long j9 = this.f34346d;
            if (j9 != 0) {
                this.f34343a.setCurrentPlayTime(j9);
                this.f34346d = 0L;
            }
            this.f34343a.start();
        }
    }

    public void e() {
        this.f34344b = false;
        this.f34346d = this.f34343a.getCurrentPlayTime();
        this.f34343a.cancel();
    }
}
