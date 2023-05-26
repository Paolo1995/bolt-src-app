package eu.bolt.android.rib;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.OneShotPreDrawListener;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import eu.bolt.android.rib.lifecycle.ActivityCallbackEvent;
import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import eu.bolt.logger.StaticLogger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.CompletableSubject;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.rx2.RxConvertKt;

/* compiled from: RibActivity.kt */
/* loaded from: classes5.dex */
public abstract class RibActivity extends AppCompatActivity implements RxActivityEvents, CoActivityEvents {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f37049k = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private static final CorrespondingEventsFunction<ActivityLifecycleEvent> f37050l = new CorrespondingEventsFunction() { // from class: eu.bolt.android.rib.f
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            ActivityLifecycleEvent U;
            U = RibActivity.U((ActivityLifecycleEvent) obj);
            return U;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final BehaviorRelay<ActivityLifecycleEvent> f37051f;

    /* renamed from: g  reason: collision with root package name */
    private final Relay<ActivityLifecycleEvent> f37052g;

    /* renamed from: h  reason: collision with root package name */
    private final Relay<ActivityCallbackEvent> f37053h;

    /* renamed from: i  reason: collision with root package name */
    private ViewRouter<?> f37054i;

    /* renamed from: j  reason: collision with root package name */
    private final CompletableSubject f37055j;

    /* compiled from: RibActivity.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RibActivity.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37056a;

        static {
            int[] iArr = new int[ActivityLifecycleEvent.Type.values().length];
            try {
                iArr[ActivityLifecycleEvent.Type.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActivityLifecycleEvent.Type.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActivityLifecycleEvent.Type.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ActivityLifecycleEvent.Type.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ActivityLifecycleEvent.Type.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ActivityLifecycleEvent.Type.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f37056a = iArr;
        }
    }

    public RibActivity() {
        BehaviorRelay<ActivityLifecycleEvent> e8 = BehaviorRelay.e();
        Intrinsics.e(e8, "create<ActivityLifecycleEvent>()");
        this.f37051f = e8;
        Relay<ActivityLifecycleEvent> c8 = e8.c();
        Intrinsics.e(c8, "lifecycleBehaviorRelay.toSerialized()");
        this.f37052g = c8;
        Relay c9 = PublishRelay.e().c();
        Intrinsics.e(c9, "create<ActivityCallbackE…)\n        .toSerialized()");
        this.f37053h = c9;
        CompletableSubject O = CompletableSubject.O();
        Intrinsics.e(O, "create()");
        this.f37055j = O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityLifecycleEvent U(ActivityLifecycleEvent activityLifecycleEvent) {
        ActivityLifecycleEvent.Type type;
        int i8;
        if (activityLifecycleEvent != null) {
            type = activityLifecycleEvent.d();
        } else {
            type = null;
        }
        if (type == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f37056a[type.ordinal()];
        }
        switch (i8) {
            case -1:
                throw new UnsupportedOperationException("Binding to " + activityLifecycleEvent + " not yet implemented");
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.DESTROY);
            case 2:
                return ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.STOP);
            case 3:
                return ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.PAUSE);
            case 4:
                return ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.STOP);
            case 5:
                return ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.DESTROY);
            case 6:
                throw new LifecycleEndedException("Cannot bind to Activity lifecycle when outside of it.");
        }
    }

    private final void W() {
        OneShotPreDrawListener.a(findViewById(16908290), new Runnable() { // from class: eu.bolt.android.rib.d
            @Override // java.lang.Runnable
            public final void run() {
                RibActivity.X(RibActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(RibActivity this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f37055j.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource Z(RibActivity this$0) {
        Intrinsics.f(this$0, "this$0");
        Observable<ActivityLifecycleEvent> f8 = this$0.f();
        final RibActivity$onPauseEvents$1$pauseEvents$1 ribActivity$onPauseEvents$1$pauseEvents$1 = new Function1<ActivityLifecycleEvent, Boolean>() { // from class: eu.bolt.android.rib.RibActivity$onPauseEvents$1$pauseEvents$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ActivityLifecycleEvent e8) {
                boolean z7;
                Intrinsics.f(e8, "e");
                if (e8.d() == ActivityLifecycleEvent.Type.PAUSE) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ActivityLifecycleEvent> filter = f8.filter(new Predicate() { // from class: eu.bolt.android.rib.g
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean a02;
                a02 = RibActivity.a0(Function1.this, obj);
                return a02;
            }
        });
        ActivityLifecycleEvent g02 = this$0.g0();
        if (g02 != null) {
            ActivityLifecycleEvent.Type d8 = g02.d();
            ActivityLifecycleEvent.Type type = ActivityLifecycleEvent.Type.DESTROY;
            if (d8 == type || g02.d() == ActivityLifecycleEvent.Type.STOP) {
                if (g02.d() == type) {
                    StaticLogger.f41686a.i("subscribing to onPauseEvents of a destroyed activity");
                }
                return filter.startWith((Observable<ActivityLifecycleEvent>) ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.PAUSE));
            }
            return filter;
        }
        return filter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource c0(RibActivity this$0) {
        ActivityLifecycleEvent.Type type;
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        Observable<ActivityLifecycleEvent> f8 = this$0.f();
        final RibActivity$onStartEvents$1$startEvents$1 ribActivity$onStartEvents$1$startEvents$1 = new Function1<ActivityLifecycleEvent, Boolean>() { // from class: eu.bolt.android.rib.RibActivity$onStartEvents$1$startEvents$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ActivityLifecycleEvent e8) {
                boolean z8;
                Intrinsics.f(e8, "e");
                if (e8.d() == ActivityLifecycleEvent.Type.START) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                return Boolean.valueOf(z8);
            }
        };
        Observable<ActivityLifecycleEvent> filter = f8.filter(new Predicate() { // from class: eu.bolt.android.rib.h
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean d02;
                d02 = RibActivity.d0(Function1.this, obj);
                return d02;
            }
        });
        ActivityLifecycleEvent g02 = this$0.g0();
        if (g02 != null) {
            type = g02.d();
        } else {
            type = null;
        }
        if (type != ActivityLifecycleEvent.Type.RESUME && type != ActivityLifecycleEvent.Type.PAUSE) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            return filter.startWith((Observable<ActivityLifecycleEvent>) ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.START));
        }
        return filter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource e0(RibActivity this$0) {
        Intrinsics.f(this$0, "this$0");
        Observable<ActivityLifecycleEvent> f8 = this$0.f();
        final RibActivity$onStopEvents$1$stopEvents$1 ribActivity$onStopEvents$1$stopEvents$1 = new Function1<ActivityLifecycleEvent, Boolean>() { // from class: eu.bolt.android.rib.RibActivity$onStopEvents$1$stopEvents$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ActivityLifecycleEvent e8) {
                boolean z7;
                Intrinsics.f(e8, "e");
                if (e8.d() == ActivityLifecycleEvent.Type.STOP) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ActivityLifecycleEvent> filter = f8.filter(new Predicate() { // from class: eu.bolt.android.rib.i
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean f02;
                f02 = RibActivity.f0(Function1.this, obj);
                return f02;
            }
        });
        ActivityLifecycleEvent g02 = this$0.g0();
        if (g02 != null && g02.d() == ActivityLifecycleEvent.Type.DESTROY) {
            StaticLogger.f41686a.i("subscribing to onStopEvents of a destroyed activity");
            return filter.startWith((Observable<ActivityLifecycleEvent>) ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.STOP));
        }
        return filter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    @Override // eu.bolt.android.rib.RxActivityEvents
    public Observable<ActivityLifecycleEvent> A() {
        Observable<ActivityLifecycleEvent> defer = Observable.defer(new Callable() { // from class: eu.bolt.android.rib.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource Z;
                Z = RibActivity.Z(RibActivity.this);
                return Z;
            }
        });
        Intrinsics.e(defer, "defer {\n        val paus…useEvents\n        }\n    }");
        return defer;
    }

    @Override // eu.bolt.android.rib.RxActivityEvents
    public Observable<ActivityLifecycleEvent> C() {
        Observable<ActivityLifecycleEvent> f8 = f();
        final RibActivity$onResumeEvents$1 ribActivity$onResumeEvents$1 = new Function1<ActivityLifecycleEvent, Boolean>() { // from class: eu.bolt.android.rib.RibActivity$onResumeEvents$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ActivityLifecycleEvent e8) {
                boolean z7;
                Intrinsics.f(e8, "e");
                if (e8.d() == ActivityLifecycleEvent.Type.RESUME) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ActivityLifecycleEvent> filter = f8.filter(new Predicate() { // from class: eu.bolt.android.rib.e
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean b02;
                b02 = RibActivity.b0(Function1.this, obj);
                return b02;
            }
        });
        Intrinsics.e(filter, "this.lifecycle()\n       …ecycleEvent.Type.RESUME }");
        return filter;
    }

    protected abstract ViewRouter<?> V(ViewGroup viewGroup);

    public final ViewRouter<?> Y() {
        return this.f37054i;
    }

    @Override // eu.bolt.android.rib.RxActivityEvents
    public Observable<ActivityLifecycleEvent> f() {
        Observable<ActivityLifecycleEvent> hide = this.f37052g.hide();
        Intrinsics.e(hide, "lifecycleRelay.hide()");
        return hide;
    }

    public ActivityLifecycleEvent g0() {
        return this.f37051f.g();
    }

    @Override // eu.bolt.android.rib.RxActivityEvents
    public Observable<ActivityLifecycleEvent> k() {
        Observable<ActivityLifecycleEvent> defer = Observable.defer(new Callable() { // from class: eu.bolt.android.rib.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource e02;
                e02 = RibActivity.e0(RibActivity.this);
                return e02;
            }
        });
        Intrinsics.e(defer, "defer {\n        val stop…topEvents\n        }\n    }");
        return defer;
    }

    @Override // eu.bolt.android.rib.RxActivityEvents
    public Observable<ActivityLifecycleEvent> o() {
        Observable<ActivityLifecycleEvent> defer = Observable.defer(new Callable() { // from class: eu.bolt.android.rib.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource c02;
                c02 = RibActivity.c0(RibActivity.this);
                return c02;
            }
        });
        Intrinsics.e(defer, "defer {\n        val star…artEvents\n        }\n    }");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        this.f37053h.accept(ActivityCallbackEvent.c(i8, i9, intent));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ViewRouter<?> viewRouter = this.f37054i;
        if (viewRouter != null && !viewRouter.s()) {
            StaticLogger.f41686a.b("RibActivity: onBackPressed");
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        StaticLogger.f41686a.b("RibActivity: onCreate");
        View findViewById = findViewById(16908290);
        Intrinsics.d(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.f37052g.accept(ActivityLifecycleEvent.c(bundle));
        this.f37054i = V(viewGroup);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = null;
        }
        ViewRouter<?> viewRouter = this.f37054i;
        if (viewRouter != null) {
            viewGroup.addView(viewRouter.A());
            RibExtensionsKt.a(viewRouter, bundle2);
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        StaticLogger.f41686a.b("RibActivity: onDestroy");
        this.f37052g.accept(ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.DESTROY));
        ViewRouter<?> viewRouter = this.f37054i;
        if (viewRouter != null) {
            viewRouter.j(true);
        }
        this.f37054i = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.f37055j.onComplete();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f37053h.accept(ActivityCallbackEvent.b(ActivityCallbackEvent.Type.LOW_MEMORY));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.f37052g.accept(ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.PAUSE));
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f37052g.accept(ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.RESUME));
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle outState) {
        Intrinsics.f(outState, "outState");
        super.onSaveInstanceState(outState);
        this.f37053h.accept(ActivityCallbackEvent.d(outState));
        ((ViewRouter) Preconditions.a(this.f37054i)).v(new Bundle(outState));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f37052g.accept(ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.START));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f37052g.accept(ActivityLifecycleEvent.b(ActivityLifecycleEvent.Type.STOP));
        super.onStop();
    }

    @Override // eu.bolt.android.rib.CoActivityEvents
    public Flow<ActivityLifecycleEvent> p() {
        return RxConvertKt.b(k());
    }

    @Override // eu.bolt.android.rib.RxActivityEvents
    public Observable<ActivityCallbackEvent> t() {
        Observable<ActivityCallbackEvent> hide = this.f37053h.hide();
        Intrinsics.e(hide, "callbacksRelay.hide()");
        return hide;
    }

    @Override // eu.bolt.android.rib.CoActivityEvents
    public Flow<ActivityLifecycleEvent> u() {
        return RxConvertKt.b(o());
    }
}
