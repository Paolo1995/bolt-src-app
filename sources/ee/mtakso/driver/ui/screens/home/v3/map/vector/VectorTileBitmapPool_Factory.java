package ee.mtakso.driver.ui.screens.home.v3.map.vector;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VectorTileBitmapPool_Factory implements Factory<VectorTileBitmapPool> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f30334a;

    public VectorTileBitmapPool_Factory(Provider<DriverProvider> provider) {
        this.f30334a = provider;
    }

    public static VectorTileBitmapPool_Factory a(Provider<DriverProvider> provider) {
        return new VectorTileBitmapPool_Factory(provider);
    }

    public static VectorTileBitmapPool c(DriverProvider driverProvider) {
        return new VectorTileBitmapPool(driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VectorTileBitmapPool get() {
        return c(this.f30334a.get());
    }
}
