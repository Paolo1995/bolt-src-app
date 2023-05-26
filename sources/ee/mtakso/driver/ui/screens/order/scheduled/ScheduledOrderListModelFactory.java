package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.RideDetailLabel;
import ee.mtakso.driver.network.client.order.RideDetailLabelTypeInfo;
import ee.mtakso.driver.network.client.order.ScheduledRideRequests;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderListModelFactory.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderListModelFactory {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f31752a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderMapPointsFactory f31753b;

    @Inject
    public ScheduledOrderListModelFactory(HtmlEngine htmlEngine, OrderMapPointsFactory orderMapPointsFactory) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(orderMapPointsFactory, "orderMapPointsFactory");
        this.f31752a = htmlEngine;
        this.f31753b = orderMapPointsFactory;
    }

    public final ListModel a(String listId, ScheduledRideRequests.Item item, Map<String, RideDetailLabelTypeInfo> map) {
        int v7;
        Image.Url url;
        RideDetailLabelTypeInfo rideDetailLabelTypeInfo;
        String a8;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(item, "item");
        Text.Value value = new Text.Value(this.f31752a.a(item.e()));
        List<RideDetailLabel> c8 = item.c();
        v7 = CollectionsKt__IterablesKt.v(c8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (RideDetailLabel rideDetailLabel : c8) {
            if (map != null && (rideDetailLabelTypeInfo = map.get(rideDetailLabel.b())) != null && (a8 = rideDetailLabelTypeInfo.a()) != null) {
                url = new Image.Url(a8);
            } else {
                url = null;
            }
            arrayList.add(new OrderLabelModel(url, new Text.Value(rideDetailLabel.a())));
        }
        return new ScheduledOrderDelegate.Model(listId, value, arrayList, this.f31753b.a(item.a()), item.d(), item.b(), null, 64, null);
    }
}
