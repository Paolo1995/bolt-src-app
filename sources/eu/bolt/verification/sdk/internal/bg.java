package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.worker.Worker;
import eu.bolt.android.rib.worker.WorkerBinder;
import eu.bolt.android.rib.worker.WorkerGroup;
import eu.bolt.android.rib.worker.WorkerUnbinder;
import eu.bolt.android.rib.worker.scope.StartedActivityScopeWorkerGroup;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.b7;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class bg {

    /* renamed from: a  reason: collision with root package name */
    private final dl f42320a;

    /* renamed from: b  reason: collision with root package name */
    private final s f42321b;

    /* renamed from: c  reason: collision with root package name */
    private final CoActivityEvents f42322c;

    /* renamed from: d  reason: collision with root package name */
    private final RxActivityEvents f42323d;

    /* renamed from: e  reason: collision with root package name */
    private WorkerUnbinder f42324e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class a implements Worker {

        /* renamed from: a  reason: collision with root package name */
        private final BaseRibInteractor<?> f42325a;

        /* renamed from: b  reason: collision with root package name */
        private final Function0<u> f42326b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ bg f42327c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(bg bgVar, BaseRibInteractor<?> interactor, Function0<? extends u> eventFactory) {
            Intrinsics.f(interactor, "interactor");
            Intrinsics.f(eventFactory, "eventFactory");
            this.f42327c = bgVar;
            this.f42325a = interactor;
            this.f42326b = eventFactory;
        }

        @Override // eu.bolt.android.rib.worker.Worker
        public void onStart() {
            u invoke = this.f42326b.invoke();
            if (invoke != null) {
                this.f42327c.f42321b.b(invoke);
                return;
            }
            Logger c8 = ac.a.f42020b.c();
            String D = this.f42325a.D();
            c8.d("failed to resolve analytics screen event for " + D);
        }

        @Override // eu.bolt.android.rib.worker.Worker
        public void onStop() {
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function0<u> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ u f42328f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(u uVar) {
            super(0);
            this.f42328f = uVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final u invoke() {
            return this.f42328f;
        }
    }

    @Inject
    public bg(dl targetingManager, s analyticsManager, CoActivityEvents coActivityEvents, RxActivityEvents rxActivityEvents) {
        Intrinsics.f(targetingManager, "targetingManager");
        Intrinsics.f(analyticsManager, "analyticsManager");
        Intrinsics.f(coActivityEvents, "coActivityEvents");
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        this.f42320a = targetingManager;
        this.f42321b = analyticsManager;
        this.f42322c = coActivityEvents;
        this.f42323d = rxActivityEvents;
    }

    public final void b(BaseRibInteractor<?> interactor, u screen) {
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(screen, "screen");
        c(interactor, new b(screen));
    }

    public final void c(BaseRibInteractor<?> interactor, Function0<? extends u> factory) {
        Set<? extends Worker> a8;
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(factory, "factory");
        WorkerUnbinder workerUnbinder = this.f42324e;
        if (workerUnbinder != null) {
            workerUnbinder.a();
        }
        WorkerGroup.Companion companion = WorkerGroup.f37378a;
        a8 = SetsKt__SetsJVMKt.a(new a(this, interactor, factory));
        this.f42324e = WorkerBinder.f37350a.i(interactor, new StartedActivityScopeWorkerGroup(((Boolean) this.f42320a.a(b7.a.c.f42289b)).booleanValue(), this.f42323d, this.f42322c, companion.a(a8)));
    }

    public final void d(q event) {
        Intrinsics.f(event, "event");
        this.f42321b.a(event);
    }

    public final void e(u screen) {
        Intrinsics.f(screen, "screen");
        this.f42321b.b(screen);
    }
}
