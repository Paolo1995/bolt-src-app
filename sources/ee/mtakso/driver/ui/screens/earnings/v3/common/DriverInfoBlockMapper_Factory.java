package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverInfoBlockMapper_Factory implements Factory<DriverInfoBlockMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f29043a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverImageMapper> f29044b;

    public DriverInfoBlockMapper_Factory(Provider<HtmlEngine> provider, Provider<DriverImageMapper> provider2) {
        this.f29043a = provider;
        this.f29044b = provider2;
    }

    public static DriverInfoBlockMapper_Factory a(Provider<HtmlEngine> provider, Provider<DriverImageMapper> provider2) {
        return new DriverInfoBlockMapper_Factory(provider, provider2);
    }

    public static DriverInfoBlockMapper c(HtmlEngine htmlEngine, DriverImageMapper driverImageMapper) {
        return new DriverInfoBlockMapper(htmlEngine, driverImageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverInfoBlockMapper get() {
        return c(this.f29043a.get(), this.f29044b.get());
    }
}
