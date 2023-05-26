package ee.mtakso.driver.ui.screens.settings.auto_acceptance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import ee.mtakso.driver.service.analytics.event.facade.AutoAcceptanceAnalytics;
import ee.mtakso.driver.service.settings.AutoAcceptanceState;
import ee.mtakso.driver.service.settings.CategorySelectionAutoAcceptanceState;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoAcceptanceSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class AutoAcceptanceSettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DispatchSettingsManager f33160f;

    /* renamed from: g  reason: collision with root package name */
    private final AutoAcceptanceAnalytics f33161g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<AutoAcceptanceState> f33162h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f33163i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f33164j;

    @Inject
    public AutoAcceptanceSettingsViewModel(DispatchSettingsManager dispatchSettingsManager, AutoAcceptanceAnalytics autoAcceptanceAnalytics) {
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(autoAcceptanceAnalytics, "autoAcceptanceAnalytics");
        this.f33160f = dispatchSettingsManager;
        this.f33161g = autoAcceptanceAnalytics;
        this.f33162h = new MutableLiveData<>();
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

    private final void M() {
        Disposable disposable = this.f33163i;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable f8 = ObservableExtKt.f(this.f33160f.v());
        final Function1<CategorySelectionAutoAcceptanceState, Unit> function1 = new Function1<CategorySelectionAutoAcceptanceState, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsViewModel$updateAutoAcceptanceState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AutoAcceptanceSettingsViewModel.this.f33162h;
                mutableLiveData.m(categorySelectionAutoAcceptanceState.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState) {
                b(categorySelectionAutoAcceptanceState);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoAcceptanceSettingsViewModel.N(Function1.this, obj);
            }
        };
        final AutoAcceptanceSettingsViewModel$updateAutoAcceptanceState$2 autoAcceptanceSettingsViewModel$updateAutoAcceptanceState$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsViewModel$updateAutoAcceptanceState$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to observe car category selection availability!");
            }
        };
        this.f33163i = f8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoAcceptanceSettingsViewModel.O(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        M();
    }

    public final LiveData<AutoAcceptanceState> I() {
        return this.f33162h;
    }

    public final void J(boolean z7) {
        AutoOrderAcceptance autoOrderAcceptance;
        this.f33161g.Z2("Settings screen", z7);
        Disposable disposable = this.f33164j;
        if (disposable != null) {
            disposable.dispose();
        }
        DispatchSettingsManager dispatchSettingsManager = this.f33160f;
        if (z7) {
            autoOrderAcceptance = AutoOrderAcceptance.AUTO;
        } else {
            autoOrderAcceptance = AutoOrderAcceptance.MANUAL;
        }
        Single d8 = SingleExtKt.d(DispatchSettingsManager.M(dispatchSettingsManager, null, autoOrderAcceptance, 1, null));
        final AutoAcceptanceSettingsViewModel$onAutoAcceptanceToggleClick$1 autoAcceptanceSettingsViewModel$onAutoAcceptanceToggleClick$1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsViewModel$onAutoAcceptanceToggleClick$1
            public final void b(String str) {
                Kalev.b("Update setting call ended. Result message: " + str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoAcceptanceSettingsViewModel.K(Function1.this, obj);
            }
        };
        final AutoAcceptanceSettingsViewModel$onAutoAcceptanceToggleClick$2 autoAcceptanceSettingsViewModel$onAutoAcceptanceToggleClick$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsViewModel$onAutoAcceptanceToggleClick$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to update settings!");
            }
        };
        this.f33164j = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.settings.auto_acceptance.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoAcceptanceSettingsViewModel.L(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f33163i;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f33164j;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
