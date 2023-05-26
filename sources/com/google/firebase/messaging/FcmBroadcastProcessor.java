package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@KeepForSdk
/* loaded from: classes3.dex */
public class FcmBroadcastProcessor {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f16467c = new Object();
    @GuardedBy("lock")

    /* renamed from: d  reason: collision with root package name */
    private static WithinAppServiceConnection f16468d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f16469a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f16470b = FcmBroadcastProcessor$$Lambda$0.f16471f;

    public FcmBroadcastProcessor(Context context) {
        this.f16469a = context;
    }

    private static Task<Integer> a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        return b(context, "com.google.firebase.MESSAGING_EVENT").c(intent).continueWith(FcmBroadcastProcessor$$Lambda$3.f16476f, FcmBroadcastProcessor$$Lambda$4.f16477a);
    }

    private static WithinAppServiceConnection b(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (f16467c) {
            if (f16468d == null) {
                f16468d = new WithinAppServiceConnection(context, "com.google.firebase.MESSAGING_EVENT");
            }
            withinAppServiceConnection = f16468d;
        }
        return withinAppServiceConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Integer c(Task task) throws Exception {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Integer e(Task task) throws Exception {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Task f(Context context, Intent intent, Task task) throws Exception {
        if (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) {
            return a(context, intent).continueWith(FcmBroadcastProcessor$$Lambda$5.f16478f, FcmBroadcastProcessor$$Lambda$6.f16479a);
        }
        return task;
    }

    @KeepForSdk
    public Task<Integer> g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.f16469a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> h(final Context context, final Intent intent) {
        boolean z7 = false;
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z7 = true;
        }
        int flags = intent.getFlags() & 268435456;
        if (z7 && flags == 0) {
            return a(context, intent);
        }
        return Tasks.call(this.f16470b, new Callable(context, intent) { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$Lambda$1

            /* renamed from: f  reason: collision with root package name */
            private final Context f16472f;

            /* renamed from: g  reason: collision with root package name */
            private final Intent f16473g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16472f = context;
                this.f16473g = intent;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                Integer valueOf;
                valueOf = Integer.valueOf(ServiceStarter.b().g(this.f16472f, this.f16473g));
                return valueOf;
            }
        }).continueWithTask(this.f16470b, new Continuation(context, intent) { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$Lambda$2

            /* renamed from: a  reason: collision with root package name */
            private final Context f16474a;

            /* renamed from: b  reason: collision with root package name */
            private final Intent f16475b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16474a = context;
                this.f16475b = intent;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task) {
                return FcmBroadcastProcessor.f(this.f16474a, this.f16475b, task);
            }
        });
    }
}
