package ee.mtakso.driver.utils.retry;

import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.utils.retry.StandardExponentialBackoffStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: StandardExponentialBackoffStrategy.kt */
/* loaded from: classes5.dex */
public final class StandardExponentialBackoffStrategy {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f36464b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TrueTimeProvider f36465a;

    /* compiled from: StandardExponentialBackoffStrategy.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public StandardExponentialBackoffStrategy(TrueTimeProvider trueTimeProvider) {
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        this.f36465a = trueTimeProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public Flowable<Long> c(Flowable<Throwable> throwable, final Function1<? super Throwable, Boolean> shouldNotContinueRetry) {
        Intrinsics.f(throwable, "throwable");
        Intrinsics.f(shouldNotContinueRetry, "shouldNotContinueRetry");
        final long a8 = this.f36465a.a();
        final AtomicLong atomicLong = new AtomicLong(0L);
        final Function1<Throwable, Publisher<? extends Long>> function1 = new Function1<Throwable, Publisher<? extends Long>>() { // from class: ee.mtakso.driver.utils.retry.StandardExponentialBackoffStrategy$retryIn$1
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
                trueTimeProvider = StandardExponentialBackoffStrategy.this.f36465a;
                if (trueTimeProvider.a() - a8 >= 10) {
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
                long incrementAndGet = atomicLong.incrementAndGet();
                if (incrementAndGet == 1) {
                    return Flowable.d0(0L, TimeUnit.SECONDS);
                }
                return Flowable.d0(incrementAndGet, TimeUnit.SECONDS);
            }
        };
        return throwable.w(new Function() { // from class: b6.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher d8;
                d8 = StandardExponentialBackoffStrategy.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
