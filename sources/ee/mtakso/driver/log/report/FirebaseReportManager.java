package ee.mtakso.driver.log.report;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseReportManager.kt */
/* loaded from: classes3.dex */
public final class FirebaseReportManager implements ReportManager {
    @Override // ee.mtakso.driver.log.report.ReportManager
    public void b(String id) {
        Intrinsics.f(id, "id");
        FirebaseCrashlytics.a().g(id);
    }

    @Override // ee.mtakso.driver.log.report.ReportManager
    public void c(String key, String value) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        FirebaseCrashlytics.a().f(key, value);
    }

    @Override // ee.mtakso.driver.log.report.ReportManager
    public void d(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        FirebaseCrashlytics.a().d(throwable);
    }

    @Override // ee.mtakso.driver.log.report.ReportManager
    public void init() {
        FirebaseCrashlytics.a().e(true);
    }

    @Override // ee.mtakso.driver.log.report.ReportManager
    public void log(String message) {
        Intrinsics.f(message, "message");
        FirebaseCrashlytics.a().c(message);
    }
}
