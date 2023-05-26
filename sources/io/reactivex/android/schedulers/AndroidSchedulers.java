package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class AndroidSchedulers {

    /* renamed from: a  reason: collision with root package name */
    private static final Scheduler f47592a = RxAndroidPlugins.d(new Callable<Scheduler>() { // from class: io.reactivex.android.schedulers.AndroidSchedulers.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return MainHolder.f47593a;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class MainHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f47593a = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);

        private MainHolder() {
        }
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler a() {
        return RxAndroidPlugins.e(f47592a);
    }
}
