package ee.mtakso.driver.service.modules.tile;

import ee.mtakso.driver.uikit.utils.ColorParser;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorPropertiesFactory.kt */
/* loaded from: classes3.dex */
public final class VectorPropertiesFactory {

    /* renamed from: a  reason: collision with root package name */
    private final FeaturePropertiesFactory f25373a;

    @Inject
    public VectorPropertiesFactory(FeaturePropertiesFactory featurePropertiesFactory) {
        Intrinsics.f(featurePropertiesFactory, "featurePropertiesFactory");
        this.f25373a = featurePropertiesFactory;
    }

    private final Integer b(String str, String str2) {
        if (str == null) {
            str = str2;
        }
        if (str != null) {
            return Integer.valueOf(ColorParser.f36034a.a(str));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final ee.mtakso.driver.service.modules.tile.VectorProperties a(eu.bolt.driver.maps.tile.mvt.MvtFeature r12, ee.mtakso.driver.network.client.driver.map.TileCollectionConfig r13) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.modules.tile.VectorPropertiesFactory.a(eu.bolt.driver.maps.tile.mvt.MvtFeature, ee.mtakso.driver.network.client.driver.map.TileCollectionConfig):ee.mtakso.driver.service.modules.tile.VectorProperties");
    }
}
