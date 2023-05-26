package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignDelegate;
import ee.mtakso.driver.ui.screens.campaigns.v2.LoadingDelegate;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.recyclerview.Paging;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.SegmentControlItemView;
import ee.mtakso.driver.uikit.widgets.SegmentControlView;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastCampaignsFragment.kt */
/* loaded from: classes3.dex */
public final class PastCampaignsFragment extends BazeMvvmFragment<PastCampaignsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final DiffAdapter f27341o;

    /* renamed from: p  reason: collision with root package name */
    private final int f27342p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f27343q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PastCampaignsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_campaigns_v2_past_campaigns, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f27343q = new LinkedHashMap();
        this.f27341o = new DiffAdapter().P(new GenericTitleDelegate()).P(new CampaignDelegate(new PastCampaignsFragment$adapter$1(this))).P(new LoadingDelegate());
        this.f27342p = 2132017818;
    }

    private final Navigator Y() {
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            return (Navigator) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(CampaignDelegate.Model model) {
        M().S(model.n());
        Navigator Y = Y();
        if (Y != null) {
            Navigator.DefaultImpls.b(Y, CampaignDetailsFragment.class, CampaignDetailsFragment.A.a(model.n()), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(PastCampaignsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        SegmentControlItemView allSegment = (SegmentControlItemView) this$0.U(R.id.allSegment);
        Intrinsics.e(allSegment, "allSegment");
        ((SegmentControlView) this$0.U(R.id.segments)).E(allSegment);
        this$0.M().L(PastCampaignsFilter.ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(PastCampaignsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        SegmentControlItemView completedSegment = (SegmentControlItemView) this$0.U(R.id.completedSegment);
        Intrinsics.e(completedSegment, "completedSegment");
        ((SegmentControlView) this$0.U(R.id.segments)).E(completedSegment);
        this$0.M().L(PastCampaignsFilter.COMPLETED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27343q.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27342p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        super.H(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null), this, "error");
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27343q;
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
    /* renamed from: d0 */
    public PastCampaignsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (PastCampaignsViewModel) new ViewModelProvider(this, E.d()).a(PastCampaignsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) U(R.id.H9)).setAdapter(null);
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Navigator Y = Y();
        if (Y != null) {
            Y.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.previous_campaigns, null, 2, null), false, null, null, null, null, null, null, 509, null));
        }
        M().T();
        int i8 = R.id.H9;
        ((RecyclerView) U(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) U(i8)).setAdapter(this.f27341o);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.R(false);
        ((RecyclerView) U(i8)).setItemAnimator(defaultItemAnimator);
        ((RecyclerView) U(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        RecyclerView recyclerView = (RecyclerView) U(i8);
        Intrinsics.e(recyclerView, "recyclerView");
        final Paging paging = new Paging(recyclerView, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsFragment$onViewCreated$paging$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                PastCampaignsViewModel M;
                M = PastCampaignsFragment.this.M();
                M.M();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        ((SegmentControlItemView) U(R.id.allSegment)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PastCampaignsFragment.a0(PastCampaignsFragment.this, view2);
            }
        });
        ((SegmentControlItemView) U(R.id.completedSegment)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PastCampaignsFragment.b0(PastCampaignsFragment.this, view2);
            }
        });
        LinearLayout emptyLayout = (LinearLayout) U(R.id.emptyLayout);
        Intrinsics.e(emptyLayout, "emptyLayout");
        ViewExtKt.d(emptyLayout, false, 0, 2, null);
        LiveData<PastCampaignsState> R = M().R();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<PastCampaignsState, Unit> function1 = new Function1<PastCampaignsState, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsFragment$onViewCreated$4

            /* compiled from: PastCampaignsFragment.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f27346a;

                static {
                    int[] iArr = new int[PastCampaignsFilter.values().length];
                    try {
                        iArr[PastCampaignsFilter.ALL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PastCampaignsFilter.COMPLETED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f27346a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(PastCampaignsState pastCampaignsState) {
                List<ListModel> o02;
                DiffAdapter diffAdapter;
                PastCampaignsViewModel M;
                if (pastCampaignsState.e()) {
                    o02 = pastCampaignsState.c();
                } else {
                    List<ListModel> c8 = pastCampaignsState.c();
                    double random = Math.random();
                    o02 = CollectionsKt___CollectionsKt.o0(c8, new LoadingDelegate.Model("loading_" + random));
                }
                diffAdapter = PastCampaignsFragment.this.f27341o;
                DiffAdapter.V(diffAdapter, o02, null, 2, null);
                if (o02.isEmpty()) {
                    LinearLayout emptyLayout2 = (LinearLayout) PastCampaignsFragment.this.U(R.id.emptyLayout);
                    Intrinsics.e(emptyLayout2, "emptyLayout");
                    ViewExtKt.d(emptyLayout2, true, 0, 2, null);
                    RecyclerView recyclerView2 = (RecyclerView) PastCampaignsFragment.this.U(R.id.H9);
                    Intrinsics.e(recyclerView2, "recyclerView");
                    ViewExtKt.d(recyclerView2, false, 0, 2, null);
                    M = PastCampaignsFragment.this.M();
                    M.U();
                } else {
                    LinearLayout emptyLayout3 = (LinearLayout) PastCampaignsFragment.this.U(R.id.emptyLayout);
                    Intrinsics.e(emptyLayout3, "emptyLayout");
                    ViewExtKt.d(emptyLayout3, false, 0, 2, null);
                    RecyclerView recyclerView3 = (RecyclerView) PastCampaignsFragment.this.U(R.id.H9);
                    Intrinsics.e(recyclerView3, "recyclerView");
                    ViewExtKt.d(recyclerView3, true, 0, 2, null);
                }
                paging.c(pastCampaignsState.e());
                int i9 = WhenMappings.f27346a[pastCampaignsState.d().ordinal()];
                if (i9 != 1) {
                    if (i9 != 2) {
                        RuntimeException runtimeException = new RuntimeException("Unsupported filter type: " + pastCampaignsState + ".filter");
                        Kalev.m(runtimeException, "Unsupported filter type: " + pastCampaignsState + ".filter");
                        return;
                    }
                    SegmentControlItemView completedSegment = (SegmentControlItemView) PastCampaignsFragment.this.U(R.id.completedSegment);
                    Intrinsics.e(completedSegment, "completedSegment");
                    ((SegmentControlView) PastCampaignsFragment.this.U(R.id.segments)).E(completedSegment);
                    return;
                }
                SegmentControlItemView allSegment = (SegmentControlItemView) PastCampaignsFragment.this.U(R.id.allSegment);
                Intrinsics.e(allSegment, "allSegment");
                ((SegmentControlView) PastCampaignsFragment.this.U(R.id.segments)).E(allSegment);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PastCampaignsState pastCampaignsState) {
                b(pastCampaignsState);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PastCampaignsFragment.c0(Function1.this, obj);
            }
        });
    }
}
