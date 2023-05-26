package ee.mtakso.driver.ui.screens.boltclub;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.boltclub.model.BoltClubOfferDetailsResponse;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubOfferDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class BoltClubOfferDetailsViewModel extends BaseViewModel {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f27144n = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final BoltClubClient f27145f;

    /* renamed from: g  reason: collision with root package name */
    private final BoltClubDataMapper f27146g;

    /* renamed from: h  reason: collision with root package name */
    private final LanguageManager f27147h;

    /* renamed from: i  reason: collision with root package name */
    private final CompositeUrlLauncher f27148i;

    /* renamed from: j  reason: collision with root package name */
    private final PartnerOffersAnalytics f27149j;

    /* renamed from: k  reason: collision with root package name */
    private String f27150k;

    /* renamed from: l  reason: collision with root package name */
    private CompositeDisposable f27151l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<BoltClubDetailsState> f27152m;

    /* compiled from: BoltClubOfferDetailsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public BoltClubOfferDetailsViewModel(BoltClubClient boltClubClient, BoltClubDataMapper boltClubDataMapper, LanguageManager languageManager, CompositeUrlLauncher urlLauncher, PartnerOffersAnalytics partnerOffersAnalytics) {
        Intrinsics.f(boltClubClient, "boltClubClient");
        Intrinsics.f(boltClubDataMapper, "boltClubDataMapper");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(partnerOffersAnalytics, "partnerOffersAnalytics");
        this.f27145f = boltClubClient;
        this.f27146g = boltClubDataMapper;
        this.f27147h = languageManager;
        this.f27148i = urlLauncher;
        this.f27149j = partnerOffersAnalytics;
        this.f27151l = new CompositeDisposable();
        this.f27152m = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoltClubDetailsState K(BoltClubOfferDetailsResponse boltClubOfferDetailsResponse) {
        return this.f27146g.b(boltClubOfferDetailsResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoltClubDetailsState M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (BoltClubDetailsState) tmp0.invoke(obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(BoltClubOfferDetailsViewModel this$0, boolean z7) {
        BoltClubDetailsState a8;
        Intrinsics.f(this$0, "this$0");
        MutableLiveData<BoltClubDetailsState> mutableLiveData = this$0.f27152m;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "offerDescription.requireValue()");
        a8 = r2.a((r16 & 1) != 0 ? r2.f27118a : 0L, (r16 & 2) != 0 ? r2.f27119b : null, (r16 & 4) != 0 ? r2.f27120c : null, (r16 & 8) != 0 ? r2.f27121d : null, (r16 & 16) != 0 ? r2.f27122e : z7, (r16 & 32) != 0 ? ((BoltClubDetailsState) b8).f27123f : false);
        mutableLiveData.o(a8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U(String str, boolean z7) {
        String str2;
        if (z7) {
            str2 = "Added";
        } else if (!z7) {
            str2 = "Removed";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.f27149j.i3(str, str2);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f27150k = this.f27147h.f().b();
    }

    public final void L(long j8, String theme) {
        Intrinsics.f(theme, "theme");
        CompositeDisposable compositeDisposable = this.f27151l;
        BoltClubClient boltClubClient = this.f27145f;
        String str = this.f27150k;
        if (str == null) {
            Intrinsics.w("language");
            str = null;
        }
        Single<BoltClubOfferDetailsResponse> e8 = boltClubClient.e(j8, str, theme);
        final Function1<BoltClubOfferDetailsResponse, BoltClubDetailsState> function1 = new Function1<BoltClubOfferDetailsResponse, BoltClubDetailsState>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsViewModel$loadOfferDescription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final BoltClubDetailsState invoke(BoltClubOfferDetailsResponse it) {
                BoltClubDetailsState K;
                Intrinsics.f(it, "it");
                K = BoltClubOfferDetailsViewModel.this.K(it);
                return K;
            }
        };
        Single<R> x7 = e8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.boltclub.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BoltClubDetailsState M;
                M = BoltClubOfferDetailsViewModel.M(Function1.this, obj);
                return M;
            }
        });
        Intrinsics.e(x7, "fun loadOfferDescription…ail\n            })\n\n    }");
        Single l8 = l(SingleExtKt.d(x7));
        final BoltClubOfferDetailsViewModel$loadOfferDescription$2 boltClubOfferDetailsViewModel$loadOfferDescription$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsViewModel$loadOfferDescription$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Kalev.d("Failed to load offer description");
            }
        };
        Single l9 = l8.l(new Consumer() { // from class: ee.mtakso.driver.ui.screens.boltclub.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BoltClubOfferDetailsViewModel.N(Function1.this, obj);
            }
        });
        final Function1<BoltClubDetailsState, Unit> function12 = new Function1<BoltClubDetailsState, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsViewModel$loadOfferDescription$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BoltClubDetailsState boltClubDetailsState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = BoltClubOfferDetailsViewModel.this.f27152m;
                mutableLiveData.o(boltClubDetailsState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BoltClubDetailsState boltClubDetailsState) {
                b(boltClubDetailsState);
                return Unit.f50853a;
            }
        };
        compositeDisposable.b(l9.H(new Consumer() { // from class: ee.mtakso.driver.ui.screens.boltclub.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BoltClubOfferDetailsViewModel.O(Function1.this, obj);
            }
        }));
    }

    public final LiveData<BoltClubDetailsState> P() {
        return this.f27152m;
    }

    public final void Q(final boolean z7) {
        BoltClubDetailsState boltClubDetailsState = (BoltClubDetailsState) LiveDataExtKt.b(this.f27152m);
        long e8 = boltClubDetailsState.e();
        String f8 = boltClubDetailsState.f();
        CompositeDisposable compositeDisposable = this.f27151l;
        Completable a8 = CompletableExtKt.a(this.f27145f.g(e8, z7));
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.boltclub.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                BoltClubOfferDetailsViewModel.R(BoltClubOfferDetailsViewModel.this, z7);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsViewModel$onFavouriteClicked$2
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
                BoltClubOfferDetailsViewModel boltClubOfferDetailsViewModel = BoltClubOfferDetailsViewModel.this;
                Intrinsics.e(it, "it");
                boltClubOfferDetailsViewModel.z(it, "Failed to set favourite");
            }
        };
        compositeDisposable.b(a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.boltclub.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BoltClubOfferDetailsViewModel.S(Function1.this, obj);
            }
        }));
        U(f8, z7);
    }

    public final void T(String url) {
        Intrinsics.f(url, "url");
        this.f27148i.a(url);
    }

    public final void V() {
        BoltClubDetailsState boltClubDetailsState = (BoltClubDetailsState) LiveDataExtKt.b(this.f27152m);
        String f8 = boltClubDetailsState.f();
        String c8 = boltClubDetailsState.c();
        if (c8 != null) {
            this.f27149j.I0(f8, c8);
        }
    }

    public final void W(String offerTitle) {
        Intrinsics.f(offerTitle, "offerTitle");
        this.f27149j.o0(offerTitle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        DisposableExtKt.a(this.f27151l);
    }
}
