package eu.bolt.driver.voip.service.call.log;

import ee.mtakso.voip_client.VoipCall;
import ee.mtakso.voip_client.VoipLogger;
import eu.bolt.driver.core.service.BaseServiceImpl;
import eu.bolt.driver.voip.CallData;
import eu.bolt.driver.voip.VoipSession;
import eu.bolt.driver.voip.service.call.log.CallLoggerService;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallLoggerService.kt */
/* loaded from: classes5.dex */
public final class CallLoggerService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final VoipSession f41642b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipLogger f41643c;

    public CallLoggerService(VoipSession voipSession, VoipLogger logger) {
        Intrinsics.f(voipSession, "voipSession");
        Intrinsics.f(logger, "logger");
        this.f41642b = voipSession;
        this.f41643c = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(CallData callData) {
        VoipLogger voipLogger = this.f41643c;
        String id = callData.a().getId();
        VoipCall.Type type = callData.a().getType();
        VoipCall.State state = callData.a().getState();
        VoipCall.EndReason b8 = callData.b();
        voipLogger.c("Active call has been updated: ID = " + id + ". Type = " + type + ". State = " + state + ". End reason = " + b8, new Object[0]);
    }

    @Override // eu.bolt.driver.core.service.BaseServiceImpl
    public Disposable a() {
        Observable<CallData> N = this.f41642b.N();
        final CallLoggerService$doStart$1 callLoggerService$doStart$1 = new CallLoggerService$doStart$1(this);
        Disposable subscribe = N.subscribe(new Consumer() { // from class: k7.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CallLoggerService.d(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "voipSession.observeActiv…be(::onActiveCallUpdated)");
        return subscribe;
    }
}
