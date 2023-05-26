package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ActivityRecreator {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f5542a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f5543b;

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f5544c;

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f5545d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f5546e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f5547f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f5548g = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {

        /* renamed from: f  reason: collision with root package name */
        Object f5555f;

        /* renamed from: g  reason: collision with root package name */
        private Activity f5556g;

        /* renamed from: h  reason: collision with root package name */
        private final int f5557h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5558i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f5559j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f5560k = false;

        LifecycleCheckCallbacks(@NonNull Activity activity) {
            this.f5556g = activity;
            this.f5557h = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f5556g == activity) {
                this.f5556g = null;
                this.f5559j = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (this.f5559j && !this.f5560k && !this.f5558i && ActivityRecreator.h(this.f5555f, this.f5557h, activity)) {
                this.f5560k = true;
                this.f5555f = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f5556g == activity) {
                this.f5558i = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a8 = a();
        f5542a = a8;
        f5543b = b();
        f5544c = f();
        f5545d = d(a8);
        f5546e = c(a8);
        f5547f = e(a8);
    }

    private ActivityRecreator() {
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 != 26 && i8 != 27) {
            return false;
        }
        return true;
    }

    protected static boolean h(Object obj, int i8, Activity activity) {
        try {
            final Object obj2 = f5544c.get(activity);
            if (obj2 == obj && activity.hashCode() == i8) {
                final Object obj3 = f5543b.get(activity);
                f5548g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Method method = ActivityRecreator.f5545d;
                            if (method != null) {
                                method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                            } else {
                                ActivityRecreator.f5546e.invoke(obj3, obj2, Boolean.FALSE);
                            }
                        } catch (RuntimeException e8) {
                            if (e8.getClass() == RuntimeException.class && e8.getMessage() != null && e8.getMessage().startsWith("Unable to stop")) {
                                throw e8;
                            }
                        } catch (Throwable th) {
                            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(@NonNull Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f5547f == null) {
            return false;
        } else {
            if (f5546e == null && f5545d == null) {
                return false;
            }
            try {
                final Object obj2 = f5544c.get(activity);
                if (obj2 == null || (obj = f5543b.get(activity)) == null) {
                    return false;
                }
                final Application application = activity.getApplication();
                final LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                Handler handler = f5548g;
                handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LifecycleCheckCallbacks.this.f5555f = obj2;
                    }
                });
                if (g()) {
                    Method method = f5547f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
