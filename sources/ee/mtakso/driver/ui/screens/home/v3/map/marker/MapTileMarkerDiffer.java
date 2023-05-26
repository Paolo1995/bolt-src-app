package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: MapTileMarkerDiffer.kt */
/* loaded from: classes3.dex */
public final class MapTileMarkerDiffer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<MapTileMarker<T>, MarkerParams> f30271a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f30272b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f30273c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<State> f30274d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapTileMarkerDiffer.kt */
    /* loaded from: classes3.dex */
    public static final class StateWithDiff {

        /* renamed from: a  reason: collision with root package name */
        private final State f30279a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, RenderedMarkerDiff> f30280b;

        public StateWithDiff(State state, Map<String, RenderedMarkerDiff> diff) {
            Intrinsics.f(state, "state");
            Intrinsics.f(diff, "diff");
            this.f30279a = state;
            this.f30280b = diff;
        }

        public final Map<String, RenderedMarkerDiff> a() {
            return this.f30280b;
        }

        public final State b() {
            return this.f30279a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StateWithDiff) {
                StateWithDiff stateWithDiff = (StateWithDiff) obj;
                return Intrinsics.a(this.f30279a, stateWithDiff.f30279a) && Intrinsics.a(this.f30280b, stateWithDiff.f30280b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f30279a.hashCode() * 31) + this.f30280b.hashCode();
        }

        public String toString() {
            State state = this.f30279a;
            Map<String, RenderedMarkerDiff> map = this.f30280b;
            return "StateWithDiff(state=" + state + ", diff=" + map + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MapTileMarkerDiffer(Function1<? super MapTileMarker<T>, MarkerParams> renderer, Executor diffExecutor, Executor notificationExecutor) {
        Intrinsics.f(renderer, "renderer");
        Intrinsics.f(diffExecutor, "diffExecutor");
        Intrinsics.f(notificationExecutor, "notificationExecutor");
        this.f30271a = renderer;
        this.f30272b = diffExecutor;
        this.f30273c = notificationExecutor;
        this.f30274d = new AtomicReference<>(new State(0L, null, 0, null, 15, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RenderedMarker f(MapTileMarker<T> mapTileMarker) {
        Object b8;
        String a8 = mapTileMarker.a();
        Locatable c8 = mapTileMarker.c();
        T b9 = mapTileMarker.b();
        try {
            Result.Companion companion = Result.f50818g;
            b8 = Result.b(this.f30271a.invoke(mapTileMarker));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        Throwable e8 = Result.e(b8);
        if (e8 != null) {
            Kalev.e(e8, "Failed to render marker: " + mapTileMarker);
            Unit unit = Unit.f50853a;
        }
        if (Result.g(b8)) {
            b8 = null;
        }
        return new RenderedMarker(a8, c8, b9, (MarkerParams) b8);
    }

    private final void g(final Function1<? super MapTileDiff, Unit> function1, final Function1<? super State, StateWithDiff> function12) {
        this.f30272b.execute(new Runnable() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.a
            @Override // java.lang.Runnable
            public final void run() {
                MapTileMarkerDiffer.i(MapTileMarkerDiffer.this, function12, function1);
            }
        });
    }

    private final boolean h(State state, State state2) {
        if (!androidx.camera.view.e.a(this.f30274d, state, state2) && Intrinsics.a(this.f30274d.get().d(), state.d())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MapTileMarkerDiffer this$0, Function1 update, final Function1 diffReceiver) {
        State state;
        State b8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(update, "$update");
        Intrinsics.f(diffReceiver, "$diffReceiver");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        do {
            state = this$0.f30274d.get();
            Intrinsics.e(state, "state");
            StateWithDiff stateWithDiff = (StateWithDiff) update.invoke(state);
            b8 = stateWithDiff.b();
            ref$ObjectRef.f51016f = (T) stateWithDiff.a();
            if (b8 == state) {
                return;
            }
        } while (this$0.h(state, b8));
        if (((Map) ref$ObjectRef.f51016f).isEmpty()) {
            return;
        }
        this$0.f30273c.execute(new Runnable() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.b
            @Override // java.lang.Runnable
            public final void run() {
                MapTileMarkerDiffer.j(Function1.this, ref$ObjectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 diffReceiver, Ref$ObjectRef diff) {
        Intrinsics.f(diffReceiver, "$diffReceiver");
        Intrinsics.f(diff, "$diff");
        diffReceiver.invoke(new MapTileDiff((Map) diff.f51016f));
    }

    public final void d(final MapTile<T> tile, Function1<? super MapTileDiff, Unit> diffReceiver) {
        Intrinsics.f(tile, "tile");
        Intrinsics.f(diffReceiver, "diffReceiver");
        g(diffReceiver, new Function1<State, StateWithDiff>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer$addTile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0134 A[SYNTHETIC] */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer.StateWithDiff invoke(ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer.State r19) {
                /*
                    Method dump skipped, instructions count: 443
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer$addTile$1.invoke(ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer$State):ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer$StateWithDiff");
            }
        });
    }

    public final void e(Function1<? super MapTileDiff, Unit> diffReceiver) {
        Intrinsics.f(diffReceiver, "diffReceiver");
        g(diffReceiver, new Function1<State, StateWithDiff>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer$clear$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MapTileMarkerDiffer.StateWithDiff invoke(MapTileMarkerDiffer.State state) {
                int v7;
                int b8;
                int d8;
                Map f8;
                Intrinsics.f(state, "state");
                long e8 = state.e() + 1;
                Collection<RenderedMarkerHolder> values = state.c().values();
                ArrayList arrayList = new ArrayList();
                for (RenderedMarkerHolder renderedMarkerHolder : values) {
                    RenderedMarkerDiff a8 = RenderedMarkerDiff.f30299d.a(e8, renderedMarkerHolder.c(), null);
                    if (a8 != null) {
                        arrayList.add(a8);
                    }
                }
                v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
                b8 = MapsKt__MapsJVMKt.b(v7);
                d8 = RangesKt___RangesKt.d(b8, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(d8);
                for (Object obj : arrayList) {
                    linkedHashMap.put(((RenderedMarkerDiff) obj).b().a(), obj);
                }
                Object obj2 = new Object();
                f8 = MapsKt__MapsKt.f();
                return new MapTileMarkerDiffer.StateWithDiff(MapTileMarkerDiffer.State.b(state, e8, obj2, 0, f8, 4, null), linkedHashMap);
            }
        });
    }

    public final void k(final int i8, Function1<? super MapTileDiff, Unit> diffReceiver) {
        Intrinsics.f(diffReceiver, "diffReceiver");
        g(diffReceiver, new Function1<State, StateWithDiff>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarkerDiffer$zoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MapTileMarkerDiffer.StateWithDiff invoke(MapTileMarkerDiffer.State state) {
                int b8;
                Map f8;
                Intrinsics.f(state, "state");
                if (state.f() == i8) {
                    f8 = MapsKt__MapsKt.f();
                    return new MapTileMarkerDiffer.StateWithDiff(state, f8);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long e8 = state.e() + 1;
                Map<String, RenderedMarkerHolder> c8 = state.c();
                int i9 = i8;
                b8 = MapsKt__MapsJVMKt.b(c8.size());
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(b8);
                Iterator<T> it = c8.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object key = entry.getKey();
                    RenderedMarkerHolder renderedMarkerHolder = (RenderedMarkerHolder) entry.getValue();
                    RenderedMarkerHolder a8 = RenderedMarkerHolderKt.a(renderedMarkerHolder, i9);
                    RenderedMarkerDiff a9 = RenderedMarkerDiff.f30299d.a(e8, renderedMarkerHolder.c(), a8.c());
                    if (a9 != null) {
                        linkedHashMap.put(a8.d(), a9);
                    }
                    linkedHashMap2.put(key, a8);
                }
                return new MapTileMarkerDiffer.StateWithDiff(MapTileMarkerDiffer.State.b(state, e8, null, i8, linkedHashMap2, 2, null), linkedHashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapTileMarkerDiffer.kt */
    /* loaded from: classes3.dex */
    public static final class State {

        /* renamed from: a  reason: collision with root package name */
        private final long f30275a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f30276b;

        /* renamed from: c  reason: collision with root package name */
        private final int f30277c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, RenderedMarkerHolder> f30278d;

        public State() {
            this(0L, null, 0, null, 15, null);
        }

        public State(long j8, Object token, int i8, Map<String, RenderedMarkerHolder> markers) {
            Intrinsics.f(token, "token");
            Intrinsics.f(markers, "markers");
            this.f30275a = j8;
            this.f30276b = token;
            this.f30277c = i8;
            this.f30278d = markers;
        }

        public static /* synthetic */ State b(State state, long j8, Object obj, int i8, Map map, int i9, Object obj2) {
            if ((i9 & 1) != 0) {
                j8 = state.f30275a;
            }
            long j9 = j8;
            if ((i9 & 2) != 0) {
                obj = state.f30276b;
            }
            Object obj3 = obj;
            if ((i9 & 4) != 0) {
                i8 = state.f30277c;
            }
            int i10 = i8;
            Map<String, RenderedMarkerHolder> map2 = map;
            if ((i9 & 8) != 0) {
                map2 = state.f30278d;
            }
            return state.a(j9, obj3, i10, map2);
        }

        public final State a(long j8, Object token, int i8, Map<String, RenderedMarkerHolder> markers) {
            Intrinsics.f(token, "token");
            Intrinsics.f(markers, "markers");
            return new State(j8, token, i8, markers);
        }

        public final Map<String, RenderedMarkerHolder> c() {
            return this.f30278d;
        }

        public final Object d() {
            return this.f30276b;
        }

        public final long e() {
            return this.f30275a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof State) {
                State state = (State) obj;
                return this.f30275a == state.f30275a && Intrinsics.a(this.f30276b, state.f30276b) && this.f30277c == state.f30277c && Intrinsics.a(this.f30278d, state.f30278d);
            }
            return false;
        }

        public final int f() {
            return this.f30277c;
        }

        public int hashCode() {
            return (((((i0.a.a(this.f30275a) * 31) + this.f30276b.hashCode()) * 31) + this.f30277c) * 31) + this.f30278d.hashCode();
        }

        public String toString() {
            long j8 = this.f30275a;
            Object obj = this.f30276b;
            int i8 = this.f30277c;
            Map<String, RenderedMarkerHolder> map = this.f30278d;
            return "State(version=" + j8 + ", token=" + obj + ", zoom=" + i8 + ", markers=" + map + ")";
        }

        public /* synthetic */ State(long j8, Object obj, int i8, Map map, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this((i9 & 1) != 0 ? 0L : j8, (i9 & 2) != 0 ? new Object() : obj, (i9 & 4) != 0 ? 0 : i8, (i9 & 8) != 0 ? MapsKt__MapsKt.f() : map);
        }
    }
}
