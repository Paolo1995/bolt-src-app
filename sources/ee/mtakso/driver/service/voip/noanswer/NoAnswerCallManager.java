package ee.mtakso.driver.service.voip.noanswer;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.AppForegroundState;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.voip_client.VoipCall;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerCallManager.kt */
/* loaded from: classes3.dex */
public final class NoAnswerCallManager {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f26185a;

    /* renamed from: b  reason: collision with root package name */
    private final BackgroundManager f26186b;

    /* renamed from: c  reason: collision with root package name */
    private final NoAnswerCallCache f26187c;

    /* renamed from: d  reason: collision with root package name */
    private final VoipNotificationDrawer f26188d;

    @Inject
    public NoAnswerCallManager(OrderProvider orderProvider, BackgroundManager backgroundManager, NoAnswerCallCache cache, VoipNotificationDrawer voipNotificationDrawer) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(cache, "cache");
        Intrinsics.f(voipNotificationDrawer, "voipNotificationDrawer");
        this.f26185a = orderProvider;
        this.f26186b = backgroundManager;
        this.f26187c = cache;
        this.f26188d = voipNotificationDrawer;
    }

    public final void a(VoipCall call) {
        OrderHandle orderHandle;
        Intrinsics.f(call, "call");
        ActiveOrderDetails i8 = OrderProviderUtils.i(this.f26185a.f());
        if (i8 != null) {
            orderHandle = i8.a();
        } else {
            orderHandle = null;
        }
        NoAnswerIncomingCall noAnswerIncomingCall = new NoAnswerIncomingCall(orderHandle, call.e(), call.g());
        AppForegroundState d8 = this.f26186b.d();
        if (d8 != AppForegroundState.BACKGROUND && i8 != null) {
            if (d8 == AppForegroundState.FOREGROUND) {
                this.f26187c.b(noAnswerIncomingCall);
                return;
            }
            return;
        }
        this.f26188d.e(noAnswerIncomingCall);
    }
}
