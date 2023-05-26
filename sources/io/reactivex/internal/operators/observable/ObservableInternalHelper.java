package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class ObservableInternalHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: f  reason: collision with root package name */
        private final Observable<T> f48778f;

        /* renamed from: g  reason: collision with root package name */
        private final int f48779g;

        BufferedReplayCallable(Observable<T> observable, int i8) {
            this.f48778f = observable;
            this.f48779g = i8;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public ConnectableObservable<T> call() {
            return this.f48778f.replay(this.f48779g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: f  reason: collision with root package name */
        private final Observable<T> f48780f;

        /* renamed from: g  reason: collision with root package name */
        private final int f48781g;

        /* renamed from: h  reason: collision with root package name */
        private final long f48782h;

        /* renamed from: i  reason: collision with root package name */
        private final TimeUnit f48783i;

        /* renamed from: j  reason: collision with root package name */
        private final Scheduler f48784j;

        BufferedTimedReplayCallable(Observable<T> observable, int i8, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            this.f48780f = observable;
            this.f48781g = i8;
            this.f48782h = j8;
            this.f48783i = timeUnit;
            this.f48784j = scheduler;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public ConnectableObservable<T> call() {
            return this.f48780f.replay(this.f48781g, this.f48782h, this.f48783i, this.f48784j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {

        /* renamed from: f  reason: collision with root package name */
        private final Function<? super T, ? extends Iterable<? extends U>> f48785f;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.f48785f = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<U> apply(T t7) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.e(this.f48785f.apply(t7), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {

        /* renamed from: f  reason: collision with root package name */
        private final BiFunction<? super T, ? super U, ? extends R> f48786f;

        /* renamed from: g  reason: collision with root package name */
        private final T f48787g;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t7) {
            this.f48786f = biFunction;
            this.f48787g = t7;
        }

        @Override // io.reactivex.functions.Function
        public R apply(U u7) throws Exception {
            return this.f48786f.apply((T) this.f48787g, u7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {

        /* renamed from: f  reason: collision with root package name */
        private final BiFunction<? super T, ? super U, ? extends R> f48788f;

        /* renamed from: g  reason: collision with root package name */
        private final Function<? super T, ? extends ObservableSource<? extends U>> f48789g;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.f48788f = biFunction;
            this.f48789g = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<R> apply(T t7) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.e(this.f48789g.apply(t7), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.f48788f, t7));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {

        /* renamed from: f  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<U>> f48790f;

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.f48790f = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<T> apply(T t7) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.e(this.f48790f.apply(t7), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.l(t7)).defaultIfEmpty(t7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ObserverOnComplete<T> implements Action {

        /* renamed from: f  reason: collision with root package name */
        final Observer<T> f48791f;

        ObserverOnComplete(Observer<T> observer) {
            this.f48791f = observer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.f48791f.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ObserverOnError<T> implements Consumer<Throwable> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<T> f48792f;

        ObserverOnError(Observer<T> observer) {
            this.f48792f = observer;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.f48792f.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ObserverOnNext<T> implements Consumer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<T> f48793f;

        ObserverOnNext(Observer<T> observer) {
            this.f48793f = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t7) throws Exception {
            this.f48793f.onNext(t7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: f  reason: collision with root package name */
        private final Observable<T> f48794f;

        ReplayCallable(Observable<T> observable) {
            this.f48794f = observable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public ConnectableObservable<T> call() {
            return this.f48794f.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {

        /* renamed from: f  reason: collision with root package name */
        private final Function<? super Observable<T>, ? extends ObservableSource<R>> f48795f;

        /* renamed from: g  reason: collision with root package name */
        private final Scheduler f48796g;

        ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            this.f48795f = function;
            this.f48796g = scheduler;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<R> apply(Observable<T> observable) throws Exception {
            return Observable.wrap((ObservableSource) ObjectHelper.e(this.f48795f.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.f48796g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final BiConsumer<S, Emitter<T>> f48797a;

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f48797a = biConsumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a */
        public S apply(S s7, Emitter<T> emitter) throws Exception {
            this.f48797a.accept(s7, emitter);
            return s7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final Consumer<Emitter<T>> f48798a;

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f48798a = consumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a */
        public S apply(S s7, Emitter<T> emitter) throws Exception {
            this.f48798a.accept(emitter);
            return s7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* renamed from: f  reason: collision with root package name */
        private final Observable<T> f48799f;

        /* renamed from: g  reason: collision with root package name */
        private final long f48800g;

        /* renamed from: h  reason: collision with root package name */
        private final TimeUnit f48801h;

        /* renamed from: i  reason: collision with root package name */
        private final Scheduler f48802i;

        TimedReplayCallable(Observable<T> observable, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            this.f48799f = observable;
            this.f48800g = j8;
            this.f48801h = timeUnit;
            this.f48802i = scheduler;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public ConnectableObservable<T> call() {
            return this.f48799f.replay(this.f48800g, this.f48801h, this.f48802i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {

        /* renamed from: f  reason: collision with root package name */
        private final Function<? super Object[], ? extends R> f48803f;

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.f48803f = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return Observable.zipIterable(list, this.f48803f, false, Observable.bufferSize());
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> a(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> b(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> c(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action d(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> e(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> f(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Callable<ConnectableObservable<T>> g(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T> Callable<ConnectableObservable<T>> h(Observable<T> observable, int i8) {
        return new BufferedReplayCallable(observable, i8);
    }

    public static <T> Callable<ConnectableObservable<T>> i(Observable<T> observable, int i8, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, i8, j8, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> j(Observable<T> observable, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j8, timeUnit, scheduler);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> k(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> l(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> m(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> n(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }
}
