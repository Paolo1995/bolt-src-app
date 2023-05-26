package ee.mtakso.driver.network.client.partner;

import ee.mtakso.driver.network.client.auth.anonymous.RefreshToken;
import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerClient.kt */
/* loaded from: classes3.dex */
public final class PartnerClient {

    /* renamed from: a  reason: collision with root package name */
    private final PartnerApi f22643a;

    @Inject
    public PartnerClient(PartnerApi partnerApi) {
        Intrinsics.f(partnerApi, "partnerApi");
        this.f22643a = partnerApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RefreshToken c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (RefreshToken) tmp0.invoke(obj);
    }

    public final Single<RefreshToken> b() {
        Single<ServerResponse<RefreshToken>> b8 = this.f22643a.b();
        final PartnerClient$exchangeToken$1 partnerClient$exchangeToken$1 = new Function1<ServerResponse<RefreshToken>, RefreshToken>() { // from class: ee.mtakso.driver.network.client.partner.PartnerClient$exchangeToken$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final RefreshToken invoke(ServerResponse<RefreshToken> it) {
                Intrinsics.f(it, "it");
                return (RefreshToken) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.partner.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RefreshToken c8;
                c8 = PartnerClient.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "partnerApi.exchangeToken… .map { it.exposeData() }");
        return x7;
    }

    public final Completable d(String deviceToken) {
        Intrinsics.f(deviceToken, "deviceToken");
        Completable v7 = this.f22643a.a(deviceToken).v();
        Intrinsics.e(v7, "partnerApi.setDeviceToke…iceToken).ignoreElement()");
        return v7;
    }
}
