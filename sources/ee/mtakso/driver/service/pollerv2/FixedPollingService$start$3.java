package ee.mtakso.driver.service.pollerv2;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.reactivestreams.Publisher;

/* compiled from: FixedPollingService.kt */
/* loaded from: classes3.dex */
final class FixedPollingService$start$3 extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ FixedPollingService f25538f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedPollingService$start$3(FixedPollingService fixedPollingService) {
        super(1);
        this.f25538f = fixedPollingService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final Publisher<?> invoke(Flowable<Throwable> it) {
        Intrinsics.f(it, "it");
        final FixedPollingService fixedPollingService = this.f25538f;
        final Function1<Throwable, Publisher<? extends Long>> function1 = new Function1<Throwable, Publisher<? extends Long>>() { // from class: ee.mtakso.driver.service.pollerv2.FixedPollingService$start$3.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Publisher<? extends Long> invoke(Throwable throwable) {
                Flowable u7;
                Intrinsics.f(throwable, "throwable");
                u7 = FixedPollingService.this.u(throwable);
                return u7;
            }
        };
        return it.w(new Function() { // from class: ee.mtakso.driver.service.pollerv2.p
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher d8;
                d8 = FixedPollingService$start$3.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
