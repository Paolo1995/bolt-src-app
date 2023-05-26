package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: f  reason: collision with root package name */
    OpenHashSet<Disposable> f47602f;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f47603g;

    public CompositeDisposable() {
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean a(Disposable disposable) {
        if (c(disposable)) {
            disposable.dispose();
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean b(Disposable disposable) {
        ObjectHelper.e(disposable, "disposable is null");
        if (!this.f47603g) {
            synchronized (this) {
                if (!this.f47603g) {
                    OpenHashSet<Disposable> openHashSet = this.f47602f;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.f47602f = openHashSet;
                    }
                    openHashSet.a(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean c(Disposable disposable) {
        ObjectHelper.e(disposable, "disposables is null");
        if (this.f47603g) {
            return false;
        }
        synchronized (this) {
            if (this.f47603g) {
                return false;
            }
            OpenHashSet<Disposable> openHashSet = this.f47602f;
            if (openHashSet != null && openHashSet.e(disposable)) {
                return true;
            }
            return false;
        }
    }

    public void d() {
        if (this.f47603g) {
            return;
        }
        synchronized (this) {
            if (this.f47603g) {
                return;
            }
            OpenHashSet<Disposable> openHashSet = this.f47602f;
            this.f47602f = null;
            e(openHashSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f47603g) {
            return;
        }
        synchronized (this) {
            if (this.f47603g) {
                return;
            }
            this.f47603g = true;
            OpenHashSet<Disposable> openHashSet = this.f47602f;
            this.f47602f = null;
            e(openHashSet);
        }
    }

    void e(OpenHashSet<Disposable> openHashSet) {
        Object[] b8;
        if (openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : openHashSet.b()) {
            if (obj instanceof Disposable) {
                try {
                    ((Disposable) obj).dispose();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.e((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    public int f() {
        int i8 = 0;
        if (this.f47603g) {
            return 0;
        }
        synchronized (this) {
            if (this.f47603g) {
                return 0;
            }
            OpenHashSet<Disposable> openHashSet = this.f47602f;
            if (openHashSet != null) {
                i8 = openHashSet.g();
            }
            return i8;
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f47603g;
    }

    public CompositeDisposable(Disposable... disposableArr) {
        ObjectHelper.e(disposableArr, "disposables is null");
        this.f47602f = new OpenHashSet<>(disposableArr.length + 1);
        for (Disposable disposable : disposableArr) {
            ObjectHelper.e(disposable, "A Disposable in the disposables array is null");
            this.f47602f.a(disposable);
        }
    }
}
