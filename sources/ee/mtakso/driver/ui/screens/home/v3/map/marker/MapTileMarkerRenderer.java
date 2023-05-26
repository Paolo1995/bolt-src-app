package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import android.os.Handler;
import android.os.Looper;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.RenderedMarkerDiff;
import eu.bolt.android.maps.core.plugin.driver.DriverAppPlugin;
import eu.bolt.android.maps.core.plugin.driver.MarkerInfo;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapTileMarkerRenderer.kt */
/* loaded from: classes3.dex */
public final class MapTileMarkerRenderer<T> {

    /* renamed from: f */
    private static final Companion f30285f = new Companion(null);

    /* renamed from: a */
    private final DriverAppPlugin f30286a;

    /* renamed from: b */
    private final Handler f30287b;

    /* renamed from: c */
    private final Map<String, RenderedMarkerDiff> f30288c;

    /* renamed from: d */
    private final Map<String, MarkerInfo> f30289d;

    /* renamed from: e */
    private final MapTileMarkerDiffer<T> f30290e;

    /* compiled from: MapTileMarkerRenderer.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MapTileMarkerRenderer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a */
        public static final /* synthetic */ int[] f30291a;

        static {
            int[] iArr = new int[RenderedMarkerDiff.Change.values().length];
            try {
                iArr[RenderedMarkerDiff.Change.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderedMarkerDiff.Change.UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenderedMarkerDiff.Change.DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f30291a = iArr;
        }
    }

    public MapTileMarkerRenderer(Function1<? super MapTileMarker<T>, MarkerParams> renderer, DriverAppPlugin mapController) {
        Intrinsics.f(renderer, "renderer");
        Intrinsics.f(mapController, "mapController");
        this.f30286a = mapController;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f30287b = handler;
        this.f30288c = new LinkedHashMap();
        this.f30289d = new LinkedHashMap();
        this.f30290e = new MapTileMarkerDiffer<>(renderer, new Executor() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.c
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                MapTileMarkerRenderer.h(runnable);
            }
        }, new Executor() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.d
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        });
    }

    private final void e(RenderedMarker renderedMarker) {
        j(renderedMarker);
        if (renderedMarker.b() != null) {
            this.f30289d.put(renderedMarker.a(), this.f30286a.h(renderedMarker.b()));
        }
    }

    public static final void h(Runnable runnable) {
        Schedulers.a().d(runnable);
    }

    private final void j(RenderedMarker renderedMarker) {
        MarkerInfo remove = this.f30289d.remove(renderedMarker.a());
        if (remove != null) {
            this.f30286a.n(remove.a());
        }
    }

    public final void k(MapTileDiff mapTileDiff) {
        long j8;
        for (RenderedMarkerDiff renderedMarkerDiff : mapTileDiff.a().values()) {
            String a8 = renderedMarkerDiff.b().a();
            RenderedMarkerDiff renderedMarkerDiff2 = this.f30288c.get(a8);
            if (renderedMarkerDiff2 != null) {
                j8 = renderedMarkerDiff2.c();
            } else {
                j8 = -1;
            }
            if (j8 < renderedMarkerDiff.c()) {
                this.f30288c.put(a8, renderedMarkerDiff);
            }
        }
        this.f30287b.removeCallbacks(new e(this));
        this.f30287b.post(new e(this));
    }

    public final void l() {
        Object X;
        RenderedMarkerDiff remove;
        long nanoTime = System.nanoTime();
        do {
            X = CollectionsKt___CollectionsKt.X(this.f30288c.keySet());
            String str = (String) X;
            if (str == null || (remove = this.f30288c.remove(str)) == null) {
                return;
            }
            int i8 = WhenMappings.f30291a[remove.a().ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        j(remove.b());
                    }
                } else {
                    e(remove.b());
                }
            } else {
                e(remove.b());
            }
            if (!(!this.f30288c.isEmpty())) {
                break;
            }
        } while (System.nanoTime() - nanoTime < 8000000);
        this.f30287b.post(new e(this));
    }

    public final void f(MapTile<T> tile) {
        Intrinsics.f(tile, "tile");
        this.f30290e.d(tile, new Function1<MapTileDiff, Unit>(this) { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerRenderer$addTile$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ MapTileMarkerRenderer<T> f30292f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f30292f = this;
            }

            public final void b(MapTileDiff diff) {
                Intrinsics.f(diff, "diff");
                this.f30292f.k(diff);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapTileDiff mapTileDiff) {
                b(mapTileDiff);
                return Unit.f50853a;
            }
        });
    }

    public final void g() {
        this.f30290e.e(new Function1<MapTileDiff, Unit>(this) { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerRenderer$clear$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ MapTileMarkerRenderer<T> f30293f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f30293f = this;
            }

            public final void b(MapTileDiff diff) {
                Intrinsics.f(diff, "diff");
                this.f30293f.k(diff);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapTileDiff mapTileDiff) {
                b(mapTileDiff);
                return Unit.f50853a;
            }
        });
    }

    public final void m(int i8) {
        this.f30290e.k(i8, new Function1<MapTileDiff, Unit>(this) { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerRenderer$zoom$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ MapTileMarkerRenderer<T> f30294f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f30294f = this;
            }

            public final void b(MapTileDiff diff) {
                Intrinsics.f(diff, "diff");
                this.f30294f.k(diff);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapTileDiff mapTileDiff) {
                b(mapTileDiff);
                return Unit.f50853a;
            }
        });
    }
}
