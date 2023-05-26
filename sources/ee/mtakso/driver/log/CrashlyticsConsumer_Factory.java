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
public final class CrashlyticsConsumer_Factory implements Factory<CrashlyticsConsumer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ReportManager> f21002a;

    public CrashlyticsConsumer_Factory(Provider<ReportManager> provider) {
        this.f21002a = provider;
    }

    public static CrashlyticsConsumer_Factory a(Provider<ReportManager> provider) {
        return new CrashlyticsConsumer_Factory(provider);
    }

    public static CrashlyticsConsumer c(ReportManager reportManager) {
        return new CrashlyticsConsumer(reportManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CrashlyticsConsumer get() {
        return c(this.f21002a.get());
    }
}
