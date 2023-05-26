package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        if (obj instanceof Callable) {
            CompletableSource completableSource = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    completableSource = (CompletableSource) ObjectHelper.e(function.apply(obj2), "The mapper returned a null CompletableSource");
                }
                if (completableSource == null) {
                    EmptyDisposable.c(completableObserver);
                } else {
                    completableSource.a(completableObserver);
                }
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.f(th, completableObserver);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean b(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        if (obj instanceof Callable) {
            MaybeSource maybeSource = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    maybeSource = (MaybeSource) ObjectHelper.e(function.apply(obj2), "The mapper returned a null MaybeSource");
                }
                if (maybeSource == null) {
                    EmptyDisposable.e(observer);
                } else {
                    maybeSource.a(MaybeToObservable.c(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean c(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        if (obj instanceof Callable) {
            SingleSource singleSource = null;
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                if (obj2 != 0) {
                    singleSource = (SingleSource) ObjectHelper.e(function.apply(obj2), "The mapper returned a null SingleSource");
                }
                if (singleSource == null) {
                    EmptyDisposable.e(observer);
                } else {
                    singleSource.a(SingleToObservable.c(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
                return true;
            }
        }
        return false;
    }
}
