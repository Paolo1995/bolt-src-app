package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import ee.mtakso.driver.log.LogsUploader;
import ee.mtakso.driver.log.report.FirebaseReportManager;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.utils.logs.LogsUploaderImpl;

/* compiled from: LogsModule.kt */
@Module
/* loaded from: classes3.dex */
public interface LogsBindings {
    @Binds
    ReportManager a(FirebaseReportManager firebaseReportManager);

    @Binds
    LogsUploader b(LogsUploaderImpl logsUploaderImpl);
}
