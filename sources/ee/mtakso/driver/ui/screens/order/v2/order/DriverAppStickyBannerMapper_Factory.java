package ee.mtakso.driver.ui.screens.order.v2.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverColorMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverAppStickyBannerMapper_Factory implements Factory<DriverAppStickyBannerMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f32204a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverImageMapper> f32205b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverColorMapper> f32206c;

    public DriverAppStickyBannerMapper_Factory(Provider<HtmlEngine> provider, Provider<DriverImageMapper> provider2, Provider<DriverColorMapper> provider3) {
        this.f32204a = provider;
        this.f32205b = provider2;
        this.f32206c = provider3;
    }

    public static DriverAppStickyBannerMapper_Factory a(Provider<HtmlEngine> provider, Provider<DriverImageMapper> provider2, Provider<DriverColorMapper> provider3) {
        return new DriverAppStickyBannerMapper_Factory(provider, provider2, provider3);
    }

    public static DriverAppStickyBannerMapper c(HtmlEngine htmlEngine, DriverImageMapper driverImageMapper, DriverColorMapper driverColorMapper) {
        return new DriverAppStickyBannerMapper(htmlEngine, driverImageMapper, driverColorMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverAppStickyBannerMapper get() {
        return c(this.f32204a.get(), this.f32205b.get(), this.f32206c.get());
    }
}
