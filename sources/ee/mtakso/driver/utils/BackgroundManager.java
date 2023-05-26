package ee.mtakso.driver.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackgroundManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class BackgroundManager implements LifecycleObserver {

    /* renamed from: f  reason: collision with root package name */
    private final NotRespondReporter f36281f;

    /* renamed from: g  reason: collision with root package name */
    private final Timer f36282g;

    /* renamed from: h  reason: collision with root package name */
    private TimerTask f36283h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36284i;

    /* renamed from: j  reason: collision with root package name */
    private final BehaviorSubject<AppForegroundState> f36285j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicReference<AppForegroundState> f36286k;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicBoolean f36287l;

    /* compiled from: BackgroundManager.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36288a;

        static {
            int[] iArr = new int[AppForegroundState.values().length];
            try {
                iArr[AppForegroundState.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f36288a = iArr;
        }
    }

    @Inject
    public BackgroundManager(NotRespondReporter notRespondReporter) {
        Intrinsics.f(notRespondReporter, "notRespondReporter");
        this.f36281f = notRespondReporter;
        this.f36282g = new Timer();
        BehaviorSubject<AppForegroundState> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<AppForegroundState>()");
        this.f36285j = e8;
        AtomicReference<AppForegroundState> atomicReference = new AtomicReference<>(AppForegroundState.BACKGROUND);
        this.f36286k = atomicReference;
        this.f36287l = new AtomicBoolean(false);
        ProcessLifecycleOwner.h().getLifecycle().a(this);
        e8.onNext(atomicReference.get());
        AppForegroundState appForegroundState = atomicReference.get();
        Intrinsics.e(appForegroundState, "currentAppForegroundState.get()");
        notRespondReporter.h(appForegroundState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(AppForegroundState appForegroundState) {
        this.f36286k.set(appForegroundState);
        Kalev.b("App visibility changed: foregroundStatus = " + appForegroundState);
        this.f36285j.onNext(this.f36286k.get());
        NotRespondReporter notRespondReporter = this.f36281f;
        AppForegroundState appForegroundState2 = this.f36286k.get();
        Intrinsics.e(appForegroundState2, "currentAppForegroundState.get()");
        notRespondReporter.h(appForegroundState2);
    }

    public final AppForegroundState d() {
        return this.f36286k.get();
    }

    public final boolean e() {
        return this.f36284i;
    }

    public final boolean f() {
        int i8;
        AppForegroundState appForegroundState = this.f36286k.get();
        if (appForegroundState == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f36288a[appForegroundState.ordinal()];
        }
        if (i8 == 1) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (this.f36287l.get() || this.f36286k.get() == AppForegroundState.BACKGROUND) {
            return true;
        }
        return false;
    }

    public final Observable<AppForegroundState> h() {
        return this.f36285j;
    }

    public final void j(boolean z7) {
        this.f36284i = z7;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onBackground() {
        Kalev.h("Application goes to background");
        this.f36287l.set(true);
        j(false);
        TimerTask timerTask = new TimerTask() { // from class: ee.mtakso.driver.utils.BackgroundManager$onBackground$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AtomicBoolean atomicBoolean;
                Kalev.h("Application goes to background - confirmed");
                atomicBoolean = BackgroundManager.this.f36287l;
                atomicBoolean.set(false);
                BackgroundManager.this.i(AppForegroundState.BACKGROUND);
            }
        };
        this.f36283h = timerTask;
        this.f36282g.schedule(timerTask, 2000L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onForeground() {
        Kalev.h("Application goes to foreground");
        this.f36287l.set(false);
        TimerTask timerTask = this.f36283h;
        if (timerTask != null) {
            timerTask.cancel();
        }
        i(AppForegroundState.FOREGROUND);
    }
}
