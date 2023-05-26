package ee.mtakso.driver.ui.screens.support;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.network.client.support.SupportWebAppLinkResponse;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportViewModel.kt */
/* loaded from: classes5.dex */
public final class SupportViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final WebViewTracker f33458f;

    /* renamed from: g  reason: collision with root package name */
    private final Features f33459g;

    /* renamed from: h  reason: collision with root package name */
    private final SupportClient f33460h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f33461i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<String> f33462j;

    @Inject
    public SupportViewModel(WebViewTracker webViewTracker, Features features, SupportClient supportClient) {
        Intrinsics.f(webViewTracker, "webViewTracker");
        Intrinsics.f(features, "features");
        Intrinsics.f(supportClient, "supportClient");
        this.f33458f = webViewTracker;
        this.f33459g = features;
        this.f33460h = supportClient;
        this.f33462j = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
        this.f33458f.b();
    }

    public final Features I() {
        return this.f33459g;
    }

    public final WebViewTracker J() {
        return this.f33458f;
    }

    public final void K(String webAppLaunchToken) {
        Intrinsics.f(webAppLaunchToken, "webAppLaunchToken");
        Single d8 = SingleExtKt.d(this.f33460h.m(webAppLaunchToken));
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.support.SupportViewModel$loadSupportWebAppLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = SupportViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = d8.n(new Consumer() { // from class: ee.mtakso.driver.ui.screens.support.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SupportViewModel.L(Function1.this, obj);
            }
        });
        final Function1<SupportWebAppLinkResponse, Unit> function12 = new Function1<SupportWebAppLinkResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.support.SupportViewModel$loadSupportWebAppLink$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SupportWebAppLinkResponse supportWebAppLinkResponse) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                y7 = SupportViewModel.this.y();
                y7.o(Boolean.FALSE);
                mutableLiveData = SupportViewModel.this.f33462j;
                mutableLiveData.o(supportWebAppLinkResponse.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SupportWebAppLinkResponse supportWebAppLinkResponse) {
                b(supportWebAppLinkResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.support.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SupportViewModel.M(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.support.SupportViewModel$loadSupportWebAppLink$3
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
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to load the support webapp URL!");
                y7 = SupportViewModel.this.y();
                y7.o(Boolean.FALSE);
                BaseViewModel.A(SupportViewModel.this, it, null, 2, null);
            }
        };
        this.f33461i = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.support.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SupportViewModel.N(Function1.this, obj);
            }
        });
    }

    public final LiveData<String> O() {
        return this.f33462j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f33461i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f33458f.a();
    }
}
