package ee.mtakso.driver.ui.screens.home.v3.delegate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.BackendModalDialogAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.ui.interactor.promodialog.PromoDialog;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import ee.mtakso.driver.ui.screens.score.DriverScoreFragment;
import ee.mtakso.driver.ui.screens.settings.QuickAccessSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsFragment;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessPromoDialog;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.permission.DefaultPermissionCallback;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.ActionDialog;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationDialog;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromoDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class PromoDialogDelegate {

    /* renamed from: k */
    public static final Companion f29883k = new Companion(null);

    /* renamed from: a */
    private final DriverProvider f29884a;

    /* renamed from: b */
    private final OrderAnalytics f29885b;

    /* renamed from: c */
    private final QuickAccessStateAnalytics f29886c;

    /* renamed from: d */
    private final BackendModalDialogAnalytics f29887d;

    /* renamed from: e */
    private final PermissionManager f29888e;

    /* renamed from: f */
    private final SettingsAnalytics f29889f;

    /* renamed from: g */
    private Function1<? super DynamicModalDialog.ActionModel, Unit> f29890g;

    /* renamed from: h */
    private Function0<Unit> f29891h;

    /* renamed from: i */
    private final Function3<DialogFragment, View, Object, Unit> f29892i;

    /* renamed from: j */
    private final PromoDialogDelegate$onDialogCallback$1 f29893j;

    /* compiled from: PromoDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PromoDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public enum Promo {
        DYNAMIC,
        AUTO_NAVIGATION,
        QUICK_ACCESS_PROMO,
        VOIP_PROMO,
        AUTO_ACCEPTANCE_PROMO,
        DRIVER_SCORE_DROPPED,
        NOTIFICATION_PERMISSION,
        TRAINIG
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate$onDialogCallback$1] */
    @Inject
    public PromoDialogDelegate(DriverProvider driverProvider, OrderAnalytics orderAnalytics, QuickAccessStateAnalytics quickAccessStateAnalytics, BackendModalDialogAnalytics backendModalDialogAnalytics, PermissionManager permissionManager, SettingsAnalytics settingsAnalytics) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(orderAnalytics, "orderAnalytics");
        Intrinsics.f(quickAccessStateAnalytics, "quickAccessStateAnalytics");
        Intrinsics.f(backendModalDialogAnalytics, "backendModalDialogAnalytics");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(settingsAnalytics, "settingsAnalytics");
        this.f29884a = driverProvider;
        this.f29885b = orderAnalytics;
        this.f29886c = quickAccessStateAnalytics;
        this.f29887d = backendModalDialogAnalytics;
        this.f29888e = permissionManager;
        this.f29889f = settingsAnalytics;
        this.f29890g = new Function1<DynamicModalDialog.ActionModel, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate$onDynamicDialogActionsListener$1
            public final void b(DynamicModalDialog.ActionModel it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DynamicModalDialog.ActionModel actionModel) {
                b(actionModel);
                return Unit.f50853a;
            }
        };
        this.f29891h = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate$onTrainingDialogRequestedListener$1
            public final void b() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        };
        this.f29892i = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate$onDialogConfirmationListener$1

            /* compiled from: PromoDialogDelegate.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f29906a;

                static {
                    int[] iArr = new int[PromoDialogDelegate.Promo.values().length];
                    try {
                        iArr[PromoDialogDelegate.Promo.DYNAMIC.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f29906a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                DynamicModalDialog.CancelPayload cancelPayload;
                DynamicModalDialog.ActionModel actionModel;
                BackendModalDialogAnalytics backendModalDialogAnalytics2;
                BackendModalDialogAnalytics backendModalDialogAnalytics3;
                Intrinsics.f(dialogFragment, "dialogFragment");
                String tag = dialogFragment.getTag();
                if (tag != null) {
                    Intrinsics.e(tag, "checkNotNull(dialogFragment.tag)");
                    if (WhenMappings.f29906a[PromoDialogDelegate.Promo.valueOf(tag).ordinal()] == 1) {
                        String str = null;
                        if (obj instanceof DynamicModalDialog.CancelPayload) {
                            cancelPayload = (DynamicModalDialog.CancelPayload) obj;
                        } else {
                            cancelPayload = null;
                        }
                        if (cancelPayload != null) {
                            backendModalDialogAnalytics3 = PromoDialogDelegate.this.f29887d;
                            backendModalDialogAnalytics3.W(cancelPayload.a());
                        }
                        if (obj instanceof DynamicModalDialog.ActionModel) {
                            actionModel = (DynamicModalDialog.ActionModel) obj;
                        } else {
                            actionModel = null;
                        }
                        if (actionModel != null) {
                            PromoDialogDelegate promoDialogDelegate = PromoDialogDelegate.this;
                            promoDialogDelegate.i().invoke(actionModel);
                            backendModalDialogAnalytics2 = promoDialogDelegate.f29887d;
                            DynamicModalDialog.ModalInfo c8 = actionModel.c();
                            if (c8 != null) {
                                str = c8.a();
                            }
                            backendModalDialogAnalytics2.A0(str, actionModel.a());
                        }
                    }
                    if (!Intrinsics.a(obj, "dialog_shown")) {
                        dialogFragment.dismissAllowingStateLoss();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.f29893j = new DialogCallback() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate$onDialogCallback$1

            /* compiled from: PromoDialogDelegate.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f29904a;

                static {
                    int[] iArr = new int[PromoDialogDelegate.Promo.values().length];
                    try {
                        iArr[PromoDialogDelegate.Promo.DRIVER_SCORE_DROPPED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PromoDialogDelegate.Promo.QUICK_ACCESS_PROMO.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PromoDialogDelegate.Promo.AUTO_ACCEPTANCE_PROMO.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PromoDialogDelegate.Promo.VOIP_PROMO.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[PromoDialogDelegate.Promo.AUTO_NAVIGATION.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[PromoDialogDelegate.Promo.NOTIFICATION_PERMISSION.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[PromoDialogDelegate.Promo.TRAINIG.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    f29904a = iArr;
                }
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            @SuppressLint({"InlinedApi"})
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                boolean a8 = Intrinsics.a(payload, "ITEM_CONFIRM_TAG");
                Context requireContext = dialog.requireContext();
                Intrinsics.e(requireContext, "dialog.requireContext()");
                String tag = dialog.getTag();
                if (tag != null) {
                    Intrinsics.e(tag, "checkNotNull(dialog.tag)");
                    switch (WhenMappings.f29904a[PromoDialogDelegate.Promo.valueOf(tag).ordinal()]) {
                        case 1:
                            PromoDialogDelegate.this.l(payload, dialog);
                            return;
                        case 2:
                            PromoDialogDelegate.this.n(requireContext);
                            return;
                        case 3:
                            PromoDialogDelegate.this.j(requireContext, a8);
                            return;
                        case 4:
                            PromoDialogDelegate.this.o(dialog, a8);
                            return;
                        case 5:
                            PromoDialogDelegate.this.k(dialog, a8);
                            return;
                        case 6:
                            PromoDialogDelegate.this.m(payload, dialog);
                            return;
                        case 7:
                            PromoDialogDelegate.this.p(a8);
                            return;
                        default:
                            return;
                    }
                }
                throw new IllegalStateException("Required value was null.".toString());
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void B(PromoDialogDelegate promoDialogDelegate, FragmentActivity fragmentActivity, PromoDialog promoDialog, ActivityResultLauncher activityResultLauncher, LowStorageDialogDelegate lowStorageDialogDelegate, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            activityResultLauncher = null;
        }
        if ((i8 & 8) != 0) {
            lowStorageDialogDelegate = null;
        }
        promoDialogDelegate.A(fragmentActivity, promoDialog, activityResultLauncher, lowStorageDialogDelegate);
    }

    private final void C(FragmentActivity fragmentActivity) {
        FragmentUtils.c(QuickAccessPromoDialog.f34490m.a(this.f29893j), fragmentActivity, "QUICK_ACCESS_PROMO");
        this.f29884a.w().j0(true);
        this.f29886c.p4();
    }

    private final void D(FragmentActivity fragmentActivity, ActivityResultLauncher<Intent> activityResultLauncher, PromoDialog.Story story) {
        Unit unit;
        Intent g8 = SimpleActivity.f27004l.g(fragmentActivity, StorySetFragment.class, StorySetFragment.f41557p.a(story.a().b().a(), true), false);
        fragmentActivity.overridePendingTransition(R.anim.story_enter, R.anim.story_exit);
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(g8);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            fragmentActivity.startActivity(g8);
        }
    }

    private final void E(FragmentActivity fragmentActivity) {
        String string;
        ConfirmationWithIconDialog a8;
        boolean a9 = PermissionManager.f40899f.a(this.f29888e.o("android.permission.RECORD_AUDIO"));
        if (a9) {
            string = fragmentActivity.getString(R.string.go_to_settings);
        } else {
            string = fragmentActivity.getString(R.string.allow);
        }
        String str = string;
        Intrinsics.e(str, "if (shouldNavigateUserTo…R.string.allow)\n        }");
        ConfirmationWithIconDialog.Companion companion = ConfirmationWithIconDialog.f41082m;
        String string2 = fragmentActivity.getString(R.string.voip_permission_record_audio_promo_dialog_title);
        Intrinsics.e(string2, "activity.getString(R.str…audio_promo_dialog_title)");
        String string3 = fragmentActivity.getString(R.string.voip_permission_record_audio_promo_dialog_description);
        Intrinsics.e(string3, "activity.getString(R.str…promo_dialog_description)");
        String string4 = fragmentActivity.getString(R.string.do_not_allow);
        Intrinsics.e(string4, "activity.getString(R.string.do_not_allow)");
        a8 = companion.a(R.drawable.ic_call_in_app_filled, string2, string3, str, (r20 & 16) != 0 ? UiKitRoundButtonType.f36161k : null, string4, this.f29893j, (r20 & 128) != 0 ? null : BundleKt.a(TuplesKt.a("arg_is_leading_to_settings", Boolean.valueOf(a9))));
        FragmentUtils.c(a8, fragmentActivity, "VOIP_PROMO");
        this.f29884a.w().p0(true);
    }

    public final void j(Context context, boolean z7) {
        if (z7) {
            SimpleActivity.Companion.m(SimpleActivity.f27004l, context, AutoAcceptanceSettingsFragment.class, null, true, 4, null);
        }
    }

    public final void k(BaseDialogFragment baseDialogFragment, boolean z7) {
        if (z7) {
            boolean z8 = false;
            if (!this.f29884a.q().r() ? this.f29884a.w().r().a() == Navigator.Type.NO_NAVIGATION_SELECTED : this.f29884a.v().I().a() == null) {
                z8 = true;
            }
            if (z8) {
                this.f29884a.w().J().b(true);
                NavigatorChooserFragment.Companion companion = NavigatorChooserFragment.f30914t;
                FragmentActivity requireActivity = baseDialogFragment.requireActivity();
                Intrinsics.e(requireActivity, "dialog.requireActivity()");
                companion.b(requireActivity, 754);
                return;
            }
            this.f29885b.a(true, OrderAnalytics.EventSource.PROMPT);
            this.f29889f.n4(true);
            this.f29884a.w().f().b(true);
        }
    }

    public final void l(Object obj, BaseDialogFragment baseDialogFragment) {
        if (Intrinsics.a(obj, "positive")) {
            SimpleActivity.Companion companion = SimpleActivity.f27004l;
            Context requireContext = baseDialogFragment.requireContext();
            Intrinsics.e(requireContext, "dialog.requireContext()");
            companion.l(requireContext, DriverScoreFragment.class, DriverScoreFragment.f32903t.a(), true);
        }
        baseDialogFragment.dismissAllowingStateLoss();
    }

    public final void m(Object obj, BaseDialogFragment baseDialogFragment) {
        String str;
        if (Intrinsics.a(obj, "positive")) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            Context context = baseDialogFragment.getContext();
            if (context != null) {
                str = context.getPackageName();
            } else {
                str = null;
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", str);
            baseDialogFragment.requireActivity().startActivity(intent);
        }
        baseDialogFragment.dismissAllowingStateLoss();
    }

    public final void n(Context context) {
        this.f29886c.u();
        SimpleActivity.Companion.m(SimpleActivity.f27004l, context, QuickAccessSettingsFragment.class, null, true, 4, null);
    }

    public final void o(BaseDialogFragment baseDialogFragment, boolean z7) {
        Context requireContext = baseDialogFragment.requireContext();
        Intrinsics.e(requireContext, "dialog.requireContext()");
        boolean z8 = baseDialogFragment.requireArguments().getBoolean("arg_is_leading_to_settings", false);
        if (z7) {
            if (z8) {
                requireContext.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", requireContext.getPackageName(), null)));
            } else {
                this.f29888e.k("android.permission.RECORD_AUDIO", new DefaultPermissionCallback());
            }
        }
    }

    public final void p(boolean z7) {
        if (z7) {
            this.f29891h.invoke();
        }
    }

    private final void t(FragmentActivity fragmentActivity) {
        ConfirmationWithIconDialog a8;
        ConfirmationWithIconDialog.Companion companion = ConfirmationWithIconDialog.f41082m;
        String string = fragmentActivity.getString(R.string.auto_accept);
        Intrinsics.e(string, "activity.getString(R.string.auto_accept)");
        String string2 = fragmentActivity.getString(R.string.auto_accept_promo_desc);
        Intrinsics.e(string2, "activity.getString(R.str…g.auto_accept_promo_desc)");
        String string3 = fragmentActivity.getString(R.string.go_to_settings);
        Intrinsics.e(string3, "activity.getString(R.string.go_to_settings)");
        String string4 = fragmentActivity.getString(R.string.action_cancel);
        Intrinsics.e(string4, "activity.getString(R.string.action_cancel)");
        a8 = companion.a(R.drawable.ic_lightning_purple500, string, string2, string3, (r20 & 16) != 0 ? UiKitRoundButtonType.f36161k : null, string4, this.f29893j, (r20 & 128) != 0 ? null : null);
        FragmentUtils.c(a8, fragmentActivity, "AUTO_ACCEPTANCE_PROMO");
        this.f29884a.w().X(true);
    }

    private final void u(FragmentActivity fragmentActivity) {
        this.f29884a.w().g().b(true);
        ConfirmationDialog.Companion companion = ConfirmationDialog.f41075m;
        String string = fragmentActivity.getString(R.string.auto_navigation_prompt_title);
        Intrinsics.e(string, "activity.getString(R.str…_navigation_prompt_title)");
        String string2 = fragmentActivity.getString(R.string.auto_navigation_prompt_content);
        Intrinsics.e(string2, "activity.getString(R.str…avigation_prompt_content)");
        String string3 = fragmentActivity.getString(R.string.auto_navigation_prompt_confirm_button);
        Intrinsics.e(string3, "activity.getString(R.str…on_prompt_confirm_button)");
        String string4 = fragmentActivity.getString(R.string.auto_navigation_prompt_cancel_button_lowercase);
        Intrinsics.e(string4, "activity.getString(R.str…_cancel_button_lowercase)");
        FragmentUtils.c(ConfirmationDialog.Companion.b(companion, string, string2, string3, null, string4, this.f29893j, null, 72, null), fragmentActivity, "AUTO_NAVIGATION");
    }

    private final void v(FragmentActivity fragmentActivity, PromoDialog.DriverScoreDropped driverScoreDropped) {
        ActionDialog.Companion companion = ActionDialog.f41071m;
        String string = fragmentActivity.getString(R.string.driver_score_dropped_title, driverScoreDropped.a());
        Intrinsics.e(string, "activity.getString(R.str…dialog.droppedScoreValue)");
        String string2 = fragmentActivity.getString(R.string.driver_score_dropped_message);
        Intrinsics.e(string2, "activity.getString(R.str…er_score_dropped_message)");
        String string3 = fragmentActivity.getString(R.string.find_out_more);
        Intrinsics.e(string3, "activity.getString(R.string.find_out_more)");
        String string4 = fragmentActivity.getString(R.string.close);
        Intrinsics.e(string4, "activity.getString(R.string.close)");
        FragmentUtils.c(companion.a(string, string2, string3, string4, this.f29893j), fragmentActivity, "DRIVER_SCORE_DROPPED");
        this.f29884a.w().a0(true);
    }

    private final void w(FragmentActivity fragmentActivity, PromoDialog.Dynamic dynamic) {
        DynamicModalDialog.Companion companion = DynamicModalDialog.f28274o;
        FragmentUtils.c(companion.a(companion.d(dynamic.a(), Integer.valueOf((int) R.drawable.ic_hand_stop_24dp)), this.f29892i), fragmentActivity, "DYNAMIC");
        this.f29887d.J3(dynamic.a().a());
    }

    private final void x(FragmentActivity fragmentActivity, LowStorageDialogDelegate lowStorageDialogDelegate) {
        if (lowStorageDialogDelegate != null) {
            lowStorageDialogDelegate.c(fragmentActivity);
            this.f29884a.w().h0(true);
            return;
        }
        Kalev.d("Low Storage Dialog delegate is null");
    }

    private final void y(FragmentActivity fragmentActivity, ModalDialogResponse.Dialog.DialogPayload dialogPayload) {
        DynamicModalDialog.Companion companion = DynamicModalDialog.f28274o;
        FragmentUtils.c(companion.a(DynamicModalDialog.Companion.f(companion, "training-dialog", dialogPayload, null, null, 12, null), this.f29892i), fragmentActivity, "DYNAMIC");
    }

    private final void z(FragmentActivity fragmentActivity) {
        ActionDialog.Companion companion = ActionDialog.f41071m;
        String string = fragmentActivity.getString(R.string.turn_on_push_notifications);
        Intrinsics.e(string, "activity.getString(R.str…rn_on_push_notifications)");
        String string2 = fragmentActivity.getString(R.string.turn_on_push_notifications_message);
        Intrinsics.e(string2, "activity.getString(R.str…sh_notifications_message)");
        String string3 = fragmentActivity.getString(R.string.action_turn_on);
        Intrinsics.e(string3, "activity.getString(R.string.action_turn_on)");
        String string4 = fragmentActivity.getString(R.string.action_cancel);
        Intrinsics.e(string4, "activity.getString(R.string.action_cancel)");
        FragmentUtils.c(companion.a(string, string2, string3, string4, this.f29893j), fragmentActivity, "NOTIFICATION_PERMISSION");
    }

    public final void A(FragmentActivity activity, PromoDialog dialog, ActivityResultLauncher<Intent> activityResultLauncher, LowStorageDialogDelegate lowStorageDialogDelegate) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(dialog, "dialog");
        if (dialog instanceof PromoDialog.Dynamic) {
            w(activity, (PromoDialog.Dynamic) dialog);
        } else if (dialog instanceof PromoDialog.QuickAccess) {
            C(activity);
        } else if (dialog instanceof PromoDialog.Voip) {
            E(activity);
        } else if (dialog instanceof PromoDialog.AutoAcceptance) {
            t(activity);
        } else if (dialog instanceof PromoDialog.AutoNavigation) {
            u(activity);
        } else if (dialog instanceof PromoDialog.DriverScoreDropped) {
            v(activity, (PromoDialog.DriverScoreDropped) dialog);
        } else if (dialog instanceof PromoDialog.NotificationPermission) {
            z(activity);
        } else if (dialog instanceof PromoDialog.Training) {
            y(activity, ((PromoDialog.Training) dialog).a());
        } else if (dialog instanceof PromoDialog.Story) {
            D(activity, activityResultLauncher, (PromoDialog.Story) dialog);
        } else if (!(dialog instanceof PromoDialog.Banner) && (dialog instanceof PromoDialog.LowStorage)) {
            x(activity, lowStorageDialogDelegate);
        }
    }

    public final Function1<DynamicModalDialog.ActionModel, Unit> i() {
        return this.f29890g;
    }

    public final void q(FragmentActivity activity) {
        Promo[] values;
        Intrinsics.f(activity, "activity");
        for (Promo promo : Promo.values()) {
            RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, activity.getSupportFragmentManager(), promo.name(), this.f29892i, null, 8, null);
            BaseDialogFragment.f41026i.a(activity.getSupportFragmentManager(), promo.name(), this.f29893j);
        }
    }

    public final void r(Function1<? super DynamicModalDialog.ActionModel, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f29890g = function1;
    }

    public final void s(Function0<Unit> function0) {
        Intrinsics.f(function0, "<set-?>");
        this.f29891h = function0;
    }
}
