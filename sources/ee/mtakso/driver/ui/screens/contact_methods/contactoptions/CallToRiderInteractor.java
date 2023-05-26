package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.OutgoingCallInfo;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallToRiderInteractor.kt */
/* loaded from: classes3.dex */
public final class CallToRiderInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final VoipCallDelegate f27763a;

    @Inject
    public CallToRiderInteractor(VoipCallDelegate callDelegate) {
        Intrinsics.f(callDelegate, "callDelegate");
        this.f27763a = callDelegate;
    }

    public final Single<OutgoingCallInfo> a(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return this.f27763a.f(orderHandle);
    }
}
