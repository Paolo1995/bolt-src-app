package io.reactivex.subjects;

import androidx.camera.view.e;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: j  reason: collision with root package name */
    static final SingleDisposable[] f49932j = new SingleDisposable[0];

    /* renamed from: k  reason: collision with root package name */
    static final SingleDisposable[] f49933k = new SingleDisposable[0];

    /* renamed from: h  reason: collision with root package name */
    T f49936h;

    /* renamed from: i  reason: collision with root package name */
    Throwable f49937i;

    /* renamed from: g  reason: collision with root package name */
    final AtomicBoolean f49935g = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<SingleDisposable<T>[]> f49934f = new AtomicReference<>(f49932j);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49938f;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.f49938f = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SingleSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.a0(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    SingleSubject() {
    }

    public static <T> SingleSubject<T> Z() {
        return new SingleSubject<>();
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        SingleDisposable<T> singleDisposable = new SingleDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (Y(singleDisposable)) {
            if (singleDisposable.isDisposed()) {
                a0(singleDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f49937i;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess((T) this.f49936h);
        }
    }

    boolean Y(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = this.f49934f.get();
            if (singleDisposableArr == f49933k) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[length + 1];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!e.a(this.f49934f, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    void a0(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = this.f49934f.get();
            int length = singleDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i8 = -1;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                } else if (singleDisposableArr[i9] == singleDisposable) {
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
                singleDisposableArr2 = f49932j;
            } else {
                SingleDisposable[] singleDisposableArr3 = new SingleDisposable[length - 1];
                System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i8);
                System.arraycopy(singleDisposableArr, i8 + 1, singleDisposableArr3, i8, (length - i8) - 1);
                singleDisposableArr2 = singleDisposableArr3;
            }
        } while (!e.a(this.f49934f, singleDisposableArr, singleDisposableArr2));
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f49935g.compareAndSet(false, true)) {
            this.f49937i = th;
            for (SingleDisposable<T> singleDisposable : this.f49934f.getAndSet(f49933k)) {
                singleDisposable.f49938f.onError(th);
            }
            return;
        }
        RxJavaPlugins.s(th);
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        if (this.f49934f.get() == f49933k) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
    public void onSuccess(T t7) {
        ObjectHelper.e(t7, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f49935g.compareAndSet(false, true)) {
            this.f49936h = t7;
            for (SingleDisposable<T> singleDisposable : this.f49934f.getAndSet(f49933k)) {
                singleDisposable.f49938f.onSuccess(t7);
            }
        }
    }
}
