package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.Channel;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.contact.ContactOptionsDetails;
import ee.mtakso.driver.network.client.contact.VoipContactDetails;
import ee.mtakso.driver.network.client.voip.CallbackOptions;
import ee.mtakso.driver.network.client.voip.VoipClient;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.service.voip.VoipConnectionExtKt;
import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerIncomingCall;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.voip_client.VoipPeer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCallDelegate.kt */
/* loaded from: classes3.dex */
public final class VoipCallDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final VoipService f27923a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipClient f27924b;

    /* renamed from: c  reason: collision with root package name */
    private final ContactClient f27925c;

    /* renamed from: d  reason: collision with root package name */
    private final VoipCache f27926d;

    @Inject
    public VoipCallDelegate(VoipService voipService, VoipClient voipClient, ContactClient contactClient, VoipCache voipCache) {
        Intrinsics.f(voipService, "voipService");
        Intrinsics.f(voipClient, "voipClient");
        Intrinsics.f(contactClient, "contactClient");
        Intrinsics.f(voipCache, "voipCache");
        this.f27923a = voipService;
        this.f27924b = voipClient;
        this.f27925c = contactClient;
        this.f27926d = voipCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutgoingCallInfo e(OrderHandle orderHandle, VoipContactDetails voipContactDetails) {
        this.f27926d.b(orderHandle);
        this.f27923a.q(new VoipPeer(voipContactDetails.d(), voipContactDetails.b(), voipContactDetails.c()), VoipConnectionExtKt.a(voipContactDetails));
        return new OutgoingCallInfo(new VoipOptionsData(voipContactDetails));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OutgoingCallInfo g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OutgoingCallInfo) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource i(final NoAnswerIncomingCall call, final VoipCallDelegate this$0) {
        Intrinsics.f(call, "$call");
        Intrinsics.f(this$0, "this$0");
        String b8 = VoipConnectionExtKt.b(call.b());
        if (b8 == null) {
            return Single.w(new OutgoingCallInfo(null));
        }
        Single d8 = SingleExtKt.d(this$0.f27924b.e(b8));
        final Function1<CallbackOptions, OutgoingCallInfo> function1 = new Function1<CallbackOptions, OutgoingCallInfo>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate$callBack$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OutgoingCallInfo invoke(CallbackOptions callbackOptions) {
                OutgoingCallInfo e8;
                Intrinsics.f(callbackOptions, "callbackOptions");
                if (callbackOptions.a() != null) {
                    e8 = VoipCallDelegate.this.e(call.a(), callbackOptions.a());
                    return e8;
                }
                return new OutgoingCallInfo(null);
            }
        };
        return d8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OutgoingCallInfo j8;
                j8 = VoipCallDelegate.j(Function1.this, obj);
                return j8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OutgoingCallInfo j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OutgoingCallInfo) tmp0.invoke(obj);
    }

    public final Single<OutgoingCallInfo> f(final OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single d8 = SingleExtKt.d(this.f27925c.h(Channel.VOIP, orderHandle));
        final Function1<ContactOptionsDetails, OutgoingCallInfo> function1 = new Function1<ContactOptionsDetails, OutgoingCallInfo>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OutgoingCallInfo invoke(ContactOptionsDetails details) {
                OutgoingCallInfo e8;
                Intrinsics.f(details, "details");
                if (details instanceof VoipContactDetails) {
                    e8 = VoipCallDelegate.this.e(orderHandle, (VoipContactDetails) details);
                    return e8;
                }
                return new OutgoingCallInfo(null);
            }
        };
        Single<OutgoingCallInfo> x7 = d8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OutgoingCallInfo g8;
                g8 = VoipCallDelegate.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(x7, "fun call(orderHandle: Or…    }\n            }\n    }");
        return x7;
    }

    public final Single<OutgoingCallInfo> h(final NoAnswerIncomingCall call) {
        Intrinsics.f(call, "call");
        Single<OutgoingCallInfo> g8 = Single.g(new Callable() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SingleSource i8;
                i8 = VoipCallDelegate.i(NoAnswerIncomingCall.this, this);
                return i8;
            }
        });
        Intrinsics.e(g8, "defer {\n            when…}\n            }\n        }");
        return g8;
    }
}
