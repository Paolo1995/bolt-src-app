package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class nc {

    /* renamed from: a  reason: collision with root package name */
    private final xn f44321a;

    @Inject
    public nc(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f44321a = verificationFlowRepository;
    }

    public Observable<Unit> a() {
        return this.f44321a.b();
    }
}
