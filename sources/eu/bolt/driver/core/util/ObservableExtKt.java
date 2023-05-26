package eu.bolt.driver.core.util;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObservableExt.kt */
/* loaded from: classes5.dex */
public final class ObservableExtKt {
    public static final <T> Observable<T> a(Observable<T> observable) {
        Intrinsics.f(observable, "<this>");
        Observable<T> observeOn = observable.subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "subscribeOn(Schedulers.i…dSchedulers.mainThread())");
        return observeOn;
    }
}
