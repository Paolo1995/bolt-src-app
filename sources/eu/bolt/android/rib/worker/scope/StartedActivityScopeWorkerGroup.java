package eu.bolt.android.rib.worker.scope;

import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import eu.bolt.android.rib.rx.RxExtKt;
import eu.bolt.android.rib.worker.WorkerGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StartedActivityScopeWorkerGroup.kt */
/* loaded from: classes5.dex */
public final class StartedActivityScopeWorkerGroup extends BaseScopedWorkerGroup {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f37391e;

    /* renamed from: f  reason: collision with root package name */
    private final RxActivityEvents f37392f;

    /* renamed from: g  reason: collision with root package name */
    private final CoActivityEvents f37393g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedActivityScopeWorkerGroup(boolean z7, RxActivityEvents lifecycle, CoActivityEvents coroutinesLifecycle, WorkerGroup group) {
        super(group);
        Intrinsics.f(lifecycle, "lifecycle");
        Intrinsics.f(coroutinesLifecycle, "coroutinesLifecycle");
        Intrinsics.f(group, "group");
        this.f37391e = z7;
        this.f37392f = lifecycle;
        this.f37393g = coroutinesLifecycle;
    }

    @Override // eu.bolt.android.rib.worker.Worker
    public void onStart() {
        if (this.f37391e) {
            c(this.f37393g.u(), new StartedActivityScopeWorkerGroup$onStart$1(this, null));
            c(this.f37393g.p(), new StartedActivityScopeWorkerGroup$onStart$2(this, null));
            return;
        }
        a(RxExtKt.i(this.f37392f.o(), new Function1<ActivityLifecycleEvent, Unit>() { // from class: eu.bolt.android.rib.worker.scope.StartedActivityScopeWorkerGroup$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ActivityLifecycleEvent it) {
                Intrinsics.f(it, "it");
                StartedActivityScopeWorkerGroup.this.d();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
                b(activityLifecycleEvent);
                return Unit.f50853a;
            }
        }, null, null, null, null, 30, null));
        a(RxExtKt.i(this.f37392f.k(), new Function1<ActivityLifecycleEvent, Unit>() { // from class: eu.bolt.android.rib.worker.scope.StartedActivityScopeWorkerGroup$onStart$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ActivityLifecycleEvent it) {
                Intrinsics.f(it, "it");
                StartedActivityScopeWorkerGroup.this.b();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
                b(activityLifecycleEvent);
                return Unit.f50853a;
            }
        }, null, null, null, null, 30, null));
    }
}
