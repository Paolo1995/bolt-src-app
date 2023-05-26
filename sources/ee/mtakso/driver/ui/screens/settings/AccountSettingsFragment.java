package ee.mtakso.driver.ui.screens.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.ui.screens.settings.ReferralConfig;
import ee.mtakso.driver.ui.screens.shared.InviteDriversActivity;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeFragment;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemChipDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemIconDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class AccountSettingsFragment extends BazeMvvmFragment<SettingsViewModel> {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f32979t = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private int f32980o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f32981p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f32982q;

    /* renamed from: r  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f32983r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f32984s;

    /* compiled from: AccountSettingsFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AccountSettingsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_settings_details, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f32984s = new LinkedHashMap();
        this.f32980o = 2132017818;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.settings.AccountSettingsFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = AccountSettingsFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f32981p = b8;
        this.f32982q = new DiffAdapter().P(new TwoLinesItemDelegate(new AccountSettingsFragment$diffAdapter$1(this), null, 0, null, 14, null)).P(new TwoLinesItemChipDelegate(new AccountSettingsFragment$diffAdapter$2(this), null, 2, null)).P(new TwoLinesItemIconDelegate(new AccountSettingsFragment$diffAdapter$3(this), null, 2, null)).P(new ItemHeaderDelegate());
        this.f32983r = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.AccountSettingsFragment$onDialogConfirmationListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialog, View view, Object obj) {
                SettingsViewModel M;
                Intrinsics.f(dialog, "dialog");
                if (obj == "confirm") {
                    M = AccountSettingsFragment.this.M();
                    M.a0();
                }
                dialog.dismiss();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
    }

    private final void V() {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.logout);
        Intrinsics.e(string, "getString(R.string.logout)");
        String string2 = getString(R.string.confirmation_message_logout);
        Intrinsics.e(string2, "getString(R.string.confirmation_message_logout)");
        String string3 = getString(R.string.logout);
        Intrinsics.e(string3, "getString(R.string.logout)");
        ConfirmationDialog b8 = ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36163m, getString(R.string.no), this.f32983r, null, null, 392, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(b8, requireActivity, "TAG_CONFIRM_LOGOUT");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> W(ee.mtakso.driver.ui.screens.settings.SettingsScreenState r58) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.settings.AccountSettingsFragment.W(ee.mtakso.driver.ui.screens.settings.SettingsScreenState):java.util.List");
    }

    private final Navigator X() {
        return (Navigator) this.f32981p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(TwoLinesItemDelegate.Model<String> model) {
        String m8 = model.m();
        switch (m8.hashCode()) {
            case -1432598868:
                if (m8.equals("LIST_ID_REFERRAL_CODE")) {
                    e0();
                    return;
                }
                return;
            case -1400895040:
                if (m8.equals("LIST_ID_DRIVER_PORTAL")) {
                    M().V();
                    return;
                }
                return;
            case 133266096:
                if (m8.equals("LIST_ID_LOG_OUT")) {
                    V();
                    return;
                }
                return;
            case 1250767477:
                if (m8.equals("LIST_ID_DOCUMENTS")) {
                    M().U();
                    return;
                }
                return;
            case 1541267525:
                if (m8.equals("LIST_ID_DRIVE_TIME")) {
                    i0();
                    return;
                }
                return;
            case 1734703244:
                if (m8.equals("LIST_ID_REFERRAL_NO_CODE")) {
                    e0();
                    return;
                }
                return;
            case 2128384008:
                if (m8.equals("LIST_ID_REFERRAL_INVITE")) {
                    String B = model.B();
                    if (B == null) {
                        B = "";
                    }
                    d0(B);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final ee.mtakso.driver.uikit.recyclerview.ListModel Z(ee.mtakso.driver.ui.screens.settings.ReferralConfig.Campaign r26) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.settings.AccountSettingsFragment.Z(ee.mtakso.driver.ui.screens.settings.ReferralConfig$Campaign):ee.mtakso.driver.uikit.recyclerview.ListModel");
    }

    private final ListModel a0(ReferralConfig.Invite invite) {
        if (invite.a() != null) {
            return new TwoLinesItemDelegate.Model("LIST_ID_REFERRAL_INVITE", new Text.Value(invite.a()), null, null, null, null, null, null, null, null, null, null, new Image.Res(R.drawable.ic_chevron_right), null, null, null, null, null, invite.a(), false, 0, 0, false, null, null, Float.valueOf(Dimens.c(24.0f)), false, false, false, 503050236, null);
        }
        return null;
    }

    private final ListModel b0(ReferralConfig referralConfig) {
        if (referralConfig instanceof ReferralConfig.Campaign) {
            return Z((ReferralConfig.Campaign) referralConfig);
        }
        if (referralConfig instanceof ReferralConfig.Invite) {
            return a0((ReferralConfig.Invite) referralConfig);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AccountSettingsFragment this$0, SettingsScreenState state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.g0(state);
    }

    private final void d0(String str) {
        Intent intent = new Intent(requireContext(), InviteDriversActivity.class);
        intent.putExtra("extra_ref_code", str);
        startActivity(intent);
    }

    private final void e0() {
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        startActivity(SimpleActivity.Companion.h(companion, requireContext, ReferralCampaignDetailsFragment.class, null, false, 12, null));
    }

    private final void g0(SettingsScreenState settingsScreenState) {
        DiffAdapter.V(this.f32982q, W(settingsScreenState), null, 2, null);
    }

    private final void h0() {
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f32982q);
        ((RecyclerView) S(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
    }

    private final void i0() {
        Navigator X = X();
        if (X != null) {
            X.d(WorkTimeFragment.class, null, true);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f32984s.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f32980o);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32984s;
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
    /* renamed from: f0 */
    public SettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (SettingsViewModel) new ViewModelProvider(this, E.d()).a(SettingsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().i0();
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, getChildFragmentManager(), "TAG_CONFIRM_LOGOUT", this.f32983r, null, 8, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Navigator X = X();
        if (X != null) {
            X.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.settings_account, null, 2, null), false, 5, null));
        }
        h0();
        M().g0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.settings.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountSettingsFragment.c0(AccountSettingsFragment.this, (SettingsScreenState) obj);
            }
        });
    }
}
