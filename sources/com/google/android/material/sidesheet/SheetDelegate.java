package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class SheetDelegate {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float a(int i8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b(@NonNull View view, float f8, float f9);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <V extends View> int e(@NonNull V v7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean g(View view, int i8, boolean z7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void h(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i8, int i9);
}
