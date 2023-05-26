package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.common.map.MapManager;
import eu.bolt.android.maps.core.MapProvider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MapModule_ProvideMapV2Factory implements Factory<MapProvider> {
    public static MapProvider a(MapModule mapModule, MapManager mapManager) {
        return (MapProvider) Preconditions.checkNotNullFromProvides(mapModule.a(mapManager));
    }
}
