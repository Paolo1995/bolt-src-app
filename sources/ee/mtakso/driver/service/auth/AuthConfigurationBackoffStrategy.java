package ee.mtakso.driver.service.auth;

import ee.mtakso.driver.service.time.TrueTimeProvider;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: AuthConfigurationBackoffStrategy.kt */
/* loaded from: classes3.dex */
public final class AuthConfigurationBackoffStrategy {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f23556b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TrueTimeProvider f23557a;

    /* compiled from: AuthConfigurationBackoffStrategy.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AuthConfigurationBackoffStrategy(TrueTimeProvider trueTimeProvider) {
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        this.f23557a = trueTimeProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public Flowable<Long> c(Flowable<Throwable> throwable, final Function1<? super Throwable, Boolean> shouldNotContinueRetry) {
        Intrinsics.f(throwable, "throwable");
        Intrinsics.f(shouldNotContinueRetry, "shouldNotContinueRetry");
        final long a8 = this.f23557a.a();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final Function1<Throwable, Publisher<? extends Long>> function1 = new Function1<Throwable, Publisher<? extends Long>>() { // from class: ee.mtakso.driver.service.auth.AuthConfigurationBackoffStrategy$retryIn$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Publisher<? extends Long> invoke(Throwable it) {
                TrueTimeProvider trueTimeProvider;
                boolean z7;
                Intrinsics.f(it, "it");
                trueTimeProvider = AuthConfigurationBackoffStrategy.this.f23557a;
                if (trueTimeProvider.a() - a8 > 10) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (shouldNotContinueRetry.invoke(it).booleanValue()) {
                    return Flowable.s(it);
                }
                if (z7) {
                    return Flowable.s(it);
                }
                atomicInteger.incrementAndGet();
                if (atomicInteger.get() <= 2) {
                    return Flowable.d0(0L, TimeUnit.SECONDS);
                }
                if (atomicInteger.get() == 3) {
                    return Flowable.d0(1L, TimeUnit.SECONDS);
                }
                return Flowable.s(it);
            }
        };
        return throwable.w(new Function() { // from class: ee.mtakso.driver.service.auth.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher d8;
                d8 = AuthConfigurationBackoffStrategy.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
