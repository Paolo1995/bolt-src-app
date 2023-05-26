package ee.mtakso.driver.service.token;

import ee.mtakso.driver.network.ApiExceptionProvider;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.service.BaseServiceImpl;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidateTokenService.kt */
/* loaded from: classes3.dex */
public final class InvalidateTokenService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final ApiExceptionProvider f26025b;

    /* renamed from: c  reason: collision with root package name */
    private final TokenManager f26026c;

    @Inject
    public InvalidateTokenService(ApiExceptionProvider apiExceptionProvider, TokenManager tokenManager) {
        Intrinsics.f(apiExceptionProvider, "apiExceptionProvider");
        Intrinsics.f(tokenManager, "tokenManager");
        this.f26025b = apiExceptionProvider;
        this.f26026c = tokenManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<ApiException> b8 = this.f26025b.b();
        final InvalidateTokenService$doStart$1 invalidateTokenService$doStart$1 = new Function1<ApiException, Boolean>() { // from class: ee.mtakso.driver.service.token.InvalidateTokenService$doStart$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ApiException it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it.c() == 503) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ApiException> filter = b8.filter(new Predicate() { // from class: ee.mtakso.driver.service.token.a
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean j8;
                j8 = InvalidateTokenService.j(Function1.this, obj);
                return j8;
            }
        });
        final Function1<ApiException, Unit> function1 = new Function1<ApiException, Unit>() { // from class: ee.mtakso.driver.service.token.InvalidateTokenService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ApiException apiException) {
                TokenManager tokenManager;
                tokenManager = InvalidateTokenService.this.f26026c;
                tokenManager.u();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ApiException apiException) {
                b(apiException);
                return Unit.f50853a;
            }
        };
        Consumer<? super ApiException> consumer = new Consumer() { // from class: ee.mtakso.driver.service.token.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InvalidateTokenService.k(Function1.this, obj);
            }
        };
        final InvalidateTokenService$doStart$3 invalidateTokenService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.token.InvalidateTokenService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to observe api error");
            }
        };
        Disposable subscribe = filter.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.token.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                InvalidateTokenService.l(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …or\")\n            })\n    }");
        return subscribe;
    }
}
