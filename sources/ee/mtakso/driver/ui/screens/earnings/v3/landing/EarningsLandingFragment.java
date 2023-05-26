package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityChartItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityProgressItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityTextItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityTextWithImageItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsBalanceItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingState;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsPieChartItemDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.modal.ModalAction;
import ee.mtakso.driver.ui.screens.modal.ModalDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SubtitleItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpanMarginDecoration;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpanSizeProvider;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsLandingFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsLandingFragment extends BazeMvvmFragment<EarningsLandingViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final DeeplinkDelegate f29314o;

    /* renamed from: p  reason: collision with root package name */
    private final EarningsLandingMapper f29315p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverFeatures f29316q;

    /* renamed from: r  reason: collision with root package name */
    private final ModalDelegate f29317r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f29318s;

    /* renamed from: t  reason: collision with root package name */
    private final int f29319t;

    /* renamed from: u  reason: collision with root package name */
    private final int f29320u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f29321v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public EarningsLandingFragment(BaseUiDependencies dependencies, DeeplinkDelegate deeplinkDelegate, EarningsLandingMapper mapper, DriverFeatures features, ModalDelegate modalDelegate) {
        super(dependencies, R.layout.fragment_earnings_landing, null, 4, null);
        Lazy b8;
        Intrinsics.f(dependencies, "dependencies");
        Intrinsics.f(deeplinkDelegate, "deeplinkDelegate");
        Intrinsics.f(mapper, "mapper");
        Intrinsics.f(features, "features");
        Intrinsics.f(modalDelegate, "modalDelegate");
        this.f29321v = new LinkedHashMap();
        this.f29314o = deeplinkDelegate;
        this.f29315p = mapper;
        this.f29316q = features;
        this.f29317r = modalDelegate;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$adapter$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsLandingFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$adapter$2$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<EarningsPieChartItemDelegate.Model, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, EarningsLandingFragment.class, "onBreakdownLinkClicked", "onBreakdownLinkClicked(Lee/mtakso/driver/ui/screens/earnings/v3/landing/EarningsPieChartItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningsPieChartItemDelegate.Model model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(EarningsPieChartItemDelegate.Model p02) {
                    Intrinsics.f(p02, "p0");
                    ((EarningsLandingFragment) this.f50989g).n0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsLandingFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$adapter$2$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<EarningsBalanceItemDelegate.Model, Unit> {
                AnonymousClass2(Object obj) {
                    super(1, obj, EarningsLandingFragment.class, "onBalanceClicked", "onBalanceClicked(Lee/mtakso/driver/ui/screens/earnings/v3/landing/EarningsBalanceItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningsBalanceItemDelegate.Model model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(EarningsBalanceItemDelegate.Model p02) {
                    Intrinsics.f(p02, "p0");
                    ((EarningsLandingFragment) this.f50989g).m0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsLandingFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$adapter$2$3  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<EarningsActivityChartItemDelegate.Model, Unit> {
                AnonymousClass3(Object obj) {
                    super(1, obj, EarningsLandingFragment.class, "onActivityChartClicked", "onActivityChartClicked(Lee/mtakso/driver/ui/screens/earnings/v3/landing/EarningsActivityChartItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningsActivityChartItemDelegate.Model model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(EarningsActivityChartItemDelegate.Model p02) {
                    Intrinsics.f(p02, "p0");
                    ((EarningsLandingFragment) this.f50989g).i0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsLandingFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$adapter$2$4  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<EarningsActivityTextItemDelegate.Model, Unit> {
                AnonymousClass4(Object obj) {
                    super(1, obj, EarningsLandingFragment.class, "onActivityTextClicked", "onActivityTextClicked(Lee/mtakso/driver/ui/screens/earnings/v3/landing/EarningsActivityTextItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningsActivityTextItemDelegate.Model model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(EarningsActivityTextItemDelegate.Model p02) {
                    Intrinsics.f(p02, "p0");
                    ((EarningsLandingFragment) this.f50989g).k0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsLandingFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$adapter$2$5  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<EarningsActivityTextWithImageItemDelegate.Model, Unit> {
                AnonymousClass5(Object obj) {
                    super(1, obj, EarningsLandingFragment.class, "onActivityTextWithImageClicked", "onActivityTextWithImageClicked(Lee/mtakso/driver/ui/screens/earnings/v3/landing/EarningsActivityTextWithImageItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningsActivityTextWithImageItemDelegate.Model model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(EarningsActivityTextWithImageItemDelegate.Model p02) {
                    Intrinsics.f(p02, "p0");
                    ((EarningsLandingFragment) this.f50989g).l0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EarningsLandingFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$adapter$2$6  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<EarningsActivityProgressItemDelegate.Model, Unit> {
                AnonymousClass6(Object obj) {
                    super(1, obj, EarningsLandingFragment.class, "onActivityProgressClicked", "onActivityProgressClicked(Lee/mtakso/driver/ui/screens/earnings/v3/landing/EarningsActivityProgressItemDelegate$Model;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningsActivityProgressItemDelegate.Model model) {
                    j(model);
                    return Unit.f50853a;
                }

                public final void j(EarningsActivityProgressItemDelegate.Model p02) {
                    Intrinsics.f(p02, "p0");
                    ((EarningsLandingFragment) this.f50989g).j0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                return new DiffAdapter().P(new EarningsPieChartItemDelegate(new AnonymousClass1(EarningsLandingFragment.this))).P(new EarningsBalanceItemDelegate(new AnonymousClass2(EarningsLandingFragment.this))).P(new EarningsActivityChartItemDelegate(new AnonymousClass3(EarningsLandingFragment.this))).P(new EarningsActivityTextItemDelegate(new AnonymousClass4(EarningsLandingFragment.this))).P(new EarningsActivityTextWithImageItemDelegate(new AnonymousClass5(EarningsLandingFragment.this))).P(new EarningsActivityProgressItemDelegate(new AnonymousClass6(EarningsLandingFragment.this))).P(new StaticItemDelegate(R.layout.delegate_item_earnings_pie_chart_stub)).P(new StaticItemDelegate(R.layout.delegate_item_subtitle_stub)).P(new StaticItemDelegate(R.layout.delegate_item_earnings_balance_stub)).P(new StaticItemDelegate(R.layout.delegate_item_earnings_activity_chart_stub)).P(new StaticItemDelegate(R.layout.delegate_item_earnings_activity_text_stub)).P(new SubtitleItemDelegate());
            }
        });
        this.f29318s = b8;
        this.f29319t = 2;
        this.f29320u = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiffAdapter g0() {
        return (DiffAdapter) this.f29318s.getValue();
    }

    private final Navigator h0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(EarningsActivityChartItemDelegate.Model model) {
        String o8 = model.o();
        if (o8 != null) {
            DeeplinkDelegate.f(this.f29314o, o8, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(EarningsActivityProgressItemDelegate.Model model) {
        String n8 = model.n();
        if (n8 != null) {
            DeeplinkDelegate.f(this.f29314o, n8, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(EarningsActivityTextItemDelegate.Model model) {
        String n8 = model.n();
        if (n8 != null) {
            DeeplinkDelegate.f(this.f29314o, n8, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(EarningsActivityTextWithImageItemDelegate.Model model) {
        String o8 = model.o();
        if (o8 != null) {
            DeeplinkDelegate.f(this.f29314o, o8, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(EarningsBalanceItemDelegate.Model model) {
        String q8 = model.q();
        if (q8 != null) {
            DeeplinkDelegate.f(this.f29314o, q8, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(EarningsPieChartItemDelegate.Model model) {
        String q8 = model.q();
        if (q8 != null) {
            DeeplinkDelegate.f(this.f29314o, q8, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(EarningsLandingFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f29321v.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f29320u);
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29321v;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f29317r.g(this, new Function1<ModalAction, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ModalAction payload) {
                EarningsLandingViewModel M;
                DeeplinkDelegate deeplinkDelegate;
                Intrinsics.f(payload, "payload");
                String b8 = payload.b();
                if (b8 != null) {
                    deeplinkDelegate = EarningsLandingFragment.this.f29314o;
                    DeeplinkDelegate.f(deeplinkDelegate, b8, null, 2, null);
                }
                M = EarningsLandingFragment.this.M();
                M.L(payload);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModalAction modalAction) {
                b(modalAction);
                return Unit.f50853a;
            }
        });
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        h0().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.current_week_earnings, null, 2, null), false, null, null, new Color.Attr(R.attr.backTertiary), null, null, null, 477, null));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), this.f29319t);
        gridLayoutManager.p3(new SpanSizeProvider(this.f29319t, g0()));
        int i8 = R.id.H9;
        ((RecyclerView) U(i8)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) U(i8)).setAdapter(g0());
        ((RecyclerView) U(i8)).h(new SpanMarginDecoration(this.f29319t));
        if (this.f29316q.w()) {
            ((RecyclerView) U(i8)).setItemAnimator(new EarningsLandingItemAnimator());
        }
        ((RoundButton) U(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EarningsLandingFragment.o0(EarningsLandingFragment.this, view2);
            }
        });
        LiveData<EarningsLandingState> O = M().O();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<EarningsLandingState, Unit> function1 = new Function1<EarningsLandingState, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsLandingState earningsLandingState) {
                DiffAdapter g02;
                List k8;
                DiffAdapter g03;
                EarningsLandingMapper earningsLandingMapper;
                DiffAdapter g04;
                List k9;
                DiffAdapter g05;
                EarningsLandingMapper earningsLandingMapper2;
                if (earningsLandingState instanceof EarningsLandingState.Loading) {
                    View errorView = EarningsLandingFragment.this.U(R.id.errorView);
                    Intrinsics.e(errorView, "errorView");
                    ViewExtKt.d(errorView, false, 0, 2, null);
                    ((RoundButton) EarningsLandingFragment.this.U(R.id.O9)).g();
                    g05 = EarningsLandingFragment.this.g0();
                    earningsLandingMapper2 = EarningsLandingFragment.this.f29315p;
                    DiffAdapter.V(g05, earningsLandingMapper2.a(null), null, 2, null);
                } else if (earningsLandingState instanceof EarningsLandingState.Retrying) {
                    View errorView2 = EarningsLandingFragment.this.U(R.id.errorView);
                    Intrinsics.e(errorView2, "errorView");
                    ViewExtKt.d(errorView2, false, 0, 3, null);
                    ((RoundButton) EarningsLandingFragment.this.U(R.id.O9)).k();
                    g04 = EarningsLandingFragment.this.g0();
                    k9 = CollectionsKt__CollectionsKt.k();
                    DiffAdapter.V(g04, k9, null, 2, null);
                } else if (earningsLandingState instanceof EarningsLandingState.Ready) {
                    View errorView3 = EarningsLandingFragment.this.U(R.id.errorView);
                    Intrinsics.e(errorView3, "errorView");
                    ViewExtKt.d(errorView3, false, 0, 2, null);
                    ((RoundButton) EarningsLandingFragment.this.U(R.id.O9)).g();
                    g03 = EarningsLandingFragment.this.g0();
                    earningsLandingMapper = EarningsLandingFragment.this.f29315p;
                    DiffAdapter.V(g03, earningsLandingMapper.a(((EarningsLandingState.Ready) earningsLandingState).a()), null, 2, null);
                } else if (earningsLandingState instanceof EarningsLandingState.Error) {
                    View errorView4 = EarningsLandingFragment.this.U(R.id.errorView);
                    Intrinsics.e(errorView4, "errorView");
                    ViewExtKt.d(errorView4, false, 0, 3, null);
                    ((RoundButton) EarningsLandingFragment.this.U(R.id.O9)).g();
                    g02 = EarningsLandingFragment.this.g0();
                    k8 = CollectionsKt__CollectionsKt.k();
                    DiffAdapter.V(g02, k8, null, 2, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsLandingState earningsLandingState) {
                b(earningsLandingState);
                return Unit.f50853a;
            }
        };
        O.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsLandingFragment.p0(Function1.this, obj);
            }
        });
        LiveData<EarningsModal> P = M().P();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<EarningsModal, Unit> function12 = new Function1<EarningsModal, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsModal earningsModal) {
                ModalDelegate modalDelegate;
                modalDelegate = EarningsLandingFragment.this.f29317r;
                modalDelegate.k(EarningsLandingFragment.this, null, earningsModal.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsModal earningsModal) {
                b(earningsModal);
                return Unit.f50853a;
            }
        };
        P.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EarningsLandingFragment.q0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: r0 */
    public EarningsLandingViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (EarningsLandingViewModel) new ViewModelProvider(this, E.d()).a(EarningsLandingViewModel.class);
    }
}
