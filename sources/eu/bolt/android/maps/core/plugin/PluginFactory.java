package eu.bolt.android.maps.core.plugin;

import android.view.View;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: PluginFactory.kt */
/* loaded from: classes5.dex */
public interface PluginFactory<MapSdk> {
    Map<String, Object> a(MapSdk mapsdk, Function0<? extends View> function0);
}
