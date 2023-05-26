package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {

    /* renamed from: f  reason: collision with root package name */
    private boolean f13062f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        private BottomSheetDismissCallback() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void b(@NonNull View view, float f8) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void c(@NonNull View view, int i8) {
            if (i8 == 5) {
                BottomSheetDialogFragment.this.E();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.f13062f) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void F(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z7) {
        this.f13062f = z7;
        if (bottomSheetBehavior.p0() == 5) {
            E();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) getDialog()).p();
        }
        bottomSheetBehavior.Y(new BottomSheetDismissCallback());
        bottomSheetBehavior.Q0(5);
    }

    private boolean G(boolean z7) {
        Dialog dialog = getDialog();
        if (dialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            BottomSheetBehavior<FrameLayout> n8 = bottomSheetDialog.n();
            if (n8.u0() && bottomSheetDialog.o()) {
                F(n8, z7);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (!G(false)) {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (!G(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
