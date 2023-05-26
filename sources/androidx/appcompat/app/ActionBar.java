package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;

/* loaded from: classes.dex */
public abstract class ActionBar {

    /* loaded from: classes.dex */
    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z7);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class Tab {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public void i(boolean z7) {
    }

    public abstract int j();

    public Context k() {
        return null;
    }

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
    }

    public boolean o(int i8, KeyEvent keyEvent) {
        return false;
    }

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public void r(boolean z7) {
    }

    public abstract void s(boolean z7);

    public abstract void t(boolean z7);

    public void u(boolean z7) {
    }

    public abstract void v(int i8);

    public abstract void w(CharSequence charSequence);

    public void x(CharSequence charSequence) {
    }

    public ActionMode y(ActionMode.Callback callback) {
        return null;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f1086a;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1086a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1051t);
            this.f1086a = obtainStyledAttributes.getInt(R$styleable.f1056u, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f1086a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f1086a = 0;
            this.f1086a = layoutParams.f1086a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1086a = 0;
        }
    }
}
