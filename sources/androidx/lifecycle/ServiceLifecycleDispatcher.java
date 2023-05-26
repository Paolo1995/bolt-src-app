package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public class ServiceLifecycleDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleRegistry f6775a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6776b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private DispatchRunnable f6777c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DispatchRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final LifecycleRegistry f6778f;

        /* renamed from: g  reason: collision with root package name */
        final Lifecycle.Event f6779g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f6780h = false;

        DispatchRunnable(@NonNull LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.f6778f = lifecycleRegistry;
            this.f6779g = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f6780h) {
                this.f6778f.h(this.f6779g);
                this.f6780h = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@NonNull LifecycleOwner lifecycleOwner) {
        this.f6775a = new LifecycleRegistry(lifecycleOwner);
    }

    private void f(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.f6777c;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.f6775a, event);
        this.f6777c = dispatchRunnable2;
        this.f6776b.postAtFrontOfQueue(dispatchRunnable2);
    }

    @NonNull
    public Lifecycle a() {
        return this.f6775a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }
}
