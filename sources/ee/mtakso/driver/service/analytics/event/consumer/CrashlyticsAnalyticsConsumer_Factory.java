package ee.mtakso.driver.service.analytics.event.consumer;

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
public final class CrashlyticsAnalyticsConsumer_Factory implements Factory<CrashlyticsAnalyticsConsumer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ReportManager> f23480a;

    public CrashlyticsAnalyticsConsumer_Factory(Provider<ReportManager> provider) {
        this.f23480a = provider;
    }

    public static CrashlyticsAnalyticsConsumer_Factory a(Provider<ReportManager> provider) {
        return new CrashlyticsAnalyticsConsumer_Factory(provider);
    }

    public static CrashlyticsAnalyticsConsumer c(ReportManager reportManager) {
        return new CrashlyticsAnalyticsConsumer(reportManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CrashlyticsAnalyticsConsumer get() {
        return c(this.f23480a.get());
    }
}
