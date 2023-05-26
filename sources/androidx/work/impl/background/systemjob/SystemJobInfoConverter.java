package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobInfo$TriggerContentUri;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.core.os.BuildCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;

/* loaded from: classes.dex */
class SystemJobInfoConverter {

    /* renamed from: b  reason: collision with root package name */
    private static final String f8505b = Logger.f("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    private final ComponentName f8506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8507a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            f8507a = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8507a[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8507a[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8507a[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8507a[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemJobInfoConverter(@NonNull Context context) {
        this.f8506a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.app.job.JobInfo$TriggerContentUri] */
    private static JobInfo$TriggerContentUri b(ContentUriTriggers.Trigger trigger) {
        boolean b8 = trigger.b();
        final Uri a8 = trigger.a();
        final int i8 = b8 ? 1 : 0;
        return new Parcelable(a8, i8) { // from class: android.app.job.JobInfo$TriggerContentUri
            static {
                throw new NoClassDefFoundError();
            }
        };
    }

    static int c(NetworkType networkType) {
        int i8 = AnonymousClass1.f8507a[networkType.ordinal()];
        if (i8 == 1) {
            return 0;
        }
        if (i8 == 2) {
            return 1;
        }
        if (i8 == 3) {
            return 2;
        }
        if (i8 != 4) {
            if (i8 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        Logger.c().a(f8505b, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
        return 1;
    }

    static void d(@NonNull JobInfo.Builder builder, @NonNull NetworkType networkType) {
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        } else {
            builder.setRequiredNetworkType(c(networkType));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JobInfo a(WorkSpec workSpec, int i8) {
        int i9;
        Constraints constraints = workSpec.f8627j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.f8618a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.d());
        JobInfo.Builder extras = new JobInfo.Builder(i8, this.f8506a).setRequiresCharging(constraints.g()).setRequiresDeviceIdle(constraints.h()).setExtras(persistableBundle);
        d(extras, constraints.b());
        boolean z7 = false;
        if (!constraints.h()) {
            if (workSpec.f8629l == BackoffPolicy.LINEAR) {
                i9 = 0;
            } else {
                i9 = 1;
            }
            extras.setBackoffCriteria(workSpec.f8630m, i9);
        }
        long max = Math.max(workSpec.a() - System.currentTimeMillis(), 0L);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!workSpec.f8634q) {
            extras.setImportantWhileForeground(true);
        }
        if (i10 >= 24 && constraints.e()) {
            for (ContentUriTriggers.Trigger trigger : constraints.a().b()) {
                extras.addTriggerContentUri(b(trigger));
            }
            extras.setTriggerContentUpdateDelay(constraints.c());
            extras.setTriggerContentMaxDelay(constraints.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(constraints.f());
            extras.setRequiresStorageNotLow(constraints.i());
        }
        if (workSpec.f8628k > 0) {
            z7 = true;
        }
        if (BuildCompat.c() && workSpec.f8634q && !z7) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
