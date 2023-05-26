package ee.mtakso.driver.log;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.report.ReportManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InternalLog_Factory implements Factory<InternalLog> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ReportManager> f21005a;

    public InternalLog_Factory(Provider<ReportManager> provider) {
        this.f21005a = provider;
    }

    public static InternalLog_Factory a(Provider<ReportManager> provider) {
        return new InternalLog_Factory(provider);
    }

    public static InternalLog c(ReportManager reportManager) {
        return new InternalLog(reportManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InternalLog get() {
        return c(this.f21005a.get());
    }
}
