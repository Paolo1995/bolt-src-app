package ee.mtakso.driver.service.modules.polling;

import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.ObservableService;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;

/* compiled from: Poller.kt */
/* loaded from: classes3.dex */
public interface Poller extends ObservableService<PollingSigned<PollingResult>>, PollerSource {

    /* compiled from: Poller.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Observable<PollingSigned<PollingResult>> a(Poller poller) {
            return PollerSource.DefaultImpls.a(poller);
        }
    }

    void a();

    void b();
}
