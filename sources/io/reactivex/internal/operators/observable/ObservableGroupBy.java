package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends K> f48722g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, ? extends V> f48723h;

    /* renamed from: i  reason: collision with root package name */
    final int f48724i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f48725j;

    /* loaded from: classes5.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: n  reason: collision with root package name */
        static final Object f48726n = new Object();

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super GroupedObservable<K, V>> f48727f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends K> f48728g;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super T, ? extends V> f48729h;

        /* renamed from: i  reason: collision with root package name */
        final int f48730i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f48731j;

        /* renamed from: l  reason: collision with root package name */
        Disposable f48733l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicBoolean f48734m = new AtomicBoolean();

        /* renamed from: k  reason: collision with root package name */
        final Map<Object, GroupedUnicast<K, V>> f48732k = new ConcurrentHashMap();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i8, boolean z7) {
            this.f48727f = observer;
            this.f48728g = function;
            this.f48729h = function2;
            this.f48730i = i8;
            this.f48731j = z7;
            lazySet(1);
        }

        public void a(K k8) {
            if (k8 == null) {
                k8 = (K) f48726n;
            }
            this.f48732k.remove(k8);
            if (decrementAndGet() == 0) {
                this.f48733l.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f48734m.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f48733l.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48734m.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList<GroupedUnicast> arrayList = new ArrayList(this.f48732k.values());
            this.f48732k.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                groupedUnicast.onComplete();
            }
            this.f48727f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayList<GroupedUnicast> arrayList = new ArrayList(this.f48732k.values());
            this.f48732k.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                groupedUnicast.onError(th);
            }
            this.f48727f.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            Object obj;
            try {
                K apply = this.f48728g.apply(t7);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = f48726n;
                }
                GroupedUnicast<K, V> groupedUnicast = this.f48732k.get(obj);
                if (groupedUnicast == null) {
                    if (this.f48734m.get()) {
                        return;
                    }
                    groupedUnicast = GroupedUnicast.c(apply, this.f48730i, this, this.f48731j);
                    this.f48732k.put(obj, groupedUnicast);
                    getAndIncrement();
                    this.f48727f.onNext(groupedUnicast);
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.e(this.f48729h.apply(t7), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f48733l.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f48733l.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48733l, disposable)) {
                this.f48733l = disposable;
                this.f48727f.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {

        /* renamed from: g  reason: collision with root package name */
        final State<T, K> f48735g;

        protected GroupedUnicast(K k8, State<T, K> state) {
            super(k8);
            this.f48735g = state;
        }

        public static <T, K> GroupedUnicast<K, T> c(K k8, int i8, GroupByObserver<?, K, T> groupByObserver, boolean z7) {
            return new GroupedUnicast<>(k8, new State(i8, groupByObserver, k8, z7));
        }

        public void onComplete() {
            this.f48735g.c();
        }

        public void onError(Throwable th) {
            this.f48735g.d(th);
        }

        public void onNext(T t7) {
            this.f48735g.e(t7);
        }

        @Override // io.reactivex.Observable
        protected void subscribeActual(Observer<? super T> observer) {
            this.f48735g.subscribe(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {

        /* renamed from: f  reason: collision with root package name */
        final K f48736f;

        /* renamed from: g  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f48737g;

        /* renamed from: h  reason: collision with root package name */
        final GroupByObserver<?, K, T> f48738h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f48739i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f48740j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f48741k;

        /* renamed from: l  reason: collision with root package name */
        final AtomicBoolean f48742l = new AtomicBoolean();

        /* renamed from: m  reason: collision with root package name */
        final AtomicBoolean f48743m = new AtomicBoolean();

        /* renamed from: n  reason: collision with root package name */
        final AtomicReference<Observer<? super T>> f48744n = new AtomicReference<>();

        State(int i8, GroupByObserver<?, K, T> groupByObserver, K k8, boolean z7) {
            this.f48737g = new SpscLinkedArrayQueue<>(i8);
            this.f48738h = groupByObserver;
            this.f48736f = k8;
            this.f48739i = z7;
        }

        boolean a(boolean z7, boolean z8, Observer<? super T> observer, boolean z9) {
            if (this.f48742l.get()) {
                this.f48737g.clear();
                this.f48738h.a(this.f48736f);
                this.f48744n.lazySet(null);
                return true;
            } else if (z7) {
                if (z9) {
                    if (z8) {
                        Throwable th = this.f48741k;
                        this.f48744n.lazySet(null);
                        if (th != null) {
                            observer.onError(th);
                        } else {
                            observer.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f48741k;
                if (th2 != null) {
                    this.f48737g.clear();
                    this.f48744n.lazySet(null);
                    observer.onError(th2);
                    return true;
                } else if (z8) {
                    this.f48744n.lazySet(null);
                    observer.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f48737g;
            boolean z8 = this.f48739i;
            Observer<? super T> observer = this.f48744n.get();
            int i8 = 1;
            while (true) {
                if (observer != null) {
                    while (true) {
                        boolean z9 = this.f48740j;
                        Object obj = (T) spscLinkedArrayQueue.poll();
                        if (obj == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (a(z9, z7, observer, z8)) {
                            return;
                        }
                        if (z7) {
                            break;
                        }
                        observer.onNext(obj);
                    }
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
                if (observer == null) {
                    observer = this.f48744n.get();
                }
            }
        }

        public void c() {
            this.f48740j = true;
            b();
        }

        public void d(Throwable th) {
            this.f48741k = th;
            this.f48740j = true;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f48742l.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f48744n.lazySet(null);
                this.f48738h.a(this.f48736f);
            }
        }

        public void e(T t7) {
            this.f48737g.offer(t7);
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48742l.get();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            if (this.f48743m.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.f48744n.lazySet(observer);
                if (this.f48742l.get()) {
                    this.f48744n.lazySet(null);
                    return;
                } else {
                    b();
                    return;
                }
            }
            EmptyDisposable.h(new IllegalStateException("Only one Observer allowed!"), observer);
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i8, boolean z7) {
        super(observableSource);
        this.f48722g = function;
        this.f48723h = function2;
        this.f48724i = i8;
        this.f48725j = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.f48232f.subscribe(new GroupByObserver(observer, this.f48722g, this.f48723h, this.f48724i, this.f48725j));
    }
}
