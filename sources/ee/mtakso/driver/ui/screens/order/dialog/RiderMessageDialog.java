package ee.mtakso.driver.ui.screens.order.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.dialog.RiderMessageDialog;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uikit.dialog.ItemViewFactory;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RiderMessageDialog.kt */
/* loaded from: classes3.dex */
public final class RiderMessageDialog extends BaseDialogFragment {

    /* renamed from: n  reason: collision with root package name */
    public static final Companion f31286n = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    public Map<Integer, View> f31287m = new LinkedHashMap();

    /* compiled from: RiderMessageDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RiderMessageDialog a(String message, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
            Intrinsics.f(message, "message");
            Bundle bundle = new Bundle();
            bundle.putString("message", message);
            RiderMessageDialog riderMessageDialog = new RiderMessageDialog();
            riderMessageDialog.setArguments(bundle);
            riderMessageDialog.K(function3);
            return riderMessageDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(RiderMessageDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, view, "link");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(RiderMessageDialog this$0, RoundButton this_apply, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(this_apply, "$this_apply");
        Function3<DialogFragment, View, Object, Unit> G = this$0.G();
        if (G != null) {
            G.l(this$0, this_apply, "ok");
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f31287m.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment
    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31287m;
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
        String string = requireContext().getString(R.string.new_message_from_passenger);
        Intrinsics.e(string, "requireContext().getStri…w_message_from_passenger)");
        ItemViewFactory.i(itemViewFactory, container, string, null, 4, null).setTextSize(18.0f);
        String string2 = requireArguments().getString("message", "");
        ItemViewFactory.p(itemViewFactory, container, "“" + string2 + "”", null, 4, null);
        String string3 = requireContext().getString(R.string.see_translation);
        Intrinsics.e(string3, "requireContext().getStri…R.string.see_translation)");
        ItemViewFactory.n(itemViewFactory, container, string3, null, 4, null).setOnClickListener(new View.OnClickListener() { // from class: s4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RiderMessageDialog.R(RiderMessageDialog.this, view);
            }
        });
        String string4 = requireContext().getString(R.string.ok_lowercase);
        Intrinsics.e(string4, "requireContext().getString(R.string.ok_lowercase)");
        final RoundButton l8 = ItemViewFactory.l(itemViewFactory, container, string4, null, 4, null);
        l8.setOnClickListener(new View.OnClickListener() { // from class: s4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RiderMessageDialog.S(RiderMessageDialog.this, l8, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment, ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }
}
