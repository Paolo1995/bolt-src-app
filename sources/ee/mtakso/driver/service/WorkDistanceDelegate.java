package ee.mtakso.driver.service;

import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.RxUtils;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkDistanceDelegate.kt */
/* loaded from: classes3.dex */
public final class WorkDistanceDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f23405a;

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f23406b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverClient f23407c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverAppConfig.MaxClientDistance f23408d;

    /* renamed from: e  reason: collision with root package name */
    private DriverAppConfig.MaxClientDistance f23409e;

    /* renamed from: f  reason: collision with root package name */
    private DriverAppConfig.MaxClientDistance f23410f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f23411g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f23412h;

    /* renamed from: i  reason: collision with root package name */
    private final BehaviorSubject<DriverAppConfig.MaxClientDistance> f23413i;

    /* renamed from: j  reason: collision with root package name */
    private final BehaviorSubject<DriverAppConfig.MaxClientDistance> f23414j;

    /* renamed from: k  reason: collision with root package name */
    private final List<DriverAppConfig.MaxClientDistance> f23415k;

    @Inject
    public WorkDistanceDelegate(DriverProvider driverProvider, PollerSource poller, DriverClient apiClient) {
        Object obj;
        DriverAppConfig.MaxClientDistance maxClientDistance;
        Object W;
        boolean z7;
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(poller, "poller");
        Intrinsics.f(apiClient, "apiClient");
        this.f23405a = driverProvider;
        this.f23406b = poller;
        this.f23407c = apiClient;
        BehaviorSubject<DriverAppConfig.MaxClientDistance> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<DriverAppConfig.MaxClientDistance>()");
        this.f23413i = e8;
        BehaviorSubject<DriverAppConfig.MaxClientDistance> e9 = BehaviorSubject.e();
        Intrinsics.e(e9, "create<DriverAppConfig.MaxClientDistance>()");
        this.f23414j = e9;
        List<DriverAppConfig.MaxClientDistance> L = driverProvider.m().L();
        this.f23415k = L;
        if (L.isEmpty()) {
            maxClientDistance = new DriverAppConfig.MaxClientDistance(-1, "");
        } else {
            Iterator<T> it = L.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((DriverAppConfig.MaxClientDistance) obj).a() == this.f23405a.m().K()) {
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
            maxClientDistance = (DriverAppConfig.MaxClientDistance) obj;
            if (maxClientDistance == null) {
                W = CollectionsKt___CollectionsKt.W(this.f23415k);
                maxClientDistance = (DriverAppConfig.MaxClientDistance) W;
            }
        }
        this.f23408d = maxClientDistance;
        this.f23409e = maxClientDistance;
        this.f23410f = maxClientDistance;
    }

    private final DriverAppConfig.MaxClientDistance m() {
        DriverAppConfig.MaxClientDistance maxClientDistance;
        boolean z7;
        List<DriverAppConfig.MaxClientDistance> list = this.f23415k;
        ListIterator<DriverAppConfig.MaxClientDistance> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                maxClientDistance = listIterator.previous();
                if (maxClientDistance.a() < this.f23410f.a()) {
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
                maxClientDistance = null;
                break;
            }
        }
        DriverAppConfig.MaxClientDistance maxClientDistance2 = maxClientDistance;
        if (maxClientDistance2 == null) {
            return this.f23410f;
        }
        return maxClientDistance2;
    }

    private final DriverAppConfig.MaxClientDistance n() {
        Object obj;
        boolean z7;
        Iterator<T> it = this.f23415k.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((DriverAppConfig.MaxClientDistance) obj).a() > this.f23410f.a()) {
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
        DriverAppConfig.MaxClientDistance maxClientDistance = (DriverAppConfig.MaxClientDistance) obj;
        if (maxClientDistance == null) {
            return this.f23410f;
        }
        return maxClientDistance;
    }

    private final void p() {
        if (DisposableExtKt.b(this.f23412h)) {
            Observable<DriverAppConfig.MaxClientDistance> sample = this.f23414j.sample(2L, TimeUnit.SECONDS);
            final WorkDistanceDelegate$initRadiusChangeChainIfNeeded$1 workDistanceDelegate$initRadiusChangeChainIfNeeded$1 = new WorkDistanceDelegate$initRadiusChangeChainIfNeeded$1(this);
            Observable<R> flatMapSingle = sample.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.i
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    SingleSource q8;
                    q8 = WorkDistanceDelegate.q(Function1.this, obj);
                    return q8;
                }
            });
            final WorkDistanceDelegate$initRadiusChangeChainIfNeeded$2 workDistanceDelegate$initRadiusChangeChainIfNeeded$2 = new Function1<Observable<DriverAppConfig.MaxClientDistance>, ObservableSource<DriverAppConfig.MaxClientDistance>>() { // from class: ee.mtakso.driver.service.WorkDistanceDelegate$initRadiusChangeChainIfNeeded$2
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<DriverAppConfig.MaxClientDistance> invoke(Observable<DriverAppConfig.MaxClientDistance> it) {
                    Intrinsics.f(it, "it");
                    return RxUtils.b(it);
                }
            };
            Observable compose = flatMapSingle.compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.j
                @Override // io.reactivex.ObservableTransformer
                public final ObservableSource a(Observable observable) {
                    ObservableSource r7;
                    r7 = WorkDistanceDelegate.r(Function1.this, observable);
                    return r7;
                }
            });
            final Function1<DriverAppConfig.MaxClientDistance, Unit> function1 = new Function1<DriverAppConfig.MaxClientDistance, Unit>() { // from class: ee.mtakso.driver.service.WorkDistanceDelegate$initRadiusChangeChainIfNeeded$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(DriverAppConfig.MaxClientDistance it) {
                    WorkDistanceDelegate workDistanceDelegate = WorkDistanceDelegate.this;
                    Intrinsics.e(it, "it");
                    workDistanceDelegate.f23409e = it;
                    WorkDistanceDelegate.this.x(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DriverAppConfig.MaxClientDistance maxClientDistance) {
                    b(maxClientDistance);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WorkDistanceDelegate.s(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.WorkDistanceDelegate$initRadiusChangeChainIfNeeded$4
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
                public final void invoke2(Throwable it) {
                    DriverAppConfig.MaxClientDistance maxClientDistance;
                    DriverAppConfig.MaxClientDistance maxClientDistance2;
                    WorkDistanceDelegate workDistanceDelegate = WorkDistanceDelegate.this;
                    maxClientDistance = workDistanceDelegate.f23409e;
                    workDistanceDelegate.f23410f = maxClientDistance;
                    WorkDistanceDelegate workDistanceDelegate2 = WorkDistanceDelegate.this;
                    maxClientDistance2 = workDistanceDelegate2.f23409e;
                    workDistanceDelegate2.x(maxClientDistance2);
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to set max client distance!");
                }
            };
            this.f23412h = compose.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.l
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WorkDistanceDelegate.t(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource r(Function1 tmp0, Observable p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (ObservableSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(DriverAppConfig.MaxClientDistance maxClientDistance) {
        this.f23405a.v().S().b(maxClientDistance.a());
        this.f23413i.onNext(maxClientDistance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int i8) {
        Object obj;
        boolean z7;
        Iterator<T> it = this.f23415k.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((DriverAppConfig.MaxClientDistance) obj).a() == i8) {
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
        DriverAppConfig.MaxClientDistance maxClientDistance = (DriverAppConfig.MaxClientDistance) obj;
        if (maxClientDistance == null) {
            return;
        }
        this.f23410f = maxClientDistance;
        this.f23409e = maxClientDistance;
        x(maxClientDistance);
    }

    public final DriverClient o() {
        return this.f23407c;
    }

    public final Observable<DriverAppConfig.MaxClientDistance> u() {
        if (DisposableExtKt.b(this.f23411g)) {
            Single<PollingSigned<PollingResult>> z7 = this.f23406b.e().retry().firstOrError().z(Schedulers.a());
            final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.WorkDistanceDelegate$observeRadius$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(PollingSigned<PollingResult> pollingSigned) {
                    DriverAppConfig.MaxClientDistance maxClientDistance;
                    int a8;
                    Double h8 = pollingSigned.a().h();
                    if (h8 == null) {
                        maxClientDistance = WorkDistanceDelegate.this.f23408d;
                        a8 = maxClientDistance.a();
                    } else {
                        a8 = ((int) h8.doubleValue()) * 1000;
                    }
                    WorkDistanceDelegate.this.y(a8);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                    b(pollingSigned);
                    return Unit.f50853a;
                }
            };
            Consumer<? super PollingSigned<PollingResult>> consumer = new Consumer() { // from class: ee.mtakso.driver.service.g
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WorkDistanceDelegate.v(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.WorkDistanceDelegate$observeRadius$2
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
                    DriverAppConfig.MaxClientDistance maxClientDistance;
                    WorkDistanceDelegate workDistanceDelegate = WorkDistanceDelegate.this;
                    maxClientDistance = workDistanceDelegate.f23408d;
                    workDistanceDelegate.y(maxClientDistance.a());
                }
            };
            this.f23411g = z7.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WorkDistanceDelegate.w(Function1.this, obj);
                }
            });
        }
        return this.f23413i;
    }

    public final void z(boolean z7) {
        DriverAppConfig.MaxClientDistance m8;
        if (!this.f23405a.m().R()) {
            return;
        }
        p();
        if (z7) {
            m8 = n();
        } else {
            m8 = m();
        }
        this.f23410f = m8;
        x(m8);
        this.f23414j.onNext(m8);
    }
}
