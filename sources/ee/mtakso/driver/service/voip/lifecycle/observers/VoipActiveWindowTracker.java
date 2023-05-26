package ee.mtakso.driver.service.voip.lifecycle.observers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallFragment;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderActivity;
import ee.mtakso.voip_client.VoipCall;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.kalev.Kalev;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipActiveWindowTracker.kt */
@Singleton
/* loaded from: classes3.dex */
public final class VoipActiveWindowTracker extends SimpleVoipLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26151a;

    /* renamed from: b  reason: collision with root package name */
    private final RoutingManager f26152b;

    /* renamed from: c  reason: collision with root package name */
    private VoipCall f26153c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ExponentialBackoffTask f26154d;

    /* renamed from: e  reason: collision with root package name */
    private volatile int f26155e;

    /* renamed from: f  reason: collision with root package name */
    private final VoipActiveWindowTracker$lifecycleObserver$1 f26156f;

    /* JADX WARN: Type inference failed for: r2v1, types: [ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker$lifecycleObserver$1] */
    @Inject
    public VoipActiveWindowTracker(Context context, RoutingManager routingManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(routingManager, "routingManager");
        this.f26151a = context;
        this.f26152b = routingManager;
        this.f26156f = new LifecycleObserver() { // from class: ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker$lifecycleObserver$1
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public final void onCreate() {
                int i8;
                VoipActiveWindowTracker voipActiveWindowTracker = VoipActiveWindowTracker.this;
                i8 = voipActiveWindowTracker.f26155e;
                voipActiveWindowTracker.f26155e = i8 + 1;
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                int i8;
                VoipActiveWindowTracker voipActiveWindowTracker = VoipActiveWindowTracker.this;
                i8 = voipActiveWindowTracker.f26155e;
                voipActiveWindowTracker.f26155e = i8 - 1;
                VoipActiveWindowTracker.this.k();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(VoipCall voipCall) {
        Class<? extends Activity> cls;
        RoutingState f8 = this.f26152b.f();
        if (f8 != null) {
            cls = f8.a();
        } else {
            cls = null;
        }
        if (Intrinsics.a(cls, IncomingOrderActivity.class)) {
            return;
        }
        VoipCall.State state = voipCall.getState();
        VoipCall.Type type = voipCall.getType();
        VoipCall.State state2 = VoipCall.State.CREATED;
        if (state == state2 && type == VoipCall.Type.INCOMING) {
            Kalev.d("VoipActiveWindowTracker launch IncomingCallFragment");
            VoipFloatingActivity.Companion companion = VoipFloatingActivity.f27818p;
            Context context = this.f26151a;
            Intent intent = new Intent(context, VoipFloatingActivity.class);
            intent.putExtra("dialog_class_argument", IncomingCallFragment.class);
            intent.addFlags(268500992);
            context.startActivity(intent);
        } else if (state != VoipCall.State.ESTABLISHING && state != VoipCall.State.ESTABLISHED && (state != state2 || type != VoipCall.Type.OUTGOING)) {
            Kalev.d("No active call in active state");
        } else {
            VoipFloatingActivity.Companion companion2 = VoipFloatingActivity.f27818p;
            Context context2 = this.f26151a;
            Intent intent2 = new Intent(context2, VoipFloatingActivity.class);
            intent2.putExtra("dialog_class_argument", InprogressCallFragment.class);
            intent2.addFlags(268500992);
            context2.startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        final VoipCall voipCall = this.f26153c;
        if (this.f26155e <= 0 && voipCall != null) {
            this.f26154d = new ExponentialBackoffTask(new Function0<Boolean>() { // from class: ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker$restoreActivityWhenPossible$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final Boolean invoke() {
                    VoipActiveWindowTracker.this.i(voipCall);
                    return Boolean.FALSE;
                }
            }, 0, 2, null);
            ExponentialBackoffTask exponentialBackoffTask = this.f26154d;
            if (exponentialBackoffTask != null) {
                exponentialBackoffTask.e();
            }
        }
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        this.f26153c = null;
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void d(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26153c = call;
    }

    public final void j(AppCompatActivity activity) {
        Intrinsics.f(activity, "activity");
        activity.getLifecycle().c(this.f26156f);
    }

    public final void l(AppCompatActivity activity) {
        Intrinsics.f(activity, "activity");
        activity.getLifecycle().a(this.f26156f);
        ExponentialBackoffTask exponentialBackoffTask = this.f26154d;
        if (exponentialBackoffTask != null) {
            exponentialBackoffTask.b();
        }
    }

    /* compiled from: VoipActiveWindowTracker.kt */
    /* loaded from: classes3.dex */
    public static final class ExponentialBackoffTask {

        /* renamed from: a  reason: collision with root package name */
        private final Function0<Boolean> f26157a;

        /* renamed from: b  reason: collision with root package name */
        private final int f26158b;

        /* renamed from: c  reason: collision with root package name */
        private final ScheduledExecutorService f26159c;

        /* renamed from: d  reason: collision with root package name */
        private ScheduledFuture<?> f26160d;

        public ExponentialBackoffTask(Function0<Boolean> predicate, int i8) {
            Intrinsics.f(predicate, "predicate");
            this.f26157a = predicate;
            this.f26158b = i8;
            this.f26159c = Executors.newScheduledThreadPool(1);
        }

        private final void c(final Function0<Boolean> function0, final int i8) {
            if (i8 >= this.f26158b) {
                return;
            }
            this.f26160d = this.f26159c.schedule(new Runnable() { // from class: j2.a
                @Override // java.lang.Runnable
                public final void run() {
                    VoipActiveWindowTracker.ExponentialBackoffTask.d(Function0.this, this, i8);
                }
            }, f(i8), TimeUnit.SECONDS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function0 predicate, ExponentialBackoffTask this$0, int i8) {
            Intrinsics.f(predicate, "$predicate");
            Intrinsics.f(this$0, "this$0");
            if (!((Boolean) predicate.invoke()).booleanValue()) {
                this$0.c(predicate, i8 + 1);
            }
        }

        private final long f(int i8) {
            return (long) Math.pow(2.0d, i8);
        }

        public final void b() {
            ScheduledFuture<?> scheduledFuture = this.f26160d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.f26160d = null;
        }

        public final void e() {
            c(this.f26157a, 0);
        }

        public /* synthetic */ ExponentialBackoffTask(Function0 function0, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i9 & 2) != 0 ? 5 : i8);
        }
    }
}
