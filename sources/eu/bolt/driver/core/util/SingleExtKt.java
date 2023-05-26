package eu.bolt.driver.core.util;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleExt.kt */
/* loaded from: classes5.dex */
public final class SingleExtKt {
    public static final <T> Single<T> a(Single<T> single) {
        Intrinsics.f(single, "<this>");
        Single<T> z7 = single.K(Schedulers.c()).z(AndroidSchedulers.a());
        Intrinsics.e(z7, "subscribeOn(Schedulers.i…dSchedulers.mainThread())");
        return z7;
    }
}
