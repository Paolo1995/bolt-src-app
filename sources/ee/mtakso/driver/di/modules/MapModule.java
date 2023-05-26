package ee.mtakso.driver.di.modules;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.ui.common.map.MapManager;
import eu.bolt.android.maps.core.MapProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapModule.kt */
@Module
/* loaded from: classes3.dex */
public final class MapModule {
    @Provides
    public final MapProvider a(MapManager mapManager) {
        Intrinsics.f(mapManager, "mapManager");
        return mapManager.a();
    }
}
