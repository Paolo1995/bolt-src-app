package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class pc {

    /* renamed from: a  reason: collision with root package name */
    private final xn f44529a;

    @Inject
    public pc(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f44529a = verificationFlowRepository;
    }

    public Observable<Unit> a() {
        return this.f44529a.o();
    }
}
