package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class EndIconDelegate {

    /* renamed from: a  reason: collision with root package name */
    final TextInputLayout f14351a;

    /* renamed from: b  reason: collision with root package name */
    final EndCompoundLayout f14352b;

    /* renamed from: c  reason: collision with root package name */
    final Context f14353c;

    /* renamed from: d  reason: collision with root package name */
    final CheckableImageButton f14354d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        this.f14351a = endCompoundLayout.f14323f;
        this.f14352b = endCompoundLayout;
        this.f14353c = endCompoundLayout.getContext();
        this.f14354d = endCompoundLayout.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Editable editable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(CharSequence charSequence, int i8, int i9, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i8) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(EditText editText) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z7) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() {
        this.f14352b.K(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
    }
}
