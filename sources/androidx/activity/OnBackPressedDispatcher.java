package androidx.activity;

import android.annotation.SuppressLint;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f758a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<OnBackPressedCallback> f759b;

    /* renamed from: c  reason: collision with root package name */
    private Consumer<Boolean> f760c;

    /* renamed from: d  reason: collision with root package name */
    private OnBackInvokedCallback f761d;

    /* renamed from: e  reason: collision with root package name */
    private OnBackInvokedDispatcher f762e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f763f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedCallback a(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new g(runnable);
        }

        static void b(Object obj, int i8, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i8, (OnBackInvokedCallback) obj2);
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        /* renamed from: f  reason: collision with root package name */
        private final Lifecycle f764f;

        /* renamed from: g  reason: collision with root package name */
        private final OnBackPressedCallback f765g;

        /* renamed from: h  reason: collision with root package name */
        private Cancellable f766h;

        LifecycleOnBackPressedCancellable(@NonNull Lifecycle lifecycle, @NonNull OnBackPressedCallback onBackPressedCallback) {
            this.f764f = lifecycle;
            this.f765g = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.f764f.c(this);
            this.f765g.removeCancellable(this);
            Cancellable cancellable = this.f766h;
            if (cancellable != null) {
                cancellable.cancel();
                this.f766h = null;
            }
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f766h = OnBackPressedDispatcher.this.c(this.f765g);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.f766h;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OnBackPressedCancellable implements Cancellable {

        /* renamed from: f  reason: collision with root package name */
        private final OnBackPressedCallback f768f;

        OnBackPressedCancellable(OnBackPressedCallback onBackPressedCallback) {
            this.f768f = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.this.f759b.remove(this.f768f);
            this.f768f.removeCancellable(this);
            if (BuildCompat.d()) {
                this.f768f.setIsEnabledConsumer(null);
                OnBackPressedDispatcher.this.h();
            }
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Boolean bool) {
        if (BuildCompat.d()) {
            h();
        }
    }

    @SuppressLint({"LambdaLast"})
    public void b(@NonNull LifecycleOwner lifecycleOwner, @NonNull OnBackPressedCallback onBackPressedCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
        if (BuildCompat.d()) {
            h();
            onBackPressedCallback.setIsEnabledConsumer(this.f760c);
        }
    }

    @NonNull
    Cancellable c(@NonNull OnBackPressedCallback onBackPressedCallback) {
        this.f759b.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        if (BuildCompat.d()) {
            h();
            onBackPressedCallback.setIsEnabledConsumer(this.f760c);
        }
        return onBackPressedCancellable;
    }

    public boolean d() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f759b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f759b.descendingIterator();
        while (descendingIterator.hasNext()) {
            OnBackPressedCallback next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.f758a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void g(@NonNull OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.f762e = onBackInvokedDispatcher;
        h();
    }

    void h() {
        boolean d8 = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f762e;
        if (onBackInvokedDispatcher != null) {
            if (d8 && !this.f763f) {
                Api33Impl.b(onBackInvokedDispatcher, 0, this.f761d);
                this.f763f = true;
            } else if (!d8 && this.f763f) {
                Api33Impl.c(onBackInvokedDispatcher, this.f761d);
                this.f763f = false;
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f759b = new ArrayDeque<>();
        this.f763f = false;
        this.f758a = runnable;
        if (BuildCompat.d()) {
            this.f760c = new Consumer() { // from class: androidx.activity.e
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    OnBackPressedDispatcher.this.e((Boolean) obj);
                }
            };
            this.f761d = Api33Impl.a(new Runnable() { // from class: androidx.activity.f
                @Override // java.lang.Runnable
                public final void run() {
                    OnBackPressedDispatcher.this.f();
                }
            });
        }
    }
}
