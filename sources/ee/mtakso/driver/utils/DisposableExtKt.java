package ee.mtakso.driver.utils;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisposableExt.kt */
/* loaded from: classes5.dex */
public final class DisposableExtKt {
    public static final void a(Disposable disposable) {
        Intrinsics.f(disposable, "<this>");
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public static final boolean b(Disposable disposable) {
        if (disposable != null) {
            return disposable.isDisposed();
        }
        return true;
    }
}
