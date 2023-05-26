package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: f  reason: collision with root package name */
    private int f13690f;

    public final void b(int i8, boolean z7) {
        super.setVisibility(i8);
        if (z7) {
            this.f13690f = i8;
        }
    }

    public final int getUserSetVisibility() {
        return this.f13690f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i8) {
        b(i8, true);
    }
}
