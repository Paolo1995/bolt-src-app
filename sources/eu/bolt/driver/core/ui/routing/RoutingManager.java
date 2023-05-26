package eu.bolt.driver.core.ui.routing;

import eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand;
import eu.bolt.driver.core.ui.routing.internal.ReverseIntegerComparator;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.driver.core.ui.routing.state.StateHolder;
import eu.bolt.driver.core.util.AssertUtils;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: RoutingManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class RoutingManager {

    /* renamed from: b  reason: collision with root package name */
    private RoutingState f41157b;

    /* renamed from: a  reason: collision with root package name */
    private final StateHolder f41156a = new StateHolder();

    /* renamed from: c  reason: collision with root package name */
    private final TreeMap<Integer, Set<Coordinator>> f41158c = new TreeMap<>(new ReverseIntegerComparator());

    private final void a(eu.bolt.driver.core.ui.routing.command.RoutingCommand routingCommand) {
        List<Coordinator> H0;
        int v7;
        Collection<Set<Coordinator>> values = this.f41158c.values();
        Intrinsics.e(values, "coordinators.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Set bucket = (Set) it.next();
            Intrinsics.e(bucket, "bucket");
            H0 = CollectionsKt___CollectionsKt.H0(bucket);
            v7 = CollectionsKt__IterablesKt.v(H0, 10);
            ArrayList<Boolean> arrayList = new ArrayList(v7);
            for (Coordinator coordinator : H0) {
                arrayList.add(Boolean.valueOf(coordinator.b(routingCommand)));
            }
            int i8 = 0;
            if (!arrayList.isEmpty()) {
                for (Boolean bool : arrayList) {
                    if (bool.booleanValue() && (i8 = i8 + 1) < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                }
            }
            if (i8 > 1) {
                Kalev.e(new IllegalStateException(i8 + " coordinators processed command: " + routingCommand), "Routing error");
                continue;
            }
            if (i8 == 1) {
                return;
            }
        }
        Kalev.e(new IllegalStateException("No coordinator found for " + routingCommand), "Routing error");
    }

    public static /* synthetic */ void d(RoutingManager routingManager, RoutingCommand routingCommand, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        routingManager.b(routingCommand, z7);
    }

    private final boolean i(eu.bolt.driver.core.ui.routing.command.RoutingCommand routingCommand) {
        if (!(routingCommand instanceof BackpressureRoutingCommand)) {
            this.f41156a.c(null);
            return true;
        }
        BackpressureRoutingCommand backpressureRoutingCommand = (BackpressureRoutingCommand) routingCommand;
        if (!Intrinsics.a(this.f41157b, backpressureRoutingCommand.a())) {
            this.f41156a.c(backpressureRoutingCommand.a());
            return true;
        }
        return false;
    }

    public final void b(RoutingCommand command, boolean z7) {
        List<Coordinator> H0;
        int v7;
        Intrinsics.f(command, "command");
        if (!z7 && !this.f41156a.c(command.b())) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.a(g8, "Expected state reached. Command will not be executed", null, 2, null);
                return;
            }
            return;
        }
        Collection<Set<Coordinator>> values = this.f41158c.values();
        Intrinsics.e(values, "coordinators.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Set bucket = (Set) it.next();
            Intrinsics.e(bucket, "bucket");
            H0 = CollectionsKt___CollectionsKt.H0(bucket);
            v7 = CollectionsKt__IterablesKt.v(H0, 10);
            ArrayList<Boolean> arrayList = new ArrayList(v7);
            for (Coordinator coordinator : H0) {
                arrayList.add(Boolean.valueOf(coordinator.b(command)));
            }
            int i8 = 0;
            if (!arrayList.isEmpty()) {
                for (Boolean bool : arrayList) {
                    if (bool.booleanValue() && (i8 = i8 + 1) < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                }
            }
            if (i8 > 1) {
                Kalev.e(new IllegalStateException(i8 + " coordinators processed command: " + command), "Routing error");
                continue;
            }
            if (i8 == 1) {
                return;
            }
        }
    }

    public final void c(eu.bolt.driver.core.ui.routing.command.RoutingCommand command) {
        Intrinsics.f(command, "command");
        AssertUtils.f41299a.c("State should be updated from main thread");
        Kalev.b("Got command " + command);
        if (command instanceof RoutingCommand) {
            d(this, (RoutingCommand) command, false, 2, null);
        } else if (!i(command)) {
            RoutingState routingState = this.f41157b;
            Kalev.b("Command " + command + " will be skipped. Current routing state: " + routingState);
        } else {
            a(command);
        }
    }

    public final void e(RoutingState state) {
        Intrinsics.f(state, "state");
        Kalev.b("New state detected: " + state);
        this.f41156a.b(state);
        this.f41157b = state;
    }

    public final RoutingState f() {
        return this.f41156a.a();
    }

    public final boolean g(int i8, Coordinator coordinator) {
        Intrinsics.f(coordinator, "coordinator");
        TreeMap<Integer, Set<Coordinator>> treeMap = this.f41158c;
        Integer valueOf = Integer.valueOf(i8);
        Set<Coordinator> set = treeMap.get(valueOf);
        if (set == null) {
            set = new LinkedHashSet<>();
            treeMap.put(valueOf, set);
        }
        return set.add(coordinator);
    }

    public final boolean h(int i8, Object coordinator) {
        Intrinsics.f(coordinator, "coordinator");
        Set<Coordinator> set = this.f41158c.get(Integer.valueOf(i8));
        if (set != null) {
            return TypeIntrinsics.a(set).remove(coordinator);
        }
        return false;
    }
}
