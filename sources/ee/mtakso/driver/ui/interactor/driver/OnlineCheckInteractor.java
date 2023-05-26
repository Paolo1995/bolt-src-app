package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnlineCheckInteractor.kt */
/* loaded from: classes3.dex */
public final class OnlineCheckInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final PollerSource f26513a;

    @Inject
    public OnlineCheckInteractor(PollerSource poller) {
        Intrinsics.f(poller, "poller");
        this.f26513a = poller;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }

    public final Observable<Object> b() {
        Observable<PollingSigned<PollingResult>> e8 = this.f26513a.e();
        final OnlineCheckInteractor$call$1 onlineCheckInteractor$call$1 = new Function1<PollingSigned<PollingResult>, Object>() { // from class: ee.mtakso.driver.ui.interactor.driver.OnlineCheckInteractor$call$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Object invoke(PollingSigned<PollingResult> it) {
                Intrinsics.f(it, "it");
                return new Object();
            }
        };
        Observable<R> map = e8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Object c8;
                c8 = OnlineCheckInteractor.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(map, "poller.observePollingResult().map { Any() }");
        return map;
    }
}
