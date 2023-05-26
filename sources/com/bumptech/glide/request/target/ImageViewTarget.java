package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {

    /* renamed from: n  reason: collision with root package name */
    private Animatable f10738n;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    private void m(Z z7) {
        if (z7 instanceof Animatable) {
            Animatable animatable = (Animatable) z7;
            this.f10738n = animatable;
            animatable.start();
            return;
        }
        this.f10738n = null;
    }

    private void p(Z z7) {
        o(z7);
        m(z7);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void b(Drawable drawable) {
        super.b(drawable);
        p(null);
        n(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void d(Drawable drawable) {
        super.d(drawable);
        Animatable animatable = this.f10738n;
        if (animatable != null) {
            animatable.stop();
        }
        p(null);
        n(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void e(@NonNull Z z7, Transition<? super Z> transition) {
        if (transition != null && transition.a(z7, this)) {
            m(z7);
        } else {
            p(z7);
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void i(Drawable drawable) {
        super.i(drawable);
        p(null);
        n(drawable);
    }

    public void n(Drawable drawable) {
        ((ImageView) this.f10743g).setImageDrawable(drawable);
    }

    protected abstract void o(Z z7);

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable animatable = this.f10738n;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable animatable = this.f10738n;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
