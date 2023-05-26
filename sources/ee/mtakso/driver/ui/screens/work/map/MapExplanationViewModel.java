package ee.mtakso.driver.ui.screens.work.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.driver.DriverMapsConfigsExplanation;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.interactor.map.GetMapExplanationInteractor;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationState;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapExplanationViewModel.kt */
/* loaded from: classes5.dex */
public final class MapExplanationViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetMapExplanationInteractor f34131f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<MapExplanationState> f34132g;

    @Inject
    public MapExplanationViewModel(GetMapExplanationInteractor getMapsExplanationInteractor) {
        Intrinsics.f(getMapsExplanationInteractor, "getMapsExplanationInteractor");
        this.f34131f = getMapsExplanationInteractor;
        this.f34132g = new MutableLiveData<>(MapExplanationState.Loading.f34129a);
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
        Single d8 = SingleExtKt.d(this.f34131f.a());
        final Function1<DriverMapsConfigsExplanation, Unit> function1 = new Function1<DriverMapsConfigsExplanation, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapExplanationViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverMapsConfigsExplanation driverMapsConfigsExplanation) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MapExplanationViewModel.this.f34132g;
                mutableLiveData.o(new MapExplanationState.Ready(driverMapsConfigsExplanation.a()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverMapsConfigsExplanation driverMapsConfigsExplanation) {
                b(driverMapsConfigsExplanation);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.map.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapExplanationViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapExplanationViewModel$onStart$2
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
                MutableLiveData mutableLiveData;
                MapExplanationViewModel mapExplanationViewModel = MapExplanationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(mapExplanationViewModel, it, null, 2, null);
                mutableLiveData = MapExplanationViewModel.this.f34132g;
                mutableLiveData.o(new MapExplanationState.Error(it));
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.map.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapExplanationViewModel.I(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "override fun onStart() {…     .autoDispose()\n    }");
        v(I);
    }

    public final LiveData<MapExplanationState> G() {
        return this.f34132g;
    }
}
