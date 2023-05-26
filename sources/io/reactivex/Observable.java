package io.reactivex;

import com.google.android.gms.common.api.Api;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* loaded from: classes5.dex */
public abstract class Observable<T> implements ObservableSource<T> {

    /* renamed from: io.reactivex.Observable$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47572a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f47572a = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47572a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47572a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47572a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.e(iterable, "sources is null");
        return RxJavaPlugins.n(new ObservableAmb(null, iterable));
    }

    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        ObjectHelper.e(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.n(new ObservableAmb(observableSourceArr, null));
    }

    public static int bufferSize() {
        return Flowable.b();
    }

    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i8, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i8);
    }

    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.e(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.i(), bufferSize(), false);
    }

    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.n(new ObservableConcatMap(fromArray(observableSourceArr), Functions.i(), bufferSize(), ErrorMode.BOUNDARY));
    }

    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return concatDelayError(fromArray(observableSourceArr));
    }

    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    public static <T> Observable<T> concatArrayEagerDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), observableSourceArr);
    }

    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.e(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.e(observableOnSubscribe, "source is null");
        return RxJavaPlugins.n(new ObservableCreate(observableOnSubscribe));
    }

    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.e(callable, "supplier is null");
        return RxJavaPlugins.n(new ObservableDefer(callable));
    }

    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.e(consumer, "onNext is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        ObjectHelper.e(action2, "onAfterTerminate is null");
        return RxJavaPlugins.n(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    public static <T> Observable<T> empty() {
        return RxJavaPlugins.n(ObservableEmpty.f48611f);
    }

    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.e(callable, "errorSupplier is null");
        return RxJavaPlugins.n(new ObservableError(callable));
    }

    public static <T> Observable<T> fromArray(T... tArr) {
        ObjectHelper.e(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.n(new ObservableFromArray(tArr));
    }

    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.e(callable, "supplier is null");
        return RxJavaPlugins.n(new ObservableFromCallable(callable));
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.e(future, "future is null");
        return RxJavaPlugins.n(new ObservableFromFuture(future, 0L, null));
    }

    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.e(iterable, "source is null");
        return RxJavaPlugins.n(new ObservableFromIterable(iterable));
    }

    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.e(publisher, "publisher is null");
        return RxJavaPlugins.n(new ObservableFromPublisher(publisher));
    }

    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.e(consumer, "generator is null");
        return generate(Functions.s(), ObservableInternalHelper.m(consumer), Functions.g());
    }

    public static Observable<Long> interval(long j8, long j9, TimeUnit timeUnit) {
        return interval(j8, j9, timeUnit, Schedulers.a());
    }

    public static Observable<Long> intervalRange(long j8, long j9, long j10, long j11, TimeUnit timeUnit) {
        return intervalRange(j8, j9, j10, j11, timeUnit, Schedulers.a());
    }

    public static <T> Observable<T> just(T t7) {
        ObjectHelper.e(t7, "item is null");
        return RxJavaPlugins.n(new ObservableJust(t7));
    }

    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i8, int i9) {
        return fromIterable(iterable).flatMap(Functions.i(), false, i8, i9);
    }

    public static <T> Observable<T> mergeArray(int i8, int i9, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), false, i8, i9);
    }

    public static <T> Observable<T> mergeArrayDelayError(int i8, int i9, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), true, i8, i9);
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.i(), true);
    }

    public static <T> Observable<T> never() {
        return RxJavaPlugins.n(ObservableNever.f48894f);
    }

    public static Observable<Integer> range(int i8, int i9) {
        if (i9 >= 0) {
            if (i9 == 0) {
                return empty();
            }
            if (i9 == 1) {
                return just(Integer.valueOf(i8));
            }
            if (i8 + (i9 - 1) <= 2147483647L) {
                return RxJavaPlugins.n(new ObservableRange(i8, i9));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + i9);
    }

    public static Observable<Long> rangeLong(long j8, long j9) {
        int i8 = (j9 > 0L ? 1 : (j9 == 0L ? 0 : -1));
        if (i8 >= 0) {
            if (i8 == 0) {
                return empty();
            }
            if (j9 == 1) {
                return just(Long.valueOf(j8));
            }
            long j10 = (j9 - 1) + j8;
            if (j8 > 0 && j10 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            return RxJavaPlugins.n(new ObservableRangeLong(j8, j9));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j9);
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.d(), bufferSize());
    }

    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i8) {
        ObjectHelper.e(observableSource, "sources is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableSwitchMap(observableSource, Functions.i(), i8, false));
    }

    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    private Observable<T> timeout0(long j8, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "timeUnit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableTimeoutTimed(this, j8, timeUnit, scheduler, observableSource));
    }

    public static Observable<Long> timer(long j8, TimeUnit timeUnit) {
        return timer(j8, timeUnit, Schedulers.a());
    }

    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.e(observableSource, "onSubscribe is null");
        if (!(observableSource instanceof Observable)) {
            return RxJavaPlugins.n(new ObservableFromUnsafeSource(observableSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.e(observableSource, "source is null");
        if (observableSource instanceof Observable) {
            return RxJavaPlugins.n((Observable) observableSource);
        }
        return RxJavaPlugins.n(new ObservableFromUnsafeSource(observableSource));
    }

    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.e(function, "zipper is null");
        ObjectHelper.e(iterable, "sources is null");
        return RxJavaPlugins.n(new ObservableZip(null, iterable, function, bufferSize(), false));
    }

    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z7, int i8, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.e(function, "zipper is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableZip(observableSourceArr, null, function, i8, z7));
    }

    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z7, int i8) {
        ObjectHelper.e(function, "zipper is null");
        ObjectHelper.e(iterable, "sources is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableZip(null, iterable, function, i8, z7));
    }

    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.o(new ObservableAllSingle(this, predicate));
    }

    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.o(new ObservableAnySingle(this, predicate));
    }

    public final <R> R as(ObservableConverter<T, ? extends R> observableConverter) {
        return (R) ((ObservableConverter) ObjectHelper.e(observableConverter, "converter is null")).a(this);
    }

    public final T blockingFirst() {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T a8 = blockingFirstObserver.a();
        if (a8 != null) {
            return a8;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th) {
                Exceptions.b(th);
                ((Disposable) it).dispose();
                throw ExceptionHelper.e(th);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T a8 = blockingLastObserver.a();
        if (a8 != null) {
            return a8;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    public final Iterable<T> blockingMostRecent(T t7) {
        return new BlockingObservableMostRecent(this, t7);
    }

    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    public final T blockingSingle() {
        T c8 = singleElement().c();
        if (c8 != null) {
            return c8;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.a(this);
    }

    public final Observable<List<T>> buffer(int i8) {
        return buffer(i8, i8);
    }

    public final Observable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final Observable<T> cacheWithInitialCapacity(int i8) {
        ObjectHelper.f(i8, "initialCapacity");
        return RxJavaPlugins.n(new ObservableCache(this, i8));
    }

    public final <U> Observable<U> cast(Class<U> cls) {
        ObjectHelper.e(cls, "clazz is null");
        return (Observable<U>) map(Functions.d(cls));
    }

    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.e(callable, "initialValueSupplier is null");
        ObjectHelper.e(biConsumer, "collector is null");
        return RxJavaPlugins.o(new ObservableCollectSingle(this, callable, biConsumer));
    }

    public final <U> Single<U> collectInto(U u7, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.e(u7, "initialValue is null");
        return collect(Functions.k(u7), biConsumer);
    }

    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return wrap(((ObservableTransformer) ObjectHelper.e(observableTransformer, "composer is null")).a(this));
    }

    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, Api.BaseClientBuilder.API_PRIORITY_OTHER, bufferSize());
    }

    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z7) {
        return concatMapEagerDelayError(function, Api.BaseClientBuilder.API_PRIORITY_OTHER, bufferSize(), z7);
    }

    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableFlattenIterable(this, function));
    }

    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return concat(this, observableSource);
    }

    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.e(obj, "element is null");
        return any(Functions.h(obj));
    }

    public final Single<Long> count() {
        return RxJavaPlugins.o(new ObservableCountSingle(this));
    }

    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.e(function, "debounceSelector is null");
        return RxJavaPlugins.n(new ObservableDebounce(this, function));
    }

    public final Observable<T> defaultIfEmpty(T t7) {
        ObjectHelper.e(t7, "defaultItem is null");
        return switchIfEmpty(just(t7));
    }

    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.e(function, "itemDelay is null");
        return (Observable<T>) flatMap(ObservableInternalHelper.c(function));
    }

    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return RxJavaPlugins.n(new ObservableDelaySubscriptionOther(this, observableSource));
    }

    @Deprecated
    public final <T2> Observable<T2> dematerialize() {
        return RxJavaPlugins.n(new ObservableDematerialize(this, Functions.i()));
    }

    public final Observable<T> distinct() {
        return distinct(Functions.i(), Functions.f());
    }

    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.i());
    }

    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.e(consumer, "onAfterNext is null");
        return RxJavaPlugins.n(new ObservableDoAfterNext(this, consumer));
    }

    public final Observable<T> doAfterTerminate(Action action) {
        ObjectHelper.e(action, "onFinally is null");
        return doOnEach(Functions.g(), Functions.g(), Functions.f47618c, action);
    }

    public final Observable<T> doFinally(Action action) {
        ObjectHelper.e(action, "onFinally is null");
        return RxJavaPlugins.n(new ObservableDoFinally(this, action));
    }

    public final Observable<T> doOnComplete(Action action) {
        return doOnEach(Functions.g(), Functions.g(), action, Functions.f47618c);
    }

    public final Observable<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.g(), action);
    }

    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer<? super T> g8 = Functions.g();
        Action action = Functions.f47618c;
        return doOnEach(g8, consumer, action, action);
    }

    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.e(consumer, "onSubscribe is null");
        ObjectHelper.e(action, "onDispose is null");
        return RxJavaPlugins.n(new ObservableDoOnLifecycle(this, consumer, action));
    }

    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        Consumer<? super Throwable> g8 = Functions.g();
        Action action = Functions.f47618c;
        return doOnEach(consumer, g8, action, action);
    }

    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.f47618c);
    }

    public final Observable<T> doOnTerminate(Action action) {
        ObjectHelper.e(action, "onTerminate is null");
        return doOnEach(Functions.g(), Functions.a(action), action, Functions.f47618c);
    }

    public final Maybe<T> elementAt(long j8) {
        if (j8 >= 0) {
            return RxJavaPlugins.m(new ObservableElementAtMaybe(this, j8));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j8);
    }

    public final Single<T> elementAtOrError(long j8) {
        if (j8 >= 0) {
            return RxJavaPlugins.o(new ObservableElementAtSingle(this, j8, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j8);
    }

    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.n(new ObservableFilter(this, predicate));
    }

    public final Single<T> first(T t7) {
        return elementAt(0L, t7);
    }

    public final Maybe<T> firstElement() {
        return elementAt(0L);
    }

    public final Single<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap((Function) function, false);
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableFlattenIterable(this, function));
    }

    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.f47621f, Functions.f47618c);
    }

    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.i(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        ObjectHelper.e(observableSource, "other is null");
        ObjectHelper.e(function, "leftEnd is null");
        ObjectHelper.e(function2, "rightEnd is null");
        ObjectHelper.e(biFunction, "resultSelector is null");
        return RxJavaPlugins.n(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    public final Observable<T> hide() {
        return RxJavaPlugins.n(new ObservableHide(this));
    }

    public final Completable ignoreElements() {
        return RxJavaPlugins.k(new ObservableIgnoreElementsCompletable(this));
    }

    public final Single<Boolean> isEmpty() {
        return all(Functions.b());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.e(observableSource, "other is null");
        ObjectHelper.e(function, "leftEnd is null");
        ObjectHelper.e(function2, "rightEnd is null");
        ObjectHelper.e(biFunction, "resultSelector is null");
        return RxJavaPlugins.n(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    public final Single<T> last(T t7) {
        ObjectHelper.e(t7, "defaultItem is null");
        return RxJavaPlugins.o(new ObservableLastSingle(this, t7));
    }

    public final Maybe<T> lastElement() {
        return RxJavaPlugins.m(new ObservableLastMaybe(this));
    }

    public final Single<T> lastOrError() {
        return RxJavaPlugins.o(new ObservableLastSingle(this, null));
    }

    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.e(observableOperator, "lifter is null");
        return RxJavaPlugins.n(new ObservableLift(this, observableOperator));
    }

    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableMap(this, function));
    }

    public final Observable<Notification<T>> materialize() {
        return RxJavaPlugins.n(new ObservableMaterialize(this));
    }

    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return merge(this, observableSource);
    }

    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    public final <U> Observable<U> ofType(Class<U> cls) {
        ObjectHelper.e(cls, "clazz is null");
        return filter(Functions.j(cls)).cast(cls);
    }

    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.e(function, "resumeFunction is null");
        return RxJavaPlugins.n(new ObservableOnErrorNext(this, function, false));
    }

    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.e(function, "valueSupplier is null");
        return RxJavaPlugins.n(new ObservableOnErrorReturn(this, function));
    }

    public final Observable<T> onErrorReturnItem(T t7) {
        ObjectHelper.e(t7, "item is null");
        return onErrorReturn(Functions.l(t7));
    }

    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "next is null");
        return RxJavaPlugins.n(new ObservableOnErrorNext(this, Functions.l(observableSource), true));
    }

    public final Observable<T> onTerminateDetach() {
        return RxJavaPlugins.n(new ObservableDetach(this));
    }

    public final ConnectableObservable<T> publish() {
        return ObservablePublish.f(this);
    }

    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.e(biFunction, "reducer is null");
        return RxJavaPlugins.m(new ObservableReduceMaybe(this, biFunction));
    }

    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.e(callable, "seedSupplier is null");
        ObjectHelper.e(biFunction, "reducer is null");
        return RxJavaPlugins.o(new ObservableReduceWithSingle(this, callable, biFunction));
    }

    public final Observable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.e(booleanSupplier, "stop is null");
        return RxJavaPlugins.n(new ObservableRepeatUntil(this, booleanSupplier));
    }

    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.e(function, "handler is null");
        return RxJavaPlugins.n(new ObservableRepeatWhen(this, function));
    }

    public final ConnectableObservable<T> replay() {
        return ObservableReplay.j(this);
    }

    public final Observable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.c());
    }

    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.e(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.t(booleanSupplier));
    }

    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.e(function, "handler is null");
        return RxJavaPlugins.n(new ObservableRetryWhen(this, function));
    }

    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.e(observer, "observer is null");
        if (observer instanceof SafeObserver) {
            subscribe(observer);
        } else {
            subscribe(new SafeObserver(observer));
        }
    }

    public final Observable<T> sample(long j8, TimeUnit timeUnit) {
        return sample(j8, timeUnit, Schedulers.a());
    }

    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.e(biFunction, "accumulator is null");
        return RxJavaPlugins.n(new ObservableScan(this, biFunction));
    }

    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.e(callable, "seedSupplier is null");
        ObjectHelper.e(biFunction, "accumulator is null");
        return RxJavaPlugins.n(new ObservableScanSeed(this, callable, biFunction));
    }

    public final Observable<T> serialize() {
        return RxJavaPlugins.n(new ObservableSerialized(this));
    }

    public final Observable<T> share() {
        return publish().e();
    }

    public final Single<T> single(T t7) {
        ObjectHelper.e(t7, "defaultItem is null");
        return RxJavaPlugins.o(new ObservableSingleSingle(this, t7));
    }

    public final Maybe<T> singleElement() {
        return RxJavaPlugins.m(new ObservableSingleMaybe(this));
    }

    public final Single<T> singleOrError() {
        return RxJavaPlugins.o(new ObservableSingleSingle(this, null));
    }

    public final Observable<T> skip(long j8) {
        if (j8 <= 0) {
            return RxJavaPlugins.n(this);
        }
        return RxJavaPlugins.n(new ObservableSkip(this, j8));
    }

    public final Observable<T> skipLast(int i8) {
        if (i8 >= 0) {
            if (i8 == 0) {
                return RxJavaPlugins.n(this);
            }
            return RxJavaPlugins.n(new ObservableSkipLast(this, i8));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i8);
    }

    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return RxJavaPlugins.n(new ObservableSkipUntil(this, observableSource));
    }

    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.n(new ObservableSkipWhile(this, predicate));
    }

    public final Observable<T> sorted() {
        return toList().R().map(Functions.m(Functions.n())).flatMapIterable(Functions.i());
    }

    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final Observable<T> startWithArray(T... tArr) {
        Observable fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return RxJavaPlugins.n(this);
        }
        return concatArray(fromArray, this);
    }

    public final Disposable subscribe() {
        return subscribe(Functions.g(), Functions.f47621f, Functions.f47618c, Functions.g());
    }

    protected abstract void subscribeActual(Observer<? super T> observer);

    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableSubscribeOn(this, scheduler));
    }

    public final <E extends Observer<? super T>> E subscribeWith(E e8) {
        subscribe(e8);
        return e8;
    }

    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return RxJavaPlugins.n(new ObservableSwitchIfEmpty(this, observableSource));
    }

    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    public final Completable switchMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.k(new ObservableSwitchMapCompletable(this, function, false));
    }

    public final Completable switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.k(new ObservableSwitchMapCompletable(this, function, true));
    }

    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    public final <R> Observable<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableSwitchMapMaybe(this, function, false));
    }

    public final <R> Observable<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableSwitchMapMaybe(this, function, true));
    }

    public final <R> Observable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableSwitchMapSingle(this, function, false));
    }

    public final <R> Observable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableSwitchMapSingle(this, function, true));
    }

    public final Observable<T> take(long j8) {
        if (j8 >= 0) {
            return RxJavaPlugins.n(new ObservableTake(this, j8));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j8);
    }

    public final Observable<T> takeLast(int i8) {
        if (i8 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i8);
        } else if (i8 == 0) {
            return RxJavaPlugins.n(new ObservableIgnoreElements(this));
        } else {
            if (i8 == 1) {
                return RxJavaPlugins.n(new ObservableTakeLastOne(this));
            }
            return RxJavaPlugins.n(new ObservableTakeLast(this, i8));
        }
    }

    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return RxJavaPlugins.n(new ObservableTakeUntil(this, observableSource));
    }

    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "predicate is null");
        return RxJavaPlugins.n(new ObservableTakeWhile(this, predicate));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final Observable<T> throttleFirst(long j8, TimeUnit timeUnit) {
        return throttleFirst(j8, timeUnit, Schedulers.a());
    }

    public final Observable<T> throttleLast(long j8, TimeUnit timeUnit) {
        return sample(j8, timeUnit);
    }

    public final Observable<T> throttleLatest(long j8, TimeUnit timeUnit) {
        return throttleLatest(j8, timeUnit, Schedulers.a(), false);
    }

    public final Observable<T> throttleWithTimeout(long j8, TimeUnit timeUnit) {
        return debounce(j8, timeUnit);
    }

    public final Observable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return timeout0(null, function, null);
    }

    public final Observable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    public final <R> R to(Function<? super Observable<T>, R> function) {
        try {
            return (R) ((Function) ObjectHelper.e(function, "converter is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.b(th);
            throw ExceptionHelper.e(th);
        }
    }

    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i8 = AnonymousClass1.f47572a[backpressureStrategy.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        return flowableFromObservable.O();
                    }
                    return RxJavaPlugins.l(new FlowableOnBackpressureError(flowableFromObservable));
                }
                return flowableFromObservable;
            }
            return flowableFromObservable.R();
        }
        return flowableFromObservable.Q();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    public final Single<List<T>> toList() {
        return toList(16);
    }

    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.e(function, "keySelector is null");
        return (Single<Map<K, T>>) collect(HashMapSupplier.a(), Functions.D(function));
    }

    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return (Single<Map<K, Collection<T>>>) toMultimap(function, Functions.i(), HashMapSupplier.a(), ArrayListSupplier.e());
    }

    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.o());
    }

    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableUnsubscribeOn(this, scheduler));
    }

    public final Observable<Observable<T>> window(long j8) {
        return window(j8, j8, bufferSize());
    }

    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.e(observableSource, "other is null");
        ObjectHelper.e(biFunction, "combiner is null");
        return RxJavaPlugins.n(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.e(iterable, "other is null");
        ObjectHelper.e(biFunction, "zipper is null");
        return RxJavaPlugins.n(new ObservableZipIterable(this, iterable, biFunction));
    }

    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i8, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i8);
    }

    public static <T> Observable<T> concatArrayEager(int i8, int i9, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.i(), i8, i9, false);
    }

    public static <T> Observable<T> concatArrayEagerDelayError(int i8, int i9, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.i(), i8, i9, true);
    }

    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i8, int i9) {
        return wrap(observableSource).concatMapEager(Functions.i(), i8, i9);
    }

    public static Observable<Long> interval(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableInterval(Math.max(0L, j8), Math.max(0L, j9), timeUnit, scheduler));
    }

    public static Observable<Long> intervalRange(long j8, long j9, long j10, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        int i8 = (j9 > 0L ? 1 : (j9 == 0L ? 0 : -1));
        if (i8 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j9);
        } else if (i8 == 0) {
            return empty().delay(j10, timeUnit, scheduler);
        } else {
            long j12 = j8 + (j9 - 1);
            if (j8 > 0 && j12 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            ObjectHelper.e(timeUnit, "unit is null");
            ObjectHelper.e(scheduler, "scheduler is null");
            return RxJavaPlugins.n(new ObservableIntervalRange(j8, j12, Math.max(0L, j10), Math.max(0L, j11), timeUnit, scheduler));
        }
    }

    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.i());
    }

    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), observableSourceArr.length);
    }

    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.i(), true, observableSourceArr.length);
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i8, int i9) {
        return fromIterable(iterable).flatMap(Functions.i(), true, i8, i9);
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i8) {
        ObjectHelper.e(observableSource, "sources is null");
        ObjectHelper.f(i8, "prefetch");
        return RxJavaPlugins.n(new ObservableSwitchMap(observableSource, Functions.i(), i8, true));
    }

    public static Observable<Long> timer(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableTimer(Math.max(j8, 0L), timeUnit, scheduler));
    }

    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z7) {
        ObjectHelper.e(callable, "resourceSupplier is null");
        ObjectHelper.e(function, "sourceSupplier is null");
        ObjectHelper.e(consumer, "disposer is null");
        return RxJavaPlugins.n(new ObservableUsing(callable, function, consumer, z7));
    }

    public final Iterable<T> blockingIterable(int i8) {
        ObjectHelper.f(i8, "bufferSize");
        return new BlockingObservableIterable(this, i8);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.c(this, consumer, Functions.f47621f, Functions.f47618c);
    }

    public final Observable<List<T>> buffer(int i8, int i9) {
        return (Observable<List<T>>) buffer(i8, i9, ArrayListSupplier.c());
    }

    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.a(call, function);
        }
        return RxJavaPlugins.n(new ObservableConcatMap(this, function, i8, ErrorMode.IMMEDIATE));
    }

    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "capacityHint");
        return RxJavaPlugins.k(new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i8));
    }

    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z7) {
        return concatMapCompletableDelayError(function, z7, 2);
    }

    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i8, boolean z7) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.a(call, function);
        }
        return RxJavaPlugins.n(new ObservableConcatMap(this, function, i8, z7 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i8, int i9) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "maxConcurrency");
        ObjectHelper.f(i9, "prefetch");
        return RxJavaPlugins.n(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i8, i9));
    }

    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i8, int i9, boolean z7) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "maxConcurrency");
        ObjectHelper.f(i9, "prefetch");
        return RxJavaPlugins.n(new ObservableConcatMapEager(this, function, z7 ? ErrorMode.END : ErrorMode.BOUNDARY, i8, i9));
    }

    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        return RxJavaPlugins.n(new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i8));
    }

    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7) {
        return concatMapMaybeDelayError(function, z7, 2);
    }

    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        return RxJavaPlugins.n(new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i8));
    }

    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7) {
        return concatMapSingleDelayError(function, z7, 2);
    }

    public final <R> Observable<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.e(function, "selector is null");
        return RxJavaPlugins.n(new ObservableDematerialize(this, function));
    }

    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.f());
    }

    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.e(function, "keySelector is null");
        return RxJavaPlugins.n(new ObservableDistinctUntilChanged(this, function, ObjectHelper.d()));
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z7) {
        return flatMap(function, z7, (int) Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z7) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.k(new ObservableFlatMapCompletableCompletable(this, function, z7));
    }

    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableFlatMapMaybe(this, function, z7));
    }

    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableFlatMapSingle(this, function, z7));
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.f47618c);
    }

    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z7) {
        return (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.i(), z7, bufferSize());
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z7) {
        return observeOn(scheduler, z7, bufferSize());
    }

    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.e(function, "selector is null");
        return RxJavaPlugins.n(new ObservablePublishSelector(this, function));
    }

    public final Observable<T> repeat(long j8) {
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            if (i8 == 0) {
                return empty();
            }
            return RxJavaPlugins.n(new ObservableRepeat(this, j8));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j8);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.e(function, "selector is null");
        return ObservableReplay.k(ObservableInternalHelper.g(this), function);
    }

    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.e(biPredicate, "predicate is null");
        return RxJavaPlugins.n(new ObservableRetryBiPredicate(this, biPredicate));
    }

    public final Observable<T> sample(long j8, TimeUnit timeUnit, boolean z7) {
        return sample(j8, timeUnit, Schedulers.a(), z7);
    }

    public final Observable<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.e(comparator, "sortFunction is null");
        return toList().R().map(Functions.m(comparator)).flatMapIterable(Functions.i());
    }

    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.f47621f, Functions.f47618c, Functions.g());
    }

    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.a(call, function);
        }
        return RxJavaPlugins.n(new ObservableSwitchMap(this, function, i8, false));
    }

    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.a(call, function);
        }
        return RxJavaPlugins.n(new ObservableSwitchMap(this, function, i8, true));
    }

    public final Observable<T> throttleFirst(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableThrottleFirstTimed(this, j8, timeUnit, scheduler));
    }

    public final Observable<T> throttleLast(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j8, timeUnit, scheduler);
    }

    public final Observable<T> throttleLatest(long j8, TimeUnit timeUnit, boolean z7) {
        return throttleLatest(j8, timeUnit, Schedulers.a(), z7);
    }

    public final Observable<T> throttleWithTimeout(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j8, timeUnit, scheduler);
    }

    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return timeout0(null, function, observableSource);
    }

    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    public final Single<List<T>> toList(int i8) {
        ObjectHelper.f(i8, "capacityHint");
        return RxJavaPlugins.o(new ObservableToListSingle(this, i8));
    }

    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.e(comparator, "comparator is null");
        return (Single<List<T>>) toList().x(Functions.m(comparator));
    }

    public final Observable<Observable<T>> window(long j8, long j9) {
        return window(j8, j9, bufferSize());
    }

    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i8) {
        ObjectHelper.e(iterable, "sources is null");
        ObjectHelper.e(function, "combiner is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableCombineLatest(null, iterable, function, i8 << 1, false));
    }

    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i8) {
        ObjectHelper.f(i8, "bufferSize");
        ObjectHelper.e(function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.n(new ObservableCombineLatest(observableSourceArr, null, function, i8 << 1, true));
    }

    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> Observable<T> error(Throwable th) {
        ObjectHelper.e(th, "exception is null");
        return error(Functions.k(th));
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j8, TimeUnit timeUnit) {
        ObjectHelper.e(future, "future is null");
        ObjectHelper.e(timeUnit, "unit is null");
        return RxJavaPlugins.n(new ObservableFromFuture(future, j8, timeUnit));
    }

    public static <T> Observable<T> just(T t7, T t8) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        return fromArray(t7, t8);
    }

    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i8) {
        return fromIterable(iterable).flatMap(Functions.i(), i8);
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i8) {
        return fromIterable(iterable).flatMap(Functions.i(), true, i8);
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i8) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(biPredicate, "isEqual is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.o(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i8));
    }

    public final T blockingSingle(T t7) {
        return single(t7).d();
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.c(this, consumer, consumer2, Functions.f47618c);
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(int i8, int i9, Callable<U> callable) {
        ObjectHelper.f(i8, "count");
        ObjectHelper.f(i9, "skip");
        ObjectHelper.e(callable, "bufferSupplier is null");
        return RxJavaPlugins.n(new ObservableBuffer(this, i8, i9, callable));
    }

    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z7, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        return RxJavaPlugins.k(new ObservableConcatMapCompletable(this, function, z7 ? ErrorMode.END : ErrorMode.BOUNDARY, i8));
    }

    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        return (Observable<U>) concatMap(ObservableInternalHelper.a(function), i8);
    }

    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        return RxJavaPlugins.n(new ObservableConcatMapMaybe(this, function, z7 ? ErrorMode.END : ErrorMode.BOUNDARY, i8));
    }

    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7, int i8) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "prefetch");
        return RxJavaPlugins.n(new ObservableConcatMapSingle(this, function, z7 ? ErrorMode.END : ErrorMode.BOUNDARY, i8));
    }

    public final Observable<T> concatWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.e(singleSource, "other is null");
        return RxJavaPlugins.n(new ObservableConcatWithSingle(this, singleSource));
    }

    public final Observable<T> debounce(long j8, TimeUnit timeUnit) {
        return debounce(j8, timeUnit, Schedulers.a());
    }

    public final Observable<T> delay(long j8, TimeUnit timeUnit) {
        return delay(j8, timeUnit, Schedulers.a(), false);
    }

    public final Observable<T> delaySubscription(long j8, TimeUnit timeUnit) {
        return delaySubscription(j8, timeUnit, Schedulers.a());
    }

    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.e(function, "keySelector is null");
        ObjectHelper.e(callable, "collectionSupplier is null");
        return RxJavaPlugins.n(new ObservableDistinct(this, function, callable));
    }

    public final Single<T> elementAt(long j8, T t7) {
        if (j8 >= 0) {
            ObjectHelper.e(t7, "defaultItem is null");
            return RxJavaPlugins.o(new ObservableElementAtSingle(this, j8, t7));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j8);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z7, int i8) {
        return flatMap(function, z7, i8, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.e(biFunction, "resultSelector is null");
        return (Observable<V>) flatMap(ObservableInternalHelper.a(function), biFunction, false, bufferSize(), bufferSize());
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.e(predicate, "onNext is null");
        ObjectHelper.e(consumer, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    public final Observable<T> mergeWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.e(singleSource, "other is null");
        return RxJavaPlugins.n(new ObservableMergeWithSingle(this, singleSource));
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z7, int i8) {
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableObserveOn(this, scheduler, z7, i8));
    }

    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "next is null");
        return onErrorResumeNext(Functions.l(observableSource));
    }

    public final <R> Single<R> reduce(R r7, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.e(r7, "seed is null");
        ObjectHelper.e(biFunction, "reducer is null");
        return RxJavaPlugins.o(new ObservableReduceSeedSingle(this, r7, biFunction));
    }

    public final Observable<T> sample(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableSampleTimed(this, j8, timeUnit, scheduler, false));
    }

    public final <R> Observable<R> scan(R r7, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.e(r7, "initialValue is null");
        return scanWith(Functions.k(r7), biFunction);
    }

    public final Observable<T> skip(long j8, TimeUnit timeUnit) {
        return skipUntil(timer(j8, timeUnit));
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.f47618c, Functions.g());
    }

    public final Observable<T> take(long j8, TimeUnit timeUnit) {
        return takeUntil(timer(j8, timeUnit));
    }

    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.e(predicate, "stopPredicate is null");
        return RxJavaPlugins.n(new ObservableTakeUntilPredicate(this, predicate));
    }

    public final TestObserver<T> test(boolean z7) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z7) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final Observable<T> throttleLatest(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return throttleLatest(j8, timeUnit, scheduler, false);
    }

    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.a());
    }

    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.a());
    }

    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.e(function, "keySelector is null");
        ObjectHelper.e(function2, "valueSelector is null");
        return (Single<Map<K, V>>) collect(HashMapSupplier.a(), Functions.E(function, function2));
    }

    public final Observable<Observable<T>> window(long j8, long j9, int i8) {
        ObjectHelper.g(j8, "count");
        ObjectHelper.g(j9, "skip");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableWindow(this, j8, j9, i8));
    }

    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i8) {
        ObjectHelper.e(observableSource, "sources is null");
        ObjectHelper.f(i8, "prefetch");
        return RxJavaPlugins.n(new ObservableConcatMap(observableSource, Functions.i(), i8, ErrorMode.IMMEDIATE));
    }

    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i8, boolean z7) {
        ObjectHelper.e(observableSource, "sources is null");
        ObjectHelper.f(i8, "prefetch is null");
        return RxJavaPlugins.n(new ObservableConcatMap(observableSource, Functions.i(), i8, z7 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i8, int i9) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.i(), i8, i9, false);
    }

    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.e(observableSource, "sources is null");
        return RxJavaPlugins.n(new ObservableFlatMap(observableSource, Functions.i(), false, Api.BaseClientBuilder.API_PRIORITY_OTHER, bufferSize()));
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.e(observableSource, "sources is null");
        return RxJavaPlugins.n(new ObservableFlatMap(observableSource, Functions.i(), true, Api.BaseClientBuilder.API_PRIORITY_OTHER, bufferSize()));
    }

    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.e(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.n(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.e(function, "zipper is null");
        ObjectHelper.e(observableSource, "sources is null");
        return RxJavaPlugins.n(new ObservableToList(observableSource, 16).flatMap(ObservableInternalHelper.n(function)));
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.c(this, consumer, consumer2, action);
    }

    public final Observable<T> debounce(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableDebounceTimed(this, j8, timeUnit, scheduler));
    }

    public final Observable<T> delay(long j8, TimeUnit timeUnit, boolean z7) {
        return delay(j8, timeUnit, Schedulers.a(), z7);
    }

    public final Observable<T> delaySubscription(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j8, timeUnit, scheduler));
    }

    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.e(biPredicate, "comparer is null");
        return RxJavaPlugins.n(new ObservableDistinctUntilChanged(this, Functions.i(), biPredicate));
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z7, int i8, int i9) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.f(i8, "maxConcurrency");
        ObjectHelper.f(i9, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.a(call, function);
        }
        return RxJavaPlugins.n(new ObservableFlatMap(this, function, z7, i8, i9));
    }

    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z7) {
        return groupBy(function, function2, z7, bufferSize());
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i8) {
        ObjectHelper.e(function, "selector is null");
        ObjectHelper.f(i8, "bufferSize");
        return ObservableReplay.k(ObservableInternalHelper.h(this, i8), function);
    }

    public final Observable<T> retry(long j8) {
        return retry(j8, Functions.c());
    }

    public final Observable<T> skip(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j8, timeUnit, scheduler));
    }

    public final Observable<T> skipLast(long j8, TimeUnit timeUnit) {
        return skipLast(j8, timeUnit, Schedulers.e(), false, bufferSize());
    }

    public final Observable<T> startWith(T t7) {
        ObjectHelper.e(t7, "item is null");
        return concatArray(just(t7), this);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.g());
    }

    public final Observable<T> take(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j8, timeUnit, scheduler));
    }

    public final Observable<T> throttleLatest(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableThrottleLatest(this, j8, timeUnit, scheduler, z7));
    }

    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableTimeInterval(this, timeUnit, scheduler));
    }

    public final Observable<T> timeout(long j8, TimeUnit timeUnit) {
        return timeout0(j8, timeUnit, null, Schedulers.a());
    }

    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return (Observable<Timed<T>>) map(Functions.u(timeUnit, scheduler));
    }

    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.e(callable, "collectionSupplier is null");
        return RxJavaPlugins.o(new ObservableToListSingle(this, callable));
    }

    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i8) {
        ObjectHelper.e(comparator, "comparator is null");
        return (Single<List<T>>) toList(i8).x(Functions.m(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.e(observableSource, "o1 is null");
        ObjectHelper.e(observableSource2, "o2 is null");
        ObjectHelper.e(function3, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2}, Functions.w(function3));
    }

    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.e(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.e(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.l(biConsumer), Functions.g());
    }

    public static Observable<Long> interval(long j8, TimeUnit timeUnit) {
        return interval(j8, j8, timeUnit, Schedulers.a());
    }

    public final T blockingFirst(T t7) {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T a8 = blockingFirstObserver.a();
        return a8 != null ? a8 : t7;
    }

    public final T blockingLast(T t7) {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T a8 = blockingLastObserver.a();
        return a8 != null ? a8 : t7;
    }

    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.b(this, observer);
    }

    public final Observable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.e(maybeSource, "other is null");
        return RxJavaPlugins.n(new ObservableConcatWithMaybe(this, maybeSource));
    }

    public final Observable<T> delay(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j8, timeUnit, scheduler, false);
    }

    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z7, int i8) {
        ObjectHelper.e(function, "keySelector is null");
        ObjectHelper.e(function2, "valueSelector is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableGroupBy(this, function, function2, i8, z7));
    }

    public final Observable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.e(maybeSource, "other is null");
        return RxJavaPlugins.n(new ObservableMergeWithMaybe(this, maybeSource));
    }

    public final Observable<T> retry(long j8, Predicate<? super Throwable> predicate) {
        if (j8 >= 0) {
            ObjectHelper.e(predicate, "predicate is null");
            return RxJavaPlugins.n(new ObservableRetryPredicate(this, j8, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j8);
    }

    public final Observable<T> skipLast(long j8, TimeUnit timeUnit, boolean z7) {
        return skipLast(j8, timeUnit, Schedulers.e(), z7, bufferSize());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.e(consumer, "onNext is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        ObjectHelper.e(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final Observable<T> takeLast(long j8, long j9, TimeUnit timeUnit) {
        return takeLast(j8, j9, timeUnit, Schedulers.e(), false, bufferSize());
    }

    public final Observable<T> timeout(long j8, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return timeout0(j8, timeUnit, observableSource, Schedulers.a());
    }

    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.a(), ArrayListSupplier.e());
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return fromFuture(future, j8, timeUnit).subscribeOn(scheduler);
    }

    public static Observable<Long> interval(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j8, j8, timeUnit, scheduler);
    }

    public static <T> Observable<T> just(T t7, T t8, T t9) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        return fromArray(t7, t8, t9);
    }

    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i8) {
        ObjectHelper.e(observableSource, "sources is null");
        ObjectHelper.f(i8, "maxConcurrency");
        return RxJavaPlugins.n(new ObservableFlatMap(observableSource, Functions.i(), false, i8, bufferSize()));
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i8) {
        ObjectHelper.e(observableSource, "sources is null");
        ObjectHelper.f(i8, "maxConcurrency");
        return RxJavaPlugins.n(new ObservableFlatMap(observableSource, Functions.i(), true, i8, bufferSize()));
    }

    public final Observable<T> delay(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableDelay(this, j8, timeUnit, scheduler, z7));
    }

    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.e(consumer, "onNotification is null");
        return doOnEach(Functions.r(consumer), Functions.q(consumer), Functions.p(consumer), Functions.f47618c);
    }

    public final Observable<T> sample(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableSampleTimed(this, j8, timeUnit, scheduler, z7));
    }

    public final Observable<T> skipLast(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j8, timeUnit, scheduler, false, bufferSize());
    }

    public final Observable<T> takeLast(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j8, j9, timeUnit, scheduler, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.e(function, "keySelector is null");
        ObjectHelper.e(function2, "valueSelector is null");
        ObjectHelper.e(callable, "mapSupplier is null");
        return (Single<Map<K, V>>) collect(callable, Functions.E(function, function2));
    }

    public final Single<List<T>> toSortedList(int i8) {
        return toSortedList(Functions.o(), i8);
    }

    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z7) {
        return zip(this, observableSource, biFunction, z7);
    }

    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.e(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.l(biConsumer), consumer);
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(int i8, Callable<U> callable) {
        return buffer(i8, i8, callable);
    }

    public final Observable<T> concatWith(CompletableSource completableSource) {
        ObjectHelper.e(completableSource, "other is null");
        return RxJavaPlugins.n(new ObservableConcatWithCompletable(this, completableSource));
    }

    public final Observable<T> mergeWith(CompletableSource completableSource) {
        ObjectHelper.e(completableSource, "other is null");
        return RxJavaPlugins.n(new ObservableMergeWithCompletable(this, completableSource));
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i8, long j8, TimeUnit timeUnit) {
        return replay(function, i8, j8, timeUnit, Schedulers.a());
    }

    public final Observable<T> skipLast(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        return skipLast(j8, timeUnit, scheduler, z7, bufferSize());
    }

    public final Observable<T> takeLast(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler, boolean z7, int i8) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.f(i8, "bufferSize");
        if (j8 >= 0) {
            return RxJavaPlugins.n(new ObservableTakeLastTimed(this, j8, j9, timeUnit, scheduler, i8, z7));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j8);
    }

    public final Observable<T> timeout(long j8, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.e(observableSource, "other is null");
        return timeout0(j8, timeUnit, observableSource, scheduler);
    }

    public final Observable<Observable<T>> window(long j8, long j9, TimeUnit timeUnit) {
        return window(j8, j9, timeUnit, Schedulers.a(), bufferSize());
    }

    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z7, int i8) {
        return zip(this, observableSource, biFunction, z7, i8);
    }

    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i8) {
        ObjectHelper.e(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.e(function, "combiner is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableCombineLatest(observableSourceArr, null, function, i8 << 1, false));
    }

    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i8) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.d(), i8);
    }

    public final Observable<List<T>> buffer(long j8, long j9, TimeUnit timeUnit) {
        return (Observable<List<T>>) buffer(j8, j9, timeUnit, Schedulers.a(), ArrayListSupplier.c());
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i8, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(function, "selector is null");
        ObjectHelper.f(i8, "bufferSize");
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return ObservableReplay.k(ObservableInternalHelper.i(this, i8, j8, timeUnit, scheduler), function);
    }

    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    public final Observable<T> skipLast(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7, int i8) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableSkipLastTimed(this, j8, timeUnit, scheduler, i8 << 1, z7));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.e(function, "keySelector is null");
        ObjectHelper.e(function2, "valueSelector is null");
        ObjectHelper.e(callable, "mapSupplier is null");
        ObjectHelper.e(function3, "collectionFactory is null");
        return (Single<Map<K, Collection<V>>>) collect(callable, Functions.F(function, function2, function3));
    }

    public final Observable<Observable<T>> window(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j8, j9, timeUnit, scheduler, bufferSize());
    }

    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i8) {
        ObjectHelper.e(iterable, "sources is null");
        ObjectHelper.e(function, "combiner is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableCombineLatest(null, iterable, function, i8 << 1, true));
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.g());
    }

    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.i(), false, 2);
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.i(), true, 2);
    }

    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        return zipArray(Functions.v(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    public final Observable<List<T>> buffer(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) buffer(j8, j9, timeUnit, scheduler, ArrayListSupplier.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> Observable<T> delay(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        return delaySubscription(observableSource).delay(function);
    }

    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.e(observableSource, "sampler is null");
        return RxJavaPlugins.n(new ObservableSampleWithObservable(this, observableSource, false));
    }

    public final Observable<T> timeout(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j8, timeUnit, null, scheduler);
    }

    public final Observable<Observable<T>> window(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler, int i8) {
        ObjectHelper.g(j8, "timespan");
        ObjectHelper.g(j9, "timeskip");
        ObjectHelper.f(i8, "bufferSize");
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.e(timeUnit, "unit is null");
        return RxJavaPlugins.n(new ObservableWindowTimed(this, j8, j9, timeUnit, scheduler, Long.MAX_VALUE, i8, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.e(observableSource, "o1 is null");
        ObjectHelper.e(observableSource2, "o2 is null");
        ObjectHelper.e(observableSource3, "o3 is null");
        ObjectHelper.e(function4, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.x(function4));
    }

    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.e(callable, "initialState is null");
        ObjectHelper.e(biFunction, "generator is null");
        ObjectHelper.e(consumer, "disposeState is null");
        return RxJavaPlugins.n(new ObservableGenerate(callable, biFunction, consumer));
    }

    public static <T> Observable<T> just(T t7, T t8, T t9, T t10) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        ObjectHelper.e(t10, "item4 is null");
        return fromArray(t7, t8, t9, t10);
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.e(callable, "bufferSupplier is null");
        return RxJavaPlugins.n(new ObservableBufferTimed(this, j8, j9, timeUnit, scheduler, callable, Api.BaseClientBuilder.API_PRIORITY_OTHER, false));
    }

    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.e(observableSource, "firstTimeoutIndicator is null");
        return timeout0(observableSource, function, null);
    }

    public final Observable<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.e(observer, "observer is null");
        return doOnEach(ObservableInternalHelper.f(observer), ObservableInternalHelper.e(observer), ObservableInternalHelper.d(observer), Functions.f47618c);
    }

    public final <U> Observable<T> sample(ObservableSource<U> observableSource, boolean z7) {
        ObjectHelper.e(observableSource, "sampler is null");
        return RxJavaPlugins.n(new ObservableSampleWithObservable(this, observableSource, z7));
    }

    @Override // io.reactivex.ObservableSource
    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.e(observer, "observer is null");
        try {
            Observer<? super T> y7 = RxJavaPlugins.y(this, observer);
            ObjectHelper.e(y7, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(y7);
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

    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.i(), false, 3);
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.i(), true, 3);
    }

    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z7) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        return zipArray(Functions.v(biFunction), z7, bufferSize(), observableSource, observableSource2);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.e(function, "onNextMapper is null");
        ObjectHelper.e(function2, "onErrorMapper is null");
        ObjectHelper.e(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable));
    }

    public final Observable<T> takeLast(long j8, TimeUnit timeUnit) {
        return takeLast(j8, timeUnit, Schedulers.e(), false, bufferSize());
    }

    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.e(observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.e(observableSource2, "other is null");
        return timeout0(observableSource, function, observableSource2);
    }

    public final Observable<T> takeLast(long j8, TimeUnit timeUnit, boolean z7) {
        return takeLast(j8, timeUnit, Schedulers.e(), z7, bufferSize());
    }

    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.e());
    }

    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        return combineLatest(Functions.v(biFunction), bufferSize(), observableSource, observableSource2);
    }

    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    public final Observable<List<T>> buffer(long j8, TimeUnit timeUnit) {
        return buffer(j8, timeUnit, Schedulers.a(), (int) Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i8, Scheduler scheduler) {
        ObjectHelper.e(function, "selector is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.f(i8, "bufferSize");
        return ObservableReplay.k(ObservableInternalHelper.h(this, i8), ObservableInternalHelper.k(function, scheduler));
    }

    public final Observable<T> takeLast(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j8, timeUnit, scheduler, false, bufferSize());
    }

    public static <T> Observable<T> just(T t7, T t8, T t9, T t10, T t11) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        ObjectHelper.e(t10, "item4 is null");
        ObjectHelper.e(t11, "item5 is null");
        return fromArray(t7, t8, t9, t10, t11);
    }

    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z7, int i8) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        return zipArray(Functions.v(biFunction), z7, i8, observableSource, observableSource2);
    }

    public final Observable<List<T>> buffer(long j8, TimeUnit timeUnit, int i8) {
        return buffer(j8, timeUnit, Schedulers.a(), i8);
    }

    public final Observable<T> takeLast(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        return takeLast(j8, timeUnit, scheduler, z7, bufferSize());
    }

    public final Observable<Observable<T>> window(long j8, TimeUnit timeUnit) {
        return window(j8, timeUnit, Schedulers.a(), Long.MAX_VALUE, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.e(observableSource, "o1 is null");
        ObjectHelper.e(observableSource2, "o2 is null");
        ObjectHelper.e(observableSource3, "o3 is null");
        ObjectHelper.e(observableSource4, "o4 is null");
        ObjectHelper.e(function5, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.y(function5));
    }

    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.i(), false, 4);
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.i(), true, 4);
    }

    public final Observable<List<T>> buffer(long j8, TimeUnit timeUnit, Scheduler scheduler, int i8) {
        return (Observable<List<T>>) buffer(j8, timeUnit, scheduler, i8, ArrayListSupplier.c(), false);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i8) {
        ObjectHelper.e(function, "onNextMapper is null");
        ObjectHelper.e(function2, "onErrorMapper is null");
        ObjectHelper.e(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable), i8);
    }

    public final Observable<T> takeLast(long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7, int i8) {
        return takeLast(Long.MAX_VALUE, j8, timeUnit, scheduler, z7, i8);
    }

    public final Observable<Observable<T>> window(long j8, TimeUnit timeUnit, long j9) {
        return window(j8, timeUnit, Schedulers.a(), j9, false);
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        return combineLatest(Functions.w(function3), bufferSize(), observableSource, observableSource2, observableSource3);
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(long j8, TimeUnit timeUnit, Scheduler scheduler, int i8, Callable<U> callable, boolean z7) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.e(callable, "bufferSupplier is null");
        ObjectHelper.f(i8, "count");
        return RxJavaPlugins.n(new ObservableBufferTimed(this, j8, j8, timeUnit, scheduler, callable, i8, z7));
    }

    public final Observable<Observable<T>> window(long j8, TimeUnit timeUnit, long j9, boolean z7) {
        return window(j8, timeUnit, Schedulers.a(), j9, z7);
    }

    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        return zipArray(Functions.w(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    public final Observable<Observable<T>> window(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j8, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    public final Observable<Observable<T>> window(long j8, TimeUnit timeUnit, Scheduler scheduler, long j9) {
        return window(j8, timeUnit, scheduler, j9, false);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i8) {
        return flatMap((Function) function, false, i8, bufferSize());
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j8, TimeUnit timeUnit) {
        return replay(function, j8, timeUnit, Schedulers.a());
    }

    public final Observable<Observable<T>> window(long j8, TimeUnit timeUnit, Scheduler scheduler, long j9, boolean z7) {
        return window(j8, timeUnit, scheduler, j9, z7, bufferSize());
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        return combineLatest(Functions.x(function4), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    public static <T> Observable<T> just(T t7, T t8, T t9, T t10, T t11, T t12) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        ObjectHelper.e(t10, "item4 is null");
        ObjectHelper.e(t11, "item5 is null");
        ObjectHelper.e(t12, "item6 is null");
        return fromArray(t7, t8, t9, t10, t11, t12);
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(function, "selector is null");
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return ObservableReplay.k(ObservableInternalHelper.j(this, j8, timeUnit, scheduler), function);
    }

    public final Observable<Observable<T>> window(long j8, TimeUnit timeUnit, Scheduler scheduler, long j9, boolean z7, int i8) {
        ObjectHelper.f(i8, "bufferSize");
        ObjectHelper.e(scheduler, "scheduler is null");
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.g(j9, "count");
        return RxJavaPlugins.n(new ObservableWindowTimed(this, j8, j8, timeUnit, scheduler, j9, i8, z7));
    }

    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        return zipArray(Functions.x(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    public final Observable<List<T>> buffer(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) buffer(j8, timeUnit, scheduler, Api.BaseClientBuilder.API_PRIORITY_OTHER, ArrayListSupplier.c(), false);
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z7) {
        return flatMap(function, biFunction, z7, bufferSize(), bufferSize());
    }

    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        ObjectHelper.e(observableSourceArr, "others is null");
        ObjectHelper.e(function, "combiner is null");
        return RxJavaPlugins.n(new ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return (Observable<List<T>>) buffer(observableSource, function, ArrayListSupplier.c());
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z7, int i8) {
        return flatMap(function, biFunction, z7, i8, bufferSize());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.e(observableSource, "openingIndicator is null");
        ObjectHelper.e(function, "closingIndicator is null");
        ObjectHelper.e(callable, "bufferSupplier is null");
        return RxJavaPlugins.n(new ObservableBufferBoundary(this, observableSource, function, callable));
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z7, int i8, int i9) {
        ObjectHelper.e(function, "mapper is null");
        ObjectHelper.e(biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.b(function, biFunction), z7, i8, i9);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.e(function, "selector is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return ObservableReplay.k(ObservableInternalHelper.g(this), ObservableInternalHelper.k(function, scheduler));
    }

    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.e(iterable, "others is null");
        ObjectHelper.e(function, "combiner is null");
        return RxJavaPlugins.n(new ObservableWithLatestFromMany(this, iterable, function));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        return combineLatest(Functions.y(function5), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        return zipArray(Functions.y(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i8) {
        return flatMap(function, biFunction, false, i8, bufferSize());
    }

    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int i8) {
        ObjectHelper.e(observableSource, "boundary is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableWindowBoundary(this, observableSource, i8));
    }

    public static <T> Observable<T> just(T t7, T t8, T t9, T t10, T t11, T t12, T t13) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        ObjectHelper.e(t10, "item4 is null");
        ObjectHelper.e(t11, "item5 is null");
        ObjectHelper.e(t12, "item6 is null");
        ObjectHelper.e(t13, "item7 is null");
        return fromArray(t7, t8, t9, t10, t11, t12, t13);
    }

    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        return (Observable<List<T>>) buffer(observableSource, ArrayListSupplier.c());
    }

    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int i8) {
        ObjectHelper.f(i8, "initialCapacity");
        return (Observable<List<T>>) buffer(observableSource, Functions.e(i8));
    }

    public final ConnectableObservable<T> replay(int i8) {
        ObjectHelper.f(i8, "bufferSize");
        return ObservableReplay.f(this, i8);
    }

    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.e(observableSource, "boundary is null");
        ObjectHelper.e(callable, "bufferSupplier is null");
        return RxJavaPlugins.n(new ObservableBufferExactBoundary(this, observableSource, callable));
    }

    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i8) {
        ObjectHelper.e(observableSource, "openingIndicator is null");
        ObjectHelper.e(function, "closingIndicator is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableWindowBoundarySelector(this, observableSource, function, i8));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        return combineLatest(Functions.z(function6), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    public final ConnectableObservable<T> replay(int i8, long j8, TimeUnit timeUnit) {
        return replay(i8, j8, timeUnit, Schedulers.a());
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        return zipArray(Functions.z(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    public final ConnectableObservable<T> replay(int i8, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.f(i8, "bufferSize");
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return ObservableReplay.h(this, j8, timeUnit, scheduler, i8);
    }

    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return (Observable<List<T>>) buffer(callable, ArrayListSupplier.c());
    }

    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.e(callable, "boundarySupplier is null");
        ObjectHelper.e(callable2, "bufferSupplier is null");
        return RxJavaPlugins.n(new ObservableBufferBoundarySupplier(this, callable, callable2));
    }

    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> Observable<T> just(T t7, T t8, T t9, T t10, T t11, T t12, T t13, T t14) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        ObjectHelper.e(t10, "item4 is null");
        ObjectHelper.e(t11, "item5 is null");
        ObjectHelper.e(t12, "item6 is null");
        ObjectHelper.e(t13, "item7 is null");
        ObjectHelper.e(t14, "item8 is null");
        return fromArray(t7, t8, t9, t10, t11, t12, t13, t14);
    }

    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int i8) {
        ObjectHelper.e(callable, "boundary is null");
        ObjectHelper.f(i8, "bufferSize");
        return RxJavaPlugins.n(new ObservableWindowBoundarySupplier(this, callable, i8));
    }

    public final ConnectableObservable<T> replay(int i8, Scheduler scheduler) {
        ObjectHelper.f(i8, "bufferSize");
        return ObservableReplay.l(replay(i8), scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        ObjectHelper.e(observableSource7, "source7 is null");
        return combineLatest(Functions.A(function7), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    public final ConnectableObservable<T> replay(long j8, TimeUnit timeUnit) {
        return replay(j8, timeUnit, Schedulers.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        ObjectHelper.e(observableSource7, "source7 is null");
        return zipArray(Functions.A(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    public final ConnectableObservable<T> replay(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(timeUnit, "unit is null");
        ObjectHelper.e(scheduler, "scheduler is null");
        return ObservableReplay.g(this, j8, timeUnit, scheduler);
    }

    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return ObservableReplay.l(replay(), scheduler);
    }

    public static <T> Observable<T> just(T t7, T t8, T t9, T t10, T t11, T t12, T t13, T t14, T t15) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        ObjectHelper.e(t10, "item4 is null");
        ObjectHelper.e(t11, "item5 is null");
        ObjectHelper.e(t12, "item6 is null");
        ObjectHelper.e(t13, "item7 is null");
        ObjectHelper.e(t14, "item8 is null");
        ObjectHelper.e(t15, "item9 is null");
        return fromArray(t7, t8, t9, t10, t11, t12, t13, t14, t15);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        ObjectHelper.e(observableSource7, "source7 is null");
        ObjectHelper.e(observableSource8, "source8 is null");
        return combineLatest(Functions.B(function8), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        ObjectHelper.e(observableSource7, "source7 is null");
        ObjectHelper.e(observableSource8, "source8 is null");
        return zipArray(Functions.B(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    public static <T> Observable<T> just(T t7, T t8, T t9, T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        ObjectHelper.e(t7, "item1 is null");
        ObjectHelper.e(t8, "item2 is null");
        ObjectHelper.e(t9, "item3 is null");
        ObjectHelper.e(t10, "item4 is null");
        ObjectHelper.e(t11, "item5 is null");
        ObjectHelper.e(t12, "item6 is null");
        ObjectHelper.e(t13, "item7 is null");
        ObjectHelper.e(t14, "item8 is null");
        ObjectHelper.e(t15, "item9 is null");
        ObjectHelper.e(t16, "item10 is null");
        return fromArray(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        ObjectHelper.e(observableSource7, "source7 is null");
        ObjectHelper.e(observableSource8, "source8 is null");
        ObjectHelper.e(observableSource9, "source9 is null");
        return combineLatest(Functions.C(function9), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.e(observableSource, "source1 is null");
        ObjectHelper.e(observableSource2, "source2 is null");
        ObjectHelper.e(observableSource3, "source3 is null");
        ObjectHelper.e(observableSource4, "source4 is null");
        ObjectHelper.e(observableSource5, "source5 is null");
        ObjectHelper.e(observableSource6, "source6 is null");
        ObjectHelper.e(observableSource7, "source7 is null");
        ObjectHelper.e(observableSource8, "source8 is null");
        ObjectHelper.e(observableSource9, "source9 is null");
        return zipArray(Functions.C(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }
}
