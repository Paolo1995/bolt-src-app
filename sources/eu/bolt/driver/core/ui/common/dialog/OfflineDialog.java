package eu.bolt.driver.core.ui.common.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment;
import eu.bolt.driver.core.ui.common.dialog.OfflineDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfflineDialog.kt */
/* loaded from: classes5.dex */
public final class OfflineDialog extends LinearScrollableDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f41103m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41104l = new LinkedHashMap();

    /* compiled from: OfflineDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OfflineDialog a(CharSequence title, CharSequence message, String positiveActionText, String negativeActionText, DialogCallback callback) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(positiveActionText, "positiveActionText");
            Intrinsics.f(negativeActionText, "negativeActionText");
            Intrinsics.f(callback, "callback");
            Bundle bundle = new Bundle();
            bundle.putCharSequence("title", title);
            bundle.putCharSequence("message", message);
            bundle.putString("positive_button", positiveActionText);
            bundle.putString("negative_button", negativeActionText);
            OfflineDialog offlineDialog = new OfflineDialog();
            offlineDialog.setArguments(bundle);
            offlineDialog.K(callback);
            return offlineDialog;
        }
    }

    public OfflineDialog() {
        super(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(OfflineDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "positive");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(OfflineDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "negative");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f41104l.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        M().g(F("title", ""), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
        M().d(F("message", ""), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
        M().h(H("positive_button", ""), new RoundButtonStyle(UiKitRoundButtonType.f36167q, UiKitRoundButtonSize.f36155i), container, new Margins(0, Dimens.c(16), 0, Dimens.c(16), 5, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfflineDialog.R(OfflineDialog.this, view);
            }
        });
        M().e(H("negative_button", ""), container, new Margins(0, 0, 0, 0, 15, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfflineDialog.S(OfflineDialog.this, view);
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
