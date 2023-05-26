package ee.mtakso.driver.log;

import android.annotation.SuppressLint;
import android.util.Log;
import ee.mtakso.driver.log.report.ReportManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalLog.kt */
/* loaded from: classes3.dex */
public final class InternalLog {

    /* renamed from: a  reason: collision with root package name */
    private final ReportManager f21003a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21004b;

    @Inject
    public InternalLog(ReportManager reportManager) {
        Intrinsics.f(reportManager, "reportManager");
        this.f21003a = reportManager;
    }

    public final void a(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        this.f21003a.d(throwable);
    }

    @SuppressLint({"LogNotTimber"})
    public final void b(String message) {
        Intrinsics.f(message, "message");
        if (!this.f21004b) {
            return;
        }
        Log.d("LOG_OF_LOGS", message);
    }

    @SuppressLint({"LogNotTimber"})
    public final void c(Throwable error) {
        Intrinsics.f(error, "error");
        if (!this.f21004b) {
            return;
        }
        Log.d("LOG_OF_LOGS", "ERROR", error);
    }
}
