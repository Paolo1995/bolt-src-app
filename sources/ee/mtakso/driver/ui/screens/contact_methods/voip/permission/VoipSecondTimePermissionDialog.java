package ee.mtakso.driver.ui.screens.contact_methods.voip.permission;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipSecondTimePermissionDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipMicrophonePermissionDialog.kt */
/* loaded from: classes3.dex */
public final class VoipSecondTimePermissionDialog extends BaseDialogFragment {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f28080n = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    public Map<Integer, View> f28081m = new LinkedHashMap();

    /* compiled from: VoipMicrophonePermissionDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VoipSecondTimePermissionDialog a(boolean z7) {
            VoipSecondTimePermissionDialog voipSecondTimePermissionDialog = new VoipSecondTimePermissionDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean("args.leads_to_settings", z7);
            voipSecondTimePermissionDialog.setArguments(bundle);
            return voipSecondTimePermissionDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(boolean z7, VoipSecondTimePermissionDialog this$0, View view) {
        String str;
        Intrinsics.f(this$0, "this$0");
        if (z7) {
            str = "dialog_leads_to_settings";
        } else {
            str = "dialog_request_permission";
        }
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, str);
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(VoipSecondTimePermissionDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "dialog_deny_request_permission");
        }
        this$0.dismissAllowingStateLoss();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28081m.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28081m;
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
        final boolean z7;
        int i8;
        Intrinsics.f(container, "container");
        ItemViewFactory itemViewFactory = ItemViewFactory.f35921a;
        ItemViewFactory.g(itemViewFactory, N(), R.drawable.ic_microphone, null, 4, null);
        ViewGroup N = N();
        String string = getResources().getString(R.string.voip_permission_record_audio_second_time_dialog_title);
        Intrinsics.e(string, "resources.getString(R.st…second_time_dialog_title)");
        Rect rect = new Rect();
        rect.top = Dimens.d(16);
        Unit unit = Unit.f50853a;
        itemViewFactory.o(N, string, rect);
        ViewGroup N2 = N();
        String string2 = getResources().getString(R.string.voip_permission_record_audio_second_time_dialog_description);
        Intrinsics.e(string2, "resources.getString(R.st…_time_dialog_description)");
        Rect rect2 = new Rect();
        rect2.top = Dimens.d(16);
        itemViewFactory.h(N2, string2, rect2);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z7 = arguments.getBoolean("args.leads_to_settings", false);
        } else {
            z7 = false;
        }
        ViewGroup N3 = N();
        Resources resources = getResources();
        if (z7) {
            i8 = R.string.voip_permission_record_audio_second_time_dialog_button_go_to_settings;
        } else {
            i8 = R.string.voip_permission_record_audio_second_time_dialog_button_allow;
        }
        String string3 = resources.getString(i8);
        Intrinsics.e(string3, "resources.getString(\n   …  }\n                    )");
        ItemViewFactory.d(itemViewFactory, N3, string3, null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: e3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoipSecondTimePermissionDialog.R(z7, this, view);
            }
        });
        ViewGroup N4 = N();
        String string4 = getResources().getString(R.string.voip_permission_record_audio_second_time_dialog_cancel);
        Intrinsics.e(string4, "resources.getString(R.st…econd_time_dialog_cancel)");
        ItemViewFactory.l(itemViewFactory, N4, string4, null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: e3.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoipSecondTimePermissionDialog.S(VoipSecondTimePermissionDialog.this, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
