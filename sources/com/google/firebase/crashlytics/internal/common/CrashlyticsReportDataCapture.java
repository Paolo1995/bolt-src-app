package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class CrashlyticsReportDataCapture {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Integer> f15671e;

    /* renamed from: f  reason: collision with root package name */
    static final String f15672f;

    /* renamed from: a  reason: collision with root package name */
    private final Context f15673a;

    /* renamed from: b  reason: collision with root package name */
    private final IdManager f15674b;

    /* renamed from: c  reason: collision with root package name */
    private final AppData f15675c;

    /* renamed from: d  reason: collision with root package name */
    private final StackTraceTrimmingStrategy f15676d;

    static {
        HashMap hashMap = new HashMap();
        f15671e = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
        f15672f = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.2.12");
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f15673a = context;
        this.f15674b = idManager;
        this.f15675c = appData;
        this.f15676d = stackTraceTrimmingStrategy;
    }

    private CrashlyticsReport.Builder a() {
        return CrashlyticsReport.b().h("18.2.12").d(this.f15675c.f15559a).e(this.f15674b.a()).b(this.f15675c.f15563e).c(this.f15675c.f15564f).g(4);
    }

    private static int e() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = f15671e.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage f() {
        return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a().b(0L).d(0L).c(this.f15675c.f15562d).e(this.f15675c.f15560b).a();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> g() {
        return ImmutableList.d(f());
    }

    private CrashlyticsReport.Session.Event.Application h(int i8, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        boolean z7;
        if (applicationExitInfo.b() != 100) {
            z7 = true;
        } else {
            z7 = false;
        }
        return CrashlyticsReport.Session.Event.Application.a().b(Boolean.valueOf(z7)).f(i8).d(m(applicationExitInfo)).a();
    }

    private CrashlyticsReport.Session.Event.Application i(int i8, TrimmedThrowableData trimmedThrowableData, Thread thread, int i9, int i10, boolean z7) {
        Boolean bool;
        boolean z8;
        ActivityManager.RunningAppProcessInfo j8 = CommonUtils.j(this.f15675c.f15562d, this.f15673a);
        if (j8 != null) {
            if (j8.importance != 100) {
                z8 = true;
            } else {
                z8 = false;
            }
            bool = Boolean.valueOf(z8);
        } else {
            bool = null;
        }
        return CrashlyticsReport.Session.Event.Application.a().b(bool).f(i8).d(n(trimmedThrowableData, thread, i9, i10, z7)).a();
    }

    private CrashlyticsReport.Session.Event.Device j(int i8) {
        Double d8;
        BatteryState a8 = BatteryState.a(this.f15673a);
        Float b8 = a8.b();
        if (b8 != null) {
            d8 = Double.valueOf(b8.doubleValue());
        } else {
            d8 = null;
        }
        int c8 = a8.c();
        boolean o8 = CommonUtils.o(this.f15673a);
        long s7 = CommonUtils.s() - CommonUtils.a(this.f15673a);
        return CrashlyticsReport.Session.Event.Device.a().b(d8).c(c8).f(o8).e(i8).g(s7).d(CommonUtils.b(Environment.getDataDirectory().getPath())).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception k(TrimmedThrowableData trimmedThrowableData, int i8, int i9) {
        return l(trimmedThrowableData, i8, i9, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception l(TrimmedThrowableData trimmedThrowableData, int i8, int i9, int i10) {
        String str = trimmedThrowableData.f16199b;
        String str2 = trimmedThrowableData.f16198a;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f16200c;
        int i11 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f16201d;
        if (i10 >= i9) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.f16201d;
                i11++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder d8 = CrashlyticsReport.Session.Event.Application.Execution.Exception.a().f(str).e(str2).c(ImmutableList.b(p(stackTraceElementArr, i8))).d(i11);
        if (trimmedThrowableData2 != null && i11 == 0) {
            d8.b(l(trimmedThrowableData2, i8, i9, i10 + 1));
        }
        return d8.a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution m(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().b(applicationExitInfo).e(u()).c(g()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution n(TrimmedThrowableData trimmedThrowableData, Thread thread, int i8, int i9, boolean z7) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().f(x(trimmedThrowableData, thread, i8, z7)).d(k(trimmedThrowableData, i8, i9)).e(u()).c(g()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame o(StackTraceElement stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder) {
        long j8;
        long j9 = 0;
        if (stackTraceElement.isNativeMethod()) {
            j8 = Math.max(stackTraceElement.getLineNumber(), 0L);
        } else {
            j8 = 0;
        }
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j9 = stackTraceElement.getLineNumber();
        }
        return builder.e(j8).f(str).b(fileName).d(j9).a();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> p(StackTraceElement[] stackTraceElementArr, int i8) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(o(stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a().c(i8)));
        }
        return ImmutableList.b(arrayList);
    }

    private CrashlyticsReport.Session.Application q() {
        return CrashlyticsReport.Session.Application.a().e(this.f15674b.f()).g(this.f15675c.f15563e).d(this.f15675c.f15564f).f(this.f15674b.a()).b(this.f15675c.f15565g.d()).c(this.f15675c.f15565g.e()).a();
    }

    private CrashlyticsReport.Session r(String str, long j8) {
        return CrashlyticsReport.Session.a().l(j8).i(str).g(f15672f).b(q()).k(t()).d(s()).h(3).a();
    }

    private CrashlyticsReport.Session.Device s() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int e8 = e();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long s7 = CommonUtils.s();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean y7 = CommonUtils.y();
        int m8 = CommonUtils.m();
        String str = Build.MANUFACTURER;
        return CrashlyticsReport.Session.Device.a().b(e8).f(Build.MODEL).c(availableProcessors).h(s7).d(blockCount).i(y7).j(m8).e(str).g(Build.PRODUCT).a();
    }

    private CrashlyticsReport.Session.OperatingSystem t() {
        return CrashlyticsReport.Session.OperatingSystem.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(CommonUtils.z()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Signal u() {
        return CrashlyticsReport.Session.Event.Application.Execution.Signal.a().d("0").c("0").b(0L).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread v(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return w(thread, stackTraceElementArr, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread w(Thread thread, StackTraceElement[] stackTraceElementArr, int i8) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.a().d(thread.getName()).c(i8).b(ImmutableList.b(p(stackTraceElementArr, i8))).a();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> x(TrimmedThrowableData trimmedThrowableData, Thread thread, int i8, boolean z7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(w(thread, trimmedThrowableData.f16200c, i8));
        if (z7) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(v(key, this.f15676d.a(entry.getValue())));
                }
            }
        }
        return ImmutableList.b(arrayList);
    }

    public CrashlyticsReport.Session.Event b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        int i8 = this.f15673a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.a().f("anr").e(applicationExitInfo.h()).b(h(i8, applicationExitInfo)).c(j(i8)).a();
    }

    public CrashlyticsReport.Session.Event c(Throwable th, Thread thread, String str, long j8, int i8, int i9, boolean z7) {
        int i10 = this.f15673a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.a().f(str).e(j8).b(i(i10, new TrimmedThrowableData(th, this.f15676d), thread, i8, i9, z7)).c(j(i10)).a();
    }

    public CrashlyticsReport d(String str, long j8) {
        return a().i(r(str, j8)).a();
    }
}
