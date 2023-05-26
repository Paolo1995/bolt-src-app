package ee.mtakso.driver.ui.screens.boltclub;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.boltclub.model.BoltClubOffersResponse;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubViewModel.kt */
/* loaded from: classes3.dex */
public final class BoltClubViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final BoltClubClient f27166f;

    /* renamed from: g  reason: collision with root package name */
    private final BoltClubDataMapper f27167g;

    /* renamed from: h  reason: collision with root package name */
    private final LanguageManager f27168h;

    /* renamed from: i  reason: collision with root package name */
    private final CompositeUrlLauncher f27169i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f27170j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<BoltClubOffersState> f27171k;

    /* renamed from: l  reason: collision with root package name */
    private String f27172l;

    @Inject
    public BoltClubViewModel(BoltClubClient boltClubClient, BoltClubDataMapper boltClubDataMapper, LanguageManager languageManager, CompositeUrlLauncher urlLauncher) {
        Intrinsics.f(boltClubClient, "boltClubClient");
        Intrinsics.f(boltClubDataMapper, "boltClubDataMapper");
        Intrinsics.f(languageManager, "languageManager");
        Intrinsics.f(urlLauncher, "urlLauncher");
        this.f27166f = boltClubClient;
        this.f27167g = boltClubDataMapper;
        this.f27168h = languageManager;
        this.f27169i = urlLauncher;
        this.f27171k = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoltClubOffersState I(BoltClubOffersResponse boltClubOffersResponse) {
        return new BoltClubOffersState(boltClubOffersResponse.e(), this.f27167g.c(boltClubOffersResponse), boltClubOffersResponse.a(), boltClubOffersResponse.c());
    }

    private final void J(String str) {
        Single<BoltClubOffersResponse> c8 = this.f27166f.c(str);
        final Function1<BoltClubOffersResponse, BoltClubOffersState> function1 = new Function1<BoltClubOffersResponse, BoltClubOffersState>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubViewModel$loadLoyaltyOffers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final BoltClubOffersState invoke(BoltClubOffersResponse it) {
                BoltClubOffersState I;
                Intrinsics.f(it, "it");
                I = BoltClubViewModel.this.I(it);
                return I;
            }
        };
        Single<R> x7 = c8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.boltclub.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BoltClubOffersState K;
                K = BoltClubViewModel.K(Function1.this, obj);
                return K;
            }
        });
        Intrinsics.e(x7, "private fun loadLoyaltyO…tate\n            }\n\n    }");
        Single l8 = l(SingleExtKt.d(x7));
        final BoltClubViewModel$loadLoyaltyOffers$2 boltClubViewModel$loadLoyaltyOffers$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubViewModel$loadLoyaltyOffers$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Kalev.d("Failed to load offers list");
            }
        };
        Single l9 = l8.l(new Consumer() { // from class: ee.mtakso.driver.ui.screens.boltclub.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BoltClubViewModel.L(Function1.this, obj);
            }
        });
        final Function1<BoltClubOffersState, Unit> function12 = new Function1<BoltClubOffersState, Unit>() { // from class: ee.mtakso.driver.ui.screens.boltclub.BoltClubViewModel$loadLoyaltyOffers$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BoltClubOffersState boltClubOffersState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = BoltClubViewModel.this.f27171k;
                mutableLiveData.o(boltClubOffersState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BoltClubOffersState boltClubOffersState) {
                b(boltClubOffersState);
                return Unit.f50853a;
            }
        };
        this.f27170j = l9.H(new Consumer() { // from class: ee.mtakso.driver.ui.screens.boltclub.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BoltClubViewModel.M(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoltClubOffersState K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (BoltClubOffersState) tmp0.invoke(obj);
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        String b8 = this.f27168h.f().b();
        this.f27172l = b8;
        if (b8 == null) {
            Intrinsics.w("language");
            b8 = null;
        }
        J(b8);
    }

    public final LiveData<BoltClubOffersState> N() {
        return this.f27171k;
    }

    public final void O(String faqLink) {
        Intrinsics.f(faqLink, "faqLink");
        this.f27169i.a(faqLink);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f27170j;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
