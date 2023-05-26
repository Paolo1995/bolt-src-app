package eu.bolt.driver.voip.ui.screen.call.incoming;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.voip_client.VoipCall;
import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.util.Optional;
import eu.bolt.driver.voip.CallData;
import eu.bolt.driver.voip.DriverVoipSdk;
import eu.bolt.driver.voip.VoipSession;
import eu.bolt.driver.voip.service.call.CallModel;
import eu.bolt.driver.voip.service.call.CallState;
import eu.bolt.driver.voip.service.order.CurrentOrderInfo;
import eu.bolt.driver.voip.service.order.CurrentOrderInfoProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingCallViewModel.kt */
/* loaded from: classes5.dex */
public final class IncomingCallViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CurrentOrderInfoProvider f41657f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<IncomingCallData> f41658g;

    @Inject
    public IncomingCallViewModel(CurrentOrderInfoProvider currentOrderInfoProvider) {
        Intrinsics.f(currentOrderInfoProvider, "currentOrderInfoProvider");
        this.f41657f = currentOrderInfoProvider;
        this.f41658g = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    private final Observable<Optional<CurrentOrderInfo>> B() {
        Single<VoipCall> firstOrError = x().X().firstOrError();
        final Function1<VoipCall, ObservableSource<? extends Optional<CurrentOrderInfo>>> function1 = new Function1<VoipCall, ObservableSource<? extends Optional<CurrentOrderInfo>>>() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel$observeOrderInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends Optional<CurrentOrderInfo>> invoke(VoipCall it) {
                Observable z7;
                Intrinsics.f(it, "it");
                z7 = IncomingCallViewModel.this.z(new CallModel(it));
                return z7;
            }
        };
        Observable t7 = firstOrError.t(new Function() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource C;
                C = IncomingCallViewModel.C(Function1.this, obj);
                return C;
            }
        });
        Intrinsics.e(t7, "private fun observeOrder…er(CallModel(it)) }\n    }");
        return t7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IncomingCallData D(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (IncomingCallData) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final VoipSession x() {
        VoipSession b8 = DriverVoipSdk.f41604a.b().b();
        if (b8 != null) {
            return b8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<Optional<CurrentOrderInfo>> z(CallModel callModel) {
        Boolean bool;
        String a8 = callModel.a("isOrderFinished");
        if (a8 != null) {
            bool = Boolean.valueOf(Boolean.parseBoolean(a8));
        } else {
            bool = null;
        }
        if (Intrinsics.a(bool, Boolean.FALSE)) {
            Observable<CurrentOrderInfo> a9 = this.f41657f.a();
            final IncomingCallViewModel$observeIncomingCallOrder$1 incomingCallViewModel$observeIncomingCallOrder$1 = new Function1<CurrentOrderInfo, Optional<CurrentOrderInfo>>() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel$observeIncomingCallOrder$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Optional<CurrentOrderInfo> invoke(CurrentOrderInfo it) {
                    Intrinsics.f(it, "it");
                    return Optional.f41306b.b(it);
                }
            };
            Observable map = a9.map(new Function() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.e
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Optional A;
                    A = IncomingCallViewModel.A(Function1.this, obj);
                    return A;
                }
            });
            Intrinsics.e(map, "currentOrderInfoProvider…).map { Optional.of(it) }");
            return map;
        }
        Observable<Optional<CurrentOrderInfo>> just = Observable.just(Optional.f41306b.a());
        Intrinsics.e(just, "just(Optional.empty())");
        return just;
    }

    public final void G() {
        x().t();
    }

    @Override // eu.bolt.driver.core.ui.base.mvvm.BaseViewModel
    public void n() {
        Observable<CallData> N = x().N();
        Observable<Optional<CurrentOrderInfo>> startWith = B().startWith((Observable<Optional<CurrentOrderInfo>>) Optional.f41306b.a());
        final IncomingCallViewModel$onStart$1 incomingCallViewModel$onStart$1 = new Function2<CallData, Optional<CurrentOrderInfo>, IncomingCallData>() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel$onStart$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final IncomingCallData s(CallData callUpdate, Optional<CurrentOrderInfo> orderInfoOptional) {
                String str;
                Intrinsics.f(callUpdate, "callUpdate");
                Intrinsics.f(orderInfoOptional, "orderInfoOptional");
                CallState a8 = CallState.f41635f.a(callUpdate.a().getState());
                String b8 = callUpdate.a().e().b();
                CurrentOrderInfo b9 = orderInfoOptional.b();
                Long l8 = null;
                if (b9 != null) {
                    str = b9.a();
                } else {
                    str = null;
                }
                CurrentOrderInfo b10 = orderInfoOptional.b();
                if (b10 != null) {
                    l8 = b10.b();
                }
                return new IncomingCallData(a8, b8, str, l8);
            }
        };
        Observable combineLatest = Observable.combineLatest(N, startWith, new BiFunction() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                IncomingCallData D;
                D = IncomingCallViewModel.D(Function2.this, obj, obj2);
                return D;
            }
        });
        final Function1<IncomingCallData, Unit> function1 = new Function1<IncomingCallData, Unit>() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(IncomingCallData incomingCallData) {
                MutableLiveData mutableLiveData;
                mutableLiveData = IncomingCallViewModel.this.f41658g;
                mutableLiveData.m(incomingCallData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IncomingCallData incomingCallData) {
                b(incomingCallData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingCallViewModel.E(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel$onStart$3
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
                IncomingCallViewModel incomingCallViewModel = IncomingCallViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.m(incomingCallViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = combineLatest.subscribe(consumer, new Consumer() { // from class: eu.bolt.driver.voip.ui.screen.call.incoming.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingCallViewModel.F(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun onStart() {…     .autoDispose()\n    }");
        h(subscribe);
    }

    public final void u() {
        x().h();
    }

    public final LiveData<IncomingCallData> y() {
        return this.f41658g;
    }
}
