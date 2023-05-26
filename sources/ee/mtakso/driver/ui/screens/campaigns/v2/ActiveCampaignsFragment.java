package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.LiveDataNotification;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignBannerTileDelegate;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignDelegate;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveCampaignsFragment.kt */
/* loaded from: classes3.dex */
public final class ActiveCampaignsFragment extends BazeMvvmFragment<ActiveCampaignsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final DiffAdapter f27223o;

    /* renamed from: p  reason: collision with root package name */
    private final int f27224p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f27225q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ActiveCampaignsFragment(DateTimeConverter dateTimeConverter, BaseUiDependencies deps) {
        super(deps, R.layout.fragment_campaigns_v2_active_campaigns, null, 4, null);
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(deps, "deps");
        this.f27225q = new LinkedHashMap();
        this.f27223o = new DiffAdapter().P(new CampaignThisWeekBonusDelegate(new ActiveCampaignsFragment$adapter$1(this), new ActiveCampaignsFragment$adapter$2(this))).P(new GenericTitleDelegate()).P(new CampaignDelegate(new ActiveCampaignsFragment$adapter$3(this))).P(new CampaignBannerTileDelegate(dateTimeConverter, new Function2<CampaignBannerTileDelegate.CampaignTileMode, Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment$adapter$4

            /* compiled from: ActiveCampaignsFragment.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f27227a;

                static {
                    int[] iArr = new int[CampaignBannerTileDelegate.CampaignTileMode.values().length];
                    try {
                        iArr[CampaignBannerTileDelegate.CampaignTileMode.REFERRALS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[CampaignBannerTileDelegate.CampaignTileMode.OPT_IN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[CampaignBannerTileDelegate.CampaignTileMode.CIRCLE_K_LOYALTY.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f27227a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(CampaignBannerTileDelegate.CampaignTileMode clickedCampaignListMode, Long l8) {
                ActiveCampaignsViewModel M;
                Navigator d02;
                ActiveCampaignsViewModel M2;
                Navigator d03;
                ActiveCampaignsViewModel M3;
                Intrinsics.f(clickedCampaignListMode, "clickedCampaignListMode");
                int i8 = WhenMappings.f27227a[clickedCampaignListMode.ordinal()];
                if (i8 == 1) {
                    M = ActiveCampaignsFragment.this.M();
                    M.d0();
                    d02 = ActiveCampaignsFragment.this.d0();
                    if (d02 != null) {
                        Navigator.DefaultImpls.b(d02, ReferralCampaignDetailsFragment.class, null, false, 6, null);
                    }
                } else if (i8 != 2) {
                    if (i8 == 3) {
                        M3 = ActiveCampaignsFragment.this.M();
                        M3.L();
                        return;
                    }
                    Kalev.d("Unexpected tile mode " + clickedCampaignListMode);
                } else if (l8 != null) {
                    ActiveCampaignsFragment activeCampaignsFragment = ActiveCampaignsFragment.this;
                    long longValue = l8.longValue();
                    M2 = activeCampaignsFragment.M();
                    M2.a0(l8.longValue());
                    d03 = activeCampaignsFragment.d0();
                    if (d03 != null) {
                        Navigator.DefaultImpls.b(d03, OptInCampaignFragment.class, OptInCampaignFragment.f27598v.a(longValue), false, 4, null);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(CampaignBannerTileDelegate.CampaignTileMode campaignTileMode, Long l8) {
                b(campaignTileMode, l8);
                return Unit.f50853a;
            }
        }));
        this.f27224p = 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadingDialogDelegate c0() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new LoadingDialogDelegate(requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator d0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            return (Navigator) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        M().V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(CampaignDelegate.Model model) {
        M().W(model.n());
        Navigator d02 = d0();
        if (d02 != null) {
            Navigator.DefaultImpls.b(d02, CampaignDetailsFragment.class, CampaignDetailsFragment.A.a(model.n()), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        M().b0();
        Navigator d02 = d0();
        if (d02 != null) {
            Navigator.DefaultImpls.b(d02, PastCampaignsFragment.class, null, false, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ActiveCampaignsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27225q.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27224p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        ((CircularProgressIndicator) U(R.id.V6)).j();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        ((CircularProgressIndicator) U(R.id.V6)).q();
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27225q;
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
    /* renamed from: k0 */
    public ActiveCampaignsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (ActiveCampaignsViewModel) new ViewModelProvider(this, E.d()).a(ActiveCampaignsViewModel.class);
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
        Navigator d02 = d0();
        if (d02 != null) {
            d02.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.campaigns, null, 2, null), false, null, null, null, null, null, null, 509, null));
        }
        M().X();
        int i8 = R.id.H9;
        ((RecyclerView) U(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) U(i8)).setAdapter(this.f27223o);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.R(false);
        ((RecyclerView) U(i8)).setItemAnimator(defaultItemAnimator);
        ((RecyclerView) U(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((TextView) U(R.id.previousCampaignTitle)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActiveCampaignsFragment.h0(ActiveCampaignsFragment.this, view2);
            }
        });
        LinearLayout emptyLayout = (LinearLayout) U(R.id.emptyLayout);
        Intrinsics.e(emptyLayout, "emptyLayout");
        ViewExtKt.d(emptyLayout, false, 0, 2, null);
        LiveData<List<ListModel>> Q = M().Q();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends ListModel>, Unit> function1 = new Function1<List<? extends ListModel>, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends ListModel> campaigns) {
                DiffAdapter diffAdapter;
                ActiveCampaignsViewModel M;
                diffAdapter = ActiveCampaignsFragment.this.f27223o;
                Intrinsics.e(campaigns, "campaigns");
                DiffAdapter.V(diffAdapter, campaigns, null, 2, null);
                if (campaigns.isEmpty()) {
                    RecyclerView recyclerView = (RecyclerView) ActiveCampaignsFragment.this.U(R.id.H9);
                    Intrinsics.e(recyclerView, "recyclerView");
                    ViewExtKt.d(recyclerView, false, 0, 2, null);
                    LinearLayout emptyLayout2 = (LinearLayout) ActiveCampaignsFragment.this.U(R.id.emptyLayout);
                    Intrinsics.e(emptyLayout2, "emptyLayout");
                    ViewExtKt.d(emptyLayout2, true, 0, 2, null);
                    M = ActiveCampaignsFragment.this.M();
                    M.Y();
                    return;
                }
                RecyclerView recyclerView2 = (RecyclerView) ActiveCampaignsFragment.this.U(R.id.H9);
                Intrinsics.e(recyclerView2, "recyclerView");
                ViewExtKt.d(recyclerView2, true, 0, 2, null);
                LinearLayout emptyLayout3 = (LinearLayout) ActiveCampaignsFragment.this.U(R.id.emptyLayout);
                Intrinsics.e(emptyLayout3, "emptyLayout");
                ViewExtKt.d(emptyLayout3, false, 0, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ListModel> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Q.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveCampaignsFragment.i0(Function1.this, obj);
            }
        });
        LiveData<LiveDataNotification<String>> R = M().R();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<LiveDataNotification<String>, Unit> function12 = new Function1<LiveDataNotification<String>, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(LiveDataNotification<String> liveDataNotification) {
                LoadingDialogDelegate c02;
                LoadingDialogDelegate c03;
                if (liveDataNotification.c()) {
                    c03 = ActiveCampaignsFragment.this.c0();
                    c03.b();
                    return;
                }
                c02 = ActiveCampaignsFragment.this.c0();
                c02.a();
                String b8 = liveDataNotification.b();
                if (b8 != null) {
                    CircleKLoyaltyFragment.Companion companion = CircleKLoyaltyFragment.f27371t;
                    Context requireContext = ActiveCampaignsFragment.this.requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    companion.c(requireContext, b8);
                } else if (liveDataNotification.a() != null) {
                    NotificationDialog.Companion companion2 = NotificationDialog.f28313n;
                    Context requireContext2 = ActiveCampaignsFragment.this.requireContext();
                    Intrinsics.e(requireContext2, "requireContext()");
                    NotificationDialog c8 = NotificationDialog.Companion.c(companion2, requireContext2, liveDataNotification.a(), null, 4, null);
                    FragmentActivity requireActivity = ActiveCampaignsFragment.this.requireActivity();
                    Intrinsics.e(requireActivity, "requireActivity()");
                    FragmentUtils.c(c8, requireActivity, "error");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveDataNotification<String> liveDataNotification) {
                b(liveDataNotification);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveCampaignsFragment.j0(Function1.this, obj);
            }
        });
    }
}
