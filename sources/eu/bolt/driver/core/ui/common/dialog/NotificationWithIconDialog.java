package eu.bolt.driver.core.ui.common.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment;
import eu.bolt.driver.core.ui.common.dialog.NotificationWithIconDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationWithIconDialog.kt */
/* loaded from: classes5.dex */
public final class NotificationWithIconDialog extends LinearScrollableDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f41101m = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41102l = new LinkedHashMap();

    /* compiled from: NotificationWithIconDialog.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NotificationWithIconDialog a(int i8, String title, String message, String buttonText, DialogCallback callback) {
            Intrinsics.f(title, "title");
            Intrinsics.f(message, "message");
            Intrinsics.f(buttonText, "buttonText");
            Intrinsics.f(callback, "callback");
            Bundle bundle = new Bundle();
            bundle.putInt("icon", i8);
            bundle.putString("title", title);
            bundle.putString("message", message);
            bundle.putString("dismiss", buttonText);
            NotificationWithIconDialog notificationWithIconDialog = new NotificationWithIconDialog();
            notificationWithIconDialog.setArguments(bundle);
            notificationWithIconDialog.K(callback);
            return notificationWithIconDialog;
        }
    }

    public NotificationWithIconDialog() {
        super(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(NotificationWithIconDialog this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        DialogCallback I = this$0.I();
        Intrinsics.e(it, "it");
        I.a(this$0, it, "dismiss");
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f41102l.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment
    public void N(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        M().c(G("icon"), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
        M().g(H("title", ""), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
        M().d(H("message", ""), container, new Margins(0, 0, 0, Dimens.c(16), 7, null));
        M().e(H("dismiss", ""), container, new Margins(0, 0, 0, Dimens.c(16), 7, null)).setOnClickListener(new View.OnClickListener() { // from class: f7.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationWithIconDialog.Q(NotificationWithIconDialog.this, view);
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment, eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
