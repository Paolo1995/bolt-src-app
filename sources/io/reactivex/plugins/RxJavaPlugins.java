package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class RxJavaPlugins {

    /* renamed from: a  reason: collision with root package name */
    static volatile Consumer<? super Throwable> f49847a;

    /* renamed from: b  reason: collision with root package name */
    static volatile Function<? super Runnable, ? extends Runnable> f49848b;

    /* renamed from: c  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f49849c;

    /* renamed from: d  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f49850d;

    /* renamed from: e  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f49851e;

    /* renamed from: f  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f49852f;

    /* renamed from: g  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f49853g;

    /* renamed from: h  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f49854h;

    /* renamed from: i  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f49855i;

    /* renamed from: j  reason: collision with root package name */
    static volatile Function<? super Flowable, ? extends Flowable> f49856j;

    /* renamed from: k  reason: collision with root package name */
    static volatile Function<? super Observable, ? extends Observable> f49857k;

    /* renamed from: l  reason: collision with root package name */
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> f49858l;

    /* renamed from: m  reason: collision with root package name */
    static volatile Function<? super Maybe, ? extends Maybe> f49859m;

    /* renamed from: n  reason: collision with root package name */
    static volatile Function<? super Single, ? extends Single> f49860n;

    /* renamed from: o  reason: collision with root package name */
    static volatile Function<? super Completable, ? extends Completable> f49861o;

    /* renamed from: p  reason: collision with root package name */
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f49862p;

    /* renamed from: q  reason: collision with root package name */
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> f49863q;

    /* renamed from: r  reason: collision with root package name */
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> f49864r;

    /* renamed from: s  reason: collision with root package name */
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f49865s;

    /* renamed from: t  reason: collision with root package name */
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f49866t;

    /* renamed from: u  reason: collision with root package name */
    static volatile BooleanSupplier f49867u;

    /* renamed from: v  reason: collision with root package name */
    static volatile boolean f49868v;

    /* renamed from: w  reason: collision with root package name */
    static volatile boolean f49869w;

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Subscriber<? super T> A(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = f49862p;
        if (biFunction != null) {
            return (Subscriber) a(biFunction, flowable, subscriber);
        }
        return subscriber;
    }

    public static void B(Consumer<? super Throwable> consumer) {
        if (!f49868v) {
            f49847a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void C(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static <T, U, R> R a(BiFunction<T, U, R> biFunction, T t7, U u7) {
        try {
            return biFunction.apply(t7, u7);
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }

    static <T, R> R b(Function<T, R> function, T t7) {
        try {
            return function.apply(t7);
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }

    static Scheduler c(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.e(b(function, callable), "Scheduler Callable result can't be null");
    }

    static Scheduler d(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.e(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }

    public static Scheduler e(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f49849c;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    public static Scheduler f(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f49851e;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    public static Scheduler g(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f49852f;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    public static Scheduler h(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f49850d;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    static boolean i(Throwable th) {
        if ((th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException)) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        return f49869w;
    }

    public static Completable k(Completable completable) {
        Function<? super Completable, ? extends Completable> function = f49861o;
        if (function != null) {
            return (Completable) b(function, completable);
        }
        return completable;
    }

    public static <T> Flowable<T> l(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f49856j;
        if (function != null) {
            return (Flowable) b(function, flowable);
        }
        return flowable;
    }

    public static <T> Maybe<T> m(Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = f49859m;
        if (function != null) {
            return (Maybe) b(function, maybe);
        }
        return maybe;
    }

    public static <T> Observable<T> n(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f49857k;
        if (function != null) {
            return (Observable) b(function, observable);
        }
        return observable;
    }

    public static <T> Single<T> o(Single<T> single) {
        Function<? super Single, ? extends Single> function = f49860n;
        if (function != null) {
            return (Single) b(function, single);
        }
        return single;
    }

    public static <T> ConnectableObservable<T> p(ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = f49858l;
        if (function != null) {
            return (ConnectableObservable) b(function, connectableObservable);
        }
        return connectableObservable;
    }

    public static boolean q() {
        BooleanSupplier booleanSupplier = f49867u;
        if (booleanSupplier != null) {
            try {
                return booleanSupplier.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.e(th);
            }
        }
        return false;
    }

    public static Scheduler r(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f49853g;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    public static void s(Throwable th) {
        Consumer<? super Throwable> consumer = f49847a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                C(th2);
            }
        }
        th.printStackTrace();
        C(th);
    }

    public static Scheduler t(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f49855i;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    public static Runnable u(Runnable runnable) {
        ObjectHelper.e(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f49848b;
        if (function == null) {
            return runnable;
        }
        return (Runnable) b(function, runnable);
    }

    public static Scheduler v(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f49854h;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    public static CompletableObserver w(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = f49866t;
        if (biFunction != null) {
            return (CompletableObserver) a(biFunction, completable, completableObserver);
        }
        return completableObserver;
    }

    public static <T> MaybeObserver<? super T> x(Maybe<T> maybe, MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = f49863q;
        if (biFunction != null) {
            return (MaybeObserver) a(biFunction, maybe, maybeObserver);
        }
        return maybeObserver;
    }

    public static <T> Observer<? super T> y(Observable<T> observable, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = f49864r;
        if (biFunction != null) {
            return (Observer) a(biFunction, observable, observer);
        }
        return observer;
    }

    public static <T> SingleObserver<? super T> z(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = f49865s;
        if (biFunction != null) {
            return (SingleObserver) a(biFunction, single, singleObserver);
        }
        return singleObserver;
    }
}
