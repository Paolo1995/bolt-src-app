package io.reactivex;

import com.google.android.gms.common.api.Api;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFilter;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper$RequestMax;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public abstract class Flowable<T> implements Publisher<T> {

    /* renamed from: f  reason: collision with root package name */
    static final int f47569f = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static <T> Flowable<T> F(T... tArr) {
        ObjectHelper.e(tArr, "items is null");
        if (tArr.length == 0) {
            return r();
        }
        if (tArr.length == 1) {
            return I(tArr[0]);
        }
        return RxJavaPlugins.l(new FlowableFromArray(tArr));
    }

    public static <T> Flowable<T> G(Callable<? extends T> callable) {
        ObjectHelper.e(callable, "supplier is null");
        return RxJavaPlugins.l(new FlowableFromCallable(callable));
    }

    public static <T> Flowable<T> H(Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.l((Flowable) publisher);
        }
        ObjectHelper.e(publisher, "source is null");
        return RxJavaPlugins.l(new FlowableFromPublisher(publisher));
    }

    public static <T> Flowable<T> I(T t7) {
        ObjectHelper.e(t7, "item is null");
        return RxJavaPlugins.l(new FlowableJust(t7));
    }

    public static <T> Flowable<T> K(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.e(publisher, "source1 is null");
        ObjectHelper.e(publisher2, "source2 is null");
        return F(publisher, publisher2).x(Functions.i(), false, 2);
    }

    public static int b() {
        return f47569f;
    }

    public static <T, R> Flowable<R> d(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        return i(publisherArr, function, b());
    }

    public static Flowable<Long> d0(long j8, TimeUnit timeUnit) {
        return e0(j8, timeUnit, Schedulers.a());
    }

    public static Flowable<Long> e0(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.l(new FlowableTimer(Math.max(0L, j8), timeUnit, scheduler));
    }

    public static <T1, T2, R> Flowable<R> g(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.e(publisher, "source1 is null");
        ObjectHelper.e(publisher2, "source2 is null");
        return d(Functions.v(biFunction), publisher, publisher2);
    }

    public static <T, R> Flowable<R> i(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i8) {
        ObjectHelper.e(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return r();
        }
        ObjectHelper.e(function, "combiner is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.l(new FlowableCombineLatest(publisherArr, function, i8, false));
    }

    public static <T> Flowable<T> l(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        ObjectHelper.e(flowableOnSubscribe, "source is null");
        ObjectHelper.e(backpressureStrategy, "mode is null");
        return RxJavaPlugins.l(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    private Flowable<T> o(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.e(consumer, "onNext is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        ObjectHelper.e(action2, "onAfterTerminate is null");
        return RxJavaPlugins.l(new FlowableDoOnEach(this, consumer, consumer2, action, action2));
    }

    public static <T> Flowable<T> r() {
        return RxJavaPlugins.l(FlowableEmpty.f47894g);
    }

    public static <T> Flowable<T> s(Throwable th) {
        ObjectHelper.e(th, "throwable is null");
        return t(Functions.k(th));
    }

    public static <T> Flowable<T> t(Callable<? extends Throwable> callable) {
        ObjectHelper.e(callable, "supplier is null");
        return RxJavaPlugins.l(new FlowableError(callable));
    }

    public final Completable A(Function<? super T, ? extends CompletableSource> function, boolean z7, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "maxConcurrency");
        return RxJavaPlugins.k(new FlowableFlatMapCompletableCompletable(this, function, z7, i8));
    }

    public final <R> Flowable<R> B(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return C(function, false, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final <R> Flowable<R> C(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "maxConcurrency");
        return RxJavaPlugins.l(new FlowableFlatMapMaybe(this, function, z7, i8));
    }

    public final <R> Flowable<R> D(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return E(function, false, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final <R> Flowable<R> E(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "maxConcurrency");
        return RxJavaPlugins.l(new FlowableFlatMapSingle(this, function, z7, i8));
    }

    public final <R> Flowable<R> J(Function<? super T, ? extends R> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.l(new FlowableMap(this, function));
    }

    public final Flowable<T> L(Scheduler scheduler) {
        return N(scheduler, false, b());
    }

    public final Flowable<T> M(Scheduler scheduler, boolean z7) {
        return N(scheduler, z7, b());
    }

    public final Flowable<T> N(Scheduler scheduler, boolean z7, int i8) {
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.l(new FlowableObserveOn(this, scheduler, z7, i8));
    }

    public final Flowable<T> O() {
        return P(b(), false, true);
    }

    public final Flowable<T> P(int i8, boolean z7, boolean z8) {
        ObjectHelper.f(i8, "capacity");
        return RxJavaPlugins.l(new FlowableOnBackpressureBuffer(this, i8, z8, z7, Functions.f47618c));
    }

    public final Flowable<T> Q() {
        return RxJavaPlugins.l(new FlowableOnBackpressureDrop(this));
    }

    public final Flowable<T> R() {
        return RxJavaPlugins.l(new FlowableOnBackpressureLatest(this));
    }

    public final Flowable<T> S(Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        ObjectHelper.e(function, "resumeFunction is null");
        return RxJavaPlugins.l(new FlowableOnErrorNext(this, function, false));
    }

    public final Flowable<T> T(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        ObjectHelper.e(function, "handler is null");
        return RxJavaPlugins.l(new FlowableRepeatWhen(this, function));
    }

    public final Flowable<T> U(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        ObjectHelper.e(function, "handler is null");
        return RxJavaPlugins.l(new FlowableRetryWhen(this, function));
    }

    public final Disposable V(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return X(consumer, consumer2, Functions.f47618c, FlowableInternalHelper$RequestMax.INSTANCE);
    }

    public final Disposable W(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return X(consumer, consumer2, action, FlowableInternalHelper$RequestMax.INSTANCE);
    }

    public final Disposable X(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        ObjectHelper.e(consumer, "onNext is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        ObjectHelper.e(consumer3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, consumer3);
        Y(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final void Y(FlowableSubscriber<? super T> flowableSubscriber) {
        ObjectHelper.e(flowableSubscriber, "s is null");
        try {
            Subscriber<? super T> A = RxJavaPlugins.A(this, flowableSubscriber);
            ObjectHelper.e(A, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            Z(A);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void Z(Subscriber<? super T> subscriber);

    @Override // org.reactivestreams.Publisher
    public final void a(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            Y((FlowableSubscriber) subscriber);
            return;
        }
        ObjectHelper.e(subscriber, "s is null");
        Y(new StrictSubscriber(subscriber));
    }

    public final Flowable<T> a0(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return b0(scheduler, !(this instanceof FlowableCreate));
    }

    public final Flowable<T> b0(Scheduler scheduler, boolean z7) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.l(new FlowableSubscribeOn(this, scheduler, z7));
    }

    public final Flowable<T> c0(long j8) {
        if (j8 >= 0) {
            return RxJavaPlugins.l(new FlowableTake(this, j8));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j8);
    }

    public final Observable<T> f0() {
        return RxJavaPlugins.n(new ObservableFromPublisher(this));
    }

    public final Flowable<T> g0(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.l(new FlowableUnsubscribeOn(this, scheduler));
    }

    public final <R> Flowable<R> j(Function<? super T, ? extends Publisher<? extends R>> function) {
        return k(function, 2);
    }

    public final <R> Flowable<R> k(Function<? super T, ? extends Publisher<? extends R>> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return r();
            }
            return FlowableScalarXMap.a(call, function);
        }
        return RxJavaPlugins.l(new FlowableConcatMap(this, function, i8, ErrorMode.IMMEDIATE));
    }

    public final Flowable<T> m() {
        return n(Functions.i());
    }

    public final <K> Flowable<T> n(Function<? super T, K> function) {
        ObjectHelper.e(function, "keySelector is null");
        return RxJavaPlugins.l(new FlowableDistinctUntilChanged(this, function, ObjectHelper.d()));
    }

    public final Flowable<T> p(Consumer<? super T> consumer) {
        Consumer<? super Throwable> g8 = Functions.g();
        Action action = Functions.f47618c;
        return o(consumer, g8, action, action);
    }

    public final Single<T> q(long j8) {
        if (j8 >= 0) {
            return RxJavaPlugins.o(new FlowableElementAtSingle(this, j8, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j8);
    }

    public final Flowable<T> u(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.l(new FlowableFilter(this, predicate));
    }

    public final Single<T> v() {
        return q(0L);
    }

    public final <R> Flowable<R> w(Function<? super T, ? extends Publisher<? extends R>> function) {
        return y(function, false, b(), b());
    }

    public final <R> Flowable<R> x(Function<? super T, ? extends Publisher<? extends R>> function, boolean z7, int i8) {
        return y(function, z7, i8, b());
    }

    public final <R> Flowable<R> y(Function<? super T, ? extends Publisher<? extends R>> function, boolean z7, int i8, int i9) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "maxConcurrency");
        ObjectHelper.f(i9, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return r();
            }
            return FlowableScalarXMap.a(call, function);
        }
        return RxJavaPlugins.l(new FlowableFlatMap(this, function, z7, i8, i9));
    }

    public final Completable z(Function<? super T, ? extends CompletableSource> function) {
        return A(function, false, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }
}
