package ee.mtakso.driver.service.auth;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: StoreVerificationBackoffStrategy.kt */
/* loaded from: classes3.dex */
public final class StoreVerificationBackoffStrategy {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public Flowable<Long> b(Flowable<Throwable> throwable, Function1<? super Throwable, Boolean> shouldNotContinueRetry) {
        Intrinsics.f(throwable, "throwable");
        Intrinsics.f(shouldNotContinueRetry, "shouldNotContinueRetry");
        final StoreVerificationBackoffStrategy$retryIn$1 storeVerificationBackoffStrategy$retryIn$1 = new StoreVerificationBackoffStrategy$retryIn$1(shouldNotContinueRetry, new AtomicInteger(0), new AtomicLong(5L));
        return throwable.w(new Function() { // from class: ee.mtakso.driver.service.auth.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher c8;
                c8 = StoreVerificationBackoffStrategy.c(Function1.this, obj);
                return c8;
            }
        });
    }
}
