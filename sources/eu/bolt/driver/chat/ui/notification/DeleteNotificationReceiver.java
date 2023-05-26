package eu.bolt.driver.chat.ui.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.core.util.PendingIntentFactory;
import eu.bolt.kalev.Kalev;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteNotificationReceiver.kt */
/* loaded from: classes5.dex */
public final class DeleteNotificationReceiver extends BroadcastReceiver {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f40579b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f40580a;

    /* compiled from: DeleteNotificationReceiver.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PendingIntent a(Context context, String chatId) {
            Intrinsics.f(context, "context");
            Intrinsics.f(chatId, "chatId");
            PendingIntentFactory pendingIntentFactory = new PendingIntentFactory(context);
            Intent intent = new Intent(context, DeleteNotificationReceiver.class);
            intent.setAction("delete");
            intent.putExtra("chat_id", chatId);
            return PendingIntentFactory.b(pendingIntentFactory, intent, 0, 0, PendingIntentFactory.Type.BROADCAST, 6, null);
        }
    }

    public DeleteNotificationReceiver() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ChatNotificationManager>() { // from class: eu.bolt.driver.chat.ui.notification.DeleteNotificationReceiver$manager$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ChatNotificationManager invoke() {
                return DriverChatSdk.f40388a.d();
            }
        });
        this.f40580a = b8;
    }

    private final ChatNotificationManager a() {
        return (ChatNotificationManager) this.f40580a.getValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!Intrinsics.a(str, "delete")) {
            Kalev.e(new IllegalStateException("Unsupported action: " + str), "Failed to handle notification deletion");
            return;
        }
        String stringExtra = intent.getStringExtra("chat_id");
        if (stringExtra == null) {
            Kalev.e(new IllegalStateException("Missing chat id"), "Failed to handle notification deletion");
        } else {
            a().f(stringExtra);
        }
    }
}
