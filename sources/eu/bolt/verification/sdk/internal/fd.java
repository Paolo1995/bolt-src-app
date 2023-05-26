package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.d;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class fd {

    /* renamed from: a  reason: collision with root package name */
    private final xn f42980a;

    @Inject
    public fd(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f42980a = verificationFlowRepository;
    }

    public Observable<d.e> a() {
        return this.f42980a.t();
    }
}
