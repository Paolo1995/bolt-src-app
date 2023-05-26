package ee.mtakso.driver.ui.screens.priority;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.priority.DriverPriorityClient;
import ee.mtakso.driver.network.client.priority.DriverPriorityResponse;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPriorityViewModel.kt */
/* loaded from: classes3.dex */
public final class DriverPriorityViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverPriorityClient f32522f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverPriorityMapper f32523g;

    /* renamed from: h  reason: collision with root package name */
    private final CompositeUrlLauncher f32524h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f32525i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<ScreenState> f32526j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveEvent<Object> f32527k;

    /* compiled from: DriverPriorityViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class ScreenState {

        /* renamed from: a  reason: collision with root package name */
        private final DriverPriorityResponse f32528a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ListModel> f32529b;

        /* JADX WARN: Multi-variable type inference failed */
        public ScreenState(DriverPriorityResponse details, List<? extends ListModel> listItems) {
            Intrinsics.f(details, "details");
            Intrinsics.f(listItems, "listItems");
            this.f32528a = details;
            this.f32529b = listItems;
        }

        public final DriverPriorityResponse a() {
            return this.f32528a;
        }

        public final List<ListModel> b() {
            return this.f32529b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ScreenState) {
                ScreenState screenState = (ScreenState) obj;
                return Intrinsics.a(this.f32528a, screenState.f32528a) && Intrinsics.a(this.f32529b, screenState.f32529b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f32528a.hashCode() * 31) + this.f32529b.hashCode();
        }

        public String toString() {
            DriverPriorityResponse driverPriorityResponse = this.f32528a;
            List<ListModel> list = this.f32529b;
            return "ScreenState(details=" + driverPriorityResponse + ", listItems=" + list + ")";
        }
    }

    @Inject
    public DriverPriorityViewModel(DriverPriorityClient driverPriorityClient, DriverPriorityMapper driverPriorityMapper, CompositeUrlLauncher urlLauncher) {
        Intrinsics.f(driverPriorityClient, "driverPriorityClient");
        Intrinsics.f(driverPriorityMapper, "driverPriorityMapper");
        Intrinsics.f(urlLauncher, "urlLauncher");
        this.f32522f = driverPriorityClient;
        this.f32523g = driverPriorityMapper;
        this.f32524h = urlLauncher;
        this.f32526j = new MutableLiveData<>();
        this.f32527k = new LiveEvent<>();
    }

    private final void K() {
        y().o(Boolean.TRUE);
        Disposable disposable = this.f32525i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single<DriverPriorityResponse> e8 = this.f32522f.e();
        final Function1<DriverPriorityResponse, ScreenState> function1 = new Function1<DriverPriorityResponse, ScreenState>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel$refreshScreenData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverPriorityViewModel.ScreenState invoke(DriverPriorityResponse it) {
                DriverPriorityMapper driverPriorityMapper;
                Intrinsics.f(it, "it");
                driverPriorityMapper = DriverPriorityViewModel.this.f32523g;
                return new DriverPriorityViewModel.ScreenState(it, driverPriorityMapper.h(it));
            }
        };
        Single<R> x7 = e8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.priority.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverPriorityViewModel.ScreenState L;
                L = DriverPriorityViewModel.L(Function1.this, obj);
                return L;
            }
        });
        Intrinsics.e(x7, "private fun refreshScree…        }\n        )\n    }");
        Single l8 = l(SingleExtKt.d(x7));
        final Function1<ScreenState, Unit> function12 = new Function1<ScreenState, Unit>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel$refreshScreenData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverPriorityViewModel.ScreenState screenState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DriverPriorityViewModel.this.f32526j;
                mutableLiveData.o(screenState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverPriorityViewModel.ScreenState screenState) {
                b(screenState);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.priority.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverPriorityViewModel.M(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel$refreshScreenData$3
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
                LiveEvent liveEvent;
                ApiException apiException = it instanceof ApiException ? (ApiException) it : null;
                boolean z7 = true;
                if ((apiException == null || !apiException.f()) ? false : false) {
                    liveEvent = DriverPriorityViewModel.this.f32527k;
                    liveEvent.o(new Object());
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Payout data is not found!");
                    return;
                }
                DriverPriorityViewModel driverPriorityViewModel = DriverPriorityViewModel.this;
                Intrinsics.e(it, "it");
                driverPriorityViewModel.z(it, "Failed to refresh screen data!");
            }
        };
        this.f32525i = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.priority.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverPriorityViewModel.N(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScreenState L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ScreenState) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        K();
    }

    public final LiveData<ScreenState> J() {
        return this.f32526j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f32525i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
