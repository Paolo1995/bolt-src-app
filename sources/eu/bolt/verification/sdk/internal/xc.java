package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class xc {

    /* renamed from: a  reason: collision with root package name */
    private final xn f45644a;

    @Inject
    public xc(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f45644a = verificationFlowRepository;
    }

    public Observable<VerificationFlowStatus> a() {
        return this.f45644a.r();
    }
}
