package eu.bolt.verification.sdk.internal;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class vg {

    /* renamed from: a  reason: collision with root package name */
    private final kb f45450a;

    /* renamed from: b  reason: collision with root package name */
    private final xg f45451b;

    /* renamed from: c  reason: collision with root package name */
    private final db f45452c;

    @Inject
    public vg(kb keyboardStateProvider, xg rxSchedulers, db keyboardController) {
        Intrinsics.f(keyboardStateProvider, "keyboardStateProvider");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(keyboardController, "keyboardController");
        this.f45450a = keyboardStateProvider;
        this.f45451b = rxSchedulers;
        this.f45452c = keyboardController;
    }
}
