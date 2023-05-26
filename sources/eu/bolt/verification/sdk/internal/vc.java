package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class vc {

    /* renamed from: a  reason: collision with root package name */
    private final xn f45444a;

    @Inject
    public vc(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f45444a = verificationFlowRepository;
    }

    public Observable<String> a() {
        return this.f45444a.q();
    }
}
