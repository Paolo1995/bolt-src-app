package ee.mtakso.driver.ui.screens.order.scheduled;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.ScheduledRideRequests;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersGroupViewModel.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersGroupViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetScheduledOrdersInteractor f31790f;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledOrderListModelFactory f31791g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<ScheduledOrdersGroupState> f31792h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f31793i;

    @Inject
    public ScheduledOrdersGroupViewModel(GetScheduledOrdersInteractor getScheduledOrdersInteractor, ScheduledOrderListModelFactory listModelFactory) {
        List k8;
        Intrinsics.f(getScheduledOrdersInteractor, "getScheduledOrdersInteractor");
        Intrinsics.f(listModelFactory, "listModelFactory");
        this.f31790f = getScheduledOrdersInteractor;
        this.f31791g = listModelFactory;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f31792h = new MutableLiveData<>(new ScheduledOrdersGroupState(null, k8, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduledOrdersGroupState J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ScheduledOrdersGroupState) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScheduledOrdersGroupState M(ScheduledOrdersGroupInfo scheduledOrdersGroupInfo, ScheduledRideRequests scheduledRideRequests) {
        Object obj;
        List k8;
        List<ScheduledRideRequests.Item> c8;
        List<ScheduledRideRequests.Item> c9;
        int v7;
        Iterator<T> it = scheduledRideRequests.c().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.a(((ScheduledRideRequests.Group) obj).b(), scheduledOrdersGroupInfo.a())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ScheduledRideRequests.Group group = (ScheduledRideRequests.Group) obj;
        if (group != null && (c9 = group.c()) != null) {
            v7 = CollectionsKt__IterablesKt.v(c9, 10);
            k8 = new ArrayList(v7);
            for (ScheduledRideRequests.Item item : c9) {
                ScheduledOrderListModelFactory scheduledOrderListModelFactory = this.f31791g;
                OrderHandle b8 = item.b();
                k8.add(scheduledOrderListModelFactory.a("scheduled_order_" + b8, item, scheduledRideRequests.b()));
            }
        } else {
            k8 = CollectionsKt__CollectionsKt.k();
        }
        int i8 = -1;
        if (group != null && (c8 = group.c()) != null) {
            int i9 = 0;
            Iterator<ScheduledRideRequests.Item> it2 = c8.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (Intrinsics.a(it2.next().b(), scheduledOrdersGroupInfo.b())) {
                    i8 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        return new ScheduledOrdersGroupState(scheduledOrdersGroupInfo, k8, i8);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void I(final ScheduledOrdersGroupInfo groupInfo) {
        String str;
        List k8;
        Intrinsics.f(groupInfo, "groupInfo");
        ScheduledOrdersGroupInfo a8 = ((ScheduledOrdersGroupState) LiveDataExtKt.b(this.f31792h)).a();
        if (a8 != null) {
            str = a8.a();
        } else {
            str = null;
        }
        if (Intrinsics.a(str, groupInfo.a())) {
            return;
        }
        Disposable disposable = this.f31793i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        MutableLiveData<ScheduledOrdersGroupState> mutableLiveData = this.f31792h;
        k8 = CollectionsKt__CollectionsKt.k();
        mutableLiveData.o(new ScheduledOrdersGroupState(groupInfo, k8, -1));
        Observable d8 = GetScheduledOrdersInteractor.d(this.f31790f, null, 1, null);
        final Function1<ScheduledRideRequests, ScheduledOrdersGroupState> function1 = new Function1<ScheduledRideRequests, ScheduledOrdersGroupState>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupViewModel$loadGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ScheduledOrdersGroupState invoke(ScheduledRideRequests it) {
                ScheduledOrdersGroupState M;
                Intrinsics.f(it, "it");
                M = ScheduledOrdersGroupViewModel.this.M(groupInfo, it);
                return M;
            }
        };
        Observable map = d8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ScheduledOrdersGroupState J;
                J = ScheduledOrdersGroupViewModel.J(Function1.this, obj);
                return J;
            }
        });
        Intrinsics.e(map, "fun loadGroup(groupInfo:…it) }\n            )\n    }");
        Observable k9 = k(ObservableExtKt.g(map));
        final Function1<ScheduledOrdersGroupState, Unit> function12 = new Function1<ScheduledOrdersGroupState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupViewModel$loadGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ScheduledOrdersGroupState scheduledOrdersGroupState) {
                MutableLiveData mutableLiveData2;
                mutableLiveData2 = ScheduledOrdersGroupViewModel.this.f31792h;
                mutableLiveData2.o(scheduledOrdersGroupState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrdersGroupState scheduledOrdersGroupState) {
                b(scheduledOrdersGroupState);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrdersGroupViewModel.K(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupViewModel$loadGroup$3
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
                ScheduledOrdersGroupViewModel scheduledOrdersGroupViewModel = ScheduledOrdersGroupViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(scheduledOrdersGroupViewModel, it, null, 2, null);
            }
        };
        this.f31793i = k9.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrdersGroupViewModel.L(Function1.this, obj);
            }
        });
    }

    public final LiveData<ScheduledOrdersGroupState> N() {
        return this.f31792h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f31793i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f31793i = null;
    }
}
