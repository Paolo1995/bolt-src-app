package ee.mtakso.driver.ui.screens.score;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.GenericValue;
import ee.mtakso.driver.network.client.score.IssueItem;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.dialogs.InfoCopyDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.score.DriverScoreActionDelegate;
import ee.mtakso.driver.ui.screens.score.DriverScoreViewModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOptionTextDelegate;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreFragment.kt */
/* loaded from: classes3.dex */
public final class DriverScoreFragment extends BazeMvvmFragment<DriverScoreViewModel> {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f32903t = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final CompositeUrlLauncher f32904o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f32905p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f32906q;

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f32907r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f32908s;

    /* compiled from: DriverScoreFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("SHOW_ONBOARDING", true);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverScoreFragment(BaseUiDependencies deps, CompositeUrlLauncher urlLauncher) {
        super(deps, R.layout.fragment_driver_score, null, 4, null);
        Lazy b8;
        Lazy b9;
        Lazy b10;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(urlLauncher, "urlLauncher");
        this.f32908s = new LinkedHashMap();
        this.f32904o = urlLauncher;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreFragment$needOnboarding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Boolean invoke() {
                Bundle arguments = DriverScoreFragment.this.getArguments();
                boolean z7 = false;
                if (arguments != null) {
                    z7 = arguments.getBoolean("SHOW_ONBOARDING", false);
                }
                return Boolean.valueOf(z7);
            }
        });
        this.f32905p = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<DiffAdapter>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DiffAdapter invoke() {
                DiffAdapter diffAdapter = new DiffAdapter();
                DriverScoreFragment driverScoreFragment = DriverScoreFragment.this;
                diffAdapter.P(new DriverScoreHeaderDelegate());
                diffAdapter.P(new DriverScoreMoreDelegate(new DriverScoreFragment$adapter$2$1$1(driverScoreFragment)));
                diffAdapter.P(new InfoBlockDelegate());
                diffAdapter.P(new DriverScoreActionDelegate(new DriverScoreFragment$adapter$2$1$2(driverScoreFragment)));
                diffAdapter.P(new ItemOptionTextDelegate());
                diffAdapter.P(new ItemHeaderDelegate());
                diffAdapter.P(new TwoLinesItemDelegate(new Function1<TwoLinesItemDelegate.Model<IssueItem>, Unit>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreFragment$adapter$2$1$3
                    public final void b(TwoLinesItemDelegate.Model<IssueItem> it) {
                        Intrinsics.f(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<IssueItem> model) {
                        b(model);
                        return Unit.f50853a;
                    }
                }, null, 0, null, 14, null));
                diffAdapter.P(new ItemOneLineDelegate(new DriverScoreFragment$adapter$2$1$4(driverScoreFragment)));
                diffAdapter.P(new DriverScoreRatingDelegate());
                return diffAdapter;
            }
        });
        this.f32906q = b9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<TooltipOnbordingDelegate>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreFragment$tooltipOnbordingDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final TooltipOnbordingDelegate invoke() {
                DiffAdapter Y;
                ConstraintLayout rootView = (ConstraintLayout) DriverScoreFragment.this.T(R.id.rootView);
                Intrinsics.e(rootView, "rootView");
                RecyclerView recyclerView = (RecyclerView) DriverScoreFragment.this.T(R.id.H9);
                Y = DriverScoreFragment.this.Y();
                return new TooltipOnbordingDelegate(rootView, recyclerView, Y, null, 8, null);
            }
        });
        this.f32907r = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiffAdapter Y() {
        return (DiffAdapter) this.f32906q.getValue();
    }

    private final Navigator Z() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    private final boolean a0() {
        return ((Boolean) this.f32905p.getValue()).booleanValue();
    }

    private final TooltipOnbordingDelegate b0() {
        return (TooltipOnbordingDelegate) this.f32907r.getValue();
    }

    private final void c0(final DriverScoreViewModel.DriverScoreState driverScoreState) {
        DiffAdapter.V(Y(), driverScoreState.a(), null, 2, null);
        if (driverScoreState.b() != null && a0()) {
            ((RecyclerView) T(R.id.H9)).post(new Runnable() { // from class: ee.mtakso.driver.ui.screens.score.g
                @Override // java.lang.Runnable
                public final void run() {
                    DriverScoreFragment.d0(DriverScoreFragment.this, driverScoreState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(DriverScoreFragment this$0, DriverScoreViewModel.DriverScoreState screenState) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(screenState, "$screenState");
        this$0.b0().u(screenState.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(DriverScoreActionDelegate.Model model) {
        M().L();
        this.f32904o.a(model.n().a().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        M().M();
        Navigator.DefaultImpls.b(Z(), DriverScoreExplanationFragment.class, null, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(IssueItem issueItem) {
        if (issueItem.a() == null) {
            return;
        }
        InfoCopyDialog.Companion companion = InfoCopyDialog.f28299n;
        String b8 = issueItem.b();
        GenericValue c8 = issueItem.c();
        FragmentUtils.b(companion.a(b8, (c8 == null || (r2 = c8.d()) == null) ? "" : "", issueItem.a(), false), this, "issue_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(DriverScoreFragment this$0, DriverScoreViewModel.DriverScoreState it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.c0(it);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f32908s.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        IndeterminateProgressView progressView = (IndeterminateProgressView) T(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(c8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        IndeterminateProgressView progressView = (IndeterminateProgressView) T(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
    }

    public View T(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32908s;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: i0 */
    public DriverScoreViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (DriverScoreViewModel) new ViewModelProvider(this, E.d()).a(DriverScoreViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) T(R.id.H9)).setAdapter(null);
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        SimpleItemAnimator simpleItemAnimator = null;
        Z().n(new PopupToolbarAppearance(0, new Text.Resource(R.string.driver_score, null, 2, null), false, 5, null));
        int i8 = R.id.H9;
        ((RecyclerView) T(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) T(i8)).setAdapter(Y());
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) T(i8)).getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        ((RecyclerView) T(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        M().I().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.score.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverScoreFragment.h0(DriverScoreFragment.this, (DriverScoreViewModel.DriverScoreState) obj);
            }
        });
    }
}
