package ee.mtakso.driver.ui.screens.score;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.score.DriverScoreClient;
import ee.mtakso.driver.network.client.score.DriverScoreExplanationResponse;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.theme.ThemeTitle;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.theme.Theme;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreExplanationViewModel.kt */
/* loaded from: classes3.dex */
public final class DriverScoreExplanationViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverScoreClient f32892f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverScoreAnalytics f32893g;

    /* renamed from: h  reason: collision with root package name */
    private final WebViewTracker f32894h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<String> f32895i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f32896j;

    @Inject
    public DriverScoreExplanationViewModel(DriverScoreClient driverScoreClient, DriverScoreAnalytics analytics, WebViewTracker webViewTracker) {
        Intrinsics.f(driverScoreClient, "driverScoreClient");
        Intrinsics.f(analytics, "analytics");
        Intrinsics.f(webViewTracker, "webViewTracker");
        this.f32892f = driverScoreClient;
        this.f32893g = analytics;
        this.f32894h = webViewTracker;
        this.f32895i = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f32894h.b();
    }

    public final void H(Theme theme) {
        Intrinsics.f(theme, "theme");
        Disposable disposable = this.f32896j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single<DriverScoreExplanationResponse> k8 = this.f32892f.k(ThemeTitle.f34260g.a(theme));
        final DriverScoreExplanationViewModel$fetchDriverScoreExplanation$1 driverScoreExplanationViewModel$fetchDriverScoreExplanation$1 = new Function1<DriverScoreExplanationResponse, String>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreExplanationViewModel$fetchDriverScoreExplanation$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(DriverScoreExplanationResponse it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<R> x7 = k8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.score.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String I;
                I = DriverScoreExplanationViewModel.I(Function1.this, obj);
                return I;
            }
        });
        Intrinsics.e(x7, "driverScoreClient\n      …  .map { it.htmlContent }");
        Single l8 = l(SingleExtKt.d(x7));
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreExplanationViewModel$fetchDriverScoreExplanation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DriverScoreExplanationViewModel.this.f32895i;
                mutableLiveData.o(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.score.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverScoreExplanationViewModel.J(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreExplanationViewModel$fetchDriverScoreExplanation$3
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
                DriverScoreExplanationViewModel driverScoreExplanationViewModel = DriverScoreExplanationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverScoreExplanationViewModel, it, null, 2, null);
            }
        };
        this.f32896j = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.score.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverScoreExplanationViewModel.K(Function1.this, obj);
            }
        });
    }

    public final WebViewTracker L() {
        return this.f32894h;
    }

    public final LiveData<String> M() {
        return this.f32895i;
    }

    public final void N() {
        this.f32893g.Y1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f32894h.a();
        Disposable disposable = this.f32896j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
