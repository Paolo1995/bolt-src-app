package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.CommonNotificationBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
class DisplayNotification {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f16457a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f16458b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationParams f16459c;

    public DisplayNotification(Context context, NotificationParams notificationParams, Executor executor) {
        this.f16457a = executor;
        this.f16458b = context;
        this.f16459c = notificationParams;
    }

    private boolean b() {
        if (((KeyguardManager) this.f16458b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.isAtLeastLollipop()) {
            SystemClock.sleep(10L);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f16458b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    if (next.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void c(CommonNotificationBuilder.DisplayNotificationInfo displayNotificationInfo) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f16458b.getSystemService("notification")).notify(displayNotificationInfo.f16454b, displayNotificationInfo.f16455c, displayNotificationInfo.f16453a.b());
    }

    private ImageDownload d() {
        ImageDownload e8 = ImageDownload.e(this.f16459c.p("gcm.n.image"));
        if (e8 != null) {
            e8.h(this.f16457a);
        }
        return e8;
    }

    private void e(NotificationCompat.Builder builder, ImageDownload imageDownload) {
        if (imageDownload == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(imageDownload.g(), 5L, TimeUnit.SECONDS);
            builder.v(bitmap);
            builder.F(new NotificationCompat.BigPictureStyle().i(bitmap).h(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            imageDownload.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e8) {
            String valueOf = String.valueOf(e8.getCause());
            StringBuilder sb = new StringBuilder(valueOf.length() + 26);
            sb.append("Failed to download image: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            imageDownload.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.f16459c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        ImageDownload d8 = d();
        CommonNotificationBuilder.DisplayNotificationInfo d9 = CommonNotificationBuilder.d(this.f16458b, this.f16459c);
        e(d9.f16453a, d8);
        c(d9);
        return true;
    }
}
