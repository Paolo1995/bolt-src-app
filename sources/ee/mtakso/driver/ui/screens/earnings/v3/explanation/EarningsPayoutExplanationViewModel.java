package ee.mtakso.driver.ui.screens.earnings.v3.explanation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.earnings.network.DriverInfoBlock;
import eu.bolt.driver.earnings.network.EarningPayoutExplanationResponse;
import eu.bolt.driver.earnings.network.EarningsClient;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsPayoutExplanationViewModel.kt */
/* loaded from: classes3.dex */
public final class EarningsPayoutExplanationViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsClient f29081f;

    /* renamed from: g  reason: collision with root package name */
    private final HtmlEngine f29082g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverInfoBlockMapper f29083h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<EarningsPayoutExplanationState> f29084i;

    @Inject
    public EarningsPayoutExplanationViewModel(EarningsClient earningsClient, HtmlEngine htmlEngine, DriverInfoBlockMapper infoBlockMapper) {
        Intrinsics.f(earningsClient, "earningsClient");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(infoBlockMapper, "infoBlockMapper");
        this.f29081f = earningsClient;
        this.f29082g = htmlEngine;
        this.f29083h = infoBlockMapper;
        this.f29084i = new MutableLiveData<>(new EarningsPayoutExplanationState(null, null, null, 7, null));
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
        Single l8 = l(SingleExtKt.d(this.f29081f.e()));
        final Function1<EarningPayoutExplanationResponse, Unit> function1 = new Function1<EarningPayoutExplanationResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningPayoutExplanationResponse earningPayoutExplanationResponse) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                int v7;
                int v8;
                DriverInfoBlockMapper driverInfoBlockMapper;
                int m8;
                DividerModel dividerModel;
                HtmlEngine htmlEngine;
                mutableLiveData = EarningsPayoutExplanationViewModel.this.f29084i;
                mutableLiveData2 = EarningsPayoutExplanationViewModel.this.f29084i;
                EarningsPayoutExplanationState earningsPayoutExplanationState = (EarningsPayoutExplanationState) LiveDataExtKt.b(mutableLiveData2);
                Text.Value value = new Text.Value(earningPayoutExplanationResponse.c());
                List<String> b8 = earningPayoutExplanationResponse.b();
                EarningsPayoutExplanationViewModel earningsPayoutExplanationViewModel = EarningsPayoutExplanationViewModel.this;
                v7 = CollectionsKt__IterablesKt.v(b8, 10);
                ArrayList arrayList = new ArrayList(v7);
                int i8 = 0;
                for (Object obj : b8) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    String str = (String) obj;
                    m8 = CollectionsKt__CollectionsKt.m(earningPayoutExplanationResponse.b());
                    if (i8 == m8) {
                        dividerModel = new Divider(false, false, false, null, null, Float.valueOf(Dimens.b(6.0f)), 31, null);
                    } else {
                        dividerModel = NoDivider.f34829a;
                    }
                    Text.Value value2 = new Text.Value(String.valueOf(i9));
                    htmlEngine = earningsPayoutExplanationViewModel.f29082g;
                    arrayList.add(new EarningsPayoutExplanationDelegate.Model("explanation_" + i8, value2, new Text.Value(htmlEngine.a(str)), dividerModel));
                    i8 = i9;
                }
                List<DriverInfoBlock> a8 = earningPayoutExplanationResponse.a();
                EarningsPayoutExplanationViewModel earningsPayoutExplanationViewModel2 = EarningsPayoutExplanationViewModel.this;
                v8 = CollectionsKt__IterablesKt.v(a8, 10);
                ArrayList arrayList2 = new ArrayList(v8);
                int i10 = 0;
                for (Object obj2 : a8) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    driverInfoBlockMapper = earningsPayoutExplanationViewModel2.f29083h;
                    arrayList2.add(driverInfoBlockMapper.b("info_block_" + i10, (DriverInfoBlock) obj2));
                    i10 = i11;
                }
                mutableLiveData.o(earningsPayoutExplanationState.a(value, arrayList, arrayList2));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningPayoutExplanationResponse earningPayoutExplanationResponse) {
                b(earningPayoutExplanationResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: s3.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsPayoutExplanationViewModel.J(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationViewModel$onStart$2
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
                EarningsPayoutExplanationViewModel earningsPayoutExplanationViewModel = EarningsPayoutExplanationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(earningsPayoutExplanationViewModel, it, null, 2, null);
            }
        };
        Disposable I = l8.I(consumer, new Consumer() { // from class: s3.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsPayoutExplanationViewModel.K(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "override fun onStart() {…     .autoDispose()\n    }");
        v(I);
    }

    public final LiveData<EarningsPayoutExplanationState> I() {
        return this.f29084i;
    }
}
