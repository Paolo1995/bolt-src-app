package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* loaded from: classes5.dex */
public abstract class Single<T> implements SingleSource<T> {
    private Single<T> N(long j8, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.o(new SingleTimeout(this, j8, timeUnit, scheduler, singleSource));
    }

    public static Single<Long> O(long j8, TimeUnit timeUnit) {
        return P(j8, timeUnit, Schedulers.a());
    }

    public static Single<Long> P(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.o(new SingleTimer(j8, timeUnit, scheduler));
    }

    private static <T> Single<T> S(Flowable<T> flowable) {
        return RxJavaPlugins.o(new FlowableSingleSingle(flowable, null));
    }

    public static <T> Single<T> T(SingleSource<T> singleSource) {
        ObjectHelper.e(singleSource, "source is null");
        if (singleSource instanceof Single) {
            return RxJavaPlugins.o((Single) singleSource);
        }
        return RxJavaPlugins.o(new SingleFromUnsafeSource(singleSource));
    }

    public static <T1, T2, T3, R> Single<R> U(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.e(singleSource, "source1 is null");
        ObjectHelper.e(singleSource2, "source2 is null");
        ObjectHelper.e(singleSource3, "source3 is null");
        return W(Functions.w(function3), singleSource, singleSource2, singleSource3);
    }

    public static <T1, T2, R> Single<R> V(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.e(singleSource, "source1 is null");
        ObjectHelper.e(singleSource2, "source2 is null");
        return W(Functions.v(biFunction), singleSource, singleSource2);
    }

    public static <T, R> Single<R> W(Function<? super Object[], ? extends R> function, SingleSource<? extends T>... singleSourceArr) {
        ObjectHelper.e(function, "zipper is null");
        ObjectHelper.e(singleSourceArr, "sources is null");
        if (singleSourceArr.length == 0) {
            return error(new NoSuchElementException());
        }
        return RxJavaPlugins.o(new SingleZipArray(singleSourceArr, function));
    }

    public static <T> Single<T> error(Throwable th) {
        ObjectHelper.e(th, "exception is null");
        return p(Functions.k(th));
    }

    public static <T> Single<T> f(SingleOnSubscribe<T> singleOnSubscribe) {
        ObjectHelper.e(singleOnSubscribe, "source is null");
        return RxJavaPlugins.o(new SingleCreate(singleOnSubscribe));
    }

    public static <T> Single<T> g(Callable<? extends SingleSource<? extends T>> callable) {
        ObjectHelper.e(callable, "singleSupplier is null");
        return RxJavaPlugins.o(new SingleDefer(callable));
    }

    public static <T> Single<T> p(Callable<? extends Throwable> callable) {
        ObjectHelper.e(callable, "errorSupplier is null");
        return RxJavaPlugins.o(new SingleError(callable));
    }

    public static <T> Single<T> u(Callable<? extends T> callable) {
        ObjectHelper.e(callable, "callable is null");
        return RxJavaPlugins.o(new SingleFromCallable(callable));
    }

    public static <T> Single<T> w(T t7) {
        ObjectHelper.e(t7, "item is null");
        return RxJavaPlugins.o(new SingleJust(t7));
    }

    public static <T> Single<T> y() {
        return RxJavaPlugins.o(SingleNever.f49588f);
    }

    public final Single<T> A(Single<? extends T> single) {
        ObjectHelper.e(single, "resumeSingleInCaseOfError is null");
        return B(Functions.l(single));
    }

    public final Single<T> B(Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        ObjectHelper.e(function, "resumeFunctionInCaseOfError is null");
        return RxJavaPlugins.o(new SingleResumeNext(this, function));
    }

    public final Single<T> C(Function<Throwable, ? extends T> function) {
        ObjectHelper.e(function, "resumeFunction is null");
        return RxJavaPlugins.o(new SingleOnErrorReturn(this, function, null));
    }

    public final Single<T> D(T t7) {
        ObjectHelper.e(t7, "value is null");
        return RxJavaPlugins.o(new SingleOnErrorReturn(this, null, t7));
    }

    public final Flowable<T> E(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return Q().T(function);
    }

    public final Single<T> F(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return S(Q().U(function));
    }

    public final Disposable G() {
        return I(Functions.g(), Functions.f47621f);
    }

    public final Disposable H(Consumer<? super T> consumer) {
        return I(consumer, Functions.f47621f);
    }

    public final Disposable I(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.e(consumer, "onSuccess is null");
        ObjectHelper.e(consumer2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        a(consumerSingleObserver);
        return consumerSingleObserver;
    }

    protected abstract void J(SingleObserver<? super T> singleObserver);

    public final Single<T> K(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.o(new SingleSubscribeOn(this, scheduler));
    }

    public final Single<T> L(long j8, TimeUnit timeUnit) {
        return N(j8, timeUnit, Schedulers.a(), null);
    }

    public final Single<T> M(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return N(j8, timeUnit, scheduler, null);
    }

    public final Flowable<T> Q() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).c();
        }
        return RxJavaPlugins.l(new SingleToFlowable(this));
    }

    public final Observable<T> R() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).b();
        }
        return RxJavaPlugins.n(new SingleToObservable(this));
    }

    public final <U, R> Single<R> X(SingleSource<U> singleSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return V(this, singleSource, biFunction);
    }

    @Override // io.reactivex.SingleSource
    public final void a(SingleObserver<? super T> singleObserver) {
        ObjectHelper.e(singleObserver, "observer is null");
        SingleObserver<? super T> z7 = RxJavaPlugins.z(this, singleObserver);
        ObjectHelper.e(z7, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            J(z7);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            Exceptions.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final T d() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        a(blockingMultiObserver);
        return (T) blockingMultiObserver.a();
    }

    public final <R> Single<R> e(SingleTransformer<? super T, ? extends R> singleTransformer) {
        return T(((SingleTransformer) ObjectHelper.e(singleTransformer, "transformer is null")).a(this));
    }

    public final Single<T> h(long j8, TimeUnit timeUnit) {
        return i(j8, timeUnit, Schedulers.a(), false);
    }

    public final Single<T> i(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.o(new SingleDelay(this, j8, timeUnit, scheduler, z7));
    }

    public final Single<T> j(Action action) {
        ObjectHelper.e(action, "onFinally is null");
        return RxJavaPlugins.o(new SingleDoFinally(this, action));
    }

    public final Single<T> k(Action action) {
        ObjectHelper.e(action, "onDispose is null");
        return RxJavaPlugins.o(new SingleDoOnDispose(this, action));
    }

    public final Single<T> l(Consumer<? super Throwable> consumer) {
        ObjectHelper.e(consumer, "onError is null");
        return RxJavaPlugins.o(new SingleDoOnError(this, consumer));
    }

    public final Single<T> m(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.e(biConsumer, "onEvent is null");
        return RxJavaPlugins.o(new SingleDoOnEvent(this, biConsumer));
    }

    public final Single<T> n(Consumer<? super Disposable> consumer) {
        ObjectHelper.e(consumer, "onSubscribe is null");
        return RxJavaPlugins.o(new SingleDoOnSubscribe(this, consumer));
    }

    public final Single<T> o(Consumer<? super T> consumer) {
        ObjectHelper.e(consumer, "onSuccess is null");
        return RxJavaPlugins.o(new SingleDoOnSuccess(this, consumer));
    }

    public final Maybe<T> q(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.m(new MaybeFilterSingle(this, predicate));
    }

    public final <R> Single<R> r(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.o(new SingleFlatMap(this, function));
    }

    public final Completable s(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.k(new SingleFlatMapCompletable(this, function));
    }

    public final <R> Observable<R> t(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new SingleFlatMapObservable(this, function));
    }

    public final Completable v() {
        return RxJavaPlugins.k(new CompletableFromSingle(this));
    }

    public final <R> Single<R> x(Function<? super T, ? extends R> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.o(new SingleMap(this, function));
    }

    public final Single<T> z(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.o(new SingleObserveOn(this, scheduler));
    }
}
