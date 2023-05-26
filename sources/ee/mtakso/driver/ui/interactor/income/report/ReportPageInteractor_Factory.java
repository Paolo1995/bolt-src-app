package ee.mtakso.driver.ui.interactor.income.report;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.earnings.EarningsClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReportPageInteractor_Factory implements Factory<ReportPageInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsClient> f26598a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ReportItemsMapper> f26599b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ChartMapper> f26600c;

    public ReportPageInteractor_Factory(Provider<EarningsClient> provider, Provider<ReportItemsMapper> provider2, Provider<ChartMapper> provider3) {
        this.f26598a = provider;
        this.f26599b = provider2;
        this.f26600c = provider3;
    }

    public static ReportPageInteractor_Factory a(Provider<EarningsClient> provider, Provider<ReportItemsMapper> provider2, Provider<ChartMapper> provider3) {
        return new ReportPageInteractor_Factory(provider, provider2, provider3);
    }

    public static ReportPageInteractor c(EarningsClient earningsClient, ReportItemsMapper reportItemsMapper, ChartMapper chartMapper) {
        return new ReportPageInteractor(earningsClient, reportItemsMapper, chartMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReportPageInteractor get() {
        return c(this.f26598a.get(), this.f26599b.get(), this.f26600c.get());
    }
}
