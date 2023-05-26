package ee.mtakso.driver.ui.screens.home.v3.map.surge;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MvtToRasterConverter_Factory implements Factory<MvtToRasterConverter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MvtRenderer> f30328a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VectorTileBitmapPool> f30329b;

    public MvtToRasterConverter_Factory(Provider<MvtRenderer> provider, Provider<VectorTileBitmapPool> provider2) {
        this.f30328a = provider;
        this.f30329b = provider2;
    }

    public static MvtToRasterConverter_Factory a(Provider<MvtRenderer> provider, Provider<VectorTileBitmapPool> provider2) {
        return new MvtToRasterConverter_Factory(provider, provider2);
    }

    public static MvtToRasterConverter c(MvtRenderer mvtRenderer, VectorTileBitmapPool vectorTileBitmapPool) {
        return new MvtToRasterConverter(mvtRenderer, vectorTileBitmapPool);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MvtToRasterConverter get() {
        return c(this.f30328a.get(), this.f30329b.get());
    }
}
