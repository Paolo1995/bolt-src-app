package ee.mtakso.driver.ui.screens.dialogs;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullScreenDialogFragment.kt */
/* loaded from: classes3.dex */
public abstract class FullScreenDialogFragment extends RestoreableDialogFragment {

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f28298k = new LinkedHashMap();

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f28298k.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        onCreateDialog.requestWindowFeature(1);
        onCreateDialog.setContentView(relativeLayout);
        Window window = onCreateDialog.getWindow();
        Intrinsics.c(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        Window window2 = onCreateDialog.getWindow();
        Intrinsics.c(window2);
        window2.setLayout(-1, -1);
        return onCreateDialog;
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.f(manager, "manager");
        FragmentTransaction beginTransaction = manager.beginTransaction();
        Intrinsics.e(beginTransaction, "manager.beginTransaction()");
        beginTransaction.add(this, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
