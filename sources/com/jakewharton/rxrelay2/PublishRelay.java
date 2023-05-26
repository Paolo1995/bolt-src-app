package com.jakewharton.rxrelay2;

import androidx.camera.view.e;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class PublishRelay<T> extends Relay<T> {

    /* renamed from: g  reason: collision with root package name */
    static final PublishDisposable[] f18955g = new PublishDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<PublishDisposable<T>[]> f18956f = new AtomicReference<>(f18955g);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f18957f;

        /* renamed from: g  reason: collision with root package name */
        final PublishRelay<T> f18958g;

        PublishDisposable(Observer<? super T> observer, PublishRelay<T> publishRelay) {
            this.f18957f = observer;
            this.f18958g = publishRelay;
        }

        public void a(T t7) {
            if (!get()) {
                this.f18957f.onNext(t7);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f18958g.f(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    PublishRelay() {
    }

    public static <T> PublishRelay<T> e() {
        return new PublishRelay<>();
    }

    @Override // com.jakewharton.rxrelay2.Relay, io.reactivex.functions.Consumer
    public void accept(T t7) {
        if (t7 != null) {
            for (PublishDisposable<T> publishDisposable : this.f18956f.get()) {
                publishDisposable.a(t7);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    void d(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f18956f.get();
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!e.a(this.f18956f, publishDisposableArr, publishDisposableArr2));
    }

    void f(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f18956f.get();
            if (publishDisposableArr == f18955g) {
                return;
            }
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
                publishDisposableArr2 = f18955g;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i8);
                System.arraycopy(publishDisposableArr, i8 + 1, publishDisposableArr3, i8, (length - i8) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!e.a(this.f18956f, publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        d(publishDisposable);
        if (publishDisposable.isDisposed()) {
            f(publishDisposable);
        }
    }
}
