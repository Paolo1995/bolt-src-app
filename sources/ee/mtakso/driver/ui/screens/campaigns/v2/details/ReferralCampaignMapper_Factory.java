package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReferralCampaignMapper_Factory implements Factory<ReferralCampaignMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f27545a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverConfig> f27546b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ReferralCampaignInvitationFactory> f27547c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DateTimeConverter> f27548d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HtmlEngine> f27549e;

    public ReferralCampaignMapper_Factory(Provider<TrueTimeProvider> provider, Provider<DriverConfig> provider2, Provider<ReferralCampaignInvitationFactory> provider3, Provider<DateTimeConverter> provider4, Provider<HtmlEngine> provider5) {
        this.f27545a = provider;
        this.f27546b = provider2;
        this.f27547c = provider3;
        this.f27548d = provider4;
        this.f27549e = provider5;
    }

    public static ReferralCampaignMapper_Factory a(Provider<TrueTimeProvider> provider, Provider<DriverConfig> provider2, Provider<ReferralCampaignInvitationFactory> provider3, Provider<DateTimeConverter> provider4, Provider<HtmlEngine> provider5) {
        return new ReferralCampaignMapper_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ReferralCampaignMapper c(TrueTimeProvider trueTimeProvider, DriverConfig driverConfig, ReferralCampaignInvitationFactory referralCampaignInvitationFactory, DateTimeConverter dateTimeConverter, HtmlEngine htmlEngine) {
        return new ReferralCampaignMapper(trueTimeProvider, driverConfig, referralCampaignInvitationFactory, dateTimeConverter, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReferralCampaignMapper get() {
        return c(this.f27545a.get(), this.f27546b.get(), this.f27547c.get(), this.f27548d.get(), this.f27549e.get());
    }
}
