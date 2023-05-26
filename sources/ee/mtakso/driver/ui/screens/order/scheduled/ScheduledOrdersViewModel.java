package ee.mtakso.driver.ui.screens.order.scheduled;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.AcceptedScheduledRides;
import ee.mtakso.driver.network.client.order.RideDetailChip;
import ee.mtakso.driver.network.client.order.RideDetailLabel;
import ee.mtakso.driver.network.client.order.RideDetailLabelTypeInfo;
import ee.mtakso.driver.network.client.order.ScheduledRideRequests;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetAcceptedOrdersInteractor;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor;
import ee.mtakso.driver.ui.screens.order.scheduled.AcceptedOrderDelegate;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersState;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.engine.html.HtmlEngine;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersViewModel.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetScheduledOrdersInteractor f31809f;

    /* renamed from: g  reason: collision with root package name */
    private final GetAcceptedOrdersInteractor f31810g;

    /* renamed from: h  reason: collision with root package name */
    private final ScheduledOrderListModelFactory f31811h;

    /* renamed from: i  reason: collision with root package name */
    private final ScheduledOrderInfoBlockMapper f31812i;

    /* renamed from: j  reason: collision with root package name */
    private final HtmlEngine f31813j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<ScheduledOrdersState> f31814k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f31815l;

    /* compiled from: ScheduledOrdersViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31816a;

        static {
            int[] iArr = new int[ScheduledOrdersState.Filter.values().length];
            try {
                iArr[ScheduledOrdersState.Filter.SCHEDULED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScheduledOrdersState.Filter.ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f31816a = iArr;
        }
    }

    @Inject
    public ScheduledOrdersViewModel(GetScheduledOrdersInteractor getScheduledOrdersInteractor, GetAcceptedOrdersInteractor getAcceptedOrdersInteractor, ScheduledOrderListModelFactory listModelFactory, ScheduledOrderInfoBlockMapper infoBlockMapper, HtmlEngine htmlEngine) {
        List k8;
        Intrinsics.f(getScheduledOrdersInteractor, "getScheduledOrdersInteractor");
        Intrinsics.f(getAcceptedOrdersInteractor, "getAcceptedOrdersInteractor");
        Intrinsics.f(listModelFactory, "listModelFactory");
        Intrinsics.f(infoBlockMapper, "infoBlockMapper");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f31809f = getScheduledOrdersInteractor;
        this.f31810g = getAcceptedOrdersInteractor;
        this.f31811h = listModelFactory;
        this.f31812i = infoBlockMapper;
        this.f31813j = htmlEngine;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f31814k = new MutableLiveData<>(new ScheduledOrdersState(k8, ScheduledOrdersState.Filter.SCHEDULED, false, 0));
    }

    private final void N() {
        if (!DisposableExtKt.b(this.f31815l)) {
            return;
        }
        int i8 = WhenMappings.f31816a[((ScheduledOrdersState) LiveDataExtKt.b(this.f31814k)).b().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                Observable<AcceptedScheduledRides> c8 = this.f31810g.c();
                final Function1<AcceptedScheduledRides, ScheduledOrdersState> function1 = new Function1<AcceptedScheduledRides, ScheduledOrdersState>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel$loadOrders$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: b */
                    public final ScheduledOrdersState invoke(AcceptedScheduledRides it) {
                        ScheduledOrdersState U;
                        Intrinsics.f(it, "it");
                        U = ScheduledOrdersViewModel.this.U(it);
                        return U;
                    }
                };
                Observable<R> map = c8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.w
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        ScheduledOrdersState R;
                        R = ScheduledOrdersViewModel.R(Function1.this, obj);
                        return R;
                    }
                });
                Intrinsics.e(map, "private fun loadOrders()…        }\n        }\n    }");
                Observable k8 = k(ObservableExtKt.g(map));
                final Function1<ScheduledOrdersState, Unit> function12 = new Function1<ScheduledOrdersState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel$loadOrders$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void b(ScheduledOrdersState scheduledOrdersState) {
                        MutableLiveData mutableLiveData;
                        mutableLiveData = ScheduledOrdersViewModel.this.f31814k;
                        mutableLiveData.o(scheduledOrdersState);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrdersState scheduledOrdersState) {
                        b(scheduledOrdersState);
                        return Unit.f50853a;
                    }
                };
                Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.x
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ScheduledOrdersViewModel.S(Function1.this, obj);
                    }
                };
                final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel$loadOrders$6
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
                        ScheduledOrdersViewModel scheduledOrdersViewModel = ScheduledOrdersViewModel.this;
                        Intrinsics.e(it, "it");
                        BaseViewModel.A(scheduledOrdersViewModel, it, null, 2, null);
                    }
                };
                this.f31815l = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.y
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ScheduledOrdersViewModel.T(Function1.this, obj);
                    }
                });
                return;
            }
            return;
        }
        Observable d8 = GetScheduledOrdersInteractor.d(this.f31809f, null, 1, null);
        final Function1<ScheduledRideRequests, ScheduledOrdersState> function14 = new Function1<ScheduledRideRequests, ScheduledOrdersState>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel$loadOrders$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ScheduledOrdersState invoke(ScheduledRideRequests it) {
                ScheduledOrdersState V;
                Intrinsics.f(it, "it");
                V = ScheduledOrdersViewModel.this.V(it);
                return V;
            }
        };
        Observable map2 = d8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.t
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ScheduledOrdersState O;
                O = ScheduledOrdersViewModel.O(Function1.this, obj);
                return O;
            }
        });
        Intrinsics.e(map2, "private fun loadOrders()…        }\n        }\n    }");
        Observable k9 = k(ObservableExtKt.g(map2));
        final Function1<ScheduledOrdersState, Unit> function15 = new Function1<ScheduledOrdersState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel$loadOrders$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ScheduledOrdersState scheduledOrdersState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ScheduledOrdersViewModel.this.f31814k;
                mutableLiveData.o(scheduledOrdersState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrdersState scheduledOrdersState) {
                b(scheduledOrdersState);
                return Unit.f50853a;
            }
        };
        Consumer consumer2 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrdersViewModel.P(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function16 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel$loadOrders$3
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
                ScheduledOrdersViewModel scheduledOrdersViewModel = ScheduledOrdersViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(scheduledOrdersViewModel, it, null, 2, null);
            }
        };
        this.f31815l = k9.subscribe(consumer2, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrdersViewModel.Q(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduledOrdersState O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ScheduledOrdersState) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduledOrdersState R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ScheduledOrdersState) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScheduledOrdersState U(AcceptedScheduledRides acceptedScheduledRides) {
        int v7;
        int v8;
        Image.Url url;
        RideDetailLabelTypeInfo rideDetailLabelTypeInfo;
        String a8;
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : acceptedScheduledRides.b()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            AcceptedScheduledRides.Group group = (AcceptedScheduledRides.Group) obj;
            arrayList.add(new GenericTitleDelegate.Model("accepted_group_" + group.a(), 0, this.f31813j.a(group.c()), null, false, false, false, null, null, null, 1016, null));
            List<AcceptedScheduledRides.Item> b8 = group.b();
            v7 = CollectionsKt__IterablesKt.v(b8, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            int i10 = 0;
            for (Object obj2 : b8) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                AcceptedScheduledRides.Item item = (AcceptedScheduledRides.Item) obj2;
                String str = "accepted_order_" + item.b();
                Text.Value value = new Text.Value(this.f31813j.a(item.e()));
                List<RideDetailChip> c8 = item.c();
                List<RideDetailLabel> d8 = item.d();
                v8 = CollectionsKt__IterablesKt.v(d8, 10);
                ArrayList arrayList3 = new ArrayList(v8);
                for (RideDetailLabel rideDetailLabel : d8) {
                    Map<String, RideDetailLabelTypeInfo> a9 = acceptedScheduledRides.a();
                    if (a9 != null && (rideDetailLabelTypeInfo = a9.get(rideDetailLabel.b())) != null && (a8 = rideDetailLabelTypeInfo.a()) != null) {
                        url = new Image.Url(a8);
                    } else {
                        url = null;
                    }
                    arrayList3.add(new OrderLabelModel(url, new Text.Value(rideDetailLabel.a())));
                }
                arrayList2.add(new AcceptedOrderDelegate.Model(str, value, c8, arrayList3, this.f31812i.a(item.a()), item.b(), null, 64, null));
                i10 = i11;
            }
            arrayList.addAll(arrayList2);
            i8 = i9;
        }
        ScheduledOrdersState.Filter filter = ScheduledOrdersState.Filter.ACCEPTED;
        int i12 = 0;
        for (AcceptedScheduledRides.Group group2 : acceptedScheduledRides.b()) {
            i12 += group2.b().size();
        }
        return new ScheduledOrdersState(arrayList, filter, true, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScheduledOrdersState V(ScheduledRideRequests scheduledRideRequests) {
        int v7;
        Object h02;
        List<ScheduledRideRequests.Group> c8 = scheduledRideRequests.c();
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : c8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            ScheduledRideRequests.Group group = (ScheduledRideRequests.Group) obj;
            arrayList.add(new GenericTitleDelegate.Model("scheduled_group_" + group.b(), 0, this.f31813j.a(group.d()), null, false, false, false, null, null, null, 1016, null));
            List<ScheduledRideRequests.Item> c9 = group.c();
            v7 = CollectionsKt__IterablesKt.v(c9, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            for (ScheduledRideRequests.Item item : c9) {
                arrayList2.add(this.f31811h.a("scheduled_order_" + item.b(), item, scheduledRideRequests.b()));
            }
            arrayList.addAll(arrayList2);
            if (group.a()) {
                String str = "expand_group_" + group.b();
                Text.Resource resource = new Text.Resource(R.string.view_all_requests, null, 2, null);
                Color.Attr attr = new Color.Attr(R.attr.dynamicNeutral04);
                Image.Res res = new Image.Res(R.drawable.ic_chevron_right);
                String b8 = group.b();
                String d8 = group.d();
                h02 = CollectionsKt___CollectionsKt.h0(group.c());
                arrayList.add(new TwoLinesItemDelegate.Model(str, resource, null, null, null, null, null, null, null, null, null, attr, res, null, null, null, null, null, new ScheduledOrdersGroupInfo(b8, d8, ((ScheduledRideRequests.Item) h02).b()), false, 0, 0, false, new Color.Attr(R.attr.backTertiary), null, Float.valueOf(Dimens.b(8.0f)), false, true, false, 360441852, null));
            }
            i8 = i9;
        }
        return new ScheduledOrdersState(arrayList, ScheduledOrdersState.Filter.SCHEDULED, true, scheduledRideRequests.a());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        N();
    }

    public final void M(ScheduledOrdersState.Filter filter) {
        List k8;
        Intrinsics.f(filter, "filter");
        ScheduledOrdersState scheduledOrdersState = (ScheduledOrdersState) LiveDataExtKt.b(this.f31814k);
        if (scheduledOrdersState.b() == filter) {
            return;
        }
        Disposable disposable = this.f31815l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        MutableLiveData<ScheduledOrdersState> mutableLiveData = this.f31814k;
        k8 = CollectionsKt__CollectionsKt.k();
        mutableLiveData.o(new ScheduledOrdersState(k8, filter, false, scheduledOrdersState.a()));
        N();
    }

    public final LiveData<ScheduledOrdersState> W() {
        return this.f31814k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f31815l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f31815l = null;
    }
}
