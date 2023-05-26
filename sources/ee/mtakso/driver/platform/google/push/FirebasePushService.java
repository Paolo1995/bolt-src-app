package ee.mtakso.driver.platform.google.push;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import ee.mtakso.driver.platform.Platform;
import ee.mtakso.driver.platform.di.PlatformDependencies;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.platform.push.PushManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebasePushService.kt */
/* loaded from: classes3.dex */
public final class FirebasePushService extends FirebaseMessagingService {

    /* renamed from: f  reason: collision with root package name */
    private PushManager f23334f;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        PlatformDependencies a8 = Platform.f23272a.a();
        if (a8 != null) {
            PushManager j8 = a8.j();
            this.f23334f = j8;
            if (j8 == null) {
                Intrinsics.w("pushManager");
                j8 = null;
            }
            j8.init();
            return;
        }
        throw new IllegalStateException("Platform dependencies are not initialised".toString());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        String str;
        String str2;
        Intrinsics.f(message, "message");
        FastLog g8 = Kalev.f41674e.g();
        PushManager pushManager = null;
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "New push received " + message.getData(), null, 2, null);
        }
        RemoteMessage.Notification g9 = message.g();
        if (g9 != null) {
            str = g9.c();
        } else {
            str = null;
        }
        RemoteMessage.Notification g10 = message.g();
        if (g10 != null) {
            str2 = g10.a();
        } else {
            str2 = null;
        }
        Map<String, String> data = message.getData();
        Intrinsics.e(data, "message.data");
        Push push = new Push(str, str2, data, message);
        PushManager pushManager2 = this.f23334f;
        if (pushManager2 == null) {
            Intrinsics.w("pushManager");
        } else {
            pushManager = pushManager2;
        }
        pushManager.b(push);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.f(token, "token");
        FastLog g8 = Kalev.f41674e.g();
        PushManager pushManager = null;
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "New FCM token received " + token, null, 2, null);
        }
        PushManager pushManager2 = this.f23334f;
        if (pushManager2 == null) {
            Intrinsics.w("pushManager");
        } else {
            pushManager = pushManager2;
        }
        pushManager.a(token);
    }
}
