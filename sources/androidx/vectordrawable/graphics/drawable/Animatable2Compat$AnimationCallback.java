package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class Animatable2Compat$AnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    Animatable2.AnimationCallback f7926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animatable2.AnimationCallback a() {
        if (this.f7926a == null) {
            this.f7926a = new Animatable2.AnimationCallback() { // from class: androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback.1
                public void onAnimationEnd(Drawable drawable) {
                    Animatable2Compat$AnimationCallback.this.b(drawable);
                }

                public void onAnimationStart(Drawable drawable) {
                    Animatable2Compat$AnimationCallback.this.c(drawable);
                }
            };
        }
        return this.f7926a;
    }

    public void b(Drawable drawable) {
    }

    public void c(Drawable drawable) {
    }
}
