package eu.bolt.driver.voip.service.call.tone;

import eu.bolt.driver.voip.CallData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToneService.kt */
/* loaded from: classes5.dex */
/* synthetic */ class ToneService$doStart$1 extends FunctionReferenceImpl implements Function1<CallData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ToneService$doStart$1(Object obj) {
        super(1, obj, ToneService.class, "onActiveCallUpdated", "onActiveCallUpdated(Leu/bolt/driver/voip/CallData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CallData callData) {
        j(callData);
        return Unit.f50853a;
    }

    public final void j(CallData p02) {
        Intrinsics.f(p02, "p0");
        ((ToneService) this.f50989g).e(p02);
    }
}
