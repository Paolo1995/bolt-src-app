package ee.mtakso.driver.ui.screens.work;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.network.client.driver.PricingData;
import ee.mtakso.driver.network.client.driver.PricingRequiredAction;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.modules.status.GoOnlineIssue;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.AssertUtils;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.kalev.Kalev;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingRequiredDialogDelegate.kt */
/* loaded from: classes5.dex */
public final class PricingRequiredDialogDelegate {

    /* renamed from: e  reason: collision with root package name */
    private static final Companion f33654e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverPricingAnalytics f33655a;

    /* renamed from: b  reason: collision with root package name */
    private final HtmlEngine f33656b;

    /* renamed from: c  reason: collision with root package name */
    private Function1<? super PricingRequiredAction, Unit> f33657c;

    /* renamed from: d  reason: collision with root package name */
    private Function2<? super PricingRequiredAction, ? super PricingData, Unit> f33658d;

    /* compiled from: PricingRequiredDialogDelegate.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PricingRequiredDialogDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33659a;

        static {
            int[] iArr = new int[DriverPricingState.values().length];
            try {
                iArr[DriverPricingState.STANDARD_PRICING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverPricingState.CUSTOM_PRICING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f33659a = iArr;
        }
    }

    public PricingRequiredDialogDelegate(DriverPricingAnalytics driverPricingAnalytics, HtmlEngine htmlEngine) {
        Intrinsics.f(driverPricingAnalytics, "driverPricingAnalytics");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f33655a = driverPricingAnalytics;
        this.f33656b = htmlEngine;
        this.f33657c = new Function1<PricingRequiredAction, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.PricingRequiredDialogDelegate$pricingRequiredCallback$1
            public final void b(PricingRequiredAction it) {
                Intrinsics.f(it, "it");
                AssertUtils.a("pricingRequiredCallback isn't defined");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PricingRequiredAction pricingRequiredAction) {
                b(pricingRequiredAction);
                return Unit.f50853a;
            }
        };
        this.f33658d = new Function2<PricingRequiredAction, PricingData, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.PricingRequiredDialogDelegate$pricingConfirmationCallback$1
            public final void b(PricingRequiredAction pricingRequiredAction, PricingData pricingData) {
                Intrinsics.f(pricingRequiredAction, "<anonymous parameter 0>");
                Intrinsics.f(pricingData, "<anonymous parameter 1>");
                AssertUtils.a("pricingConfirmationCallback isn't defined");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(PricingRequiredAction pricingRequiredAction, PricingData pricingData) {
                b(pricingRequiredAction, pricingData);
                return Unit.f50853a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(DialogFragment dialogFragment, Object obj, Function2<? super PricingRequiredAction, ? super PricingData, Unit> function2) {
        PricingRequiredAction pricingRequiredAction;
        PricingData pricingData;
        PricingRequiredAction pricingRequiredAction2;
        PricingData pricingData2;
        PricingData pricingData3 = null;
        if (Intrinsics.a(obj, "confirm")) {
            dialogFragment.dismissAllowingStateLoss();
            Bundle arguments = dialogFragment.getArguments();
            if (arguments != null) {
                pricingRequiredAction2 = (PricingRequiredAction) arguments.getParcelable("pricing_confirm_action");
            } else {
                pricingRequiredAction2 = null;
            }
            if (!(pricingRequiredAction2 instanceof PricingRequiredAction)) {
                pricingRequiredAction2 = null;
            }
            Bundle arguments2 = dialogFragment.getArguments();
            if (arguments2 != null) {
                pricingData2 = (PricingData) arguments2.getParcelable("pricing_data");
            } else {
                pricingData2 = null;
            }
            if (pricingData2 instanceof PricingData) {
                pricingData3 = pricingData2;
            }
            if (pricingRequiredAction2 != null && pricingData3 != null) {
                int i8 = WhenMappings.f33659a[pricingData3.b().ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        String str = "track unsupported DriverPricingState=" + pricingData3.b();
                        Kalev.e(new IllegalArgumentException(str), str);
                    } else {
                        this.f33655a.q1(pricingData3.a());
                    }
                } else {
                    this.f33655a.Q2();
                }
                function2.s(pricingRequiredAction2, pricingData3);
                return;
            }
            Kalev.l("Missing arguments!");
        } else if (Intrinsics.a(obj, "cancel")) {
            dialogFragment.dismissAllowingStateLoss();
            Bundle arguments3 = dialogFragment.getArguments();
            if (arguments3 != null) {
                pricingRequiredAction = (PricingRequiredAction) arguments3.getParcelable("pricing_change_action");
            } else {
                pricingRequiredAction = null;
            }
            if (!(pricingRequiredAction instanceof PricingRequiredAction)) {
                pricingRequiredAction = null;
            }
            Bundle arguments4 = dialogFragment.getArguments();
            if (arguments4 != null) {
                pricingData = (PricingData) arguments4.getParcelable("pricing_data");
            } else {
                pricingData = null;
            }
            if (pricingData instanceof PricingData) {
                pricingData3 = pricingData;
            }
            if (pricingRequiredAction != null && pricingData3 != null) {
                int i9 = WhenMappings.f33659a[pricingData3.b().ordinal()];
                if (i9 != 1) {
                    if (i9 != 2) {
                        String str2 = "track unsupported DriverPricingState=" + pricingData3.b();
                        Kalev.e(new IllegalArgumentException(str2), str2);
                    } else {
                        this.f33655a.j4();
                    }
                } else {
                    this.f33655a.R1();
                }
                function2.s(pricingRequiredAction, pricingData3);
                return;
            }
            Kalev.l("Missing arguments!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(DialogFragment dialogFragment, Object obj, Function1<? super PricingRequiredAction, Unit> function1) {
        PricingRequiredAction pricingRequiredAction;
        if (Intrinsics.a(obj, "confirm")) {
            dialogFragment.dismissAllowingStateLoss();
            Bundle arguments = dialogFragment.getArguments();
            PricingRequiredAction pricingRequiredAction2 = null;
            if (arguments != null) {
                pricingRequiredAction = (PricingRequiredAction) arguments.getParcelable("action");
            } else {
                pricingRequiredAction = null;
            }
            if (pricingRequiredAction instanceof PricingRequiredAction) {
                pricingRequiredAction2 = pricingRequiredAction;
            }
            if (pricingRequiredAction2 != null) {
                this.f33655a.w0();
                function1.invoke(pricingRequiredAction2);
                return;
            }
            Kalev.l("Missing arguments!");
        } else if (Intrinsics.a(obj, "cancel")) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    public final Function2<PricingRequiredAction, PricingData, Unit> c() {
        return this.f33658d;
    }

    public final Function1<PricingRequiredAction, Unit> d() {
        return this.f33657c;
    }

    public final void g(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        RestoreableDialogFragment.Companion companion = RestoreableDialogFragment.f34751j;
        RestoreableDialogFragment.Companion.b(companion, fragment.getChildFragmentManager(), "pricing_required", new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.PricingRequiredDialogDelegate$restoreCallbacks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialog, View view, Object obj) {
                Intrinsics.f(dialog, "dialog");
                PricingRequiredDialogDelegate pricingRequiredDialogDelegate = PricingRequiredDialogDelegate.this;
                pricingRequiredDialogDelegate.f(dialog, obj, pricingRequiredDialogDelegate.d());
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        }, null, 8, null);
        RestoreableDialogFragment.Companion.b(companion, fragment.getChildFragmentManager(), "pricing_confirmation_required", new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.PricingRequiredDialogDelegate$restoreCallbacks$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialog, View view, Object obj) {
                Intrinsics.f(dialog, "dialog");
                PricingRequiredDialogDelegate pricingRequiredDialogDelegate = PricingRequiredDialogDelegate.this;
                pricingRequiredDialogDelegate.e(dialog, obj, pricingRequiredDialogDelegate.c());
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        }, null, 8, null);
    }

    public final void h(Function2<? super PricingRequiredAction, ? super PricingData, Unit> function2) {
        Intrinsics.f(function2, "<set-?>");
        this.f33658d = function2;
    }

    public final void i(Function1<? super PricingRequiredAction, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f33657c = function1;
    }

    public final void j(Fragment fragment, GoOnlineIssue.PricingConfirmation pricingRequired) {
        Object obj;
        Object obj2;
        boolean z7;
        boolean z8;
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(pricingRequired, "pricingRequired");
        Iterator<T> it = pricingRequired.a().a().iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (((PricingRequiredAction) obj2).b() == null) {
                    z8 = true;
                    continue;
                } else {
                    z8 = false;
                    continue;
                }
                if (z8) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        PricingRequiredAction pricingRequiredAction = (PricingRequiredAction) obj2;
        Iterator<T> it2 = pricingRequired.a().a().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((PricingRequiredAction) next).b() != null) {
                z7 = true;
                continue;
            } else {
                z7 = false;
                continue;
            }
            if (z7) {
                obj = next;
                break;
            }
        }
        PricingRequiredAction pricingRequiredAction2 = (PricingRequiredAction) obj;
        if (pricingRequiredAction != null && pricingRequiredAction2 != null) {
            ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
            String c8 = pricingRequired.a().c();
            CharSequence a8 = this.f33656b.a(pricingRequired.a().b());
            String a9 = pricingRequiredAction.a();
            UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
            String a10 = pricingRequiredAction2.a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("pricing_confirm_action", pricingRequiredAction);
            bundle.putParcelable("pricing_change_action", pricingRequiredAction2);
            bundle.putParcelable("pricing_data", pricingRequired.b());
            Unit unit = Unit.f50853a;
            FragmentUtils.b(ConfirmationDialog.Companion.b(companion, c8, a8, a9, null, uiKitRoundButtonType, a10, null, bundle, new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.PricingRequiredDialogDelegate$showConfirmation$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                public final void b(DialogFragment dialog, View view, Object obj3) {
                    Intrinsics.f(dialog, "dialog");
                    PricingRequiredDialogDelegate pricingRequiredDialogDelegate = PricingRequiredDialogDelegate.this;
                    pricingRequiredDialogDelegate.e(dialog, obj3, pricingRequiredDialogDelegate.c());
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj3) {
                    b(dialogFragment, view, obj3);
                    return Unit.f50853a;
                }
            }, 72, null), fragment, "pricing_confirmation_required");
            return;
        }
        Kalev.l("Pricing confirmation required data doesn't contain action!!!");
    }

    public final void k(Fragment fragment, GoOnlineIssue.PricingNotChosen pricingRequired) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(pricingRequired, "pricingRequired");
        PricingRequiredAction pricingRequiredAction = (PricingRequiredAction) CollectionsKt___CollectionsKt.Y(pricingRequired.a().a());
        if (pricingRequiredAction == null) {
            Kalev.l("Pricing required data doesn't contains action!!!");
            return;
        }
        this.f33655a.o4();
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String c8 = pricingRequired.a().c();
        CharSequence a8 = this.f33656b.a(pricingRequired.a().b());
        String a9 = pricingRequiredAction.a();
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
        Bundle bundle = new Bundle();
        bundle.putParcelable("action", pricingRequiredAction);
        Unit unit = Unit.f50853a;
        FragmentUtils.b(ConfirmationDialog.Companion.b(companion, c8, a8, a9, null, uiKitRoundButtonType, null, null, bundle, new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.PricingRequiredDialogDelegate$showNotChosen$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialog, View view, Object obj) {
                Intrinsics.f(dialog, "dialog");
                PricingRequiredDialogDelegate pricingRequiredDialogDelegate = PricingRequiredDialogDelegate.this;
                pricingRequiredDialogDelegate.f(dialog, obj, pricingRequiredDialogDelegate.d());
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        }, 104, null), fragment, "pricing_required");
    }
}
