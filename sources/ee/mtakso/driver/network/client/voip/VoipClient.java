package ee.mtakso.driver.network.client.voip;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipClient.kt */
/* loaded from: classes3.dex */
public final class VoipClient {

    /* renamed from: a  reason: collision with root package name */
    private final VoipApi f22906a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f22907b;

    @Inject
    public VoipClient(VoipApi api, ResponseErrorProcessor errorResponseProcessor) {
        Intrinsics.f(api, "api");
        Intrinsics.f(errorResponseProcessor, "errorResponseProcessor");
        this.f22906a = api;
        this.f22907b = errorResponseProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallbackOptions g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CallbackOptions) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Single<CallbackOptions> e(String context) {
        Intrinsics.f(context, "context");
        Single<ServerResponse<CallbackOptions>> a8 = this.f22906a.a(context);
        final Function1<ServerResponse<CallbackOptions>, Unit> function1 = new Function1<ServerResponse<CallbackOptions>, Unit>() { // from class: ee.mtakso.driver.network.client.voip.VoipClient$getCallbackOption$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<CallbackOptions> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = VoipClient.this.f22907b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<CallbackOptions> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<CallbackOptions>> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.voip.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipClient.f(Function1.this, obj);
            }
        });
        final VoipClient$getCallbackOption$2 voipClient$getCallbackOption$2 = new Function1<ServerResponse<CallbackOptions>, CallbackOptions>() { // from class: ee.mtakso.driver.network.client.voip.VoipClient$getCallbackOption$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CallbackOptions invoke(ServerResponse<CallbackOptions> it) {
                Intrinsics.f(it, "it");
                return (CallbackOptions) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.voip.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CallbackOptions g8;
                g8 = VoipClient.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(x7, "fun getCallbackOption(co…{ it.exposeData() }\n    }");
        return x7;
    }

    public final Single<EmptyServerResponse> h(int i8, String callId) {
        Intrinsics.f(callId, "callId");
        Single<EmptyServerResponse> b8 = this.f22906a.b(i8, callId);
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.network.client.voip.VoipClient$rateCall$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = VoipClient.this.f22907b;
                responseErrorProcessor.c(emptyServerResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Single<EmptyServerResponse> o8 = b8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.voip.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipClient.i(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun rateCall(rating: Int…rApiException(it) }\n    }");
        return o8;
    }
}
