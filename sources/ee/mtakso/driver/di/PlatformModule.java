package ee.mtakso.driver.di;

import android.content.Context;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import ee.mtakso.driver.platform.google.di.GmsModule;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.plugin.PluginFactory;
import eu.bolt.android.maps.google.v2.GoogleV2MapProvider;
import eu.bolt.android.maps.google.v2.plugin.driver.GoogleV2DriverAppPlugin;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformModule.kt */
@Module(includes = {GmsModule.class, PlatformBindings.class})
/* loaded from: classes3.dex */
public final class PlatformModule {
    @Provides
    @IntoMap
    @StringKey("googleV2")
    public final MapProvider a(final Context context) {
        Intrinsics.f(context, "context");
        return new GoogleV2MapProvider(context, new PluginFactory<GoogleMap>() { // from class: ee.mtakso.driver.di.PlatformModule$provideGoogleMapsV2Provider$pluginFactory$1
            @Override // eu.bolt.android.maps.core.plugin.PluginFactory
            /* renamed from: b */
            public Map<String, Object> a(GoogleMap map, Function0<? extends View> mapViewProvider) {
                Map<String, Object> c8;
                Intrinsics.f(map, "map");
                Intrinsics.f(mapViewProvider, "mapViewProvider");
                c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("driver", new GoogleV2DriverAppPlugin(context, map, mapViewProvider)));
                return c8;
            }
        });
    }
}
