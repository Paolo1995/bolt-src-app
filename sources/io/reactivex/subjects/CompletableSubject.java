package io.reactivex.subjects;

import androidx.camera.view.e;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableSubject extends Completable implements CompletableObserver {

    /* renamed from: i  reason: collision with root package name */
    static final CompletableDisposable[] f49916i = new CompletableDisposable[0];

    /* renamed from: j  reason: collision with root package name */
    static final CompletableDisposable[] f49917j = new CompletableDisposable[0];

    /* renamed from: h  reason: collision with root package name */
    Throwable f49920h;

    /* renamed from: g  reason: collision with root package name */
    final AtomicBoolean f49919g = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<CompletableDisposable[]> f49918f = new AtomicReference<>(f49916i);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f49921f;

        CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.f49921f = completableObserver;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            CompletableSubject andSet = getAndSet(null);
            if (andSet != null) {
                andSet.P(this);
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

    CompletableSubject() {
    }

    public static CompletableSubject O() {
        return new CompletableSubject();
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (N(completableDisposable)) {
            if (completableDisposable.isDisposed()) {
                P(completableDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f49920h;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    boolean N(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f49918f.get();
            if (completableDisposableArr == f49917j) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[length + 1];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!e.a(this.f49918f, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    void P(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f49918f.get();
            int length = completableDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i8 = -1;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                } else if (completableDisposableArr[i9] == completableDisposable) {
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
                completableDisposableArr2 = f49916i;
            } else {
                CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[length - 1];
                System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i8);
                System.arraycopy(completableDisposableArr, i8 + 1, completableDisposableArr3, i8, (length - i8) - 1);
                completableDisposableArr2 = completableDisposableArr3;
            }
        } while (!e.a(this.f49918f, completableDisposableArr, completableDisposableArr2));
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.f49919g.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f49918f.getAndSet(f49917j)) {
                completableDisposable.f49921f.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f49919g.compareAndSet(false, true)) {
            this.f49920h = th;
            for (CompletableDisposable completableDisposable : this.f49918f.getAndSet(f49917j)) {
                completableDisposable.f49921f.onError(th);
            }
            return;
        }
        RxJavaPlugins.s(th);
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        if (this.f49918f.get() == f49917j) {
            disposable.dispose();
        }
    }
}
