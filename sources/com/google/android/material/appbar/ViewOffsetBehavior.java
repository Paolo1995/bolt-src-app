package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private ViewOffsetHelper f12841a;

    /* renamed from: b  reason: collision with root package name */
    private int f12842b;

    /* renamed from: c  reason: collision with root package name */
    private int f12843c;

    public ViewOffsetBehavior() {
        this.f12842b = 0;
        this.f12843c = 0;
    }

    public int E() {
        ViewOffsetHelper viewOffsetHelper = this.f12841a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.c();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8) {
        coordinatorLayout.J(v7, i8);
    }

    public boolean G(int i8) {
        ViewOffsetHelper viewOffsetHelper = this.f12841a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.f(i8);
        }
        this.f12842b = i8;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8) {
        F(coordinatorLayout, v7, i8);
        if (this.f12841a == null) {
            this.f12841a = new ViewOffsetHelper(v7);
        }
        this.f12841a.d();
        this.f12841a.a();
        int i9 = this.f12842b;
        if (i9 != 0) {
            this.f12841a.f(i9);
            this.f12842b = 0;
        }
        int i10 = this.f12843c;
        if (i10 != 0) {
            this.f12841a.e(i10);
            this.f12843c = 0;
            return true;
        }
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12842b = 0;
        this.f12843c = 0;
    }
}
