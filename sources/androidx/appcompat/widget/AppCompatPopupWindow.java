package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.widget.PopupWindowCompat;

/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f1874b = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1875a;

    public AppCompatPopupWindow(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        a(context, attributeSet, i8, i9);
    }

    private void a(Context context, AttributeSet attributeSet, int i8, int i9) {
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, R$styleable.Y1, i8, i9);
        int i10 = R$styleable.f959a2;
        if (v7.s(i10)) {
            b(v7.a(i10, false));
        }
        setBackgroundDrawable(v7.g(R$styleable.Z1));
        v7.w();
    }

    private void b(boolean z7) {
        if (f1874b) {
            this.f1875a = z7;
        } else {
            PopupWindowCompat.a(this, z7);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i8, int i9) {
        if (f1874b && this.f1875a) {
            i9 -= view.getHeight();
        }
        super.showAsDropDown(view, i8, i9);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i8, int i9, int i10, int i11) {
        if (f1874b && this.f1875a) {
            i9 -= view.getHeight();
        }
        super.update(view, i8, i9, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i8, int i9, int i10) {
        if (f1874b && this.f1875a) {
            i9 -= view.getHeight();
        }
        super.showAsDropDown(view, i8, i9, i10);
    }
}
