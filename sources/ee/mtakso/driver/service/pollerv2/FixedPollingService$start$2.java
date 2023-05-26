package ee.mtakso.driver.service.pollerv2;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.reactivestreams.Publisher;

/* compiled from: FixedPollingService.kt */
/* loaded from: classes3.dex */
final class FixedPollingService$start$2 extends Lambda implements Function1<Flowable<Object>, Publisher<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ FixedPollingService f25537f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedPollingService$start$2(FixedPollingService fixedPollingService) {
        super(1);
        this.f25537f = fixedPollingService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher d(FixedPollingService this$0, Object it) {
        Flowable t7;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        t7 = this$0.t();
        return t7;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final Publisher<?> invoke(Flowable<Object> it) {
        Intrinsics.f(it, "it");
        final FixedPollingService fixedPollingService = this.f25537f;
        return it.w(new Function() { // from class: ee.mtakso.driver.service.pollerv2.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher d8;
                d8 = FixedPollingService$start$2.d(FixedPollingService.this, obj);
                return d8;
            }
        });
    }
}
