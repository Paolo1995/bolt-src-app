package ee.mtakso.driver.service.campaign;

import ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns;
import ee.mtakso.driver.network.client.campaign.ActiveAndPendingCampaignInfo;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.OptInChoiceV2;
import ee.mtakso.driver.network.client.campaign.OptInChoicesV2;
import ee.mtakso.driver.network.client.campaign.OptInGroupV2;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.util.Optional;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignManager.kt */
/* loaded from: classes3.dex */
public final class CampaignManager {

    /* renamed from: a  reason: collision with root package name */
    private final CampaignClient f23955a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishSubject<Unit> f23956b;

    /* renamed from: c  reason: collision with root package name */
    private volatile List<OptInGroupV2> f23957c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishSubject<ActiveAndFutureCampaigns> f23958d;

    /* renamed from: e  reason: collision with root package name */
    private final BehaviorSubject<Integer> f23959e;

    /* renamed from: f  reason: collision with root package name */
    private final BehaviorSubject<Notification<ActiveAndPendingCampaignInfo>> f23960f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f23961g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f23962h;

    @Inject
    public CampaignManager(CampaignClient campaignClient) {
        Intrinsics.f(campaignClient, "campaignClient");
        this.f23955a = campaignClient;
        PublishSubject<Unit> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f23956b = e8;
        PublishSubject<ActiveAndFutureCampaigns> e9 = PublishSubject.e();
        Intrinsics.e(e9, "create()");
        this.f23958d = e9;
        BehaviorSubject<Integer> e10 = BehaviorSubject.e();
        Intrinsics.e(e10, "create()");
        this.f23959e = e10;
        BehaviorSubject<Notification<ActiveAndPendingCampaignInfo>> e11 = BehaviorSubject.e();
        Intrinsics.e(e11, "create()");
        this.f23960f = e11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void E() {
        Single d8 = SingleExtKt.d(this.f23955a.k());
        final Function1<ActiveAndFutureCampaigns, Unit> function1 = new Function1<ActiveAndFutureCampaigns, Unit>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$loadActiveCampaigns$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ActiveAndFutureCampaigns activeAndFutureCampaigns) {
                PublishSubject publishSubject;
                publishSubject = CampaignManager.this.f23958d;
                publishSubject.onNext(activeAndFutureCampaigns);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActiveAndFutureCampaigns activeAndFutureCampaigns) {
                b(activeAndFutureCampaigns);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.campaign.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignManager.F(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$loadActiveCampaigns$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                PublishSubject publishSubject;
                publishSubject = CampaignManager.this.f23958d;
                publishSubject.onError(th);
            }
        };
        this.f23961g = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.campaign.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignManager.G(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H() {
        Single d8 = SingleExtKt.d(this.f23955a.m());
        final Function1<ActiveAndPendingCampaignInfo, Unit> function1 = new Function1<ActiveAndPendingCampaignInfo, Unit>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$loadActiveCampaignsInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ActiveAndPendingCampaignInfo activeAndPendingCampaignInfo) {
                BehaviorSubject behaviorSubject;
                BehaviorSubject behaviorSubject2;
                behaviorSubject = CampaignManager.this.f23960f;
                behaviorSubject.onNext(Notification.c(activeAndPendingCampaignInfo));
                behaviorSubject2 = CampaignManager.this.f23959e;
                behaviorSubject2.onNext(Integer.valueOf(activeAndPendingCampaignInfo.b()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActiveAndPendingCampaignInfo activeAndPendingCampaignInfo) {
                b(activeAndPendingCampaignInfo);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.campaign.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignManager.J(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$loadActiveCampaignsInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BehaviorSubject behaviorSubject;
                BehaviorSubject behaviorSubject2;
                behaviorSubject = CampaignManager.this.f23960f;
                behaviorSubject.onNext(Notification.b(th));
                behaviorSubject2 = CampaignManager.this.f23959e;
                behaviorSubject2.onNext(0);
            }
        };
        this.f23962h = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.campaign.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignManager.I(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource x(CampaignManager this$0) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        List<OptInGroupV2> list = this$0.f23957c;
        if (list != null && !list.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            return this$0.B();
        }
        Single w7 = Single.w(list);
        Intrinsics.e(w7, "{\n                    Si…Groups)\n                }");
        return w7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Single<List<OptInGroupV2>> B() {
        Single<OptInChoicesV2> t7 = this.f23955a.t();
        final CampaignManager$getOptInGroupsV2$1 campaignManager$getOptInGroupsV2$1 = new Function1<OptInChoicesV2, List<? extends OptInGroupV2>>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$getOptInGroupsV2$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<OptInGroupV2> invoke(OptInChoicesV2 it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<R> x7 = t7.x(new Function() { // from class: ee.mtakso.driver.service.campaign.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List C;
                C = CampaignManager.C(Function1.this, obj);
                return C;
            }
        });
        final Function1<List<? extends OptInGroupV2>, Unit> function1 = new Function1<List<? extends OptInGroupV2>, Unit>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$getOptInGroupsV2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<OptInGroupV2> list) {
                CampaignManager.this.f23957c = list;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends OptInGroupV2> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Single<List<OptInGroupV2>> o8 = x7.o(new Consumer() { // from class: ee.mtakso.driver.service.campaign.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignManager.D(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun getOptInGroupsV2(): …ptInGroupsV2 = it }\n    }");
        return o8;
    }

    public final Observable<Notification<ActiveAndPendingCampaignInfo>> K() {
        return this.f23960f;
    }

    public final Observable<Unit> L() {
        return this.f23956b;
    }

    public final Single<Boolean> q(long j8, long j9) {
        Single<EmptyServerResponse> h8 = this.f23955a.h(j8, j9);
        final CampaignManager$activateOptInCampaign$1 campaignManager$activateOptInCampaign$1 = new Function1<EmptyServerResponse, Boolean>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$activateOptInCampaign$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(EmptyServerResponse it) {
                Intrinsics.f(it, "it");
                return Boolean.TRUE;
            }
        };
        Single<R> x7 = h8.x(new Function() { // from class: ee.mtakso.driver.service.campaign.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean r7;
                r7 = CampaignManager.r(Function1.this, obj);
                return r7;
            }
        });
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$activateOptInCampaign$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                PublishSubject publishSubject;
                publishSubject = CampaignManager.this.f23956b;
                publishSubject.onNext(Unit.f50853a);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Single<Boolean> o8 = x7.o(new Consumer() { // from class: ee.mtakso.driver.service.campaign.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignManager.s(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun activateOptInCampaig…Unit)\n            }\n    }");
        return o8;
    }

    public final Single<ActiveAndFutureCampaigns> t() {
        if (DisposableExtKt.b(this.f23961g)) {
            E();
        }
        Single<ActiveAndFutureCampaigns> firstOrError = this.f23958d.firstOrError();
        Intrinsics.e(firstOrError, "activeCampaignsSubject.firstOrError()");
        return firstOrError;
    }

    public final Single<Integer> u() {
        if (!this.f23959e.h()) {
            v();
        }
        Single<Integer> firstOrError = this.f23959e.firstOrError();
        Intrinsics.e(firstOrError, "activeCampaignsCountSubject.firstOrError()");
        return firstOrError;
    }

    public final Single<Notification<ActiveAndPendingCampaignInfo>> v() {
        if (DisposableExtKt.b(this.f23962h)) {
            H();
        }
        Single<Notification<ActiveAndPendingCampaignInfo>> firstOrError = this.f23960f.firstOrError();
        Intrinsics.e(firstOrError, "activeCampaignsInfoSubject.firstOrError()");
        return firstOrError;
    }

    public final Single<Optional<OptInChoiceV2>> w(final long j8, final long j9) {
        Single g8 = Single.g(new Callable() { // from class: ee.mtakso.driver.service.campaign.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SingleSource x7;
                x7 = CampaignManager.x(CampaignManager.this);
                return x7;
            }
        });
        final Function1<List<? extends OptInGroupV2>, Optional<OptInChoiceV2>> function1 = new Function1<List<? extends OptInGroupV2>, Optional<OptInChoiceV2>>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$getOptInChoiceV2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OptInChoiceV2> invoke(List<OptInGroupV2> groups) {
                OptInChoiceV2 optInChoiceV2;
                Object obj;
                List<OptInChoiceV2> a8;
                boolean z7;
                boolean z8;
                Intrinsics.f(groups, "groups");
                long j10 = j8;
                Iterator<T> it = groups.iterator();
                while (true) {
                    optInChoiceV2 = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((OptInGroupV2) obj).getId() == j10) {
                            z8 = true;
                            continue;
                        } else {
                            z8 = false;
                            continue;
                        }
                        if (z8) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                OptInGroupV2 optInGroupV2 = (OptInGroupV2) obj;
                if (optInGroupV2 != null && (a8 = optInGroupV2.a()) != null) {
                    long j11 = j9;
                    Iterator<T> it2 = a8.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (((OptInChoiceV2) next).getId() == j11) {
                            z7 = true;
                            continue;
                        } else {
                            z7 = false;
                            continue;
                        }
                        if (z7) {
                            optInChoiceV2 = next;
                            break;
                        }
                    }
                    optInChoiceV2 = optInChoiceV2;
                }
                return Optional.f41306b.b(optInChoiceV2);
            }
        };
        Single<Optional<OptInChoiceV2>> x7 = g8.x(new Function() { // from class: ee.mtakso.driver.service.campaign.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional y7;
                y7 = CampaignManager.y(Function1.this, obj);
                return y7;
            }
        });
        Intrinsics.e(x7, "optInGroupId: Long, optI…ptInChoice)\n            }");
        return x7;
    }

    public final Single<Optional<OptInGroupV2>> z(final long j8) {
        Single<List<OptInGroupV2>> B = B();
        final Function1<List<? extends OptInGroupV2>, Optional<OptInGroupV2>> function1 = new Function1<List<? extends OptInGroupV2>, Optional<OptInGroupV2>>() { // from class: ee.mtakso.driver.service.campaign.CampaignManager$getOptInGroupV2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OptInGroupV2> invoke(List<OptInGroupV2> optInGroups) {
                Object obj;
                boolean z7;
                Intrinsics.f(optInGroups, "optInGroups");
                Optional.Companion companion = Optional.f41306b;
                long j9 = j8;
                Iterator<T> it = optInGroups.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((OptInGroupV2) obj).getId() == j9) {
                            z7 = true;
                            continue;
                        } else {
                            z7 = false;
                            continue;
                        }
                        if (z7) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                return companion.b(obj);
            }
        };
        Single x7 = B.x(new Function() { // from class: ee.mtakso.driver.service.campaign.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional A;
                A = CampaignManager.A(Function1.this, obj);
                return A;
            }
        });
        Intrinsics.e(x7, "groupId: Long): Single<O… groupId })\n            }");
        return x7;
    }
}
