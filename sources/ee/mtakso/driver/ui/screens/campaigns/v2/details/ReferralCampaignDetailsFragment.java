package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.Bonus;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignUtilsKt;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uicore.components.views.PopupToolbar;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.ui.common.activity.NoToolbarAppearance;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferralCampaignDetailsFragment.kt */
/* loaded from: classes3.dex */
public final class ReferralCampaignDetailsFragment extends BazeMvvmFragment<ReferralCampaignDetailsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final CampaignBonusMapper f27519o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f27520p;

    /* renamed from: q  reason: collision with root package name */
    private CampaignBonusController f27521q;

    /* renamed from: r  reason: collision with root package name */
    private final int f27522r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f27523s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ReferralCampaignDetailsFragment(CampaignBonusMapper campaignBonusMapper, BaseUiDependencies deps) {
        super(deps, R.layout.fragment_campaigns_v2_referral_campaign_details, null, 4, null);
        Intrinsics.f(campaignBonusMapper, "campaignBonusMapper");
        Intrinsics.f(deps, "deps");
        this.f27523s = new LinkedHashMap();
        this.f27519o = campaignBonusMapper;
        this.f27520p = new DiffAdapter().P(new ItemOneLineDelegate(new Function1<Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment$adapter$1
            public final void b(Object it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        }));
        this.f27522r = 2132017818;
    }

    private final void X() {
        ConstraintSet constraintSet = new ConstraintSet();
        int i8 = R.id.referralCampaignContentRoot;
        constraintSet.g((ConstraintLayout) V(i8));
        constraintSet.i(R.id.f357inviteButton, 4, 0, 4);
        constraintSet.z(R.id.f357inviteButton, 1.0f);
        constraintSet.c((ConstraintLayout) V(i8));
    }

    private final ClipboardManager Y() {
        Object systemService = requireContext().getSystemService("clipboard");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        return (ClipboardManager) systemService;
    }

    private final Navigator Z() {
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            return (Navigator) activity;
        }
        return null;
    }

    private final void a0(ReferralCampaignState referralCampaignState) {
        M().K();
        Y().setPrimaryClip(ClipData.newPlainText(null, referralCampaignState.g()));
        Snackbar.u0((FrameLayout) V(R.id.rootView), R.string.copy_clipboard, -1).e0();
        M().J();
    }

    private final void b0(ReferralCampaignState referralCampaignState) {
        M().I();
        M().H();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Text h8 = referralCampaignState.h();
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        intent.putExtra("android.intent.extra.TEXT", TextKt.a(h8, requireContext));
        startActivity(Intent.createChooser(intent, getString(R.string.invite_friends_to_ride)));
        M().N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ReferralCampaignDetailsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Navigator Z = this$0.Z();
        if (Z != null) {
            Z.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(final ReferralCampaignState referralCampaignState) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z11;
        boolean z12;
        boolean z13;
        CampaignBonusController campaignBonusController;
        Long e8 = referralCampaignState.e();
        if (e8 != null) {
            M().L(e8.longValue());
        }
        TextView title = (TextView) V(R.id.cc);
        Intrinsics.e(title, "title");
        TextViewExtKt.h(title, referralCampaignState.l());
        int i8 = R.id.tb;
        TextView subtitle = (TextView) V(i8);
        Intrinsics.e(subtitle, "subtitle");
        boolean z14 = true;
        if (referralCampaignState.m() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(subtitle, z7, 0, 2, null);
        TextView subtitle2 = (TextView) V(i8);
        Intrinsics.e(subtitle2, "subtitle");
        TextViewExtKt.h(subtitle2, referralCampaignState.m());
        int i9 = R.id.f19827b0;
        TextView badge = (TextView) V(i9);
        Intrinsics.e(badge, "badge");
        if (referralCampaignState.d() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.d(badge, z8, 0, 2, null);
        TextView badge2 = (TextView) V(i9);
        Intrinsics.e(badge2, "badge");
        TextViewExtKt.h(badge2, referralCampaignState.d());
        ImageView badgeDivider = (ImageView) V(R.id.badgeDivider);
        Intrinsics.e(badgeDivider, "badgeDivider");
        if (referralCampaignState.d() == null && !referralCampaignState.j()) {
            z9 = true;
        } else {
            z9 = false;
        }
        ViewExtKt.d(badgeDivider, z9, 0, 2, null);
        int i10 = R.id.categoryAndLocation;
        TextView categoryAndLocation = (TextView) V(i10);
        Intrinsics.e(categoryAndLocation, "categoryAndLocation");
        if (referralCampaignState.b() == null && referralCampaignState.i() == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        ViewExtKt.d(categoryAndLocation, z10, 0, 2, null);
        TextView textView = (TextView) V(i10);
        Context context = ((TextView) V(i10)).getContext();
        Intrinsics.e(context, "categoryAndLocation.context");
        int lineHeight = ((TextView) V(i10)).getLineHeight();
        Text b8 = referralCampaignState.b();
        if (b8 != null) {
            Context context2 = ((TextView) V(i10)).getContext();
            Intrinsics.e(context2, "categoryAndLocation.context");
            charSequence = TextKt.a(b8, context2);
        } else {
            charSequence = null;
        }
        Text i11 = referralCampaignState.i();
        if (i11 != null) {
            Context context3 = ((TextView) V(i10)).getContext();
            Intrinsics.e(context3, "categoryAndLocation.context");
            charSequence2 = TextKt.a(i11, context3);
        } else {
            charSequence2 = null;
        }
        textView.setText(CampaignUtilsKt.b(context, lineHeight, charSequence, charSequence2));
        ((TextView) V(R.id.inviteCodeText)).setText(referralCampaignState.g());
        ((LinearLayout) V(R.id.inviteCode)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReferralCampaignDetailsFragment.g0(ReferralCampaignDetailsFragment.this, referralCampaignState, view);
            }
        });
        ((RoundButton) V(R.id.inviteButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReferralCampaignDetailsFragment.h0(ReferralCampaignDetailsFragment.this, referralCampaignState, view);
            }
        });
        View bonus = V(R.id.bonus);
        Intrinsics.e(bonus, "bonus");
        if (referralCampaignState.a() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        ViewExtKt.d(bonus, z11, 0, 2, null);
        Bonus a8 = referralCampaignState.a();
        if (a8 != null && (campaignBonusController = this.f27521q) != null) {
            CampaignBonusController.c(campaignBonusController, this.f27519o.a(a8), null, 2, null);
        }
        int i12 = R.id.f19834o3;
        TextView descriptionText = (TextView) V(i12);
        Intrinsics.e(descriptionText, "descriptionText");
        if (referralCampaignState.c() != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        ViewExtKt.d(descriptionText, z12, 0, 2, null);
        TextView descriptionText2 = (TextView) V(i12);
        Intrinsics.e(descriptionText2, "descriptionText");
        TextViewExtKt.h(descriptionText2, referralCampaignState.c());
        RecyclerView recyclerView = (RecyclerView) V(R.id.H9);
        Intrinsics.e(recyclerView, "recyclerView");
        ViewExtKt.d(recyclerView, !referralCampaignState.f().isEmpty(), 0, 2, null);
        DiffAdapter.V(this.f27520p, referralCampaignState.f(), null, 2, null);
        View invitationDivider = V(R.id.invitationDivider);
        Intrinsics.e(invitationDivider, "invitationDivider");
        if (referralCampaignState.k() != null) {
            z13 = true;
        } else {
            z13 = false;
        }
        ViewExtKt.d(invitationDivider, z13, 0, 2, null);
        int i13 = R.id.noteText;
        TextView noteText = (TextView) V(i13);
        Intrinsics.e(noteText, "noteText");
        if (referralCampaignState.k() == null) {
            z14 = false;
        }
        ViewExtKt.d(noteText, z14, 0, 2, null);
        TextView noteText2 = (TextView) V(i13);
        Intrinsics.e(noteText2, "noteText");
        TextViewExtKt.h(noteText2, referralCampaignState.k());
        ((TextView) V(i13)).setMovementMethod(LinkMovementMethod.getInstance());
        if (referralCampaignState.j()) {
            X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(ReferralCampaignDetailsFragment this$0, ReferralCampaignState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.a0(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ReferralCampaignDetailsFragment this$0, ReferralCampaignState state, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(state, "$state");
        this$0.b0(state);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27523s.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f27522r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        NestedScrollView content = (NestedScrollView) V(R.id.S2);
        Intrinsics.e(content, "content");
        ViewExtKt.d(content, false, 0, 3, null);
        ((CircularProgressIndicator) V(R.id.V6)).j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        NestedScrollView content = (NestedScrollView) V(R.id.S2);
        Intrinsics.e(content, "content");
        ViewExtKt.d(content, false, 0, 2, null);
        ((CircularProgressIndicator) V(R.id.V6)).q();
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27523s;
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
    /* renamed from: e0 */
    public ReferralCampaignDetailsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (ReferralCampaignDetailsViewModel) new ViewModelProvider(this, E.d()).a(ReferralCampaignDetailsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((RecyclerView) V(R.id.H9)).setAdapter(null);
        this.f27521q = null;
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        View bonus = V(R.id.bonus);
        Intrinsics.e(bonus, "bonus");
        this.f27521q = new CampaignBonusController(bonus);
        Navigator Z = Z();
        if (Z != null) {
            Z.x(new NoToolbarAppearance());
        }
        ((PopupToolbar) V(R.id.kc)).setNavigationOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReferralCampaignDetailsFragment.c0(ReferralCampaignDetailsFragment.this, view2);
            }
        });
        int i8 = R.id.H9;
        ((RecyclerView) V(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) V(i8)).setAdapter(this.f27520p);
        ((RecyclerView) V(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        LiveData<ReferralCampaignState> F = M().F();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ReferralCampaignState, Unit> function1 = new Function1<ReferralCampaignState, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ReferralCampaignState state) {
                ReferralCampaignDetailsFragment referralCampaignDetailsFragment = ReferralCampaignDetailsFragment.this;
                Intrinsics.e(state, "state");
                referralCampaignDetailsFragment.f0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReferralCampaignState referralCampaignState) {
                b(referralCampaignState);
                return Unit.f50853a;
            }
        };
        F.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReferralCampaignDetailsFragment.d0(Function1.this, obj);
            }
        });
        M().M();
    }
}
