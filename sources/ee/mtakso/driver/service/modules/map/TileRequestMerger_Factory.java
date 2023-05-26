package ee.mtakso.driver.service.modules.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.tile.TileClient;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TileRequestMerger_Factory implements Factory<TileRequestMerger> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TileClient> f24874a;

    public TileRequestMerger_Factory(Provider<TileClient> provider) {
        this.f24874a = provider;
    }

    public static TileRequestMerger_Factory a(Provider<TileClient> provider) {
        return new TileRequestMerger_Factory(provider);
    }

    public static TileRequestMerger c(TileClient tileClient) {
        return new TileRequestMerger(tileClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TileRequestMerger get() {
        return c(this.f24874a.get());
    }
}
