package ee.mtakso.driver.ui.common.map;

import eu.bolt.android.maps.core.MapProvider;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapManager.kt */
/* loaded from: classes3.dex */
public final class MapManager {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f26378b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, MapProvider> f26379a;

    /* compiled from: MapManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public MapManager(Map<String, MapProvider> providers) {
        Intrinsics.f(providers, "providers");
        this.f26379a = providers;
    }

    public final MapProvider a() {
        Object s02;
        s02 = CollectionsKt___CollectionsKt.s0(this.f26379a.values());
        return (MapProvider) s02;
    }
}
