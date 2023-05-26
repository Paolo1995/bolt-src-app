package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends R>> f49203g;

    /* renamed from: h  reason: collision with root package name */
    final int f49204h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f49205i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {

        /* renamed from: f  reason: collision with root package name */
        final SwitchMapObserver<T, R> f49206f;

        /* renamed from: g  reason: collision with root package name */
        final long f49207g;

        /* renamed from: h  reason: collision with root package name */
        final int f49208h;

        /* renamed from: i  reason: collision with root package name */
        volatile SimpleQueue<R> f49209i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f49210j;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j8, int i8) {
            this.f49206f = switchMapObserver;
            this.f49207g = j8;
            this.f49208h = i8;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49207g == this.f49206f.f49221o) {
                this.f49210j = true;
                this.f49206f.b();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49206f.c(this, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r7) {
            if (this.f49207g == this.f49206f.f49221o) {
                if (r7 != null) {
                    this.f49209i.offer(r7);
                }
                this.f49206f.b();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a8 = queueDisposable.a(7);
                    if (a8 == 1) {
                        this.f49209i = queueDisposable;
                        this.f49210j = true;
                        this.f49206f.b();
                        return;
                    } else if (a8 == 2) {
                        this.f49209i = queueDisposable;
                        return;
                    }
                }
                this.f49209i = new SpscLinkedArrayQueue(this.f49208h);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: p  reason: collision with root package name */
        static final SwitchMapInnerObserver<Object, Object> f49211p;

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f49212f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f49213g;

        /* renamed from: h  reason: collision with root package name */
        final int f49214h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f49215i;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f49217k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f49218l;

        /* renamed from: m  reason: collision with root package name */
        Disposable f49219m;

        /* renamed from: o  reason: collision with root package name */
        volatile long f49221o;

        /* renamed from: n  reason: collision with root package name */
        final AtomicReference<SwitchMapInnerObserver<T, R>> f49220n = new AtomicReference<>();

        /* renamed from: j  reason: collision with root package name */
        final AtomicThrowable f49216j = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            f49211p = switchMapInnerObserver;
            switchMapInnerObserver.a();
        }

        SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i8, boolean z7) {
            this.f49212f = observer;
            this.f49213g = function;
            this.f49214h = i8;
            this.f49215i = z7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.f49220n.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver3 = f49211p;
            if (switchMapInnerObserver2 != switchMapInnerObserver3 && (switchMapInnerObserver = (SwitchMapInnerObserver) this.f49220n.getAndSet(switchMapInnerObserver3)) != switchMapInnerObserver3 && switchMapInnerObserver != null) {
                switchMapInnerObserver.a();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x00e9 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                Method dump skipped, instructions count: 241
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        void c(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.f49207g == this.f49221o && this.f49216j.a(th)) {
                if (!this.f49215i) {
                    this.f49219m.dispose();
                    this.f49217k = true;
                }
                switchMapInnerObserver.f49210j = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49218l) {
                this.f49218l = true;
                this.f49219m.dispose();
                a();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49218l;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f49217k) {
                this.f49217k = true;
                b();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f49217k && this.f49216j.a(th)) {
                if (!this.f49215i) {
                    a();
                }
                this.f49217k = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j8 = this.f49221o + 1;
            this.f49221o = j8;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.f49220n.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.a();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49213g.apply(t7), "The ObservableSource returned is null");
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j8, this.f49214h);
                do {
                    switchMapInnerObserver = this.f49220n.get();
                    if (switchMapInnerObserver == f49211p) {
                        return;
                    }
                } while (!e.a(this.f49220n, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49219m.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49219m, disposable)) {
                this.f49219m = disposable;
                this.f49212f.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i8, boolean z7) {
        super(observableSource);
        this.f49203g = function;
        this.f49204h = i8;
        this.f49205i = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (ObservableScalarXMap.b(this.f48232f, observer, this.f49203g)) {
            return;
        }
        this.f48232f.subscribe(new SwitchMapObserver(observer, this.f49203g, this.f49204h, this.f49205i));
    }
}
