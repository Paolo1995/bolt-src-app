package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapsConfigsTileCollectionsExt.kt */
/* loaded from: classes3.dex */
public final class MapsConfigsTileCollectionsExt {

    /* renamed from: a  reason: collision with root package name */
    public static final MapsConfigsTileCollectionsExt f24862a = new MapsConfigsTileCollectionsExt();

    private MapsConfigsTileCollectionsExt() {
    }

    public final TileCollectionConfig a(Map<String, TileCollectionConfig> map) {
        Intrinsics.f(map, "<this>");
        return map.get("dispatch_areas");
    }
}
