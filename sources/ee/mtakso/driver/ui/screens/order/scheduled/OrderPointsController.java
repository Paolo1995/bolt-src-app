package ee.mtakso.driver.ui.screens.order.scheduled;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.RideDetailRoutePoint;
import ee.mtakso.driver.ui.screens.order.scheduled.OrderPointsController;
import ee.mtakso.driver.ui.views.DynamicViewHelper;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderPointsController.kt */
/* loaded from: classes3.dex */
public final class OrderPointsController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f31643a;

    /* renamed from: b  reason: collision with root package name */
    private final DynamicViewHelper<ViewHolder> f31644b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, View> f31645c;

    /* compiled from: OrderPointsController.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f31646a;

        /* renamed from: b  reason: collision with root package name */
        public Map<Integer, View> f31647b;

        public ViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f31647b = new LinkedHashMap();
            this.f31646a = containerView;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f31646a;
        }

        public View b(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f31647b;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View a8 = a();
                if (a8 == null || (findViewById = a8.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }
    }

    /* compiled from: OrderPointsController.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31648a;

        static {
            int[] iArr = new int[RideDetailRoutePoint.Type.values().length];
            try {
                iArr[RideDetailRoutePoint.Type.PICKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RideDetailRoutePoint.Type.WAYPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RideDetailRoutePoint.Type.DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f31648a = iArr;
        }
    }

    public OrderPointsController(ViewGroup containerView, List<? extends View> pointViews) {
        int v7;
        List J0;
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(pointViews, "pointViews");
        this.f31645c = new LinkedHashMap();
        this.f31643a = containerView;
        ViewGroup c8 = c();
        v7 = CollectionsKt__IterablesKt.v(pointViews, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (View view : pointViews) {
            arrayList.add(new ViewHolder(view));
        }
        J0 = CollectionsKt___CollectionsKt.J0(arrayList);
        this.f31644b = new DynamicViewHelper<>(c8, J0, null, new Function2<LayoutInflater, ViewGroup, ViewHolder>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderPointsController$dynamicViewHelper$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final OrderPointsController.ViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.f(inflater, "inflater");
                Intrinsics.f(parent, "parent");
                View inflate = inflater.inflate(R.layout.content_scheduled_order_route_point, parent, false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…ute_point, parent, false)");
                return new OrderPointsController.ViewHolder(inflate);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d(RideDetailRoutePoint.Type type) {
        int i8 = WhenMappings.f31648a[type.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return 0;
                }
                return R.attr.markerRouteDestination;
            }
            return R.attr.markerRouteMidStop;
        }
        return R.attr.markerRoutePickup;
    }

    public final void b(final List<RideDetailRoutePoint> routePoints) {
        Intrinsics.f(routePoints, "routePoints");
        this.f31644b.a(routePoints.size(), new Function2<ViewHolder, Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderPointsController$bindRoutePoints$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(OrderPointsController.ViewHolder pointHolder, int i8) {
                boolean z7;
                int m8;
                int d8;
                Intrinsics.f(pointHolder, "pointHolder");
                RideDetailRoutePoint rideDetailRoutePoint = routePoints.get(i8);
                ViewExtKt.d(pointHolder.a(), false, 0, 3, null);
                ImageView imageView = (ImageView) pointHolder.b(R.id.topTimeline);
                Intrinsics.e(imageView, "pointHolder.topTimeline");
                boolean z8 = true;
                if (i8 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                ViewExtKt.d(imageView, z7, 0, 2, null);
                ImageView imageView2 = (ImageView) pointHolder.b(R.id.bottomTimeline);
                Intrinsics.e(imageView2, "pointHolder.bottomTimeline");
                m8 = CollectionsKt__CollectionsKt.m(routePoints);
                if (i8 == m8) {
                    z8 = false;
                }
                ViewExtKt.d(imageView2, z8, 0, 2, null);
                ((TextView) pointHolder.b(R.id.Hb)).setText(rideDetailRoutePoint.a());
                int i9 = R.id.Q5;
                Context context = ((ImageView) pointHolder.b(i9)).getContext();
                Intrinsics.e(context, "pointHolder.icon.context");
                d8 = this.d(rideDetailRoutePoint.b());
                ((ImageView) pointHolder.b(i9)).setImageResource(ContextUtilsKt.d(context, d8));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(OrderPointsController.ViewHolder viewHolder, Integer num) {
                b(viewHolder, num.intValue());
                return Unit.f50853a;
            }
        });
    }

    public ViewGroup c() {
        return this.f31643a;
    }
}
