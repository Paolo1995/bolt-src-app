package eu.bolt.chat.tools.rx;

import eu.bolt.chat.tools.ToolsKit;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: RetryWithDelaySingle.kt */
/* loaded from: classes5.dex */
public final class RetryWithDelaySingle<T> implements Function<Flowable<Throwable>, Publisher<?>> {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f39663k = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private static final Function1<Throwable, Boolean> f39664l = new Function1<Throwable, Boolean>() { // from class: eu.bolt.chat.tools.rx.RetryWithDelaySingle$Companion$DEFAULT_PREDICATE$1
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(Throwable it) {
            Intrinsics.f(it, "it");
            return Boolean.TRUE;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f39665f;

    /* renamed from: g  reason: collision with root package name */
    private final int f39666g;

    /* renamed from: h  reason: collision with root package name */
    private final Function1<Throwable, Boolean> f39667h;

    /* renamed from: i  reason: collision with root package name */
    private final Scheduler f39668i;

    /* renamed from: j  reason: collision with root package name */
    private int f39669j;

    /* compiled from: RetryWithDelaySingle.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RetryWithDelaySingle(int i8, int i9, Function1<? super Throwable, Boolean> predicate, Scheduler scheduler) {
        Intrinsics.f(predicate, "predicate");
        Intrinsics.f(scheduler, "scheduler");
        this.f39665f = i8;
        this.f39666g = i9;
        this.f39667h = predicate;
        this.f39668i = scheduler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: h */
    public Publisher<?> apply(Flowable<Throwable> throwableFlowable) throws Exception {
        Intrinsics.f(throwableFlowable, "throwableFlowable");
        final Function1<Throwable, SingleSource<? extends Object>> function1 = new Function1<Throwable, SingleSource<? extends Object>>(this) { // from class: eu.bolt.chat.tools.rx.RetryWithDelaySingle$apply$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ RetryWithDelaySingle<T> f39671f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f39671f = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Object> invoke(Throwable throwable) {
                Function1 function12;
                int i8;
                int i9;
                int i10;
                int i11;
                Scheduler scheduler;
                Intrinsics.f(throwable, "throwable");
                function12 = ((RetryWithDelaySingle) this.f39671f).f39667h;
                if (((Boolean) function12.invoke(throwable)).booleanValue()) {
                    RetryWithDelaySingle<T> retryWithDelaySingle = this.f39671f;
                    i8 = ((RetryWithDelaySingle) retryWithDelaySingle).f39669j;
                    ((RetryWithDelaySingle) retryWithDelaySingle).f39669j = i8 + 1;
                    i9 = ((RetryWithDelaySingle) this.f39671f).f39665f;
                    if (i8 < i9) {
                        Logger a8 = ToolsKit.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Retrying interval ");
                        i10 = ((RetryWithDelaySingle) this.f39671f).f39666g;
                        sb.append(i10);
                        a8.a(throwable, sb.toString());
                        i11 = ((RetryWithDelaySingle) this.f39671f).f39666g;
                        long j8 = i11;
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        scheduler = ((RetryWithDelaySingle) this.f39671f).f39668i;
                        Single<Long> P = Single.P(j8, timeUnit, scheduler);
                        Intrinsics.e(P, "{\n                // Whe… scheduler)\n            }");
                        return P;
                    }
                }
                Single error = Single.error(throwable);
                Intrinsics.e(error, "{\n                Single…(throwable)\n            }");
                return error;
            }
        };
        Publisher D = throwableFlowable.D(new Function() { // from class: eu.bolt.chat.tools.rx.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource i8;
                i8 = RetryWithDelaySingle.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(D, "@Throws(Exception::class…        }\n        }\n    }");
        return D;
    }

    public /* synthetic */ RetryWithDelaySingle(int i8, int i9, Function1 function1, Scheduler scheduler, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 3 : i8, (i10 & 2) != 0 ? 1000 : i9, (i10 & 4) != 0 ? f39664l : function1, scheduler);
    }
}
