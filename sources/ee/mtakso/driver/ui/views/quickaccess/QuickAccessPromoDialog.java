package ee.mtakso.driver.ui.views.quickaccess;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment;
import eu.bolt.driver.core.ui.common.dialog.helper.ItemViewInflater;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessPromoDialog.kt */
/* loaded from: classes5.dex */
public final class QuickAccessPromoDialog extends LinearScrollableDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f34490m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f34491l = new LinkedHashMap();

    /* compiled from: QuickAccessPromoDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QuickAccessPromoDialog a(DialogCallback callback) {
            Intrinsics.f(callback, "callback");
            QuickAccessPromoDialog quickAccessPromoDialog = new QuickAccessPromoDialog();
            quickAccessPromoDialog.K(callback);
            return quickAccessPromoDialog;
        }
    }

    public QuickAccessPromoDialog() {
        super(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(QuickAccessPromoDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(QuickAccessPromoDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f34491l.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        M().c(R.drawable.ic_quick_access_static, container, new Margins(0, 0, 0, 0, 15, null));
        ItemViewInflater M = M();
        String string = getResources().getString(R.string.title_quick_access_widget);
        Intrinsics.e(string, "resources.getString(R.st…itle_quick_access_widget)");
        M.g(string, container, new Margins(0, 0, 0, 0, 15, null));
        ItemViewInflater M2 = M();
        String string2 = getResources().getString(R.string.desc_quick_access_promo);
        Intrinsics.e(string2, "resources.getString(R.st….desc_quick_access_promo)");
        M2.d(string2, container, new Margins(0, Dimens.d(16), 0, 0, 13, null));
        ItemViewInflater M3 = M();
        String string3 = getString(R.string.action_go_to_settings);
        Intrinsics.e(string3, "getString(R.string.action_go_to_settings)");
        M3.b(string3, container, new Margins(0, Dimens.d(16), 0, 0, 13, null)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickAccessPromoDialog.R(QuickAccessPromoDialog.this, view);
            }
        });
        ItemViewInflater M4 = M();
        String string4 = getString(R.string.action_cancel);
        Intrinsics.e(string4, "getString(R.string.action_cancel)");
        M4.e(string4, container, new Margins(0, Dimens.d(16), 0, 0, 13, null)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickAccessPromoDialog.S(QuickAccessPromoDialog.this, view);
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
