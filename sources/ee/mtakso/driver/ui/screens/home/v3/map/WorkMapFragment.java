package ee.mtakso.driver.ui.screens.home.v3.map;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.Coordinates;
import ee.mtakso.driver.network.client.campaign.ActiveAndPendingCampaignInfo;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.order.FifoQueueDispatchAreaState;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.common.map.MapPaddingViewModel;
import ee.mtakso.driver.ui.interactor.driver.DriverArea;
import ee.mtakso.driver.ui.interactor.driver.FifoQueueMap;
import ee.mtakso.driver.ui.interactor.driver.NearbyDriver;
import ee.mtakso.driver.ui.interactor.map.Heatmap;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileLabel;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileLabelManager;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileSource;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileState;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.HeatmapTileSourceArgs;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.HeatmapTileSourceFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarker;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerRenderer;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTileSourceArgs;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTileSourceFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTile;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerRenderer;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.image.ImageCallback;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.uikit.utils.image.ImageSize;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapController;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.maps.core.container.MapContainer;
import eu.bolt.android.maps.core.plugin.driver.CircleInfo;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MapProjectionAndCamera;
import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import eu.bolt.kalev.Kalev;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkMapFragment.kt */
/* loaded from: classes3.dex */
public final class WorkMapFragment extends BazeMvvmFragment<WorkMapViewModel> {
    private static final Companion O = new Companion(null);
    private CircleInfo A;
    private MarkerInfo B;
    private final List<MarkerInfo> C;
    private final Lazy D;
    private final List<Integer> E;
    private final List<MarkerInfo> F;
    private Integer G;
    private Integer H;
    private FifoQueueTileLabelManager I;
    private final Lazy J;
    private Integer K;
    private Integer L;
    private MapTileMarkerRenderer<WaitingTimeMarker> M;
    public Map<Integer, View> N;

    /* renamed from: o  reason: collision with root package name */
    private final MapProvider f30064o;

    /* renamed from: p  reason: collision with root package name */
    private final HeatmapTileSourceFactory f30065p;

    /* renamed from: q  reason: collision with root package name */
    private final WaitingTimeTileSourceFactory f30066q;

    /* renamed from: r  reason: collision with root package name */
    private final WaitingTimeMarkerRenderer f30067r;

    /* renamed from: s  reason: collision with root package name */
    private final FifoQueueTileSource f30068s;

    /* renamed from: t  reason: collision with root package name */
    private final FifoQueueTileSource f30069t;

    /* renamed from: u  reason: collision with root package name */
    private final MarkerParamsFactory f30070u;

    /* renamed from: v  reason: collision with root package name */
    private final HtmlEngine f30071v;

    /* renamed from: w  reason: collision with root package name */
    private final DriverFeatures f30072w;

    /* renamed from: x  reason: collision with root package name */
    private DriverAppPlugin f30073x;

    /* renamed from: y  reason: collision with root package name */
    private final Lazy f30074y;

    /* renamed from: z  reason: collision with root package name */
    private MarkerInfo f30075z;

    /* compiled from: WorkMapFragment.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public WorkMapFragment(BaseUiDependencies deps, MapProvider mapProvider, HeatmapTileSourceFactory heatmapTileSourceFactory, WaitingTimeTileSourceFactory waitingTimeTileSourceFactory, WaitingTimeMarkerRenderer waitingTimeLabelRenderer, FifoQueueTileSource fifoQueueTileSource, FifoQueueTileSource fifoQueueOutsideTileSource, MarkerParamsFactory markerParamsFactory, HtmlEngine htmlEngine, DriverFeatures driverFeatures) {
        super(deps, R.layout.fragment_work_map, null, 4, null);
        Lazy b8;
        Lazy b9;
        Lazy b10;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(mapProvider, "mapProvider");
        Intrinsics.f(heatmapTileSourceFactory, "heatmapTileSourceFactory");
        Intrinsics.f(waitingTimeTileSourceFactory, "waitingTimeTileSourceFactory");
        Intrinsics.f(waitingTimeLabelRenderer, "waitingTimeLabelRenderer");
        Intrinsics.f(fifoQueueTileSource, "fifoQueueTileSource");
        Intrinsics.f(fifoQueueOutsideTileSource, "fifoQueueOutsideTileSource");
        Intrinsics.f(markerParamsFactory, "markerParamsFactory");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.N = new LinkedHashMap();
        this.f30064o = mapProvider;
        this.f30065p = heatmapTileSourceFactory;
        this.f30066q = waitingTimeTileSourceFactory;
        this.f30067r = waitingTimeLabelRenderer;
        this.f30068s = fifoQueueTileSource;
        this.f30069t = fifoQueueOutsideTileSource;
        this.f30070u = markerParamsFactory;
        this.f30071v = htmlEngine;
        this.f30072w = driverFeatures;
        b8 = LazyKt__LazyJVMKt.b(new Function0<MapPaddingViewModel>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$paddingViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final MapPaddingViewModel invoke() {
                BaseUiDependencies E;
                WorkMapFragment workMapFragment = WorkMapFragment.this;
                FragmentActivity requireActivity = workMapFragment.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                E = workMapFragment.E();
                return (MapPaddingViewModel) new ViewModelProvider(requireActivity, E.d()).a(MapPaddingViewModel.class);
            }
        });
        this.f30074y = b8;
        this.C = new ArrayList();
        b9 = LazyKt__LazyJVMKt.b(new Function0<View>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$campaignLabelView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final View invoke() {
                return View.inflate(WorkMapFragment.this.getContext(), R.layout.active_campaigns_label, null);
            }
        });
        this.D = b9;
        this.E = new ArrayList();
        this.F = new ArrayList();
        b10 = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$handler$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.J = b10;
    }

    private final void B0(long j8, boolean z7) {
        DriverArea f8;
        List<? extends Locatable> n02;
        if ((((MapContainer) Y(R.id.mapHolderWork)).b() < 10 && !z7) || (f8 = M().X().f()) == null) {
            return;
        }
        DriverAppPlugin driverAppPlugin = null;
        if (f8.b() != null) {
            GeoUtils geoUtils = GeoUtils.f36938a;
            n02 = CollectionsKt___CollectionsKt.n0(geoUtils.h(f8.b(), 70.0d), geoUtils.h(f8.c(), 70.0d));
            DriverAppPlugin driverAppPlugin2 = this.f30073x;
            if (driverAppPlugin2 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin2;
            }
            driverAppPlugin.e(n02, j8, 10.0f);
        } else if (f8.d() != null) {
            List<Locatable> h8 = GeoUtils.f36938a.h(f8.c(), f8.d().intValue());
            DriverAppPlugin driverAppPlugin3 = this.f30073x;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin3;
            }
            driverAppPlugin.e(h8, j8, 10.0f);
        } else {
            DriverAppPlugin driverAppPlugin4 = this.f30073x;
            if (driverAppPlugin4 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin4;
            }
            driverAppPlugin.e(GeoUtils.f36938a.i(f8.c(), 100.0d), j8, 10.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void C0(WorkMapFragment workMapFragment, long j8, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        workMapFragment.B0(j8, z7);
    }

    private final void D0() {
        Integer num = this.H;
        if (num != null) {
            int intValue = num.intValue();
            DriverAppPlugin driverAppPlugin = this.f30073x;
            if (driverAppPlugin == null) {
                Intrinsics.w("mapController");
                driverAppPlugin = null;
            }
            driverAppPlugin.u(intValue);
        }
        this.H = null;
    }

    private final void E0() {
        Integer num = this.G;
        if (num != null) {
            int intValue = num.intValue();
            DriverAppPlugin driverAppPlugin = this.f30073x;
            if (driverAppPlugin == null) {
                Intrinsics.w("mapController");
                driverAppPlugin = null;
            }
            driverAppPlugin.u(intValue);
        }
        this.G = null;
        this.f30068s.h(new Function1<FifoQueueTileLabel, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$removeFifoQueueTileOverlay$2
            public final void b(FifoQueueTileLabel it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FifoQueueTileLabel fifoQueueTileLabel) {
                b(fifoQueueTileLabel);
                return Unit.f50853a;
            }
        });
        FifoQueueTileLabelManager fifoQueueTileLabelManager = this.I;
        if (fifoQueueTileLabelManager != null) {
            fifoQueueTileLabelManager.c();
        }
    }

    private final void F0() {
        MapTileMarkerRenderer<WaitingTimeMarker> mapTileMarkerRenderer = this.M;
        if (mapTileMarkerRenderer != null) {
            mapTileMarkerRenderer.g();
        }
        Integer num = this.K;
        if (num != null) {
            int intValue = num.intValue();
            DriverAppPlugin driverAppPlugin = this.f30073x;
            if (driverAppPlugin == null) {
                Intrinsics.w("mapController");
                driverAppPlugin = null;
            }
            driverAppPlugin.u(intValue);
        }
        this.K = null;
        Integer num2 = this.L;
        if (num2 != null) {
            int intValue2 = num2.intValue();
            DriverAppPlugin driverAppPlugin2 = this.f30073x;
            if (driverAppPlugin2 == null) {
                Intrinsics.w("mapController");
                driverAppPlugin2 = null;
            }
            driverAppPlugin2.u(intValue2);
        }
        this.L = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(MapController mapController) {
        if (getView() == null) {
            return;
        }
        DriverAppPlugin driverAppPlugin = (DriverAppPlugin) mapController.a("driver");
        this.f30073x = driverAppPlugin;
        DriverAppPlugin driverAppPlugin2 = null;
        if (driverAppPlugin == null) {
            Intrinsics.w("mapController");
            driverAppPlugin = null;
        }
        driverAppPlugin.o(M().b0());
        DriverAppPlugin driverAppPlugin3 = this.f30073x;
        if (driverAppPlugin3 == null) {
            Intrinsics.w("mapController");
            driverAppPlugin3 = null;
        }
        driverAppPlugin3.setTrafficEnabled(false);
        DriverAppPlugin driverAppPlugin4 = this.f30073x;
        if (driverAppPlugin4 == null) {
            Intrinsics.w("mapController");
            driverAppPlugin4 = null;
        }
        driverAppPlugin4.x(new Function1<MarkerInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MarkerInfo markerIndo) {
                FifoQueueTileLabelManager fifoQueueTileLabelManager;
                Intrinsics.f(markerIndo, "markerIndo");
                fifoQueueTileLabelManager = WorkMapFragment.this.I;
                if (fifoQueueTileLabelManager != null) {
                    final WorkMapFragment workMapFragment = WorkMapFragment.this;
                    fifoQueueTileLabelManager.h(markerIndo, new Function1<FifoQueueTileLabel, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$1.1
                        {
                            super(1);
                        }

                        public final void b(FifoQueueTileLabel it) {
                            WorkMapViewModel M;
                            Intrinsics.f(it, "it");
                            M = WorkMapFragment.this.M();
                            M.U();
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FifoQueueTileLabel fifoQueueTileLabel) {
                            b(fifoQueueTileLabel);
                            return Unit.f50853a;
                        }
                    });
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MarkerInfo markerInfo) {
                b(markerInfo);
                return Unit.f50853a;
            }
        });
        DriverAppPlugin driverAppPlugin5 = this.f30073x;
        if (driverAppPlugin5 == null) {
            Intrinsics.w("mapController");
            driverAppPlugin5 = null;
        }
        driverAppPlugin5.w(new Function1<MapProjectionAndCamera, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapProjectionAndCamera it) {
                MapTileMarkerRenderer mapTileMarkerRenderer;
                Intrinsics.f(it, "it");
                mapTileMarkerRenderer = WorkMapFragment.this.M;
                if (mapTileMarkerRenderer != null) {
                    mapTileMarkerRenderer.m((int) it.a().c());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapProjectionAndCamera mapProjectionAndCamera) {
                b(mapProjectionAndCamera);
                return Unit.f50853a;
            }
        });
        WorkMapFragment$start$3 workMapFragment$start$3 = new WorkMapFragment$start$3(this.f30067r);
        DriverAppPlugin driverAppPlugin6 = this.f30073x;
        if (driverAppPlugin6 == null) {
            Intrinsics.w("mapController");
        } else {
            driverAppPlugin2 = driverAppPlugin6;
        }
        this.M = new MapTileMarkerRenderer<>(workMapFragment$start$3, driverAppPlugin2);
        ((MapContainer) Y(R.id.mapHolderWork)).a();
        LiveData<DriverArea> X = M().X();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<DriverArea, Unit> function1 = new Function1<DriverArea, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverArea it) {
                MarkerInfo markerInfo;
                long j8;
                DriverAppPlugin driverAppPlugin7;
                markerInfo = WorkMapFragment.this.f30075z;
                if (markerInfo == null) {
                    j8 = 0;
                } else {
                    j8 = 200;
                }
                long j9 = j8;
                WorkMapFragment workMapFragment = WorkMapFragment.this;
                driverAppPlugin7 = workMapFragment.f30073x;
                if (driverAppPlugin7 == null) {
                    Intrinsics.w("mapController");
                    driverAppPlugin7 = null;
                }
                Intrinsics.e(it, "it");
                workMapFragment.q0(driverAppPlugin7, it);
                WorkMapFragment.C0(WorkMapFragment.this, j9, false, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverArea driverArea) {
                b(driverArea);
                return Unit.f50853a;
            }
        };
        X.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkMapFragment.H0(Function1.this, obj);
            }
        });
        MediatorLiveData<Rect> j8 = y0().j();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Rect, Unit> function12 = new Function1<Rect, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Rect rect) {
                DriverAppPlugin driverAppPlugin7;
                driverAppPlugin7 = WorkMapFragment.this.f30073x;
                if (driverAppPlugin7 == null) {
                    Intrinsics.w("mapController");
                    driverAppPlugin7 = null;
                }
                driverAppPlugin7.j(rect.top, rect.bottom);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                b(rect);
                return Unit.f50853a;
            }
        };
        j8.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkMapFragment.I0(Function1.this, obj);
            }
        });
        LiveData<List<NearbyDriver>> c02 = M().c0();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<List<? extends NearbyDriver>, Unit> function13 = new Function1<List<? extends NearbyDriver>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<NearbyDriver> it) {
                WorkMapFragment workMapFragment = WorkMapFragment.this;
                Intrinsics.e(it, "it");
                workMapFragment.v0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends NearbyDriver> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        c02.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkMapFragment.J0(Function1.this, obj);
            }
        });
        LiveData<DriverStatus> Y = M().Y();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<DriverStatus, Unit> function14 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus it) {
                WorkMapFragment workMapFragment = WorkMapFragment.this;
                Intrinsics.e(it, "it");
                workMapFragment.z0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Y.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkMapFragment.K0(Function1.this, obj);
            }
        });
        LiveData<ActiveAndPendingCampaignInfo> W = M().W();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<ActiveAndPendingCampaignInfo, Unit> function15 = new Function1<ActiveAndPendingCampaignInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ActiveAndPendingCampaignInfo it) {
                WorkMapFragment workMapFragment = WorkMapFragment.this;
                Intrinsics.e(it, "it");
                workMapFragment.p0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActiveAndPendingCampaignInfo activeAndPendingCampaignInfo) {
                b(activeAndPendingCampaignInfo);
                return Unit.f50853a;
            }
        };
        W.i(viewLifecycleOwner5, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkMapFragment.L0(Function1.this, obj);
            }
        });
        LiveData a8 = Transformations.a(M().Z());
        Intrinsics.e(a8, "distinctUntilChanged(this)");
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<FifoQueueMap, Unit> function16 = new Function1<FifoQueueMap, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(FifoQueueMap fifoQueueMap) {
                WorkMapFragment workMapFragment = WorkMapFragment.this;
                Intrinsics.e(fifoQueueMap, "fifoQueueMap");
                workMapFragment.r0(fifoQueueMap);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FifoQueueMap fifoQueueMap) {
                b(fifoQueueMap);
                return Unit.f50853a;
            }
        };
        a8.i(viewLifecycleOwner6, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkMapFragment.M0(Function1.this, obj);
            }
        });
        LiveData a9 = Transformations.a(M().a0());
        Intrinsics.e(a9, "distinctUntilChanged(this)");
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final Function1<Heatmap, Unit> function17 = new Function1<Heatmap, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$start$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Heatmap it) {
                WorkMapFragment workMapFragment = WorkMapFragment.this;
                Intrinsics.e(it, "it");
                workMapFragment.u0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Heatmap heatmap) {
                b(heatmap);
                return Unit.f50853a;
            }
        };
        a9.i(viewLifecycleOwner7, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkMapFragment.N0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final <T> T O0(T t7, Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        if (t7 == null) {
            return function0.invoke();
        }
        return function1.invoke(t7);
    }

    private final int n0() {
        int i8 = R.id.mapHolderWork;
        return Math.min(Math.max(Math.min(((MapContainer) Y(i8)).getWidth(), ((MapContainer) Y(i8)).getHeight()), (int) Spliterator.NONNULL), (int) Spliterator.IMMUTABLE);
    }

    private final void o0(final ActiveAndPendingCampaignInfo.GeoCampaign geoCampaign) {
        String b8;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        if (ContextUtilsKt.a(requireContext, R.attr.isLightTheme)) {
            b8 = geoCampaign.a().a();
        } else {
            b8 = geoCampaign.a().b();
        }
        String str = b8;
        View w02 = w0();
        int i8 = R.id.cc;
        ((AppCompatTextView) w02.findViewById(i8)).setText(geoCampaign.d());
        AppCompatTextView appCompatTextView = (AppCompatTextView) w0().findViewById(i8);
        Intrinsics.e(appCompatTextView, "campaignLabelView.title");
        ViewExtKt.e(appCompatTextView, false, 0, 3, null);
        ((AppCompatTextView) w0().findViewById(R.id.subTitle)).setText(geoCampaign.c());
        ImageManager b9 = ImageManager.Companion.b(ImageManager.f36075b, null, 1, null);
        ImageRequest imageRequest = new ImageRequest(str, new ImageSize(Dimens.c(24), Dimens.c(24)), null, null, 12, null);
        ImageView imageView = (ImageView) w0().findViewById(R.id.Q5);
        Intrinsics.e(imageView, "campaignLabelView.icon");
        b9.b(imageRequest, imageView, new ImageCallback<ImageView>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$createLabelView$1
            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: e */
            public void b(ImageView view, Drawable drawable, Exception exc) {
                Intrinsics.f(view, "view");
                Kalev.d("Failed to load campaign label icon " + exc);
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: f */
            public void d(ImageView view, Drawable drawable) {
                Intrinsics.f(view, "view");
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: g */
            public void a(ImageView view, Drawable drawable) {
                List list;
                DriverAppPlugin driverAppPlugin;
                View campaignLabelView;
                Intrinsics.f(view, "view");
                Intrinsics.f(drawable, "drawable");
                view.setImageDrawable(drawable);
                list = WorkMapFragment.this.F;
                driverAppPlugin = WorkMapFragment.this.f30073x;
                if (driverAppPlugin == null) {
                    Intrinsics.w("mapController");
                    driverAppPlugin = null;
                }
                campaignLabelView = WorkMapFragment.this.w0();
                Intrinsics.e(campaignLabelView, "campaignLabelView");
                list.add(driverAppPlugin.t(campaignLabelView, GeoUtils.f36938a.b(geoCampaign.b()), 0.0d, new PointF(0.5f, 1.0f)));
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: h */
            public void c(ImageView view, Drawable drawable) {
                Intrinsics.f(view, "view");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(ActiveAndPendingCampaignInfo activeAndPendingCampaignInfo) {
        DriverAppPlugin driverAppPlugin = this.f30073x;
        if (driverAppPlugin == null) {
            Intrinsics.w("mapController");
            driverAppPlugin = null;
        }
        for (Number number : this.E) {
            int intValue = number.intValue();
            DriverAppPlugin driverAppPlugin2 = this.f30073x;
            if (driverAppPlugin2 == null) {
                Intrinsics.w("mapController");
                driverAppPlugin2 = null;
            }
            driverAppPlugin2.m(intValue);
        }
        for (MarkerInfo markerInfo : this.F) {
            DriverAppPlugin driverAppPlugin3 = this.f30073x;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
                driverAppPlugin3 = null;
            }
            driverAppPlugin3.n(markerInfo.a());
        }
        this.F.clear();
        this.E.clear();
        List<ActiveAndPendingCampaignInfo.GeoCampaign> a8 = activeAndPendingCampaignInfo.a();
        if (a8 != null) {
            for (ActiveAndPendingCampaignInfo.GeoCampaign geoCampaign : a8) {
                List<Coordinates> b8 = geoCampaign.b();
                if (!b8.isEmpty()) {
                    this.E.add(Integer.valueOf(driverAppPlugin.l(b8, 8.0d, ContextCompat.getColor(requireContext(), R.color.purple300), ContextCompat.getColor(requireContext(), R.color.purple300Opacity30))));
                    o0(geoCampaign);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(final DriverAppPlugin driverAppPlugin, final DriverArea driverArea) {
        CircleInfo circleInfo = this.A;
        MarkerInfo markerInfo = this.B;
        this.f30075z = (MarkerInfo) O0(this.f30075z, new Function0<MarkerInfo>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawDriverArea$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final MarkerInfo invoke() {
                return DriverAppPlugin.this.p(R.drawable.car_driver, driverArea.c(), driverArea.a(), 10);
            }
        }, new Function1<MarkerInfo, MarkerInfo>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawDriverArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MarkerInfo invoke(MarkerInfo it) {
                Intrinsics.f(it, "it");
                return DriverAppPlugin.this.f(it.a(), driverArea.c(), driverArea.a(), 100L);
            }
        });
        if (driverArea.b() != null) {
            this.B = (MarkerInfo) O0(this.B, new Function0<MarkerInfo>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawDriverArea$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final MarkerInfo invoke() {
                    return DriverAppPlugin.this.i(R.drawable.marker_driver_destination, driverArea.b(), 0.0d, 9);
                }
            }, new Function1<MarkerInfo, MarkerInfo>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawDriverArea$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final MarkerInfo invoke(MarkerInfo it) {
                    Intrinsics.f(it, "it");
                    return DriverAppPlugin.this.f(it.a(), driverArea.b(), 0.0d, 0L);
                }
            });
            if (circleInfo != null) {
                driverAppPlugin.b(circleInfo.a());
            }
        } else if (markerInfo != null) {
            driverAppPlugin.n(markerInfo.a());
            this.B = null;
        }
        if (driverArea.d() != null) {
            this.A = (CircleInfo) O0(this.A, new Function0<CircleInfo>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawDriverArea$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final CircleInfo invoke() {
                    return DriverAppPlugin.this.g(driverArea.c(), driverArea.d().intValue(), 7.0d, Color.parseColor("#2fcc71"), Color.parseColor("#242FCC71"));
                }
            }, new Function1<CircleInfo, CircleInfo>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawDriverArea$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CircleInfo invoke(CircleInfo it) {
                    Intrinsics.f(it, "it");
                    return DriverAppPlugin.this.z(it.a(), driverArea.c(), driverArea.d().intValue());
                }
            });
        } else if (circleInfo != null) {
            driverAppPlugin.b(circleInfo.a());
            this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(FifoQueueMap fifoQueueMap) {
        String str;
        boolean z7;
        float f8;
        if (!this.f30072w.y()) {
            E0();
            D0();
            return;
        }
        TileCollectionConfig a8 = fifoQueueMap.a();
        DriverAppPlugin driverAppPlugin = null;
        if (a8 != null) {
            str = a8.c();
        } else {
            str = null;
        }
        if (str == null) {
            E0();
            D0();
            return;
        }
        t0(fifoQueueMap);
        s0(fifoQueueMap);
        boolean z8 = true;
        if (fifoQueueMap.c() == FifoQueueDispatchAreaState.OUTSIDE) {
            z7 = true;
        } else {
            z7 = false;
        }
        Integer num = this.G;
        float f9 = 1.0f;
        if (num != null) {
            int intValue = num.intValue();
            DriverAppPlugin driverAppPlugin2 = this.f30073x;
            if (driverAppPlugin2 == null) {
                Intrinsics.w("mapController");
                driverAppPlugin2 = null;
            }
            if (z7) {
                f8 = 1.0f;
            } else {
                f8 = 0.0f;
            }
            driverAppPlugin2.q(intValue, f8);
        }
        Integer num2 = this.H;
        if (num2 != null) {
            int intValue2 = num2.intValue();
            DriverAppPlugin driverAppPlugin3 = this.f30073x;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin3;
            }
            if (z7) {
                f9 = 0.0f;
            }
            driverAppPlugin.q(intValue2, f9);
        }
        FifoQueueTileLabelManager fifoQueueTileLabelManager = this.I;
        if (fifoQueueTileLabelManager != null) {
            if (fifoQueueMap.c() != null) {
                z8 = false;
            }
            fifoQueueTileLabelManager.i(z8);
        }
    }

    private final void s0(FifoQueueMap fifoQueueMap) {
        if (!Intrinsics.a(fifoQueueMap.a(), this.f30069t.e().a()) || !Intrinsics.a(fifoQueueMap.b(), this.f30069t.e().c())) {
            D0();
            this.f30069t.i(new FifoQueueTileState(n0(), M().b0(), fifoQueueMap.a(), fifoQueueMap.b()));
            DriverAppPlugin driverAppPlugin = this.f30073x;
            if (driverAppPlugin == null) {
                Intrinsics.w("mapController");
                driverAppPlugin = null;
            }
            this.H = Integer.valueOf(driverAppPlugin.s(this.f30069t, 1.0f));
        }
    }

    private final void t0(FifoQueueMap fifoQueueMap) {
        boolean z7;
        if (!Intrinsics.a(fifoQueueMap.a(), this.f30068s.e().a())) {
            E0();
            DriverAppPlugin driverAppPlugin = null;
            if (this.I == null) {
                MarkerParamsFactory markerParamsFactory = this.f30070u;
                DriverAppPlugin driverAppPlugin2 = this.f30073x;
                if (driverAppPlugin2 == null) {
                    Intrinsics.w("mapController");
                    driverAppPlugin2 = null;
                }
                HtmlEngine htmlEngine = this.f30071v;
                View requireView = requireView();
                Intrinsics.e(requireView, "requireView()");
                this.I = new FifoQueueTileLabelManager(markerParamsFactory, driverAppPlugin2, htmlEngine, requireView);
            }
            FifoQueueTileLabelManager fifoQueueTileLabelManager = this.I;
            if (fifoQueueTileLabelManager != null) {
                if (fifoQueueMap.c() == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                fifoQueueTileLabelManager.i(z7);
            }
            this.f30068s.h(new Function1<FifoQueueTileLabel, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawFifoQueueOverlay$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(FifoQueueTileLabel label) {
                    FifoQueueTileLabelManager fifoQueueTileLabelManager2;
                    Intrinsics.f(label, "label");
                    fifoQueueTileLabelManager2 = WorkMapFragment.this.I;
                    if (fifoQueueTileLabelManager2 != null) {
                        fifoQueueTileLabelManager2.b(label);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FifoQueueTileLabel fifoQueueTileLabel) {
                    b(fifoQueueTileLabel);
                    return Unit.f50853a;
                }
            });
            this.f30068s.i(new FifoQueueTileState(n0(), M().b0(), fifoQueueMap.a(), null, 8, null));
            DriverAppPlugin driverAppPlugin3 = this.f30073x;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin = driverAppPlugin3;
            }
            this.G = Integer.valueOf(driverAppPlugin.s(this.f30068s, 1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(Heatmap heatmap) {
        if (!(heatmap instanceof Heatmap.Tile)) {
            F0();
            return;
        }
        F0();
        Heatmap.Tile tile = (Heatmap.Tile) heatmap;
        final String a8 = tile.a();
        TileSource a9 = this.f30065p.a(new HeatmapTileSourceArgs(n0(), M().b0(), a8, tile.b()));
        DriverAppPlugin driverAppPlugin = this.f30073x;
        DriverAppPlugin driverAppPlugin2 = null;
        if (driverAppPlugin == null) {
            Intrinsics.w("mapController");
            driverAppPlugin = null;
        }
        this.K = Integer.valueOf(driverAppPlugin.s(a9, 0.0f));
        if (tile.b() != null) {
            TileSource a10 = this.f30066q.a(new WaitingTimeTileSourceArgs(M().b0(), a8, tile.b()), x0(), new Function1<MapTile<WaitingTimeMarker>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawHeatmap$markerTileSource$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
                    r0 = r2.f30092f.M;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void b(ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTile<ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarker> r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "tile"
                        kotlin.jvm.internal.Intrinsics.f(r3, r0)
                        ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment r0 = ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment.this
                        android.view.View r0 = r0.getView()
                        if (r0 != 0) goto Le
                        return
                    Le:
                        java.lang.String r0 = r2
                        java.lang.String r1 = r3.a()
                        boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
                        if (r0 != 0) goto L1b
                        return
                    L1b:
                        ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment r0 = ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment.this
                        ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerRenderer r0 = ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment.i0(r0)
                        if (r0 == 0) goto L26
                        r0.f(r3)
                    L26:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$drawHeatmap$markerTileSource$1.b(ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTile):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MapTile<WaitingTimeMarker> mapTile) {
                    b(mapTile);
                    return Unit.f50853a;
                }
            });
            DriverAppPlugin driverAppPlugin3 = this.f30073x;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin2 = driverAppPlugin3;
            }
            this.L = Integer.valueOf(driverAppPlugin2.s(a10, 0.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(List<NearbyDriver> list) {
        int v7;
        int i8;
        DriverAppPlugin driverAppPlugin;
        Iterator<T> it = this.C.iterator();
        while (true) {
            DriverAppPlugin driverAppPlugin2 = null;
            if (!it.hasNext()) {
                break;
            }
            MarkerInfo markerInfo = (MarkerInfo) it.next();
            DriverAppPlugin driverAppPlugin3 = this.f30073x;
            if (driverAppPlugin3 == null) {
                Intrinsics.w("mapController");
            } else {
                driverAppPlugin2 = driverAppPlugin3;
            }
            driverAppPlugin2.n(markerInfo.a());
        }
        this.C.clear();
        List<MarkerInfo> list2 = this.C;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (NearbyDriver nearbyDriver : list) {
            if (nearbyDriver.c()) {
                i8 = R.drawable.cars_same_fleet;
            } else {
                i8 = R.drawable.cars_everyone;
            }
            DriverAppPlugin driverAppPlugin4 = this.f30073x;
            if (driverAppPlugin4 == null) {
                Intrinsics.w("mapController");
                driverAppPlugin = null;
            } else {
                driverAppPlugin = driverAppPlugin4;
            }
            arrayList.add(driverAppPlugin.p(i8, nearbyDriver.b(), nearbyDriver.a(), 0));
        }
        list2.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View w0() {
        return (View) this.D.getValue();
    }

    private final Handler x0() {
        return (Handler) this.J.getValue();
    }

    private final MapPaddingViewModel y0() {
        return (MapPaddingViewModel) this.f30074y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(DriverStatus driverStatus) {
        if (DriverStatusKt.a(driverStatus)) {
            B0(0L, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: A0 */
    public WorkMapViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (WorkMapViewModel) new ViewModelProvider(this, E.d()).a(WorkMapViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.N.clear();
    }

    public View Y(int i8) {
        View findViewById;
        Map<Integer, View> map = this.N;
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
    public void onDestroyView() {
        super.onDestroyView();
        E0();
        D0();
        this.I = null;
        this.M = null;
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        M().V();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ((MapContainer) Y(R.id.mapHolderWork)).c(M().b0());
        getChildFragmentManager().beginTransaction().replace(R.id.f398mapHolderWork, this.f30064o.a(new Function1<MapController, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment$onViewCreated$fragment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapController it) {
                Intrinsics.f(it, "it");
                WorkMapFragment.this.G0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapController mapController) {
                b(mapController);
                return Unit.f50853a;
            }
        }), "map").commit();
    }
}
