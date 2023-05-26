package ee.mtakso.driver.ui.screens.earnings.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.earnings.EarningsClient;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.EarningsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.interactor.income.report.ReportPageInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayToBoltLinkInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutPayToBoltInfoInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsViewModel_Factory implements Factory<EarningsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsInteractor> f28549a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PayToBoltLinkInteractor> f28550b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PayoutPayToBoltInfoInteractor> f28551c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EarningsAnalytics> f28552d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<EarningsV2Analytics> f28553e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PayoutAnalytics> f28554f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<EarningsClient> f28555g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverSettings> f28556h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<ReportPageInteractor> f28557i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<DriverFeatures> f28558j;

    public EarningsViewModel_Factory(Provider<EarningsInteractor> provider, Provider<PayToBoltLinkInteractor> provider2, Provider<PayoutPayToBoltInfoInteractor> provider3, Provider<EarningsAnalytics> provider4, Provider<EarningsV2Analytics> provider5, Provider<PayoutAnalytics> provider6, Provider<EarningsClient> provider7, Provider<DriverSettings> provider8, Provider<ReportPageInteractor> provider9, Provider<DriverFeatures> provider10) {
        this.f28549a = provider;
        this.f28550b = provider2;
        this.f28551c = provider3;
        this.f28552d = provider4;
        this.f28553e = provider5;
        this.f28554f = provider6;
        this.f28555g = provider7;
        this.f28556h = provider8;
        this.f28557i = provider9;
        this.f28558j = provider10;
    }

    public static EarningsViewModel_Factory a(Provider<EarningsInteractor> provider, Provider<PayToBoltLinkInteractor> provider2, Provider<PayoutPayToBoltInfoInteractor> provider3, Provider<EarningsAnalytics> provider4, Provider<EarningsV2Analytics> provider5, Provider<PayoutAnalytics> provider6, Provider<EarningsClient> provider7, Provider<DriverSettings> provider8, Provider<ReportPageInteractor> provider9, Provider<DriverFeatures> provider10) {
        return new EarningsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static EarningsViewModel c(EarningsInteractor earningsInteractor, PayToBoltLinkInteractor payToBoltLinkInteractor, PayoutPayToBoltInfoInteractor payoutPayToBoltInfoInteractor, EarningsAnalytics earningsAnalytics, EarningsV2Analytics earningsV2Analytics, PayoutAnalytics payoutAnalytics, EarningsClient earningsClient, DriverSettings driverSettings, ReportPageInteractor reportPageInteractor, DriverFeatures driverFeatures) {
        return new EarningsViewModel(earningsInteractor, payToBoltLinkInteractor, payoutPayToBoltInfoInteractor, earningsAnalytics, earningsV2Analytics, payoutAnalytics, earningsClient, driverSettings, reportPageInteractor, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsViewModel get() {
        return c(this.f28549a.get(), this.f28550b.get(), this.f28551c.get(), this.f28552d.get(), this.f28553e.get(), this.f28554f.get(), this.f28555g.get(), this.f28556h.get(), this.f28557i.get(), this.f28558j.get());
    }
}
