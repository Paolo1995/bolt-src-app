package com.jakewharton.rxbinding3.view;

import android.view.View;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewClickObservable.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class RxView__ViewClickObservableKt {
    public static final Observable<Unit> a(View clicks) {
        Intrinsics.g(clicks, "$this$clicks");
        return new ViewClickObservable(clicks);
    }
}
