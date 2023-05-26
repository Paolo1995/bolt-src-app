package ee.mtakso.driver.ui.common.push;

import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.push.PushMessage;
import ee.mtakso.driver.service.push.RateRequestPushMessage;
import ee.mtakso.driver.service.push.SupportPushMessage;
import ee.mtakso.driver.service.push.TextPushMessage;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class PushDialogDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final RateMeDialogDelegate f26397a;

    /* renamed from: b  reason: collision with root package name */
    private final UiNotificationManager f26398b;

    @Inject
    public PushDialogDelegate(RateMeDialogDelegate rateMeDialogDelegate, UiNotificationManager uiNotificationManager) {
        Intrinsics.f(rateMeDialogDelegate, "rateMeDialogDelegate");
        Intrinsics.f(uiNotificationManager, "uiNotificationManager");
        this.f26397a = rateMeDialogDelegate;
        this.f26398b = uiNotificationManager;
    }

    private final void a(TextPushMessage textPushMessage, FragmentActivity fragmentActivity) {
        String str;
        String str2;
        String b8 = textPushMessage.b();
        if (b8 == null) {
            str = "";
        } else {
            str = b8;
        }
        String a8 = textPushMessage.a();
        if (a8 == null) {
            str2 = "";
        } else {
            str2 = a8;
        }
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = fragmentActivity.getString(R.string.ok_lowercase);
        Intrinsics.e(string, "activity.getString(R.string.ok_lowercase)");
        FragmentUtils.c(NotificationDialog.Companion.i(companion, str, str2, string, null, 8, null), fragmentActivity, "push_message");
        this.f26398b.q();
    }

    private final void c(RateRequestPushMessage rateRequestPushMessage, FragmentActivity fragmentActivity) {
        this.f26397a.c(rateRequestPushMessage.a(), fragmentActivity, fragmentActivity);
    }

    public final void b(PushMessage push, FragmentActivity activity) {
        Intrinsics.f(push, "push");
        Intrinsics.f(activity, "activity");
        if (push instanceof RateRequestPushMessage) {
            c((RateRequestPushMessage) push, activity);
        } else if (push instanceof TextPushMessage) {
            a((TextPushMessage) push, activity);
        } else {
            boolean z7 = push instanceof SupportPushMessage;
        }
    }
}
