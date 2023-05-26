package ee.mtakso.driver.service.routing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import ee.mtakso.driver.deeplink.DeepLinkAction;
import ee.mtakso.driver.ui.base.CloseActivity;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppRoutingManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class AppRoutingManager {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f25869b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f25870a;

    /* compiled from: AppRoutingManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.f(context, "context");
            Intent intent = new Intent(context, LauncherActivity.class);
            intent.putExtra("from_background", true);
            intent.setFlags(805371904);
            return intent;
        }

        public final Intent b(ChatEntity chat) {
            Intrinsics.f(chat, "chat");
            Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("boltdriverapp").authority(DeepLinkAction.CHAT_MESSGAE.c()).appendQueryParameter("title", chat.f()).appendQueryParameter("description", chat.a()).appendPath(chat.b()).build());
            intent.putExtra("SOURCE", "CHAT_PUSH");
            intent.putExtra("from_background", true);
            intent.setFlags(805371904);
            return intent;
        }

        public final void c(Context context) {
            Intrinsics.f(context, "context");
            try {
                Intent intent = new Intent(context, LauncherActivity.class);
                intent.addFlags(805404672);
                intent.addCategory("android.intent.category.DEFAULT");
                context.startActivity(intent);
            } catch (IllegalStateException e8) {
                Kalev.e(e8, "Could not restart the app");
            }
        }
    }

    @Inject
    public AppRoutingManager(Context context) {
        Intrinsics.f(context, "context");
        this.f25870a = context;
    }

    public static final void a(Context context) {
        f25869b.c(context);
    }

    public final void b() {
        this.f25870a.startActivity(CloseActivity.f26228g.a(this.f25870a));
    }
}
