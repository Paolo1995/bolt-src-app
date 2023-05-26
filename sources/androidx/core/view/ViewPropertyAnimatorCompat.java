package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<View> f5984a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f5985b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f5986c = null;

    /* renamed from: d  reason: collision with root package name */
    int f5987d = -1;

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPropertyAnimatorCompat(View view) {
        this.f5984a = new WeakReference<>(view);
    }

    private void i(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.a(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.c(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat b(float f8) {
        View view = this.f5984a.get();
        if (view != null) {
            view.animate().alpha(f8);
        }
        return this;
    }

    public void c() {
        View view = this.f5984a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f5984a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    @NonNull
    public ViewPropertyAnimatorCompat f(long j8) {
        View view = this.f5984a.get();
        if (view != null) {
            view.animate().setDuration(j8);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat g(Interpolator interpolator) {
        View view = this.f5984a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat h(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.f5984a.get();
        if (view != null) {
            i(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat j(long j8) {
        View view = this.f5984a.get();
        if (view != null) {
            view.animate().setStartDelay(j8);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat k(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = this.f5984a.get();
        if (view != null) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.l1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ViewPropertyAnimatorUpdateListener.this.a(view);
                    }
                };
            }
            Api19Impl.a(view.animate(), animatorUpdateListener);
        }
        return this;
    }

    public void l() {
        View view = this.f5984a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat m(float f8) {
        View view = this.f5984a.get();
        if (view != null) {
            view.animate().translationY(f8);
        }
        return this;
    }
}
