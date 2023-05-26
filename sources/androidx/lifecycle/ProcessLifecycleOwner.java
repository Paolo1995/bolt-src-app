package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;

/* loaded from: classes.dex */
public class ProcessLifecycleOwner implements LifecycleOwner {

    /* renamed from: n  reason: collision with root package name */
    private static final ProcessLifecycleOwner f6718n = new ProcessLifecycleOwner();

    /* renamed from: j  reason: collision with root package name */
    private Handler f6723j;

    /* renamed from: f  reason: collision with root package name */
    private int f6719f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f6720g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6721h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6722i = true;

    /* renamed from: k  reason: collision with root package name */
    private final LifecycleRegistry f6724k = new LifecycleRegistry(this);

    /* renamed from: l  reason: collision with root package name */
    private Runnable f6725l = new Runnable() { // from class: androidx.lifecycle.ProcessLifecycleOwner.1
        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner.this.f();
            ProcessLifecycleOwner.this.g();
        }
    };

    /* renamed from: m  reason: collision with root package name */
    ReportFragment.ActivityInitializationListener f6726m = new ReportFragment.ActivityInitializationListener() { // from class: androidx.lifecycle.ProcessLifecycleOwner.2
        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void a() {
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            ProcessLifecycleOwner.this.b();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            ProcessLifecycleOwner.this.c();
        }
    };

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void a(@NonNull Activity activity, @NonNull Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    private ProcessLifecycleOwner() {
    }

    @NonNull
    public static LifecycleOwner h() {
        return f6718n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Context context) {
        f6718n.e(context);
    }

    void a() {
        int i8 = this.f6720g - 1;
        this.f6720g = i8;
        if (i8 == 0) {
            this.f6723j.postDelayed(this.f6725l, 700L);
        }
    }

    void b() {
        int i8 = this.f6720g + 1;
        this.f6720g = i8;
        if (i8 == 1) {
            if (this.f6721h) {
                this.f6724k.h(Lifecycle.Event.ON_RESUME);
                this.f6721h = false;
                return;
            }
            this.f6723j.removeCallbacks(this.f6725l);
        }
    }

    void c() {
        int i8 = this.f6719f + 1;
        this.f6719f = i8;
        if (i8 == 1 && this.f6722i) {
            this.f6724k.h(Lifecycle.Event.ON_START);
            this.f6722i = false;
        }
    }

    void d() {
        this.f6719f--;
        g();
    }

    void e(Context context) {
        this.f6723j = new Handler();
        this.f6724k.h(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner.3
            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    ReportFragment.f(activity).h(ProcessLifecycleOwner.this.f6726m);
                }
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner.this.a();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPreCreated(@NonNull Activity activity, Bundle bundle) {
                Api29Impl.a(activity, new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner.3.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostResumed(@NonNull Activity activity2) {
                        ProcessLifecycleOwner.this.b();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostStarted(@NonNull Activity activity2) {
                        ProcessLifecycleOwner.this.c();
                    }
                });
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner.this.d();
            }
        });
    }

    void f() {
        if (this.f6720g == 0) {
            this.f6721h = true;
            this.f6724k.h(Lifecycle.Event.ON_PAUSE);
        }
    }

    void g() {
        if (this.f6719f == 0 && this.f6721h) {
            this.f6724k.h(Lifecycle.Event.ON_STOP);
            this.f6722i = true;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f6724k;
    }
}
