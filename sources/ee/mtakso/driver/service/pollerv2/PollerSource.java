package ee.mtakso.driver.service.pollerv2;

import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Notification;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollerSource.kt */
/* loaded from: classes3.dex */
public interface PollerSource {

    /* compiled from: PollerSource.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Observable<PollingSigned<PollingResult>> a(PollerSource pollerSource) {
            return ObservableExtKt.k(pollerSource.f(), new Function1<Notification<PollingSigned<PollingResult>>, PollingSigned<PollingResult>>() { // from class: ee.mtakso.driver.service.pollerv2.PollerSource$observePollingResult$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final PollingSigned<PollingResult> invoke(Notification<PollingSigned<PollingResult>> it) {
                    Intrinsics.f(it, "it");
                    return it.e();
                }
            });
        }
    }

    Observable<PollingSigned<PollingResult>> e();

    Observable<Notification<PollingSigned<PollingResult>>> f();
}
