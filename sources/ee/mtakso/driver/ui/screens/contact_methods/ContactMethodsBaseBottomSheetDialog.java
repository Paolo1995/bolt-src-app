package ee.mtakso.driver.ui.screens.contact_methods;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.DismissableDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactMethodsBaseBottomSheetDialog.kt */
/* loaded from: classes3.dex */
public abstract class ContactMethodsBaseBottomSheetDialog<T extends BaseViewModel> extends BaseMvvmBottomSheetDialogFragment<T> implements DismissableDialog {

    /* renamed from: r  reason: collision with root package name */
    private DialogInterface.OnDismissListener f27755r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f27756s;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f27758u = new LinkedHashMap();

    /* renamed from: t  reason: collision with root package name */
    private final boolean f27757t = true;

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f27758u.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    protected boolean I() {
        return this.f27757t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y(Function0<Unit> changes) {
        ViewGroup viewGroup;
        Intrinsics.f(changes, "changes");
        ViewGroup viewGroup2 = this.f27756s;
        if (viewGroup2 != null) {
            ViewParent parent = viewGroup2.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.c0(getResources().getInteger(17694720));
                changeBounds.c(viewGroup2);
                TransitionManager.b(viewGroup, changeBounds);
            }
        }
        changes.invoke();
        ViewGroup viewGroup3 = this.f27756s;
        if (viewGroup3 != null) {
            TransitionManager.c(viewGroup3);
        }
    }

    protected boolean Z() {
        return false;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(Z());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f27755r = null;
        this.f27756s = null;
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        super.onDismiss(dialog);
        DialogInterface.OnDismissListener onDismissListener = this.f27755r;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ViewGroup viewGroup = (ViewGroup) requireDialog().findViewById(R.id.design_bottom_sheet);
        this.f27756s = viewGroup;
        if (viewGroup != null) {
            BottomSheetBehavior.k0(viewGroup).Q0(3);
        }
    }

    @Override // ee.mtakso.driver.ui.screens.contact_methods.voip.DismissableDialog
    public void z(DialogInterface.OnDismissListener onDismissListener) {
        Intrinsics.f(onDismissListener, "onDismissListener");
        this.f27755r = onDismissListener;
    }
}
