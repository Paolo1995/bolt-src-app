package eu.bolt.driver.core.ui.common.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment;
import eu.bolt.driver.core.ui.common.dialog.InfoDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoDialog.kt */
/* loaded from: classes5.dex */
public final class InfoDialog extends LinearScrollableDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f41099m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41100l = new LinkedHashMap();

    /* compiled from: InfoDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InfoDialog a(String title, String str, String str2, String action, DialogCallback callback) {
            Intrinsics.f(title, "title");
            Intrinsics.f(action, "action");
            Intrinsics.f(callback, "callback");
            Bundle bundle = new Bundle();
            bundle.putString("arg_title", title);
            bundle.putString("arg_subtitle", str);
            bundle.putString("arg_message", str2);
            bundle.putString("arg_action", action);
            InfoDialog infoDialog = new InfoDialog();
            infoDialog.setArguments(bundle);
            infoDialog.K(callback);
            return infoDialog;
        }
    }

    public InfoDialog() {
        super(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(InfoDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "tag_action");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f41100l.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        M().g(H("arg_title", ""), container, new Margins(0, 0, 0, 0, 15, null)).setGravity(8388611);
        M().f(H("arg_subtitle", ""), container, new Margins(0, Dimens.c(4), 0, 0, 13, null)).setGravity(8388611);
        M().d(H("arg_message", ""), container, new Margins(0, Dimens.c(16), 0, Dimens.c(16), 5, null)).setGravity(8388611);
        M().e(H("arg_action", ""), container, new Margins(0, 0, 0, 0, 15, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.Q(InfoDialog.this, view);
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
