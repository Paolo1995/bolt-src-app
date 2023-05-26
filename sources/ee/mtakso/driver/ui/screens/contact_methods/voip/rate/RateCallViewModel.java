package ee.mtakso.driver.ui.screens.contact_methods.voip.rate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateCallViewModel.kt */
/* loaded from: classes3.dex */
public final class RateCallViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final RateCallInteractor f28091f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f28092g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<WindowState> f28093h;

    /* compiled from: RateCallViewModel.kt */
    /* loaded from: classes3.dex */
    public enum WindowState {
        EMPTY,
        WITH_RATING
    }

    @Inject
    public RateCallViewModel(RateCallInteractor rateCallInteractor) {
        Intrinsics.f(rateCallInteractor, "rateCallInteractor");
        this.f28091f = rateCallInteractor;
        this.f28093h = new MutableLiveData<>();
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f28093h.o(WindowState.EMPTY);
    }

    public final LiveData<WindowState> F() {
        return this.f28093h;
    }

    public final void G() {
        WindowState f8 = this.f28093h.f();
        WindowState windowState = WindowState.WITH_RATING;
        if (f8 == windowState) {
            return;
        }
        this.f28093h.o(windowState);
    }

    public final void H(int i8, String callId) {
        Intrinsics.f(callId, "callId");
        if (this.f28093h.f() != WindowState.EMPTY) {
            Single d8 = SingleExtKt.d(this.f28091f.b(i8, callId));
            final RateCallViewModel$submitRatingIfSelected$1 rateCallViewModel$submitRatingIfSelected$1 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallViewModel$submitRatingIfSelected$1
                public final void b(Unit unit) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    b(unit);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RateCallViewModel.I(Function1.this, obj);
                }
            };
            final RateCallViewModel$submitRatingIfSelected$2 rateCallViewModel$submitRatingIfSelected$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallViewModel$submitRatingIfSelected$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.o(it);
                }
            };
            this.f28092g = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.rate.f
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RateCallViewModel.J(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28092g;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
