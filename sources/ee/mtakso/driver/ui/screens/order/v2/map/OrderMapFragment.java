package ee.mtakso.driver.ui.screens.order.v2.map;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.geo.Directions;
import ee.mtakso.driver.network.client.geo.DirectionsKt;
import ee.mtakso.driver.network.client.order.OrderMapPoint;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.interactor.order.active.map.MapData;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.screens.order.v2.OrderViewModel;
import ee.mtakso.driver.ui.screens.order.v2.map.MapState;
import ee.mtakso.driver.ui.screens.order.v2.map.OrderMapFragment;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.container.MapContainer;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MapProjectionAndCamera;
import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: OrderMapFragment.kt */
/* loaded from: classes3.dex */
public final class OrderMapFragment extends BazeMvvmFragment<OrderViewModel> {
    public static final Companion D = new Companion(null);
    private boolean A;
    private final Map<String, MarkerInfo> B;
    public Map<Integer, View> C;

    /* renamed from: o  reason: collision with root package name */
    private final MapProvider f32126o;

    /* renamed from: p  reason: collision with root package name */
    private final MarkerParamsFactory f32127p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverProvider f32128q;

    /* renamed from: r  reason: collision with root package name */
    private DriverAppPlugin f32129r;

    /* renamed from: s  reason: collision with root package name */
    private CompassButtonDelegate f32130s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f32131t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f32132u;

    /* renamed from: v  reason: collision with root package name */
    private MarkerInfo f32133v;

    /* renamed from: w  reason: collision with root package name */
    private MarkerInfo f32134w;

    /* renamed from: x  reason: collision with root package name */
    private NavigationMode f32135x;

    /* renamed from: y  reason: collision with root package name */
    private Integer f32136y;

    /* renamed from: z  reason: collision with root package name */
    private Directions f32137z;

    /* compiled from: OrderMapFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: OrderMapFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32138a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f32139b;

        static {
            int[] iArr = new int[NavigationMode.values().length];
            try {
                iArr[NavigationMode.OVERALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavigationMode.SEGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NavigationMode.FOLLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f32138a = iArr;
            int[] iArr2 = new int[OrderMapPoint.Type.values().length];
            try {
                iArr2[OrderMapPoint.Type.PICKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OrderMapPoint.Type.WAYPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[OrderMapPoint.Type.DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[OrderMapPoint.Type.CURRENT_ORDER_DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            f32139b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OrderMapFragment(BaseUiDependencies deps, MapProvider mapProvider, MarkerParamsFactory markerParamsFactory, DriverProvider driverProvider) {
        super(deps, R.layout.fragment_active_ride_map, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(driverProvider, "driverProvider");
        this.C = new LinkedHashMap();
        this.f32126o = mapProvider;
        this.f32127p = markerParamsFactory;
        this.f32128q = driverProvider;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: ee.mtakso.driver.ui.screens.order.v2.map.OrderMapFragment$arrowIconSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Integer invoke() {
                int q02;
                q02 = OrderMapFragment.this.q0(R.drawable.dir_arrow);
                return Integer.valueOf(q02);
            }
        });
        this.f32132u = b8;
        this.f32135x = NavigationMode.OVERALL;
        this.B = new LinkedHashMap();
    }

    private final void e0(String str, OrderMapPoint orderMapPoint) {
        FastLog g8 = Kalev.f41674e.g();
        DriverAppPlugin driverAppPlugin = null;
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "New marker appearing... " + str, null, 2, null);
        }
        int i8 = WhenMappings.f32139b[orderMapPoint.e().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        OrderMapPoint.Type e8 = orderMapPoint.e();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected map point type: " + e8);
                        OrderMapPoint.Type e9 = orderMapPoint.e();
                        Kalev.e(illegalArgumentException, "Unexpected map point type: " + e9);
                        return;
                    }
                    Map<String, MarkerInfo> map = this.B;
                    DriverAppPlugin driverAppPlugin2 = this.f32129r;
                    if (driverAppPlugin2 == null) {
                        Intrinsics.w("mapController");
                    } else {
                        driverAppPlugin = driverAppPlugin2;
                    }
                    map.put(str, g0(orderMapPoint, driverAppPlugin));
                    return;
                }
                Map<String, MarkerInfo> map2 = this.B;
                DriverAppPlugin driverAppPlugin3 = this.f32129r;
                if (driverAppPlugin3 == null) {
                    Intrinsics.w("mapController");
                } else {
                    driverAppPlugin = driverAppPlugin3;
                }
                map2.put(str, g0(orderMapPoint, driverAppPlugin));
                return;
            }
            Map<String, MarkerInfo> map3 = this.B;
            DriverAppPlugin driverAppPlugin4 = this.f32129r;
            if (driverAppPlugin4 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin4;
            }
            map3.put(str, n0(orderMapPoint, driverAppPlugin));
            return;
        }
        Map<String, MarkerInfo> map4 = this.B;
        DriverAppPlugin driverAppPlugin5 = this.f32129r;
        if (driverAppPlugin5 == null) {
            Intrinsics.w("mapController");
        } else {
            driverAppPlugin = driverAppPlugin5;
        }
        map4.put(str, m0(orderMapPoint, driverAppPlugin));
    }

    private final MarkerInfo f0(NavigationMode navigationMode, GeoCoordinate geoCoordinate, double d8) {
        int i8 = WhenMappings.f32138a[navigationMode.ordinal()];
        int i9 = R.drawable.car_driver;
        if (i8 != 1 && i8 != 2) {
            if (i8 == 3) {
                i9 = R.drawable.dir_arrow;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        DriverAppPlugin driverAppPlugin = this.f32129r;
        if (driverAppPlugin == null) {
            Intrinsics.w("mapController");
            driverAppPlugin = null;
        }
        return driverAppPlugin.p(i9, geoCoordinate, d8, 1);
    }

    private final MarkerInfo g0(OrderMapPoint orderMapPoint, DriverAppPlugin driverAppPlugin) {
        if (orderMapPoint.d() != null) {
            return driverAppPlugin.h(this.f32127p.e(orderMapPoint, orderMapPoint.d().b(), 51));
        }
        return driverAppPlugin.h(this.f32127p.d(orderMapPoint));
    }

    private final void h0(MapState mapState) {
        DriverAppPlugin driverAppPlugin;
        GeoCoordinate e8 = mapState.c().a().e();
        double a8 = mapState.c().a().a();
        if (this.f32134w == null) {
            this.f32134w = f0(mapState.d(), e8, a8);
        } else {
            DriverAppPlugin driverAppPlugin2 = null;
            if (mapState.d() == this.f32135x) {
                DriverAppPlugin driverAppPlugin3 = this.f32129r;
                if (driverAppPlugin3 == null) {
                    Intrinsics.w("mapController");
                    driverAppPlugin = null;
                } else {
                    driverAppPlugin = driverAppPlugin3;
                }
                MarkerInfo markerInfo = this.f32134w;
                Intrinsics.c(markerInfo);
                driverAppPlugin.f(markerInfo.a(), e8, a8, 500L);
            } else {
                DriverAppPlugin driverAppPlugin4 = this.f32129r;
                if (driverAppPlugin4 == null) {
                    Intrinsics.w("mapController");
                } else {
                    driverAppPlugin2 = driverAppPlugin4;
                }
                MarkerInfo markerInfo2 = this.f32134w;
                Intrinsics.c(markerInfo2);
                driverAppPlugin2.n(markerInfo2.a());
                this.f32134w = f0(mapState.d(), e8, a8);
            }
        }
        this.f32135x = mapState.d();
    }

    private final void i0(List<OrderMapPoint> list, DriverAppPlugin driverAppPlugin) {
        int v7;
        int b8;
        int d8;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        b8 = MapsKt__MapsJVMKt.b(v7);
        d8 = RangesKt___RangesKt.d(b8, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(d8);
        for (Object obj : list) {
            linkedHashMap.put(o0((OrderMapPoint) obj), obj);
        }
        Map<String, MarkerInfo> map = this.B;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, MarkerInfo> entry : map.entrySet()) {
            if (!linkedHashMap.containsKey(entry.getKey())) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            String str = (String) entry2.getKey();
            MarkerInfo markerInfo = (MarkerInfo) entry2.getValue();
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.a(g8, "Removing marker... " + str, null, 2, null);
            }
            driverAppPlugin.n(markerInfo.a());
            this.B.remove(str);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            if (!this.B.containsKey((String) entry3.getKey())) {
                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        for (Map.Entry entry4 : linkedHashMap3.entrySet()) {
            e0((String) entry4.getKey(), (OrderMapPoint) entry4.getValue());
        }
    }

    private final void j0(MapState mapState) {
        Locatable c8 = mapState.c().c();
        DriverAppPlugin driverAppPlugin = null;
        if (c8 == null) {
            MarkerInfo markerInfo = this.f32133v;
            if (markerInfo != null) {
                DriverAppPlugin driverAppPlugin2 = this.f32129r;
                if (driverAppPlugin2 == null) {
                    Intrinsics.w("mapController");
                } else {
                    driverAppPlugin = driverAppPlugin2;
                }
                driverAppPlugin.n(markerInfo.a());
                return;
            }
            return;
        }
        MarkerInfo markerInfo2 = this.f32133v;
        if (markerInfo2 != null) {
            DriverAppPlugin driverAppPlugin3 = this.f32129r;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
                driverAppPlugin3 = null;
            }
            if (driverAppPlugin3.f(markerInfo2.a(), c8, 0.0d, 500L) != null) {
                return;
            }
        }
        MarkerParams k8 = this.f32127p.k(c8);
        DriverAppPlugin driverAppPlugin4 = this.f32129r;
        if (driverAppPlugin4 == null) {
            Intrinsics.w("mapController");
        } else {
            driverAppPlugin = driverAppPlugin4;
        }
        this.f32133v = driverAppPlugin.h(k8);
        Unit unit = Unit.f50853a;
    }

    private final void k0(MapState mapState) {
        Directions d8 = mapState.c().d();
        int i8 = -1;
        DriverAppPlugin driverAppPlugin = null;
        if (d8 == null) {
            if (this.f32136y != null) {
                DriverAppPlugin driverAppPlugin2 = this.f32129r;
                if (driverAppPlugin2 == null) {
                    Intrinsics.w("mapController");
                    driverAppPlugin2 = null;
                }
                Integer num = this.f32136y;
                if (num != null) {
                    i8 = num.intValue();
                }
                driverAppPlugin2.a(i8);
                this.f32137z = null;
                this.f32136y = null;
            }
        } else if (this.f32136y != null && Intrinsics.a(this.f32137z, d8)) {
        } else {
            DriverAppPlugin driverAppPlugin3 = this.f32129r;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
                driverAppPlugin3 = null;
            }
            Integer num2 = this.f32136y;
            if (num2 != null) {
                i8 = num2.intValue();
            }
            driverAppPlugin3.a(i8);
            List<Locatable> a8 = DirectionsKt.a(d8);
            DriverAppPlugin driverAppPlugin4 = this.f32129r;
            if (driverAppPlugin4 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin4;
            }
            this.f32136y = Integer.valueOf(driverAppPlugin.v(a8, 16.0d, ContextCompat.getColor(requireContext(), R.color.purple500)));
            this.f32137z = d8;
        }
    }

    private final void l0(MapState mapState, DriverAppPlugin driverAppPlugin) {
        boolean z7;
        CompassButtonDelegate compassButtonDelegate = this.f32130s;
        if (compassButtonDelegate != null) {
            compassButtonDelegate.d(mapState.d());
        }
        ImageView locationButton = (ImageView) W(R.id.locationButton);
        Intrinsics.e(locationButton, "locationButton");
        if (mapState.d() == NavigationMode.FOLLOW) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(locationButton, z7, 0, 2, null);
        h0(mapState);
        i0(mapState.c().b(), driverAppPlugin);
        k0(mapState);
        j0(mapState);
        u0(mapState, false);
    }

    private final MarkerInfo m0(OrderMapPoint orderMapPoint, DriverAppPlugin driverAppPlugin) {
        if (orderMapPoint.d() != null) {
            return driverAppPlugin.h(this.f32127p.i(orderMapPoint, orderMapPoint.d().b(), 51));
        }
        return driverAppPlugin.h(this.f32127p.h(orderMapPoint));
    }

    private final MarkerInfo n0(OrderMapPoint orderMapPoint, DriverAppPlugin driverAppPlugin) {
        return driverAppPlugin.h(this.f32127p.n(orderMapPoint));
    }

    private final String o0(OrderMapPoint orderMapPoint) {
        OrderMapPoint.Type e8 = orderMapPoint.e();
        double a8 = orderMapPoint.a();
        double b8 = orderMapPoint.b();
        return e8 + "_" + a8 + "_" + b8;
    }

    private final int p0() {
        return ((Number) this.f32132u.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int q0(int i8) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(requireContext().getResources(), i8, options);
        return options.outHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(OrderMapFragment this$0, View view) {
        GeoLocation geoLocation;
        MapData c8;
        Intrinsics.f(this$0, "this$0");
        MapState f8 = this$0.M().A2().f();
        if (f8 != null && (c8 = f8.c()) != null) {
            geoLocation = c8.a();
        } else {
            geoLocation = null;
        }
        if (geoLocation != null) {
            this$0.u0(f8, true);
        } else {
            Kalev.d("Wrong map data on location click");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(OrderMapFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().a1();
    }

    private final void u0(MapState mapState, boolean z7) {
        long j8;
        Object i02;
        List<Locatable> k8;
        List<Locatable> k9;
        List n02;
        List n03;
        List<? extends Locatable> n04;
        List<Locatable> k10;
        List n05;
        List<? extends Locatable> n06;
        if (((MapContainer) W(R.id.mapHolder)).b() < 8 && !z7) {
            return;
        }
        if (this.A) {
            j8 = 500;
        } else {
            j8 = 0;
        }
        i02 = CollectionsKt___CollectionsKt.i0(mapState.c().b());
        OrderMapPoint orderMapPoint = (OrderMapPoint) i02;
        if (orderMapPoint == null || (k8 = GeoUtils.f36938a.i(orderMapPoint, 250.0d)) == null) {
            k8 = CollectionsKt__CollectionsKt.k();
        }
        Locatable c8 = mapState.c().c();
        if (c8 == null || (k9 = GeoUtils.f36938a.i(c8, 250.0d)) == null) {
            k9 = CollectionsKt__CollectionsKt.k();
        }
        int i8 = WhenMappings.f32138a[mapState.d().ordinal()];
        DriverAppPlugin driverAppPlugin = null;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    DriverAppPlugin driverAppPlugin2 = this.f32129r;
                    if (driverAppPlugin2 == null) {
                        Intrinsics.w("mapController");
                    } else {
                        driverAppPlugin = driverAppPlugin2;
                    }
                    driverAppPlugin.d(mapState.c().a().e(), mapState.c().a().a(), p0());
                }
            } else {
                OrderMapPoint orderMapPoint2 = (OrderMapPoint) CollectionsKt___CollectionsKt.Y(mapState.c().b());
                if (orderMapPoint2 != null) {
                    orderMapPoint = orderMapPoint2;
                }
                if (orderMapPoint == null || (k10 = GeoUtils.f36938a.i(orderMapPoint, 250.0d)) == null) {
                    k10 = CollectionsKt__CollectionsKt.k();
                }
                n05 = CollectionsKt___CollectionsKt.n0(GeoUtils.f36938a.i(mapState.c().a().e(), 100.0d), k10);
                n06 = CollectionsKt___CollectionsKt.n0(n05, k9);
                DriverAppPlugin driverAppPlugin3 = this.f32129r;
                if (driverAppPlugin3 == null) {
                    Intrinsics.w("mapController");
                } else {
                    driverAppPlugin = driverAppPlugin3;
                }
                driverAppPlugin.e(n06, j8, 30.0f);
            }
        } else {
            n02 = CollectionsKt___CollectionsKt.n0(GeoUtils.f36938a.i(mapState.c().a().e(), 100.0d), mapState.c().b());
            n03 = CollectionsKt___CollectionsKt.n0(n02, k8);
            n04 = CollectionsKt___CollectionsKt.n0(n03, k9);
            DriverAppPlugin driverAppPlugin4 = this.f32129r;
            if (driverAppPlugin4 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin4;
            }
            driverAppPlugin.e(n04, j8, 30.0f);
        }
        this.A = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(final DriverAppPlugin driverAppPlugin) {
        ((MapContainer) W(R.id.mapHolder)).a();
        ImageView compassButton = (ImageView) W(R.id.compassButton);
        Intrinsics.e(compassButton, "compassButton");
        this.f32130s = new CompassButtonDelegate(compassButton, driverAppPlugin);
        M().A2().i(getViewLifecycleOwner(), new Observer() { // from class: y4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderMapFragment.w0(OrderMapFragment.this, driverAppPlugin, (MapState) obj);
            }
        });
        M().F2().i(getViewLifecycleOwner(), new Observer() { // from class: y4.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderMapFragment.x0(OrderMapFragment.this, (Boolean) obj);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity instanceof BottomOffsetProvider) {
            ((BottomOffsetProvider) activity).B().i(getViewLifecycleOwner(), new Observer() { // from class: y4.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    OrderMapFragment.y0(OrderMapFragment.this, driverAppPlugin, (Integer) obj);
                }
            });
        }
        driverAppPlugin.w(new Function1<MapProjectionAndCamera, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.map.OrderMapFragment$start$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapProjectionAndCamera it) {
                CompassButtonDelegate compassButtonDelegate;
                Intrinsics.f(it, "it");
                compassButtonDelegate = OrderMapFragment.this.f32130s;
                if (compassButtonDelegate != null) {
                    compassButtonDelegate.e(it);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapProjectionAndCamera mapProjectionAndCamera) {
                b(mapProjectionAndCamera);
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(OrderMapFragment this$0, DriverAppPlugin mapController, MapState it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(mapController, "$mapController");
        Intrinsics.e(it, "it");
        this$0.l0(it, mapController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(OrderMapFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            ((RoundButton) this$0.W(R.id.startWaitingBtn)).setVisibility(0);
        } else {
            ((RoundButton) this$0.W(R.id.startWaitingBtn)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(OrderMapFragment this$0, DriverAppPlugin mapController, Integer it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(mapController, "$mapController");
        Intrinsics.e(it, "it");
        ((Guideline) this$0.W(R.id.guidelineBottom)).setGuidelineEnd(it.intValue());
        mapController.j(0, it.intValue());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.C.clear();
    }

    public View W(int i8) {
        View findViewById;
        Map<Integer, View> map = this.C;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((MapContainer) W(R.id.mapHolder)).c(M().z1());
        getChildFragmentManager().beginTransaction().replace(R.id.f397mapHolder, this.f32126o.a(new Function1<MapController, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.map.OrderMapFragment$onViewCreated$mapFragment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapController it) {
                DriverAppPlugin driverAppPlugin;
                OrderViewModel M;
                Intrinsics.f(it, "it");
                if (((MapContainer) OrderMapFragment.this.W(R.id.mapHolder)) == null) {
                    Kalev.e(new IllegalStateException("Map holder is null"), "Map holder is null");
                    return;
                }
                DriverAppPlugin driverAppPlugin2 = (DriverAppPlugin) it.a("driver");
                OrderMapFragment.this.f32129r = driverAppPlugin2;
                driverAppPlugin = OrderMapFragment.this.f32129r;
                if (driverAppPlugin == null) {
                    Intrinsics.w("mapController");
                    driverAppPlugin = null;
                }
                M = OrderMapFragment.this.M();
                driverAppPlugin.o(M.z1());
                OrderMapFragment.this.f32131t = true;
                OrderMapFragment.this.v0(driverAppPlugin2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapController mapController) {
                b(mapController);
                return Unit.f50853a;
            }
        }), "map").commit();
        if (this.f32128q.q().i()) {
            ImageView compassButton = (ImageView) W(R.id.compassButton);
            Intrinsics.e(compassButton, "compassButton");
            ViewGroup.LayoutParams layoutParams = compassButton.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.H = 1.0f;
                compassButton.setLayoutParams(layoutParams2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        ((ImageView) W(R.id.locationButton)).setOnClickListener(new View.OnClickListener() { // from class: y4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderMapFragment.r0(OrderMapFragment.this, view2);
            }
        });
        ((RoundButton) W(R.id.startWaitingBtn)).setOnClickListener(new View.OnClickListener() { // from class: y4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderMapFragment.s0(OrderMapFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: t0 */
    public OrderViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (OrderViewModel) new ViewModelProvider(requireActivity, E.d()).a(OrderViewModel.class);
    }
}
