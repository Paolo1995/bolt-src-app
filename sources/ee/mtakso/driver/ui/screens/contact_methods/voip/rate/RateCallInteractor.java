package ee.mtakso.driver.ui.screens.contact_methods.voip.rate;

import ee.mtakso.driver.network.client.voip.VoipClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateCallInteractor.kt */
/* loaded from: classes3.dex */
public final class RateCallInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final VoipClient f28088a;

    @Inject
    public RateCallInteractor(VoipClient apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        this.f28088a = apiClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Unit) tmp0.invoke(obj);
    }

    public final Single<Unit> b(int i8, String callId) {
        Intrinsics.f(callId, "callId");
        Single<EmptyServerResponse> h8 = this.f28088a.h(i8, callId);
        final RateCallInteractor$rate$1 rateCallInteractor$rate$1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallInteractor$rate$1
            public final void b(EmptyServerResponse it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Single x7 = h8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Unit c8;
                c8 = RateCallInteractor.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "apiClient.rateCall(ratin…            .map { Unit }");
        return x7;
    }
}
