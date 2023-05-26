package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsItemMapper_Factory implements Factory<EarningsItemMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverImageMapper> f28962a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f28963b;

    public EarningsItemMapper_Factory(Provider<DriverImageMapper> provider, Provider<HtmlEngine> provider2) {
        this.f28962a = provider;
        this.f28963b = provider2;
    }

    public static EarningsItemMapper_Factory a(Provider<DriverImageMapper> provider, Provider<HtmlEngine> provider2) {
        return new EarningsItemMapper_Factory(provider, provider2);
    }

    public static EarningsItemMapper c(DriverImageMapper driverImageMapper, HtmlEngine htmlEngine) {
        return new EarningsItemMapper(driverImageMapper, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsItemMapper get() {
        return c(this.f28962a.get(), this.f28963b.get());
    }
}
