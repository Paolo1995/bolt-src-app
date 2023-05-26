package com.mixpanel.android.mpmetrics;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.util.MPLog;

/* loaded from: classes3.dex */
public class MixpanelFCMMessagingService extends FirebaseMessagingService {
    public static void a(final String str) {
        MixpanelAPI.m(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.2
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public void a(MixpanelAPI mixpanelAPI) {
                mixpanelAPI.C().e(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        FirebaseInstanceId.i().j().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() { // from class: com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<InstanceIdResult> task) {
                if (task.isSuccessful()) {
                    MixpanelFCMMessagingService.a(task.getResult().a());
                }
            }
        });
    }

    public static void e(Context context, Intent intent) {
        f(context, intent, new MixpanelPushNotification(context.getApplicationContext()));
    }

    public static void f(Context context, Intent intent, MixpanelPushNotification mixpanelPushNotification) {
        String j8;
        Notification i8 = mixpanelPushNotification.i(intent);
        MixpanelNotificationData n8 = mixpanelPushNotification.n();
        if (n8 == null) {
            j8 = "null";
        } else {
            j8 = n8.j();
        }
        MPLog.a("MixpanelAPI.MixpanelFCMMessagingService", "MP FCM notification received: " + j8);
        if (i8 != null) {
            if (!mixpanelPushNotification.w()) {
                MPLog.c("MixpanelAPI.MixpanelFCMMessagingService", "MP FCM notification has error");
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (n8.n() != null) {
                notificationManager.notify(n8.n(), 1, i8);
            } else {
                notificationManager.notify(mixpanelPushNotification.s(), i8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Bundle bundle, NotificationManager notificationManager) {
        boolean z7;
        int i8 = bundle.getInt("mp_notification_id");
        String string = bundle.getString("mp_tag");
        if (string != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            notificationManager.cancel(string, 1);
        } else {
            notificationManager.cancel(i8);
        }
    }

    protected void d(Context context, Intent intent) {
        e(context, intent);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        MPLog.a("MixpanelAPI.MixpanelFCMMessagingService", "MP FCM on new message received");
        d(getApplicationContext(), remoteMessage.l1());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        MPLog.a("MixpanelAPI.MixpanelFCMMessagingService", "MP FCM on new push token: " + str);
        a(str);
    }
}
