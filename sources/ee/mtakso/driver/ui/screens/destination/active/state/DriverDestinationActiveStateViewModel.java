package ee.mtakso.driver.ui.screens.destination.active.state;

import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.destination.DeactivateDestinationInteractor;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverDestinationActiveStateViewModel.kt */
/* loaded from: classes3.dex */
public final class DriverDestinationActiveStateViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DeactivateDestinationInteractor f28181f;

    /* renamed from: g  reason: collision with root package name */
    private final LiveEvent<Unit> f28182g;

    /* renamed from: h  reason: collision with root package name */
    private final LiveEvent<Unit> f28183h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f28184i;

    @Inject
    public DriverDestinationActiveStateViewModel(DeactivateDestinationInteractor deactivateDestinationInteractor) {
        Intrinsics.f(deactivateDestinationInteractor, "deactivateDestinationInteractor");
        this.f28181f = deactivateDestinationInteractor;
        LiveEvent<Unit> liveEvent = new LiveEvent<>();
        this.f28182g = liveEvent;
        this.f28183h = liveEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DriverDestinationActiveStateViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.y().o(Boolean.FALSE);
        this$0.f28182g.o(Unit.f50853a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void H() {
        Completable a8 = this.f28181f.a();
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateViewModel$deactivateCurrentDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = DriverDestinationActiveStateViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Completable r7 = a8.r(new Consumer() { // from class: h3.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationActiveStateViewModel.I(Function1.this, obj);
            }
        });
        Action action = new Action() { // from class: h3.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                DriverDestinationActiveStateViewModel.J(DriverDestinationActiveStateViewModel.this);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateViewModel$deactivateCurrentDestination$3
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
                MutableLiveData y7;
                y7 = DriverDestinationActiveStateViewModel.this.y();
                y7.o(Boolean.FALSE);
                DriverDestinationActiveStateViewModel driverDestinationActiveStateViewModel = DriverDestinationActiveStateViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverDestinationActiveStateViewModel, it, null, 2, null);
            }
        };
        this.f28184i = r7.G(action, new Consumer() { // from class: h3.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationActiveStateViewModel.K(Function1.this, obj);
            }
        });
    }

    public final LiveEvent<Unit> L() {
        return this.f28183h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f28184i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        super.onCleared();
    }
}
