package ee.mtakso.driver.ui.screens.home.v3.map.fifo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.service.modules.tile.VectorPropertiesFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FifoQueueTileSource_Factory implements Factory<FifoQueueTileSource> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VectorTileBitmapPool> f30201a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TileRequestMerger> f30202b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VectorPropertiesFactory> f30203c;

    public FifoQueueTileSource_Factory(Provider<VectorTileBitmapPool> provider, Provider<TileRequestMerger> provider2, Provider<VectorPropertiesFactory> provider3) {
        this.f30201a = provider;
        this.f30202b = provider2;
        this.f30203c = provider3;
    }

    public static FifoQueueTileSource_Factory a(Provider<VectorTileBitmapPool> provider, Provider<TileRequestMerger> provider2, Provider<VectorPropertiesFactory> provider3) {
        return new FifoQueueTileSource_Factory(provider, provider2, provider3);
    }

    public static FifoQueueTileSource c(VectorTileBitmapPool vectorTileBitmapPool, TileRequestMerger tileRequestMerger, VectorPropertiesFactory vectorPropertiesFactory) {
        return new FifoQueueTileSource(vectorTileBitmapPool, tileRequestMerger, vectorPropertiesFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FifoQueueTileSource get() {
        return c(this.f30201a.get(), this.f30202b.get(), this.f30203c.get());
    }
}
