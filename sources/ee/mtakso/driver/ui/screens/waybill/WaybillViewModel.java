package ee.mtakso.driver.ui.screens.waybill;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.WayBillData;
import ee.mtakso.driver.network.client.driver.WaybillClient;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.waybill.WaybillViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaybillViewModel.kt */
/* loaded from: classes5.dex */
public final class WaybillViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final WaybillClient f33622f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<WaybillState> f33623g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f33624h;

    @Inject
    public WaybillViewModel(WaybillClient waybillClient) {
        Intrinsics.f(waybillClient, "waybillClient");
        this.f33622f = waybillClient;
        this.f33623g = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void G(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single l8 = l(SingleExtKt.d(this.f33622f.b(orderHandle)));
        final Function1<WayBillData, Unit> function1 = new Function1<WayBillData, Unit>() { // from class: ee.mtakso.driver.ui.screens.waybill.WaybillViewModel$loadWaybill$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(WayBillData wayBillData) {
                MutableLiveData mutableLiveData;
                String a8 = wayBillData.a();
                mutableLiveData = WaybillViewModel.this.f33623g;
                mutableLiveData.o(new WaybillState(a8));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WayBillData wayBillData) {
                b(wayBillData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: j5.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WaybillViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.waybill.WaybillViewModel$loadWaybill$2
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
                WaybillViewModel waybillViewModel = WaybillViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(waybillViewModel, it, null, 2, null);
            }
        };
        this.f33624h = l8.I(consumer, new Consumer() { // from class: j5.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WaybillViewModel.I(Function1.this, obj);
            }
        });
    }

    public final LiveData<WaybillState> J() {
        return this.f33623g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f33624h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        super.onCleared();
    }
}
