package ee.mtakso.driver.ui.utils;

import ee.mtakso.driver.ui.utils.AnimationTimer;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationTimer.kt */
/* loaded from: classes5.dex */
public final class AnimationTimer {

    /* renamed from: e  reason: collision with root package name */
    private static final Companion f34295e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f34296a = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: b  reason: collision with root package name */
    private final PublishSubject<Unit> f34297b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f34298c;

    /* renamed from: d  reason: collision with root package name */
    private Future<?> f34299d;

    /* compiled from: AnimationTimer.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnimationTimer() {
        PublishSubject<Unit> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f34297b = e8;
        this.f34298c = new Runnable() { // from class: k5.a
            @Override // java.lang.Runnable
            public final void run() {
                AnimationTimer.e(AnimationTimer.this);
            }
        };
    }

    public static /* synthetic */ void d(AnimationTimer animationTimer, long j8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = 4;
        }
        animationTimer.c(j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AnimationTimer this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f34297b.onNext(Unit.f50853a);
    }

    public final Observable<Unit> b() {
        return ObservableExtKt.g(this.f34297b);
    }

    public final void c(long j8) {
        this.f34299d = this.f34296a.schedule(this.f34298c, j8, TimeUnit.SECONDS);
    }
}
