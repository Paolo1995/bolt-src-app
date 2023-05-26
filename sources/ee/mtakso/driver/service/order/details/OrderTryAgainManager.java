package ee.mtakso.driver.service.order.details;

import android.os.CountDownTimer;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderTryAgainManager.kt */
/* loaded from: classes3.dex */
public final class OrderTryAgainManager {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f25468c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f25469a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownTimer f25470b;

    /* compiled from: OrderTryAgainManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public OrderTryAgainManager() {
        BehaviorSubject<Boolean> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<Boolean>()");
        this.f25469a = e8;
        this.f25470b = new CountDownTimer() { // from class: ee.mtakso.driver.service.order.details.OrderTryAgainManager$timer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(15000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BehaviorSubject behaviorSubject;
                behaviorSubject = OrderTryAgainManager.this.f25469a;
                behaviorSubject.onNext(Boolean.TRUE);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j8) {
            }
        };
    }

    public final void b() {
        this.f25469a.onNext(Boolean.FALSE);
        this.f25470b.cancel();
    }

    public final Observable<Boolean> c() {
        return this.f25469a;
    }

    public final void d() {
        this.f25470b.start();
    }
}
