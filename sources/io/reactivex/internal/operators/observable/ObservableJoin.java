package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<? extends TRight> f48819g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f48820h;

    /* renamed from: i  reason: collision with root package name */
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f48821i;

    /* renamed from: j  reason: collision with root package name */
    final BiFunction<? super TLeft, ? super TRight, ? extends R> f48822j;

    /* loaded from: classes5.dex */
    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {

        /* renamed from: s  reason: collision with root package name */
        static final Integer f48823s = 1;

        /* renamed from: t  reason: collision with root package name */
        static final Integer f48824t = 2;

        /* renamed from: u  reason: collision with root package name */
        static final Integer f48825u = 3;

        /* renamed from: v  reason: collision with root package name */
        static final Integer f48826v = 4;

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48827f;

        /* renamed from: l  reason: collision with root package name */
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f48833l;

        /* renamed from: m  reason: collision with root package name */
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f48834m;

        /* renamed from: n  reason: collision with root package name */
        final BiFunction<? super TLeft, ? super TRight, ? extends R> f48835n;

        /* renamed from: p  reason: collision with root package name */
        int f48837p;

        /* renamed from: q  reason: collision with root package name */
        int f48838q;

        /* renamed from: r  reason: collision with root package name */
        volatile boolean f48839r;

        /* renamed from: h  reason: collision with root package name */
        final CompositeDisposable f48829h = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f48828g = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: i  reason: collision with root package name */
        final Map<Integer, TLeft> f48830i = new LinkedHashMap();

        /* renamed from: j  reason: collision with root package name */
        final Map<Integer, TRight> f48831j = new LinkedHashMap();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Throwable> f48832k = new AtomicReference<>();

        /* renamed from: o  reason: collision with root package name */
        final AtomicInteger f48836o = new AtomicInteger(2);

        JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f48827f = observer;
            this.f48833l = function;
            this.f48834m = function2;
            this.f48835n = biFunction;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void a(Throwable th) {
            if (ExceptionHelper.a(this.f48832k, th)) {
                this.f48836o.decrementAndGet();
                g();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void b(boolean z7, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f48828g;
                if (z7) {
                    num = f48823s;
                } else {
                    num = f48824t;
                }
                spscLinkedArrayQueue.m(num, obj);
            }
            g();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void c(boolean z7, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f48828g;
                if (z7) {
                    num = f48825u;
                } else {
                    num = f48826v;
                }
                spscLinkedArrayQueue.m(num, leftRightEndObserver);
            }
            g();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void d(Throwable th) {
            if (ExceptionHelper.a(this.f48832k, th)) {
                g();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f48839r) {
                this.f48839r = true;
                f();
                if (getAndIncrement() == 0) {
                    this.f48828g.clear();
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void e(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.f48829h.c(leftRightObserver);
            this.f48836o.decrementAndGet();
            g();
        }

        void f() {
            this.f48829h.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            boolean z7;
            boolean z8;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.f48828g;
            Observer<? super R> observer = this.f48827f;
            int i8 = 1;
            while (!this.f48839r) {
                if (this.f48832k.get() != null) {
                    spscLinkedArrayQueue.clear();
                    f();
                    h(observer);
                    return;
                }
                if (this.f48836o.get() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                if (num == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z7 && z8) {
                    this.f48830i.clear();
                    this.f48831j.clear();
                    this.f48829h.dispose();
                    observer.onComplete();
                    return;
                } else if (z8) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == f48823s) {
                        int i9 = this.f48837p;
                        this.f48837p = i9 + 1;
                        this.f48830i.put(Integer.valueOf(i9), poll);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48833l.apply(poll), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i9);
                            this.f48829h.b(leftRightEndObserver);
                            observableSource.subscribe(leftRightEndObserver);
                            if (this.f48832k.get() != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(observer);
                                return;
                            }
                            for (TRight tright : this.f48831j.values()) {
                                try {
                                    observer.onNext((Object) ObjectHelper.e(this.f48835n.apply(poll, tright), "The resultSelector returned a null value"));
                                } catch (Throwable th) {
                                    i(th, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable th2) {
                            i(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f48824t) {
                        int i10 = this.f48838q;
                        this.f48838q = i10 + 1;
                        this.f48831j.put(Integer.valueOf(i10), poll);
                        try {
                            ObservableSource observableSource2 = (ObservableSource) ObjectHelper.e(this.f48834m.apply(poll), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i10);
                            this.f48829h.b(leftRightEndObserver2);
                            observableSource2.subscribe(leftRightEndObserver2);
                            if (this.f48832k.get() != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(observer);
                                return;
                            }
                            for (TLeft tleft : this.f48830i.values()) {
                                try {
                                    observer.onNext((Object) ObjectHelper.e(this.f48835n.apply(tleft, poll), "The resultSelector returned a null value"));
                                } catch (Throwable th3) {
                                    i(th3, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable th4) {
                            i(th4, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f48825u) {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                        this.f48830i.remove(Integer.valueOf(leftRightEndObserver3.f48768h));
                        this.f48829h.a(leftRightEndObserver3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                        this.f48831j.remove(Integer.valueOf(leftRightEndObserver4.f48768h));
                        this.f48829h.a(leftRightEndObserver4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void h(Observer<?> observer) {
            Throwable b8 = ExceptionHelper.b(this.f48832k);
            this.f48830i.clear();
            this.f48831j.clear();
            observer.onError(b8);
        }

        void i(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f48832k, th);
            spscLinkedArrayQueue.clear();
            f();
            h(observer);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48839r;
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.f48819g = observableSource2;
        this.f48820h = function;
        this.f48821i = function2;
        this.f48822j = biFunction;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.f48820h, this.f48821i, this.f48822j);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.f48829h.b(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.f48829h.b(leftRightObserver2);
        this.f48232f.subscribe(leftRightObserver);
        this.f48819g.subscribe(leftRightObserver2);
    }
}
