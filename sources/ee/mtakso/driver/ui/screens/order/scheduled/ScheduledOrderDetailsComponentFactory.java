package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.RideDetailChip;
import ee.mtakso.driver.network.client.order.RideDetailInfoBlock;
import ee.mtakso.driver.network.client.order.RideDetailLabel;
import ee.mtakso.driver.network.client.order.RideDetailLabelTypeInfo;
import ee.mtakso.driver.network.client.order.RideDetailRoutePoint;
import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderHeaderDelegate;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderLinkDelegate;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderTextDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderDetailsComponentFactory.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledOrderInfoBlockMapper f31671a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledOrderButtonAppearanceMapper f31672b;

    /* renamed from: c  reason: collision with root package name */
    private final HtmlEngine f31673c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderMapPointsFactory f31674d;

    @Inject
    public ScheduledOrderDetailsComponentFactory(ScheduledOrderInfoBlockMapper infoBlockMapper, ScheduledOrderButtonAppearanceMapper buttonAppearanceMapper, HtmlEngine htmlEngine, OrderMapPointsFactory orderMapPointsFactory) {
        Intrinsics.f(infoBlockMapper, "infoBlockMapper");
        Intrinsics.f(buttonAppearanceMapper, "buttonAppearanceMapper");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(orderMapPointsFactory, "orderMapPointsFactory");
        this.f31671a = infoBlockMapper;
        this.f31672b = buttonAppearanceMapper;
        this.f31673c = htmlEngine;
        this.f31674d = orderMapPointsFactory;
    }

    public final ListModel a(String id, int i8, List<? extends ScheduledRideDetailsComponent> components, Map<String, RideDetailLabelTypeInfo> map) {
        ListModel model;
        Object Z;
        int c8;
        int v7;
        RideDetailLabelTypeInfo rideDetailLabelTypeInfo;
        String a8;
        Intrinsics.f(id, "id");
        Intrinsics.f(components, "components");
        ScheduledRideDetailsComponent scheduledRideDetailsComponent = components.get(i8);
        if (scheduledRideDetailsComponent instanceof ScheduledRideDetailsComponent.Header) {
            ScheduledRideDetailsComponent.Header header = (ScheduledRideDetailsComponent.Header) scheduledRideDetailsComponent;
            Text.Value value = new Text.Value(this.f31673c.a(header.f()));
            List<RideDetailChip> d8 = header.d();
            List<RideDetailLabel> c9 = header.c();
            v7 = CollectionsKt__IterablesKt.v(c9, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (RideDetailLabel rideDetailLabel : c9) {
                arrayList.add(new OrderLabelModel((map == null || (rideDetailLabelTypeInfo = map.get(rideDetailLabel.b())) == null || (a8 = rideDetailLabelTypeInfo.a()) == null) ? null : new Image.Url(a8), new Text.Value(rideDetailLabel.a())));
            }
            OrderMapPoints a9 = this.f31674d.a(header.b());
            List<RideDetailRoutePoint> e8 = header.e();
            RideDetailInfoBlock a10 = header.a();
            model = new ScheduledOrderHeaderDelegate.Model(id, value, d8, arrayList, a9, e8, a10 != null ? this.f31671a.a(a10) : null);
        } else if (scheduledRideDetailsComponent instanceof ScheduledRideDetailsComponent.ListItem) {
            ScheduledRideDetailsComponent.ListItem listItem = (ScheduledRideDetailsComponent.ListItem) scheduledRideDetailsComponent;
            Text.Value value2 = new Text.Value(this.f31673c.a(listItem.d()));
            Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
            String b8 = listItem.b();
            Text.Value value3 = b8 != null ? new Text.Value(this.f31673c.a(b8)) : null;
            Color.Attr attr2 = new Color.Attr(R.attr.contentSecondary);
            Color.Attr attr3 = new Color.Attr(R.attr.accentNeutral);
            String c10 = listItem.c();
            return new TwoLinesItemDelegate.Model(id, value2, 2132017739, attr, null, value3, 2132017742, attr2, attr3, c10 != null ? new Image.Url(c10) : null, null, null, null, null, null, null, null, null, scheduledRideDetailsComponent, false, 0, 0, listItem.a(), new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), Float.valueOf(listItem.a() ? Dimens.b(1.0f) : 0.0f), false, false, false, 473693200, null);
        } else if (scheduledRideDetailsComponent instanceof ScheduledRideDetailsComponent.Text) {
            Z = CollectionsKt___CollectionsKt.Z(components, i8 - 1);
            if (((ScheduledRideDetailsComponent) Z) instanceof ScheduledRideDetailsComponent.Header) {
                c8 = Dimens.c(0);
            } else {
                c8 = Dimens.c(16);
            }
            return new ScheduledOrderTextDelegate.Model(id, new Text.Value(((ScheduledRideDetailsComponent.Text) scheduledRideDetailsComponent).a()), c8, 0, 8, null);
        } else if (scheduledRideDetailsComponent instanceof ScheduledRideDetailsComponent.Link) {
            ScheduledRideDetailsComponent.Link link = (ScheduledRideDetailsComponent.Link) scheduledRideDetailsComponent;
            return new ScheduledOrderLinkDelegate.Model(id, new Text.Value(link.a()), link.b());
        } else if (scheduledRideDetailsComponent instanceof ScheduledRideDetailsComponent.Button) {
            ScheduledRideDetailsComponent.Button button = (ScheduledRideDetailsComponent.Button) scheduledRideDetailsComponent;
            return new ButtonItemDelegate.Model(id, new Text.Value(button.d()), null, null, null, this.f31672b.a(button.b()), new Color.Attr(R.attr.backPrimary), null, true, Integer.valueOf(Dimens.c(360)), new Margins(Dimens.c(24), Dimens.c(8), Dimens.c(24), Dimens.c(8)), scheduledRideDetailsComponent, false, null, null, 0.0f, false, false, 221340, null);
        } else if (!(scheduledRideDetailsComponent instanceof ScheduledRideDetailsComponent.SectionDivider)) {
            return null;
        } else {
            model = new DividerDelegate.Model(id, Dimens.c(8), 0, null, new Color.Attr(R.attr.backTertiary), 0, 0, 108, null);
        }
        return model;
    }
}
