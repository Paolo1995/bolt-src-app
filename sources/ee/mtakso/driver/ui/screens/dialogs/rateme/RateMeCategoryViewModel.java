package ee.mtakso.driver.ui.screens.dialogs.rateme;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.RateMeTracing;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.interactor.rateme.RateMeCategory;
import ee.mtakso.driver.ui.interactor.rateme.RateMeFetchCategoriesInteractor;
import ee.mtakso.driver.ui.interactor.rateme.RateMeItem;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeCategoryViewModel.kt */
/* loaded from: classes3.dex */
public final class RateMeCategoryViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final RateMeFetchCategoriesInteractor f28337f;

    /* renamed from: g  reason: collision with root package name */
    private final RateMeAnalytics f28338g;

    /* renamed from: h  reason: collision with root package name */
    private final RateMeTracing f28339h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f28340i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<RateMeCategoryScreenState> f28341j;

    @Inject
    public RateMeCategoryViewModel(RateMeFetchCategoriesInteractor rateMeFetchCategoriesInteractor, RateMeAnalytics rateMeAnalytics, RateMeTracing rateMeTracing) {
        Intrinsics.f(rateMeFetchCategoriesInteractor, "rateMeFetchCategoriesInteractor");
        Intrinsics.f(rateMeAnalytics, "rateMeAnalytics");
        Intrinsics.f(rateMeTracing, "rateMeTracing");
        this.f28337f = rateMeFetchCategoriesInteractor;
        this.f28338g = rateMeAnalytics;
        this.f28339h = rateMeTracing;
        this.f28341j = new MutableLiveData<>();
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

    private final RateMeCategoryScreenState M(RateMeCategoryScreenState rateMeCategoryScreenState, RateMeCategory rateMeCategory, RateMeItem rateMeItem) {
        boolean z7;
        List<RateMeItem> c8;
        boolean P;
        if (rateMeCategory != null && (c8 = rateMeCategory.c()) != null) {
            P = CollectionsKt___CollectionsKt.P(c8, rateMeItem);
            if (P) {
                z7 = true;
                return RateMeCategoryScreenState.b(rateMeCategoryScreenState, null, rateMeCategory, rateMeItem, z7, 1, null);
            }
        }
        z7 = false;
        return RateMeCategoryScreenState.b(rateMeCategoryScreenState, null, rateMeCategory, rateMeItem, z7, 1, null);
    }

    static /* synthetic */ RateMeCategoryScreenState N(RateMeCategoryViewModel rateMeCategoryViewModel, RateMeCategoryScreenState rateMeCategoryScreenState, RateMeCategory rateMeCategory, RateMeItem rateMeItem, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            rateMeCategory = rateMeCategoryScreenState.e();
        }
        if ((i8 & 2) != 0) {
            rateMeItem = rateMeCategoryScreenState.f();
        }
        return rateMeCategoryViewModel.M(rateMeCategoryScreenState, rateMeCategory, rateMeItem);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        List<RateMeCategory> c8;
        RateMeCategoryScreenState f8 = this.f28341j.f();
        boolean z7 = false;
        if (f8 != null && (c8 = f8.c()) != null && (!c8.isEmpty())) {
            z7 = true;
        }
        if (!z7) {
            Single d8 = SingleExtKt.d(this.f28337f.b());
            final Function1<List<? extends RateMeCategory>, Unit> function1 = new Function1<List<? extends RateMeCategory>, Unit>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel$onStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(List<RateMeCategory> it) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    mutableLiveData = RateMeCategoryViewModel.this.f28341j;
                    RateMeCategoryViewModel.RateMeCategoryScreenState rateMeCategoryScreenState = (RateMeCategoryViewModel.RateMeCategoryScreenState) mutableLiveData.f();
                    if (rateMeCategoryScreenState == null) {
                        rateMeCategoryScreenState = new RateMeCategoryViewModel.RateMeCategoryScreenState(null, null, null, false, 15, null);
                    }
                    RateMeCategoryViewModel.RateMeCategoryScreenState rateMeCategoryScreenState2 = rateMeCategoryScreenState;
                    mutableLiveData2 = RateMeCategoryViewModel.this.f28341j;
                    Intrinsics.e(it, "it");
                    mutableLiveData2.o(RateMeCategoryViewModel.RateMeCategoryScreenState.b(rateMeCategoryScreenState2, it, null, null, false, 14, null));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends RateMeCategory> list) {
                    b(list);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RateMeCategoryViewModel.J(Function1.this, obj);
                }
            };
            final RateMeCategoryViewModel$onStart$2 rateMeCategoryViewModel$onStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel$onStart$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable err) {
                    Intrinsics.e(err, "err");
                    Kalev.e(err, "Erorr fetching settings data");
                }
            };
            this.f28340i = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.dialogs.rateme.f
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RateMeCategoryViewModel.K(Function1.this, obj);
                }
            });
        }
    }

    public final LiveData<RateMeCategoryScreenState> G() {
        return this.f28341j;
    }

    public final void H(RateMeCategory rateMeCategory) {
        if (this.f28341j.f() == null) {
            return;
        }
        RateMeCategory e8 = ((RateMeCategoryScreenState) LiveDataExtKt.b(this.f28341j)).e();
        MutableLiveData<RateMeCategoryScreenState> mutableLiveData = this.f28341j;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "ratemeStateLiveData.requireValue()");
        mutableLiveData.o(N(this, (RateMeCategoryScreenState) b8, rateMeCategory, null, 2, null));
        if (e8 != null && !Intrinsics.a(e8, rateMeCategory)) {
            this.f28339h.d(e8.a());
        }
        if (rateMeCategory != null) {
            this.f28339h.f(rateMeCategory.a());
        }
    }

    public final void I(RateMeItem rateMeItem) {
        MutableLiveData<RateMeCategoryScreenState> mutableLiveData = this.f28341j;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "ratemeStateLiveData.requireValue()");
        mutableLiveData.o(N(this, (RateMeCategoryScreenState) b8, null, rateMeItem, 1, null));
    }

    public final void L() {
        RateMeItem f8;
        String a8;
        RateMeCategory e8;
        RateMeCategoryScreenState f9 = this.f28341j.f();
        RateMeAnalytics rateMeAnalytics = this.f28338g;
        String str = "";
        String str2 = (f9 == null || (e8 = f9.e()) == null || (str2 = e8.a()) == null) ? "" : "";
        if (f9 != null && (f8 = f9.f()) != null && (a8 = f8.a()) != null) {
            str = a8;
        }
        rateMeAnalytics.V0(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28340i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    /* compiled from: RateMeCategoryViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class RateMeCategoryScreenState {

        /* renamed from: a  reason: collision with root package name */
        private final List<RateMeCategory> f28342a;

        /* renamed from: b  reason: collision with root package name */
        private final RateMeCategory f28343b;

        /* renamed from: c  reason: collision with root package name */
        private final RateMeItem f28344c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f28345d;

        public RateMeCategoryScreenState() {
            this(null, null, null, false, 15, null);
        }

        public RateMeCategoryScreenState(List<RateMeCategory> categories, RateMeCategory rateMeCategory, RateMeItem rateMeItem, boolean z7) {
            Intrinsics.f(categories, "categories");
            this.f28342a = categories;
            this.f28343b = rateMeCategory;
            this.f28344c = rateMeItem;
            this.f28345d = z7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RateMeCategoryScreenState b(RateMeCategoryScreenState rateMeCategoryScreenState, List list, RateMeCategory rateMeCategory, RateMeItem rateMeItem, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                list = rateMeCategoryScreenState.f28342a;
            }
            if ((i8 & 2) != 0) {
                rateMeCategory = rateMeCategoryScreenState.f28343b;
            }
            if ((i8 & 4) != 0) {
                rateMeItem = rateMeCategoryScreenState.f28344c;
            }
            if ((i8 & 8) != 0) {
                z7 = rateMeCategoryScreenState.f28345d;
            }
            return rateMeCategoryScreenState.a(list, rateMeCategory, rateMeItem, z7);
        }

        public final RateMeCategoryScreenState a(List<RateMeCategory> categories, RateMeCategory rateMeCategory, RateMeItem rateMeItem, boolean z7) {
            Intrinsics.f(categories, "categories");
            return new RateMeCategoryScreenState(categories, rateMeCategory, rateMeItem, z7);
        }

        public final List<RateMeCategory> c() {
            return this.f28342a;
        }

        public final boolean d() {
            return this.f28345d;
        }

        public final RateMeCategory e() {
            return this.f28343b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RateMeCategoryScreenState) {
                RateMeCategoryScreenState rateMeCategoryScreenState = (RateMeCategoryScreenState) obj;
                return Intrinsics.a(this.f28342a, rateMeCategoryScreenState.f28342a) && Intrinsics.a(this.f28343b, rateMeCategoryScreenState.f28343b) && Intrinsics.a(this.f28344c, rateMeCategoryScreenState.f28344c) && this.f28345d == rateMeCategoryScreenState.f28345d;
            }
            return false;
        }

        public final RateMeItem f() {
            return this.f28344c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f28342a.hashCode() * 31;
            RateMeCategory rateMeCategory = this.f28343b;
            int hashCode2 = (hashCode + (rateMeCategory == null ? 0 : rateMeCategory.hashCode())) * 31;
            RateMeItem rateMeItem = this.f28344c;
            int hashCode3 = (hashCode2 + (rateMeItem != null ? rateMeItem.hashCode() : 0)) * 31;
            boolean z7 = this.f28345d;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode3 + i8;
        }

        public String toString() {
            List<RateMeCategory> list = this.f28342a;
            RateMeCategory rateMeCategory = this.f28343b;
            RateMeItem rateMeItem = this.f28344c;
            boolean z7 = this.f28345d;
            return "RateMeCategoryScreenState(categories=" + list + ", selectedCategory=" + rateMeCategory + ", selectedItem=" + rateMeItem + ", readyToSend=" + z7 + ")";
        }

        public /* synthetic */ RateMeCategoryScreenState(List list, RateMeCategory rateMeCategory, RateMeItem rateMeItem, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i8 & 2) != 0 ? null : rateMeCategory, (i8 & 4) != 0 ? null : rateMeItem, (i8 & 8) != 0 ? false : z7);
        }
    }
}
