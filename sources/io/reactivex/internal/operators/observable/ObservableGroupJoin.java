package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<? extends TRight> f48745g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f48746h;

    /* renamed from: i  reason: collision with root package name */
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f48747i;

    /* renamed from: j  reason: collision with root package name */
    final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f48748j;

    /* loaded from: classes5.dex */
    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {

        /* renamed from: s  reason: collision with root package name */
        static final Integer f48749s = 1;

        /* renamed from: t  reason: collision with root package name */
        static final Integer f48750t = 2;

        /* renamed from: u  reason: collision with root package name */
        static final Integer f48751u = 3;

        /* renamed from: v  reason: collision with root package name */
        static final Integer f48752v = 4;

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48753f;

        /* renamed from: l  reason: collision with root package name */
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f48759l;

        /* renamed from: m  reason: collision with root package name */
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f48760m;

        /* renamed from: n  reason: collision with root package name */
        final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f48761n;

        /* renamed from: p  reason: collision with root package name */
        int f48763p;

        /* renamed from: q  reason: collision with root package name */
        int f48764q;

        /* renamed from: r  reason: collision with root package name */
        volatile boolean f48765r;

        /* renamed from: h  reason: collision with root package name */
        final CompositeDisposable f48755h = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f48754g = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: i  reason: collision with root package name */
        final Map<Integer, UnicastSubject<TRight>> f48756i = new LinkedHashMap();

        /* renamed from: j  reason: collision with root package name */
        final Map<Integer, TRight> f48757j = new LinkedHashMap();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Throwable> f48758k = new AtomicReference<>();

        /* renamed from: o  reason: collision with root package name */
        final AtomicInteger f48762o = new AtomicInteger(2);

        GroupJoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
            this.f48753f = observer;
            this.f48759l = function;
            this.f48760m = function2;
            this.f48761n = biFunction;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void a(Throwable th) {
            if (ExceptionHelper.a(this.f48758k, th)) {
                this.f48762o.decrementAndGet();
                g();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void b(boolean z7, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f48754g;
                if (z7) {
                    num = f48749s;
                } else {
                    num = f48750t;
                }
                spscLinkedArrayQueue.m(num, obj);
            }
            g();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void c(boolean z7, LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f48754g;
                if (z7) {
                    num = f48751u;
                } else {
                    num = f48752v;
                }
                spscLinkedArrayQueue.m(num, leftRightEndObserver);
            }
            g();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void d(Throwable th) {
            if (ExceptionHelper.a(this.f48758k, th)) {
                g();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f48765r) {
                return;
            }
            this.f48765r = true;
            f();
            if (getAndIncrement() == 0) {
                this.f48754g.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void e(LeftRightObserver leftRightObserver) {
            this.f48755h.c(leftRightObserver);
            this.f48762o.decrementAndGet();
            g();
        }

        void f() {
            this.f48755h.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            boolean z7;
            boolean z8;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.f48754g;
            Observer<? super R> observer = this.f48753f;
            int i8 = 1;
            while (!this.f48765r) {
                if (this.f48758k.get() != null) {
                    spscLinkedArrayQueue.clear();
                    f();
                    h(observer);
                    return;
                }
                if (this.f48762o.get() == 0) {
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
                    for (UnicastSubject<TRight> unicastSubject : this.f48756i.values()) {
                        unicastSubject.onComplete();
                    }
                    this.f48756i.clear();
                    this.f48757j.clear();
                    this.f48755h.dispose();
                    observer.onComplete();
                    return;
                } else if (z8) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == f48749s) {
                        UnicastSubject<TRight> d8 = UnicastSubject.d();
                        int i9 = this.f48763p;
                        this.f48763p = i9 + 1;
                        this.f48756i.put(Integer.valueOf(i9), d8);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48759l.apply(poll), "The leftEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i9);
                            this.f48755h.b(leftRightEndObserver);
                            observableSource.subscribe(leftRightEndObserver);
                            if (this.f48758k.get() != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(observer);
                                return;
                            }
                            try {
                                observer.onNext((Object) ObjectHelper.e(this.f48761n.apply(poll, d8), "The resultSelector returned a null value"));
                                for (TRight tright : this.f48757j.values()) {
                                    d8.onNext(tright);
                                }
                            } catch (Throwable th) {
                                i(th, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } catch (Throwable th2) {
                            i(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f48750t) {
                        int i10 = this.f48764q;
                        this.f48764q = i10 + 1;
                        this.f48757j.put(Integer.valueOf(i10), poll);
                        try {
                            ObservableSource observableSource2 = (ObservableSource) ObjectHelper.e(this.f48760m.apply(poll), "The rightEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i10);
                            this.f48755h.b(leftRightEndObserver2);
                            observableSource2.subscribe(leftRightEndObserver2);
                            if (this.f48758k.get() != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(observer);
                                return;
                            }
                            for (UnicastSubject<TRight> unicastSubject2 : this.f48756i.values()) {
                                unicastSubject2.onNext(poll);
                            }
                        } catch (Throwable th3) {
                            i(th3, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f48751u) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) poll;
                        UnicastSubject<TRight> remove = this.f48756i.remove(Integer.valueOf(leftRightEndObserver3.f48768h));
                        this.f48755h.a(leftRightEndObserver3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == f48752v) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) poll;
                        this.f48757j.remove(Integer.valueOf(leftRightEndObserver4.f48768h));
                        this.f48755h.a(leftRightEndObserver4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void h(Observer<?> observer) {
            Throwable b8 = ExceptionHelper.b(this.f48758k);
            for (UnicastSubject<TRight> unicastSubject : this.f48756i.values()) {
                unicastSubject.onError(b8);
            }
            this.f48756i.clear();
            this.f48757j.clear();
            observer.onError(b8);
        }

        void i(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f48758k, th);
            spscLinkedArrayQueue.clear();
            f();
            h(observer);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48765r;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface JoinSupport {
        void a(Throwable th);

        void b(boolean z7, Object obj);

        void c(boolean z7, LeftRightEndObserver leftRightEndObserver);

        void d(Throwable th);

        void e(LeftRightObserver leftRightObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final JoinSupport f48766f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f48767g;

        /* renamed from: h  reason: collision with root package name */
        final int f48768h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightEndObserver(JoinSupport joinSupport, boolean z7, int i8) {
            this.f48766f = joinSupport;
            this.f48767g = z7;
            this.f48768h = i8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48766f.c(this.f48767g, this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48766f.d(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (DisposableHelper.a(this)) {
                this.f48766f.c(this.f48767g, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final JoinSupport f48769f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f48770g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightObserver(JoinSupport joinSupport, boolean z7) {
            this.f48769f = joinSupport;
            this.f48770g = z7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48769f.e(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48769f.a(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.f48769f.b(this.f48770g, obj);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.f48745g = observableSource2;
        this.f48746h = function;
        this.f48747i = function2;
        this.f48748j = biFunction;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(observer, this.f48746h, this.f48747i, this.f48748j);
        observer.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.f48755h.b(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.f48755h.b(leftRightObserver2);
        this.f48232f.subscribe(leftRightObserver);
        this.f48745g.subscribe(leftRightObserver2);
    }
}
