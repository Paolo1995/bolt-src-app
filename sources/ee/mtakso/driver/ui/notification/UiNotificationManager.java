package ee.mtakso.driver.ui.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.deeplink.DeepLinkAction;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.order.routing.IntentProvider;
import ee.mtakso.driver.service.voip.effects.VoipEffectsFactory;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerIncomingCall;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.service.VoipIntentService;
import eu.bolt.driver.chat.ui.notification.ChatNotificationDrawer;
import eu.bolt.driver.chat.ui.notification.DeleteNotificationReceiver;
import eu.bolt.driver.chat.ui.notification.NotificationMessage;
import eu.bolt.driver.core.util.PendingIntentFactory;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import eu.bolt.kalev.Kalev;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jctools.util.Pow2;

/* compiled from: UiNotificationManager.kt */
/* loaded from: classes3.dex */
public final class UiNotificationManager implements ChatNotificationDrawer, VoipNotificationDrawer {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f26977e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f26978a;

    /* renamed from: b  reason: collision with root package name */
    private final IntentProvider f26979b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationManager f26980c;

    /* renamed from: d  reason: collision with root package name */
    private final VoipEffectsFactory f26981d;

    /* compiled from: UiNotificationManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UiNotificationManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26982a;

        static {
            int[] iArr = new int[NotificationSound.values().length];
            try {
                iArr[NotificationSound.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationSound.CHAT_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotificationSound.DRIVER_BELL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f26982a = iArr;
        }
    }

    @Inject
    public UiNotificationManager(Context context, IntentProvider intentProvider, NotificationManager notificationManager, VoipEffectsFactory voipEffectsFactory) {
        Intrinsics.f(context, "context");
        Intrinsics.f(intentProvider, "intentProvider");
        Intrinsics.f(notificationManager, "notificationManager");
        Intrinsics.f(voipEffectsFactory, "voipEffectsFactory");
        this.f26978a = context;
        this.f26979b = intentProvider;
        this.f26980c = notificationManager;
        this.f26981d = voipEffectsFactory;
    }

    private final String A(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = context.getString(R.string.voip_notification_channel_title);
            Intrinsics.e(string, "context.getString(R.stri…tification_channel_title)");
            String string2 = context.getString(R.string.voip_notification_channel_description);
            Intrinsics.e(string2, "context.getString(R.stri…tion_channel_description)");
            NotificationChannel notificationChannel = new NotificationChannel("voip_incoming_call", string, 4);
            notificationChannel.setDescription(string2);
            notificationChannel.setShowBadge(true);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setSound(this.f26981d.b().a(context), this.f26981d.a());
            notificationChannel.setLockscreenVisibility(1);
            this.f26980c.createNotificationChannel(notificationChannel);
        }
        return "voip_incoming_call";
    }

    private final int C(String str) {
        return str.hashCode();
    }

    private final Uri F(Context context, NotificationSound notificationSound) {
        int i8 = WhenMappings.f26982a[notificationSound.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    String packageName = context.getPackageName();
                    return Uri.parse("android.resource://" + packageName + "/2131886082");
                }
                throw new NoWhenBranchMatchedException();
            }
            String packageName2 = context.getPackageName();
            return Uri.parse("android.resource://" + packageName2 + "/2131886080");
        }
        return RingtoneManager.getDefaultUri(2);
    }

    private final Notification f(Context context, String str, Intent intent, PendingIntent pendingIntent, List<NotificationMessage> list) {
        String s7 = s(context);
        Person a8 = new Person.Builder().f(str).a();
        Intrinsics.e(a8, "Builder()\n            .s…ame)\n            .build()");
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(a8);
        for (NotificationMessage notificationMessage : list) {
            messagingStyle.i(notificationMessage.a(), notificationMessage.b(), a8);
        }
        Notification b8 = new NotificationCompat.Builder(context, s7).g(true).r(0).m(PendingIntentFactory.b(new PendingIntentFactory(context), intent, 0, 268435456, null, 10, null)).s(pendingIntent).r(4).C(R.drawable.status_bar_icon).K(System.currentTimeMillis()).F(messagingStyle).i("msg").A(2).D(F(context, NotificationSound.CHAT_MESSAGE)).b();
        Intrinsics.e(b8, "Builder(context, channel…GE))\n            .build()");
        return b8;
    }

    private final Notification h(Context context, PendingIntent pendingIntent, String str, String str2) {
        NotificationCompat.Builder A = new NotificationCompat.Builder(context, v(context)).C(R.drawable.ic_notification).o(str).n(str2).g(true).E(F(context, NotificationSound.DEFAULT), 5).m(pendingIntent).A(0);
        Intrinsics.e(A, "Builder(context, channel…nCompat.PRIORITY_DEFAULT)");
        Notification b8 = A.b();
        Intrinsics.e(b8, "builder.build()");
        return b8;
    }

    private final Notification i(Context context, PendingIntent pendingIntent) {
        String x7 = x(context);
        NotificationCompat.Builder D = new NotificationCompat.Builder(context, x7).A(2).o(context.getString(R.string.app_name)).n(context.getString(R.string.title_new_order)).C(R.drawable.status_bar_icon).g(false).i("call").u(pendingIntent, true).I(new long[]{100, 100, 100}).D(F(context, NotificationSound.DRIVER_BELL));
        Intrinsics.e(D, "Builder(context, channel…      .setSound(soundUri)");
        Notification b8 = D.b();
        Intrinsics.e(b8, "builder.build()");
        return b8;
    }

    private final Notification j(String str, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
        RemoteViews remoteViews = new RemoteViews(this.f26978a.getPackageName(), (int) R.layout.content_voip_notification);
        RemoteViews remoteViews2 = new RemoteViews(this.f26978a.getPackageName(), (int) R.layout.content_voip_notification_small);
        remoteViews.setOnClickPendingIntent(R.id.answerButton, pendingIntent2);
        remoteViews.setOnClickPendingIntent(R.id.f203declineButton, pendingIntent3);
        remoteViews2.setOnClickPendingIntent(R.id.answerButtonSmall, pendingIntent2);
        remoteViews2.setOnClickPendingIntent(R.id.declineButtonSmall, pendingIntent3);
        NotificationCompat.Builder u7 = new NotificationCompat.Builder(this.f26978a, str).A(2).o(this.f26978a.getString(R.string.voip_notification_title)).q(remoteViews2).p(remoteViews).z(true).C(R.drawable.status_bar_icon).g(true).i("call").u(pendingIntent, true);
        Intrinsics.e(u7, "Builder(context, channel…tent(pendingIntent, true)");
        if (Build.VERSION.SDK_INT < 26) {
            u7.E(this.f26981d.b().a(this.f26978a), this.f26981d.c());
            u7.I(this.f26981d.d());
        }
        Notification b8 = u7.b();
        Intrinsics.e(b8, "builder.build()");
        return b8;
    }

    public static /* synthetic */ Notification l(UiNotificationManager uiNotificationManager, Context context, PendingIntent pendingIntent, String str, String str2, NotificationSound notificationSound, int i8, Object obj) {
        if ((i8 & 16) != 0) {
            notificationSound = NotificationSound.DEFAULT;
        }
        return uiNotificationManager.k(context, pendingIntent, str, str2, notificationSound);
    }

    private final PendingIntent r() {
        PendingIntentFactory pendingIntentFactory = new PendingIntentFactory(this.f26978a);
        Kalev.d("createAcceptCallPendingIntent called");
        VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
        Context context = this.f26978a;
        Bundle bundle = new Bundle();
        bundle.putBoolean("should_accept_on_start", true);
        Intent intent = new Intent(context, VoipFloatingActivity.class);
        intent.putExtra("dialog_class_argument", IncomingCallFragment.class);
        intent.putExtra("dialog_extra_params", bundle);
        intent.addFlags(268500992);
        return PendingIntentFactory.b(pendingIntentFactory, intent, 913, Pow2.MAX_POW2, null, 8, null);
    }

    private final String s(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return "chat_notification_chanel";
        }
        String string = context.getString(R.string.notification_channel_chat_push_title);
        Intrinsics.e(string, "context.getString(R.stri…_channel_chat_push_title)");
        String string2 = context.getString(R.string.notification_channel_chat_push_description);
        Intrinsics.e(string2, "context.getString(R.stri…el_chat_push_description)");
        NotificationChannel notificationChannel = new NotificationChannel("chat_notification_chanel", string, 4);
        notificationChannel.setDescription(string2);
        notificationChannel.setShowBadge(true);
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        notificationChannel.setSound(F(context, NotificationSound.CHAT_MESSAGE), new AudioAttributes.Builder().setContentType(4).setUsage(6).build());
        notificationChannel.setLockscreenVisibility(1);
        this.f26980c.createNotificationChannel(notificationChannel);
        return "chat_notification_chanel";
    }

    private final PendingIntent t() {
        return new PendingIntentFactory(this.f26978a).a(VoipIntentService.f28106g.a(this.f26978a, "decline_call"), 914, Pow2.MAX_POW2, PendingIntentFactory.Type.SERVICE);
    }

    @SuppressLint({"NewApi"})
    private final String u(Context context) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26) {
            return "taxify_driver_running_notifications";
        }
        notificationChannel = this.f26980c.getNotificationChannel("taxify_driver_running_notifications");
        if (notificationChannel != null) {
            return "taxify_driver_running_notifications";
        }
        String string = context.getString(R.string.notification_channel_awake_title);
        Intrinsics.e(string, "context.getString(R.stri…tion_channel_awake_title)");
        String string2 = context.getString(R.string.notification_channel_awake_description);
        Intrinsics.e(string2, "context.getString(R.stri…hannel_awake_description)");
        NotificationChannel notificationChannel2 = new NotificationChannel("taxify_driver_running_notifications", string, 2);
        notificationChannel2.setDescription(string2);
        notificationChannel2.setShowBadge(false);
        notificationChannel2.enableVibration(false);
        notificationChannel2.enableLights(false);
        this.f26980c.createNotificationChannel(notificationChannel2);
        return "taxify_driver_running_notifications";
    }

    private final String v(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return "default";
        }
        NotificationChannel notificationChannel = new NotificationChannel("default", context.getString(R.string.notification_channel_default_name), 3);
        notificationChannel.setDescription(context.getString(R.string.notification_channel_default_description));
        notificationChannel.setShowBadge(true);
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        this.f26980c.createNotificationChannel(notificationChannel);
        return "default";
    }

    private final PendingIntent w() {
        PendingIntentFactory pendingIntentFactory = new PendingIntentFactory(this.f26978a);
        Kalev.d("createIncomingCallWindowPendingIntent called");
        VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
        Intent intent = new Intent(this.f26978a, VoipFloatingActivity.class);
        intent.putExtra("dialog_class_argument", IncomingCallFragment.class);
        intent.addFlags(268500992);
        return PendingIntentFactory.b(pendingIntentFactory, intent, 912, Pow2.MAX_POW2, null, 8, null);
    }

    private final String x(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return "new_order_notifications_v2";
        }
        this.f26980c.deleteNotificationChannel("new_order_notifications");
        String string = context.getString(R.string.notification_channel_new_order_title);
        Intrinsics.e(string, "context.getString(R.stri…_channel_new_order_title)");
        String string2 = context.getString(R.string.notification_channel_new_order_description);
        Intrinsics.e(string2, "context.getString(R.stri…el_new_order_description)");
        NotificationChannel notificationChannel = new NotificationChannel("new_order_notifications_v2", string, 4);
        notificationChannel.setDescription(string2);
        notificationChannel.setShowBadge(true);
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        notificationChannel.setSound(F(context, NotificationSound.DRIVER_BELL), new AudioAttributes.Builder().setContentType(4).setUsage(6).build());
        notificationChannel.setLockscreenVisibility(1);
        this.f26980c.createNotificationChannel(notificationChannel);
        return "new_order_notifications_v2";
    }

    private final Notification y(PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
        return j(A(this.f26978a), pendingIntent, pendingIntent2, pendingIntent3);
    }

    public final void B(Intent intent, String str, String str2) {
        Intrinsics.f(intent, "intent");
        this.f26980c.notify(984573659, h(this.f26978a, PendingIntentFactory.b(new PendingIntentFactory(this.f26978a), intent, 0, Pow2.MAX_POW2, null, 10, null), str, str2));
    }

    public final void D() {
        this.f26980c.notify(133, i(this.f26978a, this.f26979b.c(new OrderHandle("taxi", -1L, -1L))));
    }

    public final void E(Context context, PendingIntent pendingIntent, String str, String str2, String str3) {
        Intrinsics.f(context, "context");
        Intrinsics.f(pendingIntent, "pendingIntent");
        this.f26980c.notify(str3, 918463725, l(this, context, pendingIntent, str, str2, null, 16, null));
    }

    @Override // eu.bolt.driver.chat.ui.notification.ChatNotificationDrawer
    public boolean a() {
        NotificationChannel notificationChannel;
        boolean z7;
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        notificationChannel = this.f26980c.getNotificationChannel("chat_notification_chanel");
        boolean z8 = false;
        if (notificationChannel != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (notificationChannel == null) {
            s(this.f26978a);
            notificationChannel = this.f26980c.getNotificationChannel("chat_notification_chanel");
        }
        if (notificationChannel != null && notificationChannel.getImportance() == 0) {
            z8 = true;
        }
        boolean z9 = !z8;
        if (!z7) {
            this.f26980c.deleteNotificationChannel("chat_notification_chanel");
        }
        return z9;
    }

    @Override // eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer
    public void b() {
        this.f26980c.cancel(87);
    }

    @Override // eu.bolt.driver.chat.ui.notification.ChatNotificationDrawer
    public void c(String id, String title, String str, List<NotificationMessage> messages) {
        String str2;
        List<NotificationMessage> v02;
        Intrinsics.f(id, "id");
        Intrinsics.f(title, "title");
        Intrinsics.f(messages, "messages");
        Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("boltdriverapp").authority(DeepLinkAction.CHAT_MESSGAE.c()).appendQueryParameter("title", title).appendQueryParameter("description", str).appendPath(id).build());
        intent.putExtra("SOURCE", "CHAT_PUSH");
        if (messages.size() > 1) {
            str2 = " " + this.f26978a.getString(R.string.chat_message_sender_name_amout, Integer.valueOf(messages.size()));
        } else {
            str2 = "";
        }
        Context context = this.f26978a;
        PendingIntent a8 = DeleteNotificationReceiver.f40579b.a(this.f26978a, id);
        v02 = CollectionsKt___CollectionsKt.v0(messages, new Comparator() { // from class: ee.mtakso.driver.ui.notification.UiNotificationManager$showChatNotification$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a9;
                a9 = ComparisonsKt__ComparisonsKt.a(Long.valueOf(((NotificationMessage) t8).b()), Long.valueOf(((NotificationMessage) t7).b()));
                return a9;
            }
        });
        this.f26980c.notify(C(id), f(context, context.getString(R.string.chat_message_sender_name) + str2, intent, a8, v02));
    }

    @Override // eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer
    public void d() {
        this.f26980c.notify(87, y(w(), r(), t()));
    }

    @Override // eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer
    public void e(Object missedCall) {
        Intrinsics.f(missedCall, "missedCall");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f26978a.getString(R.string.voip_no_answer_incoming_call_back));
        spannableStringBuilder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_NORMAL), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f26978a, R.color.green600)), 0, spannableStringBuilder.length(), 17);
        NotificationManager notificationManager = this.f26980c;
        Context context = this.f26978a;
        NotificationCompat.Builder i8 = new NotificationCompat.Builder(context, A(context)).A(2).o(this.f26978a.getString(R.string.voip_no_answer_incoming_call_title)).C(R.drawable.status_bar_icon).g(true).i("call");
        PendingIntentFactory pendingIntentFactory = new PendingIntentFactory(this.f26978a);
        VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
        Context context2 = this.f26978a;
        Bundle a8 = CallBackFragment.C.a((NoAnswerIncomingCall) missedCall);
        Intent intent = new Intent(context2, VoipFloatingActivity.class);
        intent.putExtra("dialog_class_argument", CallBackFragment.class);
        if (a8 != null) {
            intent.putExtra("dialog_extra_params", a8);
        }
        intent.addFlags(268500992);
        notificationManager.notify(89, i8.a(0, spannableStringBuilder, PendingIntentFactory.b(pendingIntentFactory, intent, 915, Pow2.MAX_POW2, null, 8, null)).b());
    }

    public final Notification g(Context context, PendingIntent pendingIntent, String contentText) {
        Intrinsics.f(context, "context");
        Intrinsics.f(pendingIntent, "pendingIntent");
        Intrinsics.f(contentText, "contentText");
        NotificationCompat.Builder m8 = new NotificationCompat.Builder(context, u(context)).A(-1).o(context.getString(R.string.app_name)).n(contentText).C(R.drawable.status_bar_icon).g(true).m(pendingIntent);
        Intrinsics.e(m8, "Builder(context, channel…tentIntent(pendingIntent)");
        Notification b8 = m8.b();
        Intrinsics.e(b8, "builder.build()");
        return b8;
    }

    public final Notification k(Context context, PendingIntent pendingIntent, String str, String str2, NotificationSound sound) {
        Intrinsics.f(context, "context");
        Intrinsics.f(pendingIntent, "pendingIntent");
        Intrinsics.f(sound, "sound");
        NotificationCompat.Builder A = new NotificationCompat.Builder(context, "taxify_driver_push_notifications").C(R.drawable.ic_notification).o(str).n(str2).g(true).E(F(context, sound), 5).m(pendingIntent).A(0);
        Intrinsics.e(A, "Builder(context, Config.…nCompat.PRIORITY_DEFAULT)");
        Notification b8 = A.b();
        Intrinsics.e(b8, "builder.build()");
        return b8;
    }

    public final void m() {
        this.f26980c.cancelAll();
    }

    public final void n() {
        this.f26980c.cancel(133);
    }

    public final void o(String... pushTags) {
        StatusBarNotification[] list;
        boolean z7;
        Intrinsics.f(pushTags, "pushTags");
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            list = this.f26980c.getActiveNotifications();
        } catch (NullPointerException unused) {
            list = new StatusBarNotification[0];
        }
        Intrinsics.e(list, "list");
        for (StatusBarNotification statusBarNotification : list) {
            z7 = ArraysKt___ArraysKt.z(pushTags, statusBarNotification.getTag());
            if (z7) {
                this.f26980c.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
            }
        }
    }

    public final void p() {
        this.f26980c.cancel(136);
    }

    public final void q() {
        this.f26980c.cancel(918463725);
    }

    @SuppressLint({"NewApi"})
    public final String z(Context context) {
        Intrinsics.f(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return "taxify_driver_push_notifications";
        }
        String string = context.getString(R.string.notification_channel_push_title);
        Intrinsics.e(string, "context.getString(R.stri…ation_channel_push_title)");
        String string2 = context.getString(R.string.notification_channel_push_description);
        Intrinsics.e(string2, "context.getString(R.stri…channel_push_description)");
        NotificationChannel notificationChannel = new NotificationChannel("taxify_driver_push_notifications", string, 4);
        notificationChannel.setDescription(string2);
        notificationChannel.setShowBadge(false);
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        this.f26980c.createNotificationChannel(notificationChannel);
        return "taxify_driver_push_notifications";
    }
}
