package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: f  reason: collision with root package name */
    private final Chip f14482f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout f14483g;

    /* renamed from: h  reason: collision with root package name */
    private final EditText f14484h;

    /* renamed from: i  reason: collision with root package name */
    private TextWatcher f14485i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f14486j;

    /* loaded from: classes.dex */
    private class TextFormatter extends TextWatcherAdapter {
        private TextFormatter() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable)) {
                String c8 = ChipTextInputComboView.this.c(editable);
                Chip chip = ChipTextInputComboView.this.f14482f;
                if (TextUtils.isEmpty(c8)) {
                    c8 = ChipTextInputComboView.this.c("00");
                }
                chip.setText(c8);
                return;
            }
            ChipTextInputComboView.this.f14482f.setText(ChipTextInputComboView.this.c("00"));
        }
    }

    public ChipTextInputComboView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void d() {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.f14484h.setImeHintLocales(locales);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f14482f.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        int i8;
        this.f14482f.setChecked(z7);
        EditText editText = this.f14484h;
        int i9 = 0;
        if (z7) {
            i8 = 0;
        } else {
            i8 = 4;
        }
        editText.setVisibility(i8);
        Chip chip = this.f14482f;
        if (z7) {
            i9 = 8;
        }
        chip.setVisibility(i9);
        if (isChecked()) {
            ViewUtils.k(this.f14484h);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f14482f.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i8, Object obj) {
        this.f14482f.setTag(i8, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f14482f.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.f14482f = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.f14483g = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f14484h = editText;
        editText.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter();
        this.f14485i = textFormatter;
        editText.addTextChangedListener(textFormatter);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f14486j = (TextView) findViewById(R$id.material_label);
        editText.setId(ViewCompat.m());
        ViewCompat.F0(this.f14486j, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
