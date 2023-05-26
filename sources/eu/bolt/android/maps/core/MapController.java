package eu.bolt.android.maps.core;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapController.kt */
/* loaded from: classes5.dex */
public final class MapController {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f36943a;

    public MapController(Map<String, ? extends Object> plugins) {
        Intrinsics.f(plugins, "plugins");
        this.f36943a = plugins;
    }

    public final <T> T a(String key) {
        Object g8;
        Intrinsics.f(key, "key");
        g8 = MapsKt__MapsKt.g(this.f36943a, key);
        return (T) g8;
    }
}
