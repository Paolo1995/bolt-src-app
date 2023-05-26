package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverChipMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverColorMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverLinkAppearanceMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.EarningsBalanceStateTypeMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsLandingMapper_Factory implements Factory<EarningsLandingMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverFeatures> f29338a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverColorMapper> f29339b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverImageMapper> f29340c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverChipMapper> f29341d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverLinkAppearanceMapper> f29342e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<EarningsBalanceStateTypeMapper> f29343f;

    public EarningsLandingMapper_Factory(Provider<DriverFeatures> provider, Provider<DriverColorMapper> provider2, Provider<DriverImageMapper> provider3, Provider<DriverChipMapper> provider4, Provider<DriverLinkAppearanceMapper> provider5, Provider<EarningsBalanceStateTypeMapper> provider6) {
        this.f29338a = provider;
        this.f29339b = provider2;
        this.f29340c = provider3;
        this.f29341d = provider4;
        this.f29342e = provider5;
        this.f29343f = provider6;
    }

    public static EarningsLandingMapper_Factory a(Provider<DriverFeatures> provider, Provider<DriverColorMapper> provider2, Provider<DriverImageMapper> provider3, Provider<DriverChipMapper> provider4, Provider<DriverLinkAppearanceMapper> provider5, Provider<EarningsBalanceStateTypeMapper> provider6) {
        return new EarningsLandingMapper_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static EarningsLandingMapper c(DriverFeatures driverFeatures, DriverColorMapper driverColorMapper, DriverImageMapper driverImageMapper, DriverChipMapper driverChipMapper, DriverLinkAppearanceMapper driverLinkAppearanceMapper, EarningsBalanceStateTypeMapper earningsBalanceStateTypeMapper) {
        return new EarningsLandingMapper(driverFeatures, driverColorMapper, driverImageMapper, driverChipMapper, driverLinkAppearanceMapper, earningsBalanceStateTypeMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsLandingMapper get() {
        return c(this.f29338a.get(), this.f29339b.get(), this.f29340c.get(), this.f29341d.get(), this.f29342e.get(), this.f29343f.get());
    }
}
