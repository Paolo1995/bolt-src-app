package ee.mtakso.driver.service.modules.polling;

import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivePollingErrorHandler.kt */
/* loaded from: classes3.dex */
public final class ActivePollingErrorHandler implements Consumer<Throwable> {

    /* renamed from: f  reason: collision with root package name */
    private final AuthManager f25094f;

    @Inject
    public ActivePollingErrorHandler(AuthManager authManager) {
        Intrinsics.f(authManager, "authManager");
        this.f25094f = authManager;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        String localizedMessage = throwable.getLocalizedMessage();
        Kalev.e(throwable, "Polling unsuccessful, " + localizedMessage);
        if (ApiExceptionUtils.m(throwable, 23, 22)) {
            this.f25094f.q();
        }
    }
}
