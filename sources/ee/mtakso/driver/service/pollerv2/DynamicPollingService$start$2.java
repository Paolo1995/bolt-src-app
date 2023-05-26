package ee.mtakso.driver.service.pollerv2;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.reactivestreams.Publisher;

/* compiled from: DynamicPollingService.kt */
/* loaded from: classes3.dex */
final class DynamicPollingService$start$2 extends Lambda implements Function1<Flowable<Object>, Publisher<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ DynamicPollingService f25521f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicPollingService$start$2(DynamicPollingService dynamicPollingService) {
        super(1);
        this.f25521f = dynamicPollingService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher d(DynamicPollingService this$0, Object it) {
        Flowable u7;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        u7 = this$0.u();
        return u7;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final Publisher<?> invoke(Flowable<Object> it) {
        Intrinsics.f(it, "it");
        final DynamicPollingService dynamicPollingService = this.f25521f;
        return it.w(new Function() { // from class: ee.mtakso.driver.service.pollerv2.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher d8;
                d8 = DynamicPollingService$start$2.d(DynamicPollingService.this, obj);
                return d8;
            }
        });
    }
}
