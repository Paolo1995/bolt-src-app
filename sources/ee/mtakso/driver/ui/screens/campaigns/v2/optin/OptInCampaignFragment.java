package ee.mtakso.driver.ui.screens.campaigns.v2.optin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.DriverCampaignBadge;
import ee.mtakso.driver.network.client.campaign.OptInCampaign;
import ee.mtakso.driver.network.client.campaign.OptInCampaignChoice;
import ee.mtakso.driver.network.client.campaign.OptInChoiceV2;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignPeriodBadgesConditionsDelegateKt;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.SpannableUtilsKt;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptInCampaignFragment.kt */
/* loaded from: classes3.dex */
public final class OptInCampaignFragment extends BazeMvvmFragment<OptInCampaignViewModel> {

    /* renamed from: v  reason: collision with root package name */
    public static final Companion f27598v = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final HtmlEngine f27599o;

    /* renamed from: p  reason: collision with root package name */
    private final Map<String, OptInChoiceDelegate> f27600p;

    /* renamed from: q  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f27601q;

    /* renamed from: r  reason: collision with root package name */
    private final Function2<OptInCampaignChoice, Boolean, Unit> f27602r;

    /* renamed from: s  reason: collision with root package name */
    private final Function1<OptInCampaignChoice, Unit> f27603s;

    /* renamed from: t  reason: collision with root package name */
    private final int f27604t;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f27605u;

    /* compiled from: OptInCampaignFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(long j8) {
            return BundleKt.a(TuplesKt.a("argument_campaign_id", Long.valueOf(j8)));
        }

        public final RoutingCommand.ActivityClass b(long j8) {
            return SimpleActivity.Companion.f(SimpleActivity.f27004l, OptInCampaignFragment.class, a(j8), false, 0, 12, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OptInCampaignFragment(BaseUiDependencies deps, HtmlEngine htmlEngine) {
        super(deps, R.layout.fragment_opt_in_campaign, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f27605u = new LinkedHashMap();
        this.f27599o = htmlEngine;
        this.f27600p = new LinkedHashMap();
        this.f27601q = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment$onDialogActionListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                OptInCampaignViewModel M;
                OptInCampaignViewModel M2;
                OptInCampaignViewModel M3;
                OptInCampaignViewModel M4;
                OptInCampaignViewModel M5;
                OptInCampaignViewModel M6;
                OptInCampaignViewModel M7;
                OptInCampaignViewModel M8;
                long f02;
                OptInCampaignViewModel M9;
                Intrinsics.f(dialogFragment, "dialogFragment");
                if (Intrinsics.a(obj, "confirm")) {
                    dialogFragment.dismissAllowingStateLoss();
                    M6 = OptInCampaignFragment.this.M();
                    OptInCampaignChoice R = M6.R();
                    if (R != null) {
                        long id = R.getId();
                        M9 = OptInCampaignFragment.this.M();
                        M9.d0(id);
                    }
                    M7 = OptInCampaignFragment.this.M();
                    OptInCampaignChoice R2 = M7.R();
                    if (R2 != null) {
                        OptInCampaignFragment optInCampaignFragment = OptInCampaignFragment.this;
                        M8 = optInCampaignFragment.M();
                        f02 = optInCampaignFragment.f0();
                        M8.L(f02, R2);
                    }
                } else if (Intrinsics.a(obj, "link")) {
                    M4 = OptInCampaignFragment.this.M();
                    OptInCampaign Q = M4.Q();
                    M5 = OptInCampaignFragment.this.M();
                    OptInCampaignChoice R3 = M5.R();
                    if (Q != null && R3 != null) {
                        OptInCampaignFragment.this.n0(Q, R3);
                    }
                } else if (Intrinsics.a(obj, "cancel")) {
                    dialogFragment.dismissAllowingStateLoss();
                    M2 = OptInCampaignFragment.this.M();
                    OptInCampaignChoice R4 = M2.R();
                    if (R4 != null) {
                        long id2 = R4.getId();
                        M3 = OptInCampaignFragment.this.M();
                        M3.e0(id2);
                    }
                } else if (Intrinsics.a(obj, "dialog_shown") && (dialogFragment instanceof ConfirmationDialog)) {
                    M = OptInCampaignFragment.this.M();
                    M.a0();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.f27602r = new Function2<OptInCampaignChoice, Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment$onItemSelectionChangedListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(OptInCampaignChoice optInChoice, boolean z7) {
                Intrinsics.f(optInChoice, "optInChoice");
                OptInCampaignFragment.i0(OptInCampaignFragment.this, optInChoice, z7, false, 4, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(OptInCampaignChoice optInCampaignChoice, Boolean bool) {
                b(optInCampaignChoice, bool.booleanValue());
                return Unit.f50853a;
            }
        };
        this.f27603s = new Function1<OptInCampaignChoice, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment$onItemClickedListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OptInCampaignChoice optInChoice) {
                OptInCampaignViewModel M;
                OptInCampaignViewModel M2;
                Intrinsics.f(optInChoice, "optInChoice");
                M = OptInCampaignFragment.this.M();
                M.g0(optInChoice.getId());
                OptInCampaignFragment optInCampaignFragment = OptInCampaignFragment.this;
                M2 = optInCampaignFragment.M();
                OptInCampaign Q = M2.Q();
                if (Q != null) {
                    optInCampaignFragment.n0(Q, optInChoice);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OptInCampaignChoice optInCampaignChoice) {
                b(optInCampaignChoice);
                return Unit.f50853a;
            }
        };
        this.f27604t = 2132017818;
    }

    private final void Z(OptInCampaign optInCampaign, boolean z7) {
        List e8;
        d0(optInCampaign.getTitle());
        c0(optInCampaign.b());
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        LinearLayout campaignOptInBadgeContainer = (LinearLayout) V(R.id.campaignOptInBadgeContainer);
        Intrinsics.e(campaignOptInBadgeContainer, "campaignOptInBadgeContainer");
        e8 = CollectionsKt__CollectionsJVMKt.e(DriverCampaignBadge.ACTIVATION_REQUIRED);
        CampaignPeriodBadgesConditionsDelegateKt.l(requireContext, campaignOptInBadgeContainer, e8, null, 8, null);
        b0(optInCampaign.c());
        a0(optInCampaign.a(), z7);
    }

    @SuppressLint({"InflateParams"})
    private final void a0(List<? extends OptInCampaignChoice> list, boolean z7) {
        this.f27600p.clear();
        ((LinearLayout) V(R.id.campaignOptInChoicesContainer)).removeAllViews();
        for (OptInCampaignChoice optInCampaignChoice : list) {
            View optInChoiceLayout = LayoutInflater.from(requireContext()).inflate(R.layout.delegate_item_opt_in_campaign_choice, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            Intrinsics.e(optInChoiceLayout, "optInChoiceLayout");
            OptInChoiceDelegate optInChoiceDelegate = new OptInChoiceDelegate(optInChoiceLayout, optInCampaignChoice);
            optInChoiceDelegate.i(this.f27602r);
            optInChoiceDelegate.h(this.f27603s);
            this.f27600p.put(g0(optInCampaignChoice.getId()), optInChoiceDelegate);
            ((LinearLayout) V(R.id.campaignOptInChoicesContainer)).addView(optInChoiceLayout, layoutParams);
        }
        OptInCampaignChoice R = M().R();
        if (R != null) {
            h0(R, true, z7);
        }
    }

    private final void b0(String str) {
        ((TextView) V(R.id.campaignOptInDescription)).setText(this.f27599o.a(str));
    }

    private final void c0(long j8) {
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ((TextView) V(R.id.campaignOptInPeriod)).setText(getString(R.string.respond_by_date, CampaignPeriodBadgesConditionsDelegateKt.w(requireContext, j8, false, M().P(), 4, null)));
    }

    private final void d0(String str) {
        ((TextView) V(R.id.campaignOptInTitle)).setText(str);
    }

    private final Navigator e0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f0() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return -1L;
        }
        return arguments.getLong("argument_campaign_id", -1L);
    }

    private final String g0(long j8) {
        return "opt_in_choice_" + j8;
    }

    private final void h0(OptInCampaignChoice optInCampaignChoice, boolean z7, boolean z8) {
        boolean z9 = true;
        if (!z7) {
            M().Z(null);
            for (OptInChoiceDelegate optInChoiceDelegate : this.f27600p.values()) {
                optInChoiceDelegate.j(false, false);
            }
        } else {
            if (!z8) {
                M().f0(optInCampaignChoice.getId());
            }
            M().Z(optInCampaignChoice);
            for (OptInChoiceDelegate optInChoiceDelegate2 : this.f27600p.values()) {
                optInChoiceDelegate2.j(Intrinsics.a(optInChoiceDelegate2.e(), optInCampaignChoice), true);
            }
        }
        int i8 = R.id.campaignOptInActivateButton;
        RoundButton roundButton = (RoundButton) V(i8);
        if (M().R() == null) {
            z9 = false;
        }
        roundButton.setEnabled(z9);
        RoundButton campaignOptInActivateButton = (RoundButton) V(i8);
        Intrinsics.e(campaignOptInActivateButton, "campaignOptInActivateButton");
        UiKitRoundButtonTypeKt.b(campaignOptInActivateButton, UiKitRoundButtonType.f36161k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i0(OptInCampaignFragment optInCampaignFragment, OptInCampaignChoice optInCampaignChoice, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z8 = false;
        }
        optInCampaignFragment.h0(optInCampaignChoice, z7, z8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(OptInCampaignFragment this$0, long j8, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().b0(j8);
        OptInCampaignChoice R = this$0.M().R();
        if (R != null) {
            this$0.p0(R);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(OptInCampaignFragment this$0, OptInCampaign it) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (this$0.M().R() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this$0.Z(it, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(OptInCampaignFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            ((RoundButton) this$0.V(R.id.campaignOptInActivateButton)).k();
        } else {
            ((RoundButton) this$0.V(R.id.campaignOptInActivateButton)).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(OptInCampaignFragment this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            Navigator.DefaultImpls.b(this$0.e0(), OptInChoiceActivationInfoFragment.class, null, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(OptInCampaign optInCampaign, OptInCampaignChoice optInCampaignChoice) {
        if (optInCampaignChoice instanceof OptInChoiceV2) {
            SimpleActivity.Companion companion = SimpleActivity.f27004l;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            SimpleActivity.Companion.m(companion, requireContext, OptInChoiceFragment.class, OptInChoiceFragment.f27486y.a(optInCampaign.getId(), optInCampaignChoice.getId()), false, 8, null);
            return;
        }
        Kalev.l("Unsupported opt-in choice " + optInCampaignChoice);
    }

    private final void p0(OptInCampaignChoice optInCampaignChoice) {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.activate_campaign_title);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        String string2 = getString(R.string.activate_campaign_description, optInCampaignChoice.getTitle());
        Intrinsics.e(string2, "getString(R.string.activ…electedOptInChoice.title)");
        SpannableString d8 = SpannableUtilsKt.d(requireContext, string2, optInCampaignChoice.getTitle());
        String string3 = getString(R.string.view_campaign_details);
        String string4 = getString(R.string.activate);
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
        String string5 = getString(R.string.action_cancel);
        Function3<DialogFragment, View, Object, Unit> function3 = this.f27601q;
        Intrinsics.e(string, "getString(R.string.activate_campaign_title)");
        Intrinsics.e(string4, "getString(R.string.activate)");
        FragmentUtils.b(ConfirmationDialog.Companion.b(companion, string, d8, string4, string3, uiKitRoundButtonType, string5, null, null, function3, 192, null), this, "dialog_tag_opt_in_activate_confirmation");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27605u.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27604t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        IndeterminateProgressView progressView = (IndeterminateProgressView) V(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
        ScrollView campaignOptInContentContainer = (ScrollView) V(R.id.campaignOptInContentContainer);
        Intrinsics.e(campaignOptInContentContainer, "campaignOptInContentContainer");
        ViewExtKt.e(campaignOptInContentContainer, true, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        ScrollView campaignOptInContentContainer = (ScrollView) V(R.id.campaignOptInContentContainer);
        Intrinsics.e(campaignOptInContentContainer, "campaignOptInContentContainer");
        ViewExtKt.e(campaignOptInContentContainer, false, 0, 2, null);
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
        IndeterminateProgressView progressView = (IndeterminateProgressView) V(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
        ScrollView campaignOptInContentContainer = (ScrollView) V(R.id.campaignOptInContentContainer);
        Intrinsics.e(campaignOptInContentContainer, "campaignOptInContentContainer");
        ViewExtKt.e(campaignOptInContentContainer, false, 0, 2, null);
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27605u;
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
    /* renamed from: o0 */
    public OptInCampaignViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (OptInCampaignViewModel) new ViewModelProvider(this, E.d()).a(OptInCampaignViewModel.class);
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
        final long f02 = f0();
        if (f02 == -1) {
            Kalev.d("Opt-in campaign ID cannot be empty for opt-in screen");
            Toast.makeText(requireContext(), (int) R.string.something_went_wrong, 0).show();
            e0().c();
            return;
        }
        e0().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.opt_in_campaign, null, 2, null), false, null, null, null, null, null, null, 509, null));
        RestoreableDialogFragment.Companion companion = RestoreableDialogFragment.f34751j;
        RestoreableDialogFragment.Companion.b(companion, getChildFragmentManager(), "dialog_tag_opt_in_activate_confirmation", null, this.f27601q, 4, null);
        RestoreableDialogFragment.Companion.b(companion, requireActivity().getSupportFragmentManager(), "dialog_tag_opt_in_activated", null, this.f27601q, 4, null);
        ((RoundButton) V(R.id.campaignOptInActivateButton)).setOnClickListener(new View.OnClickListener() { // from class: y2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OptInCampaignFragment.j0(OptInCampaignFragment.this, f02, view2);
            }
        });
        M().X().i(getViewLifecycleOwner(), new Observer() { // from class: y2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OptInCampaignFragment.k0(OptInCampaignFragment.this, (OptInCampaign) obj);
            }
        });
        M().W().i(getViewLifecycleOwner(), new Observer() { // from class: y2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OptInCampaignFragment.l0(OptInCampaignFragment.this, (Boolean) obj);
            }
        });
        M().V().i(getViewLifecycleOwner(), new Observer() { // from class: y2.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OptInCampaignFragment.m0(OptInCampaignFragment.this, (Boolean) obj);
            }
        });
        if (M().R() == null) {
            M().c0(f02);
        }
        if (bundle == null) {
            M().S(f02);
        }
    }
}
