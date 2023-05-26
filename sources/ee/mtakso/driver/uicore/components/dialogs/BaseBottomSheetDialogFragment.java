package ee.mtakso.driver.uicore.components.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import ee.mtakso.driver.uicore.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBottomSheetDialogFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: i  reason: collision with root package name */
    private static final Companion f34739i = new Companion(null);
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    private static final int f34740j = Dimens.d(460);

    /* renamed from: g  reason: collision with root package name */
    private final boolean f34741g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f34742h = new LinkedHashMap();

    /* compiled from: BaseBottomSheetDialogFragment.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void H() {
        this.f34742h.clear();
    }

    protected boolean I() {
        return this.f34741g;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        if (I() && (window = onCreateDialog.getWindow()) != null) {
            window.addFlags(4194304);
            window.addFlags(524288);
            window.addFlags(2097152);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Dialog dialog;
        Window window;
        super.onResume();
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        if (ContextUtils.b(requireContext) && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
            window.setLayout(f34740j, -1);
        }
    }
}
