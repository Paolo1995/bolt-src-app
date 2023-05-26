package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: f  reason: collision with root package name */
    private final View f5955f;

    /* renamed from: g  reason: collision with root package name */
    private ViewTreeObserver f5956g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f5957h;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f5955f = view;
        this.f5956g = view.getViewTreeObserver();
        this.f5957h = runnable;
    }

    @NonNull
    public static OneShotPreDrawListener a(@NonNull View view, @NonNull Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
                view.addOnAttachStateChangeListener(oneShotPreDrawListener);
                return oneShotPreDrawListener;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        if (this.f5956g.isAlive()) {
            this.f5956g.removeOnPreDrawListener(this);
        } else {
            this.f5955f.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f5955f.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f5957h.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View view) {
        this.f5956g = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NonNull View view) {
        b();
    }
}
