package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class RxAndroidPlugins {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Function<Callable<Scheduler>, Scheduler> f47590a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Function<Scheduler, Scheduler> f47591b;

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }

    static <T, R> R a(Function<T, R> function, T t7) {
        try {
            return function.apply(t7);
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    static Scheduler b(Function<Callable<Scheduler>, Scheduler> function, Callable<Scheduler> callable) {
        Scheduler scheduler = (Scheduler) a(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static Scheduler c(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    public static Scheduler d(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = f47590a;
            if (function == null) {
                return c(callable);
            }
            return b(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Scheduler e(Scheduler scheduler) {
        if (scheduler != null) {
            Function<Scheduler, Scheduler> function = f47591b;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }
}
