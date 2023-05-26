package io.reactivex.subjects;

import androidx.camera.view.e;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class PublishSubject<T> extends Subject<T> {

    /* renamed from: h  reason: collision with root package name */
    static final PublishDisposable[] f49922h = new PublishDisposable[0];

    /* renamed from: i  reason: collision with root package name */
    static final PublishDisposable[] f49923i = new PublishDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<PublishDisposable<T>[]> f49924f = new AtomicReference<>(f49923i);

    /* renamed from: g  reason: collision with root package name */
    Throwable f49925g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49926f;

        /* renamed from: g  reason: collision with root package name */
        final PublishSubject<T> f49927g;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.f49926f = observer;
            this.f49927g = publishSubject;
        }

        public void a() {
            if (!get()) {
                this.f49926f.onComplete();
            }
        }

        public void b(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f49926f.onError(th);
            }
        }

        public void c(T t7) {
            if (!get()) {
                this.f49926f.onNext(t7);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f49927g.g(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    PublishSubject() {
    }

    public static <T> PublishSubject<T> e() {
        return new PublishSubject<>();
    }

    boolean d(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f49924f.get();
            if (publishDisposableArr == f49922h) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!e.a(this.f49924f, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    public boolean f() {
        if (this.f49924f.get().length != 0) {
            return true;
        }
        return false;
    }

    void g(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f49924f.get();
            if (publishDisposableArr != f49922h && publishDisposableArr != f49923i) {
                int length = publishDisposableArr.length;
                int i8 = -1;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    } else if (publishDisposableArr[i9] == publishDisposable) {
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
                    publishDisposableArr2 = f49923i;
                } else {
                    PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                    System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i8);
                    System.arraycopy(publishDisposableArr, i8 + 1, publishDisposableArr3, i8, (length - i8) - 1);
                    publishDisposableArr2 = publishDisposableArr3;
                }
            } else {
                return;
            }
        } while (!e.a(this.f49924f, publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f49924f.get();
        PublishDisposable<T>[] publishDisposableArr2 = f49922h;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.f49924f.getAndSet(publishDisposableArr2)) {
            publishDisposable.a();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f49924f.get();
        PublishDisposable<T>[] publishDisposableArr2 = f49922h;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f49925g = th;
        for (PublishDisposable<T> publishDisposable : this.f49924f.getAndSet(publishDisposableArr2)) {
            publishDisposable.b(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        ObjectHelper.e(t7, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.f49924f.get()) {
            publishDisposable.c(t7);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f49924f.get() == f49922h) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        if (d(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                g(publishDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f49925g;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }
}
