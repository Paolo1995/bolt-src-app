package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleZipArray<T, R> extends Single<R> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<? extends T>[] f49629f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Object[], ? extends R> f49630g;

    /* loaded from: classes5.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t7) throws Exception {
            return (R) ObjectHelper.e(SingleZipArray.this.f49630g.apply(new Object[]{t7}), "The zipper returned a null value");
        }
    }

    /* loaded from: classes5.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super R> f49632f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Object[], ? extends R> f49633g;

        /* renamed from: h  reason: collision with root package name */
        final ZipSingleObserver<T>[] f49634h;

        /* renamed from: i  reason: collision with root package name */
        final Object[] f49635i;

        ZipCoordinator(SingleObserver<? super R> singleObserver, int i8, Function<? super Object[], ? extends R> function) {
            super(i8);
            this.f49632f = singleObserver;
            this.f49633g = function;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                zipSingleObserverArr[i9] = new ZipSingleObserver<>(this, i9);
            }
            this.f49634h = zipSingleObserverArr;
            this.f49635i = new Object[i8];
        }

        void a(int i8) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.f49634h;
            int length = zipSingleObserverArr.length;
            for (int i9 = 0; i9 < i8; i9++) {
                zipSingleObserverArr[i9].a();
            }
            while (true) {
                i8++;
                if (i8 < length) {
                    zipSingleObserverArr[i8].a();
                } else {
                    return;
                }
            }
        }

        void b(Throwable th, int i8) {
            if (getAndSet(0) > 0) {
                a(i8);
                this.f49632f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        void c(T t7, int i8) {
            this.f49635i[i8] = t7;
            if (decrementAndGet() == 0) {
                try {
                    this.f49632f.onSuccess(ObjectHelper.e(this.f49633g.apply(this.f49635i), "The zipper returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f49632f.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> zipSingleObserver : this.f49634h) {
                    zipSingleObserver.a();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() <= 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        final ZipCoordinator<T, ?> f49636f;

        /* renamed from: g  reason: collision with root package name */
        final int f49637g;

        ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i8) {
            this.f49636f = zipCoordinator;
            this.f49637g = i8;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49636f.b(th, this.f49637g);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f49636f.c(t7, this.f49637g);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.f49629f = singleSourceArr;
        this.f49630g = function;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super R> singleObserver) {
        SingleSource<? extends T>[] singleSourceArr = this.f49629f;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].a(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.f49630g);
        singleObserver.onSubscribe(zipCoordinator);
        for (int i8 = 0; i8 < length && !zipCoordinator.isDisposed(); i8++) {
            SingleSource<? extends T> singleSource = singleSourceArr[i8];
            if (singleSource == null) {
                zipCoordinator.b(new NullPointerException("One of the sources is null"), i8);
                return;
            }
            singleSource.a(zipCoordinator.f49634h[i8]);
        }
    }
}
