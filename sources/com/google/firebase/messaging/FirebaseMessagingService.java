package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class FirebaseMessagingService extends EnhancedIntentService {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (queue.contains(str)) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "Received duplicate message: ".concat(valueOf);
                } else {
                    str2 = new String("Received duplicate message: ");
                }
                Log.d("FirebaseMessaging", str2);
                return true;
            }
            return true;
        }
        if (queue.size() >= 10) {
            queue.remove();
        }
        queue.add(str);
        return false;
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.t(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService d8 = FcmExecutors.d();
            try {
                if (new DisplayNotification(this, notificationParams, d8).a()) {
                    return;
                }
                d8.shutdown();
                if (MessagingAnalytics.B(intent)) {
                    MessagingAnalytics.u(intent);
                }
            } finally {
                d8.shutdown();
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return intent.getStringExtra("message_id");
        }
        return stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra("google.message_id"))) {
            passMessageIntentToSdk(intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void passMessageIntentToSdk(Intent intent) {
        char c8;
        String str;
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    c8 = 1;
                    break;
                }
                c8 = 65535;
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    c8 = 0;
                    break;
                }
                c8 = 65535;
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    c8 = 3;
                    break;
                }
                c8 = 65535;
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    c8 = 2;
                    break;
                }
                c8 = 65535;
                break;
            default:
                c8 = 65535;
                break;
        }
        if (c8 != 0) {
            if (c8 != 1) {
                if (c8 != 2) {
                    if (c8 != 3) {
                        if (stringExtra.length() != 0) {
                            str = "Received message with unknown type: ".concat(stringExtra);
                        } else {
                            str = new String("Received message with unknown type: ");
                        }
                        Log.w("FirebaseMessaging", str);
                        return;
                    }
                    onSendError(getMessageId(intent), new SendException(intent.getStringExtra("error")));
                    return;
                }
                onMessageSent(intent.getStringExtra("google.message_id"));
                return;
            }
            onDeletedMessages();
            return;
        }
        MessagingAnalytics.w(intent);
        dispatchMessage(intent);
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    protected Intent getStartCommandIntent(Intent intent) {
        return ServiceStarter.b().c();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void handleIntent(Intent intent) {
        String str;
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(action) && !ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                onNewToken(intent.getStringExtra("token"));
                return;
            }
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                str = "Unknown intent action: ".concat(valueOf);
            } else {
                str = new String("Unknown intent action: ");
            }
            Log.d("FirebaseMessaging", str);
            return;
        }
        handleMessageIntent(intent);
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    }

    public void onMessageSent(@NonNull String str) {
    }

    public void onNewToken(@NonNull String str) {
    }

    public void onSendError(@NonNull String str, @NonNull Exception exc) {
    }
}
