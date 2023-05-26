package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class bd {

    /* renamed from: a  reason: collision with root package name */
    private final xn f42311a;

    @Inject
    public bd(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f42311a = verificationFlowRepository;
    }

    public Observable<Boolean> a() {
        return this.f42311a.s();
    }
}
