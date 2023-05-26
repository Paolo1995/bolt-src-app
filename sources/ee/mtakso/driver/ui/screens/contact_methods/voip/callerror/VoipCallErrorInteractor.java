package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.PhoneOptionsData;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.voip_client.VoipCall;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCallErrorInteractor.kt */
/* loaded from: classes3.dex */
public final class VoipCallErrorInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final ContactOptionsDelegate f27858a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipCallErrorDelegate f27859b;

    @Inject
    public VoipCallErrorInteractor(ContactOptionsDelegate contactOptionsDelegate, VoipCallErrorDelegate voipCallErrorDelegate) {
        Intrinsics.f(contactOptionsDelegate, "contactOptionsDelegate");
        Intrinsics.f(voipCallErrorDelegate, "voipCallErrorDelegate");
        this.f27858a = contactOptionsDelegate;
        this.f27859b = voipCallErrorDelegate;
    }

    public final Single<Optional<ContactOptionsData>> a(VoipCall.Type callType) {
        Intrinsics.f(callType, "callType");
        return this.f27859b.d(callType);
    }

    public final Single<Optional<PhoneOptionsData>> b(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return this.f27858a.n(orderHandle);
    }
}
