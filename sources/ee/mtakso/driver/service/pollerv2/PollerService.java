package ee.mtakso.driver.service.pollerv2;

import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;

/* compiled from: PollerService.kt */
/* loaded from: classes3.dex */
public interface PollerService extends BaseService, PollerSource {

    /* compiled from: PollerService.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Observable<PollingSigned<PollingResult>> a(PollerService pollerService) {
            return PollerSource.DefaultImpls.a(pollerService);
        }
    }
}
