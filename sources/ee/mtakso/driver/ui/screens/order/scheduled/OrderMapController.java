package ee.mtakso.driver.ui.screens.order.scheduled;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.OrderMapPoint;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.container.MapViewContainer;
import eu.bolt.android.maps.core.plugin.driver.CircleInfo;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.android.maps.core.plugin.driver.MapType;
import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import eu.bolt.driver.core.theme.AppThemeManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: OrderMapController.kt */
/* loaded from: classes3.dex */
public final class OrderMapController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f31616a;

    /* renamed from: b  reason: collision with root package name */
    private final AppThemeManager f31617b;

    /* renamed from: c  reason: collision with root package name */
    private final MarkerParamsFactory f31618c;

    /* renamed from: d  reason: collision with root package name */
    private List<MarkerInfo> f31619d;

    /* renamed from: e  reason: collision with root package name */
    private List<CircleInfo> f31620e;

    /* renamed from: f  reason: collision with root package name */
    private Function1<? super DriverAppPlugin, Unit> f31621f;

    /* renamed from: g  reason: collision with root package name */
    private DriverAppPlugin f31622g;

    /* renamed from: h  reason: collision with root package name */
    private final Lazy f31623h;

    /* compiled from: OrderMapController.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31627a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31628b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f31629c;

        static {
            int[] iArr = new int[MapStyle.values().length];
            try {
                iArr[MapStyle.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStyle.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f31627a = iArr;
            int[] iArr2 = new int[OrderMapPoint.PinAppearance.values().length];
            try {
                iArr2[OrderMapPoint.PinAppearance.PICKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[OrderMapPoint.PinAppearance.DESTINATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OrderMapPoint.PinAppearance.WAYPOINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f31628b = iArr2;
            int[] iArr3 = new int[OrderMapPoint.Type.values().length];
            try {
                iArr3[OrderMapPoint.Type.PICKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[OrderMapPoint.Type.WAYPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[OrderMapPoint.Type.DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[OrderMapPoint.Type.CURRENT_ORDER_DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[OrderMapPoint.Type.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            f31629c = iArr3;
        }
    }

    public OrderMapController(ViewGroup containerView, View replacementView, final MapProvider mapProvider, AppThemeManager themeManager, MarkerParamsFactory markerParamsFactory) {
        Lazy b8;
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(replacementView, "replacementView");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(themeManager, "themeManager");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        this.f31616a = containerView;
        this.f31617b = themeManager;
        this.f31618c = markerParamsFactory;
        this.f31619d = new ArrayList();
        this.f31620e = new ArrayList();
        b8 = LazyKt__LazyJVMKt.b(new Function0<MapViewContainer>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapController$mapViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final MapViewContainer invoke() {
                MapProvider mapProvider2 = MapProvider.this;
                final OrderMapController orderMapController = this;
                View b9 = mapProvider2.b(true, new Function1<MapController, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapController$mapViewContainer$2.1
                    {
                        super(1);
                    }

                    public final void b(MapController it) {
                        Intrinsics.f(it, "it");
                        OrderMapController.this.o((DriverAppPlugin) it.a("driver"));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MapController mapController) {
                        b(mapController);
                        return Unit.f50853a;
                    }
                });
                Intrinsics.d(b9, "null cannot be cast to non-null type eu.bolt.android.maps.core.container.MapViewContainer");
                return (MapViewContainer) b9;
            }
        });
        this.f31623h = b8;
        ViewGroup.LayoutParams layoutParams = replacementView.getLayoutParams();
        k().setId(replacementView.getId());
        containerView.removeView(replacementView);
        containerView.addView(k(), layoutParams);
        k().b(null);
    }

    private final int e(int i8) {
        int b8;
        b8 = MathKt__MathJVMKt.b(Color.alpha(i8) * 0.2f);
        return Color.argb(b8, Color.red(i8), Color.green(i8), Color.blue(i8));
    }

    private final void h(DriverAppPlugin driverAppPlugin, OrderMapPoint orderMapPoint, int i8) {
        if (orderMapPoint.c().c() == null) {
            return;
        }
        this.f31620e.add(driverAppPlugin.g(orderMapPoint.c(), orderMapPoint.c().c().doubleValue(), 0.0d, 0, e(ContextCompat.getColor(this.f31616a.getContext(), i8))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(DriverAppPlugin driverAppPlugin, OrderMapPoint orderMapPoint, MapStyle mapStyle, int i8) {
        MarkerInfo h8;
        OrderMapPoint.PinAppearance pinAppearance;
        int i9;
        int i10 = WhenMappings.f31629c[orderMapPoint.e().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5) {
                            OrderMapPoint.Pin d8 = orderMapPoint.d();
                            if (d8 != null) {
                                pinAppearance = d8.a();
                            } else {
                                pinAppearance = null;
                            }
                            if (pinAppearance == null) {
                                i9 = -1;
                            } else {
                                i9 = WhenMappings.f31628b[pinAppearance.ordinal()];
                            }
                            if (i9 != 1) {
                                if (i9 != 2) {
                                    if (i9 == 3) {
                                        this.f31619d.add(driverAppPlugin.h(this.f31618c.m(orderMapPoint, orderMapPoint.d().b(), i8)));
                                        return;
                                    }
                                    return;
                                }
                                this.f31619d.add(driverAppPlugin.h(this.f31618c.c(orderMapPoint, orderMapPoint.d().b(), i8)));
                                return;
                            }
                            this.f31619d.add(driverAppPlugin.h(this.f31618c.j(orderMapPoint, orderMapPoint.d().b(), i8)));
                            return;
                        }
                        return;
                    }
                    h(driverAppPlugin, orderMapPoint, j(mapStyle));
                    this.f31619d.add(driverAppPlugin.h(this.f31618c.d(orderMapPoint)));
                    return;
                }
                h(driverAppPlugin, orderMapPoint, j(mapStyle));
                this.f31619d.add(driverAppPlugin.h(this.f31618c.d(orderMapPoint)));
                return;
            }
            h(driverAppPlugin, orderMapPoint, m(mapStyle));
            this.f31619d.add(driverAppPlugin.h(this.f31618c.n(orderMapPoint)));
            return;
        }
        h(driverAppPlugin, orderMapPoint, l(mapStyle));
        if (orderMapPoint.d() != null) {
            h8 = driverAppPlugin.h(this.f31618c.i(orderMapPoint, orderMapPoint.d().b(), i8));
        } else {
            h8 = driverAppPlugin.h(this.f31618c.h(orderMapPoint));
        }
        this.f31619d.add(h8);
    }

    private final int j(MapStyle mapStyle) {
        int i8 = WhenMappings.f31627a[mapStyle.ordinal()];
        if (i8 != 1 && i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return R.color.red500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MapViewContainer k() {
        return (MapViewContainer) this.f31623h.getValue();
    }

    private final int l(MapStyle mapStyle) {
        int i8 = WhenMappings.f31627a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.green700;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.green600;
    }

    private final int m(MapStyle mapStyle) {
        int i8 = WhenMappings.f31627a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.purple700;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.purple500;
    }

    private final void n() {
        Function1<? super DriverAppPlugin, Unit> function1;
        DriverAppPlugin driverAppPlugin = this.f31622g;
        if (driverAppPlugin == null || (function1 = this.f31621f) == null) {
            return;
        }
        function1.invoke(driverAppPlugin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(DriverAppPlugin driverAppPlugin) {
        this.f31622g = driverAppPlugin;
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Function1<? super DriverAppPlugin, Unit> function1) {
        this.f31621f = function1;
        n();
    }

    private final void q(final Function1<? super DriverAppPlugin, Unit> function1) {
        p(null);
        final MapViewContainer k8 = k();
        Intrinsics.e(OneShotPreDrawListener.a(k8, new Runnable() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapController$waitMapController$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                this.p(function1);
            }
        }), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
    }

    public final void f(final OrderMapPoints mapPoints) {
        Intrinsics.f(mapPoints, "mapPoints");
        final MapStyle c8 = AppThemeUtils.f34255a.c(this.f31617b.d());
        k().c(c8);
        q(new Function1<DriverAppPlugin, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.OrderMapController$bind$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(DriverAppPlugin mapController) {
                MapViewContainer k8;
                Intrinsics.f(mapController, "mapController");
                k8 = OrderMapController.this.k();
                k8.a();
                mapController.o(c8);
                mapController.A(MapType.NORMAL);
                mapController.e(mapPoints.a(), 0L, 24.0f);
                List<MapPointWithBearing> b8 = mapPoints.b();
                OrderMapController orderMapController = OrderMapController.this;
                MapStyle mapStyle = c8;
                for (MapPointWithBearing mapPointWithBearing : b8) {
                    orderMapController.i(mapController, mapPointWithBearing.d(), mapStyle, MapPointWithBearingKt.a(mapPointWithBearing));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverAppPlugin driverAppPlugin) {
                b(driverAppPlugin);
                return Unit.f50853a;
            }
        });
    }

    public final void g() {
        p(null);
        for (MarkerInfo markerInfo : this.f31619d) {
            DriverAppPlugin driverAppPlugin = this.f31622g;
            if (driverAppPlugin != null) {
                driverAppPlugin.n(markerInfo.a());
            }
        }
        this.f31619d.clear();
        for (CircleInfo circleInfo : this.f31620e) {
            DriverAppPlugin driverAppPlugin2 = this.f31622g;
            if (driverAppPlugin2 != null) {
                driverAppPlugin2.b(circleInfo.a());
            }
        }
        this.f31620e.clear();
        DriverAppPlugin driverAppPlugin3 = this.f31622g;
        if (driverAppPlugin3 != null) {
            driverAppPlugin3.A(MapType.NONE);
        }
    }
}
