package io.reactivex.internal.disposables;

import androidx.camera.view.e;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public enum DisposableHelper implements Disposable {
    DISPOSED;

    public static boolean a(AtomicReference<Disposable> atomicReference) {
        Disposable andSet;
        Disposable disposable = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (disposable != disposableHelper && (andSet = atomicReference.getAndSet(disposableHelper)) != disposableHelper) {
            if (andSet != null) {
                andSet.dispose();
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean c(Disposable disposable) {
        if (disposable == DISPOSED) {
            return true;
        }
        return false;
    }

    public static boolean e(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.dispose();
                    return false;
                }
                return false;
            }
        } while (!e.a(atomicReference, disposable2, disposable));
        return true;
    }

    public static void f() {
        RxJavaPlugins.s(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean h(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable != null) {
                    disposable.dispose();
                    return false;
                }
                return false;
            }
        } while (!e.a(atomicReference, disposable2, disposable));
        if (disposable2 != null) {
            disposable2.dispose();
            return true;
        }
        return true;
    }

    public static boolean j(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        ObjectHelper.e(disposable, "d is null");
        if (!e.a(atomicReference, null, disposable)) {
            disposable.dispose();
            if (atomicReference.get() != DISPOSED) {
                f();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean k(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        if (!e.a(atomicReference, null, disposable)) {
            if (atomicReference.get() == DISPOSED) {
                disposable.dispose();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean l(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.s(new NullPointerException("next is null"));
            return false;
        } else if (disposable != null) {
            disposable2.dispose();
            f();
            return false;
        } else {
            return true;
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }
}
