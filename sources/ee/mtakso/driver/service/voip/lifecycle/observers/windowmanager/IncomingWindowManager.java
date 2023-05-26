package ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallManager;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorConfig;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallFragment;
import ee.mtakso.voip_client.VoipCall;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingWindowManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class IncomingWindowManager extends BaseWindowManager {

    /* renamed from: b  reason: collision with root package name */
    private final Context f26174b;

    /* renamed from: c  reason: collision with root package name */
    private final NoAnswerCallManager f26175c;

    /* renamed from: d  reason: collision with root package name */
    private final VoipNotificationDrawer f26176d;

    @Inject
    public IncomingWindowManager(Context context, NoAnswerCallManager noAnswerCallManager, VoipNotificationDrawer voipNotificationDrawer) {
        Intrinsics.f(context, "context");
        Intrinsics.f(noAnswerCallManager, "noAnswerCallManager");
        Intrinsics.f(voipNotificationDrawer, "voipNotificationDrawer");
        this.f26174b = context;
        this.f26175c = noAnswerCallManager;
        this.f26176d = voipNotificationDrawer;
    }

    private final void f() {
        this.f26176d.d();
    }

    private final void g() {
        VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
        Context context = this.f26174b;
        Intent intent = new Intent(context, VoipFloatingActivity.class);
        intent.putExtra("dialog_class_argument", InprogressCallFragment.class);
        intent.addFlags(268500992);
        context.startActivity(intent);
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void a(VoipCall call) {
        Intrinsics.f(call, "call");
        g();
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.BaseWindowManager, ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        this.f26176d.b();
        if (e(call, endReason)) {
            VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
            Context context = this.f26174b;
            Bundle bundle = new Bundle();
            bundle.putString("args.call_id", call.getId());
            Intent intent = new Intent(context, VoipFloatingActivity.class);
            intent.putExtra("dialog_class_argument", RateCallFragment.class);
            intent.putExtra("dialog_extra_params", bundle);
            intent.addFlags(268500992);
            context.startActivity(intent);
        } else if (endReason == VoipCall.EndReason.ERROR) {
            VoipFloatingActivity.Companion companion2 = VoipFloatingActivity.f27818p;
            Context context2 = this.f26174b;
            Bundle a8 = VoipCallErrorFragment.f27851z.a(new VoipCallErrorConfig(call.getType()));
            Intent intent2 = new Intent(context2, VoipFloatingActivity.class);
            intent2.putExtra("dialog_class_argument", VoipCallErrorFragment.class);
            if (a8 != null) {
                intent2.putExtra("dialog_extra_params", a8);
            }
            intent2.addFlags(268500992);
            context2.startActivity(intent2);
        } else if (endReason == VoipCall.EndReason.NO_ANSWER_FROM_INCOMING_CONNECTION) {
            Kalev.b("onCallFinished NO_ANSWER_FROM_INCOMING_CONNECTION");
            this.f26175c.a(call);
        }
        super.b(call, endReason);
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void d(VoipCall call) {
        Intrinsics.f(call, "call");
        f();
    }
}
