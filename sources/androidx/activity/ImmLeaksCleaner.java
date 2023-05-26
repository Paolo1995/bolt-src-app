package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: g  reason: collision with root package name */
    private static int f753g;

    /* renamed from: h  reason: collision with root package name */
    private static Field f754h;

    /* renamed from: i  reason: collision with root package name */
    private static Field f755i;

    /* renamed from: j  reason: collision with root package name */
    private static Field f756j;

    /* renamed from: f  reason: collision with root package name */
    private Activity f757f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.f757f = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static void b() {
        try {
            f753g = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f755i = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f756j = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f754h = declaredField3;
            declaredField3.setAccessible(true);
            f753g = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f753g == 0) {
            b();
        }
        if (f753g == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f757f.getSystemService("input_method");
            try {
                Object obj = f754h.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f755i.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f756j.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
