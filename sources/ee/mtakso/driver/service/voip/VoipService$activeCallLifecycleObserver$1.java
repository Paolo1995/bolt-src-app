package ee.mtakso.driver.service.voip;

import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObservableImpl;
import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver;
import ee.mtakso.voip_client.VoipCall;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipService.kt */
/* loaded from: classes3.dex */
public final class VoipService$activeCallLifecycleObserver$1 implements VoipLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoipService f26114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VoipService$activeCallLifecycleObserver$1(VoipService voipService) {
        this.f26114a = voipService;
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void a(final VoipCall call) {
        VoipLifecycleObservableImpl voipLifecycleObservableImpl;
        Intrinsics.f(call, "call");
        voipLifecycleObservableImpl = this.f26114a.f26103b;
        voipLifecycleObservableImpl.a(call.getType(), new Function1<VoipLifecycleObserver, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$activeCallLifecycleObserver$1$onCallEstablishing$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VoipLifecycleObserver it) {
                Intrinsics.f(it, "it");
                it.a(VoipCall.this);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VoipLifecycleObserver voipLifecycleObserver) {
                b(voipLifecycleObserver);
                return Unit.f50853a;
            }
        });
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(final VoipCall call, final VoipCall.EndReason endReason) {
        VoipLifecycleObservableImpl voipLifecycleObservableImpl;
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        voipLifecycleObservableImpl = this.f26114a.f26103b;
        voipLifecycleObservableImpl.a(call.getType(), new Function1<VoipLifecycleObserver, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$activeCallLifecycleObserver$1$onCallFinished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(VoipLifecycleObserver it) {
                Intrinsics.f(it, "it");
                it.b(VoipCall.this, endReason);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VoipLifecycleObserver voipLifecycleObserver) {
                b(voipLifecycleObserver);
                return Unit.f50853a;
            }
        });
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void c(final VoipCall call) {
        VoipLifecycleObservableImpl voipLifecycleObservableImpl;
        Intrinsics.f(call, "call");
        voipLifecycleObservableImpl = this.f26114a.f26103b;
        voipLifecycleObservableImpl.a(call.getType(), new Function1<VoipLifecycleObserver, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$activeCallLifecycleObserver$1$onCallEstablished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VoipLifecycleObserver it) {
                Intrinsics.f(it, "it");
                it.c(VoipCall.this);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VoipLifecycleObserver voipLifecycleObserver) {
                b(voipLifecycleObserver);
                return Unit.f50853a;
            }
        });
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void d(final VoipCall call) {
        VoipLifecycleObservableImpl voipLifecycleObservableImpl;
        Intrinsics.f(call, "call");
        voipLifecycleObservableImpl = this.f26114a.f26103b;
        voipLifecycleObservableImpl.a(call.getType(), new Function1<VoipLifecycleObserver, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$activeCallLifecycleObserver$1$onCallCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VoipLifecycleObserver it) {
                Intrinsics.f(it, "it");
                it.d(VoipCall.this);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VoipLifecycleObserver voipLifecycleObserver) {
                b(voipLifecycleObserver);
                return Unit.f50853a;
            }
        });
    }
}
