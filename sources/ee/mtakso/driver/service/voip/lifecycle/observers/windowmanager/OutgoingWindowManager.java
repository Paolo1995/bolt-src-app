package ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorConfig;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallFragment;
import ee.mtakso.voip_client.VoipCall;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutgoingWindowManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class OutgoingWindowManager extends BaseWindowManager {

    /* renamed from: b  reason: collision with root package name */
    private final Context f26180b;

    @Inject
    public OutgoingWindowManager(Context context) {
        Intrinsics.f(context, "context");
        this.f26180b = context;
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.BaseWindowManager, ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        if (e(call, endReason)) {
            VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
            Context context = this.f26180b;
            Bundle bundle = new Bundle();
            bundle.putString("args.call_id", call.getId());
            Intent intent = new Intent(context, VoipFloatingActivity.class);
            intent.putExtra("dialog_class_argument", RateCallFragment.class);
            intent.putExtra("dialog_extra_params", bundle);
            intent.addFlags(268500992);
            context.startActivity(intent);
        } else if (endReason == VoipCall.EndReason.NO_ANSWER_FROM_OUTGOING_CONNECTION) {
            VoipFloatingActivity.Companion companion2 = VoipFloatingActivity.f27818p;
            Context context2 = this.f26180b;
            Intent intent2 = new Intent(context2, VoipFloatingActivity.class);
            intent2.putExtra("dialog_class_argument", NoAnswerFragment.class);
            intent2.addFlags(268500992);
            context2.startActivity(intent2);
        } else if (endReason == VoipCall.EndReason.ERROR) {
            VoipFloatingActivity.Companion companion3 = VoipFloatingActivity.f27818p;
            Context context3 = this.f26180b;
            Bundle a8 = VoipCallErrorFragment.f27851z.a(new VoipCallErrorConfig(call.getType()));
            Intent intent3 = new Intent(context3, VoipFloatingActivity.class);
            intent3.putExtra("dialog_class_argument", VoipCallErrorFragment.class);
            if (a8 != null) {
                intent3.putExtra("dialog_extra_params", a8);
            }
            intent3.addFlags(268500992);
            context3.startActivity(intent3);
        }
        super.b(call, endReason);
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void d(VoipCall call) {
        Intrinsics.f(call, "call");
        f();
    }

    public final void f() {
        VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
        Context context = this.f26180b;
        Intent intent = new Intent(context, VoipFloatingActivity.class);
        intent.putExtra("dialog_class_argument", InprogressCallFragment.class);
        intent.addFlags(268500992);
        context.startActivity(intent);
    }
}
