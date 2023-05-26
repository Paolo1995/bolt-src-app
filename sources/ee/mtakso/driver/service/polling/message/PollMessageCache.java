package ee.mtakso.driver.service.polling.message;

import ee.mtakso.driver.network.client.driver.PollMessage;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollMessageCache.kt */
/* loaded from: classes3.dex */
public final class PollMessageCache {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<List<PollMessage>> f25576a;

    @Inject
    public PollMessageCache() {
        PublishSubject<List<PollMessage>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<List<PollMessage>>()");
        this.f25576a = e8;
    }

    public final void a(List<PollMessage> messages) {
        Intrinsics.f(messages, "messages");
        this.f25576a.onNext(messages);
    }

    public final Observable<List<PollMessage>> b() {
        return this.f25576a;
    }
}
