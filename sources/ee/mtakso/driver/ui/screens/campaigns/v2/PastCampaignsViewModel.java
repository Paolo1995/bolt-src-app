package ee.mtakso.driver.ui.screens.campaigns.v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CampaignV2Group;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastCampaignsViewModel.kt */
/* loaded from: classes3.dex */
public final class PastCampaignsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CampaignClient f27353f;

    /* renamed from: g  reason: collision with root package name */
    private final CampaignAnalytics f27354g;

    /* renamed from: h  reason: collision with root package name */
    private final CampaignFactory f27355h;

    /* renamed from: i  reason: collision with root package name */
    private final int f27356i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<PastCampaignsState> f27357j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<PastCampaignsFilter, PastCampaignsState> f27358k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f27359l;

    @Inject
    public PastCampaignsViewModel(CampaignClient campaignClient, CampaignAnalytics campaignAnalytics, CampaignFactory campaignFactory) {
        List k8;
        List k9;
        Intrinsics.f(campaignClient, "campaignClient");
        Intrinsics.f(campaignAnalytics, "campaignAnalytics");
        Intrinsics.f(campaignFactory, "campaignFactory");
        this.f27353f = campaignClient;
        this.f27354g = campaignAnalytics;
        this.f27355h = campaignFactory;
        this.f27356i = 20;
        PastCampaignsFilter pastCampaignsFilter = PastCampaignsFilter.ALL;
        k8 = CollectionsKt__CollectionsKt.k();
        k9 = CollectionsKt__CollectionsKt.k();
        this.f27357j = new MutableLiveData<>(new PastCampaignsState(pastCampaignsFilter, k8, k9, false));
        this.f27358k = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource N(PastCampaignsState pastCampaignsState, PastCampaignsViewModel this$0) {
        int v7;
        int y02;
        Intrinsics.f(this$0, "this$0");
        List<CampaignV2Group> f8 = pastCampaignsState.f();
        v7 = CollectionsKt__IterablesKt.v(f8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (CampaignV2Group campaignV2Group : f8) {
            arrayList.add(Integer.valueOf(campaignV2Group.c().size()));
        }
        y02 = CollectionsKt___CollectionsKt.y0(arrayList);
        return this$0.f27353f.v(pastCampaignsState.d().f(), y02, this$0.f27356i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PastCampaignsState O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (PastCampaignsState) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        M();
    }

    public final void L(PastCampaignsFilter filter) {
        List k8;
        List k9;
        Intrinsics.f(filter, "filter");
        if (((PastCampaignsState) LiveDataExtKt.b(this.f27357j)).d() == filter) {
            return;
        }
        Disposable disposable = this.f27359l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        MutableLiveData<PastCampaignsState> mutableLiveData = this.f27357j;
        PastCampaignsState pastCampaignsState = this.f27358k.get(filter);
        if (pastCampaignsState == null) {
            k8 = CollectionsKt__CollectionsKt.k();
            k9 = CollectionsKt__CollectionsKt.k();
            pastCampaignsState = new PastCampaignsState(filter, k8, k9, false);
        }
        mutableLiveData.o(pastCampaignsState);
        M();
    }

    public final void M() {
        if (!DisposableExtKt.b(this.f27359l)) {
            return;
        }
        final PastCampaignsState pastCampaignsState = (PastCampaignsState) LiveDataExtKt.b(this.f27357j);
        if (pastCampaignsState.e()) {
            return;
        }
        Single g8 = Single.g(new Callable() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.u
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SingleSource N;
                N = PastCampaignsViewModel.N(PastCampaignsState.this, this);
                return N;
            }
        });
        final PastCampaignsViewModel$loadNextPage$2 pastCampaignsViewModel$loadNextPage$2 = new PastCampaignsViewModel$loadNextPage$2(pastCampaignsState, this);
        Single x7 = g8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.v
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PastCampaignsState O;
                O = PastCampaignsViewModel.O(Function1.this, obj);
                return O;
            }
        });
        Intrinsics.e(x7, "fun loadNextPage() {\n   …    }\n            )\n    }");
        Single l8 = l(SingleExtKt.d(x7));
        final Function1<PastCampaignsState, Unit> function1 = new Function1<PastCampaignsState, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsViewModel$loadNextPage$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PastCampaignsState it) {
                Map map;
                MutableLiveData mutableLiveData;
                map = PastCampaignsViewModel.this.f27358k;
                PastCampaignsFilter d8 = it.d();
                Intrinsics.e(it, "it");
                map.put(d8, it);
                mutableLiveData = PastCampaignsViewModel.this.f27357j;
                mutableLiveData.o(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PastCampaignsState pastCampaignsState2) {
                b(pastCampaignsState2);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PastCampaignsViewModel.P(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsViewModel$loadNextPage$4
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
                Intrinsics.e(it, "it");
                Kalev.m(it, "Failed to load initial past campaigns page");
                BaseViewModel.A(PastCampaignsViewModel.this, it, null, 2, null);
            }
        };
        this.f27359l = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PastCampaignsViewModel.Q(Function1.this, obj);
            }
        });
    }

    public final LiveData<PastCampaignsState> R() {
        return this.f27357j;
    }

    public final void S(long j8) {
        this.f27354g.M1(j8);
    }

    public final void T() {
        this.f27354g.v2();
    }

    public final void U() {
        this.f27354g.a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f27359l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
