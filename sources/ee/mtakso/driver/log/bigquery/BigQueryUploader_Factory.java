package ee.mtakso.driver.log.bigquery;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BigQueryUploader_Factory implements Factory<BigQueryUploader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnalyticsManager> f21082a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InternalLog> f21083b;

    public BigQueryUploader_Factory(Provider<AnalyticsManager> provider, Provider<InternalLog> provider2) {
        this.f21082a = provider;
        this.f21083b = provider2;
    }

    public static BigQueryUploader_Factory a(Provider<AnalyticsManager> provider, Provider<InternalLog> provider2) {
        return new BigQueryUploader_Factory(provider, provider2);
    }

    public static BigQueryUploader c(AnalyticsManager analyticsManager, InternalLog internalLog) {
        return new BigQueryUploader(analyticsManager, internalLog);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BigQueryUploader get() {
        return c(this.f21082a.get(), this.f21083b.get());
    }
}
