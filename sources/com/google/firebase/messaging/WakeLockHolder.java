package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
final class WakeLockHolder {

    /* renamed from: a  reason: collision with root package name */
    private static final long f16627a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f16628b = new Object();
    @GuardedBy("WakeLockHolder.syncObject")

    /* renamed from: c  reason: collision with root package name */
    private static WakeLock f16629c;

    @GuardedBy("WakeLockHolder.syncObject")
    private static void a(Context context) {
        if (f16629c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f16629c = wakeLock;
            wakeLock.setReferenceCounted(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(@NonNull Intent intent) {
        synchronized (f16628b) {
            if (f16629c != null && c(intent)) {
                d(intent, false);
                f16629c.release();
            }
        }
    }

    static boolean c(@NonNull Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    private static void d(@NonNull Intent intent, boolean z7) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComponentName e(@NonNull Context context, @NonNull Intent intent) {
        synchronized (f16628b) {
            a(context);
            boolean c8 = c(intent);
            d(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!c8) {
                f16629c.acquire(f16627a);
            }
            return startService;
        }
    }
}
