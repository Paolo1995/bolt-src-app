package io.reactivex.internal.util;

import androidx.camera.view.e;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        RxJavaPlugins.s(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        ObjectHelper.e(disposable, "next is null");
        if (!e.a(atomicReference, null, disposable)) {
            disposable.dispose();
            if (atomicReference.get() != DisposableHelper.DISPOSED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean d(Disposable disposable, Disposable disposable2, Class<?> cls) {
        ObjectHelper.e(disposable2, "next is null");
        if (disposable != null) {
            disposable2.dispose();
            if (disposable != DisposableHelper.DISPOSED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }
}
