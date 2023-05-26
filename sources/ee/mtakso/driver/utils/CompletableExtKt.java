package ee.mtakso.driver.utils;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompletableExt.kt */
/* loaded from: classes5.dex */
public final class CompletableExtKt {
    public static final Completable a(Completable completable) {
        Intrinsics.f(completable, "<this>");
        Completable I = completable.z(AndroidSchedulers.a()).I(Schedulers.c());
        Intrinsics.e(I, "observeOn(AndroidSchedul…scribeOn(Schedulers.io())");
        return I;
    }
}
