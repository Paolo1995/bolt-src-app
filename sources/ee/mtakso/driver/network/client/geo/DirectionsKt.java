package ee.mtakso.driver.network.client.geo;

import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.android.maps.core.Locatable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Directions.kt */
/* loaded from: classes3.dex */
public final class DirectionsKt {
    public static final List<Locatable> a(Directions directions) {
        List<Route> list;
        Intrinsics.f(directions, "<this>");
        ArrayList arrayList = new ArrayList();
        GoogleDirections a8 = directions.a();
        if (a8 != null) {
            list = a8.a();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(GeoUtils.f36938a.j(list.get(0).b().a()));
        }
        return arrayList;
    }
}
