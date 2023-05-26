package ee.mtakso.driver.network.client.campaign;

import dagger.Lazy;
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

/* compiled from: CircleKClient.kt */
/* loaded from: classes3.dex */
public final class CircleKClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<CircleKApi> f21621a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f21622b;

    @Inject
    public CircleKClient(Lazy<CircleKApi> api, ResponseErrorProcessor errorResponseProcessor) {
        Intrinsics.f(api, "api");
        Intrinsics.f(errorResponseProcessor, "errorResponseProcessor");
        this.f21621a = api;
        this.f21622b = errorResponseProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CircleKLoyaltySignUpMagicLink f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CircleKLoyaltySignUpMagicLink) tmp0.invoke(obj);
    }

    public final Single<CircleKLoyaltySignUpMagicLink> d() {
        Single<ServerResponse<CircleKLoyaltySignUpMagicLink>> a8 = this.f21621a.get().a();
        final Function1<ServerResponse<CircleKLoyaltySignUpMagicLink>, Unit> function1 = new Function1<ServerResponse<CircleKLoyaltySignUpMagicLink>, Unit>() { // from class: ee.mtakso.driver.network.client.campaign.CircleKClient$getLoyaltySignUpMagicLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<CircleKLoyaltySignUpMagicLink> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = CircleKClient.this.f21622b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<CircleKLoyaltySignUpMagicLink> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<CircleKLoyaltySignUpMagicLink>> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.campaign.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CircleKClient.e(Function1.this, obj);
            }
        });
        final CircleKClient$getLoyaltySignUpMagicLink$2 circleKClient$getLoyaltySignUpMagicLink$2 = new Function1<ServerResponse<CircleKLoyaltySignUpMagicLink>, CircleKLoyaltySignUpMagicLink>() { // from class: ee.mtakso.driver.network.client.campaign.CircleKClient$getLoyaltySignUpMagicLink$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CircleKLoyaltySignUpMagicLink invoke(ServerResponse<CircleKLoyaltySignUpMagicLink> it) {
                Intrinsics.f(it, "it");
                return (CircleKLoyaltySignUpMagicLink) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.campaign.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CircleKLoyaltySignUpMagicLink f8;
                f8 = CircleKClient.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(x7, "fun getLoyaltySignUpMagi…{ it.exposeData() }\n    }");
        return x7;
    }
}
