package ee.mtakso.driver.service.modules.order.v2;

import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: StaticStopDetailsService.kt */
/* loaded from: classes3.dex */
final class StaticStopDetailsService$doStart$3 extends Lambda implements Function1<Observable<Throwable>, ObservableSource<?>> {

    /* renamed from: f  reason: collision with root package name */
    public static final StaticStopDetailsService$doStart$3 f25020f = new StaticStopDetailsService$doStart$3();

    StaticStopDetailsService$doStart$3() {
        super(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<?> invoke(Observable<Throwable> errorSource) {
        Intrinsics.f(errorSource, "errorSource");
        final AnonymousClass1 anonymousClass1 = new Function1<Throwable, ObservableSource<? extends Long>>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$doStart$3.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends Long> invoke(Throwable error) {
                Intrinsics.f(error, "error");
                Kalev.e(error, "Exception on StaticStopDetailsService!");
                if (!(error instanceof NoSuchElementException) && !ApiExceptionUtils.m(error, 415)) {
                    return Observable.timer(2L, TimeUnit.SECONDS);
                }
                return Observable.error(error);
            }
        };
        return errorSource.flatMap(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.j1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource d8;
                d8 = StaticStopDetailsService$doStart$3.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
