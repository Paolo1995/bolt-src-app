package ee.mtakso.driver.service.auth;

import io.reactivex.Flowable;
import j$.util.concurrent.atomic.DesugarAtomicLong;
import j$.util.function.LongUnaryOperator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.reactivestreams.Publisher;

/* compiled from: StoreVerificationBackoffStrategy.kt */
/* loaded from: classes3.dex */
final class StoreVerificationBackoffStrategy$retryIn$1 extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Function1<Throwable, Boolean> f23744f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ AtomicInteger f23745g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AtomicLong f23746h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StoreVerificationBackoffStrategy$retryIn$1(Function1<? super Throwable, Boolean> function1, AtomicInteger atomicInteger, AtomicLong atomicLong) {
        super(1);
        this.f23744f = function1;
        this.f23745g = atomicInteger;
        this.f23746h = atomicLong;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long d(long j8) {
        return j8 * 2;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final Publisher<? extends Long> invoke(Throwable it) {
        Intrinsics.f(it, "it");
        if (this.f23744f.invoke(it).booleanValue()) {
            return Flowable.s(it);
        }
        if (this.f23745g.incrementAndGet() != 1) {
            DesugarAtomicLong.updateAndGet(this.f23746h, new LongUnaryOperator() { // from class: ee.mtakso.driver.service.auth.l
                @Override // j$.util.function.LongUnaryOperator
                public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
                    return LongUnaryOperator.CC.$default$andThen(this, longUnaryOperator);
                }

                @Override // j$.util.function.LongUnaryOperator
                public final long applyAsLong(long j8) {
                    long d8;
                    d8 = StoreVerificationBackoffStrategy$retryIn$1.d(j8);
                    return d8;
                }

                @Override // j$.util.function.LongUnaryOperator
                public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
                    return LongUnaryOperator.CC.$default$compose(this, longUnaryOperator);
                }
            });
        }
        if (this.f23745g.get() <= 3) {
            return Flowable.d0(this.f23746h.get(), TimeUnit.SECONDS);
        }
        return Flowable.s(it);
    }
}
