package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.order.UpcomingStop;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveOrderDetails.kt */
/* loaded from: classes3.dex */
public final class ActiveOrderDetailsKt {
    public static final List<UpcomingStop> a(ActiveOrderDetails activeOrderDetails) {
        Intrinsics.f(activeOrderDetails, "<this>");
        List<UpcomingStop> H = activeOrderDetails.i().H();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : H) {
            if (hashSet.add(Long.valueOf(((UpcomingStop) obj).b()))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
