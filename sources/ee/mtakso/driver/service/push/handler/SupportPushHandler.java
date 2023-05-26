package ee.mtakso.driver.service.push.handler;

import android.content.Context;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushNotificationManager;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportPushHandler.kt */
/* loaded from: classes3.dex */
public final class SupportPushHandler implements PushHandler {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f25717c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final PushNotificationManager f25718a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f25719b;

    /* compiled from: SupportPushHandler.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SupportPushHandler(PushNotificationManager pushNotificationManager, Context context) {
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        Intrinsics.f(context, "context");
        this.f25718a = pushNotificationManager;
        this.f25719b = context;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
        if (r4 != false) goto L16;
     */
    @Override // ee.mtakso.driver.service.push.PushHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(ee.mtakso.driver.platform.push.Push r8) {
        /*
            r7 = this;
            java.lang.String r0 = "push"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.util.Map r0 = r8.b()
            java.lang.String r1 = "type"
            java.lang.Object r0 = r0.get(r1)
            ee.mtakso.driver.service.push.PushType r2 = ee.mtakso.driver.service.push.PushType.ZENDESK
            java.lang.String r2 = r2.getId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r2)
            r2 = 0
            if (r0 != 0) goto L31
            java.util.Map r0 = r8.b()
            java.lang.Object r0 = r0.get(r1)
            ee.mtakso.driver.service.push.PushType r1 = ee.mtakso.driver.service.push.PushType.BEEHIVE
            java.lang.String r1 = r1.getId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
            if (r0 != 0) goto L31
            return r2
        L31:
            java.util.Map r0 = r8.b()
            java.lang.String r1 = "webapp_launch_token"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r3 = 1
            if (r0 == 0) goto L46
            boolean r4 = kotlin.text.StringsKt.y(r0)
            if (r4 == 0) goto L47
        L46:
            r2 = 1
        L47:
            if (r2 == 0) goto L54
            java.lang.String r8 = "Value at \"webapp_launch_token\" is mandatory for the support push message"
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r8)
            eu.bolt.kalev.Kalev.m(r0, r8)
            return r3
        L54:
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r4 = "boltdriverapp"
            android.net.Uri$Builder r2 = r2.scheme(r4)
            ee.mtakso.driver.deeplink.DeepLinkAction r4 = ee.mtakso.driver.deeplink.DeepLinkAction.SUPPORT
            java.lang.String r5 = r4.c()
            android.net.Uri$Builder r2 = r2.authority(r5)
            android.net.Uri$Builder r1 = r2.appendQueryParameter(r1, r0)
            android.net.Uri r1 = r1.build()
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.VIEW"
            r2.<init>(r5, r1)
            ee.mtakso.driver.service.push.PushNotificationManager r1 = r7.f25718a
            android.content.Context r5 = r7.f25719b
            r6 = 2131951861(0x7f1300f5, float:1.9540148E38)
            java.lang.String r5 = r5.getString(r6)
            java.util.Map r8 = r8.b()
            java.lang.String r6 = "body"
            java.lang.Object r8 = r8.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r4 = r4.c()
            r1.e(r2, r5, r8, r4)
            ee.mtakso.driver.service.push.PushNotificationManager r8 = r7.f25718a
            ee.mtakso.driver.service.push.SupportPushMessage r1 = new ee.mtakso.driver.service.push.SupportPushMessage
            r1.<init>(r0)
            r8.h(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.push.handler.SupportPushHandler.b(ee.mtakso.driver.platform.push.Push):boolean");
    }
}
