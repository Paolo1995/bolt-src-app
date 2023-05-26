package ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.campaign.CircleKClient;
import ee.mtakso.driver.network.client.campaign.CircleKLoyaltySignUpMagicLink;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.LiveDataNotification;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CircleKLoyaltyStarterViewModel.kt */
/* loaded from: classes3.dex */
public final class CircleKLoyaltyStarterViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CircleKClient f27394f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f27395g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<LiveDataNotification<String>> f27396h;

    @Inject
    public CircleKLoyaltyStarterViewModel(CircleKClient circleKClient) {
        Intrinsics.f(circleKClient, "circleKClient");
        this.f27394f = circleKClient;
        this.f27396h = new MutableLiveData<>();
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
        this.f27396h.o(LiveDataNotification.f26294d.b());
        Single d8 = SingleExtKt.d(this.f27394f.d());
        final Function1<CircleKLoyaltySignUpMagicLink, Unit> function1 = new Function1<CircleKLoyaltySignUpMagicLink, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CircleKLoyaltySignUpMagicLink circleKLoyaltySignUpMagicLink) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CircleKLoyaltyStarterViewModel.this.f27396h;
                mutableLiveData.o(LiveDataNotification.f26294d.c(circleKLoyaltySignUpMagicLink.a()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CircleKLoyaltySignUpMagicLink circleKLoyaltySignUpMagicLink) {
                b(circleKLoyaltySignUpMagicLink);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: x2.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CircleKLoyaltyStarterViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterViewModel$onStart$2
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
                mutableLiveData = CircleKLoyaltyStarterViewModel.this.f27396h;
                LiveDataNotification.Companion companion = LiveDataNotification.f26294d;
                Intrinsics.e(it, "it");
                mutableLiveData.o(companion.a(it));
            }
        };
        this.f27395g = d8.I(consumer, new Consumer() { // from class: x2.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CircleKLoyaltyStarterViewModel.I(Function1.this, obj);
            }
        });
    }

    public final LiveData<LiveDataNotification<String>> G() {
        return this.f27396h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f27395g;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
