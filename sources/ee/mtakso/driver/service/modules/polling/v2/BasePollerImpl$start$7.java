package ee.mtakso.driver.service.modules.polling.v2;

import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BasePollerImpl.kt */
/* loaded from: classes3.dex */
final class BasePollerImpl$start$7 extends Lambda implements Function1<Observable<Throwable>, ObservableSource<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ BasePollerImpl f25180f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePollerImpl$start$7(BasePollerImpl basePollerImpl) {
        super(1);
        this.f25180f = basePollerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<?> invoke(Observable<Throwable> it) {
        Intrinsics.f(it, "it");
        final BasePollerImpl basePollerImpl = this.f25180f;
        final Function1<Throwable, ObservableSource<? extends Long>> function1 = new Function1<Throwable, ObservableSource<? extends Long>>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$7.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends Long> invoke(Throwable throwable) {
                PollingRetryStrategy pollingRetryStrategy;
                Intrinsics.f(throwable, "throwable");
                pollingRetryStrategy = BasePollerImpl.this.f25159d;
                long a8 = pollingRetryStrategy.a(throwable);
                if (a8 == -1) {
                    return Observable.error(throwable);
                }
                return Observable.timer(a8, TimeUnit.SECONDS);
            }
        };
        return it.flatMap(new Function() { // from class: ee.mtakso.driver.service.modules.polling.v2.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource d8;
                d8 = BasePollerImpl$start$7.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
