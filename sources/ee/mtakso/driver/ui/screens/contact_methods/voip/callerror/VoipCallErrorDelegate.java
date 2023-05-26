package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.voip_client.VoipCall;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCallErrorDelegate.kt */
/* loaded from: classes3.dex */
public final class VoipCallErrorDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final ContactOptionsDelegate f27842a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipOrderInformationDelegate f27843b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipCache f27844c;

    /* compiled from: VoipCallErrorDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27845a;

        static {
            int[] iArr = new int[VoipCall.Type.values().length];
            try {
                iArr[VoipCall.Type.INCOMING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoipCall.Type.OUTGOING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f27845a = iArr;
        }
    }

    @Inject
    public VoipCallErrorDelegate(ContactOptionsDelegate contactOptionsDelegate, VoipOrderInformationDelegate voipOrderInformationDelegate, VoipCache voipCache) {
        Intrinsics.f(contactOptionsDelegate, "contactOptionsDelegate");
        Intrinsics.f(voipOrderInformationDelegate, "voipOrderInformationDelegate");
        Intrinsics.f(voipCache, "voipCache");
        this.f27842a = contactOptionsDelegate;
        this.f27843b = voipOrderInformationDelegate;
        this.f27844c = voipCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public final Single<Optional<ContactOptionsData>> d(VoipCall.Type callType) {
        Intrinsics.f(callType, "callType");
        int i8 = WhenMappings.f27845a[callType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                Single<Optional<OrderHandle>> firstOrError = this.f27843b.t().firstOrError();
                final VoipCallErrorDelegate$getAvailableContactOptions$1 voipCallErrorDelegate$getAvailableContactOptions$1 = new VoipCallErrorDelegate$getAvailableContactOptions$1(this);
                Single r7 = firstOrError.r(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.a
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        SingleSource e8;
                        e8 = VoipCallErrorDelegate.e(Function1.this, obj);
                        return e8;
                    }
                });
                Intrinsics.e(r7, "fun getAvailableContactO…        }\n        }\n    }");
                return r7;
            }
            throw new NoWhenBranchMatchedException();
        }
        Single<Optional<ContactOptionsData>> w7 = Single.w(Optional.a());
        Intrinsics.e(w7, "just(Optional.empty())");
        return w7;
    }
}
