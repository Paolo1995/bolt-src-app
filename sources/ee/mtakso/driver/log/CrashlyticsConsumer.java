package ee.mtakso.driver.log;

import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.network.exception.HttpException;
import ee.mtakso.driver.network.exception.HttpTransportException;
import eu.bolt.kalev.Kalevipoeg;
import eu.bolt.kalev.LogEntry;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CrashlyticsConsumer.kt */
/* loaded from: classes3.dex */
public final class CrashlyticsConsumer implements Kalevipoeg {

    /* renamed from: a  reason: collision with root package name */
    private final ReportManager f21001a;

    @Inject
    public CrashlyticsConsumer(ReportManager reportManager) {
        Intrinsics.f(reportManager, "reportManager");
        this.f21001a = reportManager;
    }

    private final void b(Throwable th) {
        if (th != null && !(th instanceof HttpException) && !(th instanceof HttpTransportException) && !(th instanceof ApiException)) {
            this.f21001a.d(th);
        }
    }

    private final void c(String str, Throwable th) {
        String str2;
        ReportManager reportManager = this.f21001a;
        if (th != null) {
            str2 = th.getMessage();
        } else {
            str2 = null;
        }
        reportManager.log(str + ". Throwable = " + str2);
    }

    @Override // eu.bolt.kalev.Kalevipoeg
    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        b(entry.g());
        c(entry.toString(), entry.g());
    }
}
