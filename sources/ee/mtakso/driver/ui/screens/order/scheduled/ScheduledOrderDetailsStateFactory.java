package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.ScheduledRideDetails;
import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderDetailsStateFactory.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsStateFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledOrderDetailsComponentFactory f31709a;

    @Inject
    public ScheduledOrderDetailsStateFactory(ScheduledOrderDetailsComponentFactory componentFactory) {
        Intrinsics.f(componentFactory, "componentFactory");
        this.f31709a = componentFactory;
    }

    public final ScheduledOrderDetailsState a(ScheduledRideDetails details) {
        Class<?> cls;
        Intrinsics.f(details, "details");
        Text.Value value = new Text.Value(details.d());
        List<ScheduledRideDetailsComponent> a8 = details.a();
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : a8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            ScheduledRideDetailsComponent scheduledRideDetailsComponent = (ScheduledRideDetailsComponent) obj;
            ListModel a9 = this.f31709a.a("item_" + i8, i8, details.a(), details.b());
            if (a9 != null) {
                arrayList.add(a9);
            }
            i8 = i9;
        }
        ScheduledRideDetailsComponent.Button button = null;
        if (details.c() instanceof ScheduledRideDetailsComponent.Button) {
            button = (ScheduledRideDetailsComponent.Button) details.c();
        } else {
            ScheduledRideDetailsComponent c8 = details.c();
            if (c8 != null) {
                cls = c8.getClass();
            } else {
                cls = null;
            }
            String str = "Unsupported component type for primaryAction " + cls;
            Kalev.m(new IllegalArgumentException(str), str);
        }
        return new ScheduledOrderDetailsState(value, arrayList, button);
    }
}
