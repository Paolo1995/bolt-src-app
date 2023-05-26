package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.d;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class dd {

    /* renamed from: a  reason: collision with root package name */
    private final xn f42639a;

    @Inject
    public dd(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f42639a = verificationFlowRepository;
    }

    public Observable<d.C0042d> a() {
        return this.f42639a.m();
    }
}
