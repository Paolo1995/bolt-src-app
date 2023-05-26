package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: f  reason: collision with root package name */
    List<Disposable> f47614f;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f47615g;

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
        ObjectHelper.e(disposable, "d is null");
        if (!this.f47615g) {
            synchronized (this) {
                if (!this.f47615g) {
                    List list = this.f47614f;
                    if (list == null) {
                        list = new LinkedList();
                        this.f47614f = list;
                    }
                    list.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public boolean c(Disposable disposable) {
        ObjectHelper.e(disposable, "Disposable item is null");
        if (this.f47615g) {
            return false;
        }
        synchronized (this) {
            if (this.f47615g) {
                return false;
            }
            List<Disposable> list = this.f47614f;
            if (list != null && list.remove(disposable)) {
                return true;
            }
            return false;
        }
    }

    void d(List<Disposable> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Disposable disposable : list) {
            try {
                disposable.dispose();
            } catch (Throwable th) {
                Exceptions.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.e((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f47615g) {
            return;
        }
        synchronized (this) {
            if (this.f47615g) {
                return;
            }
            this.f47615g = true;
            List<Disposable> list = this.f47614f;
            this.f47614f = null;
            d(list);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f47615g;
    }
}
