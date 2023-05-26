package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Utils;
import java.util.List;

/* loaded from: classes3.dex */
class GaugeMetadataManager {

    /* renamed from: f  reason: collision with root package name */
    private static final AndroidLogger f16744f = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private final Runtime f16745a;

    /* renamed from: b  reason: collision with root package name */
    private final ActivityManager f16746b;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityManager.MemoryInfo f16747c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16748d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f16749e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GaugeMetadataManager(Context context) {
        this(Runtime.getRuntime(), context);
    }

    private String a() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.f16746b.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return this.f16749e.getPackageName();
    }

    public int b() {
        return Utils.c(StorageUnit.BYTES.a(this.f16747c.totalMem));
    }

    public int c() {
        return Utils.c(StorageUnit.BYTES.a(this.f16745a.maxMemory()));
    }

    public int d() {
        return Utils.c(StorageUnit.MEGABYTES.a(this.f16746b.getMemoryClass()));
    }

    public String e() {
        return this.f16748d;
    }

    GaugeMetadataManager(Runtime runtime, Context context) {
        this.f16745a = runtime;
        this.f16749e = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f16746b = activityManager;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f16747c = memoryInfo;
        activityManager.getMemoryInfo(memoryInfo);
        this.f16748d = a();
    }
}
