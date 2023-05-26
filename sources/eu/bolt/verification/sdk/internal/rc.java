package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class rc {

    /* renamed from: a  reason: collision with root package name */
    private final xn f44808a;

    @Inject
    public rc(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f44808a = verificationFlowRepository;
    }

    public Observable<qn.b> a() {
        return this.f44808a.p();
    }
}
