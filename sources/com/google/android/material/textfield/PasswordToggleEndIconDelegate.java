package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PasswordToggleEndIconDelegate extends EndIconDelegate {

    /* renamed from: e  reason: collision with root package name */
    private int f14398e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f14399f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f14400g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PasswordToggleEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout, int i8) {
        super(endCompoundLayout);
        this.f14398e = R$drawable.design_password_eye;
        this.f14400g = new View.OnClickListener() { // from class: com.google.android.material.textfield.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordToggleEndIconDelegate.this.y(view);
            }
        };
        if (i8 != 0) {
            this.f14398e = i8;
        }
    }

    private boolean w() {
        EditText editText = this.f14399f;
        if (editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return true;
        }
        return false;
    }

    private static boolean x(EditText editText) {
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f14399f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (w()) {
            this.f14399f.setTransformationMethod(null);
        } else {
            this.f14399f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f14399f.setSelection(selectionEnd);
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void b(CharSequence charSequence, int i8, int i9, int i10) {
        r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public int c() {
        return R$string.password_toggle_content_description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public int d() {
        return this.f14398e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnClickListener f() {
        return this.f14400g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean l() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean m() {
        return !w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void n(EditText editText) {
        this.f14399f = editText;
        r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void s() {
        if (x(this.f14399f)) {
            this.f14399f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void u() {
        EditText editText = this.f14399f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
