package ee.mtakso.driver.network.client.modal;

import dagger.Lazy;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.driver.core.util.AssertUtils;
import eu.bolt.driver.core.util.RateLimiter;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalClient.kt */
/* loaded from: classes3.dex */
public final class ModalClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<ModalApi> f22278a;

    /* renamed from: b  reason: collision with root package name */
    private final RateLimiter f22279b;

    @Inject
    public ModalClient(Lazy<ModalApi> modalApi) {
        Intrinsics.f(modalApi, "modalApi");
        this.f22278a = modalApi;
        this.f22279b = new RateLimiter(1.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Single<Optional<ModalDialogResponse>> b(String event) {
        Intrinsics.f(event, "event");
        if (!RateLimiter.e(this.f22279b, 0, 1, null)) {
            AssertUtils.b(AssertUtils.f41299a, null, 1, null);
        }
        Single<ServerResponse<ModalDialogResponse>> b8 = this.f22278a.get().b(event);
        final ModalClient$getModalDialog$1 modalClient$getModalDialog$1 = new Function1<ServerResponse<ModalDialogResponse>, Optional<ModalDialogResponse>>() { // from class: ee.mtakso.driver.network.client.modal.ModalClient$getModalDialog$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<ModalDialogResponse> invoke(ServerResponse<ModalDialogResponse> it) {
                Intrinsics.f(it, "it");
                return ServerResponseKt.c(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.modal.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional c8;
                c8 = ModalClient.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "modalApi.get()\n         …p { it.exposeOptional() }");
        return x7;
    }

    public final Single<EmptyServerResponse> d(ModalDialogActionReport request) {
        Intrinsics.f(request, "request");
        return this.f22278a.get().a(request);
    }
}
