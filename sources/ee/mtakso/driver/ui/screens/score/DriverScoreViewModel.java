package ee.mtakso.driver.ui.screens.score;

import androidx.lifecycle.LiveData;
import ee.mtakso.driver.network.client.score.Action;
import ee.mtakso.driver.network.client.score.DriverScoreClient;
import ee.mtakso.driver.network.client.score.DriverScoreOverviewResponse;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData;
import ee.mtakso.driver.ui.screens.score.DriverScoreViewModel;
import ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: DriverScoreViewModel.kt */
/* loaded from: classes3.dex */
public final class DriverScoreViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverScoreClient f32950f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverScoreMapper f32951g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverScoreTooltipFactory f32952h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverScoreAnalytics f32953i;

    /* renamed from: j  reason: collision with root package name */
    private final SingleLiveData<DriverScoreState> f32954j;

    /* compiled from: DriverScoreViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class DriverScoreState {

        /* renamed from: a  reason: collision with root package name */
        private final List<ListModel> f32955a;

        /* renamed from: b  reason: collision with root package name */
        private final List<TooltipOnbordingDelegate.TooltipElement> f32956b;

        /* JADX WARN: Multi-variable type inference failed */
        public DriverScoreState(List<? extends ListModel> models, List<TooltipOnbordingDelegate.TooltipElement> list) {
            Intrinsics.f(models, "models");
            this.f32955a = models;
            this.f32956b = list;
        }

        public final List<ListModel> a() {
            return this.f32955a;
        }

        public final List<TooltipOnbordingDelegate.TooltipElement> b() {
            return this.f32956b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DriverScoreState) {
                DriverScoreState driverScoreState = (DriverScoreState) obj;
                return Intrinsics.a(this.f32955a, driverScoreState.f32955a) && Intrinsics.a(this.f32956b, driverScoreState.f32956b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f32955a.hashCode() * 31;
            List<TooltipOnbordingDelegate.TooltipElement> list = this.f32956b;
            return hashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            List<ListModel> list = this.f32955a;
            List<TooltipOnbordingDelegate.TooltipElement> list2 = this.f32956b;
            return "DriverScoreState(models=" + list + ", tooltips=" + list2 + ")";
        }
    }

    @Inject
    public DriverScoreViewModel(DriverScoreClient driverScoreClient, DriverScoreMapper driverScoreMapper, DriverScoreTooltipFactory driverScoreTooltipFactory, DriverScoreAnalytics analytics) {
        Intrinsics.f(driverScoreClient, "driverScoreClient");
        Intrinsics.f(driverScoreMapper, "driverScoreMapper");
        Intrinsics.f(driverScoreTooltipFactory, "driverScoreTooltipFactory");
        Intrinsics.f(analytics, "analytics");
        this.f32950f = driverScoreClient;
        this.f32951g = driverScoreMapper;
        this.f32952h = driverScoreTooltipFactory;
        this.f32953i = analytics;
        this.f32954j = new SingleLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverScoreState K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverScoreState) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        SingleLiveData<DriverScoreState> singleLiveData = this.f32954j;
        Single<DriverScoreOverviewResponse> n8 = this.f32950f.n();
        final Function1<DriverScoreOverviewResponse, Unit> function1 = new Function1<DriverScoreOverviewResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverScoreOverviewResponse driverScoreOverviewResponse) {
                DriverScoreAnalytics driverScoreAnalytics;
                long c8;
                boolean z7;
                driverScoreAnalytics = DriverScoreViewModel.this.f32953i;
                c8 = MathKt__MathJVMKt.c(driverScoreOverviewResponse.c().d());
                List<Action> a8 = driverScoreOverviewResponse.a();
                if (a8 != null) {
                    z7 = !a8.isEmpty();
                } else {
                    z7 = false;
                }
                driverScoreAnalytics.j2(c8, z7);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverScoreOverviewResponse driverScoreOverviewResponse) {
                b(driverScoreOverviewResponse);
                return Unit.f50853a;
            }
        };
        Single<DriverScoreOverviewResponse> o8 = n8.o(new Consumer() { // from class: ee.mtakso.driver.ui.screens.score.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverScoreViewModel.J(Function1.this, obj);
            }
        });
        final Function1<DriverScoreOverviewResponse, DriverScoreState> function12 = new Function1<DriverScoreOverviewResponse, DriverScoreState>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverScoreViewModel.DriverScoreState invoke(DriverScoreOverviewResponse it) {
                DriverScoreMapper driverScoreMapper;
                DriverScoreTooltipFactory driverScoreTooltipFactory;
                Intrinsics.f(it, "it");
                driverScoreMapper = DriverScoreViewModel.this.f32951g;
                List<ListModel> g8 = driverScoreMapper.g(it);
                driverScoreTooltipFactory = DriverScoreViewModel.this.f32952h;
                return new DriverScoreViewModel.DriverScoreState(g8, driverScoreTooltipFactory.a());
            }
        };
        Single<R> x7 = o8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.score.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverScoreViewModel.DriverScoreState K;
                K = DriverScoreViewModel.K(Function1.this, obj);
                return K;
            }
        });
        Intrinsics.e(x7, "override fun onStart() {…{ handleError(it) }\n    }");
        singleLiveData.t(l(SingleExtKt.c(x7)), new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreViewModel$onStart$3
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
                Intrinsics.f(it, "it");
                BaseViewModel.A(DriverScoreViewModel.this, it, null, 2, null);
            }
        });
    }

    public final LiveData<DriverScoreState> I() {
        return this.f32954j;
    }

    public final void L() {
        this.f32953i.y3();
    }

    public final void M() {
        this.f32953i.x3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        DisposableExtKt.a(this.f32954j);
    }
}
