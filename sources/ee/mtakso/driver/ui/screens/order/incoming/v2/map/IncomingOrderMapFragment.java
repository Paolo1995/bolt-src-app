package ee.mtakso.driver.ui.screens.order.incoming.v2.map;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.order.OrderMapPoint;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.route.Route;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderData;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderDetails;
import ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRoute;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel;
import ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.container.MapContainer;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderMapFragment.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderMapFragment extends BazeMvvmFragment<IncomingOrderViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final MapProvider f31450o;

    /* renamed from: p  reason: collision with root package name */
    private final MarkerParamsFactory f31451p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverFeatures f31452q;

    /* renamed from: r  reason: collision with root package name */
    private View.OnLayoutChangeListener f31453r;

    /* renamed from: s  reason: collision with root package name */
    private MarkerInfo f31454s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f31455t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f31456u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f31457v;

    /* compiled from: IncomingOrderMapFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31460a;

        static {
            int[] iArr = new int[OrderMapPoint.Type.values().length];
            try {
                iArr[OrderMapPoint.Type.PICKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderMapPoint.Type.WAYPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderMapPoint.Type.DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderMapPoint.Type.CURRENT_ORDER_DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f31460a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public IncomingOrderMapFragment(BaseUiDependencies deps, MapProvider mapProvider, MarkerParamsFactory markerParamsFactory, DriverFeatures driverFeatures) {
        super(deps, R.layout.fragment_order_incoming_map, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f31457v = new LinkedHashMap();
        this.f31450o = mapProvider;
        this.f31451p = markerParamsFactory;
        this.f31452q = driverFeatures;
    }

    private final void Y(OrderMapPoint orderMapPoint, DriverAppPlugin driverAppPlugin) {
        if (orderMapPoint.d() != null) {
            driverAppPlugin.h(this.f31451p.e(orderMapPoint, orderMapPoint.d().b(), 51));
        } else {
            driverAppPlugin.h(this.f31451p.d(orderMapPoint));
        }
    }

    private final void Z(GeoCoordinate geoCoordinate, double d8, DriverAppPlugin driverAppPlugin) {
        MarkerInfo markerInfo = this.f31454s;
        if (markerInfo == null) {
            this.f31454s = driverAppPlugin.p(R.drawable.car_driver, geoCoordinate, d8, 0);
            return;
        }
        Intrinsics.c(markerInfo);
        driverAppPlugin.f(markerInfo.a(), geoCoordinate, d8, 500L);
    }

    private final void a0(IncomingOrderData incomingOrderData, DriverAppPlugin driverAppPlugin) {
        GeoCoordinate geoCoordinate;
        List<Locatable> k8;
        Collection k9;
        List<? extends Locatable> n02;
        List<OrderMapPoint> l8;
        double d8;
        int i8 = R.id.mapHolder;
        ((MapContainer) V(i8)).removeOnLayoutChangeListener(this.f31453r);
        if (!ViewCompat.W((MapContainer) V(i8))) {
            Kalev.m(new IllegalStateException("Map container isn't laid out"), "Map container isn't laid out");
            b0(incomingOrderData, driverAppPlugin);
        } else if (((MapContainer) V(i8)).getHeight() == 0) {
            Kalev.m(new IllegalStateException("Map container's height is 0"), "Map container's height is 0");
            b0(incomingOrderData, driverAppPlugin);
        } else {
            GeoLocation c8 = incomingOrderData.a().c();
            Order order = null;
            if (c8 != null) {
                geoCoordinate = c8.e();
            } else {
                geoCoordinate = null;
            }
            if (geoCoordinate != null) {
                GeoLocation c9 = incomingOrderData.a().c();
                if (c9 != null) {
                    d8 = c9.a();
                } else {
                    d8 = 0.0d;
                }
                Z(geoCoordinate, d8, driverAppPlugin);
            }
            if (geoCoordinate == null || (k8 = GeoUtils.f36938a.i(geoCoordinate, 100.0d)) == null) {
                k8 = CollectionsKt__CollectionsKt.k();
            }
            IncomingOrderDetails c10 = incomingOrderData.b().c();
            if (c10 != null) {
                order = c10.b();
            }
            if (order != null && (l8 = order.l()) != null) {
                k9 = new ArrayList();
                for (OrderMapPoint orderMapPoint : l8) {
                    CollectionsKt__MutableCollectionsKt.A(k9, GeoUtils.f36938a.i(orderMapPoint, 250.0d));
                }
            } else {
                k9 = CollectionsKt__CollectionsKt.k();
            }
            e0(incomingOrderData, driverAppPlugin);
            n02 = CollectionsKt___CollectionsKt.n0(k8, k9);
            driverAppPlugin.e(n02, 0L, 0.0f);
        }
    }

    private final void b0(final IncomingOrderData incomingOrderData, final DriverAppPlugin driverAppPlugin) {
        this.f31453r = new View.OnLayoutChangeListener() { // from class: u4.d
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                IncomingOrderMapFragment.c0(IncomingOrderMapFragment.this, incomingOrderData, driverAppPlugin, view, i8, i9, i10, i11, i12, i13, i14, i15);
            }
        };
        ((MapContainer) V(R.id.mapHolder)).addOnLayoutChangeListener(this.f31453r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(IncomingOrderMapFragment this$0, IncomingOrderData data, DriverAppPlugin mapController, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(data, "$data");
        Intrinsics.f(mapController, "$mapController");
        this$0.a0(data, mapController);
    }

    private final void d0(OrderMapPoint orderMapPoint, boolean z7, DriverAppPlugin driverAppPlugin) {
        if (z7) {
            View label = View.inflate(getContext(), R.layout.content_matched_destination, null);
            driverAppPlugin.i(R.drawable.circle_orange, orderMapPoint, 0.0d, 1);
            driverAppPlugin.i(R.drawable.ic_map_marker_matched_destination, orderMapPoint, 0.0d, 2);
            Intrinsics.e(label, "label");
            driverAppPlugin.t(label, orderMapPoint, 0.0d, new PointF(0.0f, 0.0f));
        } else if (orderMapPoint.d() != null) {
            driverAppPlugin.h(this.f31451p.i(orderMapPoint, orderMapPoint.d().b(), 51));
        } else {
            driverAppPlugin.h(this.f31451p.h(orderMapPoint));
        }
    }

    private final void e0(IncomingOrderData incomingOrderData, DriverAppPlugin driverAppPlugin) {
        IncomingOrderDetails c8;
        Order b8;
        if (!this.f31456u && (c8 = incomingOrderData.b().c()) != null && (b8 = c8.b()) != null) {
            for (OrderMapPoint orderMapPoint : b8.l()) {
                int i8 = WhenMappings.f31460a[orderMapPoint.e().ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4) {
                                OrderMapPoint.Type e8 = orderMapPoint.e();
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected map point type: " + e8);
                                OrderMapPoint.Type e9 = orderMapPoint.e();
                                Kalev.e(illegalArgumentException, "Unexpected map point type: " + e9);
                            } else if (this.f31452q.h()) {
                                Y(orderMapPoint, driverAppPlugin);
                            }
                        } else {
                            Y(orderMapPoint, driverAppPlugin);
                        }
                    } else {
                        g0(orderMapPoint, driverAppPlugin);
                    }
                } else {
                    d0(orderMapPoint, incomingOrderData.c(), driverAppPlugin);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(IncomingOrderRoute incomingOrderRoute, DriverAppPlugin driverAppPlugin) {
        String str;
        Kalev.d("Drawing route: " + incomingOrderRoute);
        if (incomingOrderRoute == null || this.f31455t) {
            return;
        }
        Route b8 = incomingOrderRoute.b();
        String str2 = null;
        if (b8 != null) {
            str = b8.b();
        } else {
            str = null;
        }
        if (str != null) {
            driverAppPlugin.v(GeoUtils.f36938a.j(str), 16.0d, ContextCompat.getColor(requireContext(), R.color.purple500));
        }
        Route a8 = incomingOrderRoute.a();
        if (a8 != null) {
            str2 = a8.b();
        }
        if (str2 != null) {
            driverAppPlugin.v(GeoUtils.f36938a.j(str2), 16.0d, ContextCompat.getColor(requireContext(), R.color.neutral500));
        }
        this.f31455t = true;
    }

    private final void g0(OrderMapPoint orderMapPoint, DriverAppPlugin driverAppPlugin) {
        driverAppPlugin.h(this.f31451p.n(orderMapPoint));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(final DriverAppPlugin driverAppPlugin) {
        driverAppPlugin.o(M().P());
        ((MapContainer) V(R.id.mapHolder)).a();
        M().Q().i(getViewLifecycleOwner(), new Observer() { // from class: u4.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingOrderMapFragment.j0(IncomingOrderMapFragment.this, driverAppPlugin, (IncomingOrderData) obj);
            }
        });
        SingleLiveData<IncomingOrderRoute> S = M().S();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<IncomingOrderRoute, Unit> function1 = new Function1<IncomingOrderRoute, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment$start$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(IncomingOrderRoute incomingOrderRoute) {
                IncomingOrderMapFragment.this.f0(incomingOrderRoute, driverAppPlugin);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IncomingOrderRoute incomingOrderRoute) {
                b(incomingOrderRoute);
                return Unit.f50853a;
            }
        };
        S.i(viewLifecycleOwner, new Observer() { // from class: u4.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingOrderMapFragment.k0(Function1.this, obj);
            }
        });
        M().T().i(getViewLifecycleOwner(), new Observer() { // from class: u4.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingOrderMapFragment.l0(IncomingOrderMapFragment.this, driverAppPlugin, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(IncomingOrderMapFragment this$0, DriverAppPlugin map, IncomingOrderData it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(map, "$map");
        Intrinsics.e(it, "it");
        this$0.a0(it, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(IncomingOrderMapFragment this$0, DriverAppPlugin map, Integer it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(map, "$map");
        int max = Math.max((((MapContainer) this$0.V(R.id.mapHolder)).getHeight() / 2) - 2, 0);
        Intrinsics.e(it, "it");
        if (it.intValue() > max) {
            Kalev.m(new IllegalArgumentException("Padding is more than map.height / 2"), "Padding is more than map.height / 2");
        }
        map.j(Math.min(it.intValue(), max), 0);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31457v.clear();
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31457v;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: h0 */
    public IncomingOrderViewModel Q() {
        BaseUiDependencies E;
        Fragment requireParentFragment = requireParentFragment();
        Intrinsics.e(requireParentFragment, "requireParentFragment()");
        E = E();
        return (IncomingOrderViewModel) new ViewModelProvider(requireParentFragment, E.d()).a(IncomingOrderViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((MapContainer) V(R.id.mapHolder)).c(M().P());
        getChildFragmentManager().beginTransaction().replace(R.id.f397mapHolder, this.f31450o.a(new Function1<MapController, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment$onViewCreated$mapFragment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(final MapController mapController) {
                Intrinsics.f(mapController, "mapController");
                IncomingOrderMapFragment incomingOrderMapFragment = IncomingOrderMapFragment.this;
                int i8 = R.id.mapHolder;
                if (((MapContainer) incomingOrderMapFragment.V(i8)) == null) {
                    Kalev.e(new IllegalStateException("Map holder is null"), "Map holder is null");
                    return;
                }
                MapContainer mapHolder = (MapContainer) IncomingOrderMapFragment.this.V(i8);
                Intrinsics.e(mapHolder, "mapHolder");
                final IncomingOrderMapFragment incomingOrderMapFragment2 = IncomingOrderMapFragment.this;
                if (ViewCompat.W(mapHolder) && !mapHolder.isLayoutRequested()) {
                    incomingOrderMapFragment2.i0((DriverAppPlugin) mapController.a("driver"));
                } else {
                    mapHolder.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment$onViewCreated$mapFragment$1$invoke$$inlined$doOnLayout$1
                        @Override // android.view.View.OnLayoutChangeListener
                        public void onLayoutChange(View view2, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
                            Intrinsics.f(view2, "view");
                            view2.removeOnLayoutChangeListener(this);
                            IncomingOrderMapFragment.this.i0((DriverAppPlugin) mapController.a("driver"));
                        }
                    });
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapController mapController) {
                b(mapController);
                return Unit.f50853a;
            }
        }), "map").commit();
    }
}
