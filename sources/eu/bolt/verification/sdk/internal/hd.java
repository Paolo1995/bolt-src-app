package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class hd {

    /* renamed from: a  reason: collision with root package name */
    private final xn f43391a;

    @Inject
    public hd(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f43391a = verificationFlowRepository;
    }

    public Observable<vd<kp>> a() {
        return this.f43391a.u();
    }
}
