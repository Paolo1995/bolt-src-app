package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import com.google.android.gms.common.api.Api;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements ResettableConnectable {

    /* renamed from: j  reason: collision with root package name */
    static final BufferSupplier f49010j = new UnBoundedFactory();

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f49011f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<ReplayObserver<T>> f49012g;

    /* renamed from: h  reason: collision with root package name */
    final BufferSupplier<T> f49013h;

    /* renamed from: i  reason: collision with root package name */
    final ObservableSource<T> f49014i;

    /* loaded from: classes5.dex */
    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {

        /* renamed from: f  reason: collision with root package name */
        Node f49015f;

        /* renamed from: g  reason: collision with root package name */
        int f49016g;

        BoundedReplayBuffer() {
            Node node = new Node(null);
            this.f49015f = node;
            set(node);
        }

        final void a(Node node) {
            this.f49015f.set(node);
            this.f49015f = node;
            this.f49016g++;
        }

        Object b(Object obj) {
            return obj;
        }

        Node c() {
            return get();
        }

        Object d(Object obj) {
            return obj;
        }

        final void e() {
            this.f49016g--;
            f(get().get());
        }

        final void f(Node node) {
            set(node);
        }

        final void g() {
            Node node = get();
            if (node.f49024f != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        abstract void h();

        void i() {
            g();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void k() {
            a(new Node(b(NotificationLite.f())));
            i();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void m(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int i8 = 1;
            do {
                Node node = (Node) innerDisposable.a();
                if (node == null) {
                    node = c();
                    innerDisposable.f49020h = node;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node2 = node.get();
                    if (node2 != null) {
                        if (NotificationLite.a(d(node2.f49024f), innerDisposable.f49019g)) {
                            innerDisposable.f49020h = null;
                            return;
                        }
                        node = node2;
                    } else {
                        innerDisposable.f49020h = node;
                        i8 = innerDisposable.addAndGet(-i8);
                    }
                }
                innerDisposable.f49020h = null;
                return;
            } while (i8 != 0);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void n(Throwable th) {
            a(new Node(b(NotificationLite.j(th))));
            i();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void o(T t7) {
            a(new Node(b(NotificationLite.q(t7))));
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    /* loaded from: classes5.dex */
    static final class DisposeConsumer<R> implements Consumer<Disposable> {

        /* renamed from: f  reason: collision with root package name */
        private final ObserverResourceWrapper<R> f49017f;

        DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f49017f = observerResourceWrapper;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Disposable disposable) {
            this.f49017f.a(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final ReplayObserver<T> f49018f;

        /* renamed from: g  reason: collision with root package name */
        final Observer<? super T> f49019g;

        /* renamed from: h  reason: collision with root package name */
        Object f49020h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49021i;

        InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.f49018f = replayObserver;
            this.f49019g = observer;
        }

        <U> U a() {
            return (U) this.f49020h;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49021i) {
                this.f49021i = true;
                this.f49018f.b(this);
                this.f49020h = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49021i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class MulticastReplay<R, U> extends Observable<R> {

        /* renamed from: f  reason: collision with root package name */
        private final Callable<? extends ConnectableObservable<U>> f49022f;

        /* renamed from: g  reason: collision with root package name */
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> f49023g;

        MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.f49022f = callable;
            this.f49023g = function;
        }

        @Override // io.reactivex.Observable
        protected void subscribeActual(Observer<? super R> observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.e(this.f49022f.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49023g.apply(connectableObservable), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.c(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Node extends AtomicReference<Node> {

        /* renamed from: f  reason: collision with root package name */
        final Object f49024f;

        Node(Object obj) {
            this.f49024f = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Replay<T> extends ConnectableObservable<T> {

        /* renamed from: f  reason: collision with root package name */
        private final ConnectableObservable<T> f49025f;

        /* renamed from: g  reason: collision with root package name */
        private final Observable<T> f49026g;

        Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
            this.f49025f = connectableObservable;
            this.f49026g = observable;
        }

        @Override // io.reactivex.observables.ConnectableObservable
        public void c(Consumer<? super Disposable> consumer) {
            this.f49025f.c(consumer);
        }

        @Override // io.reactivex.Observable
        protected void subscribeActual(Observer<? super T> observer) {
            this.f49026g.subscribe(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface ReplayBuffer<T> {
        void k();

        void m(InnerDisposable<T> innerDisposable);

        void n(Throwable th);

        void o(T t7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f49027a;

        ReplayBufferSupplier(int i8) {
            this.f49027a = i8;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.f49027a);
        }
    }

    /* loaded from: classes5.dex */
    static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        static final InnerDisposable[] f49028j = new InnerDisposable[0];

        /* renamed from: k  reason: collision with root package name */
        static final InnerDisposable[] f49029k = new InnerDisposable[0];

        /* renamed from: f  reason: collision with root package name */
        final ReplayBuffer<T> f49030f;

        /* renamed from: g  reason: collision with root package name */
        boolean f49031g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<InnerDisposable[]> f49032h = new AtomicReference<>(f49028j);

        /* renamed from: i  reason: collision with root package name */
        final AtomicBoolean f49033i = new AtomicBoolean();

        ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.f49030f = replayBuffer;
        }

        boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f49032h.get();
                if (innerDisposableArr == f49029k) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!e.a(this.f49032h, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f49032h.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i8 = -1;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    } else if (innerDisposableArr[i9].equals(innerDisposable)) {
                        i8 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
                if (i8 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f49028j;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i8);
                    System.arraycopy(innerDisposableArr, i8 + 1, innerDisposableArr3, i8, (length - i8) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!e.a(this.f49032h, innerDisposableArr, innerDisposableArr2));
        }

        void c() {
            for (InnerDisposable<T> innerDisposable : this.f49032h.get()) {
                this.f49030f.m(innerDisposable);
            }
        }

        void d() {
            for (InnerDisposable<T> innerDisposable : this.f49032h.getAndSet(f49029k)) {
                this.f49030f.m(innerDisposable);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49032h.set(f49029k);
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f49032h.get() == f49029k) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f49031g) {
                this.f49031g = true;
                this.f49030f.k();
                d();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f49031g) {
                this.f49031g = true;
                this.f49030f.n(th);
                d();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (!this.f49031g) {
                this.f49030f.o(t7);
                c();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ReplaySource<T> implements ObservableSource<T> {

        /* renamed from: f  reason: collision with root package name */
        private final AtomicReference<ReplayObserver<T>> f49034f;

        /* renamed from: g  reason: collision with root package name */
        private final BufferSupplier<T> f49035g;

        ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.f49034f = atomicReference;
            this.f49035g = bufferSupplier;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            ReplayObserver<T> replayObserver;
            while (true) {
                replayObserver = this.f49034f.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f49035g.call());
                if (e.a(this.f49034f, null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, observer);
            observer.onSubscribe(innerDisposable);
            replayObserver.a(innerDisposable);
            if (innerDisposable.isDisposed()) {
                replayObserver.b(innerDisposable);
            } else {
                replayObserver.f49030f.m(innerDisposable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f49036a;

        /* renamed from: b  reason: collision with root package name */
        private final long f49037b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f49038c;

        /* renamed from: d  reason: collision with root package name */
        private final Scheduler f49039d;

        ScheduledReplaySupplier(int i8, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            this.f49036a = i8;
            this.f49037b = j8;
            this.f49038c = timeUnit;
            this.f49039d = scheduler;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f49036a, this.f49037b, this.f49038c, this.f49039d);
        }
    }

    /* loaded from: classes5.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {

        /* renamed from: h  reason: collision with root package name */
        final Scheduler f49040h;

        /* renamed from: i  reason: collision with root package name */
        final long f49041i;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f49042j;

        /* renamed from: k  reason: collision with root package name */
        final int f49043k;

        SizeAndTimeBoundReplayBuffer(int i8, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            this.f49040h = scheduler;
            this.f49043k = i8;
            this.f49041i = j8;
            this.f49042j = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object b(Object obj) {
            return new Timed(obj, this.f49040h.c(this.f49042j), this.f49042j);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Node c() {
            Node node;
            long c8 = this.f49040h.c(this.f49042j) - this.f49041i;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    Timed timed = (Timed) node2.f49024f;
                    if (NotificationLite.m(timed.b()) || NotificationLite.p(timed.b()) || timed.a() > c8) {
                        break;
                    }
                    node3 = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object d(Object obj) {
            return ((Timed) obj).b();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void h() {
            Node node;
            long c8 = this.f49040h.c(this.f49042j) - this.f49041i;
            Node node2 = get();
            Node node3 = node2.get();
            int i8 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i9 = this.f49016g;
                if (i9 > this.f49043k && i9 > 1) {
                    i8++;
                    this.f49016g = i9 - 1;
                    node3 = node2.get();
                } else if (((Timed) node2.f49024f).a() > c8) {
                    break;
                } else {
                    i8++;
                    this.f49016g--;
                    node3 = node2.get();
                }
            }
            if (i8 != 0) {
                f(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
            f(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void i() {
            /*
                r10 = this;
                io.reactivex.Scheduler r0 = r10.f49040h
                java.util.concurrent.TimeUnit r1 = r10.f49042j
                long r0 = r0.c(r1)
                long r2 = r10.f49041i
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                r4 = 0
            L18:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3c
                int r5 = r10.f49016g
                r6 = 1
                if (r5 <= r6) goto L3c
                java.lang.Object r5 = r2.f49024f
                io.reactivex.schedulers.Timed r5 = (io.reactivex.schedulers.Timed) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3c
                int r4 = r4 + 1
                int r3 = r10.f49016g
                int r3 = r3 - r6
                r10.f49016g = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                goto L18
            L3c:
                if (r4 == 0) goto L41
                r10.f(r3)
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.i():void");
        }
    }

    /* loaded from: classes5.dex */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {

        /* renamed from: h  reason: collision with root package name */
        final int f49044h;

        SizeBoundReplayBuffer(int i8) {
            this.f49044h = i8;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void h() {
            if (this.f49016g > this.f49044h) {
                e();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* loaded from: classes5.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {

        /* renamed from: f  reason: collision with root package name */
        volatile int f49045f;

        UnboundedReplayBuffer(int i8) {
            super(i8);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void k() {
            add(NotificationLite.f());
            this.f49045f++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void m(InnerDisposable<T> innerDisposable) {
            int i8;
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = innerDisposable.f49019g;
            int i9 = 1;
            while (!innerDisposable.isDisposed()) {
                int i10 = this.f49045f;
                Integer num = (Integer) innerDisposable.a();
                if (num != null) {
                    i8 = num.intValue();
                } else {
                    i8 = 0;
                }
                while (i8 < i10) {
                    if (NotificationLite.a(get(i8), observer) || innerDisposable.isDisposed()) {
                        return;
                    }
                    i8++;
                }
                innerDisposable.f49020h = Integer.valueOf(i8);
                i9 = innerDisposable.addAndGet(-i9);
                if (i9 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void n(Throwable th) {
            add(NotificationLite.j(th));
            this.f49045f++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void o(T t7) {
            add(NotificationLite.q(t7));
            this.f49045f++;
        }
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.f49014i = observableSource;
        this.f49011f = observableSource2;
        this.f49012g = atomicReference;
        this.f49013h = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> f(ObservableSource<T> observableSource, int i8) {
        if (i8 == Integer.MAX_VALUE) {
            return j(observableSource);
        }
        return i(observableSource, new ReplayBufferSupplier(i8));
    }

    public static <T> ConnectableObservable<T> g(ObservableSource<T> observableSource, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        return h(observableSource, j8, timeUnit, scheduler, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static <T> ConnectableObservable<T> h(ObservableSource<T> observableSource, long j8, TimeUnit timeUnit, Scheduler scheduler, int i8) {
        return i(observableSource, new ScheduledReplaySupplier(i8, j8, timeUnit, scheduler));
    }

    static <T> ConnectableObservable<T> i(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.p(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static <T> ConnectableObservable<T> j(ObservableSource<? extends T> observableSource) {
        return i(observableSource, f49010j);
    }

    public static <U, R> Observable<R> k(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.n(new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> l(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.p(new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void b(Disposable disposable) {
        e.a(this.f49012g, (ReplayObserver) disposable, null);
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void c(Consumer<? super Disposable> consumer) {
        ReplayObserver<T> replayObserver;
        boolean z7;
        while (true) {
            replayObserver = this.f49012g.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f49013h.call());
            if (e.a(this.f49012g, replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        if (!replayObserver.f49033i.get() && replayObserver.f49033i.compareAndSet(false, true)) {
            z7 = true;
        } else {
            z7 = false;
        }
        try {
            consumer.accept(replayObserver);
            if (z7) {
                this.f49011f.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z7) {
                replayObserver.f49033i.compareAndSet(true, false);
            }
            Exceptions.b(th);
            throw ExceptionHelper.e(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f49014i.subscribe(observer);
    }
}
