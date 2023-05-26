package ee.mtakso.driver.service.push;

import android.content.Context;
import android.content.Intent;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.utils.AppForegroundState;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.driver.core.util.PendingIntentFactory;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jctools.util.Pow2;

/* compiled from: PushNotificationManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class PushNotificationManager {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f25616e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f25617a;

    /* renamed from: b  reason: collision with root package name */
    private final BackgroundManager f25618b;

    /* renamed from: c  reason: collision with root package name */
    private final UiNotificationManager f25619c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishSubject<PushMessage> f25620d;

    /* compiled from: PushNotificationManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public PushNotificationManager(Context context, BackgroundManager backgroundManager, UiNotificationManager uiNotificationManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(uiNotificationManager, "uiNotificationManager");
        this.f25617a = context;
        this.f25618b = backgroundManager;
        this.f25619c = uiNotificationManager;
        PublishSubject<PushMessage> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<PushMessage>()");
        this.f25620d = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void d() {
        if (this.f25618b.d() == AppForegroundState.BACKGROUND) {
            this.f25619c.D();
        }
    }

    public final void e(Intent intent, String str, String str2, String str3) {
        Intrinsics.f(intent, "intent");
        intent.putExtra("from_background", true);
        this.f25619c.E(this.f25617a, PendingIntentFactory.b(new PendingIntentFactory(this.f25617a), intent, 0, Pow2.MAX_POW2, null, 10, null), str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(ee.mtakso.driver.platform.push.Push r8) {
        /*
            r7 = this;
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.util.Map r0 = r8.b()
            java.lang.String r1 = "alert"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L17
            java.lang.String r0 = r8.c()
        L17:
            java.util.Map r1 = r8.b()
            java.lang.String r2 = "body"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L29
            java.lang.String r1 = r8.a()
        L29:
            java.util.Map r2 = r8.b()
            java.lang.String r3 = "action"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L39
            java.lang.String r2 = ""
        L39:
            java.util.Map r8 = r8.b()
            java.lang.String r3 = "type"
            java.lang.Object r8 = r8.get(r3)
            java.lang.String r8 = (java.lang.String) r8
            int r3 = r2.length()
            r4 = 1
            r5 = 0
            if (r3 <= 0) goto L4f
            r3 = 1
            goto L50
        L4f:
            r3 = 0
        L50:
            if (r3 == 0) goto L5e
            android.content.Intent r3 = new android.content.Intent
            android.net.Uri r2 = android.net.Uri.parse(r2)
            java.lang.String r6 = "android.intent.action.VIEW"
            r3.<init>(r6, r2)
            goto L66
        L5e:
            ee.mtakso.driver.service.routing.AppRoutingManager$Companion r2 = ee.mtakso.driver.service.routing.AppRoutingManager.f25869b
            android.content.Context r3 = r7.f25617a
            android.content.Intent r3 = r2.a(r3)
        L66:
            if (r1 == 0) goto L71
            boolean r2 = kotlin.text.StringsKt.y(r1)
            if (r2 == 0) goto L6f
            goto L71
        L6f:
            r2 = 0
            goto L72
        L71:
            r2 = 1
        L72:
            if (r2 == 0) goto L81
            if (r0 == 0) goto L7e
            boolean r2 = kotlin.text.StringsKt.y(r0)
            if (r2 == 0) goto L7d
            goto L7e
        L7d:
            r4 = 0
        L7e:
            if (r4 == 0) goto L81
            return
        L81:
            r7.e(r3, r0, r1, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.push.PushNotificationManager.f(ee.mtakso.driver.platform.push.Push):void");
    }

    public final void g(Push message) {
        Intrinsics.f(message, "message");
        String str = message.b().get("alert");
        if (str == null) {
            str = message.c();
        }
        String str2 = message.b().get("body");
        if (str2 == null) {
            str2 = message.a();
        }
        h(new TextPushMessage(str, str2, message.b().get("type")));
    }

    public final void h(PushMessage message) {
        Intrinsics.f(message, "message");
        this.f25620d.onNext(message);
    }

    public final Observable<PushMessage> i() {
        PublishSubject<PushMessage> publishSubject = this.f25620d;
        final Function1<PushMessage, Unit> function1 = new Function1<PushMessage, Unit>() { // from class: ee.mtakso.driver.service.push.PushNotificationManager$observePushMessages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PushMessage pushMessage) {
                PublishSubject publishSubject2;
                UiNotificationManager uiNotificationManager;
                publishSubject2 = PushNotificationManager.this.f25620d;
                if (publishSubject2.f()) {
                    uiNotificationManager = PushNotificationManager.this.f25619c;
                    uiNotificationManager.q();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PushMessage pushMessage) {
                b(pushMessage);
                return Unit.f50853a;
            }
        };
        Observable<PushMessage> doOnNext = publishSubject.doOnNext(new Consumer() { // from class: ee.mtakso.driver.service.push.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushNotificationManager.j(Function1.this, obj);
            }
        });
        Intrinsics.e(doOnNext, "fun observePushMessages(…        }\n        }\n    }");
        return doOnNext;
    }
}
