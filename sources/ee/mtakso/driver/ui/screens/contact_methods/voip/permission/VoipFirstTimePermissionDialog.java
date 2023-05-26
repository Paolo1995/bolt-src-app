package ee.mtakso.driver.ui.screens.contact_methods.voip.permission;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipFirstTimePermissionDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipMicrophonePermissionDialog.kt */
/* loaded from: classes3.dex */
public final class VoipFirstTimePermissionDialog extends BaseDialogFragment {

    /* renamed from: m  reason: collision with root package name */
    public Map<Integer, View> f28075m = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(VoipFirstTimePermissionDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "dialog_request_permission");
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(VoipFirstTimePermissionDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "dialog_deny_request_permission");
        }
        this$0.dismissAllowingStateLoss();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28075m.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28075m;
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

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public void O(ViewGroup container, Bundle bundle) {
        Intrinsics.f(container, "container");
        ItemViewFactory itemViewFactory = ItemViewFactory.f35921a;
        ViewGroup N = N();
        String string = getResources().getString(R.string.voip_permission_record_audio_first_time_dialog_title);
        Intrinsics.e(string, "resources.getString(R.st…_first_time_dialog_title)");
        ItemViewFactory.p(itemViewFactory, N, string, null, 4, null);
        ViewGroup N2 = N();
        String string2 = getResources().getString(R.string.voip_permission_record_audio_first_time_dialog_description);
        Intrinsics.e(string2, "resources.getString(R.st…_time_dialog_description)");
        Rect rect = new Rect();
        rect.top = Dimens.d(16);
        Unit unit = Unit.f50853a;
        itemViewFactory.h(N2, string2, rect);
        ViewGroup N3 = N();
        String string3 = getResources().getString(R.string.voip_permission_record_audio_first_time_dialog_allow);
        Intrinsics.e(string3, "resources.getString(R.st…_first_time_dialog_allow)");
        ItemViewFactory.d(itemViewFactory, N3, string3, null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: e3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoipFirstTimePermissionDialog.R(VoipFirstTimePermissionDialog.this, view);
            }
        });
        ViewGroup N4 = N();
        String string4 = getResources().getString(R.string.voip_permission_record_audio_first_time_dialog_cancel);
        Intrinsics.e(string4, "resources.getString(R.st…first_time_dialog_cancel)");
        ItemViewFactory.l(itemViewFactory, N4, string4, null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: e3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoipFirstTimePermissionDialog.S(VoipFirstTimePermissionDialog.this, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
