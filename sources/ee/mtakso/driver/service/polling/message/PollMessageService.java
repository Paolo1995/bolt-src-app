package ee.mtakso.driver.service.polling.message;

import ee.mtakso.driver.network.client.driver.PollMessage;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollMessageService.kt */
/* loaded from: classes3.dex */
public final class PollMessageService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f25581b;

    /* renamed from: c  reason: collision with root package name */
    private final PollMessageCache f25582c;

    @Inject
    public PollMessageService(PollerSource poller, PollMessageCache cache) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(cache, "cache");
        this.f25581b = poller;
        this.f25582c = cache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(PollingSigned<PollingResult> pollingSigned) {
        List<PollMessage> k8;
        PollingResult a8;
        if (pollingSigned == null || (a8 = pollingSigned.a()) == null || (k8 = a8.i()) == null) {
            k8 = CollectionsKt__CollectionsKt.k();
        }
        this.f25582c.a(k8);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f25581b.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.polling.message.PollMessageService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                PollMessageService.this.k(pollingSigned);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Consumer<? super PollingSigned<PollingResult>> consumer = new Consumer() { // from class: ee.mtakso.driver.service.polling.message.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PollMessageService.i(Function1.this, obj);
            }
        };
        final PollMessageService$doStart$2 pollMessageService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.polling.message.PollMessageService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "Failed to observe poll result!!!");
            }
        };
        Disposable subscribe = e8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.polling.message.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PollMessageService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …!\") }\n            )\n    }");
        return subscribe;
    }
}
