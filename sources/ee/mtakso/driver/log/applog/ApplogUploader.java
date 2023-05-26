package ee.mtakso.driver.log.applog;

import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.storage.LogEntity;
import ee.mtakso.driver.network.client.applog.AppLogClient;
import ee.mtakso.driver.network.client.applog.ApplogEntry;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.utils.ext.JSONObjectExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApplogUploader.kt */
/* loaded from: classes3.dex */
public final class ApplogUploader {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f21057e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final AppLogClient f21058a;

    /* renamed from: b  reason: collision with root package name */
    private final InternalLog f21059b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f21060c;

    /* renamed from: d  reason: collision with root package name */
    private final DeviceFeatures f21061d;

    /* compiled from: ApplogUploader.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String severity) {
            Intrinsics.f(severity, "severity");
            int hashCode = severity.hashCode();
            if (hashCode != 100) {
                if (hashCode != 101) {
                    if (hashCode != 105) {
                        if (hashCode != 118) {
                            if (hashCode == 119 && severity.equals("w")) {
                                return ApploggerSeverity.WARNING.c();
                            }
                        } else if (severity.equals("v")) {
                            return ApploggerSeverity.TRACE.c();
                        }
                    } else if (severity.equals("i")) {
                        return ApploggerSeverity.INFO.c();
                    }
                } else if (severity.equals("e")) {
                    return ApploggerSeverity.ERROR.c();
                }
            } else if (severity.equals("d")) {
                return ApploggerSeverity.DEBUG.c();
            }
            return ApploggerSeverity.CRITICAL.c();
        }
    }

    public ApplogUploader(AppLogClient appLogClient, InternalLog internalLog, DriverProvider driverProvider, DeviceFeatures deviceFeatures) {
        Intrinsics.f(appLogClient, "appLogClient");
        Intrinsics.f(internalLog, "internalLog");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(deviceFeatures, "deviceFeatures");
        this.f21058a = appLogClient;
        this.f21059b = internalLog;
        this.f21060c = driverProvider;
        this.f21061d = deviceFeatures;
    }

    private final ApplogEntry a(LogEntity logEntity) {
        JSONObject jSONObject = new JSONObject(logEntity.a());
        long e8 = logEntity.e();
        return new ApplogEntry(JSONObjectExtKt.a(jSONObject), f21057e.a(logEntity.c()), logEntity.b(), e8);
    }

    public final boolean b(List<LogEntity> logs) {
        int v7;
        Intrinsics.f(logs, "logs");
        if (this.f21060c.p().d().isEmpty() && this.f21060c.p().e().isEmpty()) {
            return false;
        }
        v7 = CollectionsKt__IterablesKt.v(logs, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LogEntity logEntity : logs) {
            arrayList.add(a(logEntity));
        }
        return c(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(java.util.List<ee.mtakso.driver.network.client.applog.ApplogEntry> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "logs"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            ee.mtakso.driver.param.DriverProvider r0 = r6.f21060c
            ee.mtakso.driver.param.DriverFeatures r0 = r0.e()
            r1 = 0
            if (r0 == 0) goto L13
            java.util.Set r0 = r0.d()
            goto L14
        L13:
            r0 = r1
        L14:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L21
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1f
            goto L21
        L1f:
            r0 = 0
            goto L22
        L21:
            r0 = 1
        L22:
            if (r0 == 0) goto L4c
            ee.mtakso.driver.param.DriverProvider r0 = r6.f21060c
            ee.mtakso.driver.param.DriverFeatures r0 = r0.e()
            if (r0 == 0) goto L30
            java.util.Set r1 = r0.e()
        L30:
            if (r1 == 0) goto L3b
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L39
            goto L3b
        L39:
            r0 = 0
            goto L3c
        L3b:
            r0 = 1
        L3c:
            if (r0 == 0) goto L4c
            ee.mtakso.driver.param.DeviceFeatures r0 = r6.f21061d
            java.util.Set r0 = r0.a()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L4c
            r0 = 1
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 == 0) goto L50
            return r3
        L50:
            ee.mtakso.driver.network.client.applog.LogUploadRequest r0 = new ee.mtakso.driver.network.client.applog.LogUploadRequest     // Catch: java.lang.Exception -> Laf
            r0.<init>(r7)     // Catch: java.lang.Exception -> Laf
            java.util.List r7 = r0.a()     // Catch: java.lang.Exception -> Laf
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Exception -> Laf
            if (r7 == 0) goto L60
            return r2
        L60:
            ee.mtakso.driver.log.InternalLog r7 = r6.f21059b     // Catch: java.lang.Exception -> Laf
            java.util.List r1 = r0.a()     // Catch: java.lang.Exception -> Laf
            int r1 = r1.size()     // Catch: java.lang.Exception -> Laf
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf
            r4.<init>()     // Catch: java.lang.Exception -> Laf
            java.lang.String r5 = "Uploading file. Count: "
            r4.append(r5)     // Catch: java.lang.Exception -> Laf
            r4.append(r1)     // Catch: java.lang.Exception -> Laf
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> Laf
            r7.b(r1)     // Catch: java.lang.Exception -> Laf
            ee.mtakso.driver.network.client.applog.AppLogClient r7 = r6.f21058a     // Catch: java.lang.Exception -> Laf
            retrofit2.Call r7 = r7.a(r0)     // Catch: java.lang.Exception -> Laf
            retrofit2.Response r7 = r7.execute()     // Catch: java.lang.Exception -> Laf
            int r0 = r7.code()     // Catch: java.lang.Exception -> Laf
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L98
            ee.mtakso.driver.log.InternalLog r7 = r6.f21059b     // Catch: java.lang.Exception -> Laf
            java.lang.String r0 = "Uploaded OK"
            r7.b(r0)     // Catch: java.lang.Exception -> Laf
            goto Lae
        L98:
            ee.mtakso.driver.log.InternalLog r0 = r6.f21059b     // Catch: java.lang.Exception -> Laf
            java.lang.String r1 = "Uploaded FAIL."
            r0.b(r1)     // Catch: java.lang.Exception -> Laf
            ee.mtakso.driver.log.InternalLog r0 = r6.f21059b     // Catch: java.lang.Exception -> Laf
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> Laf
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Laf
            r1.<init>(r7)     // Catch: java.lang.Exception -> Laf
            r0.a(r1)     // Catch: java.lang.Exception -> Laf
            r2 = 0
        Lae:
            return r2
        Laf:
            r7 = move-exception
            ee.mtakso.driver.log.InternalLog r0 = r6.f21059b
            r0.c(r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.log.applog.ApplogUploader.c(java.util.List):boolean");
    }
}
