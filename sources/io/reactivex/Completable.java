package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* loaded from: classes5.dex */
public abstract class Completable implements CompletableSource {
    public static Completable J(long j8, TimeUnit timeUnit) {
        return K(j8, timeUnit, Schedulers.a());
    }

    public static Completable K(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.k(new CompletableTimer(j8, timeUnit, scheduler));
    }

    private static NullPointerException M(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static Completable g() {
        return RxJavaPlugins.k(CompletableEmpty.f47740f);
    }

    public static Completable h(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.e(iterable, "sources is null");
        return RxJavaPlugins.k(new CompletableConcatIterable(iterable));
    }

    public static Completable i(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.e(completableOnSubscribe, "source is null");
        return RxJavaPlugins.k(new CompletableCreate(completableOnSubscribe));
    }

    public static Completable j(Callable<? extends CompletableSource> callable) {
        ObjectHelper.e(callable, "completableSupplier");
        return RxJavaPlugins.k(new CompletableDefer(callable));
    }

    private Completable q(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.e(consumer, "onSubscribe is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        ObjectHelper.e(action2, "onTerminate is null");
        ObjectHelper.e(action3, "onAfterTerminate is null");
        ObjectHelper.e(action4, "onDispose is null");
        return RxJavaPlugins.k(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    public static Completable t(Throwable th) {
        ObjectHelper.e(th, "error is null");
        return RxJavaPlugins.k(new CompletableError(th));
    }

    public static Completable u(Action action) {
        ObjectHelper.e(action, "run is null");
        return RxJavaPlugins.k(new CompletableFromAction(action));
    }

    public static Completable v(Callable<?> callable) {
        ObjectHelper.e(callable, "callable is null");
        return RxJavaPlugins.k(new CompletableFromCallable(callable));
    }

    public static <T> Completable w(Publisher<T> publisher) {
        ObjectHelper.e(publisher, "publisher is null");
        return RxJavaPlugins.k(new CompletableFromPublisher(publisher));
    }

    public static Completable x(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.e(iterable, "sources is null");
        return RxJavaPlugins.k(new CompletableMergeIterable(iterable));
    }

    public static Completable y(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.e(iterable, "sources is null");
        return RxJavaPlugins.k(new CompletableMergeDelayErrorIterable(iterable));
    }

    public final Completable A() {
        return B(Functions.c());
    }

    public final Completable B(Predicate<? super Throwable> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.k(new CompletableOnErrorComplete(this, predicate));
    }

    public final Completable C(Function<? super Throwable, ? extends CompletableSource> function) {
        ObjectHelper.e(function, "errorMapper is null");
        return RxJavaPlugins.k(new CompletableResumeNext(this, function));
    }

    public final Completable D(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return w(L().U(function));
    }

    public final Disposable E() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        a(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public final Disposable F(Action action) {
        ObjectHelper.e(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final Disposable G(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.e(consumer, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    protected abstract void H(CompletableObserver completableObserver);

    public final Completable I(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.k(new CompletableSubscribeOn(this, scheduler));
    }

    public final <T> Flowable<T> L() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).c();
        }
        return RxJavaPlugins.l(new CompletableToFlowable(this));
    }

    @Override // io.reactivex.CompletableSource
    public final void a(CompletableObserver completableObserver) {
        ObjectHelper.e(completableObserver, "observer is null");
        try {
            CompletableObserver w7 = RxJavaPlugins.w(this, completableObserver);
            ObjectHelper.e(w7, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            H(w7);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
            throw M(th);
        }
    }

    public final Completable d(CompletableSource completableSource) {
        ObjectHelper.e(completableSource, "next is null");
        return RxJavaPlugins.k(new CompletableAndThenCompletable(this, completableSource));
    }

    public final <T> Observable<T> e(ObservableSource<T> observableSource) {
        ObjectHelper.e(observableSource, "next is null");
        return RxJavaPlugins.n(new CompletableAndThenObservable(this, observableSource));
    }

    public final <T> Single<T> f(SingleSource<T> singleSource) {
        ObjectHelper.e(singleSource, "next is null");
        return RxJavaPlugins.o(new SingleDelayWithCompletable(singleSource, this));
    }

    public final Completable k(long j8, TimeUnit timeUnit) {
        return l(j8, timeUnit, Schedulers.a(), false);
    }

    public final Completable l(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.k(new CompletableDelay(this, j8, timeUnit, scheduler, z7));
    }

    public final Completable m(Action action) {
        ObjectHelper.e(action, "onFinally is null");
        return RxJavaPlugins.k(new CompletableDoFinally(this, action));
    }

    public final Completable n(Action action) {
        Consumer<? super Disposable> g8 = Functions.g();
        Consumer<? super Throwable> g9 = Functions.g();
        Action action2 = Functions.f47618c;
        return q(g8, g9, action, action2, action2, action2);
    }

    public final Completable o(Action action) {
        Consumer<? super Disposable> g8 = Functions.g();
        Consumer<? super Throwable> g9 = Functions.g();
        Action action2 = Functions.f47618c;
        return q(g8, g9, action2, action2, action2, action);
    }

    public final Completable p(Consumer<? super Throwable> consumer) {
        Consumer<? super Disposable> g8 = Functions.g();
        Action action = Functions.f47618c;
        return q(g8, consumer, action, action, action, action);
    }

    public final Completable r(Consumer<? super Disposable> consumer) {
        Consumer<? super Throwable> g8 = Functions.g();
        Action action = Functions.f47618c;
        return q(consumer, g8, action, action, action, action);
    }

    public final Completable s(Action action) {
        Consumer<? super Disposable> g8 = Functions.g();
        Consumer<? super Throwable> g9 = Functions.g();
        Action action2 = Functions.f47618c;
        return q(g8, g9, action2, action, action2, action2);
    }

    public final Completable z(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.k(new CompletableObserveOn(this, scheduler));
    }
}
