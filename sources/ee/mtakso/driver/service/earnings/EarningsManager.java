package ee.mtakso.driver.service.earnings;

import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.earnings.network.EarningLandingScreen;
import eu.bolt.driver.earnings.network.EarningsClient;
import eu.bolt.driver.earnings.network.EarningsGoalClient;
import eu.bolt.driver.earnings.network.GetEarningsGoalResponse;
import eu.bolt.driver.earnings.network.SetEarningsGoalRequest;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsManager.kt */
/* loaded from: classes3.dex */
public final class EarningsManager {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsClient f24359a;

    /* renamed from: b  reason: collision with root package name */
    private final EarningsGoalClient f24360b;

    /* renamed from: c  reason: collision with root package name */
    private final PublishSubject<Unit> f24361c;

    @Inject
    public EarningsManager(EarningsClient earningsClient, EarningsGoalClient earningsGoalClient) {
        Intrinsics.f(earningsClient, "earningsClient");
        Intrinsics.f(earningsGoalClient, "earningsGoalClient");
        this.f24359a = earningsClient;
        this.f24360b = earningsGoalClient;
        PublishSubject<Unit> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f24361c = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(EarningsManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f24361c.onNext(Unit.f50853a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EarningsManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f24361c.onNext(Unit.f50853a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(EarningsManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f24361c.onNext(Unit.f50853a);
    }

    public final Completable f() {
        Completable n8 = CompletableExtKt.a(this.f24360b.b()).n(new Action() { // from class: e2.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                EarningsManager.g(EarningsManager.this);
            }
        });
        Intrinsics.e(n8, "earningsGoalClient.delet…nNext(Unit)\n            }");
        return n8;
    }

    public final Single<GetEarningsGoalResponse> h() {
        return SingleExtKt.d(this.f24360b.c());
    }

    public final Completable i() {
        Completable n8 = CompletableExtKt.a(this.f24360b.e()).n(new Action() { // from class: e2.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                EarningsManager.j(EarningsManager.this);
            }
        });
        Intrinsics.e(n8, "earningsGoalClient.keepD…nNext(Unit)\n            }");
        return n8;
    }

    public final Observable<EarningLandingScreen> k() {
        Observable R = SingleExtKt.d(this.f24359a.d()).R();
        final EarningsManager$observeEarnings$1 earningsManager$observeEarnings$1 = new EarningsManager$observeEarnings$1(this);
        Observable<EarningLandingScreen> repeatWhen = R.repeatWhen(new Function() { // from class: e2.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource l8;
                l8 = EarningsManager.l(Function1.this, obj);
                return l8;
            }
        });
        Intrinsics.e(repeatWhen, "fun observeEarnings(): O…chMap { subject } }\n    }");
        return repeatWhen;
    }

    public final Completable m(SetEarningsGoalRequest goal) {
        Intrinsics.f(goal, "goal");
        Completable n8 = CompletableExtKt.a(this.f24360b.f(goal)).n(new Action() { // from class: e2.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                EarningsManager.n(EarningsManager.this);
            }
        });
        Intrinsics.e(n8, "earningsGoalClient\n     …nNext(Unit)\n            }");
        return n8;
    }
}
