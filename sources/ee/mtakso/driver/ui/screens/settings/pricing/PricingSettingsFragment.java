package ee.mtakso.driver.ui.screens.settings.pricing;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.DriverPricingConfiguration;
import ee.mtakso.driver.network.client.settings.DriverPricingSetup;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import ee.mtakso.driver.network.client.settings.SliderConfigResponse;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.GoBackNavigatorDelegate;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.ToolbarAppearance;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettings;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsCloseReason;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment;
import ee.mtakso.driver.ui.views.HorizontalSnapPickerView;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockController;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemRadioDelegate;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.ActionDialog;
import eu.bolt.driver.core.ui.common.dialog.InfoDialog;
import eu.bolt.kalev.Kalev;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class PricingSettingsFragment extends BazeMvvmFragment<PricingSettingsViewModel> implements GoBackNavigatorDelegate {

    /* renamed from: w  reason: collision with root package name */
    private static final Companion f33258w = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final PriceFormat f33259o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f33260p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f33261q;

    /* renamed from: r  reason: collision with root package name */
    private final PricingSettingsFragment$confirmationDialogCallback$1 f33262r;

    /* renamed from: s  reason: collision with root package name */
    private final PricingSettingsFragment$unavailableDialogCallback$1 f33263s;

    /* renamed from: t  reason: collision with root package name */
    private InfoBlockController f33264t;

    /* renamed from: u  reason: collision with root package name */
    private final int f33265u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f33266v;

    /* compiled from: PricingSettingsFragment.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PricingSettingsFragment.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33267a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f33268b;

        static {
            int[] iArr = new int[PricingSettingsCloseReason.values().length];
            try {
                iArr[PricingSettingsCloseReason.UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PricingSettingsCloseReason.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f33267a = iArr;
            int[] iArr2 = new int[DriverPricingState.values().length];
            try {
                iArr2[DriverPricingState.STANDARD_PRICING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DriverPricingState.CUSTOM_PRICING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f33268b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v5, types: [ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$confirmationDialogCallback$1] */
    /* JADX WARN: Type inference failed for: r8v6, types: [ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$unavailableDialogCallback$1] */
    @Inject
    public PricingSettingsFragment(BaseUiDependencies deps, PriceFormat decimalFormat) {
        super(deps, R.layout.fragment_pricing_settings, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(decimalFormat, "decimalFormat");
        this.f33266v = new LinkedHashMap();
        this.f33259o = decimalFormat;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = PricingSettingsFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f33260p = b8;
        this.f33261q = new DiffAdapter().P(new TwoLinesItemRadioDelegate(new Function1<TwoLinesItemRadioDelegate.Model<DriverPricingConfiguration.Option>, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$adapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(TwoLinesItemRadioDelegate.Model<DriverPricingConfiguration.Option> it) {
                Intrinsics.f(it, "it");
                PricingSettingsFragment.this.c0(it.s().d().getState());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemRadioDelegate.Model<DriverPricingConfiguration.Option> model) {
                b(model);
                return Unit.f50853a;
            }
        }));
        this.f33262r = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$confirmationDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                PricingSettingsViewModel M;
                PricingSettingsViewModel M2;
                PricingSettingsViewModel M3;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "positive")) {
                    M2 = PricingSettingsFragment.this.M();
                    M2.Z();
                    M3 = PricingSettingsFragment.this.M();
                    M3.L();
                } else if (Intrinsics.a(payload, "negative")) {
                    M = PricingSettingsFragment.this.M();
                    M.Y();
                }
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                PricingSettingsViewModel M;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
                if (event == DialogLifecycleEvent.CANCELLED) {
                    M = PricingSettingsFragment.this.M();
                    M.Y();
                }
            }
        };
        this.f33263s = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$unavailableDialogCallback$1
            /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
                r2 = r1.f33273a.b0();
             */
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment r2, android.view.View r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    java.lang.String r0 = "dialog"
                    kotlin.jvm.internal.Intrinsics.f(r2, r0)
                    java.lang.String r2 = "view"
                    kotlin.jvm.internal.Intrinsics.f(r3, r2)
                    java.lang.String r2 = "payload"
                    kotlin.jvm.internal.Intrinsics.f(r4, r2)
                    java.lang.String r2 = "tag_action"
                    boolean r2 = kotlin.jvm.internal.Intrinsics.a(r4, r2)
                    if (r2 == 0) goto L22
                    ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment r2 = ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment.this
                    ee.mtakso.driver.ui.screens.Navigator r2 = ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment.X(r2)
                    if (r2 == 0) goto L22
                    r2.c()
                L22:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$unavailableDialogCallback$1.a(eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, android.view.View, java.lang.Object):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
                r1 = r0.f33273a.b0();
             */
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void b(eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment r1, eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent r2, java.lang.Object r3) {
                /*
                    r0 = this;
                    java.lang.String r3 = "dialog"
                    kotlin.jvm.internal.Intrinsics.f(r1, r3)
                    java.lang.String r1 = "event"
                    kotlin.jvm.internal.Intrinsics.f(r2, r1)
                    eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent r1 = eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent.CANCELLED
                    if (r2 != r1) goto L19
                    ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment r1 = ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment.this
                    ee.mtakso.driver.ui.screens.Navigator r1 = ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment.X(r1)
                    if (r1 == 0) goto L19
                    r1.c()
                L19:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$unavailableDialogCallback$1.b(eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent, java.lang.Object):void");
            }
        };
        this.f33265u = 2132017818;
    }

    private final ActionDialog a0() {
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("confirmation");
        if (findFragmentByTag instanceof ActionDialog) {
            return (ActionDialog) findFragmentByTag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator b0() {
        return (Navigator) this.f33260p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(DriverPricingState driverPricingState) {
        M().Q(driverPricingState);
        M().b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(PricingSettingsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().U();
        this$0.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(PricingSettingsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().O();
        this$0.M().W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(PricingSettingsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().P();
        this$0.M().X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(PricingSettingsFragment this$0, PricingSettings it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.l0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(PricingSettingsFragment this$0, PricingSettingsCloseReason pricingSettingsCloseReason) {
        int i8;
        Intrinsics.f(this$0, "this$0");
        if (pricingSettingsCloseReason == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f33267a[pricingSettingsCloseReason.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                RuntimeException runtimeException = new RuntimeException("Unsupported reason: " + pricingSettingsCloseReason);
                Kalev.e(runtimeException, "Unsupported reason: " + pricingSettingsCloseReason);
                return;
            }
            InfoDialog.Companion companion = InfoDialog.f41099m;
            String string = this$0.getString(R.string.driver_pricing_error_title);
            Intrinsics.e(string, "getString(R.string.driver_pricing_error_title)");
            String string2 = this$0.getString(R.string.driver_pricing_error_became_unavailable_message_proceed);
            String string3 = this$0.getString(R.string.close);
            Intrinsics.e(string3, "getString(R.string.close)");
            FragmentUtils.b(companion.a(string, null, string2, string3, this$0.f33263s), this$0, "unavailable_error");
            return;
        }
        Navigator b02 = this$0.b0();
        if (b02 != null) {
            b02.c();
        }
    }

    private final void j0(String str, String str2, String str3, String str4, DialogCallback dialogCallback) {
        FragmentUtils.b(ActionDialog.f41071m.a(str, str2, str3, str4, dialogCallback), this, "confirmation");
    }

    private final void k0() {
        String str;
        SliderConfigResponse d8;
        Integer num;
        SliderConfigResponse d9;
        BigDecimal d10;
        PricingSettings f8 = M().K().f();
        if (f8 == null) {
            return;
        }
        DriverPricingConfiguration.Option a8 = PricingSettingsKt.a(f8);
        if (a8 == null) {
            Kalev.m(new IllegalStateException("Price option wasn't selected"), "Price option wasn't selected");
            return;
        }
        DriverPricingState state = a8.d().getState();
        int i8 = WhenMappings.f33268b[state.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                Kalev.m(new IllegalStateException("Unsupported pricing state " + state), "Unsupported pricing state " + state);
                return;
            }
            Object[] objArr = new Object[3];
            objArr[0] = a8.a().b();
            BigDecimal b8 = PricingSettingsKt.b(f8);
            String str2 = null;
            if (b8 != null) {
                PriceFormat priceFormat = this.f33259o;
                DriverPricingSetup c8 = f8.c();
                if (c8 != null && (d9 = c8.d()) != null && (d10 = d9.d()) != null) {
                    num = Integer.valueOf(d10.scale());
                } else {
                    num = null;
                }
                str = priceFormat.a(b8, num);
            } else {
                str = null;
            }
            objArr[1] = str;
            DriverPricingSetup c9 = f8.c();
            if (c9 != null && (d8 = c9.d()) != null) {
                str2 = d8.e();
            }
            objArr[2] = str2;
            String string = getString(R.string.confirm_price_title_format, objArr);
            Intrinsics.e(string, "getString(\n             …g?.unit\n                )");
            String a9 = a8.a().a();
            if (a9 == null) {
                a9 = getString(R.string.driver_pricing_confirm_your_custom_price_message);
                Intrinsics.e(a9, "getString(R.string.drive…our_custom_price_message)");
            }
            String string2 = getString(R.string.confirm_lowercase);
            Intrinsics.e(string2, "getString(R.string.confirm_lowercase)");
            String string3 = getString(R.string.action_cancel);
            Intrinsics.e(string3, "getString(R.string.action_cancel)");
            j0(string, a9, string2, string3, this.f33262r);
            return;
        }
        String b9 = a8.a().b();
        String a10 = a8.a().a();
        if (a10 == null) {
            a10 = getString(R.string.driver_pricing_confirm_your_standard_price_message);
            Intrinsics.e(a10, "getString(R.string.drive…r_standard_price_message)");
        }
        String string4 = getString(R.string.confirm_lowercase);
        Intrinsics.e(string4, "getString(R.string.confirm_lowercase)");
        String string5 = getString(R.string.action_cancel);
        Intrinsics.e(string5, "getString(R.string.action_cancel)");
        j0(b9, a10, string4, string5, this.f33262r);
    }

    private final void l0(PricingSettings pricingSettings) {
        Integer num;
        int v7;
        boolean z7;
        String str;
        DriverPricingConfiguration.InfoBlock b8;
        Text.Value value;
        boolean z8;
        int m8;
        boolean z9;
        SliderConfigResponse d8;
        BigDecimal d9;
        DriverPricingSetup c8 = pricingSettings.c();
        InfoBlockData infoBlockData = null;
        if (c8 != null && (d8 = c8.d()) != null && (d9 = d8.d()) != null) {
            num = Integer.valueOf(d9.scale());
        } else {
            num = null;
        }
        DiffAdapter diffAdapter = this.f33261q;
        List<DriverPricingConfiguration.Option> d10 = pricingSettings.d();
        v7 = CollectionsKt__IterablesKt.v(d10, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : d10) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            DriverPricingConfiguration.Option option = (DriverPricingConfiguration.Option) obj;
            String str2 = "option_" + option.d();
            Text.Value value2 = new Text.Value(option.c().b());
            String a8 = option.c().a();
            if (a8 != null) {
                value = new Text.Value(a8);
            } else {
                value = null;
            }
            if (option.d().getState() == pricingSettings.g()) {
                z8 = true;
            } else {
                z8 = false;
            }
            m8 = CollectionsKt__CollectionsKt.m(pricingSettings.d());
            if (i8 != m8) {
                z9 = true;
            } else {
                z9 = false;
            }
            arrayList.add(new TwoLinesItemRadioDelegate.Model(str2, value2, null, null, value, null, null, null, z8, option, null, z9, 1260, null));
            i8 = i9;
        }
        DiffAdapter.V(diffAdapter, arrayList, null, 2, null);
        TextView subtitleTextView = (TextView) W(R.id.subtitleTextView);
        Intrinsics.e(subtitleTextView, "subtitleTextView");
        TextViewExtKt.h(subtitleTextView, pricingSettings.h());
        Group pricingCustomGroup = (Group) W(R.id.pricingCustomGroup);
        Intrinsics.e(pricingCustomGroup, "pricingCustomGroup");
        if (pricingSettings.g() == DriverPricingState.CUSTOM_PRICING) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(pricingCustomGroup, z7, 0, 2, null);
        RoundButton confirmButton = (RoundButton) W(R.id.confirmButton);
        Intrinsics.e(confirmButton, "confirmButton");
        ViewExtKt.d(confirmButton, PricingSettingsKt.d(pricingSettings), 0, 2, null);
        TextView textView = (TextView) W(R.id.customPricingConfigRateText);
        BigDecimal b9 = PricingSettingsKt.b(pricingSettings);
        if (b9 != null) {
            str = this.f33259o.a(b9, num);
        } else {
            str = null;
        }
        textView.setText(str);
        int i10 = R.id.customPricingPickerView;
        ((HorizontalSnapPickerView) W(i10)).setItemCount(pricingSettings.e().size());
        ((HorizontalSnapPickerView) W(i10)).M(pricingSettings.f());
        ((TextView) W(R.id.customPricingPickerHint)).setText(PricingSettingsKt.c(pricingSettings));
        DriverPricingSetup c9 = pricingSettings.c();
        if (c9 != null) {
            ((HorizontalSnapPickerView) W(i10)).setStartHint(getString(R.string.driver_pricing_custom_picker_min, this.f33259o.a(c9.d().c(), num)));
            ((HorizontalSnapPickerView) W(i10)).setEndHint(getString(R.string.driver_pricing_custom_picker_max, this.f33259o.a(c9.d().b(), num)));
            ((TextView) W(R.id.customPricingConfigUnitText)).setText(c9.d().e());
        }
        InfoBlockController infoBlockController = this.f33264t;
        if (infoBlockController != null) {
            DriverPricingConfiguration.Option a9 = PricingSettingsKt.a(pricingSettings);
            if (a9 != null && (b8 = a9.b()) != null) {
                infoBlockData = DriverPricingConfigurationExtKt.a(b8);
            }
            infoBlockController.b(infoBlockData);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33266v.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33265u);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        IndeterminateProgressView progressView = (IndeterminateProgressView) W(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.d(progressView, false, 0, 2, null);
        ((RoundButton) W(R.id.confirmButton)).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        ActionDialog a02 = a0();
        if (a02 != null) {
            a02.dismissAllowingStateLoss();
        }
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.driver_pricing_error_title);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        String k8 = ApiExceptionUtils.k(error, requireContext);
        String string2 = getString(R.string.close);
        Intrinsics.e(string2, "getString(R.string.close)");
        NotificationDialog f8 = NotificationDialog.Companion.f(companion, string, k8, string2, 0, null, null, 48, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(f8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        int i8 = R.id.confirmButton;
        if (((RoundButton) W(i8)).getVisibility() == 0) {
            ((RoundButton) W(i8)).k();
            return;
        }
        IndeterminateProgressView progressView = (IndeterminateProgressView) W(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.d(progressView, true, 0, 2, null);
    }

    public View W(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33266v;
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

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public boolean c() {
        PricingSettings f8 = M().K().f();
        if (f8 == null) {
            return false;
        }
        PricingSettingsCloseReason f9 = M().J().f();
        Throwable f10 = M().w().f();
        if (f9 != null || f10 != null || !PricingSettingsKt.d(f8)) {
            return false;
        }
        k0();
        return true;
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void d(Class<? extends Fragment> cls, Bundle bundle, boolean z7) {
        GoBackNavigatorDelegate.DefaultImpls.e(this, cls, bundle, z7);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public Navigator e() {
        return GoBackNavigatorDelegate.DefaultImpls.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: i0 */
    public PricingSettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (PricingSettingsViewModel) new ViewModelProvider(this, E.d()).a(PricingSettingsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void n(ToolbarAppearance toolbarAppearance) {
        GoBackNavigatorDelegate.DefaultImpls.c(this, toolbarAppearance);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Navigator navigator;
        Navigator b02;
        super.onDestroyView();
        Navigator b03 = b0();
        if (b03 != null) {
            navigator = b03.e();
        } else {
            navigator = null;
        }
        if (Intrinsics.a(navigator, this) && (b02 = b0()) != null) {
            b02.q(null);
        }
        ((RecyclerView) W(R.id.H9)).setAdapter(null);
        this.f33264t = null;
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            M().a0();
        }
        Navigator b02 = b0();
        if (b02 != null) {
            b02.n(new PopupToolbarAppearance(0, new Text.Resource(R.string.driver_prising_title, null, 2, null), false, 5, null));
        }
        Navigator b03 = b0();
        if (b03 != null) {
            b03.q(this);
        }
        int i8 = R.id.H9;
        ((RecyclerView) W(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) W(i8)).setAdapter(this.f33261q);
        ((RecyclerView) W(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.R(false);
        ((RecyclerView) W(i8)).setItemAnimator(defaultItemAnimator);
        IndeterminateProgressView progressView = (IndeterminateProgressView) W(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.d(progressView, false, 0, 2, null);
        Group pricingCustomGroup = (Group) W(R.id.pricingCustomGroup);
        Intrinsics.e(pricingCustomGroup, "pricingCustomGroup");
        ViewExtKt.d(pricingCustomGroup, false, 0, 2, null);
        int i9 = R.id.confirmButton;
        RoundButton confirmButton = (RoundButton) W(i9);
        Intrinsics.e(confirmButton, "confirmButton");
        ViewExtKt.d(confirmButton, false, 0, 2, null);
        ((RoundButton) W(i9)).setOnClickListener(new View.OnClickListener() { // from class: d5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PricingSettingsFragment.d0(PricingSettingsFragment.this, view2);
            }
        });
        ((ImageButton) W(R.id.customPricingConfigMinusButton)).setOnClickListener(new View.OnClickListener() { // from class: d5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PricingSettingsFragment.e0(PricingSettingsFragment.this, view2);
            }
        });
        ((ImageButton) W(R.id.customPricingConfigPlusButton)).setOnClickListener(new View.OnClickListener() { // from class: d5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PricingSettingsFragment.f0(PricingSettingsFragment.this, view2);
            }
        });
        ((HorizontalSnapPickerView) W(R.id.customPricingPickerView)).setItemPickedListener(new Function2<Integer, Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(int i10, boolean z7) {
                PricingSettingsViewModel M;
                PricingSettingsViewModel M2;
                M = PricingSettingsFragment.this.M();
                M.R(i10);
                if (z7 && ((HorizontalSnapPickerView) PricingSettingsFragment.this.W(R.id.customPricingPickerView)).getScrollState() == 0) {
                    M2 = PricingSettingsFragment.this.M();
                    M2.V();
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Integer num, Boolean bool) {
                b(num.intValue(), bool.booleanValue());
                return Unit.f50853a;
            }
        });
        View customPricingPickerInfo = W(R.id.customPricingPickerInfo);
        Intrinsics.e(customPricingPickerInfo, "customPricingPickerInfo");
        InfoBlockController infoBlockController = new InfoBlockController(customPricingPickerInfo);
        this.f33264t = infoBlockController;
        infoBlockController.b(null);
        M().K().i(getViewLifecycleOwner(), new Observer() { // from class: d5.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PricingSettingsFragment.g0(PricingSettingsFragment.this, (PricingSettings) obj);
            }
        });
        M().J().i(getViewLifecycleOwner(), new Observer() { // from class: d5.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PricingSettingsFragment.h0(PricingSettingsFragment.this, (PricingSettingsCloseReason) obj);
            }
        });
        BaseDialogFragment.Companion companion = BaseDialogFragment.f41026i;
        companion.a(getChildFragmentManager(), "confirmation", this.f33262r);
        companion.a(getChildFragmentManager(), "unavailable_error", this.f33263s);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void q(Navigator navigator) {
        GoBackNavigatorDelegate.DefaultImpls.b(this, navigator);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void x(eu.bolt.driver.core.ui.common.activity.ToolbarAppearance toolbarAppearance) {
        GoBackNavigatorDelegate.DefaultImpls.d(this, toolbarAppearance);
    }
}
