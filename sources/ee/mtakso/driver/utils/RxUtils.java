package ee.mtakso.driver.utils;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/* loaded from: classes5.dex */
public class RxUtils {
    public static <R> Observable<R> a(Observable<R> observable) {
        return observable.observeOn(AndroidSchedulers.a()).subscribeOn(Schedulers.a());
    }

    public static <R> Observable<R> b(Observable<R> observable) {
        return observable.observeOn(AndroidSchedulers.a()).subscribeOn(Schedulers.c());
    }

    public static <R> Single<R> c(Single<R> single) {
        return single.z(AndroidSchedulers.a()).K(Schedulers.c());
    }

    public static void d(Disposable... disposableArr) {
        if (disposableArr != null) {
            for (Disposable disposable : disposableArr) {
                if (disposable != null && !disposable.isDisposed()) {
                    disposable.dispose();
                }
            }
        }
    }
}
