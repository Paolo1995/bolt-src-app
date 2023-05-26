package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;

/* loaded from: classes.dex */
final class RightSheetDelegate extends SheetDelegate {

    /* renamed from: a  reason: collision with root package name */
    final SideSheetBehavior<? extends View> f14098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RightSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f14098a = sideSheetBehavior;
    }

    private boolean i(@NonNull View view) {
        if (view.getLeft() > (d() - c()) / 2) {
            return true;
        }
        return false;
    }

    private boolean j(float f8, float f9) {
        if (SheetUtils.a(f8, f9) && f9 > this.f14098a.e0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public float a(int i8) {
        float d8 = d();
        return (d8 - i8) / (d8 - c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int b(@NonNull View view, float f8, float f9) {
        if (f8 >= 0.0f) {
            if (k(view, f8)) {
                if (j(f8, f9) || i(view)) {
                    return 5;
                }
            } else if (f8 != 0.0f && SheetUtils.a(f8, f9)) {
                return 5;
            } else {
                int left = view.getLeft();
                if (Math.abs(left - c()) >= Math.abs(left - d())) {
                    return 5;
                }
            }
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int c() {
        return Math.max(0, d() - this.f14098a.W());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int d() {
        return this.f14098a.d0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public <V extends View> int e(@NonNull V v7) {
        return v7.getLeft();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int f() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public boolean g(View view, int i8, boolean z7) {
        int c02 = this.f14098a.c0(i8);
        ViewDragHelper f02 = this.f14098a.f0();
        if (f02 != null && (!z7 ? f02.O(view, c02, view.getTop()) : f02.M(c02, view.getTop()))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.SheetDelegate
    public void h(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i8, int i9) {
        int d02 = this.f14098a.d0();
        if (i8 <= d02) {
            marginLayoutParams.rightMargin = d02 - i8;
        }
    }

    boolean k(@NonNull View view, float f8) {
        if (Math.abs(view.getRight() + (f8 * this.f14098a.a0())) > this.f14098a.b0()) {
            return true;
        }
        return false;
    }
}
