package ee.mtakso.driver.utils;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: RetryWithDelayWithConditionSingle.kt */
/* loaded from: classes5.dex */
public final class RetryWithDelayWithConditionSingle implements Function<Flowable<Throwable>, Publisher<?>> {

    /* renamed from: f  reason: collision with root package name */
    private final int f36316f;

    /* renamed from: g  reason: collision with root package name */
    private final int f36317g;

    /* renamed from: h  reason: collision with root package name */
    private final Function<Throwable, Boolean> f36318h;

    /* renamed from: i  reason: collision with root package name */
    private int f36319i;

    public RetryWithDelayWithConditionSingle(int i8, int i9, Function<Throwable, Boolean> shouldContinueRetryFunc) {
        Intrinsics.f(shouldContinueRetryFunc, "shouldContinueRetryFunc");
        this.f36316f = i8;
        this.f36317g = i9;
        this.f36318h = shouldContinueRetryFunc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: g */
    public Publisher<?> apply(Flowable<Throwable> throwableFlowable) throws Exception {
        Intrinsics.f(throwableFlowable, "throwableFlowable");
        final Function1<Throwable, SingleSource<? extends Long>> function1 = new Function1<Throwable, SingleSource<? extends Long>>() { // from class: ee.mtakso.driver.utils.RetryWithDelayWithConditionSingle$apply$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Long> invoke(Throwable throwable) {
                int i8;
                int i9;
                int i10;
                Function function;
                int i11;
                Intrinsics.f(throwable, "throwable");
                RetryWithDelayWithConditionSingle retryWithDelayWithConditionSingle = RetryWithDelayWithConditionSingle.this;
                i8 = retryWithDelayWithConditionSingle.f36319i;
                retryWithDelayWithConditionSingle.f36319i = i8 + 1;
                i9 = retryWithDelayWithConditionSingle.f36319i;
                i10 = RetryWithDelayWithConditionSingle.this.f36316f;
                if (i9 < i10) {
                    function = RetryWithDelayWithConditionSingle.this.f36318h;
                    Object apply = function.apply(throwable);
                    Intrinsics.e(apply, "shouldContinueRetryFunc.apply(throwable)");
                    if (((Boolean) apply).booleanValue()) {
                        i11 = RetryWithDelayWithConditionSingle.this.f36317g;
                        return Single.P(i11, TimeUnit.MILLISECONDS, Schedulers.c());
                    }
                }
                return Single.error(throwable);
            }
        };
        Publisher D = throwableFlowable.D(new Function() { // from class: ee.mtakso.driver.utils.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource h8;
                h8 = RetryWithDelayWithConditionSingle.h(Function1.this, obj);
                return h8;
            }
        });
        Intrinsics.e(D, "@Throws(Exception::class…hrowable)\n        }\n    }");
        return D;
    }
}
